package cn.com.youngon.util;

import java.util.ArrayList;
import cn.com.youngon.entity.SignRecord;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GetWeekSignRecord implements Runnable {
	private Thread t;
	private int order;
	private double minWidth;
	private VBox cuWeeklist;
	private ArrayList<SignRecord> curWeekList;

	
	public GetWeekSignRecord(int order,VBox cuWeeklist,ArrayList<SignRecord> curWeekList) {
		this.order = order;
		this.minWidth = Session.GetScreenSize().get("width")*0.26;
		this.cuWeeklist = cuWeeklist;
		this.curWeekList = curWeekList;
	}

	public void run() {		
		try {
			setSignRecordScrollPane(cuWeeklist,curWeekList);
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, "id" + this.order);
			t.start();
		}
	}
	
    public void setSignRecordScrollPane(VBox cuWeeklist, ArrayList<SignRecord> curWeekList){
	    HBox curWeekUserContentHBox =new HBox();
	    VBox  curWeekUserVBox = new VBox();
	    curWeekUserContentHBox.setPadding(new Insets(2,15,2,15));
	    
	    ImageView cureekUserHead = Session.setImgView(curWeekList.get(this.order).getHead(), minWidth*0.88*0.18, minWidth*0.88*0.18, minWidth*0.88*0.18, minWidth*0.88*0.18);
	    cureekUserHead.setCursor(Cursor.HAND);
	    
	    Text curUsername = new Text(curWeekList.get(this.order).getName());
	    curUsername.setStyle("-fx-font-size:14px;");
	    curUsername.setFill(Color.WHITE);
	    Text curUserentertime = new Text(curWeekList.get(this.order).getEntertime());
	    curUserentertime.setStyle("-fx-font-size:10px;");
	    curUserentertime.setFill(Color.GRAY);
	    
	    curWeekUserVBox.setAlignment(Pos.CENTER_LEFT);           
	    curWeekUserVBox.setMinWidth(minWidth*0.88*0.42);
	    curWeekUserVBox.getChildren().addAll(curUsername,curUserentertime);   
	    
	    Text curUserReason = new Text(curWeekList.get(this.order).getReason());
	    curUserReason.setStyle("-fx-font-size:14px;");
	    curUserReason.setFill(Color.WHITE);
	    HBox curUserReasonHBox = new HBox();
	    curUserReasonHBox.setAlignment(Pos.CENTER_RIGHT);
	    curUserReasonHBox.getChildren().add(curUserReason);
	    
	    curWeekUserContentHBox.setSpacing(10);
	    curWeekUserContentHBox.setCursor(Cursor.HAND);
	    curWeekUserContentHBox.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				curWeekUserContentHBox.setStyle("-fx-background-color:rgba(255,255,255,0.75)");
				curUsername.setFill(Color.BLACK);
				curUserentertime.setFill(Color.BLACK);
				curUserReason.setFill(Color.BLACK);
			}
		});
	
	    curWeekUserContentHBox.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				curWeekUserContentHBox.setStyle("-fx-background-color:rgba(0,0,0,0)");
				curUsername.setFill(Color.WHITE);
				curUserentertime.setFill(Color.GRAY);
				curUserReason.setFill(Color.WHITE);
			}
	    	
		});
	    curWeekUserContentHBox.getChildren().addAll(cureekUserHead,curWeekUserVBox,curUserReasonHBox);
		Platform.runLater(new Runnable() {
			public void run() {
				 cuWeeklist.getChildren().add(curWeekUserContentHBox);
			}
		});
	   
	}	
}