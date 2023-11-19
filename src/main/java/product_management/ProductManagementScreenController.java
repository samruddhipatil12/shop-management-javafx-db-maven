package product_management;

import add_product.AddProductScreen;
import add_user.AddUserScreen;
import back_to_home.BackToHomeScreen;
import delete_product.DeleteProductScreen;
import delete_user.DeleteUserScreen;
import edit_product.EditProductScreen;
import edit_user.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_product.SearchProductScreen;
import search_user.SearchUserScreen;

public class ProductManagementScreenController {
	
	@FXML
	private Button add_product;
	
	@FXML
	private Button edit_product;
	
	@FXML
	private Button search_product;
	
	@FXML
	private Button delete_product;
	
	@FXML
	private Button back_to_home;
	
	public void AddProduct(ActionEvent event) {
		
	     AddProductScreen.showAddProductScreen();
		
	}
	public void EditProduct(ActionEvent event) {
		
		EditProductScreen.showEditProductScreen();
		
	}
	public void SearchProduct(ActionEvent event) {
		
		SearchProductScreen.showSearchProductScreen();
		
	}
	public void DeleteProduct(ActionEvent event) {
		
		DeleteProductScreen.showDeleteProductScreen();
		
	}
	public void BackToHome(ActionEvent event) {
		
		try {
			BackToHomeScreen.showBackScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}