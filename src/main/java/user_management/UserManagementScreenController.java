package user_management;

import add_user.AddUserScreen;
import back_to_home.BackToHomeScreen;
import delete_user.DeleteUserScreen;
import edit_user.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_user.SearchUserScreen;

public class UserManagementScreenController {
	
	@FXML
	private Button addUser;
	
	@FXML
	private Button editUser;
	
	@FXML
	private Button searchUser;
	
	@FXML
	private Button deleteUser;
	
	@FXML
	private Button backToHome;
	
	public void showAddUserScreen(ActionEvent event) {
		
	     AddUserScreen.showAddUserScreen();
		
	}
	public void showEditUserScreen(ActionEvent event) {
		
		EditUserScreen.showEditUserScreen();
		
	}
	public void showSearchUserScreen(ActionEvent event) {
		
		SearchUserScreen.showSearchUserScreen();
		
	}
	public void showDeleteUserScreen(ActionEvent event) {
		
		DeleteUserScreen.showDeleteUserScreen();
	}
	public void showBackToHomeScreen(ActionEvent event) {
		
		try {
		      BackToHomeScreen.showBackScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
