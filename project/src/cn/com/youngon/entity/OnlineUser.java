package cn.com.youngon.entity;

import cn.com.youngon.util.Session;

public class OnlineUser extends Users{
	
	protected String entertime;
	protected String reason;
	
	public OnlineUser(String entertime, String reason,String head,String name,long stuid) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.head = Session.baseHeadUrl + head;
		this.entertime = entertime;
		this.reason = reason;
	}

	public String getEntertime() {
		return entertime;
	}

	public void setEntertime(String entertime) {
		this.entertime = entertime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}                     
}