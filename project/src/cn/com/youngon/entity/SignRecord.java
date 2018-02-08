package cn.com.youngon.entity;

public class SignRecord {
	
	private int id;
	private String entertime;
	private long stuid;
	private String name;
	private String reason;
	private String outtertime;
	private String head;

	public SignRecord(int id, String entertime, long stuid, String name, String reason,String head,String outtertime) {
		super();
		this.id = id;
		this.entertime = entertime;
		this.stuid = stuid;
		this.name = name;
		this.reason = reason;
		this.outtertime = outtertime;
		
	}
	public SignRecord(String entertime, long stuid, String name, String reason, String head, String outtertime) {
		super();		
		this.entertime = entertime;
		this.stuid = stuid;
		this.name = name;
		this.reason = reason;
		this.head =head;
		this.outtertime = outtertime;
	}	
	
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEntertime() {
		return entertime;
	}

	public void setEntertime(String entertime) {
		this.entertime = entertime;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOuttertime() {
		return outtertime;
	}

	public void setOuttertime(String outtertime) {
		this.outtertime = outtertime;
	}

}
