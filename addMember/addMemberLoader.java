package ui.addMember;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class addMemberLoader extends  Application{
	public void start(Stage primaryStage) {
	try {
		
			
		@SuppressWarnings("deprecation")
		java.net.URL url = new File("E:\\spoj\\LL\\src\\ui\\addMember\\addlog.fxml").toURL();
	     Parent root = FXMLLoader.load(url);
		//Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("E:\\spoj\\LL\\src\\ui\\addBook\\newbook.fxml"));
		
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
