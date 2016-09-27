package com.github.sd4324530.fastweixin.message.req;

public final class DeviceTextReqMsg extends BaseReqMsg {
	private String deviceType;
	private String deviceID;
	private String openId;
	private String sessionId;
    private String content;

    public DeviceTextReqMsg() {
        super();
        setMsgType(ReqType.DEVICE_TEXT);
    }


    public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	@Override
    public String toString() {
        return "DeviceTextReqMsg [content=" + content + ", toUserName=" + toUserName
        		+ ", deviceType=" + deviceType+ ", deviceID=" + deviceID
        		+ ", openId=" + openId+ ", sessionId=" + sessionId
                + ", fromUserName=" + fromUserName + ", createTime="
                + createTime + ", msgType=" + msgType + ", msgId=" + msgId
                + "]";
    }

}
