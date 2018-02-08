package cn.com.youngon.entity;

public class ApplicationInfor {
	private int aid;
	private long applicantstuid;
	private String appdata;
	private String appreason;
	private String apptime;
	private int appclass;
	private String appfixtime;
	private int appfixclass;
	private int state;
	private String redate;
	private long handlerstuid;
	
	public ApplicationInfor(int aid, long applicantstuid, String appdata, String appreason, String apptime,
			int appclass, String appfixtime, int appfixclass, int state, String redate, long handlerstuid) {
		super();
		this.aid = aid;
		this.applicantstuid = applicantstuid;
		this.appdata = appdata;
		this.appreason = appreason;
		this.apptime = apptime;
		this.appclass = appclass;
		this.appfixtime = appfixtime;
		this.appfixclass = appfixclass;
		this.state = state;
		this.redate = redate;
		this.handlerstuid = handlerstuid;
	}

	public ApplicationInfor(int aid, long applicantstuid, String appdata, String appreason,int state, String redate, long handlerstuid) {
		super();
		this.aid = aid;
		this.applicantstuid = applicantstuid;
		this.appdata = appdata;
		this.appreason = appreason;
		this.apptime = "2017-01-01";
		this.appclass = 0;
		this.appfixtime = "2017-01-01";
		this.appfixclass = 0;
		this.state = state;
		this.redate = redate;
		this.handlerstuid = handlerstuid;
	}

	public ApplicationInfor(long applicantstuid, String appreason, String apptime, int appclass, String appfixtime,
			int appfixclass) {
		super();
		this.applicantstuid = applicantstuid;
		this.appreason = appreason;
		this.apptime = apptime;
		this.appclass = appclass;
		this.appfixtime = appfixtime;
		this.appfixclass = appfixclass;
	}

	public ApplicationInfor(long applicantstuid, String appreason) {
		super();
		this.applicantstuid = applicantstuid;
		this.appreason = appreason;
		this.apptime = "2017-01-01";
		this.appclass = 0;
		this.appfixtime = "2017-01-01";
		this.appfixclass = 0;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public long getApplicantstuid() {
		return applicantstuid;
	}

	public void setApplicantstuid(long applicantstuid) {
		this.applicantstuid = applicantstuid;
	}

	public String getAppdata() {
		return appdata;
	}

	public void setAppdata(String appdata) {
		this.appdata = appdata;
	}

	public String getAppreason() {
		return appreason;
	}

	public void setAppreason(String appreason) {
		this.appreason = appreason;
	}

	public String getApptime() {
		return apptime;
	}

	public void setApptime(String apptime) {
		this.apptime = apptime;
	}

	public int getAppclass() {
		return appclass;
	}

	public void setAppclass(int appclass) {
		this.appclass = appclass;
	}

	public String getAppfixtime() {
		return appfixtime;
	}

	public void setAppfixtime(String appfixtime) {
		this.appfixtime = appfixtime;
	}

	public int getAppfixclass() {
		return appfixclass;
	}

	public void setAppfixclass(int appfixclass) {
		this.appfixclass = appfixclass;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRedate() {
		return redate;
	}

	public void setRedate(String redate) {
		this.redate = redate;
	}

	public long getHandlerstuid() {
		return handlerstuid;
	}

	public void setHandlerstuid(long handlerstuid) {
		this.handlerstuid = handlerstuid;
	}

}
