package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class SinisterEquipmentContainterController implements Initializable {
	

    @FXML
    private AnchorPane AnchorPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FXMLLoader loader = switchViewTo("/views/SinisterEquipmentConsult.fxml");
		((SinisterEquipmentConsultController)loader.getController()).setContainer(this);
	}
	public FXMLLoader switchViewTo(String view){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
			Parent ManageEmployees = loader.load();
			AnchorPane.getChildren().clear();
			AnchorPane.getChildren().add(ManageEmployees);
			return loader;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return null;

	}}
