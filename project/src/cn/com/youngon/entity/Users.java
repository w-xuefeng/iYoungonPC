package cn.com.youngon.entity;

import com.alibaba.fastjson.JSONObject;

public class Users {
	protected int id;
	protected long stuid;
	protected String password;
	protected String name;
	protected int sex;
	protected String head;
	protected String birthday;
	protected String college;
	protected String majorclass;
	protected String department;
	protected String qq;
	protected String phone;
	protected String email;
	protected int utype;
	protected String loginip;
	protected boolean ifkey;
	protected boolean online;
	protected String token;
	protected String xgtoken;
	protected JSONObject duty;
	protected int ulevel;
	protected long sigincount;
	protected String registerdate;
	protected String dToken;

	public Users() {
		super();
	}
	
	public Users(String dToken) {
		super();
		this.dToken = dToken;
	}

	public Users(long stuid, String name, int sex, String head, String birthday, String college,
			String majorclass, String department, String qq, String phone, String email, int utype, boolean ifkey,
			boolean online, String token, JSONObject duty, int ulevel, long sigincount, String registerdate) {
		super();		
		this.stuid = stuid;
		this.name = name;
		this.sex = sex;
		this.head = head;
		this.birthday = birthday;
		this.college = college;
		this.majorclass = majorclass;
		this.department = department;
		this.qq = qq;
		this.phone = phone;
		this.email = email;
		this.utype = utype;
		this.ifkey = ifkey;
		this.online = online;
		this.token = token;
		this.duty = duty;
		this.ulevel = ulevel;
		this.sigincount = sigincount;
		this.registerdate = registerdate;
	}

	public Users(long stuid, String password, String name, String email, int utype) {
		super();		
		this.stuid = stuid;
		this.password = password;
		this.name = name;
		this.email = email;
		this.utype = utype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajorclass() {
		return majorclass;
	}

	public void setMajorclass(String majorclass) {
		this.majorclass = majorclass;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUtype() {
		return utype;
	}

	public void setUtype(int utype) {
		this.utype = utype;
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public boolean isIfkey() {
		return ifkey;
	}

	public void setIfkey(boolean ifkey) {
		this.ifkey = ifkey;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getXgtoken() {
		return xgtoken;
	}

	public void setXgtoken(String xgtoken) {
		this.xgtoken = xgtoken;
	}

	public JSONObject getDuty() {
		return duty;
	}

	public void setDuty(JSONObject duty) {
		this.duty = duty;
	}

	public int getUlevel() {
		return ulevel;
	}

	public void setUlevel(int ulevel) {
		this.ulevel = ulevel;
	}

	public long getSigincount() {
		return sigincount;
	}

	public void setSigincount(long sigincount) {
		this.sigincount = sigincount;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getdToken() {
		return dToken;
	}

	public void setdToken(String dToken) {
		this.dToken = dToken;
	}
	
}
