package cn.com.youngon.view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


import com.alibaba.fastjson.JSONObject;
import cn.com.youngon.entity.Users;
import cn.com.youngon.i.Login;
import cn.com.youngon.util.EncrypAES;
import cn.com.youngon.util.FileOperation;
import cn.com.youngon.util.Session;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginView extends Application{

	private String title = "iYoungon 签到系统";
	//标题
	
	private Image logo;
	//LOGO
	
	public TextField stuid;
	//输入学号	
	
	public PasswordField passwordField;
	//输入密码
	
	private Button login;
	//登录按钮
	
	private Button register;
	//注册按钮
	
	private double maxWidth = 428;
	//窗体最大宽度
	
	private double maxHeight = 350;
	//窗体最大高度	
	
	private String encodeRules = "iYoungon2019";
	//加密规则
	
	private final Text actiontarget = new Text();
	
	public LoginView() {
		super();
	}

    public void start(Stage primaryStage) {
    	
    	primaryStage.initStyle(StageStyle.TRANSPARENT);
    	//隐藏默认标题栏
    	
    	primaryStage.getIcons().add(new Image(Session.iconUrl));
    	//设置ICON
    	
        primaryStage.setTitle(this.title);
        //设置标题（被隐藏）

        GridPane grid = new GridPane();
        //整体容器
        
        GridPane bodyGrid = new GridPane();
        //主体容器
        
        grid.setHgap(10);
        grid.setVgap(10);
        bodyGrid.setHgap(10);
        bodyGrid.setVgap(10);
        grid.setGridLinesVisible(false);
        bodyGrid.setGridLinesVisible(false);
        //网格布局
        
        TitleBar titleBar = new TitleBar(this.title, "https://pub.wangxuefeng.com.cn/asset/youngon_logo/icon.png", 225, this.maxWidth, this.maxWidth);        
        //设置标题栏
        
        titleBar.setTitleStyle("-fx-background-color:rgba(255,255,255,0.25)");
        //标题背景为透明
        
        HBox titleBarBox = titleBar.setTitleBar(primaryStage);        
        titleBarBox.setPadding(new Insets(0,2,0,2));       
        grid.add(titleBarBox, 0, 0);
        //添加标题栏到整体容器中
        
        grid.setAlignment(Pos.CENTER);
        bodyGrid.setAlignment(Pos.CENTER);
        //居中
        
        ImageView logoImg = new ImageView();
        this.logo = new Image("https://pub.wangxuefeng.com.cn/asset/youngon_logo/logo-blue-small.png", 270, 112, false, false);
        logoImg.setImage(this.logo);
        bodyGrid.add(logoImg, 1, 1);
        //设置LOGO图片
        
        HBox titleBox = new HBox();
        //设置标题容器
        
        Text scenetitle = new Text(this.title);
        //设置标题
        
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));        
        scenetitle.setFill(Color.DEEPSKYBLUE);
        //标题样式  
        
        titleBox.setAlignment(Pos.CENTER);
        //标题居中
        
        titleBox.getChildren().add(scenetitle);
        //装载标题到容器
        
        bodyGrid.add(titleBox, 1, 2, 1, 1);
        //装载标题容器到网格
        
        Label userName = new Label("学号:");
        this.stuid = new TextField();
        this.stuid.setStyle("-fx-background-color:rgba(255,255,255,0.45)");
        this.stuid.setPromptText("请输入学号");
        this.stuid.setFocusTraversable(false);
        this.stuid.setMinHeight(30);
        bodyGrid.add(userName, 0, 3);        
        bodyGrid.add(this.stuid, 1, 3);
        //设置学号输入框

        Label pw = new Label("密码:");
        this.passwordField = new PasswordField();
        this.passwordField.setStyle("-fx-background-color:rgba(255,255,255,0.45)");
        this.passwordField.setPromptText("请输入密码");
        this.passwordField.setFocusTraversable(false);
        this.passwordField.setMinHeight(30);
        bodyGrid.add(pw, 0, 4);        
        bodyGrid.add(this.passwordField, 1, 4); 
        //设置密码输入框

        FileOperation readFile = new FileOperation("Userconfig.json");
        //读取本地配置文件中的用户名和密码
        try {
        	String reString  = readFile.readByBufferedReader();        	
            if(!(reString.equals("[文件初始化]") ||reString.equals("文件不存在") || reString.equals("读取文件出错") || reString.equals("") || reString == null)){
            	JSONObject userConfig = JSONObject.parseObject(reString);          
    			String stuidStr = EncrypAES.AESDecode(encodeRules, userConfig.getString("stuid"));
    			String PassTStr = EncrypAES.AESDecode(encodeRules, userConfig.getString("password"));
            	this.stuid.setText(stuidStr);
            	this.passwordField.setText(PassTStr);
            	this.stuid.setFocusTraversable(true);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        this.login = new Button("登录");
        this.register = new Button("注册");
        this.login.setStyle("-fx-background-color:#3A98CE;");
        this.register.setStyle("-fx-background-color:#3A98CE;");
        this.login.setCursor(Cursor.HAND);        
        this.register.setCursor(Cursor.HAND);
        this.login.setMinSize(155, 30);
        this.register.setMinSize(155, 30);
        this.login.setTextFill(Color.WHITE);
        this.register.setTextFill(Color.WHITE);
        hbBtn.getChildren().addAll(this.login, this.register);
        bodyGrid.add(hbBtn, 1, 5);
        //设置按钮及其样式
        
        
        bodyGrid.add(actiontarget, 1, 6);
        
        grid.add(bodyGrid, 0, 1);
        grid.setMaxSize(this.maxWidth, this.maxHeight);
        grid.setStyle("-fx-background-color:#EEEEEE;");
        grid.setStyle("-fx-border-color:gray;-fx-border-width:0.6px;-fx-border-radius:5px;-fx-background-image:url('https://pub.wangxuefeng.com.cn/asset/img/zhezhi-small.jpg');-fx-background-size:cover;-fx-background-repeat:no-repeat;");
        
        this.login.setOnAction(new EventHandler<ActionEvent>() {
        	//设置登录事件
			@Override
            public void handle(ActionEvent e) {
				loginHandel(primaryStage);
            }
        });
        
        this.stuid.setOnKeyPressed(new EventHandler<KeyEvent>() {        	  
            @Override  
            public void handle(KeyEvent event) {                
                if (event.getCode() == KeyCode.ENTER) {
                	loginHandel(primaryStage);
                }                
                if (event.getCode() == KeyCode.TAB) {
                	passwordField.setFocusTraversable(true);                	
                }                
            }  
        });
        //监听学号输入框键盘enter键登录和输入切换

        this.passwordField.setOnKeyPressed(new EventHandler<KeyEvent>() {        	  
            @Override  
            public void handle(KeyEvent event) {                
                if (event.getCode() == KeyCode.ENTER) {
                	loginHandel(primaryStage);
                }
                if (event.getCode() == KeyCode.TAB) {
                	stuid.setFocusTraversable(true);
                }
            }  
        });
      //监听密码框键盘enter键登录和输入切换
        
        this.register.setOnAction(new EventHandler<ActionEvent>() {
        	//设置注册事件
            @Override
            public void handle(ActionEvent e) {
                try {  
                    URI uri = new URI("https://sign.youngon.com.cn/#/register");  
                    Desktop.getDesktop().browse(uri);  
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();  
                } catch (IOException e1) {
                    e1.printStackTrace();  
                }           	                
            }
        });
        
        Scene scene = new Scene(grid, this.maxWidth, this.maxHeight);
        scene.setFill(Color.TRANSPARENT);        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);        
        primaryStage.show();
    }

    public void loginHandel(Stage primaryStage) {
        actiontarget.setFill(Color.FIREBRICK);
        String Stuid = stuid.getText();
        String Pass = passwordField.getText();
        if(!Session.isNumeric(Stuid)){
        	actiontarget.setText("学号必须为数字");
        	return;
        }
        if(Stuid.equals("") || Stuid.equals(null)){
        	actiontarget.setText("学号不能为空");
        	return;
        } else if(Pass.equals("") || Pass.equals(null)){
        	actiontarget.setText("密码不能为空");
        	return;
        } else {
        	actiontarget.setFill(Color.BLUE);
        	actiontarget.setText("正在登录中...");
    		Login login = new Login(Long.parseLong(Stuid), Pass, false);
    		Object res = login.login();
    		if(login.isLogined()){
    			Session.curUser = (Users)res;
    			actiontarget.setText("登录成功");
    			FileOperation writeFile = new FileOperation("Userconfig.json");    			
    			String secertStuid = EncrypAES.AESEncode(encodeRules, Stuid);
    			String secertPass = EncrypAES.AESEncode(encodeRules, Pass);
    			String content = "{\"stuid\":\"" + secertStuid + "\",\"password\":\""+ secertPass + "\"}";
    			writeFile.writeToMyFiles(content);
    			//将用户名和密码加密存储到本地配置文件
    			primaryStage.close();
    			IndexView indexView = new IndexView(title);    			
    			try {
					indexView.start(new Stage());
				} catch (Exception e) {					
					e.printStackTrace();
				}
    			
    		}else{
    			@SuppressWarnings("unchecked")
				Map<String, String> warn =(HashMap<String, String>)res;
    			actiontarget.setFill(Color.FIREBRICK);
    			actiontarget.setText(warn.get("warnTitle"));
    			System.out.println(warn.get("warnMsg"));
    		}

        }     	
    }
    
    public void launch(){
    	Application.launch();
    }

}
