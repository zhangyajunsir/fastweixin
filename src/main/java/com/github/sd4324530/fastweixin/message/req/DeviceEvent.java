package com.github.sd4324530.fastweixin.message.req;

public final class DeviceEvent extends BaseEvent {
	private String msgId;
	private String deviceType;
	private String deviceID;
	private String content;
	private String openId;
	private String sessionId;
	private String qrcodeSuffixData;

    public DeviceEvent() {
        super();
        setMsgType(ReqType.DEVICE_EVENT);
    }

	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getQrcodeSuffixData() {
		return qrcodeSuffixData;
	}
	public void setQrcodeSuffixData(String qrcodeSuffixData) {
		this.qrcodeSuffixData = qrcodeSuffixData;
	}

	@Override
    public String toString() {
        return "DeviceEvent [deviceType=" + deviceType + ", deviceID=" + deviceID + ", msgId=" + msgId 
        		+ ", openId=" + openId + ", sessionId=" + sessionId + ", qrcodeSuffixData=" + qrcodeSuffixData 
        		+ ", content=" + content + ", toUserName=" + toUserName
                + ", fromUserName=" + fromUserName + ", createTime="
                + createTime + ", msgType=" + msgType + "]";
    }
}
