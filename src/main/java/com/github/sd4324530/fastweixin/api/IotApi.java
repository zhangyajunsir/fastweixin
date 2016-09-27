package com.github.sd4324530.fastweixin.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.DeviceAuthInfo;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.BaseResponse;
import com.github.sd4324530.fastweixin.api.response.CreateDeviceQrcodeResponse;
import com.github.sd4324530.fastweixin.api.response.GetDeviceQrcodeResponse;
import com.github.sd4324530.fastweixin.api.response.GetDeviceStatusResponse;
import com.github.sd4324530.fastweixin.api.response.GetDeviceStatusResponse.DeviceStatus;
import com.github.sd4324530.fastweixin.api.response.GetUserDeviceResponse;
import com.github.sd4324530.fastweixin.util.BeanUtil;
import com.github.sd4324530.fastweixin.util.JSONUtil;

public class IotApi extends BaseAPI {
	private static final Logger LOG = LoggerFactory.getLogger(IotApi.class);

	protected IotApi(ApiConfig config) {
		super(config);
	}
	
	/**
	 * 获取新的设备编号和二维码信息（授权新接口）
	 * @param productId
	 * @return
	 */
	public CreateDeviceQrcodeResponse creatQrcode(String productId) {
		BeanUtil.requireNonNull(productId, "productId is null");
        LOG.debug("获取新的设备编号和二维码信息......");
        String url = BASE_API_URL + "device/getqrcode?access_token=#&product_id=" + productId;
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        LOG.debug("获取新的设备编号和二维码信息：{}", resultJson);
        CreateDeviceQrcodeResponse response = JSONUtil.toBean(resultJson, CreateDeviceQrcodeResponse.class);
        if (!isSuccess(response.getDeviceQrcodeRspMsg().getErrCode())) 
        	return null;
        return response;
	}
	
	/**
	 * 更新设备属性（授权新接口）
	 * @param deviceAuthInfo
	 * @return
	 */
	public ResultType authDevice(DeviceAuthInfo deviceAuthInfo) {
		List<DeviceAuthInfo> deviceAuthInfos = new ArrayList<DeviceAuthInfo>();
		deviceAuthInfos.add(deviceAuthInfo);
		return authDevice(deviceAuthInfos);
	}
	
	/**
	 * 批量更新设备属性（授权新接口）
	 * @param deviceAuthInfos
	 * @return
	 */
	public ResultType authDevice(List<DeviceAuthInfo> deviceAuthInfos) {
		BeanUtil.requireNonNull(deviceAuthInfos, "deviceAuthInfos is null");
		LOG.debug("更新设备属性.....");
		String url = BASE_API_URL + "device/authorize_device?access_token=#";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("device_num",  deviceAuthInfos.size());
		params.put("device_list", deviceAuthInfos);
		params.put("op_type",     1);
		BaseResponse response = executePost(url, JSONUtil.toJson(params));
		LOG.debug("更新设备属性结果：{}", isSuccess(response.getErrcode()) ? response.getErrmsg() : response.toJsonString());
		return ResultType.get(response.getErrcode());
	}
	
	/**
	 * 第三方公众账号通过设备id从公众平台批量获取设备二维码(获取设备二维码)
	 * @param deviceid
	 * @return
	 */
	public GetDeviceQrcodeResponse getQrcode(String... deviceId) {
		if (deviceId == null || deviceId.length == 0)
			return null;
		LOG.debug("获取设备二维码.....");
		String url = BASE_API_URL + "device/create_qrcode?access_token=#";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("device_num",     deviceId.length);
		params.put("device_id_list", deviceId);
		BaseResponse r = executePost(url, JSONUtil.toJson(params));
		String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
		LOG.debug("获取设备二维码结果：{}", resultJson);
		if (!isSuccess(r.getErrcode()))
			return null;
		GetDeviceQrcodeResponse response = JSONUtil.toBean(resultJson, GetDeviceQrcodeResponse.class);
		return response;
	}
	
