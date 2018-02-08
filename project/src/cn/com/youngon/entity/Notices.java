package cn.com.youngon.entity;

public class Notices {
	private int nid;	
	private long opstuid;
	private String content;
	private String publishtime;
	private String publisher;
	


	public Notices(int nid, long opstuid, String content, String publishtime, String publisher) {
		super();
		this.nid = nid;
		this.opstuid = opstuid;
		this.content = content;
		this.publishtime = publishtime;
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public long getOpstuid() {
		return opstuid;
	}

	public void setOpstuid(long opstuid) {
		this.opstuid = opstuid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	
}
