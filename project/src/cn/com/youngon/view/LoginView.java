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

	private String title = "iYoungon ǩ��ϵͳ";
	//����
	
	private Image logo;
	//LOGO
	
	public TextField stuid;
	//����ѧ��	
	
	public PasswordField passwordField;
	//��������
	
	private Button login;
	//��¼��ť
	
	private Button register;
	//ע�ᰴť
	
	private double maxWidth = 428;
	//���������
	
	private double maxHeight = 350;
	//�������߶�	
	
	private String encodeRules = "iYoungon2019";
	//���ܹ���
	
	private final Text actiontarget = new Text();
	
	public LoginView() {
		super();
	}

    public void start(Stage primaryStage) {
    	
    	primaryStage.initStyle(StageStyle.TRANSPARENT);
    	//����Ĭ�ϱ�����
    	
    	primaryStage.getIcons().add(new Image(Session.iconUrl));
    	//����ICON
    	
        primaryStage.setTitle(this.title);
        //���ñ��⣨�����أ�

        GridPane grid = new GridPane();
        //��������
        
        GridPane bodyGrid = new GridPane();
        //��������
        
        grid.setHgap(10);
        grid.setVgap(10);
        bodyGrid.setHgap(10);
        bodyGrid.setVgap(10);
        grid.setGridLinesVisible(false);
        bodyGrid.setGridLinesVisible(false);
        //���񲼾�
        
        TitleBar titleBar = new TitleBar(this.title, "https://pub.wangxuefeng.com.cn/asset/youngon_logo/icon.png", 225, this.maxWidth, this.maxWidth);        
        //���ñ�����
        
        titleBar.setTitleStyle("-fx-background-color:rgba(255,255,255,0.25)");
        //���ⱳ��Ϊ͸��
        
        HBox titleBarBox = titleBar.setTitleBar(primaryStage);        
        titleBarBox.setPadding(new Insets(0,2,0,2));       
        grid.add(titleBarBox, 0, 0);
        //��ӱ�����������������
        
        grid.setAlignment(Pos.CENTER);
        bodyGrid.setAlignment(Pos.CENTER);
        //����
        
        ImageView logoImg = new ImageView();
        this.logo = new Image("https://pub.wangxuefeng.com.cn/asset/youngon_logo/logo-blue-small.png", 270, 112, false, false);
        logoImg.setImage(this.logo);
        bodyGrid.add(logoImg, 1, 1);
        //����LOGOͼƬ
        
        HBox titleBox = new HBox();
        //���ñ�������
        
        Text scenetitle = new Text(this.title);
        //���ñ���
        
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));        
        scenetitle.setFill(Color.DEEPSKYBLUE);
        //������ʽ  
        
        titleBox.setAlignment(Pos.CENTER);
        //�������
        
        titleBox.getChildren().add(scenetitle);
        //װ�ر��⵽����
        
        bodyGrid.add(titleBox, 1, 2, 1, 1);
        //װ�ر�������������
        
        Label userName = new Label("ѧ��:");
        this.stuid = new TextField();
        this.stuid.setStyle("-fx-background-color:rgba(255,255,255,0.45)");
        this.stuid.setPromptText("������ѧ��");
        this.stuid.setFocusTraversable(false);
        this.stuid.setMinHeight(30);
        bodyGrid.add(userName, 0, 3);        
        bodyGrid.add(this.stuid, 1, 3);
        //����ѧ�������

        Label pw = new Label("����:");
        this.passwordField = new PasswordField();
        this.passwordField.setStyle("-fx-background-color:rgba(255,255,255,0.45)");
        this.passwordField.setPromptText("����������");
        this.passwordField.setFocusTraversable(false);
        this.passwordField.setMinHeight(30);
        bodyGrid.add(pw, 0, 4);        
        bodyGrid.add(this.passwordField, 1, 4); 
        //�������������

        FileOperation readFile = new FileOperation("Userconfig.json");
        //��ȡ���������ļ��е��û���������
        try {
        	String reString  = readFile.readByBufferedReader();        	
            if(!(reString.equals("[�ļ���ʼ��]") ||reString.equals("�ļ�������") || reString.equals("��ȡ�ļ�����") || reString.equals("") || reString == null)){
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
        this.login = new Button("��¼");
        this.register = new Button("ע��");
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
        //���ð�ť������ʽ
        
        
        bodyGrid.add(actiontarget, 1, 6);
        
        grid.add(bodyGrid, 0, 1);
        grid.setMaxSize(this.maxWidth, this.maxHeight);
        grid.setStyle("-fx-background-color:#EEEEEE;");
        grid.setStyle("-fx-border-color:gray;-fx-border-width:0.6px;-fx-border-radius:5px;-fx-background-image:url('https://pub.wangxuefeng.com.cn/asset/img/zhezhi-small.jpg');-fx-background-size:cover;-fx-background-repeat:no-repeat;");
        
        this.login.setOnAction(new EventHandler<ActionEvent>() {
        	//���õ�¼�¼�
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
        //����ѧ����������enter����¼�������л�

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
      //������������enter����¼�������л�
        
        this.register.setOnAction(new EventHandler<ActionEvent>() {
        	//����ע���¼�
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
        	actiontarget.setText("ѧ�ű���Ϊ����");
        	return;
        }
        if(Stuid.equals("") || Stuid.equals(null)){
        	actiontarget.setText("ѧ�Ų���Ϊ��");
        	return;
        } else if(Pass.equals("") || Pass.equals(null)){
        	actiontarget.setText("���벻��Ϊ��");
        	return;
        } else {
        	actiontarget.setFill(Color.BLUE);
        	actiontarget.setText("���ڵ�¼��...");
    		Login login = new Login(Long.parseLong(Stuid), Pass, false);
    		Object res = login.login();
    		if(login.isLogined()){
    			Session.curUser = (Users)res;
    			actiontarget.setText("��¼�ɹ�");
    			FileOperation writeFile = new FileOperation("Userconfig.json");    			
    			String secertStuid = EncrypAES.AESEncode(encodeRules, Stuid);
    			String secertPass = EncrypAES.AESEncode(encodeRules, Pass);
    			String content = "{\"stuid\":\"" + secertStuid + "\",\"password\":\""+ secertPass + "\"}";
    			writeFile.writeToMyFiles(content);
    			//���û�����������ܴ洢�����������ļ�
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
