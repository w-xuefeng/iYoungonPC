package cn.com.youngon.entity;


public class CarryKeyUser{
	
	protected long stuid;
	protected String name;
	protected String head;
	protected String phone;
	
	public CarryKeyUser(long stuid, String name, String head, String phone) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.head = head;
		this.phone = phone;
	}

	public long getStuid() {
		return stuid;
	}

	public void setStuid(long stuid) {
		this.stuid = stuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
