package login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import db_operations.DBUtils;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginScreenController {
	
	@FXML
	private TextField loginName;
	
	@FXML
	private TextField password;
	
	@FXML
	private Button loginButton;
	
	public void login(ActionEvent event)
	{
		boolean loginStatus = false;
		try {
			loginStatus = LoginScreenController.validateUserAndPassword(loginName.getText(),password.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(loginStatus) {
			HomeScreen.showHomeScreen();
		}else {
			System.out.println(" Login Unsuccessful");
		}
	}
	public static boolean validateUserAndPassword(String loginName, String password) throws IOException {

		String query = "select * from User where loginName='" + loginName + "' and password='" + password + "' ";

		ResultSet rs = DBUtils.executeQueryGetResult(query);

		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	

}
