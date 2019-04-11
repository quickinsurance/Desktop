package controllers;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ScoringClientController implements Initializable {
	@FXML
	private AnchorPane anchorParent;

	@FXML
	private JFXDatePicker DatePermisPiicker;

	@FXML
	private JFXDatePicker dateContratPicker;

	@FXML
	private JFXSlider sliderPointsPerdus;

	@FXML
	private JFXComboBox<String> sinistesNumberCombo;

	@FXML
	private JFXDatePicker birthDatePicker;

	@FXML
	private JFXTextField txtTarif;

	@FXML
	private ProgressIndicator progressIndicator;

	@FXML
	private JFXButton scoringBtn;

	@FXML
	private JFXCheckBox tiersCheckBox;

	@FXML
	private JFXCheckBox tiersEtenduCheckBox;

	@FXML
	private JFXCheckBox tousRisquesCheckBox;
	@FXML
	private Label labelPoints;
	@FXML
	private VBox vboxLabels;

	@FXML
	private VBox vboxResults;
	@FXML
	private JFXTextField coefficienttext;

	@FXML
	private JFXTextField BonusOuMalusText;

	@FXML
	private JFXTextField ReductionText;

	@FXML
	private JFXTextField MajorationText;

	@FXML
	private JFXTextField EtatText;

	private static DecimalFormat df2 = new DecimalFormat(".##");
    @FXML
    private Label labelCoefficient;
    
    @FXML
    private Label nbreSinistresLabel;

    @FXML
    private Label tarifLabel;
    @FXML
    private JFXButton ResetBtn;
    @FXML
    private Label tarifProchainLabel;

    @FXML
    private JFXTextField tarifProchainTxtField;
    @FXML
    private JFXTextField grouptxt;
    
    @FXML
    private ImageView coeffImageView;

    @FXML
    private ImageView bonusOumalusImageView;

    @FXML
    private ImageView majorationImageView;

    @FXML
    private ImageView clientImageView;

    @FXML
    private ImageView tarifImageView;

    @FXML
    private ImageView reductionImageView;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			sinistesNumberCombo.getItems().add(""+ i);
		}
	}

	@FXML
	void tiersAction(ActionEvent event) {
		tousRisquesCheckBox.setSelected(false);
		tiersEtenduCheckBox.setSelected(false);
	}

	@FXML
	void tiersEtenduAction(ActionEvent event) {
		tousRisquesCheckBox.setSelected(false);
		tiersCheckBox.setSelected(false);
	}

	@FXML
	void tousRisqueAction(ActionEvent event) {
		tiersEtenduCheckBox.setSelected(false);
		tiersCheckBox.setSelected(false);
	}


	@FXML
	void updatePointsSlider(MouseEvent event) {
		sliderPointsPerdus.valueProperty().addListener((obs, oldval, newVal) -> 
		sliderPointsPerdus.setValue(newVal.intValue()));
		labelPoints.setText("(" + String.valueOf(sliderPointsPerdus.getValue())+ " Points)");
	}
	public double calculPuissance(){
		int n =(Integer.parseInt(sinistesNumberCombo.getValue()));
		double s=0;
		if (n==1){
			s=Math.pow(1.25, 1);
		}
		else if(n==2){
			s=Math.pow(1.25, 2);		
		}
		else if(n==3){
			s=Math.pow(1.25, 3);		
		}
		else if(n==4){
			s=Math.pow(1.25, 4);		
		}
		else if(n==5){
			s=Math.pow(1.25, 5);		
		}
		else if(n==6){
			s=Math.pow(1.25, 6);		
		}
		else if(n==7){
			s=Math.pow(1.25, 7);		
		}
		else if(n==8){
			s=Math.pow(1.25, 8);		
		}
		else if(n==9){
			s=Math.pow(1.25, 9);		
		}
		return s;
	}

	public double calculBonuMalus(){
		int amortissement=new Date().getYear() - java.sql.Date.valueOf(dateContratPicker.getValue()).getYear();
		double bonusMalus=1;
		double[] ti;
		ti= new double[13];
		if (Integer.parseInt(sinistesNumberCombo.getValue())!=0){
			if(amortissement==0){
				bonusMalus=1*calculPuissance();
			}
			else if(amortissement==1){
				bonusMalus=0.95*calculPuissance();			
			}
			else if(amortissement==2){
				bonusMalus=0.9025*calculPuissance();
			}
			else if(amortissement<13){
				for (int i=0; i<12; i++){
					double r=0.05;
					ti[0]=0.95;
					ti[i+1]=ti[i]*0.95;
					bonusMalus=ti[amortissement-1]*calculPuissance();
				}}
			else {
				bonusMalus=0.513342*calculPuissance();
			}}

		else{ if(amortissement==0){
			bonusMalus=1;
		}
		else if(amortissement==1){
			bonusMalus=0.95;			
		}
		else if(amortissement==2){
			bonusMalus=0.9025;			
		}
		else if(amortissement<13){
			for (int i=0; i<12; i++){
				double r=0.05;
				ti[0]=0.95;
				ti[i+1]=ti[i]*0.95;
				bonusMalus=ti[amortissement-1];
			}}
		else {
			bonusMalus=0.513342;
		}}
		return bonusMalus;}


	@FXML
	void calculScoreAction(ActionEvent event) {

		boolean valid=true;
				
		if (birthDatePicker.getValue() == null) {
			valid = false;
		}

		else if(DatePermisPiicker.getValue()==null){
			valid=false;
		}
		else if(dateContratPicker.getValue()==null){
			valid=false;
		}
				
		if(dateContratPicker.getValue()!=null){
			if (((new Date()).getTime() - java.sql.Date.valueOf(dateContratPicker.getValue()).getTime()) < 0){
				dateContratPicker.getStyleClass().add("error");
				Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Date !", ButtonType.OK);
				alert.show();
				valid=false;
				dateContratPicker.setValue(null);
			}}
		if(DatePermisPiicker.getValue()!=null){
			if (((new Date()).getTime() - java.sql.Date.valueOf(DatePermisPiicker.getValue()).getTime()) < 0){
				DatePermisPiicker.getStyleClass().add("error");
				Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Date !", ButtonType.OK);
				alert.show();
				valid=false;
				DatePermisPiicker.setValue(null);
			}}

		if(birthDatePicker.getValue()!=null){
			if (((new Date()).getYear() - java.sql.Date.valueOf(birthDatePicker.getValue()).getYear()) < 18){
				birthDatePicker.getStyleClass().add("error");
				Alert alert = new Alert(Alert.AlertType.ERROR, "the customer must be at least 18 years old !", ButtonType.OK);
				alert.show();
				valid=false;
				birthDatePicker.setValue(null);
			}}
		if(birthDatePicker.getValue()!=null && DatePermisPiicker.getValue()!=null){
			if (((java.sql.Date.valueOf(DatePermisPiicker.getValue()).getYear()) - java.sql.Date.valueOf(birthDatePicker.getValue()).getYear()) < 18){
				DatePermisPiicker.getStyleClass().add("error");
				Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Date of obtaining driving licence !", ButtonType.OK);
				alert.show();
				valid=false;
				DatePermisPiicker.setValue(null);
			}}
		if(birthDatePicker.getValue()!=null && DatePermisPiicker.getValue()!=null&&dateContratPicker.getValue()!=null){
			if (((java.sql.Date.valueOf(dateContratPicker.getValue()).getTime()) - java.sql.Date.valueOf(DatePermisPiicker.getValue()).getTime()) < 0){
				dateContratPicker.getStyleClass().add("error");
				Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Date of first contract !", ButtonType.OK);
				alert.show();
				valid=false;
				dateContratPicker.setValue(null);
			}}
        if (sinistesNumberCombo.getValue()==null) {
            nbreSinistresLabel.setText("Field is empty !");
            nbreSinistresLabel.setVisible(true);
            valid = false;
        } else {
            nbreSinistresLabel.setText("");
        }
        if (txtTarif.getText().equals("")) {
            tarifLabel.setText("Field is empty !");
            tarifLabel.setVisible(true);
            valid = false;
        } else {
            tarifLabel.setText("");
        }

		if(!valid) return;
		
		progressIndicator.setVisible(false);
		vboxResults.setVisible(true);
		tarifProchainLabel.setVisible(true);
		tarifProchainTxtField.setVisible(true);
		coefficienttext.setText(String.valueOf(calculBonuMalus()));
		
		if(calculTarifProchain()<=400){
			grouptxt.setText("Group 1");
		}
		else if(calculTarifProchain()>400 &&calculTarifProchain()<=700){
			grouptxt.setText("Group 2");
		}
		else if(calculTarifProchain()>700 &&calculTarifProchain()<=1000){
			grouptxt.setText("Group 3");
		}
		else if(calculTarifProchain()>1000 &&calculTarifProchain()<=1300){
			grouptxt.setText("Group 4");
		}
		else if(calculTarifProchain()>1300 &&calculTarifProchain()<=1600){
			grouptxt.setText("Group 5");
		}
		else if(calculTarifProchain()>1600 &&calculTarifProchain()<=1900){
			grouptxt.setText("Group 6");
		}
		else if(calculTarifProchain()>1900 &&calculTarifProchain()<=2200){
			grouptxt.setText("Group 7");
		}
		else if(calculTarifProchain()>2200 &&calculTarifProchain()<=2500){
			grouptxt.setText("Group 8");
		}
		else if(calculTarifProchain()>2500 &&calculTarifProchain()<=2800){
			grouptxt.setText("Group 9");
		}
		else if(calculTarifProchain()>2800 &&calculTarifProchain()<=3100){
			grouptxt.setText("Group 10");
		}
		else if(calculTarifProchain()>3100){
			grouptxt.setText("Group 11");
		}
		
		grouptxt.setVisible(true);
		
		if(calculBonuMalus()<0.75){
			BonusOuMalusText.setText("Bonus");
			double f = (1-Double.valueOf((coefficienttext.getText())))*100;
			ReductionText.setText(String.valueOf(f)+ "%");
			MajorationText.setText("0 %");
			EtatText.setText("Excellent Customer");
		}else if(calculBonuMalus()<1 &&calculBonuMalus()>=0.75){
			BonusOuMalusText.setText("Bonus");
			double f = (1-Double.valueOf((coefficienttext.getText())))*100;
			ReductionText.setText(String.valueOf(f)+ "%");
			MajorationText.setText("0 %");
			EtatText.setText("Good Customer");
		}
		else if(calculBonuMalus()==1){
			BonusOuMalusText.setText("Neither Bonus Nor Malus");
			ReductionText.setText("0 %");
			MajorationText.setText("0 %");
			EtatText.setText("Good Customer");
		}
		
		else if(calculBonuMalus()>1 &&calculBonuMalus()<=1.10){
			BonusOuMalusText.setText("Malus");
			ReductionText.setText("0 %");
			MajorationText.setText("An increase from 1 to 10 % on the old Tarif");
			EtatText.setText("Bad Customer");
		}
		else if(calculBonuMalus()>1.10 &&calculBonuMalus()<=1.25){
			BonusOuMalusText.setText("Malus");
			ReductionText.setText("0 %");
			MajorationText.setText("An increase from 11 to 25 % on the old Tarif");
			EtatText.setText("Bad Customer");
		}
		else if(calculBonuMalus()>1.25 &&calculBonuMalus()<=1.50){
			BonusOuMalusText.setText("Malus");
			ReductionText.setText("0 %");
			MajorationText.setText("An increase from 26 to 50 % on the old Tarif");
			EtatText.setText("Bad Customer");
		}
		else if(calculBonuMalus()>1.50 &&calculBonuMalus()<=2){
			BonusOuMalusText.setText("Malus");
			ReductionText.setText("0 %");
			MajorationText.setText("An increase from 51 to 100 % on the old Tarif");
			EtatText.setText("Very Risky Customer");
		}
		else if(calculBonuMalus()>2 &&calculBonuMalus()<=3){
			BonusOuMalusText.setText("Malus");
			ReductionText.setText("0 %");
			MajorationText.setText("An increase from 101 to 200 % on the old Tarif");
			EtatText.setText("Very Risky Customer");
		}
		else if(calculBonuMalus()>3 &&calculBonuMalus()<=3.5){
			BonusOuMalusText.setText("Malus");
			ReductionText.setText("0 %");
			MajorationText.setText("An increase from 201 to 250 % on the old Tarif");
			EtatText.setText("Very Risky Customer");
		}
		else if(calculBonuMalus()>3.5){
			BonusOuMalusText.setText("Malus");
			ReductionText.setText("0 %");
			MajorationText.setText("A very strong increase Rate above 250%");
			EtatText.setText("Customer to avoid");
		}
		tarifProchainTxtField.setText(String.valueOf(calculTarifProchain()));
	}
	
	public double calculTarifProchain(){
		double tarif=0;
		if(tiersCheckBox.isSelected()){
			tarif=Double.valueOf(txtTarif.getText())*Double.valueOf(coefficienttext.getText());
		}
		else if(tiersEtenduCheckBox.isSelected()){
			tarif=1.5*Double.valueOf(txtTarif.getText())*Double.valueOf(coefficienttext.getText());
		}
		else if(tousRisquesCheckBox.isSelected()){
			tarif=2.22*Double.valueOf(txtTarif.getText())*Double.valueOf(coefficienttext.getText());
		}
		return tarif;
	}
	
    @FXML
    void ResetAction(ActionEvent event) {
    	birthDatePicker.setValue(null);
    	dateContratPicker.setValue(null);
    	DatePermisPiicker.setValue(null);
    	sinistesNumberCombo.setValue(null);
    	txtTarif.setText("");
    	vboxResults.setVisible(false);
    	tarifProchainTxtField.setVisible(false); 
    	grouptxt.setVisible(false);
    	progressIndicator.progressProperty().set(-1);
    	progressIndicator.setVisible(true);
    }
	


}
