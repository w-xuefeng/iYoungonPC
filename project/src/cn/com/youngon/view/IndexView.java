package cn.com.youngon.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;
import cn.com.youngon.entity.CarryKeyUser;
import cn.com.youngon.entity.Notices;
import cn.com.youngon.entity.OnlineUser;
import cn.com.youngon.entity.SignRecord;
import cn.com.youngon.entity.WeekDynamic;
import cn.com.youngon.util.FontawesomeWithJavaFX;
import cn.com.youngon.util.GetWeekSignRecord;
import cn.com.youngon.util.LoadWebView;
import cn.com.youngon.util.Session;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;

public class IndexView extends Application {
	private double maxWidth;
	private double minWidth;
	private double maxHeight;
	private double minHeight;
	private String title;
	private GridPane grid = new GridPane();
	private ArrayList<WeekDynamic> dynamicList = Session.getWeekdynamicList(0);

	public IndexView(String title) {
		super();
		this.title = title;
		this.minWidth = Session.GetScreenSize().get("width") * 0.26;
		this.minHeight = Session.GetScreenSize().get("height") * 0.85;
		this.maxWidth = Session.GetScreenSize().get("width") * 0.50;
		this.maxHeight = Session.GetScreenSize().get("height") * 0.90;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		// 隐藏默认标题栏
		primaryStage.getIcons().add(new Image(Session.iconUrl));
		this.grid.setHgap(10);
		this.grid.setVgap(10);
		TitleBar titleBar = new TitleBar(this.title, "https://pub.wangxuefeng.com.cn/asset/youngon_logo/icon.png",
				Session.GetScreenSize().get("width") * 0.1134, this.minWidth, this.maxWidth);
		titleBar.setTitleStyle("-fx-background-color:rgba(0,0,0,0.55)");
		titleBar.setTitleColor(Color.WHITE);
		titleBar.setMinButtonStyle(
				"-fx-base: rgba(0,0,0,0.8); -fx-border-color: rgb(243,243,243); -fx-border-width: 0.1; "
						+ "-fx-max-height: infinity;-fx-text-fill: white ; -fx-border-image-insets: 0;");
		titleBar.setCloseButtonStyle(
				"-fx-base: rgba(0,0,0,0.8); -fx-border-color: rgb(243,243,243); -fx-border-width: 0.1; "
						+ "-fx-max-height: infinity;-fx-text-fill: white ; -fx-border-image-insets: 0;");
		this.grid.add(titleBar.setTitleBar(primaryStage), 0, 0);
		this.grid.setGridLinesVisible(false);
		this.grid.setMinSize(this.minWidth, this.minHeight);
		this.grid.setMaxSize(this.maxWidth, this.maxHeight);
		this.grid.setStyle("-fx-background-color:rgba(0,0,0,0.45)");

		GridPane head = new GridPane();
		GridPane body = new GridPane();
		GridPane footer = new GridPane();

		head.setMinSize(this.minWidth, this.minHeight * 0.15);
		body.setMinSize(this.minWidth, this.minHeight * 0.70);
		body.setStyle("-fx-background-color:rgba(255,255,255,0.55)");
		footer.setMinSize(this.minWidth, this.minHeight * 0.15);
		footer.setStyle("-fx-background-color:rgba(0,0,0,0.85)");

		// head部分
		HBox headHBox = new HBox();
		headHBox.setMaxSize(this.minWidth, this.minHeight * 0.15);
		headHBox.setAlignment(Pos.CENTER);
		headHBox.setPadding(new Insets(0, 10, 0, 10));

		double headWidth = 80;
		double headHeight = 80;

		VBox headVBox = new VBox();
		headVBox.setMaxSize(this.minWidth - headWidth, this.minHeight * 0.15);
		headVBox.setAlignment(Pos.CENTER_LEFT);
		headVBox.setPadding(new Insets(5, 5, 5, 5));

		HBox inforHBox = new HBox();
		inforHBox.setAlignment(Pos.CENTER);

		Text nameText = new Text(Session.curUser.getName());
		nameText.setFill(Color.WHITE);
		nameText.setFont(Font.font("微软雅黑", FontWeight.BOLD, 20));

		Text utype = new Text(Session.utypeToType(Session.curUser.getUtype()));
		utype.setFill(Color.WHITE);
		utype.setStyle("-fx-font-size:12px;");

		Text depatement = new Text(Session.curUser.getDepartment());
		depatement.setFill(Color.WHITE);
		depatement.setStyle("-fx-font-size:12px;");

		Text ulevel = new Text("YGLV" + Session.curUser.getUlevel());
		ulevel.setFill(Color.DEEPSKYBLUE);
		ulevel.setStyle("-fx-font-size:12px;");

		inforHBox.getChildren().addAll(nameText, utype, depatement, ulevel);
		inforHBox.setSpacing(2);

		Text stuidText = new Text(Session.curUser.getStuid() + "");
		stuidText.setFill(Color.WHITE);
		stuidText.setStyle("-fx-font-size:15px;");

		headVBox.getChildren().addAll(inforHBox, stuidText);

		// 头像设置
		ImageView headImgView = Session.setImgView(Session.curUser.getHead(), headWidth, headHeight, headWidth,
				headHeight);
		headImgView.setCursor(Cursor.HAND);
		headHBox.getChildren().addAll(headImgView, headVBox);

		head.add(headHBox, 0, 0);

		// 主体部分
		// ScrollPane indexScrollPane = setIndexScrollPane();
		ScrollPane signScrollPane = setSignScrollPane(Session.isOnline(), body, primaryStage);

		body.add(signScrollPane, 0, 0);

		// footer部分
		HBox footerHBox = new HBox();
		footerHBox.setMaxSize(this.minWidth, this.minHeight * 0.15);
		footerHBox.setAlignment(Pos.CENTER);

		String signBtnStyle = "-fx-background-color:rgba(0,0,0,0);-fx-font-size:12px;";
		String signBtnHoverStyle = "-fx-background-color:rgba(0,0,0,0.55);-fx-text-fill: deepskyblue;";
		Button signBtn = FontawesomeWithJavaFX.createGlyphButton("pencil", "签到", 3, Color.WHITE, Color.DODGERBLUE,
				Color.DODGERBLUE, signBtnStyle, signBtnHoverStyle);

		String indexBtnStyle = "-fx-background-color:rgba(0,0,0,0);-fx-font-size:12px;";
		String indexBtnHoverStyle = "-fx-background-color:rgba(0,0,0,0.55);-fx-text-fill: deepskyblue;";
		Button indexBtn = FontawesomeWithJavaFX.createGlyphButton("home", "主页", 3, Color.WHITE, Color.DODGERBLUE,
				Color.DODGERBLUE, indexBtnStyle, indexBtnHoverStyle);

		String dynamicBtnStyle = "-fx-background-color:rgba(0,0,0,0);-fx-font-size:12px;";
		String dynamicBtnHoverStyle = "-fx-background-color:rgba(0,0,0,0.55);-fx-text-fill: deepskyblue;";
		Button dynamicBtn = FontawesomeWithJavaFX.createGlyphButton("star", "动态", 3, Color.WHITE, Color.DODGERBLUE,
				Color.DODGERBLUE, dynamicBtnStyle, dynamicBtnHoverStyle);

		String signRecordBtnStyle = "-fx-background-color:rgba(0,0,0,0);-fx-font-size:12px;";
		String signRecordBtnHoverStyle = "-fx-background-color:rgba(0,0,0,0.55);-fx-text-fill: deepskyblue;";
		Button signRecordBtn = FontawesomeWithJavaFX.createGlyphButton("edit", "记录", 3, Color.WHITE, Color.DODGERBLUE,
				Color.DODGERBLUE, signRecordBtnStyle, signRecordBtnHoverStyle);

		String moreBtnStyle = "-fx-background-color:rgba(0,0,0,0);-fx-font-size:12px;";
		String moreBtnHoverStyle = "-fx-background-color:rgba(0,0,0,0.55);-fx-text-fill: deepskyblue;";
		Button moreBtn = FontawesomeWithJavaFX.createGlyphButton("send", "申请", 3, Color.WHITE, Color.DODGERBLUE,
				Color.DODGERBLUE, moreBtnStyle, moreBtnHoverStyle);

		footerHBox.getChildren().addAll(signBtn, indexBtn, dynamicBtn, signRecordBtn, moreBtn);
		footerHBox.setSpacing(20);
		footer.setAlignment(Pos.TOP_CENTER);
		footer.add(footerHBox, 0, 0);

		indexBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				refreshIndexPane(body);
			}
		});

		signBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				refreshSignPane(body, primaryStage);
			}
		});

		dynamicBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				refreshDynamicPane(body, primaryStage);
			}
		});

		signRecordBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				refreshSignRecordPane(body);
			}
		});
		
		moreBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				refreshApplyPane(body,primaryStage);
			}
		});
		
		
		
		
		VBox mainPane = new VBox();
		mainPane.getChildren().addAll(head, body, footer);

		this.grid.addRow(1, mainPane);
		Scene scene = new Scene(this.grid, this.minWidth, this.minHeight);
		scene.setFill(null);
		scene.getStylesheets().add(getClass().getResource("View.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(this.minHeight);
		primaryStage.setMaxHeight(this.maxHeight);
		primaryStage.setMinWidth(this.minWidth);
		primaryStage.setMaxWidth(this.maxWidth);
		primaryStage.setResizable(false);
		LaunchViewImg launchViewImg = new LaunchViewImg("https://pub.wangxuefeng.com.cn/asset/youngon_logo/launch2.png",
				this.minWidth, this.minHeight);
		launchViewImg.start(primaryStage);
	}

	public ScrollPane setIndexScrollPane() {
		// 主页主体部分
		ScrollPane indexScrollPane = new ScrollPane();
		indexScrollPane.setMinSize(this.minWidth, this.minHeight * 0.70);
		indexScrollPane.setMaxSize(this.minWidth, this.minHeight * 0.70);
		indexScrollPane.setMinViewportWidth(this.minWidth);
		indexScrollPane.setMinViewportHeight(this.minHeight * 0.70);
		indexScrollPane.getStyleClass().add("edge-to-edge");
		indexScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		indexScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		VBox indexScrollPaneVbox = new VBox();
		indexScrollPaneVbox.setMinSize(this.minWidth, this.minHeight * 0.70);
		indexScrollPaneVbox.setAlignment(Pos.TOP_CENTER);
		indexScrollPaneVbox.setSpacing(20);
		indexScrollPaneVbox.setPadding(new Insets(10, 2, 10, 2));
		indexScrollPaneVbox.setStyle("-fx-background-color:rgba(0,0,0,0);");

		// 最新公告
		VBox lastNoticeVBox = new VBox();
		Notices lastnotice = Session.getlastNotice();
		String lastNoticeVBoxStyle = "-fx-background-color:rgba(0,0,0,0.85);";
		lastNoticeVBox.setMinWidth(this.minWidth * 0.88);
		lastNoticeVBox.setMaxWidth(this.minWidth * 0.88);
		lastNoticeVBox.setStyle(lastNoticeVBoxStyle);
		lastNoticeVBox.setAlignment(Pos.CENTER_LEFT);

		HBox noticeTitle = new HBox();
		noticeTitle.setAlignment(Pos.CENTER_LEFT);
		Text noticeTitleText = new Text("最新公告");
		noticeTitleText.setFill(Color.WHITE);
		noticeTitleText.setStyle("-fx-font-size:16px;");
		String noticeIconStyle = "-fx-background-color:rgba(0,0,0,0);";
		String noticeIconHoverStyle = "-fx-background-color:rgba(0,0,0,0);";
		Button noticeIcon = FontawesomeWithJavaFX.createGlyphButton("comment", "", 3, Color.WHITE, Color.WHITE,
				Color.WHITE, noticeIconStyle, noticeIconHoverStyle);
		noticeTitle.getChildren().addAll(noticeIcon, noticeTitleText);

		HBox noticeContentHBox = new HBox();
		noticeContentHBox.setPadding(new Insets(2, 15, 2, 15));
		Text lastNoticeContent = new Text(lastnotice.getContent());
		lastNoticeContent.setFill(Color.WHITE);
		lastNoticeContent.setStyle("-fx-font-size:14px;");
		noticeContentHBox.getChildren().add(lastNoticeContent);

		HBox noticefooterHBox = new HBox();
		noticefooterHBox.setPadding(new Insets(2, 15, 2, 15));
		noticefooterHBox.setAlignment(Pos.CENTER_RIGHT);
		Text lastNoticeFooter = new Text(lastnotice.getPublisher() + " 于 " + lastnotice.getPublishtime() + " 发布");
		lastNoticeFooter.setFill(Color.GRAY);
		lastNoticeFooter.setStyle("-fx-font-size:14px;");
		noticefooterHBox.getChildren().add(lastNoticeFooter);

		lastNoticeVBox.getChildren().addAll(noticeTitle, noticeContentHBox, noticefooterHBox);

		// 当前在站
		VBox curOnlineVBox = new VBox();
		ArrayList<OnlineUser> curOnlineUser = Session.getOnlineUsers();
		Border grayBorderBottom = new Border(new BorderStroke(Color.rgb(0, 0, 0, 0), Color.rgb(0, 0, 0, 0), Color.GRAY,
				Color.rgb(0, 0, 0, 0), BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID,
				BorderStrokeStyle.NONE, null, new BorderWidths(1), null));
		String curOnlineVBoxStyle = "-fx-background-color:rgba(0,0,0,0.85);";
		curOnlineVBox.setMinWidth(this.minWidth * 0.88);
		curOnlineVBox.setMaxWidth(this.minWidth * 0.88);
		curOnlineVBox.setStyle(curOnlineVBoxStyle);
		curOnlineVBox.setAlignment(Pos.CENTER_LEFT);

		HBox onliceUserTitle = new HBox();
		onliceUserTitle.setAlignment(Pos.CENTER_LEFT);
		onliceUserTitle.setMinWidth(minWidth * 0.88);
		Text onlineuserTitleText = new Text("当前在站");
		onlineuserTitleText.setFill(Color.WHITE);
		onlineuserTitleText.setStyle("-fx-font-size:16px;");
		onlineuserTitleText.setWrappingWidth(minWidth * 0.88 * 0.7);

		Text onlineuserTitleTextCount = new Text(curOnlineUser.size() + "人");
		onlineuserTitleTextCount.setFill(Color.WHITE);
		onlineuserTitleTextCount.setStyle("-fx-font-size:16px;");
		onlineuserTitleTextCount.setTextAlignment(TextAlignment.RIGHT);

		String onlioneUserIconStyle = "-fx-background-color:rgba(0,0,0,0);";
		Button onlineUserIcon = FontawesomeWithJavaFX.createGlyphButton("user", "", 3, Color.WHITE, Color.WHITE,
				Color.WHITE, onlioneUserIconStyle, onlioneUserIconStyle);
		onliceUserTitle.getChildren().addAll(onlineUserIcon, onlineuserTitleText, onlineuserTitleTextCount);
		onliceUserTitle.setBorder(grayBorderBottom);

		VBox curOnlineUserlist = new VBox();
		curOnlineUserlist.setSpacing(2);
		curOnlineUserlist.setPadding(new Insets(15, 2, 15, 2));
		if (curOnlineUser.size() > 0) {
			for (int i = 0; i < curOnlineUser.size(); i++) {
				HBox onlineContentHBox = new HBox();
				VBox onlineUserVBox = new VBox();
				onlineContentHBox.setPadding(new Insets(2, 15, 2, 15));

				ImageView onlineUserHead = Session.setImgView(curOnlineUser.get(i).getHead(),
						this.minWidth * 0.88 * 0.18, this.minWidth * 0.88 * 0.18, this.minWidth * 0.88 * 0.18,
						this.minWidth * 0.88 * 0.18);
				onlineUserHead.setCursor(Cursor.HAND);

				Text curUsername = new Text(curOnlineUser.get(i).getName());
				curUsername.setStyle("-fx-font-size:14px;");
				curUsername.setFill(Color.WHITE);
				Text curUserstuid = new Text(curOnlineUser.get(i).getStuid() + "");
				curUserstuid.setStyle("-fx-font-size:10px;");
				curUserstuid.setFill(Color.GRAY);

				onlineUserVBox.setAlignment(Pos.CENTER_LEFT);
				onlineUserVBox.setMinWidth(this.minWidth * 0.88 * 0.42);
				onlineUserVBox.getChildren().addAll(curUsername, curUserstuid);

				Text curUserReason = new Text(curOnlineUser.get(i).getReason());
				curUserReason.setStyle("-fx-font-size:14px;");
				curUserReason.setFill(Color.WHITE);
				HBox curUserReasonHBox = new HBox();
				curUserReasonHBox.setAlignment(Pos.CENTER_RIGHT);
				curUserReasonHBox.getChildren().add(curUserReason);

				onlineContentHBox.setSpacing(10);
				onlineContentHBox.getChildren().addAll(onlineUserHead, onlineUserVBox, curUserReasonHBox);
				curOnlineUserlist.getChildren().add(onlineContentHBox);
			}
		} else {
			Text noUserOnline = new Text("暂无人在站");
			noUserOnline.setFill(Color.WHITE);
			noUserOnline.setStyle("-fx-font-size:16px;");
			curOnlineUserlist.getChildren().add(noUserOnline);
			curOnlineUserlist.setAlignment(Pos.CENTER);
		}

		curOnlineVBox.getChildren().addAll(onliceUserTitle, curOnlineUserlist);

		// 钥匙携带者
		VBox carryKeyUserVBox = new VBox();
		ArrayList<CarryKeyUser> carryKeyUserlist = Session.getCarryKeyUser();
		String carryKeyUserVBoxStyle = "-fx-background-color:rgba(0,0,0,0.85);";
		carryKeyUserVBox.setMinWidth(this.minWidth * 0.88);
		carryKeyUserVBox.setMaxWidth(this.minWidth * 0.88);
		carryKeyUserVBox.setStyle(carryKeyUserVBoxStyle);
		carryKeyUserVBox.setAlignment(Pos.CENTER_LEFT);

		HBox carryKeyTitle = new HBox();
		carryKeyTitle.setAlignment(Pos.CENTER_LEFT);
		carryKeyTitle.setMinWidth(minWidth * 0.88);
		Text carryKeyTitleText = new Text("钥匙携带者");
		carryKeyTitleText.setFill(Color.WHITE);
		carryKeyTitleText.setStyle("-fx-font-size:16px;");
		carryKeyTitleText.setWrappingWidth(minWidth * 0.88 * 0.7);

		Text carryKeyTitleTextCount = new Text(carryKeyUserlist.size() + "人");
		carryKeyTitleTextCount.setFill(Color.WHITE);
		carryKeyTitleTextCount.setStyle("-fx-font-size:16px;");
		carryKeyTitleTextCount.setTextAlignment(TextAlignment.RIGHT);

		String carrykeyIconStyle = "-fx-background-color:rgba(0,0,0,0);";
		Button carrykeyIcon = FontawesomeWithJavaFX.createGlyphButton("key", "", 3, Color.WHITE, Color.WHITE,
				Color.WHITE, carrykeyIconStyle, carrykeyIconStyle);
		carryKeyTitle.getChildren().addAll(carrykeyIcon, carryKeyTitleText, carryKeyTitleTextCount);
		carryKeyTitle.setBorder(grayBorderBottom);

		VBox carrykeyUserlist = new VBox();
		carrykeyUserlist.setSpacing(2);
		carrykeyUserlist.setPadding(new Insets(15, 2, 15, 2));
		if (carryKeyUserlist.size() > 0) {
			for (int i = 0; i < carryKeyUserlist.size(); i++) {
				HBox carryKeyContentHBox = new HBox();
				VBox carrykeyUserVBox = new VBox();
				carryKeyContentHBox.setPadding(new Insets(2, 15, 2, 15));

				ImageView carrykeyUserHead = Session.setImgView(carryKeyUserlist.get(i).getHead(),
						this.minWidth * 0.88 * 0.18, this.minWidth * 0.88 * 0.18, this.minWidth * 0.88 * 0.18,
						this.minWidth * 0.88 * 0.18);
				carrykeyUserHead.setCursor(Cursor.HAND);

				Text carrykeyname = new Text(carryKeyUserlist.get(i).getName());
				carrykeyname.setStyle("-fx-font-size:14px;");
				carrykeyname.setFill(Color.WHITE);
				Text carrykeyPhone = new Text(carryKeyUserlist.get(i).getPhone());
				carrykeyPhone.setStyle("-fx-font-size:10px;");
				carrykeyPhone.setFill(Color.GRAY);

				carrykeyUserVBox.setAlignment(Pos.CENTER_LEFT);
				carrykeyUserVBox.setMinWidth(this.minWidth * 0.88 * 0.42);
				carrykeyUserVBox.getChildren().addAll(carrykeyname, carrykeyPhone);

				carryKeyContentHBox.setSpacing(10);
				carryKeyContentHBox.getChildren().addAll(carrykeyUserHead, carrykeyUserVBox);
				carrykeyUserlist.getChildren().add(carryKeyContentHBox);
			}
		} else {
			Text noUserCarrykey = new Text("暂无人携带钥匙");
			noUserCarrykey.setFill(Color.WHITE);
			noUserCarrykey.setStyle("-fx-font-size:16px;");
			carrykeyUserlist.getChildren().add(noUserCarrykey);
			carrykeyUserlist.setAlignment(Pos.CENTER);
		}

		carryKeyUserVBox.getChildren().addAll(carryKeyTitle, carrykeyUserlist);

		indexScrollPaneVbox.getChildren().addAll(lastNoticeVBox, curOnlineVBox, carryKeyUserVBox);
		indexScrollPane.setContent(indexScrollPaneVbox);
		indexScrollPane.setStyle("-fx-background-color: transparent;-fx-control-inner-background: transparent;");

		return indexScrollPane;
	}

	public ScrollPane setSignScrollPane(boolean isOnline, GridPane body, Stage primaryStage) {
		// 签到主体部分
		ScrollPane signScrollPane = new ScrollPane();
		signScrollPane.setMinSize(this.minWidth, this.minHeight * 0.70);
		signScrollPane.setMaxSize(this.minWidth, this.minHeight * 0.70);
		signScrollPane.setMinViewportWidth(this.minWidth);
		signScrollPane.setMinViewportHeight(this.minHeight * 0.70);
		signScrollPane.getStyleClass().add("edge-to-edge");
		signScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		signScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		VBox signScrollPaneVbox = new VBox();
		signScrollPaneVbox.setMinSize(this.minWidth, this.minHeight * 0.70);
		signScrollPaneVbox.setAlignment(Pos.TOP_CENTER);
		signScrollPaneVbox.setSpacing(20);
		signScrollPaneVbox.setPadding(new Insets(10, 2, 10, 2));
		signScrollPaneVbox.setStyle("-fx-background-color:rgba(0,0,0,0);");

		// 签到
		VBox signVBox = new VBox();
		String curIp = Session.getLocalIp();
		boolean isInAllowIp = Session.isAllowIp();
		String signVBoxStyle = "-fx-background-color:rgba(0,0,0,0.85);";
		signVBox.setMinWidth(this.minWidth * 0.88);
		signVBox.setMaxWidth(this.minWidth * 0.88);
		signVBox.setStyle(signVBoxStyle);
		signVBox.setAlignment(Pos.CENTER_LEFT);
		signVBox.setSpacing(10);
		signVBox.setPadding(new Insets(0, 0, 10, 0));

		HBox signTitle = new HBox();
		signTitle.setAlignment(Pos.CENTER_LEFT);
		Text signTitleText = new Text(isOnline ? "签退" : "签到");
		signTitleText.setFill(Color.WHITE);
		signTitleText.setStyle("-fx-font-size:16px;");
		String signIconStyle = "-fx-background-color:rgba(0,0,0,0);";
		String signIconHoverStyle = "-fx-background-color:rgba(0,0,0,0);";
		Button signIcon = FontawesomeWithJavaFX.createGlyphButton("pencil", "", 3, Color.WHITE, Color.WHITE,
				Color.WHITE, signIconStyle, signIconHoverStyle);
		signTitle.getChildren().addAll(signIcon, signTitleText);

		HBox signContentHBox = new HBox();
		signContentHBox.setPadding(new Insets(2, 15, 2, 15));
		VBox signContentVBox = new VBox();

		Text signTitleTipText = new Text(isOnline ? "前选择是否携带钥匙" : "请选择签到原因：");
		signTitleTipText.setFill(Color.WHITE);
		signTitleTipText.setStyle("-fx-font-size:18px;");

		signContentVBox.setAlignment(Pos.CENTER_LEFT);

		ObservableList<String> item = isOnline ? FXCollections.observableArrayList("是", "否")
				: FXCollections.observableArrayList("临时进站", "值班", "补值班", "例会", "自习", "其他");
		ChoiceBox<String> signReason = new ChoiceBox<String>(item);
		signReason.setValue("请选择");
		signReason.setTooltip(new Tooltip("请选择"));
		signReason.setMinSize(minWidth * 0.88 * 0.9, 30);
		signReason.setCursor(Cursor.HAND);
		signReason.setStyle("-fx-background-color:rgba(255,255,255,0.75);");
		Button signBtn = new Button(isOnline ? "签退" : "签到");
		signBtn.setAlignment(Pos.CENTER);
		signBtn.setCursor(Cursor.HAND);
		signBtn.setStyle((isOnline
				? "-fx-background-color:rgba(255,255,255,0.95);-fx-text-fill: black;-fx-border-color: red; -fx-border-width: 0.1;"
				: "-fx-background-color:#3A98CE;-fx-text-fill: white;") + "-fx-font-size:16px");
		signBtn.setMinSize(this.minWidth * 0.88 * 0.9, 30);
		signContentVBox.setSpacing(15);
		signContentVBox.getChildren().addAll(signTitleTipText, signReason, signBtn);
		signContentHBox.getChildren().add(signContentVBox);

		if (isOnline) {
			signBtn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					String ifkey = signReason.getValue();
					if (ifkey.equals("请选择")) {
						signReason.setFocusTraversable(true);
						Session.alert("请选择是否携带钥匙！", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
						return;
					}
					signOut(ifkey, body, primaryStage);
				}
			});
		} else {
			signBtn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					String reason = signReason.getValue();
					if (reason.equals("请选择")) {
						signReason.setFocusTraversable(true);
						Session.alert("请选择签到原因！", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
						return;
					}
					signIn(reason, body, primaryStage);
				}
			});
		}

		HBox signfooterHBox = new HBox();
		signfooterHBox.setPadding(new Insets(2, 15, 2, 15));
		signfooterHBox.setAlignment(Pos.CENTER_RIGHT);
		Text signfooterText = new Text("当前IP地址: " + curIp);
		signfooterText.setFill(isInAllowIp ? Color.SKYBLUE : Color.RED);
		signfooterText.setStyle("-fx-font-size:14px;");
		signfooterHBox.getChildren().add(signfooterText);

		signVBox.getChildren().addAll(signTitle, signContentHBox, signfooterHBox);

		signScrollPaneVbox.getChildren().addAll(signVBox);
		signScrollPane.setContent(signScrollPaneVbox);
		signScrollPane.setStyle("-fx-background-color: transparent;-fx-control-inner-background: transparent;");

		return signScrollPane;
	}

	public ScrollPane setDynamicScrollPane(GridPane body, Stage primaryStage) {
		// 动态主体部分
		ScrollPane dynamicScrollPane = new ScrollPane();
		dynamicScrollPane.setMinSize(this.minWidth, this.minHeight * 0.70);
		dynamicScrollPane.setMaxSize(this.minWidth, this.minHeight * 0.70);
		dynamicScrollPane.setMinViewportWidth(this.minWidth);
		dynamicScrollPane.setMinViewportHeight(this.minHeight * 0.70);
		dynamicScrollPane.getStyleClass().add("edge-to-edge");
		dynamicScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		dynamicScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		VBox dynamicScrollPaneVbox = new VBox();
		dynamicScrollPaneVbox.setMinSize(this.minWidth, this.minHeight * 0.70);
		dynamicScrollPaneVbox.setAlignment(Pos.TOP_CENTER);
		dynamicScrollPaneVbox.setSpacing(20);
		dynamicScrollPaneVbox.setPadding(new Insets(10, 2, 10, 2));
		dynamicScrollPaneVbox.setStyle("-fx-background-color:rgba(0,0,0,0);");

		String beginHtml = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><style>*{background-color:rgba(255,255,255,0.15);font-family:\"微软雅黑\";} .textCenter{text-align:center;}</style></head><body>";
		String endHtml = "</body></html>";

		if (dynamicList.size() > 0) {
			for (int i = 0; i < dynamicList.size(); i++) {
				// 动态
				VBox dynamicVBox = new VBox();
				String dynamicVBoxStyle = "-fx-background-color:rgba(0,0,0,0.85);";
				dynamicVBox.setMinWidth(this.minWidth * 0.88);
				dynamicVBox.setMaxWidth(this.minWidth * 0.88);
				dynamicVBox.setStyle(dynamicVBoxStyle);
				dynamicVBox.setAlignment(Pos.CENTER);
				dynamicVBox.setSpacing(10);
				dynamicVBox.setPadding(new Insets(10, 3, 10, 3));
				Text dynamicTitleText = new Text("阳光网站 第" + dynamicList.get(i).getWeek() + "周动态");
				dynamicTitleText.setFill(Color.WHITE);
				dynamicTitleText.setStyle("-fx-font-size:18px;");

				HBox dynamicContentHBox = new HBox();
				dynamicContentHBox.setAlignment(Pos.CENTER);
				dynamicContentHBox.setPadding(new Insets(10));
				GridPane webviewGridpane = new GridPane();
				dynamicContentHBox.setMinWidth(this.minWidth * 0.80);
				dynamicContentHBox.setStyle("-fx-background-color:rgba(0,0,0,0)");
				webviewGridpane.setMinWidth(this.minWidth * 0.80);
				webviewGridpane.setMaxWidth(this.minWidth * 0.80);
				webviewGridpane.setMaxHeight(this.minWidth * 0.80);
				webviewGridpane.setStyle("-fx-background-color:rgba(0,0,0,0);");
				LoadWebView dynamicWebcontent = new LoadWebView(beginHtml + dynamicList.get(i).getContent() + endHtml,
						dynamicTitleText.getText(), webviewGridpane);
				dynamicWebcontent.start(new Stage());
				dynamicContentHBox.getChildren().addAll(webviewGridpane);

				HBox dynamicfooterHBox = new HBox();
				dynamicfooterHBox.setPadding(new Insets(2, 15, 2, 15));
				dynamicfooterHBox.setAlignment(Pos.CENTER_LEFT);
				Text dynamicfooterText = new Text(
						dynamicList.get(i).getPublisher() + "于" + dynamicList.get(0).getPublishdate() + "发布");
				dynamicfooterText.setFill(Color.GRAY);
				dynamicfooterText.setStyle("-fx-font-size:14px;");
				dynamicfooterHBox.getChildren().add(dynamicfooterText);

				dynamicVBox.getChildren().addAll(dynamicTitleText, dynamicContentHBox, dynamicfooterHBox);
				dynamicScrollPaneVbox.getChildren().add(dynamicVBox);
			}
		} else {
			Text nodynamic = new Text("暂无动态");
			nodynamic.setFill(Color.WHITE);
			nodynamic.setStyle("-fx-font-size:16px;");
			dynamicScrollPaneVbox.getChildren().add(nodynamic);
			dynamicScrollPaneVbox.setAlignment(Pos.CENTER);
		}

		dynamicScrollPane.setContent(dynamicScrollPaneVbox);
		dynamicScrollPane.setStyle("-fx-background-color: transparent;-fx-control-inner-background: transparent;");

		dynamicScrollPane.setOnScrollFinished(new EventHandler<ScrollEvent>() {
			public void handle(ScrollEvent event) {
				System.out.println(dynamicList.size());

			}
		});

		return dynamicScrollPane;
	}

	public VBox setSignRecordScrollPane() {
		// 签到记录主体部分
		ScrollPane SignRecord = new ScrollPane();
		SignRecord.setMinSize(this.minWidth, this.minHeight * 0.70 - 50);
		SignRecord.setMaxSize(this.minWidth, this.minHeight * 0.70 - 50);
		SignRecord.setMinViewportWidth(this.minWidth);
		SignRecord.setMinViewportHeight(this.minHeight * 0.70 - 50);
		SignRecord.getStyleClass().add("edge-to-edge");
		SignRecord.setHbarPolicy(ScrollBarPolicy.NEVER);
		SignRecord.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		VBox SignRecordScrollPaneVbox = new VBox();
		SignRecordScrollPaneVbox.setMinSize(this.minWidth, this.minHeight * 0.70);
		SignRecordScrollPaneVbox.setAlignment(Pos.TOP_CENTER);
		SignRecordScrollPaneVbox.setSpacing(20);
		SignRecordScrollPaneVbox.setPadding(new Insets(10, 2, 10, 2));
		SignRecordScrollPaneVbox.setStyle("-fx-background-color:rgba(0,0,0,0);");

		
		ArrayList<SignRecord> curWeekList = Session.getCurWeekSignRecord();
		ArrayList<SignRecord> lastWeekList = Session.getLastWeekSignRecord();		
		// 本周记录
		VBox curWeekVBox = new VBox();
		Border grayBorderBottom = new Border(new BorderStroke(Color.rgb(0, 0, 0, 0), Color.rgb(0, 0, 0, 0), Color.GRAY,
				Color.rgb(0, 0, 0, 0), BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID,
				BorderStrokeStyle.NONE, null, new BorderWidths(1), null));
		String curWeekVBoxStyle = "-fx-background-color:rgba(0,0,0,0.85);";
		curWeekVBox.setMinWidth(this.minWidth * 0.88);
		curWeekVBox.setMaxWidth(this.minWidth * 0.88);
		curWeekVBox.setStyle(curWeekVBoxStyle);
		curWeekVBox.setAlignment(Pos.CENTER_LEFT);

		HBox curweekTitle = new HBox();
		curweekTitle.setAlignment(Pos.CENTER_LEFT);
		curweekTitle.setMinWidth(minWidth * 0.88);
		Text curweekTitleText = new Text("本周记录");
		curweekTitleText.setFill(Color.WHITE);
		curweekTitleText.setStyle("-fx-font-size:16px;");
		curweekTitleText.setWrappingWidth(minWidth * 0.88 * 0.7);

		String curweekIconStyle = "-fx-background-color:rgba(0,0,0,0);";
		Button curweekIcon = FontawesomeWithJavaFX.createGlyphButton("user", "", 3, Color.WHITE, Color.WHITE,
				Color.WHITE, curweekIconStyle, curweekIconStyle);
		curweekTitle.getChildren().addAll(curweekIcon, curweekTitleText);
		curweekTitle.setBorder(grayBorderBottom);

		VBox cuWeeklist = new VBox();
		cuWeeklist.setSpacing(2);
		cuWeeklist.setPadding(new Insets(15, 2, 15, 2));
		if (curWeekList.size() == 0) {
			Text noUser = new Text("暂无记录");
			noUser.setFill(Color.WHITE);
			noUser.setStyle("-fx-font-size:16px;");
			cuWeeklist.getChildren().add(noUser);
			cuWeeklist.setAlignment(Pos.CENTER);
		} else {			
			for (int i = 0; i < curWeekList.size(); i++) {
				GetWeekSignRecord curweek = new GetWeekSignRecord(i, cuWeeklist,curWeekList);
				curweek.start();	
			}
		}
		curWeekVBox.getChildren().addAll(curweekTitle, cuWeeklist);

		VBox lastWeekVBox = new VBox();
		String lastWeekVBoxStyle = "-fx-background-color:rgba(0,0,0,0.85);";
		lastWeekVBox.setMinWidth(this.minWidth * 0.88);
		lastWeekVBox.setMaxWidth(this.minWidth * 0.88);
		lastWeekVBox.setStyle(lastWeekVBoxStyle);
		lastWeekVBox.setAlignment(Pos.CENTER_LEFT);

		HBox lastweekTitle = new HBox();
		lastweekTitle.setAlignment(Pos.CENTER_LEFT);
		lastweekTitle.setMinWidth(minWidth * 0.88);
		Text lastweekTitleText = new Text("上周记录");
		lastweekTitleText.setFill(Color.WHITE);
		lastweekTitleText.setStyle("-fx-font-size:16px;");
		lastweekTitleText.setWrappingWidth(minWidth * 0.88 * 0.7);

		String lastweekIconStyle = "-fx-background-color:rgba(0,0,0,0);";
		Button lastweekIcon = FontawesomeWithJavaFX.createGlyphButton("user", "", 3, Color.WHITE, Color.WHITE,
				Color.WHITE, lastweekIconStyle, lastweekIconStyle);
		lastweekTitle.getChildren().addAll(lastweekIcon, lastweekTitleText);
		lastweekTitle.setBorder(grayBorderBottom);

		
		//上周记录
		VBox lastWeeklist = new VBox();
		lastWeeklist.setSpacing(2);
		lastWeeklist.setPadding(new Insets(15, 2, 15, 2));
		if (lastWeekList.size() == 0) {
			Text noUser = new Text("暂无记录");
			noUser.setFill(Color.WHITE);
			noUser.setStyle("-fx-font-size:16px;");
			lastWeeklist.getChildren().add(noUser);
			lastWeeklist.setAlignment(Pos.CENTER);
		} else {			
			for (int i = 0; i < lastWeekList.size(); i++) {
				GetWeekSignRecord lastweek = new GetWeekSignRecord(i, lastWeeklist, lastWeekList);
				lastweek.start();
			}
		}
		lastWeekVBox.getChildren().addAll(lastweekTitle, lastWeeklist);

		HBox SignRecordBtnHbox = new HBox();
		SignRecordBtnHbox.setAlignment(Pos.CENTER);
		SignRecordBtnHbox.setMinSize(this.minWidth * 0.88, 50);
		SignRecordBtnHbox.setSpacing(10);
		SignRecordBtnHbox.setStyle("-fx-position:fixed;");
		SignRecordBtnHbox.setPadding(new Insets(5));
		Button curBtn = new Button("本周记录");
		Button lastBtn = new Button("上周记录");
		lastBtn.setStyle("-fx-background-color:#3A98CE;");
		curBtn.setStyle("-fx-background-color:#3A98CE;");
		lastBtn.setCursor(Cursor.HAND);
		curBtn.setCursor(Cursor.HAND);
		lastBtn.setMinSize(this.minWidth * 0.88 * 0.5, 40);
		curBtn.setMinSize(this.minWidth * 0.88 * 0.5, 40);
		lastBtn.setTextFill(Color.WHITE);
		curBtn.setTextFill(Color.WHITE);
		SignRecordBtnHbox.getChildren().addAll(curBtn, lastBtn);
		SignRecordScrollPaneVbox.getChildren().addAll(curWeekVBox, lastWeekVBox);
		SignRecord.setContent(SignRecordScrollPaneVbox);
		SignRecord.setStyle("-fx-background-color: transparent;-fx-control-inner-background: transparent;");

		curBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				SignRecordScrollPaneVbox.getChildren().removeAll(curWeekVBox, lastWeekVBox);
				SignRecordScrollPaneVbox.getChildren().add(curWeekVBox);
			}
		});

		lastBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				SignRecordScrollPaneVbox.getChildren().removeAll(curWeekVBox, lastWeekVBox);
				SignRecordScrollPaneVbox.getChildren().add(lastWeekVBox);
			}
		});

		VBox warp = new VBox();		
		warp.getChildren().addAll(SignRecordBtnHbox, SignRecord);
		return warp;
	}

	
	
	
	@SuppressWarnings("unchecked")
	public ScrollPane setApplyScrollPane(GridPane body, Stage primaryStage) {
		// 申请主体部分
		ScrollPane applyScrollPane = new ScrollPane();
		applyScrollPane.setMinSize(this.minWidth, this.minHeight * 0.70);
		applyScrollPane.setMaxSize(this.minWidth, this.minHeight * 0.70);
		applyScrollPane.setMinViewportWidth(this.minWidth);
		applyScrollPane.setMinViewportHeight(this.minHeight * 0.70);
		applyScrollPane.getStyleClass().add("edge-to-edge");
		applyScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		applyScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		VBox applyScrollPaneVbox = new VBox();
		applyScrollPaneVbox.setMinSize(this.minWidth, this.minHeight * 0.70);
		applyScrollPaneVbox.setAlignment(Pos.TOP_CENTER);
		applyScrollPaneVbox.setSpacing(20);
		applyScrollPaneVbox.setPadding(new Insets(10, 2, 10, 2));
		applyScrollPaneVbox.setStyle("-fx-background-color:rgba(0,0,0,0);");

		// 其他申请
		VBox applyVBox = new VBox();		
		String applyVBoxStyle = "-fx-background-color:rgba(0,0,0,0.85);";
		applyVBox.setMinWidth(this.minWidth * 0.88);
		applyVBox.setMaxWidth(this.minWidth * 0.88);
		applyVBox.setStyle(applyVBoxStyle);
		applyVBox.setAlignment(Pos.CENTER);
		applyVBox.setSpacing(10);
		applyVBox.setPadding(new Insets(0, 0, 20, 0));
		

		HBox applyTitle = new HBox();
		applyTitle.setAlignment(Pos.CENTER_LEFT);
		Text applyTitleText = new Text("其他申请");
		applyTitleText.setFill(Color.WHITE);
		applyTitleText.setStyle("-fx-font-size:16px;");
		String applyIconStyle = "-fx-background-color:rgba(0,0,0,0);";
		String applyIconHoverStyle = "-fx-background-color:rgba(0,0,0,0);";
		Button applyIcon = FontawesomeWithJavaFX.createGlyphButton("pencil", "", 3, Color.WHITE, Color.WHITE,
				Color.WHITE, applyIconStyle, applyIconHoverStyle);
		applyTitle.getChildren().addAll(applyIcon, applyTitleText);


		VBox applyContentVBox = new VBox();		
		applyContentVBox.setSpacing(5);
		TextArea applyTextArea = new TextArea();
		applyTextArea.setMaxSize(this.minWidth*0.88*0.9, this.minWidth*0.30);
		applyTextArea.setStyle("-fx-background-color:rgba(255,255,255,0.55);");
		applyTextArea.setPromptText("请输入申请内容...");
		applyContentVBox.setAlignment(Pos.CENTER);
		Button applyBtn = new Button("确认提交");
		applyBtn.setAlignment(Pos.CENTER);
		applyBtn.setCursor(Cursor.HAND);
		applyBtn.setStyle("-fx-background-color:#3A98CE;-fx-text-fill: white;-fx-font-size:16px");
		applyBtn.setMinSize(this.minWidth * 0.88*0.9, 30);
		applyContentVBox.setSpacing(15);
		applyContentVBox.getChildren().addAll(applyTextArea,applyBtn);
				
		applyBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String applycontent = applyTextArea.getText();
				if(applycontent.trim().equals("")){
					Session.alert("申请内容不能为空", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
					return;
				}else{
					boolean res = Session.sendOtherApply(applycontent);
					if(res){
						Session.alert("申请提交成功", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
						applyTextArea.setText("");
				        String sucmsg = "管理员已收到您的申请";
				        String errmsg = "网络错误，管理员没有收到您的申请";
				        String content= ( applycontent + "<p>请管理员尽快回复申请。</p>");
						boolean isEmail = Session.sendemailtoadminforapp(content);
		        		Session.alert(isEmail?sucmsg:errmsg, "-fx-font-size:16px;-fx-fill:white;", primaryStage);

					}else{
						Session.alert("申请提交失败，请重试一次", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
					}
				}
			}
		});


		applyVBox.getChildren().addAll(applyTitle, applyContentVBox);		
		
		
		// 值班申请
		VBox dutyapplyVBox = new VBox();		
		String dutyapplyVBoxStyle = "-fx-background-color:rgba(0,0,0,0.85);";
		dutyapplyVBox.setMinWidth(this.minWidth * 0.88);
		dutyapplyVBox.setMaxWidth(this.minWidth * 0.88);
		dutyapplyVBox.setStyle(dutyapplyVBoxStyle);
		dutyapplyVBox.setAlignment(Pos.CENTER);
		dutyapplyVBox.setSpacing(10);
		dutyapplyVBox.setPadding(new Insets(0, 0, 20, 0));
		

		HBox dutyapplyTitle = new HBox();
		dutyapplyTitle.setAlignment(Pos.CENTER_LEFT);
		Text dutyapplyTitleText = new Text("值班请假");
		dutyapplyTitleText.setFill(Color.WHITE);
		dutyapplyTitleText.setStyle("-fx-font-size:16px;");
		String dutyapplyIconStyle = "-fx-background-color:rgba(0,0,0,0);";
		String dutyapplyIconHoverStyle = "-fx-background-color:rgba(0,0,0,0);";
		Button dutyapplyIcon = FontawesomeWithJavaFX.createGlyphButton("pencil", "", 3, Color.WHITE, Color.WHITE,
				Color.WHITE, dutyapplyIconStyle, dutyapplyIconHoverStyle);
		dutyapplyTitle.getChildren().addAll(dutyapplyIcon, dutyapplyTitleText);


		VBox dutyapplyContentVBox = new VBox();
		dutyapplyContentVBox.setAlignment(Pos.CENTER_LEFT);
		dutyapplyContentVBox.setPadding(new Insets(0,10,0,10));
		Text labelText1 = new Text("请假时间：");
		labelText1.setFill(Color.WHITE);
		labelText1.setStyle("-fx-font-size:14px;"); 
        Text labelText2 = new Text("请假课节：");
		labelText2.setFill(Color.WHITE);
		labelText2.setStyle("-fx-font-size:14px;");
		Text labelText3 = new Text("补假时间：");
		labelText3.setFill(Color.WHITE);
		labelText3.setStyle("-fx-font-size:14px;");
		Text labelText4 = new Text("补假课节：");
		labelText4.setFill(Color.WHITE);
		labelText4.setStyle("-fx-font-size:14px;");
		Text labelText5 = new Text("请假原因：");
		labelText5.setFill(Color.WHITE);
		labelText5.setStyle("-fx-font-size:14px;");
		DatePicker checkInDatePicker1 = new DatePicker();
		String pattern = "yyyy-MM-dd";
        @SuppressWarnings("rawtypes")
		StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = 
                DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };             
        checkInDatePicker1.setConverter(converter);
        checkInDatePicker1.setPromptText(pattern.toLowerCase());	
        checkInDatePicker1.setMaxWidth(this.minWidth*0.85);
        checkInDatePicker1.setMinWidth(this.minWidth*0.85);
        checkInDatePicker1.setMinHeight(30);
        checkInDatePicker1.setMaxHeight(30);
        checkInDatePicker1.setStyle("-fx-background-color:black;-fx-base:rgba(0,0,0,0.55);");
        
		DatePicker checkInDatePicker2 = new DatePicker();            
        checkInDatePicker2.setConverter(converter);
        checkInDatePicker2.setPromptText(pattern.toLowerCase());	
        checkInDatePicker2.setMaxWidth(this.minWidth*0.85);
        checkInDatePicker2.setMinWidth(this.minWidth*0.85);
        checkInDatePicker2.setMinHeight(30);
        checkInDatePicker2.setMaxHeight(30);
        checkInDatePicker2.setStyle("-fx-background-color:black;-fx-base:rgba(0,0,0,0.55);");
		
		ObservableList<Integer> item = FXCollections.observableArrayList(1,2,3,4);
		ChoiceBox<Integer> appclass = new ChoiceBox<Integer>(item);		
		ChoiceBox<Integer> appfixclass = new ChoiceBox<Integer>(item);	
		appclass.setValue(0);
		appclass.setTooltip(new Tooltip("请选择"));
		appclass.setMaxSize(this.minWidth*0.85, 30);
		appclass.setMinSize(this.minWidth*0.85, 30);
		appclass.setCursor(Cursor.HAND);
		appclass.setStyle("-fx-background-color:rgba(255,255,255,0.75);");		

		appfixclass.setValue(0);
		appfixclass.setTooltip(new Tooltip("请选择"));
		appfixclass.setMaxSize(this.minWidth * 0.85, 30);
		appfixclass.setMinSize(this.minWidth * 0.85, 30);
		appfixclass.setCursor(Cursor.HAND);
		appfixclass.setStyle("-fx-background-color:rgba(255,255,255,0.75);");
		Button dutyapplyBtn = new Button("确认提交");
		dutyapplyBtn.setAlignment(Pos.CENTER);
		dutyapplyBtn.setCursor(Cursor.HAND);
		dutyapplyBtn.setStyle("-fx-background-color:#3A98CE;-fx-text-fill: white;-fx-font-size:16px");
		dutyapplyBtn.setMinSize(this.minWidth * 0.85, 30);
		dutyapplyContentVBox.setSpacing(5);
		javafx.scene.control.TextField reasonText = new javafx.scene.control.TextField();
		reasonText.setStyle("-fx-background-color:black;");
		reasonText.setMaxSize(this.minWidth*0.85, 30);
		reasonText.setMinSize(this.minWidth*0.85, 30);
		VBox reasonBox = new VBox();
		reasonBox.getChildren().addAll(labelText5,reasonText);
		
		dutyapplyContentVBox.getChildren().addAll(reasonBox,labelText1,checkInDatePicker1,labelText2,appclass,labelText3,checkInDatePicker2,labelText4,appfixclass,new Text("  "),dutyapplyBtn);
				
		dutyapplyBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					boolean isNull = checkInDatePicker1.getValue() == null || checkInDatePicker2.getValue() == null || reasonText.getText() == null;
					if(!isNull){
						String reasonContent = reasonText.getText();
						String apptime = checkInDatePicker1.getValue().toString();
						String appfixtime = checkInDatePicker2.getValue().toString();
						int appclasss = appclass.getValue();
						int aapfixclasss = appfixclass.getValue();						
						if(reasonContent.equals("") || apptime.equals("") || appfixtime.equals("") || appclasss == 0 || aapfixclasss == 0){
							Session.alert("请将信息填写完整", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
							return;
						}else{
							boolean res = Session.sendDutyApply(reasonContent, apptime, appfixtime, appclasss, aapfixclasss);
							if(res){
								Session.alert("申请提交成功", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
								reasonText.setText("");								
						        String sucmsg = "管理员已收到您的申请";
						        String errmsg = "网络错误，管理员没有收到您的申请";
						        String content= ("请假原因：" + reasonContent + "<br/>" +
			                            "请假时间：" + apptime + "<br/>" +
			                            "请假课节：" + appclasss + "<br/>" +
			                            "补值班时间：" + appfixtime + "<br/>" +
			                            "补值班课节：" + aapfixclasss + "<p>请管理员尽快回复申请。</p>");
						        boolean isEmail = Session.sendemailtoadminforapp(content);
								Session.alert(isEmail?sucmsg:errmsg, "-fx-font-size:16px;-fx-fill:white;", primaryStage);
						        
							}else{
								Session.alert("申请提交失败，请重试一次", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
							}
						}						
						
					}else{
						Session.alert("请将信息填写完整", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
						return;						
					}
					
				} catch (NullPointerException e) {
					Session.alert("请将信息填写完整", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
					return;
				}
			}
		});

		dutyapplyVBox.getChildren().addAll(dutyapplyTitle, dutyapplyContentVBox);		
		
		applyScrollPaneVbox.getChildren().addAll(dutyapplyVBox, applyVBox);
		applyScrollPane.setContent(applyScrollPaneVbox);
		applyScrollPane.setStyle("-fx-background-color: transparent;-fx-control-inner-background: transparent;");

		return applyScrollPane;
	}
	
	public void refreshApplyPane(GridPane body, Stage primaryStage) {
		body.getChildren().remove(0);
		ScrollPane newScrollPane = setApplyScrollPane(body, primaryStage);
		body.add(newScrollPane, 0, 0);
	}	
	
	
	
	public void refreshSignRecordPane(GridPane body) {
		body.getChildren().remove(0);
		VBox newScrollPane = setSignRecordScrollPane();
		body.add(newScrollPane, 0, 0);
	}

	public void refreshIndexPane(GridPane body) {
		body.getChildren().remove(0);
		ScrollPane newScrollPane = setIndexScrollPane();
		body.add(newScrollPane, 0, 0);
	}

	public void refreshSignPane(GridPane body, Stage primaryStage) {
		body.getChildren().remove(0);
		ScrollPane newScrollPane = setSignScrollPane(Session.isOnline(), body, primaryStage);
		body.add(newScrollPane, 0, 0);
	}

	public void refreshDynamicPane(GridPane body, Stage primaryStage) {
		body.getChildren().remove(0);
		ScrollPane newScrollPane = setDynamicScrollPane(body, primaryStage);
		body.add(newScrollPane, 0, 0);
	}

	public void signIn(String reason, GridPane body, Stage primaryStage) {
		JSONObject res = Session.signIn(reason);
		Session.alert(res.getString("msg"), "-fx-font-size:16px;-fx-fill:white;", primaryStage);
		if ((reason.equals("值班") || reason.equals("补值班")) && res.getBooleanValue("status")) {
			boolean isduty = Session.addDutyRecord();
			Session.alert(isduty ? "已添加值班标记" : "添加值班标记失败", "-fx-font-size:16px;-fx-fill:white;", primaryStage);
		}
		refreshSignPane(body, primaryStage);
	}

	public void signOut(String ifkey, GridPane body, Stage primaryStage) {
		JSONObject res = Session.signOut(ifkey);
		Session.alert(res.getString("msg"), "-fx-font-size:16px;-fx-fill:white;", primaryStage);
		refreshSignPane(body, primaryStage);
	}

	public void launch() {
		Application.launch();
	}
}
