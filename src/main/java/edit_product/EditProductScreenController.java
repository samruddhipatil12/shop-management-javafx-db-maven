package edit_product;

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

public class EditProductScreenController {
	
	@FXML
	private TextField edit_product_name;
	
	@FXML
	private TextField new_product_name;
	
	@FXML
	private TextField new_product_id;
	
	@FXML
	private TextField new_product_category;
	
	@FXML
	private TextField new_product_quantity;
	
	@FXML
	private TextField new_product_price;
	
	@FXML
	private Label usermessage;
	
	@FXML
	private Button edit_button;
	
	@FXML
	private Button close_button;
	
	@FXML
	private Button save_Button;
	
	public void EditButton(ActionEvent event) throws SQLException {
		boolean editstatus = editProduct(edit_product_name.getText());
		
		if(editstatus) {
			editProduct(null);
		}
	}

	private boolean editProduct(String product_name) throws SQLException{
		String query = "select * from Product where productName='" + edit_product_name.getText()+ "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				
				new_product_name.setText(rs.getString("productName"));
				new_product_id.setText(rs.getString("productId"));
				new_product_category.setText(rs.getString("productCategory"));
				new_product_quantity.setText(rs.getString("productQuantity"));
				new_product_price.setText(rs.getString("productPrice"));
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}

	public void SaveButton(ActionEvent event) {
		
		String updateQuery = "update Product set "
				+ "productName='"+new_product_name.getText()+"', productId = '"+new_product_id.getText()+"', "
						+ "productCategory='"+new_product_category.getText()+"', productQuantity='"+new_product_quantity.getText()+"', "
								+ "productPrice='"+new_product_price.getText()+"' where productName='"+edit_product_name.getText()+"'";
		
		DBUtils.executeQuery(updateQuery);
		usermessage.setText(" Product updated successfully !! ");
	}
	
	public void CloseButton(ActionEvent event) {
		try {
			ProductManagementScreen.showProductManagementScreen();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}



}

