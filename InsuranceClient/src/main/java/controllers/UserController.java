package controllers;

import java.net.URL;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import tn.esprit.imputation.entity.utilisateur;
//import tn.esprit.imputation.service.interf.IUserServiceRemote;

public class UserController implements Initializable {

    @FXML
    private Button btnadd;

    @FXML
    private TextField txtlastname;

    @FXML
    private TextField txtmail;

    @FXML
    private TextField txtname;
    
    
    //utilisateur user = new utilisateur();
    
    
    
    
    
/*    public int ServiceAddUser(utilisateur u) throws Exception
	{
		String jndiName = "cour-jpa2-ear/cour-jpa2-ejb/UserServiceImpl!tn.esprit.imputation.service.interf.IUserServiceRemote";
		Context context = new InitialContext();
		IUserServiceRemote proxy = (IUserServiceRemote) context.lookup(jndiName);
		
		return proxy.addUser(u);
	}
    */
    

    @FXML
   void AddUser(ActionEvent event) throws Exception {
    	
    /*	user.setFname(txtname.getText());
    	user.setLname(txtlastname.getText());
    	user.setEmail(txtmail.getText());
    	
    	
    	ServiceAddUser(user);*/
    	System.out.print("User added");
    	
    	txtname.setText("");
    	txtlastname.setText("");
    	txtmail.setText("");
    
    	 Stage stage = (Stage)btnadd.getScene().getWindow();
         stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/views/HealthManage.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/application.css");
        Stage   primaryStage = new Stage();
        primaryStage.setTitle("Health");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}
