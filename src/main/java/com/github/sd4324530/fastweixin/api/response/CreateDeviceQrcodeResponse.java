package com.github.sd4324530.fastweixin.api.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.sd4324530.fastweixin.api.entity.BaseModel;

public class CreateDeviceQrcodeResponse extends BaseResponse {
	private static final long serialVersionUID = 6427170264137300804L;
	@JSONField(name = "base_resp")
	private DeviceQrcodeRspMsg deviceQrcodeRspMsg;
	@JSONField(name = "device_id")
	private String deviceId;
	@JSONField(name = "qrticket")
	private String qrTicket;
	@JSONField(name = "devicelicence")
	private String deviceLicence;
	
	private String thirdDefineData;
	
	
	public DeviceQrcodeRspMsg getDeviceQrcodeRspMsg() {
		return deviceQrcodeRspMsg;
	}
	public void setDeviceQrcodeRspMsg(DeviceQrcodeRspMsg deviceQrcodeRspMsg) {
		this.deviceQrcodeRspMsg = deviceQrcodeRspMsg;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getQrTicket() {
		return qrTicket;
	}
	public void setQrTicket(String qrTicket) {
		this.qrTicket = qrTicket;
	}
	public String getDeviceLicence() {
		return deviceLicence;
	}
	public void setDeviceLicence(String deviceLicence) {
		this.deviceLicence = deviceLicence;
	}
	public String getThirdDefineData() {
		return thirdDefineData;
	}
	public void setThirdDefineData(String thirdDefineData) {
		this.thirdDefineData = thirdDefineData;
	}
	
	public static class DeviceQrcodeRspMsg extends BaseModel {
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

}
