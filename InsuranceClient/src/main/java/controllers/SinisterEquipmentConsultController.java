package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class SinisterEquipmentConsultController implements Initializable{
    private SinisterEquipmentContainterController containerParent;
  /*  public void setContainer(ClaimsContainerController ClaimsContainerController) {
		this.containerParent = ClaimsContainerController;}*/
    @FXML
    private VBox content_area;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox ConsultNon;

    @FXML
    private Label dateLabel;

    @FXML
    private Label attached;

    @FXML
    private Label labelClient;

    @FXML
    private Label labelPrime;

    @FXML
    private Label labelClient1;

    @FXML
    private Label labelClient2;

    @FXML
    private Label labelClient3;

    @FXML
    private Label labelClient4;

    @FXML
    private JFXButton validate;

    @FXML
    private JFXButton refuse;

    @FXML
    private JFXButton archive;

    @FXML
    void archive(ActionEvent event) {

    }

    @FXML
    void refuse(ActionEvent event) {

    }

    @FXML
    void validate(ActionEvent event) {

    }

	public void setContainer(SinisterEquipmentContainterController sinisterEquipmentContainterController) {
		this.containerParent =		sinisterEquipmentContainterController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
