package add_product;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;
import user_management.UserManagementScreen;

public class AddProductScreenController {
	
	@FXML
	private TextField product_name;
	
	@FXML
	private TextField product_id;
	
	@FXML
	private TextField product_category;
	
	@FXML
	private TextField product_quantity;
	
	@FXML
	private TextField product_price;
	
	@FXML
	private Label usermessage;
	
	@FXML
	private Button close_button;
	
	@FXML
	private Button save_Button;
	
	public void SaveButton(ActionEvent event) {

		String query = "INSERT INTO Product(productName, productId, productCategory, productQuantity, productPrice) VALUES ('"
				+ product_name.getText() + "', '" + product_id.getText() + "', '" + product_category.getText()+ "','"
				+ product_quantity.getText() + "','" + product_price.getText() + "')";

		DBUtils.executeQuery(query);
		usermessage.setText("Product Created Successfully !! ");
	}
	public void CloseButton(ActionEvent event) {
		try {
			ProductManagementScreen.showProductManagementScreen();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
