package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class ExpertManageVehicleContainerController implements Initializable {

	@FXML
	private AnchorPane anchorPane;
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		FXMLLoader loader = switchViewTo("/views/ExpertVehicleAccidentManage.fxml");
		((ExpertVehicleAccidentController)loader.getController()).setContainer(this);
	}
	public FXMLLoader switchViewTo(String view){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
			Parent ManageEmployees = loader.load();
			anchorPane.getChildren().clear();
			anchorPane.getChildren().add(ManageEmployees);
			return loader;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return null;

	}}


