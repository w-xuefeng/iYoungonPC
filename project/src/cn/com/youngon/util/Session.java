package cn.com.youngon.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.com.youngon.entity.ApplicationInfor;
import cn.com.youngon.entity.CarryKeyUser;
import cn.com.youngon.entity.Notices;
import cn.com.youngon.entity.Users;
import cn.com.youngon.entity.WeekDynamic;
import cn.com.youngon.entity.OnlineUser;
import cn.com.youngon.entity.SignRecord;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SuppressWarnings("deprecation")
public class Session {

	public static final String baseAPIUrl = "https://api.wangxuefeng.com.cn";

	public static final String baseHeadUrl = "https://api.wangxuefeng.com.cn/static/assets";

	public static final String iconUrl = "https://pub.wangxuefeng.com.cn/asset/youngon_logo/icon.png";

	public static Users curUser;

	public static double xOffset = 0;

	public static double yOffset = 0;

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	public static Map<String, Double> GetScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Double screenWidth = (Double) screenSize.getWidth();
		Double screenHeight = (Double) screenSize.getHeight();
		Map<String, Double> Size = new HashMap<>();
		Size.put("width", screenWidth);
		Size.put("height", screenHeight);
		return Size;
	}

	public static ImageView setImgView(String url, double width, double height, double radW, double radH) {
		ImageView imgView = new ImageView();
		Image img = new Image(url, width, height, false, false);
		imgView.setImage(img);
		Rectangle clip = new Rectangle(img.getWidth(), img.getHeight());
		clip.setArcWidth(radW);
		clip.setArcHeight(radH);
		imgView.setClip(clip);
		imgView.setFitHeight(height);
		imgView.setFitWidth(width);
		return imgView;
	}

	public static String utypeToType(int utype) {
		String type = "普通用户";
		switch (utype) {
		case 0:
			type = "普通用户";
			break;
		case 1:
			type = "实习站员";
			break;
		case 2:
			type = "正式站员";
			break;
		case 3:
			type = "往届站员";
			break;
		case 4:
			type = "管理员";
			break;
		case 5:
			type = "超级管理员";
			break;
		default:
			type = "普通用户";
			break;
		}
		return type;
	}

	public static Users jsonToUser(JSONObject jsonUser) {

		Users users = null;

		if (!jsonUser.getString("stuid").toString().equals("")) {
			long stuid = Long.parseLong(jsonUser.getString("stuid"));
			String name = jsonUser.getString("name");
			int sex = Integer.parseInt(jsonUser.getString("sex"));
			String head = baseHeadUrl + jsonUser.getString("head");
			String birthday = jsonUser.getString("birthday");
			String college = jsonUser.getString("college");
			String majorclass = jsonUser.getString("majorclass");
			String department = jsonUser.getString("department");
			String qq = jsonUser.getString("qq");
			String phone = jsonUser.getString("phone");
			String email = jsonUser.getString("email");
			int utype = Integer.parseInt(jsonUser.getString("utype"));
			boolean ifkey = intToBool(jsonUser.getIntValue("ifkey"));
			boolean online = intToBool(jsonUser.getIntValue("online"));
			String token = jsonUser.getString("token");
			JSONObject duty = JSONObject.parseObject(jsonUser.getString("duty"));
			int ulevel = jsonUser.getIntValue("ulevel");
			long sigincount = jsonUser.getLongValue("sigincount");
			String registerdate = jsonUser.getString("registerdate");
			users = new Users(stuid, name, sex, head, birthday, college, majorclass, department, qq, phone, email,
					utype, ifkey, online, token, duty, ulevel, sigincount, registerdate);
		}

		return users;

	}

	public static Notices getlastNotice() {
		Notices lastNotice = null;
		String restAPI = Session.baseAPIUrl + "/notice/get/latest";
		String json = HttpRequest.sendGet(restAPI, null, false);
		JSONObject data = JSON.parseObject(json);
		int nid = data.getIntValue("id");
		long opstuid = Long.parseLong(data.getString("opstuid"));
		String content = data.getString("content");
		String publishtime = data.getString("publishtime");
		String publisher = data.getString("publisher");
		lastNotice = new Notices(nid, opstuid, content, publishtime, publisher);
		return lastNotice;
	}

	public static ArrayList<OnlineUser> getOnlineUsers() {
		ArrayList<OnlineUser> onLineUsers = new ArrayList<OnlineUser>();
		String restAPI = Session.baseAPIUrl + "/users/get/online";
		String json = HttpRequest.sendGet(restAPI, null, false);
		JSONObject data = JSON.parseObject(json);
		boolean status = data.getBoolean("status");
		if (status) {
			JSONArray onlineUsers = data.getJSONArray("resdata");
			for (int i = 0; i < onlineUsers.size(); i++) {
				JSONObject curUser = JSON.parseObject(onlineUsers.get(i).toString());
				String entertime = curUser.getString("entertime");
				String head = curUser.getString("head");
				String name = curUser.getString("name");
				String reason = curUser.getString("reason");
				long stuid = Long.parseLong(curUser.getString("stuid"));
				onLineUsers.add(new OnlineUser(entertime, reason, head, name, stuid));
			}
		}
		return onLineUsers;
	}

	public static ArrayList<CarryKeyUser> getCarryKeyUser() {
		ArrayList<CarryKeyUser> carrykeyUsers = new ArrayList<CarryKeyUser>();
		String restAPI = Session.baseAPIUrl + "/users/get/haskey";
		String json = HttpRequest.sendGet(restAPI, null, false);
		JSONObject data = JSON.parseObject(json);
		boolean status = data.getBoolean("status");
		if (status) {
			JSONArray carryKeyUsers = data.getJSONArray("resdata");
			for (int i = 0; i < carryKeyUsers.size(); i++) {
				JSONObject curUser = JSON.parseObject(carryKeyUsers.get(i).toString());
				String phone = curUser.getString("phone");
				String head = Session.baseHeadUrl + curUser.getString("head");
				String name = curUser.getString("name");
				long stuid = Long.parseLong(curUser.getString("stuid"));
				carrykeyUsers.add(new CarryKeyUser(stuid, name, head, phone));
			}
		}
		return carrykeyUsers;
	}

	public static String getLocalIp() {
		String ip = "";
		String restAPI = Session.baseAPIUrl + "/location/index/getip";
		String json = HttpRequest.sendGet(restAPI, null, false);
		JSONObject data = JSON.parseObject(json);
		ip = data.getString("ip");
		return ip;
	}

	public static boolean isAllowIp() {
		boolean isAllowip = false;
		String restAPI = Session.baseAPIUrl + "/location/index/ip";
		String json = HttpRequest.sendGet(restAPI, null, false);
		JSONObject data = JSON.parseObject(json);
		isAllowip = data.getBooleanValue("status");
		return isAllowip;
	}

	public static boolean isOnline() {
		String restAPI = Session.baseAPIUrl + "/users";
		String json = HttpRequest.sendGet(restAPI, "token=" + Session.curUser.getToken(), false);
		JSONObject data = JSON.parseObject(json);
		JSONObject resdata = data.getJSONObject("resdata");
		int isonline = resdata.getIntValue("online");
		return isonline == 0 ? false : true;
	}

	public static JSONObject signIn(String reason) {
		String jsonMsg = "{\"status\":false,\"msg\":\"网络请求超时，请重试！\"}";
		JSONObject resJson = JSON.parseObject(jsonMsg);
		if (!Session.isAllowIp()) {
			jsonMsg = "{\"status\":false,\"msg\":\"请在指定IP下签到！\"}";
			resJson = JSON.parseObject(jsonMsg);
			return resJson;
		}
		String restAPI = Session.baseAPIUrl + "/sign/patch/in";
		String val = "{\"stuid\":" + Session.curUser.getStuid() + ", \"reason\":\"" + reason + "\"}";
		JSONObject jsonVal = JSON.parseObject(val);
		JSONObject data = executeHttpPatch(restAPI, jsonVal);
		boolean res = data.getBooleanValue("status");
		if (res) {
			jsonMsg = "{\"status\":true,\"msg\":\"签到成功！\"}";
			resJson = JSON.parseObject(jsonMsg);
		}
		return resJson;
	}

	public static JSONObject signOut(String ifkey) {
		String jsonMsg = "{\"status\":false,\"msg\":\"网络请求超时，请重试！\"}";
		JSONObject resJson = JSON.parseObject(jsonMsg);
		String restAPI = Session.baseAPIUrl + "/sign/patch/out";
		String val = "stuid=" + Session.curUser.getStuid() + "&ifkey=" + (ifkey.equals("是") ? "1" : "0");
		String json = HttpRequest.sendPost(restAPI, val);
		JSONObject data = JSON.parseObject(json);
		boolean res = data.getBooleanValue("status");
		if (res) {
			jsonMsg = "{\"status\":true,\"msg\":\"签退成功！\"}";
			resJson = JSON.parseObject(jsonMsg);
		}
		return resJson;
	}

	public static boolean addDutyRecord() {
		boolean res = false;
		String restAPI = Session.baseAPIUrl + "/duty/index/updateduty";
		String val = "{\"stuid\":" + Session.curUser.getStuid() + ", \"dutydate\":\"" + Session.getNowTime() + "\"}";
		JSONObject jsonVal = JSON.parseObject(val);
		JSONObject data = executeHttpPatch(restAPI, jsonVal);
		res = data.getBooleanValue("status");
		return res;
	}

	public static String getNowTime() {
		Date now = new Date();
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		SimpleDateFormat formatime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = (formatime.format(now)) + " " + weekDays[w];
		return nowTime;
	}

	public static Stage alert(String content, String textStyle, Stage parentStage) {

		Stage primaryStage = new Stage();
		primaryStage.setTitle(content);

		HBox aletHBox = new HBox();
		Text contentStr = new Text(content);
		contentStr.setStyle(textStyle);
		contentStr.setWrappingWidth(Session.GetScreenSize().get("width") * 0.26 * 0.8);
		String BtnStyle = "-fx-background-color:rgba(0,0,0,0);";
		String BtnHoverStyle = "-fx-background-color:rgba(0,0,0,0.55);";
		Button Btn = FontawesomeWithJavaFX.createGlyphButton("close", "", 3, Color.RED, Color.RED, Color.RED, BtnStyle,
				BtnHoverStyle);
		aletHBox.setMinSize(250, 50);
		aletHBox.setAlignment(Pos.CENTER);
		aletHBox.getChildren().addAll(contentStr, Btn);
		aletHBox.setStyle(
				"-fx-background-color:rgba(70,130,180,0.95);-fx-border-radius:5px;-fx-border-width:1px;-fx-border-image-insets: 0;");

		aletHBox.setOnMousePressed((MouseEvent event) -> {
			event.consume();
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});
		aletHBox.setOnMouseDragged((MouseEvent event) -> {
			event.consume();
			primaryStage.setX(event.getScreenX() - xOffset);

			if (event.getScreenY() - yOffset < 0) {
				primaryStage.setY(0);
			} else {
				primaryStage.setY(event.getScreenY() - yOffset);
			}
		});
		Scene scene = new Scene(aletHBox, Session.GetScreenSize().get("width") * 0.26, 50);
		scene.setFill(null);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setX(parentStage.getX());
		primaryStage.setY(parentStage.getY());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image(Session.iconUrl));
		primaryStage.show();

		Btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.close();
			}
		});

		return primaryStage;
	}

	public static JSONObject executeHttpPatch(String url, JSONObject jsonParam) {
		JSONObject resultObj = null;
		HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
		DefaultHttpClient client = new DefaultHttpClient();
		SchemeRegistry registry = new SchemeRegistry();
		SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
		socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
		registry.register(new Scheme("https", socketFactory, 443));
		SingleClientConnManager mgr = new SingleClientConnManager(client.getParams(), registry);
		DefaultHttpClient httpClient = new DefaultHttpClient(mgr, client.getParams());
		// Set verifier
		HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
		HttpPatch httpPatch = new HttpPatch(url);
		httpPatch.setHeader("Content-type", "application/json");
		httpPatch.setHeader("Charset", HTTP.UTF_8);
		httpPatch.setHeader("Accept", "application/json");
		httpPatch.setHeader("Accept-Charset", HTTP.UTF_8);
		try {
			if (jsonParam != null) {
				StringEntity entity = new StringEntity(jsonParam.toString(), HTTP.UTF_8);
				httpPatch.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPatch);
			resultObj = JSON.parseObject(EntityUtils.toString(response.getEntity()));
		} catch (ParseException | JSONException | IOException e) {
			e.printStackTrace();
		}

		return resultObj;
	}
	
	public static JSONObject executeHttpPost(String url, JSONObject jsonParam) {
		JSONObject resultObj = null;
		HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
		DefaultHttpClient client = new DefaultHttpClient();
		SchemeRegistry registry = new SchemeRegistry();
		SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
		socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
		registry.register(new Scheme("https", socketFactory, 443));
		SingleClientConnManager mgr = new SingleClientConnManager(client.getParams(), registry);
		DefaultHttpClient httpClient = new DefaultHttpClient(mgr, client.getParams());
		// Set verifier
		HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setHeader("Charset", HTTP.UTF_8);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Accept-Charset", HTTP.UTF_8);
		try {
			if (jsonParam != null) {
				StringEntity entity = new StringEntity(jsonParam.toString(), HTTP.UTF_8);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			resultObj = JSON.parseObject(EntityUtils.toString(response.getEntity()));
		} catch (ParseException | JSONException | IOException e) {
			e.printStackTrace();
		}

		return resultObj;
	}	

	public static ArrayList<WeekDynamic> getWeekdynamicList(int page) {
		ArrayList<WeekDynamic> dynamicList = new ArrayList<WeekDynamic>();
		String restAPI = Session.baseAPIUrl + "/weekdynamic/get/all";
		String json = HttpRequest.sendGet(restAPI, "page=" + page, false);
		JSONArray Weekdynamic = JSON.parseArray(json);
		for (int i = 0; i < Weekdynamic.size(); i++) {
			JSONObject curdynamic = JSON.parseObject(Weekdynamic.get(i).toString());
			int id = curdynamic.getIntValue("id");
			int week = curdynamic.getIntValue("week");
			String content = curdynamic.getString("content");
			String publishdate = curdynamic.getString("publishdate");
			String publisher = curdynamic.getString("publisher");
			long publisherstuid = Long.parseLong(curdynamic.getString("publisherstuid"));
			dynamicList.add(new WeekDynamic(id, week, content, publishdate, publisherstuid, publisher));
		}

		return dynamicList;
	}

	public static ArrayList<SignRecord> getCurWeekSignRecord() {
		ArrayList<SignRecord> curWeek = new ArrayList<SignRecord>();
		String restAPI = Session.baseAPIUrl + "/sign/record/thisweek";
		String json = HttpRequest.sendGet(restAPI, null, false);
		JSONArray data = JSON.parseArray(json);
		for (int i = 0; i < data.size(); i++) {
			JSONObject curUser = JSON.parseObject(data.get(i).toString());
			String entertime = curUser.getString("entertime");
			String outtertime = curUser.getString("outtertime");
			String head = Session.baseHeadUrl + curUser.getString("head");
			String name = curUser.getString("name");
			String reason = curUser.getString("reason");
			long stuid = Long.parseLong(curUser.getString("stuid"));
			curWeek.add(new SignRecord(entertime, stuid, name, reason, head, outtertime));
		}
		return curWeek;
	}

	public static ArrayList<SignRecord> getLastWeekSignRecord() {
		ArrayList<SignRecord> LastWeek = new ArrayList<SignRecord>();
		String restAPI = Session.baseAPIUrl + "/sign/record/lastweek";
		String json = HttpRequest.sendGet(restAPI, null, false);
		JSONArray data = JSON.parseArray(json);
		for (int i = 0; i < data.size(); i++) {
			JSONObject curUser = JSON.parseObject(data.get(i).toString());
			String entertime = curUser.getString("entertime");
			String outtertime = curUser.getString("outtertime");
			String head = Session.baseHeadUrl + curUser.getString("head");
			String name = curUser.getString("name");
			String reason = curUser.getString("reason");
			long stuid = Long.parseLong(curUser.getString("stuid"));
			LastWeek.add(new SignRecord(entertime, stuid, name, reason, head, outtertime));
		}
		return LastWeek;
	}
	
	public static boolean sendOtherApply(String content){
		boolean res = false;
		ApplicationInfor newOhterApply = new  ApplicationInfor(Session.curUser.getStuid(),content);		
		String restAPI = Session.baseAPIUrl + "/application/post";
		String val = "{\"stuid\":\"" + newOhterApply.getApplicantstuid() + "\",\"reason\":\"" + newOhterApply.getAppreason()+"\",\"apptime\":\""+newOhterApply.getApptime() + "\",\"appfixtime\":\"" + newOhterApply.getAppfixtime()+"\",\"appclass\":" + newOhterApply.getAppclass() + ",\"appfixclass\":" + newOhterApply.getAppfixclass()+ "}";
		JSONObject jsonVal = JSON.parseObject(val);
		JSONObject data = executeHttpPost(restAPI,jsonVal);
		res = data.getBooleanValue("status");
		return res;
	}
	
	public static boolean sendDutyApply(String content,String apptime,String fixtime,int appclass, int appfixclass){
		boolean res = false;
		ApplicationInfor newOhterApply = new  ApplicationInfor(Session.curUser.getStuid(),content,apptime,appclass,fixtime,appfixclass);	
		String restAPI = Session.baseAPIUrl + "/application/post";
		String val = "{\"stuid\":\"" + newOhterApply.getApplicantstuid() + "\",\"reason\":\"" + newOhterApply.getAppreason()+"\",\"apptime\":\""+newOhterApply.getApptime() + "\",\"appfixtime\":\"" + newOhterApply.getAppfixtime()+"\",\"appclass\":" + newOhterApply.getAppclass() + ",\"appfixclass\":" + newOhterApply.getAppfixclass()+ "}";
		JSONObject jsonVal = JSON.parseObject(val);
		JSONObject data = executeHttpPost(restAPI,jsonVal);
		res = data.getBooleanValue("status");
		return res;
	}	
	
	public static boolean sendemailtoadminforapp(String content){
		boolean res = false;
		String restAPI = Session.baseAPIUrl + "/email/post/admins";
		String val = "{\"type\":2,\"title\":\"" + Session.curUser.getName()+" 提出申请 来自iYoungonPC客户端\",\"content\":\""+content + "\"}";
		JSONObject jsonVal = JSON.parseObject(val);
		try {
			JSONObject data = executeHttpPost(restAPI,jsonVal);
			System.out.println(data.toString());
			res = data.getBooleanValue("status");
		} catch (Exception e) {}
		return res;
	}

	public static boolean intToBool(int m) {
		boolean is = false;
		if (m == 1) {
			is = true;
		}
		return is;
	}
}