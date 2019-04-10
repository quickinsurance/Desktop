package controllers;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;

import entities.User;
import entities.VehicleQuotation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.interf.UserServiceRemote;
import services.interf.VehicleQuotationServiceRemote;

public class VehicleQuotationController implements Initializable {


	@FXML
	private ScrollPane scrollPane;

	@FXML
	private AnchorPane anchorParent;

	@FXML
	private JFXRadioButton RtarifActuel;

	@FXML
	private ToggleGroup propVehicleGroup;

	@FXML
	private JFXRadioButton RtarifFutur;

	@FXML
	private JFXRadioButton RUsageTous;

	@FXML
	private ToggleGroup UsingGroup;

	@FXML
	private JFXRadioButton RusagePrivé;

	@FXML
	private JFXRadioButton RfréquenceTous;

	@FXML
	private ToggleGroup FrequenceGroup;

	@FXML
	private JFXRadioButton RfréquenceQuelques;

	@FXML
	private ComboBox<String> comboModeParking;

	@FXML
	private Button btnEtapeSuivante;

	@FXML
	private ComboBox<String> comboLostP;

	@FXML
	private ComboBox<String> comboSinistersNumber;

	@FXML
	private JFXButton pictureBtn;

	private FXMLLoader loader;

	@FXML
	private JFXTextField marqueText;

	public carsPictureController carsPictureController;

	@FXML
	private HBox suspendedNo;

	@FXML
	private HBox suspendedYes;

	@FXML
	private HBox EditNo;

	@FXML
	private HBox EditYes;

	@FXML
	private HBox StateOld;

	@FXML
	private HBox StateNew;

	@FXML
	private JFXSlider kmSlider;

	@FXML
	private Label kmLabel;

	@FXML
	private ImageView addPictureBtn;

	@FXML
	private JFXSlider PuissanceSlider;

	@FXML
	private Label PuissanceLabel;
	@FXML
	private HBox HboxOptions;

    @FXML
    private JFXCheckBox tiersCheckBox;

    @FXML
    private JFXCheckBox tiersEtenduCheckBox;

    @FXML
    private JFXCheckBox tousRisquesCheckBox;
	@FXML
	private HBox hboxBtnDevis;
	@FXML
	private JFXDatePicker picker;
	@FXML
	private JFXTextField txtBonusMalus;

	@FXML
	private Label bonusOuMalusLabel;
	@FXML
	public JFXTextField primeTxtField;
	
    @FXML
    private JFXButton checkBonusBtn;
    
    
    @FXML
    private JFXCheckBox maleBox;

    @FXML
    private JFXCheckBox femaleBox;

    @FXML
    private JFXDatePicker birthDatePicker;

    @FXML
    private JFXTextField cinTxt;

    @FXML
    private JFXTextField firstNametxt;

    @FXML
    private JFXTextField lastNametxt;
    @FXML
    private ImageView redCartImg;
    
    @FXML
    private Label labelPointsLosted;

    @FXML
    private Label numberOfSinistersLabel;

    @FXML
    private Label modeOfParkingLabel;

    @FXML
    private Label cinLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;
    @FXML
    private Label vehicleLabel;
    
    @FXML
    private Label birthDateLabel;

    @FXML
    private Label circulationDateLabel;
	

	private static DecimalFormat df2 = new DecimalFormat(".##");
	private String primeTextResult;
	public static VehicleQuotation vQuotation = new VehicleQuotation();
    NumberFormat formatter = new DecimalFormat("#0.00");
    User user = new User();

	public String getPrimeText(){
		return primeTextResult;
	}


	//combo Parking
	private String aParking[] = {"Garage fermé individuel", "Parking collectif", "Voie publique"};


	private void initParking(){
		List<String> list = new ArrayList<String>();
		for(String content:aParking){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		comboModeParking.setItems(oblist);
	}
	public void setText(String s){
		this.marqueText.setText(s);
	}


	public int ServiceAddVehicleQuotation(VehicleQuotation vehicleQuotation) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/VehicleQuotationServiceImpl!services.interf.VehicleQuotationServiceRemote";
		Context context = new InitialContext();
		VehicleQuotationServiceRemote proxy = (VehicleQuotationServiceRemote) context.lookup(jndiName);

		return proxy.addVehicleQuotation(vehicleQuotation);
	}
	
