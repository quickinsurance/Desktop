package tn.esprit;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tn.esprit.imputation.entity.Utilisateur;
import tn.esprit.imputation.service.interf.IUserServiceRemote;

public class UserController implements Initializable {

    @FXML
    private Button btnadd;

    @FXML
    private TextField txtlastname;

    @FXML
    private TextField txtmail;

    @FXML
    private TextField txtname;
    
    
    Utilisateur user = new Utilisateur();
    
    
    
    
    
    public int ServiceAddUser(Utilisateur u) throws Exception
	{
		String jndiName = "cours-jpa2-ear/cours-jpa2-ejb/UserServiceImpl!tn.esprit.imputation.service.interf.IUserServiceRemote";
		Context context = new InitialContext();
		IUserServiceRemote proxy = (IUserServiceRemote) context.lookup(jndiName);
		
		return proxy.addUser(u);
	}
    
    

    @FXML
   void AddUser(ActionEvent event) throws Exception {
    	
    	user.setNom(txtname.getText());
    	user.setPrenom(txtlastname.getText());
    	user.setAdresseMail(txtmail.getText());
    	
    	
    	ServiceAddUser(user);
    	System.out.print("User added");
    	
    	txtname.setText("");
    	txtlastname.setText("");
    	txtmail.setText("");

    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}
