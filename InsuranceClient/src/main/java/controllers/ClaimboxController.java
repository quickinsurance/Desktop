package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import entities.Contract.type_contract;
import entities.Sinister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ClaimboxController implements Initializable {

    @FXML
    private VBox claimvbox;
    @FXML
    private ImageView image1;
    @FXML
    private Label case1;

    @FXML
    private Label name;

    @FXML
    private Label date;

    @FXML
    private Label date1;
    

    @FXML
    private Label type;

    @FXML
    private Label etat;

   private Sinister s;
    public void setSinister(Sinister s){
    	
    	

		LocalDate dateBefore = LocalDate.parse(s.getReport().getAccident().getDate_of_Accident().toString());
		LocalDate datenext = LocalDate.parse(s.getReport().getDate_report().toString());
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore,datenext);
		if (noOfDaysBetween>15)
		{case1.setText("Denied");
			
		}
    	
    this.s=s;
    type.setText(s.getReport().getAccident().getType_contract().toString());
	name.setText(s.getReport().getAccident().getExpert().getFirstName()+s.getReport().getAccident().getExpert().getLastName());
	date.setText(s.getReport().getAccident().getDate_of_Accident().toString());
	date1.setText(s.getReport().getDate_report().toString());
	etat.setText(s.getDescription());
    System.out.println(s.toString());
    if (s.getReport().getAccident().getType_contract().toString().equals("housing")){
        Image a1 = new Image("/pictures/icons8-home-64.png");
		
        image1.setImage(a1);
    	
    }else {
    	Image a2 = new Image("/pictures/icons8-car-64.png");
    	image1.setImage(a2);
    	
    }
  
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
                  
	
		
			/*	*/
				
				
				

		
		
	}
	

    @FXML
    void show(MouseEvent event) throws Exception {
if (case1.getText().equals("Denied"))
{
	
}else{

	if (s.getReport().getAccident().getType_contract().toString().equals("housing")){
		

	

  	  FXMLLoader loader=new FXMLLoader(getClass().getResource("/views/Guaranteeclaimview.fxml"));
	  System.out.println(s.getSinister_id());
	  Parent root = (Parent) loader.load();
  	  GuaranteeclaimController cd = loader.getController();
  	  cd.setSinister(s);
  	  
  


  	  Stage stage=new Stage();
  	  stage.setScene(new Scene(root));
  	  stage.show();
	}else {

	  	  FXMLLoader loader1=new FXMLLoader(getClass().getResource("/views/Guaranteeclaimcarview.fxml"));
		  System.out.println(s.getSinister_id());
		  Parent root1 = (Parent) loader1.load();
	  	  GuaranteeclaimcarController cd = loader1.getController();
	  	  cd.setSinister(s);
	  	  
	  


	  	  Stage stage1=new Stage();
	  	  stage1.setScene(new Scene(root1));
	  	  stage1.show();
	}
}
    }

}
