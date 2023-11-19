package search_product;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import edit_product.EditProductScreen;
import edit_user.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;
import user_management.UserManagementScreen;

public class SearchProductScreenController {

	 @FXML
	   private TextField search_product_name;
	   
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
	   private Button search_button;
	   
	   @FXML
	   private Button close_button;
	   
	   @FXML
	   private Button delete_button;
	   
	   @FXML
	   private Button edit_button;
	   
	   public void SearchButton(ActionEvent event)throws SQLException {
		   
		   boolean searchstatus = searchProduct(search_product_name.getText());
		   
		   if(searchstatus) {
			   searchProduct(null);
		   }
	   }

	    public boolean searchProduct(String productName) throws SQLException {
		
		String query = "select * from Product where productName='" + search_product_name.getText()+ "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				
				product_name.setText(rs.getString("productName"));
				product_id.setText(rs.getString("productId"));
				product_category.setText(rs.getString("productcategory"));
				product_quantity.setText(rs.getString("productQuantity"));
			    product_price.setText(rs.getString("productPrice"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	    public void CloseButton(ActionEvent event) {
	    	try {
			     ProductManagementScreen.showProductManagementScreen();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	    public void EditButton(ActionEvent event) {
	    	try {
	    		EditProductScreen.showEditProductScreen();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    public void DeleteButton(ActionEvent event) {
	    	String query = "delete from Product where productName='" + search_product_name.getText() + "' ";
			DBUtils.executeQuery(query);
	    }
}
