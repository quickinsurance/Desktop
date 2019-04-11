package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class GuaranteeCheckVehicleContainerController implements Initializable {

	@FXML
	private AnchorPane anchorPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FXMLLoader loader = switchViewTo("/views/GuaranteeCheckVehicleView.fxml");
		((GuaranteeCheckVehicleController) loader.getController()).setContainer(this);
	}

	public FXMLLoader switchViewTo(String view) {
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

	}
	public FXMLLoader switchViewTo1(String view,AnchorPane anchorPane ) {
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

	}
}