package cn.com.youngon.i;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.com.youngon.util.HttpRequest;
import cn.com.youngon.util.Session;

public class Login {
	
	private long stuid;
	private String password;
	private boolean isLogined;
	
	public Login() {
		super();		
	}
	
	public Login(long stuid, String password, boolean isLogined) {
		super();
		this.stuid = stuid;
		this.password = password;
		this.isLogined = isLogined;
	}

	public long getStuid() {
		return stuid;
	}

	public void setStuid(long stuid) {
		this.stuid = stuid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogined() {
		return isLogined;
	}

	public void setLogined(boolean isLogined) {
		this.isLogined = isLogined;
	}
	
	public Object login() {
		Object users= null;
  	    String restAPI = Session.baseAPIUrl + "/session/post/stuid";
  	    String account = "stuid=" + this.stuid;
  	    String pass = "password=" + this.password;
  	    String val = account + "&" + pass;
        String json = HttpRequest.sendPost(restAPI, val);
        JSONObject data = JSON.parseObject(json);        
        boolean status = data.getBoolean("status");
        if(status){
        	JSONObject user = data.getJSONObject("infor");        	
        	users = Session.jsonToUser(user);
        	this.isLogined = true;
        }else{
        	this.isLogined = false;
        	String warnTitle = data.getString("title");
        	String warnMsg = data.getString("message");
        	Map<String, String> warn = new HashMap<>();
        	warn.put("warnTitle", warnTitle);
        	warn.put("warnMsg", warnMsg);
        	users = warn;
        }
		return users;
	}
}
