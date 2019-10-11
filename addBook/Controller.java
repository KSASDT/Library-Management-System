package ui.addBook;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import LL.database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ui.ListBook.ListBookController;

	public class Controller implements Initializable  {

	    @FXML
	    private TextField bt;

	    @FXML
	    private TextField bid;

	    @FXML
	    private TextField bthor;

	    @FXML
	    private TextField bpub;

	    @FXML
	    private HBox booksve;

	    @FXML
	    private Button bsve;

	    @FXML
	    private Button bookcncel;
	    

	    @FXML
	    private AnchorPane rootPne;
	    
	    DatabaseHandler databaseHandler;
	    private Boolean isInEditMode = Boolean.FALSE;
	    
	    
	   public void initialize(URL url, ResourceBundle rb){
	    	databaseHandler = DatabaseHandler.getInstance();
	    	checkData();
	    }

	    @FXML
	    void coolBook(ActionEvent event) {
	    	String bookID = bid.getText();
	    	String bookTitle = bt.getText();
	    	String bookAuthor = bthor.getText();
	    	String bookPublisher = bpub.getText();
	    	
	    	if(bookID.isEmpty() || bookAuthor.isEmpty() || bookTitle.isEmpty() || bookPublisher.isEmpty()){
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setHeaderText(null);
	    		alert.setContentText("Please enter in all fields");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	 if (isInEditMode) {
	             handleEditOperation();
	             return;
	         }
	    	 
	    	 
	    /*	stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
	    	    	+ "   id varchar(200) primary key, \n"
	    			+ "   title varchar(200), \n"
	    		    + "   author varchar(200), \n"
	    			+ "   publisher varchar(100), \n"
	    			+ "   intcode varchar(100), \n"
	    			+ "   isAvail boolean default true"
	    			+ ")");  */
	    	
	    	String uery = "INSERT INTO BOOK(title,id,author,publisher, isAvail) VALUES("+
	    		 "'"  + bookTitle + "'," + 
	    		 "'"  + bookID + "', "+
	    		 "'"  + bookAuthor + "',"+
	    		 "'"  + bookPublisher + "'," +
	    		 ""	  +  true + ""+ 
	    			")";
	    			
	    	System.out.println(uery);
	    	if(databaseHandler.execAction(uery))
	    	{
	    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    		alert.setHeaderText(null);
	    		alert.setContentText("Success");
	    		alert.showAndWait();
	    		
	    	} else //error msg
	    	{
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setHeaderText(null);
	    		alert.setContentText("failed");
	    		alert.showAndWait();
	    	}

	    }

	    @FXML
	    void endBook(ActionEvent event) {
	    	Stage stage = (Stage) rootPne.getScene().getWindow();
            stage.close();
	    }

	    public void inflateUI(ListBookController.Book book) {
	        bt.setText(book.getTitle());
	        bid.setText(book.getId());
	        bthor.setText(book.getAuthor());
	        bpub.setText(book.getPublisher());
	        bid.setEditable(false);
	        isInEditMode = Boolean.TRUE;
	    }
	    
	    private void handleEditOperation() {
	        ListBookController.Book book = new ListBookController.Book(bt.getText(), bid.getText(), bthor.getText(), bpub.getText(), true);
	        if (databaseHandler.updateBook(book)) {
	            LL.alert.AlertMaker.showSimpleAlert( "Success", "Update complete");
	        } else {
	            LL.alert.AlertMaker.showSimpleAlert("Failed", "Could not update data");
	        }
	    } 
	    
		private void checkData(){
			
			String query = "SELECT title FROM BOOK";
			ResultSet rs = databaseHandler.execQuery(query);
		    try{
		    	while(rs.next()){
		    		String titlex = rs.getString("title");
		    		System.out.println(titlex);
		    	}
		    } catch(SQLException ex){
		    	Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null , ex);
		    }
		    
		}

	}


