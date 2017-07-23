package com.kingfish.show.api.json;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kingfish.show.bean.MsgVO;
import com.kingfish.show.mybatis.dao.MsgMapper;
import com.kingfish.show.mybatis.model.Msg;
import com.kingfish.show.mybatis.model.MsgExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * Created by kingfish on 2017/7/23.
 */
@RestController
public class GetMsgController {
    @Autowired
    private MsgMapper msgMapper;

    @RequestMapping("api/get-msgs.json")
    public List<MsgVO> getMsgs(@RequestParam(value = "showId") Long showId) {
        List<MsgVO> msgVOs = Lists.newArrayList();
        MsgExample msgExample = new MsgExample();
        MsgExample.Criteria criteria = msgExample.createCriteria();
        criteria.andShowIdEqualTo(showId);
        List<Msg> msgs = msgMapper.selectByExample(msgExample);

        Map<Msg, List<Msg>> msg2ReplyMsgList = groupMsg(msgs);
        for (Map.Entry<Msg, List<Msg>> entry : msg2ReplyMsgList.entrySet()) {
            Msg mainMsg = entry.getKey();
            MsgVO mainVo = makeVo(mainMsg);
            mainVo.setReplyMsgs(makeVoList(entry.getValue()));
            msgVOs.add(mainVo);
        }
        //sort msg
        sortMsg(msgVOs);
        return msgVOs;
    }

    /**
     * 主体留言,回复,都按时间降序排
     *
     * @param msgVOs
     */
    private void sortMsg(List<MsgVO> msgVOs) {
        if (CollectionUtils.isEmpty(msgVOs))
            return;
        for (MsgVO msgVO : msgVOs) {
            List<MsgVO> replyMsgs = msgVO.getReplyMsgs();
            if (!CollectionUtils.isEmpty(replyMsgs)) {
                Collections.sort(replyMsgs);
            }
        }
        Collections.sort(msgVOs);
    }

    private List<MsgVO> makeVoList(List<Msg> msgs) {
        if (msgs == null) {
            return null;
        }
        List<MsgVO> msgVOList = Lists.newArrayList();
        for (Msg msg : msgs) {
            msgVOList.add(makeVo(msg));
        }
        return msgVOList;
    }

    private MsgVO makeVo(Msg msg) {
        if (msg == null) {
            return null;
        }
        MsgVO msgVO = new MsgVO();
        //TODO:拷贝必要信息
        //TODO:查找用户id,头像,昵称等信息
        return msgVO;
    }

    private Map<Msg, List<Msg>> groupMsg(List<Msg> msgs) {
        Map<Msg, List<Msg>> result = Maps.newHashMap();
        return result;
    }
}
