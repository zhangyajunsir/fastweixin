package com.github.sd4324530.fastweixin.api.response;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

public class GetDeviceQrcodeResponse extends BaseResponse {
	private static final long serialVersionUID = 6427170264137300804L;
	@JSONField(name = "device_num")
	private Integer deviceNum;
	@JSONField(name = "code_list")
	private List<Map<String,String>> codeList;
	
	public Integer getDeviceNum() {
		return deviceNum;
	}
	public void setDeviceNum(Integer deviceNum) {
		this.deviceNum = deviceNum;
	}
	public List<Map<String, String>> getCodeList() {
		return codeList;
	}
	public void setCodeList(List<Map<String, String>> codeList) {
		this.codeList = codeList;
	}

}
