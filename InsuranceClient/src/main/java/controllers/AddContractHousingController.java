package controllers;

import java.awt.geom.CubicCurve2D.Float;
import java.net.URL;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import entities.Agent;
import entities.Client;
import entities.Contract.type_contract;
import entities.Housing;
import entities.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.SwitchScreen;
import util.Test;

public class AddContractHousingController implements Initializable {

	@FXML
	private AnchorPane anchor;

	@FXML
	private RadioButton garageyes;

	@FXML
	private ToggleGroup garage;

	@FXML
	private RadioButton garageno;

	@FXML
	private RadioButton empty;

	@FXML
	private ToggleGroup empty1;

	@FXML
	private RadioButton emptyno;

	@FXML
	private ComboBox<String> houseprotectBox;
	ObservableList<String> houseprotectList = FXCollections.observableArrayList();

	@FXML
	private Button confirmer;

	@FXML
	private Button back;

	@FXML
	private Label protect1;

	@FXML
	private Label secured1;

	@FXML
	private Label floor1;

	@FXML
	private Label value1;

	@FXML
	private Label buildyear1;

	@FXML
	private Label value2;

	@FXML
	private Label unhabited1;

	@FXML
	private Label code1;

	@FXML
	private Label relationLabel;

	@FXML
	private Label gurantee1;
	@FXML
	private Label type;
	@FXML
	private JFXTextField country;

	@FXML
	private JFXTextField housevalue;

	@FXML
	private JFXTextField objectvalue;

	@FXML
	private JFXTextField buildyear;

	@FXML
	private JFXTextField unhabiteddays;

	@FXML
	private JFXTextField commission;
	@FXML
	private DatePicker date;

	@FXML
	private Label addressLabel;
	@FXML
	private Label appartment;

	@FXML
	private JFXTextField housetype;
	@FXML
	private ComboBox<String> housetypebox;
	ObservableList<String> housetypelist = FXCollections.observableArrayList();

	@FXML
	private ComboBox<String> objectsBox;
	ObservableList<String> objectsList = FXCollections.observableArrayList();

	@FXML
	private JFXTextField city;

	@FXML
	private ComboBox<String> sinisterbox;
	ObservableList<String> sinisterList = FXCollections.observableArrayList();
	@FXML
	private ComboBox<String> buildbox;
	ObservableList<String> buildList = FXCollections.observableArrayList();

	@FXML
	private ComboBox<String> floorbox;
	ObservableList<String> floorList = FXCollections.observableArrayList();

	@FXML
	private ComboBox<String> guaranteebox;
	ObservableList<String> guaranteeList = FXCollections.observableArrayList();

	@FXML
	private ToggleGroup owner1;
	@FXML
	private RadioButton owneryes;

	@FXML
	private ToggleGroup smoking1;

	@FXML
	private RadioButton owner;

	@FXML
	private JFXTextField code;

	Housing h = new Housing();
	type_contract tc;

	public Client cl;

	public void setclient(Client cl) {

		this.cl = cl;
		
		appartment.setVisible(false);
		floorbox.setVisible(false);

		housetypelist.addAll("country house", "Villa", "Appartment");
		housetypebox.setItems(housetypelist);

		buildList.addAll("New", "-10", "10_20", "+30");
		buildbox.setItems(buildList);
		floorList.addAll("ground floor", "Frist", "other");
		floorbox.setItems(floorList);
		guaranteeList.addAll("HO-8", "HO-5", "HO-3", "HO-2");
		guaranteebox.setItems(guaranteeList);
		objectsList.addAll("clothings", "jollerie", "Electronics", "doors", "windows", "other");
		objectsBox.setItems(objectsList);
		houseprotectList.addAll("alarme", "armored door", "video surveillance", "smoke detector", "none");
		houseprotectBox.setItems(houseprotectList);
		sinisterList.addAll("none", "1", "2", "3", "3+");
		sinisterbox.setItems(sinisterList);
		System.out.println(cl.getCin());
	}

