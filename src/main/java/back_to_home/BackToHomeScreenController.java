package back_to_home;

import java.sql.SQLException;

import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BackToHomeScreenController {
	
	@FXML
	private Button home_button;
	
	public void HomeButton(ActionEvent event) throws SQLException {
		
		HomeScreen.showHomeScreen();
	}

}
