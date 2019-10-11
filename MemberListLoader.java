package ui.ListMember;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MemberListLoader extends Application{

	public void start(Stage primaryStage) {
		try {
			
			@SuppressWarnings("deprecation")
			java.net.URL url = new File("E:\\spoj\\LL\\src\\ui\\ListMember\\member_list.fxml").toURL();
		    Parent root = FXMLLoader.load(url);
		    Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
