package ui.addBook;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibraryAssistant extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		@SuppressWarnings("deprecation")
		java.net.URL url = new File("E:\\spoj\\LL\\src\\ui\\addBook\\newbook.fxml").toURL();
	     Parent root = FXMLLoader.load(url);
		//Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("E:\\spoj\\LL\\src\\ui\\addBook\\newbook.fxml"));
		
	     Scene scene = new Scene(root,400,400);
	 	// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
