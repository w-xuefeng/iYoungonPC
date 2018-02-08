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
	//����
	
	private String iconUrl;
	//icon
	
	private double xOffset = 0;
	//��������
	
	private double yOffset = 0;
	//���������
	
	private double spaceing;
	//�����밴ť֮��ļ��
	
	private double minWidth;
	
	private double maxWidth;
	
	private Color titleColor = Color.BLACK;
	//������ɫ
	
	private String titleStyle = "-fx-background-color:rgba(255, 255, 255, 0.45)";
	//���ⱳ��
	
	private String minButtonStyle = "-fx-base: rgb(243,243,243); -fx-border-color: rgb(243,243,243); -fx-border-width: 0.1; "
	    	+ "-fx-max-height: infinity;-fx-text-fill: white ; -fx-border-image-insets: 0;";
	//��С����ť������ɫ
	
	private String closeButtonStyle = "-fx-base: rgb(255,128,128); -fx-border-color: rgb(243,243,243); -fx-border-width: 0.1; "
	    	+ "-fx-max-height: infinity;-fx-text-fill: white ; -fx-border-image-insets: 0;";
	//�رհ�ť������ɫ

	

	
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
		
    	Button minButton = new Button("��");
    	//�Զ����������ť��С��
    	
    	Button closeButton = new Button("��");
    	//�Զ����������ť�ر�
    	
    	minButton.setStyle(this.minButtonStyle);
    	
    	closeButton.setStyle(this.closeButtonStyle);
    	//������ʽ
  	
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
    	//������С����ť�¼�
    	
    	closeButton.setOnAction(new EventHandler<ActionEvent>() {	
	    	@Override
	    	public void handle(ActionEvent event) {
	    		primaryStage.close();
	    	}
    	});
    	//������رհ�ť�¼�
    	
        primaryStage.setTitle(this.title);
        //���ñ��⣨���ܱ����أ�

      
        HBox menu = new HBox();
        //�Զ������������
        
        menu.setAlignment(Pos.CENTER_LEFT);
        //���¾��У������
        
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
        //�Զ��崰���ƶ��¼�
        
        HBox buttonbox = new HBox();
        //��ť����
        
        buttonbox.setAlignment(Pos.CENTER_RIGHT);
        //��ť�Ҷ���
        
        buttonbox.getChildren().addAll(minButton, closeButton);
        //װ�ذ�ť 
        
        buttonbox.setSpacing(2);
        //���ð�ť��϶
        
        HBox icontitle = new HBox();
        //icon����
        ImageView logoIcon = new ImageView();
        Image icon = new Image(this.iconUrl, 30, 30, false, false);
        logoIcon.setImage(icon);
        Text titleText = new Text(this.title);
        titleText.setFill(this.titleColor);
        icontitle.getChildren().addAll(logoIcon, titleText);
        icontitle.setAlignment(Pos.CENTER_LEFT);
        //����ICON
        
        menu.getChildren().addAll(icontitle, buttonbox);
        //������װ��icon�����Ͱ�ť����
        
        menu.setSpacing(this.spaceing);
        //���ü��
        
        menu.setStyle(this.titleStyle);
        
        return menu;
        
	}

}
