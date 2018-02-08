package cn.com.youngon.util;


import java.awt.Window;
import javafx.stage.Stage;

public class StageToAwtWin {
	public Window win;
	public Stage stage;
	
	public StageToAwtWin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StageToAwtWin(Window win, Stage stage) {
		super();
		this.win = win;
		this.stage = stage;
	}

	public Window getWin() {
		return win;
	}

	public void setWin(Window win) {
		this.win = win;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public Window stageToAwtWin(){		
		return this.win;
	}
	

}