	@SuppressWarnings("deprecation")
	@FXML
	void addContract(ActionEvent event) throws Exception {
		int cin = cl.getCin();
		Test t = new Test();
		User user = new User();
		user = t.Servicegetuser(cin);

		boolean valid = true;

		if (country.getText().equals("")) {
			addressLabel.setText("Field is empty !");
			addressLabel.setVisible(true);
			valid = false;
		} else {
			addressLabel.setText("");
		}

		if (objectvalue.getText().equals("")) {
			value1.setText("Field is empty !");
			value1.setVisible(true);
			valid = false;
		} else {
			value1.setText("");
		}

		if (unhabiteddays.getText().equals("")) {
			unhabited1.setText("Field is empty !");
			unhabited1.setVisible(true);
			valid = false;
		} else {
			unhabited1.setText("");
		}

		if (code.getText().equals("")) {
			code1.setText("Field is empty !");
			code1.setVisible(true);
			valid = false;
		} else {
			code1.setText("");
		}

		/*
		 * if (floorbox.getValue() == null) {
		 * floor1.setText("Field is empty !"); floor1.setVisible(true); valid =
		 * false; } else { floor1.setText(""); }
		 */

		if (buildbox.getValue() == null) {
			buildyear1.setText("Field is empty !");
			buildyear1.setVisible(true);
			valid = false;
		} else {
			buildyear1.setText("");
		}

		if (guaranteebox.getValue() == null) {
			gurantee1.setText("Field is empty !");
			gurantee1.setVisible(true);
			valid = false;
		} else {
			gurantee1.setText("");
		}

		if (objectsBox.getValue() == null) {
			secured1.setText("Field is empty !");
			secured1.setVisible(true);
			valid = false;
		} else {
			secured1.setText("");
		}

		if (houseprotectBox.getValue() == null) {
			protect1.setText("Field is empty !");
			protect1.setVisible(true);
			valid = false;
		} else {
			protect1.setText("");
		}
		if (housevalue.getText().equals("")) {
			value2.setText("Field is empty !");
			value2.setVisible(true);
			valid = false;
		} else {
			value2.setText("");
		}

		//
		if (!valid) {
			return;
		}

		h.setAddress(city.getText());
		h.setArea(country.getText());
		h.setCodePostal(Integer.parseInt(code.getText()));
		h.setFloorapartment(floorbox.getValue());
		if (garageyes.isSelected()) {
			h.setGarage("yes");
		} else {
			h.setGarage("no");
		}
		if (empty.isSelected()) {
			h.setHouseempty("empty");
		} else {
			h.setHouseempty("no");
		}

		if (owneryes.isSelected()) {
			h.setHouseownertype("yes");
		} else {
			h.setHouseownertype("no");
		}

		if (housetypebox.getValue().equals("")) {
			type.setText("Field is empty !");
			type.setVisible(true);
			valid = false;
		} else {
			type.setText("");
		}

		h.setGuarantee(guaranteebox.getValue());
		h.setHomemainsec("homemainsec");
		h.setHouseduration(buildbox.getValue());
		h.setType_housing(housetypebox.getValue());

		h.setHouseProtection(houseprotectBox.getValue());
		h.setHousevalue(Integer.parseInt(housevalue.getText()));
		h.setImage("image");
		h.setObjectsinsured(objectsBox.getValue());
		h.setObjectsvalue(Integer.parseInt(objectvalue.getText()));
		h.setSinisternmbr(Integer.parseInt(sinisterbox.getValue()));
		h.setUninhabited(Integer.parseInt(unhabiteddays.getText()));
		Date today = new Date();
		today.setHours(0);

		h.setCommission(Integer.parseInt(commission.getText()));
		h.setDate_end(java.sql.Date.valueOf(date.getValue()));
		h.setEtatdemande("on hold");
		h.setType_contract(tc.housing);

		System.out.println(java.sql.Date.valueOf(date.getValue()).toString());
		h.setDate_creation(java.sql.Date.valueOf(java.time.LocalDate.now()));

		h.setClient((Client) user);

		System.out.println(h.toString());

		System.out.println(h.getPrime());

		float prime = calculerprime(h);
		h.setPrime(prime);
		t.ServiceAddHousingContract(h);

		/*
		 * FXMLLoader loader=new
		 * FXMLLoader(getClass().getResource("/views/Contracthousingview.fxml"))
		 * ;
		 * 
		 * Parent root = (Parent) loader.load();
		 * 
		 * Stage stage=new Stage(); stage.setScene(new Scene(root));
		 * stage.show();
		 */

		FXMLLoader loader = parentContainer.switchViewTo("/views/Contracthousingview.fxml");
		((ContracthousingController) loader.getController()).setContainer(parentContainer);

	}

