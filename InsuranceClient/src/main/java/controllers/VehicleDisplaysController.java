package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class VehicleDisplaysController implements Initializable{
	
    @FXML
    private AnchorPane anchor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 FXMLLoader loader = switchView("/views/DisplayVehicleContractsView.fxml");
	        ((DisplayVehicleContractsController)loader.getController()).setContainer(this);
	    }
	    public FXMLLoader switchView(String view){
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
	            Parent ManageEmployees = loader.load();
	            anchor.getChildren().clear();
	            anchor.getChildren().add(ManageEmployees);
	            return loader;
	        } catch (IOException ex) {
	            System.out.println(ex.getMessage());
	        }
			return null;
	        
	    }
		
	
}
