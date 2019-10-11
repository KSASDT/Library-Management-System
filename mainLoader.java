package ui.main;

import java.io.File;

import LL.database.DatabaseHandler;
import LL.util.LibUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class mainLoader extends Application {

	public void start(Stage primaryStage)  {
		try {
			
			@SuppressWarnings("deprecation")
			java.net.URL url = new File("E:\\spoj\\LL\\src\\ui\\Login\\login_login.fxml").toURL();
		    Parent root = FXMLLoader.load(url);
		    Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Library Assistant Login");
			LibUtil.setStageIcon(primaryStage);
			
			new Thread(()->{
				DatabaseHandler.getInstance();
			}).start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
