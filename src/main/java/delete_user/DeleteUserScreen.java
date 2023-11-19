package delete_user;

import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class DeleteUserScreen {
	
public static void showDeleteUserScreen() {
		
		try {
			Parent actorGroup = FXMLLoader.load(new URL("file:///C|//Users//Mr Patil//Desktop//space//ShopManagementJavaFxDB//src//delete_user//delete_user.fxml"));
			StageFactory.stage.setTitle(" DeleteUser Screen ");
			Scene scene = new Scene(actorGroup ,600,400);
			StageFactory.stage.setScene(scene);
			StageFactory.stage.setFullScreen(true);
			StageFactory.stage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
