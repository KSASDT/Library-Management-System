package ui.ListBook;


import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class BookListLoader extends Application{

	public void start(Stage primaryStage) {
		try {
			
			@SuppressWarnings("deprecation")
			java.net.URL url = new File("E:\\spoj\\LL\\src\\ui\\ListBook\\Listbook.fxml").toURL();
		     Parent root = FXMLLoader.load(url);

		     //		 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("E:\\spoj\\LL\\src\\ui\\addBook"));
			
		     Scene scene = new Scene(root);
			
		     // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
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
