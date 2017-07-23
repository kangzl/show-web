package com.kingfish.show.bean;

import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 评论消息
 */
public class MsgVO implements Comparable {

    private long msgId;
    private String createTime;
    private String content;
    private int agreeNum;
    private long fromUserId;
    private String fromUserName;
    private String fromUserHeaderPic;
    private long toUserId;
    private String toUserName;
    private String toUserHeaderPic;
    private List<MsgVO> replyMsgs;


    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(int agreeNum) {
        this.agreeNum = agreeNum;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getFromUserHeaderPic() {
        return fromUserHeaderPic;
    }

    public void setFromUserHeaderPic(String fromUserHeaderPic) {
        this.fromUserHeaderPic = fromUserHeaderPic;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getToUserHeaderPic() {
        return toUserHeaderPic;
    }

    public void setToUserHeaderPic(String toUserHeaderPic) {
        this.toUserHeaderPic = toUserHeaderPic;
    }

    public List<MsgVO> getReplyMsgs() {
        return replyMsgs;
    }

    public void setReplyMsgs(List<MsgVO> replyMsgs) {
        this.replyMsgs = replyMsgs;
    }

    @Override
    public int compareTo(Object o) {
        MsgVO another = (MsgVO) o;
        if (StringUtils.isEmpty(this.createTime) || StringUtils.isEmpty(another.createTime))
            return 0;
        return another.createTime.compareTo(this.createTime);
    }
}
