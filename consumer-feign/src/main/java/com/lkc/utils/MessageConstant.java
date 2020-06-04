package com.lkc.utils;

public class MessageConstant {

	//发送验证码的请求路径URL
    public static final String
            SERVER_URL="https://api.netease.im/sms/sendcode.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    public static final String
            APP_KEY="59fd0967aa1260b614c3e96bf83c4743";
    //设置头部信息编码 
    public static final String
    		CONTENT_TYPE="application/x-www-form-urlencoded;charset=utf-8";
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    public static final String APP_SECRET="1b2c3e398b03";
    //短信模板ID
    public static final String TEMPLATEID="14876163";
    //验证码长度，范围4～10，默认为4
    public static final String CODELEN="6";
    
    
    // 校验验证码路径URL
    public static final String VERIFY_URL ="https://api.netease.im/sms/verifycode.action";
    
	
}
