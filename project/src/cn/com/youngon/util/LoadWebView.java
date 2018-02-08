package cn.com.youngon.util;

import java.net.URI;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class LoadWebView extends Application {
	private Scene scene;
	private URI url;
	private String htmlString = "<p>Ä¬ÈÏ×Ö·û´®</p>";
	private String title;
	private GridPane parentGridpane;

	public LoadWebView(URI url, String title, GridPane parentGridpane) {
		super();
		this.url = url;
		this.title = title;
		this.parentGridpane = parentGridpane;
	}

	public LoadWebView(String htmlString, String title, GridPane parentGridpane) {
		super();
		this.htmlString = htmlString;
		this.title = title;
		this.parentGridpane = parentGridpane;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public URI getUrl() {
		return url;
	}

	public void setUrl(URI url) {
		this.url = url;
	}

	public String getHtmlString() {
		return htmlString;
	}

	public void setHtmlString(String htmlString) {
		this.htmlString = htmlString;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public GridPane getParentGridpane() {
		return parentGridpane;
	}

	public void setParentGridpane(GridPane parentGridpane) {
		this.parentGridpane = parentGridpane;
	}

	@Override
	public void start(Stage stage) {
		// create the scene
		if (this.htmlString.equals("<p>Ä¬ÈÏ×Ö·û´®</p>")) {
			stage.setTitle(this.title);
			scene = new Scene(new Browser(this.url), 900, 600, Color.WHITE);
			stage.setScene(scene);
			stage.show();
		} else {
			this.parentGridpane.add(new Browser(this.htmlString), 0, 0);
		}

	}

	public void launch() {
		Application.launch();
	}
}

class Browser extends Region {

	public WebView browser = new WebView();
	public WebEngine webEngine = browser.getEngine();
	private URI url;
	private String htmlString;

	public Browser(URI url) {
		this.url = url;
		getStyleClass().add("browser");
		webEngine.load(this.url.toString());
		getChildren().add(browser);
	}

	public Browser(String htmlString) {
		this.htmlString = htmlString;
		getStyleClass().add("browser");
		webEngine.loadContent(this.htmlString);
		getChildren().add(browser);
	}

	@Override
	protected void layoutChildren() {
		double w = getWidth();
		double h = getHeight();
		layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
	}

	@Override
	protected double computePrefWidth(double height) {
		return 900;
	}

	@Override
	protected double computePrefHeight(double width) {
		return 600;
	}
}