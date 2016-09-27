package com.github.sd4324530.fastweixin.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class DeviceAuthInfo extends BaseModel {
	private static final long serialVersionUID = 8096960497765161038L;
	//设备的deviceid
	@JSONField(name = "id")
	private String  deviceid;
	//设备的mac地址 格式采用16进制串的方式（长度为12字节），不需要0X前缀
	private String  mac;
	//支持以下四种连接协议： android classic bluetooth – 1  ios classic bluetooth – 2  ble – 3  wifi – 4 
	@JSONField(name = "connect_protocol")
	private Integer connectProtocol;
	//auth加密方法，目前支持两种取值：0：不加密 1：AES加密（CBC模式，PKCS7填充方式）
	@JSONField(name = "crypt_method")
	private Integer cryptMethod;
	//auth及通信的加密key，第三方需要将key烧制在设备上（128bit），格式采用16进制串的方式（长度为32字节），不需要0X前缀
	@JSONField(name = "auth_key")
	private String  authKey;
	//（wifi无效）auth version，设备和微信进行auth时，会根据该版本号来确认auth buf和auth key的格式（各version对应的auth buf及key的具体格式可以参看“客户端蓝牙外设协议”），该字段目前支持取值： 0：不加密的version 1：version 1
	@JSONField(name = "auth_ver")
	private Integer authVer;
	//（wifi无效）断开策略，目前支持： 1：退出公众号页面时即断开连接 2：退出公众号之后保持连接不断开
	@JSONField(name = "close_strategy")
	private Integer closeStrategy;
	//（wifi无效）连接策略，32位整型，按bit位置位，目前仅第1bit和第3bit位有效（bit置0为无效，1为有效；第2bit已被废弃），且bit位可以按或置位（如1|4=5），各bit置位含义说明如下： 
	//1：（第1bit置位）在公众号对话页面，不停的尝试连接设备 
	//4：（第3bit置位）处于非公众号页面（如主界面等），微信自动连接。当用户切换微信到前台时，可能尝试去连接设备，连上后一定时间会断开
	@JSONField(name = "conn_strategy")
	private Integer connStrategy;
	//（wifi无效）表示mac地址在厂商广播manufature data里含有mac地址的偏移，取值如下： -1：在尾部、 -2：表示不包含mac地址 其他：非法偏移
	@JSONField(name = "manu_mac_pos")
	private Integer manuMacPos;
	//（wifi无效）表示mac地址在厂商serial number里含有mac地址的偏移，取值如下： -1：表示在尾部 -2：表示不包含mac地址 其他：非法偏移
	@JSONField(name = "serMacPos")
	private Integer ser_mac_pos;
	//（wifi无效）精简协议类型，取值如下：计步设备精简协议：1 （若该字段填1，connect_protocol 必须包括3。非精简协议设备切勿填写该字段）
	@JSONField(name = "ble_simple_protocol")
	private Integer bleSimpleProtocol;
	
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public Integer getConnectProtocol() {
		return connectProtocol;
	}
	public void setConnectProtocol(Integer connectProtocol) {
		this.connectProtocol = connectProtocol;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	public Integer getCryptMethod() {
		return cryptMethod;
	}
	public void setCryptMethod(Integer cryptMethod) {
		this.cryptMethod = cryptMethod;
	}
	public Integer getAuthVer() {
		return authVer;
	}
	public void setAuthVer(Integer authVer) {
		this.authVer = authVer;
	}
	public Integer getCloseStrategy() {
		return closeStrategy;
	}
	public void setCloseStrategy(Integer closeStrategy) {
		this.closeStrategy = closeStrategy;
	}
	public Integer getConnStrategy() {
		return connStrategy;
	}
	public void setConnStrategy(Integer connStrategy) {
		this.connStrategy = connStrategy;
	}
	public Integer getManuMacPos() {
		return manuMacPos;
	}
	public void setManuMacPos(Integer manuMacPos) {
		this.manuMacPos = manuMacPos;
	}
	public Integer getSer_mac_pos() {
		return ser_mac_pos;
	}
	public void setSer_mac_pos(Integer ser_mac_pos) {
		this.ser_mac_pos = ser_mac_pos;
	}
	public Integer getBleSimpleProtocol() {
		return bleSimpleProtocol;
	}
	public void setBleSimpleProtocol(Integer bleSimpleProtocol) {
		this.bleSimpleProtocol = bleSimpleProtocol;
	}

}
