package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class carsPictureController implements Initializable {

	@FXML
	private AnchorPane anchorMarque;

    @FXML
    private JFXTextField marqueText;

	@FXML
	private ImageView bmwP;

	@FXML
	private ImageView AudiP;

	@FXML
	private ImageView citroenP;

	@FXML
	private ImageView fiatP;

	@FXML
	private ImageView kiaP;

	@FXML
	private ImageView nissanP;

	@FXML
	private ImageView miniP;

	@FXML
	private ImageView volsP;

	@FXML
	private ImageView peugeotP;

	@FXML
	private ImageView toyotaP;

	@FXML
	private ImageView daciaP;

	@FXML
	private ImageView renaultP;
	
    private Stage dialog;
    public VehicleQuotationController container;
    @FXML
    private HBox HboxValider;
    
    private String text;
    
    public String getText() {
        return text;
    }

    
    public void setContainer(VehicleQuotationController container){
        this.container = container;
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	

	public void setParams(Stage dialog){
		this.dialog=dialog;
	}

	@FXML
	public void FiatClick(MouseEvent event) {
		marqueText.setText("FIAT");
	}    

	@FXML
	public void audiClick(MouseEvent event) {
		marqueText.setText("AUDI");
	}

	@FXML
	public void bmwClick(MouseEvent event) {
		marqueText.setText("BMW");
	}

	@FXML
	public void citroenClick(MouseEvent event) {
		marqueText.setText("CITROEN");
}


	@FXML
	public void daciaClick(MouseEvent event) {
		marqueText.setText("DACIA");	
	}


	@FXML
	public void kiaClick(MouseEvent event) {
		marqueText.setText("KIA");
	}

	@FXML
	public void miniClick(MouseEvent event) {
		marqueText.setText("MINI COOPER");
	}

	@FXML
	public void nissanClick(MouseEvent event) {
		marqueText.setText("NISSAN");
}

	@FXML
	public void peugeotClick(MouseEvent event) {
		marqueText.setText("PEUGEOT");
	}

	@FXML
	public void renaultClick(MouseEvent event) {
		marqueText.setText("RENAULT");
	}

	@FXML
	public void toyotaClick(MouseEvent event) {
		marqueText.setText("TOYOTA");
	}

	@FXML
	public void volsClick(MouseEvent event) {
	    marqueText.setText("VOLKSWAGEN");
	}

    @FXML
    void valider(MouseEvent event)  throws IOException {
    	text=marqueText.getText();
        HboxValider.getScene().getWindow().hide();
    }

		 





}
