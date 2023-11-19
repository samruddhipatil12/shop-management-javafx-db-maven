package delete_product;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;
import user_management.UserManagementScreen;

public class DeleteProductScreenController {
	
	 @FXML
	 private TextField delete_product_name;
	
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
	 private Button search_button;
	 
	 @FXML
	 private Button delete_button;
	 
	 public void SearchButton(ActionEvent event)throws SQLException {
		   
		   boolean searchstatus = searchProduct(delete_product_name.getText());
		   
		   if(searchstatus) {
			   searchProduct(null);
		   }
	   }

	    public boolean searchProduct(String productname) throws SQLException {
		
		String query = "select * from Product where productName='" + delete_product_name.getText()+ "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				
				product_name.setText(rs.getString("productName"));
				product_id.setText(rs.getString("productId"));
				product_category.setText(rs.getString("productCategory"));
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
	    public void DeleteButton(ActionEvent event) {
	    	String query = "delete from Product where productName='" + delete_product_name.getText() + "' ";
			DBUtils.executeQuery(query);
			usermessage.setText("Product has been deleted ");
	    }

}
