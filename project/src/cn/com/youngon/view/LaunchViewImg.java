package cn.com.youngon.view;

import cn.com.youngon.util.Session;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LaunchViewImg extends Application{
	private String imgUrl;
	private double width;
	private double height;
	private GridPane launchPane = new GridPane();
	
	public LaunchViewImg(String imgUrl, double width, double height) {
		super();
		this.imgUrl = imgUrl;
		this.width = width;
		this.height = height;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void start(Stage parentStage) throws Exception {
		Stage primaryStage = new Stage();
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setTitle("Welcome to Youngon | In Youngon,at home.");
		primaryStage.getIcons().add(new Image(Session.iconUrl));
        ImageView launchImg = new ImageView();
        Image img = new Image(this.imgUrl,this.width, this.height, false, false);
        launchImg.setImage(img);        
        this.launchPane.add(launchImg, 0, 0);
        this.launchPane.setMinSize(this.width, this.height);
        this.launchPane.setAlignment(Pos.CENTER);
        this.launchPane.setStyle("-fx-background-color:rgba(0,0,0,0.0)");       
        this.launchPane.setCursor(Cursor.HAND);        
		this.launchPane.setOnMouseClicked(new EventHandler<MouseEvent>() {        	
			@Override
            public void handle(MouseEvent e) {
				primaryStage.close();
				parentStage.show();
            }
        });		
        Scene scene = new Scene(this.launchPane, this.width, this.height);
        scene.setFill(null);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();		
	}


}
