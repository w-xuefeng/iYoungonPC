package cn.com.youngon.entity;

public class WeekDynamic {
	private int id;
	private int week;
	private String content;
	private String publishdate;
	private long publisherstuid;
	private String publisher;
	


	public WeekDynamic(int id, int week, String content, String publishdate, long publisherstuid, String publisher) {
		super();
		this.id = id;
		this.week = week;
		this.content = content;
		this.publishdate = publishdate;
		this.publisherstuid = publisherstuid;
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public long getPublisherstuid() {
		return publisherstuid;
	}

	public void setPublisherstuid(long publisherstuid) {
		this.publisherstuid = publisherstuid;
	}	

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}	
	
	
}
