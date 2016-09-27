package com.github.sd4324530.fastweixin.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.github.sd4324530.fastweixin.message.util.MessageBuilder;

public class BaseMsg implements Serializable{
	private static final long serialVersionUID = -2977152695041828121L;
	
	private String toUserName;
    private String fromUserName;
    private long   createTime;
    private String msgType;

    public BaseMsg() {
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String toXml() {
        // 159 = 106 + 28(ToUserName) + 15(FromUserName) + 10(CreateTime)
        MessageBuilder builder = new MessageBuilder(159);
        builder.addData("ToUserName", getToUserName());
        builder.addData("FromUserName", getFromUserName());
        builder.addTag("CreateTime", String.valueOf(System.currentTimeMillis())
                .substring(0, 10));
        return builder.toString();
    }

    @Override
    public String toString() {
        return toXml();
    }
    
    public String toJson() {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("to_user_name", getToUserName());
    	map.put("from_user_name", getFromUserName());
    	map.put("creat_time", String.valueOf(System.currentTimeMillis()).substring(0, 10));
    	return JSON.toJSONString(map);
    }
}
