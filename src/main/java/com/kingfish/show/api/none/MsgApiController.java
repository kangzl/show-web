package com.kingfish.show.api.none;

import com.kingfish.show.bean.BaseVO;
import com.kingfish.show.mybatis.dao.MsgMapper;
import com.kingfish.show.mybatis.model.Msg;
import com.kingfish.show.mybatis.model.MsgExample;
import com.kingfish.show.utils.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * msg相关的api
 * TODO:需要user中心,以及权限控制
 */
@RestController
public class MsgApiController {

    @Autowired
    private MsgMapper msgMapper;

    @RequestMapping("api/del-msg.htm")
    public void deleteMsg(ModelAndView mv, @RequestParam(value = "msgId") Long msgId) {
        if (msgId == null || LoginUtil.getLoginUserId(mv) == null) return;
        if (isMsgOwner(msgId, LoginUtil.getLoginUserId(mv))) {
            msgMapper.deleteByPrimaryKey(msgId);
            MsgExample msgExample = new MsgExample();
            MsgExample.Criteria criteria = msgExample.createCriteria();
            criteria.andParentMsgIdEqualTo(msgId);
            msgMapper.deleteByExample(msgExample);
        }
    }

    @RequestMapping("api/appreciate-msg.htm")
    public void appreciateMsg(ModelAndView mv, @RequestParam(value = "msgId") Long msgId) {
        if (msgId == null || LoginUtil.getLoginUserId(mv) == null) return;
        Msg msg = msgMapper.selectByPrimaryKey(msgId);
        if (msg == null) return;
        Integer agreeNum = msg.getAgreeNum();
        if (agreeNum == null) {
            agreeNum = 0;
        }
        Msg newMsg = new Msg();
        newMsg.setId(msg.getId());
        newMsg.setGmtModify(new Date());
        newMsg.setAgreeNum(agreeNum + 1);
        msgMapper.updateByPrimaryKeySelective(newMsg);

    }

    @RequestMapping("api/cancel-appreciate-msg.htm")
    public void cancelAppreciateMsg(ModelAndView mv, @RequestParam(value = "msgId") Long msgId) {
        if (msgId == null || LoginUtil.getLoginUserId(mv) == null) return;
        Msg msg = msgMapper.selectByPrimaryKey(msgId);
        if (msg == null) return;
        Integer agreeNum = msg.getAgreeNum();
        if (agreeNum == null || agreeNum < 1) {
            return;
        }
        Msg newMsg = new Msg();
        newMsg.setId(msg.getId());
        newMsg.setGmtModify(new Date());
        newMsg.setAgreeNum(agreeNum - 1);
        msgMapper.updateByPrimaryKeySelective(newMsg);
    }

    @RequestMapping("api/insert-msg.json")
    public BaseVO insertMsg(ModelAndView mv, @RequestParam(value = "fromUserId") Long fromUserId, @RequestParam(value = "toUserId") Long toUserId, @RequestParam(value = "msgId") Long parentMsgId, @RequestParam(value = "showId") Long showId, @RequestParam(value = "content") String content) {
        if (fromUserId == null || showId == null || LoginUtil.getLoginUserId(mv) == null) return null;
        Msg msg = new Msg();
        msg.setGmtCreate(new Date());
        msg.setGmtModify(new Date());
        msg.setContent(content);
        msg.setFromUserId(LoginUtil.getLoginUserId(mv));
        msg.setToUserId(toUserId);
        msg.setParentMsgId(parentMsgId);
        msg.setShowId(showId);
        msg.setAgreeNum(0);
        int count = msgMapper.insertSelective(msg);
        if (count == 1) {
            //return msg.getId();
            BaseVO baseVO = new BaseVO();
            baseVO.setSuccess(true);
            baseVO.setMessage(String.valueOf(msg.getId()));
            return baseVO;
        } else {
            return null;
        }
    }

    private boolean isMsgOwner(Long msgId, Long userId) {
        boolean result = false;
        if (msgId == null || userId == null) return false;
        MsgExample msgExample = new MsgExample();
        MsgExample.Criteria criteria = msgExample.createCriteria();
        criteria.andParentMsgIdEqualTo(msgId);
        criteria.andFromUserIdEqualTo(userId);
        long count = msgMapper.countByExample(msgExample);
        if (count == 1l) return true;
        return result;
    }
}