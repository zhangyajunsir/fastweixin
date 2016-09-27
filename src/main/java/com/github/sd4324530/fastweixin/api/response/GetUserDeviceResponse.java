package com.github.sd4324530.fastweixin.api.response;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.sd4324530.fastweixin.api.entity.BaseModel;

public class GetUserDeviceResponse extends BaseResponse {
	private static final long serialVersionUID = -347856015006563503L;
	@JSONField(name = "base_resp")
	private UserDevicesRspMsg userDevicesRspMsg;
	@JSONField(name = "openid")
	private String openId;
	@JSONField(name = "device_list")
	private List<DeviceID> deviceIDs;
	
	public UserDevicesRspMsg getUserDevicesRspMsg() {
		return userDevicesRspMsg;
	}
	public void setUserDevicesRspMsg(UserDevicesRspMsg userDevicesRspMsg) {
		this.userDevicesRspMsg = userDevicesRspMsg;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public List<DeviceID> getDeviceIDs() {
		return deviceIDs;
	}
	public void setDeviceIDs(List<DeviceID> deviceIDs) {
		this.deviceIDs = deviceIDs;
	}

	public static class UserDevicesRspMsg extends BaseModel {
		private static final long serialVersionUID = 4683327831481748828L;
		@JSONField(name = "ret_code")
		private String errCode;
		@JSONField(name = "error_info")
		private String errMsg;
		
		public String getErrCode() {
			return errCode;
		}
		public void setErrCode(String errCode) {
			this.errCode = errCode;
		}
		public String getErrMsg() {
			return errMsg;
		}
		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}
	}
	
	public static class DeviceID extends BaseModel {
		private static final long serialVersionUID = 5318459247407202317L;
		@JSONField(name = "device_type")
		private String deviceType;
		@JSONField(name = "device_id")
		private String deviceId;
		
		public String getDeviceType() {
			return deviceType;
		}
		public void setDeviceType(String deviceType) {
			this.deviceType = deviceType;
		}
		public String getDeviceId() {
			return deviceId;
		}
		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}
	}
}