	public int ServiceAddUser(User u) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		return proxy.addUser(u);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		initParking();
		comboLostP.getItems().add("");
		for (int i = 1; i < 12; i++) {
			comboLostP.getItems().add("" + i);
		}
		comboSinistersNumber.getItems().add("");
		for (int i = 0; i < 10; i++) {
			comboSinistersNumber.getItems().add("" + i);
		}
	}	
	
    @FXML
    void checkFemaleBox(ActionEvent event) {
    		maleBox.setSelected(false);
    }

    @FXML
    void checkMaleBox(ActionEvent event) {
    		femaleBox.setSelected(false);
    }

	@FXML
	void choosePictureAction(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/carsPicture.fxml"));  
		Stage stage = new Stage();
		stage.initOwner(addPictureBtn.getScene().getWindow());
		stage.setScene(new Scene((Parent) loader.load()));
		// showAndWait will block execution until the window closes...
		/*  stage.showAndWait();
        carsPictureController controller = loader.getController();
        marqueText.setText(controller.getText());*/
		carsPictureController controller = loader.getController();
		stage.setOnHidden(evt-> marqueText.setText(controller.getText()));
		stage.show();
	}

	@FXML
	void SuspendedNo(MouseEvent event) {
		redCartImg.setVisible(false);
		if (vQuotation.isSuspendedLicence() == false) {
			suspendedNo.getStyleClass().removeAll("noBoxSelected");
			vQuotation.setSuspendedLicence(true);
		} else {
			suspendedNo.getStyleClass().addAll("noBoxSelected");
			suspendedYes.getStyleClass().removeAll("yesBoxSelected");
			vQuotation.setSuspendedLicence(false);
		}
	}

	@FXML
	void SuspendedYes(MouseEvent event) {
		redCartImg.setVisible(true);
		if (vQuotation.isSuspendedLicence() == true) {
			suspendedYes.getStyleClass().removeAll("yesBoxSelected");
			vQuotation.setSuspendedLicence(false);
		} else {
			suspendedYes.getStyleClass().addAll("yesBoxSelected");
			suspendedNo.getStyleClass().removeAll("noBoxSelected");
			vQuotation.setSuspendedLicence(true);
		}
	}

	@FXML
	void EditNoAction(MouseEvent event) {
		if (vQuotation.isVehicleEdit() == false) {
			EditNo.getStyleClass().removeAll("noBoxSelected");
			vQuotation.setVehicleEdit(true);
		} else {
			EditNo.getStyleClass().addAll("noBoxSelected");
			EditYes.getStyleClass().removeAll("yesBoxSelected");
			vQuotation.setVehicleEdit(false);
		}
	}

	@FXML
	void EditYesAction(MouseEvent event) {
		if (vQuotation.isVehicleEdit() == true) {
			EditYes.getStyleClass().removeAll("yesBoxSelected");
			vQuotation.setVehicleEdit(false);
		} else {
			EditYes.getStyleClass().addAll("yesBoxSelected");
			EditNo.getStyleClass().removeAll("noBoxSelected");
			vQuotation.setVehicleEdit(true);
		}
	}

	@FXML
	void StateNewAction(MouseEvent event) {
		if (vQuotation.isVehicleState() == true) {
			StateNew.getStyleClass().removeAll("yesBoxSelected");
			vQuotation.setVehicleState(false);
		} else {
			StateNew.getStyleClass().addAll("yesBoxSelected");
			StateOld.getStyleClass().removeAll("noBoxSelected");
			vQuotation.setVehicleState(true);
		}
	}

	@FXML
	void StateOldAction(MouseEvent event) {
		if (vQuotation.isVehicleState() == false) {
			StateOld.getStyleClass().removeAll("noBoxSelected");
			vQuotation.setVehicleState(true);
		} else {
			StateOld.getStyleClass().addAll("noBoxSelected");
			StateNew.getStyleClass().removeAll("yesBoxSelected");
			vQuotation.setVehicleState(false);
		}
	}

	@FXML
	void updateKmSlider(MouseEvent event) {
		kmLabel.setText("(" + String.valueOf(kmSlider.getValue())+ " Km)");
	}
	@FXML
	void updatePuissanceValue(MouseEvent event) {
		PuissanceSlider.valueProperty().addListener((obs, oldval, newVal) -> 
		PuissanceSlider.setValue(newVal.intValue()));
		if(marqueText.getText().equals("BMW")){
			PuissanceSlider.setMin(7);
			PuissanceSlider.setMax(36);}
		 if(marqueText.getText().equals("AUDI")){
			PuissanceSlider.setMin(5);
			PuissanceSlider.setMax(26);	}
		 if(marqueText.getText().equals("CITROEN")){
			PuissanceSlider.setMin(2);
			PuissanceSlider.setMax(16);	}
		 if(marqueText.getText().equals("FIAT")){
			PuissanceSlider.setMin(3);
			PuissanceSlider.setMax(11);	}
		 if(marqueText.getText().equals("RENAULT")){
			PuissanceSlider.setMin(1);
			PuissanceSlider.setMax(23);	}
		 if(marqueText.getText().equals("KIA")){
			PuissanceSlider.setMin(4);
			PuissanceSlider.setMax(12);	}
		 if(marqueText.getText().equals("MINI COOPER")){
			PuissanceSlider.setMin(4);
			PuissanceSlider.setMax(14);	}
		 if(marqueText.getText().equals("VOLKSWAGEN")){
			PuissanceSlider.setMin(3);
			PuissanceSlider.setMax(19);	}
		 if(marqueText.getText().equals("NISSAN")){
			PuissanceSlider.setMin(4);
			PuissanceSlider.setMax(25);	}
		 if(marqueText.getText().equals("PEUGEOT")){
			PuissanceSlider.setMin(1);
			PuissanceSlider.setMax(11);	}
		 if(marqueText.getText().equals("DACIA")){
			PuissanceSlider.setMin(4);
			PuissanceSlider.setMax(7);	}
		 if(marqueText.getText().equals("TOYOTA")){
			PuissanceSlider.setMin(3);
			PuissanceSlider.setMax(19);	}
		 
		PuissanceLabel.setText("(" + String.valueOf(PuissanceSlider.getValue())+ " CV)");}
	
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
	public void obetnirDevisAction(MouseEvent event) throws Exception {

		boolean valid=true;
		  if (firstNametxt.getText().equals("")) {
	            firstNameLabel.setText("Field is empty !");
	            firstNameLabel.setVisible(true);
	            valid = false;
	        } else {
	            firstNameLabel.setText("");
	        }
	        if (lastNametxt.getText().equals("")) {
	            lastNameLabel.setText("Field is empty !");
	            lastNameLabel.setVisible(true);
	            valid = false;
	        } else {
	            lastNameLabel.setText("");
	        }
	        
	        if (cinTxt.getText().equals("")) {
	            cinLabel.setText("Field is empty !");
	            cinLabel.setVisible(true);
	            valid = false;
	        } else {
	            cinLabel.setText("");
	        }
	        
	        if (marqueText.getText().equals("")) {
	            vehicleLabel.setText("No Vehicle chosen !");
	            vehicleLabel.setVisible(true);
	            valid = false;
	        } else {
	            vehicleLabel.setText("");
	        }
		
        if (picker.getValue() == null) {
            circulationDateLabel.setText("Field is empty !");
            circulationDateLabel.setVisible(true);
            valid = false;
        }else{
        	circulationDateLabel.setText("");
        }
		if (picker.getValue()!= null &&((new Date()).getTime() - java.sql.Date.valueOf(picker.getValue()).getTime()) < 0){
			picker.getStyleClass().add("error");
			Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid date of first Circulation !", ButtonType.OK);
			alert.show();
			valid=false;
		}
		
        if (birthDatePicker.getValue() == null) {
            birthDateLabel.setText("Field is empty !");
            birthDateLabel.setVisible(true);
            valid = false;
        }else{
        	birthDateLabel.setText("");
        }
		
        if (birthDatePicker.getValue()!= null &&((new Date()).getYear() - java.sql.Date.valueOf(birthDatePicker.getValue()).getYear()) < 18){
            birthDatePicker.getStyleClass().add("error");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Customer must at least 18 years old!", ButtonType.OK);
            alert.show();
        return;    
	        }
        
        if (comboLostP.getValue() == null) {
            labelPointsLosted.setText("Field is empty !");
            labelPointsLosted.setVisible(true);
            valid = false;
        }else{
        	labelPointsLosted.setText("");
        }
        
        if (comboModeParking.getValue() == null) {
            modeOfParkingLabel.setText("Field is empty !");
            modeOfParkingLabel.setVisible(true);
            valid = false;
        }else{
        	modeOfParkingLabel.setText("");
        }
        
        if (comboSinistersNumber.getValue() == null) {
            numberOfSinistersLabel.setText("Field is empty !");
            numberOfSinistersLabel.setVisible(true);
            valid = false;
        }else{
        	numberOfSinistersLabel.setText("");
        }
      	
		if(!valid) return;
		if (tiersCheckBox.isSelected()){
			vQuotation.setOption_vehicle("Tiers");
		}
		else if(tiersEtenduCheckBox.isSelected()){
			vQuotation.setOption_vehicle("Tiers Etendu");
		}
		else if(tousRisquesCheckBox.isSelected()){
			vQuotation.setOption_vehicle("All Risks");
		}
		user.setFirstName(firstNametxt.getText());
		user.setLastName(lastNametxt.getText());
		user.setCin(Integer.parseInt(cinTxt.getText()));
		user.setBirthDate(java.sql.Date.valueOf(birthDatePicker.getValue()));
		user.setRole("Visitor");
		user.setNote(0);
		if(maleBox.isSelected()){
			user.setGender(true);
		}else if(femaleBox.isSelected()){
			user.setGender(false);
		}
		ServiceAddUser(user);
		vQuotation.setPropVehicle(RtarifActuel.isSelected());
		vQuotation.setPower((int)(PuissanceSlider.getValue()));
		vQuotation.setVehicleUsing(RUsageTous.isSelected());
		vQuotation.setKilometersNumber(kmSlider.getValue());
		vQuotation.setUsingFrequence(RfréquenceTous.isSelected());
		vQuotation.setParkingMode(comboModeParking.getValue());
		vQuotation.setLostPoints(Integer.parseInt(comboLostP.getValue()));
		vQuotation.setSinistersNumber(Integer.parseInt(comboSinistersNumber.getValue()));
		vQuotation.setCreation_date(java.sql.Date.valueOf(picker.getValue()));
		vQuotation.setCirculationDate(java.sql.Date.valueOf(picker.getValue()));
		vQuotation.setMark(marqueText.getText());
		txtBonusMalus.setText(String.valueOf(calculBonuMalus()));
		calculPrime();
		if(tiersEtenduCheckBox.isSelected()){
			primeTxtField.setText(Double.toString(calculPrime()*1.51));
		}
		else if(tousRisquesCheckBox.isSelected()){
			primeTxtField.setText(Double.toString(calculPrime()*2.22));
		}
		else if(tiersCheckBox.isSelected()){
			primeTxtField.setText(Double.toString(calculPrime()));
		}
		showResult();
	}

	public double calculPuissance(){
		int n =vQuotation.getSinistersNumber();
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
		int amortissement=new Date().getYear() - java.sql.Date.valueOf(picker.getValue()).getYear();
		double bonusMalus=1;
		double[] ti;
		ti= new double[13];
		if (vQuotation.getSinistersNumber()!=0){
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

	public void showResult() throws IOException{
		String s= primeTxtField.getText();
		int cin = Integer.parseInt(cinTxt.getText());
		final Stage dialog = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/QuotationResult.fxml"));
		AnchorPane pane = loader.load();
		dialog.initModality(Modality.APPLICATION_MODAL);
		Scene dialogScene = new Scene(pane, 573, 408);
		((QuotationResultController)loader.getController()).setParams(dialog);
		((QuotationResultController)loader.getController()).setResult(s);
		((QuotationResultController)loader.getController()).setVehicleQuotation(vQuotation);
		((QuotationResultController)loader.getController()).setCin(cin);
		dialog.setScene(dialogScene);
		dialog.show();
	}
	public double calculPrime(){
		double prime=0;
		double BmwTarifPrimordial=824;
		double AudiTarifPrimordial=660;
		double FiatTarifPrimordial=500;
		double VolswagenTarifPrimordial=530;
		double KiaTarifPrimordial=478;
		double NissanTarifPrimordial=450;
		double MiniCooperTarifPrimordial=555;
		double CitroenTarifPrimordial=510;
		double PeugeotTarifPrimordial=442;
		double ToyotaTarifPrimordial=530;
		double DaciaTarifPrimordial=420;
		double RenaultTarifPrimordial=410;
		
		if(vQuotation.getPower()>7){
		if(vQuotation.getKilometersNumber()>8000){
			if(vQuotation.getMark().equals("BMW")){
				prime=1.2*BmwTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("AUDI")){
				prime=1.2*AudiTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("FIAT")){
				prime=1.2*FiatTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("VOLKSWAGEN")){
				prime=1.2*VolswagenTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("KIA")){
				prime=1.2*KiaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("NISSAN")){
				prime=1.2*NissanTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("MINI COOPER")){
				prime=1.2*MiniCooperTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("CITROEN")){
				prime=1.2*CitroenTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("PEUGEOT")){
				prime=1.2*PeugeotTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("TOYOTA")){
				prime=1.2*ToyotaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("DACIA")){
				prime=1.2*DaciaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("RENAULT")){
				prime=1.2*RenaultTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}}
		else
		{if(vQuotation.getMark().equals("BMW")){
			prime=1.2*0.85*BmwTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("AUDI")){
			prime=1.2*0.85*AudiTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("FIAT")){
			prime=1.2*0.85*FiatTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("VOLKSWAGEN")){
			prime=1.2*0.85*VolswagenTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("KIA")){
			prime=1.2*0.85*KiaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("NISSAN")){
			prime=1.2*0.85*NissanTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("MINI COOPER")){
			prime=1.2*0.85*MiniCooperTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("CITROEN")){
			prime=1.2*0.85*CitroenTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("PEUGEOT")){
			prime=1.2*0.85*PeugeotTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("TOYOTA")){
			prime=1.2*0.85*ToyotaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("DACIA")){
			prime=1.2*0.85*DaciaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		else if(vQuotation.getMark().equals("RENAULT")){
			prime=1.2*0.85*RenaultTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
		}
		}}else{
			if(vQuotation.getKilometersNumber()>8000){
				if(vQuotation.getMark().equals("BMW")){
					prime=BmwTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("AUDI")){
					prime=AudiTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("FIAT")){
					prime=FiatTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("VOLKSWAGEN")){
					prime=VolswagenTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("KIA")){
					prime=KiaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("NISSAN")){
					prime=NissanTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("MINI COOPER")){
					prime=MiniCooperTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("CITROEN")){
					prime=CitroenTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("PEUGEOT")){
					prime=PeugeotTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("TOYOTA")){
					prime=ToyotaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("DACIA")){
					prime=DaciaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}
				else if(vQuotation.getMark().equals("RENAULT")){
					prime=RenaultTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
				}}
			else
			{if(vQuotation.getMark().equals("BMW")){
				prime=0.85*BmwTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("AUDI")){
				prime=0.85*AudiTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("FIAT")){
				prime=0.85*FiatTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("VOLKSWAGEN")){
				prime=0.85*VolswagenTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("KIA")){
				prime=0.85*KiaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("NISSAN")){
				prime=0.85*NissanTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("MINI COOPER")){
				prime=0.85*MiniCooperTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("CITROEN")){
				prime=0.85*CitroenTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("PEUGEOT")){
				prime=0.85*PeugeotTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("TOYOTA")){
				prime=0.85*ToyotaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("DACIA")){
				prime=0.85*DaciaTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			else if(vQuotation.getMark().equals("RENAULT")){
				prime=0.85*RenaultTarifPrimordial*Double.valueOf(txtBonusMalus.getText());
			}
			}
		}return prime;
	}
    @FXML
    void checkBonusAction(ActionEvent event) throws IOException {
    	
		boolean valid=true;
        if (picker.getValue() == null) {
            circulationDateLabel.setText("Field is empty !");
            circulationDateLabel.setVisible(true);
            valid = false;
        }else{
        	circulationDateLabel.setText("");
        }
		
		if (picker.getValue()!= null &&((new Date()).getTime() - java.sql.Date.valueOf(picker.getValue()).getTime()) < 0){
			picker.getStyleClass().add("error");
			Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid date of first Circulation !", ButtonType.OK);
			alert.show();
			valid=false;
		}
        if (comboSinistersNumber.getValue() == null) {
            numberOfSinistersLabel.setText("Field is empty !");
            numberOfSinistersLabel.setVisible(true);
            valid = false;
        }else{
        	numberOfSinistersLabel.setText("");
        }
        
		if(!valid) return;
		vQuotation.setSinistersNumber(Integer.parseInt(comboSinistersNumber.getValue()));
		vQuotation.setCreation_date(java.sql.Date.valueOf(picker.getValue()));
		txtBonusMalus.setText(String.valueOf(calculBonuMalus()));
		String s= txtBonusMalus.getText();
		final Stage dialog = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CheckBonusMalusView.fxml"));
		Pane pane = loader.load();
		dialog.initModality(Modality.APPLICATION_MODAL);
		Scene dialogScene = new Scene(pane, 534, 355);
		((CheckBonusMalusController)loader.getController()).setParams(dialog);
	    ((CheckBonusMalusController)loader.getController()).setResult(s);
		dialog.setScene(dialogScene);
		dialog.show();
    }
}
