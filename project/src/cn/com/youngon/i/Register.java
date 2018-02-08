package cn.com.youngon.i;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.com.youngon.entity.Users;
import cn.com.youngon.util.HttpRequest;
import cn.com.youngon.util.Session;

public class Register {
	public Users user;

	public Register(Users user) {
		super();
		this.user = user;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	public boolean register(){
  	    String restAPI = Session.baseAPIUrl + "/users";
  	    String account = "stuid=" + this.user.getStuid();
  	    String pass = "password=" + this.user.getPassword();
  	    String name = "name=" + this.user.getName();
  	    String email = "email=" + this.user.getEmail();
  		String utype = "utype=" + this.user.getUtype();
  		String val = account + "&" + pass + "&" + name + "&" + email + "&" + utype;
        String json = HttpRequest.sendPost(restAPI, val);
        JSONObject data = JSON.parseObject(json);        
        boolean res = data.getBoolean("status");
		return res;
	}

}
