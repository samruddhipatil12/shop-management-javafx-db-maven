package delete_user;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class DeleteUserScreenController {
	
	 @FXML
	 private TextField delete_user_name;
	
	 @FXML
	 private TextField user_name;
	 
	 @FXML
	 private TextField login_name;
	 
	 @FXML
	 private TextField password;
	 
	 @FXML
	 private TextField confirm_password;
	 
	 @FXML
	 private TextField user_role;
	 
	 @FXML
	 private Label usermessage;
	 
	 @FXML
	 private Button close_button;
	 
	 @FXML
	 private Button search_button;
	 
	 @FXML
	 private Button delete_button;
	 
	 public void SearchButton(ActionEvent event)throws SQLException {
		   
		   boolean searchstatus = searchUser(delete_user_name.getText());
		   
		   if(searchstatus) {
			   searchUser(null);
		   }
	   }

	    public boolean searchUser(String username) throws SQLException {
		
		String query = "select * from User where UserName='" + delete_user_name.getText()+ "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				
				user_name.setText(rs.getString("username"));
				login_name.setText(rs.getString("loginname"));
				password.setText(rs.getString("password"));
				confirm_password.setText(rs.getString("confirmpassword"));
			    user_role.setText(rs.getString("userrole"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
}
	    public void CloseButton(ActionEvent event) {
	    	try {
				UserManagementScreen.showUserManagementScreen();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	    public void DeleteButton(ActionEvent event) {
	    	String query = "delete from User where UserName='" + delete_user_name.getText() + "' ";
			DBUtils.executeQuery(query);
			usermessage.setText("User has been deleted ");
	    }
}
