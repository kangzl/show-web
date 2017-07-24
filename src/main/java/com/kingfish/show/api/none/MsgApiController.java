package com.kingfish.show.api.none;

import com.kingfish.show.mybatis.dao.MsgMapper;
import com.kingfish.show.mybatis.model.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public void deleteMsg(@RequestParam(value = "msgId") Long msgId) {
        if (msgId == null) return;
        msgMapper.deleteByPrimaryKey(msgId);
    }

    @RequestMapping("api/appreciate-msg.htm")
    public void appreciateMsg(@RequestParam(value = "msgId") Long msgId) {
        if (msgId == null) return;
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
    public void cancelAppreciateMsg(@RequestParam(value = "msgId") Long msgId) {
        if (msgId == null) return;
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
}
