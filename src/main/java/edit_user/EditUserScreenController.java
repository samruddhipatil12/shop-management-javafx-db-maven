
package edit_user;

import java.sql.ResultSet;
import java.sql.SQLException;
import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class EditUserScreenController {
	
	@FXML
	private TextField edit_user_name;
	
	@FXML
	private TextField new_user_name;
	
	@FXML
	private TextField new_login_name;
	
	@FXML
	private TextField new_password;
	
	@FXML
	private TextField new_confirm_password;
	
	@FXML
	private TextField new_user_role;
	
	@FXML
	private Label usermessage;
	
	@FXML
	private Button edit_button;
	
	@FXML
	private Button cancel_button;
	
	@FXML
	private Button save_Button;
	
	public void EditButton(ActionEvent event) throws SQLException {
		
		boolean status = editUser(edit_user_name.getText());
		if(status) {
			editUser(null);
		
		}
		
	}
	
	private boolean editUser(String user_name) throws SQLException{
		String query = "select * from User where UserName='" + edit_user_name.getText()+ "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				
				new_user_name.setText(rs.getString("username"));
				new_login_name.setText(rs.getString("loginname"));
				new_password.setText(rs.getString("password"));
				new_confirm_password.setText(rs.getString("confirmpassword"));
				new_user_role.setText(rs.getString("userrole"));
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}

	public void SaveButton(ActionEvent event) {
		
		String updateQuery = "update User set "
				+ "UserName='"+new_user_name.getText()+"', LoginName = '"+new_login_name.getText()+"', "
						+ "Password='"+new_password.getText()+"', confirmPassword='"+new_confirm_password.getText()+"', "
								+ "userRole='"+new_user_role.getText()+"' where username='"+edit_user_name.getText()+"'";
		
		DBUtils.executeQuery(updateQuery);
		usermessage.setText("User updated successfully!!");
	}
	
	public void CancelButton(ActionEvent event) {
		try {
			UserManagementScreen.showUserManagementScreen();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
