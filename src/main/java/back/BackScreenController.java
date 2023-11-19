package back;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;

public class BackScreenController {
	
	@FXML
	private Button back_to_login_screen;
	
	public void BackToLoginScreen(ActionEvent event) throws Exception {
		
		LoginScreen.showLoginScreen();
	}

}