	/**
	 * 手动绑定/解绑设备（设备绑定/解绑）
	 * @param isBind
	 * @param ticket
	 * @param deviceId
	 * @param openId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ResultType bindOrUnbindDevice(boolean isBind, String ticket, String deviceId, String openId) {
		BeanUtil.requireNonNull(ticket,   "ticket is null");
		BeanUtil.requireNonNull(deviceId, "deviceId is null");
		BeanUtil.requireNonNull(openId,   "openId is null");
		String action = isBind ? "bind" : "unbind";
		LOG.debug("手动{}设备.....", action);
		String url = BASE_API_URL + "device/"+action+"?access_token=#";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticket",     ticket);
		params.put("device_id",  deviceId);
		params.put("openid",     openId);
		BaseResponse r = executePost(url, JSONUtil.toJson(params));
		String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
		LOG.debug("手动{}设备结果：{}", action, resultJson);
		Map<String, Object> res = JSONUtil.toMap(resultJson);
		return ResultType.get(((Map<String,String>)res.get("base_resp")).get("errcode"));
	}
	
	/**
	 * 手动强制绑定/解绑设备（设备绑定/解绑）
	 * @param isBind
	 * @param deviceId
	 * @param openId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ResultType compelBindOrUnbindDevice(boolean isBind, String deviceId, String openId) {
		BeanUtil.requireNonNull(deviceId, "deviceId is null");
		BeanUtil.requireNonNull(openId,   "openId is null");
		String action = isBind ? "bind" : "unbind";
		LOG.debug("手动强制{}设备.....", action);
		String url = BASE_API_URL + "device/compel_"+action+"?access_token=#";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("device_id",  deviceId);
		params.put("openid",     openId);
		BaseResponse r = executePost(url, JSONUtil.toJson(params));
		String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
		LOG.debug("手动强制{}设备结果：{}", action, resultJson);
		Map<String, Object> res = JSONUtil.toMap(resultJson);
		return ResultType.get(((Map<String,String>)res.get("base_resp")).get("errcode"));
	}
	
	/**
	 * 设备状态查询
	 * @param deviceId
	 * @return
	 */
	public DeviceStatus getDeviceStatus(String deviceId) {
		BeanUtil.requireNonNull(deviceId, "deviceId is null");
		LOG.debug("获取设备状态信息......");
		String url = BASE_API_URL + "device/get_stat?access_token=#&device_id="+deviceId;
		BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        LOG.debug("获取设备状态信息：{}", resultJson);
        GetDeviceStatusResponse response = JSONUtil.toBean(resultJson, GetDeviceStatusResponse.class);
        if (!isSuccess(r.getErrcode()))
        	return null;
		return response.getDeviceStatus();
	}

	@SuppressWarnings("unchecked")
	public List<String> getDeviceUsers(String deviceType, String deviceId) {
		BeanUtil.requireNonNull(deviceType, "deviceType is null");
		BeanUtil.requireNonNull(deviceId,   "deviceId is null");
		LOG.debug("获取设备绑定openID......");
		String url = BASE_API_URL + "device/get_openid?access_token=#&device_type="+deviceType+"&device_id="+deviceId;
		BaseResponse r = executeGet(url);
		String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        LOG.debug("获取设备绑定openID信息：{}", resultJson);
        if (!isSuccess(r.getErrcode()))
        	return null;
		return (List<String>)JSONUtil.toMap(resultJson).get("open_id");
	}
	
	public GetUserDeviceResponse getUserDevices(String openId) {
		BeanUtil.requireNonNull(openId, "openId is null");
		LOG.debug("获取openID绑定的设备......");
		String url = BASE_API_URL + "device/get_openid?access_token=#&openid="+openId;
		BaseResponse r = executeGet(url);
		String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        LOG.debug("获取openID绑定的设备信息：{}", resultJson);
        GetUserDeviceResponse response = JSONUtil.toBean(resultJson, GetUserDeviceResponse.class);
        if (!isSuccess(response.getUserDevicesRspMsg().getErrCode()))
        	return null;
		return response;
	}
	
}
