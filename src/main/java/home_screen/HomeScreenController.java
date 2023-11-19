package home_screen;

import back.BackScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import product_management.ProductManagementScreen;
import user_management.UserManagementScreen;

public class HomeScreenController {
	
	@FXML
	private Button userManagement;
	
	@FXML
	private Button productManagement;
	
	@FXML
	private Button back;
	
	public void showUserManagementScreen(ActionEvent event) {
		UserManagementScreen.showUserManagementScreen();
	}
	public void showProductManagementScreen(ActionEvent event) {
		ProductManagementScreen.showProductManagementScreen();
		
	}
	public void backToHomeScreen(ActionEvent event) {
		try {
			BackScreen.showBackScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
