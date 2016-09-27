package com.github.sd4324530.fastweixin.api.response;

import com.alibaba.fastjson.annotation.JSONField;

public class GetDeviceStatusResponse extends BaseResponse {
	private static final long serialVersionUID = 2331913507258193328L;
	@JSONField(name = "status")
	private int status;
	@JSONField(name = "status_info")
	private String statusInfo;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusInfo() {
		return statusInfo;
	}
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public DeviceStatus getDeviceStatus() {
		for (DeviceStatus deviceStatus : DeviceStatus.values()) {
			if (deviceStatus.code == status)
				return deviceStatus;
		}
		return null;
	}


	public enum DeviceStatus {
		AUTH(0, "未授权"), UNAUTH(1, "已经授权（尚未被用户绑定）"), BIND(2, "已经被用户绑定 "), UNSET(4,"属性未设置");
		
		private int    code;
		private String info;
		
		private DeviceStatus(int code, String info) {
			this.code = code;
			this.info = info;
		}

		public int getCode() {
			return code;
		}

		public String getInfo() {
			return info;
		}
		
	}
}
