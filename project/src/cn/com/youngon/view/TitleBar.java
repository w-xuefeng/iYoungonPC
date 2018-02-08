package cn.com.youngon.view;

import cn.com.youngon.util.Session;
import cn.com.youngon.util.Tray;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TitleBar {
	
	private String title;
	//标题
	
	private String iconUrl;
	//icon
	
	private double xOffset = 0;
	//鼠标横坐标
	
	private double yOffset = 0;
	//鼠标纵坐标
	
	private double spaceing;
	//标题与按钮之间的间隔
	
	private double minWidth;
	
	private double maxWidth;
	
	private Color titleColor = Color.BLACK;
	//标题颜色
	
	private String titleStyle = "-fx-background-color:rgba(255, 255, 255, 0.45)";
	//标题背景
	
	private String minButtonStyle = "-fx-base: rgb(243,243,243); -fx-border-color: rgb(243,243,243); -fx-border-width: 0.1; "
	    	+ "-fx-max-height: infinity;-fx-text-fill: white ; -fx-border-image-insets: 0;";
	//最小化按钮背景颜色
	
	private String closeButtonStyle = "-fx-base: rgb(255,128,128); -fx-border-color: rgb(243,243,243); -fx-border-width: 0.1; "
	    	+ "-fx-max-height: infinity;-fx-text-fill: white ; -fx-border-image-insets: 0;";
	//关闭按钮背景颜色

	

	
	public TitleBar() {
		super();
	}

	public TitleBar(String title, String iconUrl, double spaceing, double minWidth, double maxWidth) {
		super();
		this.title = title;
		this.iconUrl = iconUrl;
		this.spaceing = spaceing;
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
	}
	
	
	

	public TitleBar(String title, String iconUrl, double spaceing, double minWidth, double maxWidth, Color titleColor,
			String titleStyle, String minButtonStyle, String closeButtonStyle) {
		super();
		this.title = title;
		this.iconUrl = iconUrl;
		this.spaceing = spaceing;
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
		this.titleColor = titleColor;
		this.titleStyle = titleStyle;
		this.minButtonStyle = minButtonStyle;
		this.closeButtonStyle = closeButtonStyle;
	}

	
	
	public double getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(double minWidth) {
		this.minWidth = minWidth;
	}

	public double getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(double maxWidth) {
		this.maxWidth = maxWidth;
	}

	public Color getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(Color titleColor) {
		this.titleColor = titleColor;
	}
	
	public double getSpaceing() {
		return spaceing;
	}

	public void setSpaceing(double spaceing) {
		this.spaceing = spaceing;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIconUrl() {
		return iconUrl;
	}
	
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getTitleStyle() {
		return titleStyle;
	}
	
	public void setTitleStyle(String titleStyle) {
		this.titleStyle = titleStyle;
	}

	public String getMinButtonStyle() {
		return minButtonStyle;
	}

	public void setMinButtonStyle(String minButtonStyle) {
		this.minButtonStyle = minButtonStyle;
	}

	public String getCloseButtonStyle() {
		return closeButtonStyle;
	}

	public void setCloseButtonStyle(String closeButtonStyle) {
		this.closeButtonStyle = closeButtonStyle;
	}

	public HBox setTitleBar(Stage primaryStage){
		
    	Button minButton = new Button("—");
    	//自定义标题栏按钮最小化
    	
    	Button closeButton = new Button("×");
    	//自定义标题栏按钮关闭
    	
    	minButton.setStyle(this.minButtonStyle);
    	
    	closeButton.setStyle(this.closeButtonStyle);
    	//设置样式
  	
    	minButton.setFocusTraversable(false);
    	closeButton.setFocusTraversable(false);
    	
    	minButton.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
	    		//primaryStage.setIconified(true);
	    		Tray taryWindow = new Tray(primaryStage, Session.iconUrl, title);
	    		taryWindow.tray();
	    	}
    	});
    	//监听最小化按钮事件
    	
    	closeButton.setOnAction(new EventHandler<ActionEvent>() {	
	    	@Override
	    	public void handle(ActionEvent event) {
	    		primaryStage.close();
	    	}
    	});
    	//监听最关闭按钮事件
    	
        primaryStage.setTitle(this.title);
        //设置标题（可能被隐藏）

      
        HBox menu = new HBox();
        //自定义标题栏容器
        
        menu.setAlignment(Pos.CENTER_LEFT);
        //上下居中，左对齐
        
        menu.setMinWidth(this.minWidth);
        
        menu.setMaxWidth(this.maxWidth);
        
        menu.setOnMousePressed((MouseEvent event) -> {
    		event.consume();
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
        });

        menu.setOnMouseDragged((MouseEvent event) -> {
        	event.consume();
        	primaryStage.setX(event.getScreenX() - xOffset);

        	if (event.getScreenY() - yOffset < 0) {
        		primaryStage.setY(0);
        	} else {
        		primaryStage.setY(event.getScreenY() - yOffset);
        	}
        });
        //自定义窗口移动事件
        
        HBox buttonbox = new HBox();
        //按钮容器
        
        buttonbox.setAlignment(Pos.CENTER_RIGHT);
        //按钮右对齐
        
        buttonbox.getChildren().addAll(minButton, closeButton);
        //装载按钮 
        
        buttonbox.setSpacing(2);
        //设置按钮间隙
        
        HBox icontitle = new HBox();
        //icon容器
        ImageView logoIcon = new ImageView();
        Image icon = new Image(this.iconUrl, 30, 30, false, false);
        logoIcon.setImage(icon);
        Text titleText = new Text(this.title);
        titleText.setFill(this.titleColor);
        icontitle.getChildren().addAll(logoIcon, titleText);
        icontitle.setAlignment(Pos.CENTER_LEFT);
        //设置ICON
        
        menu.getChildren().addAll(icontitle, buttonbox);
        //标题栏装载icon容器和按钮容器
        
        menu.setSpacing(this.spaceing);
        //设置间距
        
        menu.setStyle(this.titleStyle);
        
        return menu;
        
	}

}