	public float calculerprime(Housing h) {
		float prime;
		float expense_per_exposure_unit1 = 25;
		float expense_per_exposure_unit2 = 310;

		float exposure_unit = 100000;

		float exposure_unit2 = 100000;
		float housevaluee = 0;
		float objectsvalue = 0;
		float protect = 1.05f;
		float unhabited = 1.03f;
		float sinistercoff = 0;
		float guranteevalue = 0;
		float b = 0;
		if (h.getObjectsvalue() == 0) {
			objectsvalue = h.getObjectsvalue() / exposure_unit2 * expense_per_exposure_unit2;
			housevaluee = h.getHousevalue() / exposure_unit * expense_per_exposure_unit1;
			b = housevaluee;

		} else if (h.getHousevalue() == 0) {
			objectsvalue = h.getObjectsvalue() / exposure_unit2 * expense_per_exposure_unit2;
			housevaluee = h.getHousevalue() / exposure_unit * expense_per_exposure_unit1;
			b = objectsvalue;

		} else {
			objectsvalue = h.getObjectsvalue() / exposure_unit2 * expense_per_exposure_unit2;
			housevaluee = h.getHousevalue() / exposure_unit * expense_per_exposure_unit1;
			b = objectsvalue + housevaluee;
		}

		HashMap<Double, String> hmap = new HashMap<Double, String>();

		double franchise = 0.3;
		if (h.getSinisternmbr() == 0) {
			sinistercoff = 0;
		} else if (h.getSinisternmbr() == 1) {
			sinistercoff = (float) (housevaluee * 0.1 + objectsvalue * 0.01);
		} else if (h.getSinisternmbr() == 2) {
			sinistercoff = (float) (housevaluee * 0.15 + objectsvalue * 0.015);

		} else {
			sinistercoff = (float) (housevaluee * 0.2 + objectsvalue * 0.02);

		}

		if (h.getHouseProtection() == "none") {
			protect = 1;
		}

		if (h.getUninhabited() < 180) {
			unhabited = 1;
		}

		if (h.getGuarantee() == "HO-2") {// 11
			guranteevalue = 1;
		}
		if (h.getGuarantee() == "HO-3") {// 16
			guranteevalue = 1.2f;
		}
		if (h.getGuarantee() == "HO-5") {// 16 and covers personal property from
											// almost every peri
			guranteevalue = 1.4f;
		}
		if (h.getGuarantee() == "HO-8") { // only 11 and low prime cost in
											// gurantee not all the amount
											// refunded
			guranteevalue = 0.9f;
		}

		prime = (((b + sinistercoff) * protect) * unhabited) * guranteevalue;

		/*
		 * hmap.put(0.2, "1"); hmap.put(1, "tous risque"); hmap.put(7, "Singh");
		 * hmap.put(49, "Ajeet"); hmap.put(3, "Anuj");
		 */

		System.out.print("prime");

		return prime;

	}

	@FXML
	void show(ActionEvent event) {
		if (housetypebox.getValue().equals("Appartment")) {

			appartment.setVisible(true);
			floorbox.setVisible(true);
		} else {
			appartment.setVisible(false);
			floorbox.setVisible(false);
		}

	}

	@FXML
	void returnIns(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void startstage() {

		appartment.setVisible(false);
		floorbox.setVisible(false);

		housetypelist.addAll("country house", "Villa", "Appartment");
		housetypebox.setItems(housetypelist);

		buildList.addAll("New", "-10", "10_20", "+30");
		buildbox.setItems(buildList);
		floorList.addAll("ground floor", "Frist", "other");
		floorbox.setItems(floorList);
		guaranteeList.addAll("HO-8", "HO-5", "HO-3", "HO-2");
		guaranteebox.setItems(guaranteeList);
		objectsList.addAll("clothings", "jollerie", "Electronics", "doors", "windows", "other");
		objectsBox.setItems(objectsList);
		houseprotectList.addAll("alarme", "armored door", "video surveillance", "smoke detector", "none");
		houseprotectBox.setItems(houseprotectList);
		sinisterList.addAll("none", "1", "2", "3", "3+");
		sinisterbox.setItems(sinisterList);
		System.out.println(cl.getCin());

	}

	ContractHousingContainerController parentContainer;

	public void setContainer(ContractHousingContainerController parentContainer) {
		this.parentContainer = parentContainer;
	}

}
