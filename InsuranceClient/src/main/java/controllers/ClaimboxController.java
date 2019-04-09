package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entities.Sinister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ClaimboxController implements Initializable {

    @FXML
    private VBox claimvbox;

    @FXML
    private Label name;

    @FXML
    private Label date;

    @FXML
    private Label type;

    @FXML
    private Label etat;

   private Sinister s;
    public void setSinister(Sinister s){
    	
    this.s=s;
	name.setText(s.getReport().getAccident().getExpert().getFirstName()+s.getReport().getAccident().getExpert().getLastName());
	date.setText(s.getReport().getDate_report().toString());
	
	etat.setText(s.getDescription());
    System.out.println(s.toString());
    	
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
                  
	
		
			/*	*/
				
				
				

		
		
	}
	

    @FXML
    void show(MouseEvent event) throws Exception {

  	  FXMLLoader loader=new FXMLLoader(getClass().getResource("/views/Guaranteeclaimview.fxml"));
	  System.out.println(s.getSinister_id());
	  Parent root = (Parent) loader.load();
  	  GuaranteeclaimController cd = loader.getController();
  	  cd.setSinister(s);
  	  
  


  	  Stage stage=new Stage();
  	  stage.setScene(new Scene(root));
  	  stage.show();

    }

}
