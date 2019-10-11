package ui.addMember;

import java.net.URL;
import java.util.ResourceBundle;

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
import ui.ListMember.MemberListController.Member;

public class addMemberController implements Initializable {

	 DatabaseHandler handler;
	 
    @FXML
    private TextField name;

    @FXML
    private TextField id;

    @FXML
    private TextField mobile;

    @FXML
    private TextField email;

    @FXML
    private HBox booksve;

    @FXML
    private Button save;

    @FXML
    private Button cancel;
    

    @FXML
    private AnchorPane rootPne;
    
    private Boolean isInEditMode = false;
    
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {
		handler = DatabaseHandler.getInstance();
	}

    @FXML
    void addMember(ActionEvent event) {

    	String mName = name.getText();
    	String mID = id.getText();
    	String mMobile = mobile.getText();
    	String mEmail = email.getText();
    	
    	Boolean flag = mName.isEmpty() || mID.isEmpty() || mMobile.isEmpty() || mEmail.isEmpty();
    	
    	
    	if(flag){
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
		    alert.setContentText("Please enter in all fields");
		    alert.showAndWait();
		    return;
    	}
    	
    	  if (isInEditMode) {
              handleUpdateMember();
              return;
          }
    	  
    //	stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
    //			+ "   name varchar(200), \n"
    //			+ "   id varchar(200) primary key, \n"
    //		+ "   mobile varchar(200), \n"
    //		+ "   email varchar(100)\n"
    //		+ ")");
    
    	
    	String st = "INSERT INTO MEMBER(name,id, mobile, email) VALUES("+
	    		 "'"  + mName + "'," + 
	    		 "'"  + mID + "', "+
	    		 "'"  + mMobile + "',"+
	    		 "'"  + mEmail + "'" + 
	    			")";
    	
    	System.out.println(st);
    	if(handler.execAction(st)){
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setHeaderText(null);
		    alert.setContentText("Saved");
		    alert.showAndWait();
		   }else{
			   Alert alert = new Alert(Alert.AlertType.ERROR);
	    	    alert.setHeaderText(null);
			    alert.setContentText("ERROR occured");
			    alert.showAndWait();
			     }   
    	}
    
    public void inflateUI(ui.ListMember.MemberListController.Member member) {
        name.setText(member.getName());
        id.setText(member.getId());
        id.setEditable(false);
        mobile.setText(member.getMobile());
        email.setText(member.getEmail());

        isInEditMode = Boolean.TRUE;
    }

    @FXML
    void cancelMember(ActionEvent event) {

    	Stage stage = (Stage) rootPne.getScene().getWindow();
        stage.close();
    }

    private void handleUpdateMember() {
        Member member = new ui.ListMember.MemberListController.Member(name.getText(), id.getText(), mobile.getText(), email.getText());
        if (DatabaseHandler.getInstance().updateMember(member)) {
            LL.alert.AlertMaker.showSimpleAlert( "Success", "Member Updated");
        } else {
            LL.alert.AlertMaker.showSimpleAlert("Failed", "Could not update Member");
        }
    }

}
