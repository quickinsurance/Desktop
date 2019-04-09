package controllers;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Agent;
import entities.Client;
import entities.Health;
import entities.HealthQuotation;
import entities.User;
import entities.Contract.type_contract;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import services.interf.IClientInterfaceRemote;
import services.interf.IHealthInterfaceRemote;
import services.interf.IQuotationInterfaceRemote;
import services.interf.UserServiceRemote;

public class AddHealthContractController implements Initializable {
	@FXML
	private Label title;
	@FXML
	private TextField txtFFirnstName;

	@FXML
	private TextField txtFLastName;

	@FXML
	private DatePicker birthDate;

	@FXML
	private ChoiceBox<String> familySituation;

	@FXML
	private ChoiceBox<String> profission;

	@FXML
	private TextField txtFAddress;

	@FXML
	private TextField txtFPhone;

	@FXML
	private TextField txtFEmail;

	@FXML
	private ChoiceBox<String> familyNumber;

	@FXML
	private RadioButton yesChronicHealth;

	@FXML
	private RadioButton noChronicHealth;

	@FXML
	private RadioButton donotkhnowChronicHealth;

	@FXML
	private RadioButton veryGoodHealth;

	@FXML
	private RadioButton goodHealth;

	@FXML
	private RadioButton badHealth;

	@FXML
	private RadioButton averageHealth;

	@FXML
	private RadioButton veryBadHealth;

	@FXML
	private RadioButton yesSmoke;

	@FXML
	private RadioButton noSmoke;

	@FXML
	private RadioButton yesDangerSport;

	@FXML
	private RadioButton noDangerSport;

	@FXML
	private RadioButton yesAlcohol;

	@FXML
	private RadioButton noAlcohol;

	@FXML
	private CheckBox consultations;

	@FXML
	private CheckBox pharmaceuticals;

	@FXML
	private CheckBox analysisMadical;

	@FXML
	private TextField txtFSalary;

	@FXML
	private CheckBox radiology;

	@FXML
	private CheckBox surgery;

	@FXML
	private CheckBox optical;

	@FXML
	private CheckBox dentalCare;

	@FXML
	private Button calculatePremuim;

	@FXML
	private Button btnCancel;

	@FXML
	private RadioButton women;

	@FXML
	private RadioButton man;

	@FXML
	private VBox childHbox;

	@FXML
	private ChoiceBox<String> nbrChild;

	@FXML
	private VBox partnerForm;

	@FXML
	private DatePicker birthdatePartner;

	@FXML
	private ChoiceBox<String> professionPartner;

	@FXML
	private RadioButton economicFormula;

	@FXML
	private RadioButton budgetformula;

	@FXML
	private RadioButton confortformula;
	@FXML
	private RadioButton publicHealthcare;

	@FXML
	private RadioButton privateHealthCare;

	// Cotisation
	float Cotisation;

	@FXML
	private TextField cin;
	Float premium = 0f;
	@FXML
	private ToggleGroup groupeGender;
	@FXML
	private ToggleGroup groupeSmoke;
	@FXML
	private ToggleGroup groupealcohol;
	@FXML
	private ToggleGroup groupeDangerousSport;
	@FXML
	private ToggleGroup groupeChronicIlness;
	@FXML
	private ToggleGroup groupeGeneralHealth;
	@FXML
	private ToggleGroup groupeFormulas;
	@FXML
	private ToggleGroup groupeHealthCare;
	// Prime pure
	float ppConsultation, ppPharmatical, ppAnalysis, ppradio, ppOptical, ppDenntal, ppSurgery;
	// Charge de sécurié
	float CSConsult, CSPharma, CSAnalys, Csradio, CsOPtical, CsdentalCare, CsSurgery;
	// Cout unitaire
	float CUConsult, CUPharma, CURadio, CUOptical, CUDentalCare, CUSurgery, CUAnaluse;
	// Surplus et reserve
	float SPRConsult, SPROptical, SPRPharma, SPRRadio, SPRDental, SPRSurgery, SPRANalys;
	// cotisation par service
	float CConsult, COptique, CRadio, CPharma, CDental, CSurgery, Canalys;
	
	private ManageHealthContractsContainerController containerParent;
	
    public void setContainer(ManageHealthContractsContainerController container){
        this.containerParent = container;
    }

	@FXML
	void calculatePremuimAction(ActionEvent event) {

		ppConsultation = 0;
		ppPharmatical = 0;
		ppAnalysis = 0;
		ppradio = 0;
		ppOptical = 0;
		ppDenntal = 0;
		ppSurgery = 0;
		CSConsult = 0;
		CSPharma = 0;
		CSAnalys = 0;
		Csradio = 0;
		CsOPtical = 0;
		CsdentalCare = 0;
		CsSurgery = 0f;

		CUConsult = 0;
		CUPharma = 0;
		CURadio = 0;
		CUOptical = 0;
		CUDentalCare = 0;
		CUSurgery = 0;
		CUAnaluse = 0f;

		SPRConsult = 0;
		SPROptical = 0;
		SPRPharma = 0;
		SPRRadio = 0;
		SPRDental = 0;
		SPRSurgery = 0;
		SPRANalys = 0;

		CConsult = 0;
		COptique = 0;
		CRadio = 0;
		CPharma = 0;
		CDental = 0;
		CSurgery = 0;
		Canalys = 0;

		premium = 0f;
		Cotisation = 0f;
		String smoke = "";
		String sport = "";
		String alcohole = "";
		String gender = "";
		String chronic = "";
		String generalHealth = "";
		String Options = "";
		String formuleContract = "";
		String healthCare = "";
		if (consultations.isSelected())
			Options = Options + consultations.getText();

		if (pharmaceuticals.isSelected())
			Options = Options + "," + pharmaceuticals.getText();

		if (analysisMadical.isSelected())
			Options = Options + "," + analysisMadical.getText();
		if (optical.isSelected())
			Options = Options + "," + optical.getText();

		if (dentalCare.isSelected())
			Options = Options + "," + dentalCare.getText();
		if (radiology.isSelected())
			Options = Options + "," + radiology.getText();
		if (surgery.isSelected())
			Options = Options + "," + surgery.getText();

		String jndiNameUser = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context contextUser;
		String jndiNameQotation = "Insurance-ear/Insurance-ejb/HealthQuotationServiceImlem!services.interf.IQuotationInterfaceRemote";
		Context contextQuotation;
		String jndiNameClient = "Insurance-ear/Insurance-ejb/ClientServiceImplem!services.interf.IClientInterfaceRemote";
		Context contextClient;
		String jndiNameHealth = "Insurance-ear/Insurance-ejb/HealthServiceImplem!services.interf.IHealthInterfaceRemote";
		Context contextHealth;
		String errorMessage = "";
		if (txtFFirnstName.getText() == null || txtFFirnstName.getText().length() == 0)
			errorMessage += "Add First Name Please !\n";
		if (txtFLastName.getText() == null || txtFLastName.getText().length() == 0)
			errorMessage += "Add Last Name Please! \n";
		if (birthDate.getValue() == null)
			errorMessage += "Add Birth Date please! \n";
		else if (birthDate.getValue().isAfter(LocalDate.now().minusYears(18)))
			errorMessage += "Birth Date Not Valide! \n";
		try {

			Integer.parseInt(cin.getText());
		} catch (NumberFormatException f) {
			errorMessage += "Not Valid CIN !! \n";
		}
		if (cin.getText().length() != 8 || cin.getText() == null)
			errorMessage += "Not Valid length of CIN !! \n";

		if (familySituation.getValue() == null || familySituation.getValue().length() == 0)
			errorMessage += "Add Family Situation Please! \n";
		if (profission.getValue() == null || profission.getValue().length() == 0)
			errorMessage += "Add Job Please ! \n";
		if (txtFAddress.getText() == null || txtFAddress.getText().length() == 0)
			errorMessage += "Add Your Adress please! \n";

		try {

			Integer.parseInt(txtFPhone.getText());
		} catch (NumberFormatException f) {
			errorMessage += "Not Valid Phone !! \n";
		}
		if (txtFPhone.getText().length() != 8 || txtFPhone.getText() == null)
			errorMessage += "Not Valid  length Phone !! \n";
		if (txtFEmail.getText() == null
				|| !txtFEmail.getText().matches("^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$")
				|| txtFEmail.getText().length() == 0)
			errorMessage += "Not Valid Email !! \n";
		try {
			Integer.parseInt(txtFSalary.getText());
		} catch (NumberFormatException f) {
			errorMessage += "Not Valid Salairy !! \n";
		}

		try {
			gender = ((RadioButton) this.groupeGender.getSelectedToggle()).getText();

		} catch (Exception e) {
			errorMessage += "Add Gender Please !! \n";
		}

		if (familyNumber.getValue() == null)
			errorMessage += "Add The People To Be Insured Please !! \n";
		else if (familyNumber.getValue().equals("You and your spouse")) {
			if (birthdatePartner.getValue() == null
					|| birthdatePartner.getValue().isAfter(LocalDate.now().minusYears(18)))
				errorMessage += "Birth Date Partner not Valid! \n";
		} else if (familyNumber.getValue().equals("You, your spouse and your children")) {
			if (birthdatePartner.getValue() == null
					|| birthdatePartner.getValue().isAfter(LocalDate.now().minusYears(18)))
				errorMessage += "Birth Date Partner not Valid! \n";
			if (nbrChild.getValue().equals("0"))
				errorMessage += "add number of child please !! \n";
		} else if (familyNumber.getValue().equals("You and your children")) {
			if (nbrChild.getValue().equals("0"))
				errorMessage += "add number of child please !! \n";
		}
		try {
			healthCare = ((RadioButton) this.groupeHealthCare.getSelectedToggle()).getText();

		} catch (Exception e) {
			errorMessage += "Choose a healthcare please !! \n";
		}
		try {
			formuleContract = ((RadioButton) this.groupeFormulas.getSelectedToggle()).getText();

		} catch (Exception e) {
			errorMessage += "Choose a formula please !! \n";
		}
		if (Options.length() == 0)
			errorMessage += "Add Options Please ? \n";
		try {
			generalHealth = ((RadioButton) this.groupeGeneralHealth.getSelectedToggle()).getText();

		} catch (Exception e) {
			errorMessage += "Add General Health Please !! \n";
		}

		try {
			chronic = ((RadioButton) this.groupeChronicIlness.getSelectedToggle()).getText();

		} catch (Exception e) {
			errorMessage += "Do You Suffer From an Illness or Chronic health Problem!! \n";
		}

		try {
			smoke = ((RadioButton) this.groupeSmoke.getSelectedToggle()).getText();

		} catch (Exception e) {
			errorMessage += "Do you Smoke Please ? \n";

		}

		try {
			sport = ((RadioButton) this.groupeDangerousSport.getSelectedToggle()).getText();

		} catch (Exception e) {
			errorMessage += "Do you practice Dangerous Sports ? \n";
		}
		try {
			alcohole = ((RadioButton) this.groupealcohol.getSelectedToggle()).getText();

		} catch (Exception e) {
			errorMessage += "Do you Drink Alcohol Please ? \n";
		}

	

		if (errorMessage.length() == 0) {
			
			
			// Calcule du prime
			// calcule prime pure majorée et charge de sécurité

			if (healthCare.contains("public")) {
				if (Options.contains(consultations.getText())) {
					ppConsultation = (float) ((10 * 87.9 / 100) * 1.15 * 12);
					if (gender.equals("women"))
						ppConsultation = (float) (ppConsultation * 1.15);
					if (formuleContract.equals(economicFormula.getText()))
						ppConsultation = ppConsultation * 50 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppConsultation = ppConsultation * 60 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppConsultation = ppConsultation * 70 / 100;
					CSConsult = (float) (ppConsultation * 0.14);

				}
				if (Options.contains(pharmaceuticals.getText())) {
					ppPharmatical = (float) ((50 * 50 / 100) * 1.15 * 12);
					if (gender.equals("women"))
						ppPharmatical = (float) (ppPharmatical * 1.15);
					if (formuleContract.equals(economicFormula.getText()))
						ppPharmatical = ppPharmatical * 75 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppPharmatical = ppPharmatical * 90 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppPharmatical = ppPharmatical * 100 / 100;
					CSPharma = (float) (ppPharmatical * 0.3);
				}
				if (Options.contains(analysisMadical.getText())) {
					ppAnalysis = (float) ((200 * 3 / 100) * 1.15);
					if (gender.equals("women"))
						ppAnalysis = (float) (ppAnalysis * 1.15);
					if (formuleContract.equals(economicFormula.getText()))
						ppAnalysis = ppAnalysis * 60 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppAnalysis = ppAnalysis * 80 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppAnalysis = ppAnalysis * 100 / 100;
					CSAnalys = (float) (ppAnalysis * 0.11);
				}
				if (Options.contains(radiology.getText())) {
					ppradio = (200 * 2 / 100);
					if (formuleContract.equals(economicFormula.getText()))
						ppradio = ppradio * 60 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppradio = ppradio * 80 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppradio = ppradio * 100 / 100;
					Csradio = (float) (ppradio * 0.48);
				}
				if (Options.contains(optical.getText())) {
					ppOptical = (150 * 80 / 100);
					if (formuleContract.equals(economicFormula.getText()))
						ppOptical = ppOptical * 40 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppOptical = ppOptical * 50 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppOptical = ppOptical * 60 / 100;
					CsOPtical = (float) (ppOptical * 0.02);
				}
				if (Options.contains(dentalCare.getText())) {
					ppDenntal = (50 * 58 / 100) * 12;
					if (formuleContract.equals(economicFormula.getText()))
						ppDenntal = ppDenntal * 50 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppDenntal = ppDenntal * 60 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppDenntal = ppDenntal * 70 / 100;
					CsdentalCare = (float) (ppDenntal * 0.02);
				}
				if (Options.contains(surgery.getText())) {
					ppSurgery = (300 * 2 / 100);
					if (gender.equals("women"))
						ppSurgery = (float) (ppSurgery * 1.15);
					if (formuleContract.equals(economicFormula.getText()))
						ppSurgery = ppSurgery * 60 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppSurgery = ppSurgery * 70 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppSurgery = ppSurgery * 80 / 100;

					CsSurgery = (float) (ppSurgery * 0.01);
				}

			} else if (healthCare.contains("private")) {
				if (Options.contains(consultations.getText())) {
					ppConsultation = (float) ((50 * 30 / 100) * 1.15 * 12);
					if (gender.equals("women"))
						ppConsultation = (float) (ppConsultation * 1.15);
					if (formuleContract.equals(economicFormula.getText()))
						ppConsultation = ppConsultation * 50 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppConsultation = ppConsultation * 60 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppConsultation = ppConsultation * 70 / 100;

					CSConsult = (float) (ppConsultation * 0.3);
				}
				if (Options.contains(pharmaceuticals.getText())) {
					ppPharmatical = (float) ((100 * 50 / 100) * 1.15 * 12);
					if (gender.equals("women"))
						ppPharmatical = (float) (ppPharmatical * 1.15);
					if (formuleContract.equals(economicFormula.getText()))
						ppPharmatical = ppPharmatical * 75 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppPharmatical = ppPharmatical * 90 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppPharmatical = ppPharmatical * 100 / 100;
					CSPharma = (float) (ppPharmatical * 0.3);
				}
				if (Options.contains(analysisMadical.getText())) {
					ppAnalysis = (float) ((1.1 * 1000 / 100) * 1.15);
					if (gender.equals("women"))
						ppAnalysis = (float) (ppAnalysis * 1.15);
					if (formuleContract.equals(economicFormula.getText()))
						ppAnalysis = ppAnalysis * 60 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppAnalysis = ppAnalysis * 80 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppAnalysis = ppAnalysis * 100 / 100;
					CSAnalys = (float) (ppAnalysis * 0.11);
				}
				if (Options.contains(radiology.getText())) {
					ppradio = (float) (1000 * 1.1 / 100);
					if (formuleContract.equals(economicFormula.getText()))
						ppradio = ppradio * 60 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppradio = ppradio * 80 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppradio = ppradio * 100 / 100;
					Csradio = (float) (ppradio * 0.48);
				}
				if (Options.contains(optical.getText())) {
					ppOptical = (300 * 80 / 100);
					if (formuleContract.equals(economicFormula.getText()))
						ppOptical = ppOptical * 40 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppOptical = ppOptical * 50 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppOptical = ppOptical * 60 / 100;
					CsOPtical = (float) (ppOptical * 0.02);
				}
				if (Options.contains(dentalCare.getText())) {
					ppDenntal = (300 * 50 / 100) * 12;
					if (formuleContract.equals(economicFormula.getText()))
						ppDenntal = ppDenntal * 50 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppDenntal = ppDenntal * 60 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppDenntal = ppDenntal * 70 / 100;
					CsdentalCare = (float) (ppDenntal * 0.02);
				}
				if (Options.contains(surgery.getText())) {
					ppSurgery = (2000 * 2 / 100);
					if (gender.equals("women"))
						ppSurgery = (float) (ppSurgery * 1.15);
					if (formuleContract.equals(economicFormula.getText()))
						ppSurgery = ppSurgery * 60 / 100;
					if (formuleContract.equals(budgetformula.getText()))
						ppSurgery = ppSurgery * 70 / 100;
					if (formuleContract.equals(confortformula.getText()))
						ppSurgery = ppSurgery * 80 / 100;
					CsSurgery = (float) (ppSurgery * 0.01);
				}
			}
			// calcue Cout unitaire des servives
			CUConsult = (ppConsultation + CSConsult) * 12 / 100;
			CUAnaluse = (ppAnalysis + CSAnalys) * 12 / 100;
			CUDentalCare = (ppDenntal + CsdentalCare) * 12 / 100;
			CUOptical = (ppOptical + CsOPtical) * 12 / 100;
			CUPharma = (ppPharmatical + CSPharma) * 12 / 100;
			CURadio = (ppradio + Csradio) * 12 / 100;
			CUSurgery = (ppSurgery + CsSurgery) * 12 / 100;

			// Calcule sur plus et reserve
			SPRConsult = (ppConsultation + CSConsult + CUConsult) * 7 / 100;
			SPRANalys = (ppAnalysis + CSAnalys + CUAnaluse) * 7 / 100;
			SPRDental = (ppDenntal + CsdentalCare + CUDentalCare) * 7 / 100;
			SPROptical = (ppOptical + CsOPtical + CUOptical) * 7 / 100;
			SPRPharma = (ppPharmatical + CSPharma + CUPharma) * 7 / 100;
			SPRRadio = (ppradio + Csradio + CURadio) * 7 / 100;
			SPRSurgery = (ppSurgery + CsSurgery + CUSurgery) * 7 / 100;

			// calcule cotisation par service

			CConsult = ppConsultation + CSConsult + CUConsult + SPRConsult;
			Canalys = ppAnalysis + CSAnalys + CUAnaluse + SPRANalys;
			CDental = ppDenntal + CsdentalCare + CUDentalCare + SPRDental;
			COptique = ppOptical + CsOPtical + CUOptical + SPROptical;
			CPharma = ppPharmatical + CSPharma + CUPharma + SPRPharma;
			CRadio = ppradio + Csradio + CURadio + SPRRadio;
			CSurgery = ppSurgery + CsSurgery + CUSurgery + SPRSurgery;

			/// Cotisation Individuelle totale

			Cotisation = CConsult + Canalys + CDental + COptique + CPharma + CRadio + CSurgery;

			/// majoration du cotisation selon l'age
			int age = LocalDate.now().getYear() - birthDate.getValue().getYear();
			if (age <= 29 && age >= 24)
				Cotisation = (float) (Cotisation * 1.05);
			if (age <= 35 && age >= 30)
				Cotisation = (float) (Cotisation * 1.1);
			if (age <= 41 && age >= 36)
				Cotisation = (float) (Cotisation * 1.15);
			if (age <= 47 && age >= 42)
				Cotisation = (float) (Cotisation * 1.2);
			if (age <= 53 && age >= 48)
				Cotisation = (float) (Cotisation * 1.25);
			if (age <= 59 && age >= 54)
				Cotisation = (float) (Cotisation * 1.3);
			if (age <= 65 && age >= 60)
				Cotisation = (float) (Cotisation * 1.35);
			if (age < 70 && age >= 66)
				Cotisation = (float) (Cotisation * 1.4);

			// health majoration or bonus

			if (generalHealth.equals("very good"))
				Cotisation = Cotisation - Cotisation * 0.1f;
			if (generalHealth.equals("good"))
				Cotisation = Cotisation - Cotisation * 0.05f;
			if (generalHealth.equals("bad"))
				Cotisation = Cotisation + Cotisation * 0.05f;
			if (generalHealth.equals("very bad"))
				Cotisation = Cotisation + Cotisation * 0.1f;

			if (chronic.equals("yes"))
				Cotisation = Cotisation * 1.1f;
			if (chronic.equals("don't know"))
				Cotisation = Cotisation * 1.05f;
			if (smoke.equals("yes"))
				Cotisation = Cotisation * 1.2f;
			if (alcohole.equals("yes"))
				Cotisation = Cotisation * 1.2f;
			if (sport.equals("yes"))
				Cotisation = Cotisation * 1.15f;
			/// majoration sur nbr D'enfant

			int enfant = Integer.parseInt(nbrChild.getValue());
			if (enfant != 0)
				Cotisation = Cotisation + Cotisation * enfant / 2;
			// majoration sur partener
			if (familyNumber.getValue().contains("spouse")) {
				float cotSpouse = Cotisation * 75 / 100;
				int agespouse = LocalDate.now().getYear() - birthdatePartner.getValue().getYear();
				if (agespouse <= 29 && agespouse >= 24)
					cotSpouse = (float) (cotSpouse * 1.05);
				if (agespouse <= 35 && agespouse >= 30)
					cotSpouse = (float) (cotSpouse * 1.1);
				if (agespouse <= 41 && agespouse >= 36)
					cotSpouse = (float) (cotSpouse * 1.15);
				if (agespouse <= 47 && agespouse >= 42)
					cotSpouse = (float) (cotSpouse * 1.2);
				if (agespouse <= 53 && agespouse >= 48)
					cotSpouse = (float) (cotSpouse * 1.25);
				if (agespouse <= 59 && agespouse >= 54)
					cotSpouse = (float) (cotSpouse * 1.3);
				if (agespouse <= 65 && agespouse >= 60)
					cotSpouse = (float) (cotSpouse * 1.35);
				if (agespouse < 70 && agespouse >= 66)
					cotSpouse = (float) (cotSpouse * 1.4);

				Cotisation = Cotisation + cotSpouse;

			}

			premium = Cotisation / 12;
			String insuredSocring = "";
			float salaire = Float.parseFloat(txtFSalary.getText());
			if (premium < (30 * salaire / 100))
				insuredSocring = "Safly insured ";
			else if (premium < (50 * salaire / 100) && premium > (30 * salaire / 100))
				insuredSocring = "averagely insured ";
			else
				insuredSocring = "dangerously insured";
			
			
			
			
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Contract premium and Commission");
			alert.setHeaderText(null);
			alert.setContentText("Contract premium = " + premium + " DT" + "\n" + "Contract Cotisation = " + Cotisation
					+ " DT" + "\n" + insuredSocring);

			ButtonType addContract = new ButtonType("Add Contract ");

			ButtonType addQuoatation = new ButtonType("Add Quotation");
			ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(addContract, addQuoatation, cancel);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == addContract) {

				try {
					contextClient = new InitialContext();
					IClientInterfaceRemote proxyClient = (IClientInterfaceRemote) contextClient.lookup(jndiNameClient);
					contextUser = new InitialContext();
					UserServiceRemote proxyUser = (UserServiceRemote) contextUser.lookup(jndiNameUser);

					if (proxyClient.getClientByCin(Integer.parseInt(cin.getText())) == null) {

						Client client = new Client();
						client.setBirthDate(Date.valueOf(birthDate.getValue()));
						client.setCin(Integer.parseInt(cin.getText()));
						client.setEmail(txtFEmail.getText());
						client.setFamily_situation(familySituation.getValue());
						client.setFirstName(txtFFirnstName.getText());
						client.setLastName(txtFLastName.getText());
						if(gender.equals("man"))
						client.setGender(true);
						else client.setGender(false);
						client.setPhone(Integer.parseInt(txtFPhone.getText()));
						client.setSalary(Float.parseFloat(txtFSalary.getText()));

						client.setAddress(txtFAddress.getText());
						client.setJob(profission.getValue());

						TextInputDialog dialog = new TextInputDialog("");
						dialog.setTitle("RIB Number");
						dialog.setHeaderText(null);
						dialog.setContentText("Add RIB Number:");
						Optional<String> rib = dialog.showAndWait();

						client.setRIB_Number(rib.get());
						if (proxyUser.getUserByCIN(Integer.parseInt(cin.getText())) == null) {
							proxyClient.addClient(client);
						} else {

							proxyUser.removeUser(proxyUser.getUserByCIN(Integer.parseInt(cin.getText())));
							proxyClient.addClient(client);
						}

						Alert alert2 = new Alert(AlertType.CONFIRMATION);
						alert2.setTitle("Add Contract");
						alert2.setHeaderText(null);
						alert2.setContentText("Client Added successfully!! \n Are you sure to add Contract ?");

						ButtonType addContractConfirmation = new ButtonType("Add Contract");

						ButtonType addContractCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

						alert2.getButtonTypes().setAll(addContractConfirmation, addContractCancel);

						Optional<ButtonType> resultContract = alert2.showAndWait();
						if (resultContract.get() == addContractConfirmation) {

							try {
								contextHealth = new InitialContext();
								IHealthInterfaceRemote proxyHealth = (IHealthInterfaceRemote) contextHealth
										.lookup(jndiNameHealth);
								Health health = new Health();

								health.setCommission(Cotisation);
								health.setDate_creation(Date.valueOf(LocalDate.now()));
								health.setPrime(premium);
								health.setType_contract(entities.Contract.type_contract.health);
								health.setClient(proxyClient.getClientByCin(Integer.parseInt(cin.getText())));
								health.setAlcohol(alcohole);
								health.setSmoke(smoke);
								health.setGeneral_health(generalHealth);
								health.setDangerous_sport(sport);
								health.setChronic_health(chronic);
								health.setOptions(Options);
								health.setFormulas(formuleContract);
								health.setInsured_people(familyNumber.getValue());
								health.setInsured_people(familyNumber.getValue());
								health.setNbr_child(Integer.parseInt(nbrChild.getValue()));
								health.setBirthDate_PARTNER(Date.valueOf(birthdatePartner.getValue()));
								health.setPartner_job(professionPartner.getValue());
								health.setRescission(false);
								Agent agent = new Agent();
								health.setHealthcare(healthCare);
								health.setDate_creation(Date.valueOf(LocalDate.now()));
								health.setDate_end(Date.valueOf(LocalDate.now().plusYears(1)));
								agent.setId(2);
								health.setAgent(agent);

								proxyHealth.addHealth(health);
							/*	try {
									Stage primaryStage = new Stage();
									Parent root = FXMLLoader.load(getClass().getResource("/views/HealthManage.fxml"));
									Scene scene = new Scene(root);
									scene.getStylesheets()
											.add(getClass().getResource("/css/application.css").toExternalForm());
									primaryStage.setScene(scene);
									primaryStage.setTitle("Manage Health");
									Stage stage = (Stage) calculatePremuim.getScene().getWindow();
									stage.close();
									primaryStage.show();
								} catch (Exception e) {
									e.printStackTrace();
								}*/
								   FXMLLoader loader = containerParent.switchViewTo("/views/HealthManage.fxml");
							        ((HealthManage) loader.getController()).setContainer(containerParent);
									

							} catch (NamingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					} else {

						Alert alert2 = new Alert(AlertType.CONFIRMATION);
						alert2.setTitle("Add Contract");
						alert2.setHeaderText(null);
						alert2.setContentText("Are you sure to add Contract ?");

						ButtonType addContractConfirmation = new ButtonType("Add Contract");

						ButtonType addContractCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

						alert2.getButtonTypes().setAll(addContractConfirmation, addContractCancel);

						Optional<ButtonType> resultContract = alert2.showAndWait();
						if (resultContract.get() == addContractConfirmation) {

							try {
								contextHealth = new InitialContext();
								IHealthInterfaceRemote proxyHealth = (IHealthInterfaceRemote) contextHealth
										.lookup(jndiNameHealth);
								Health health = new Health();

								health.setCommission(Cotisation);
								health.setDate_creation(Date.valueOf(LocalDate.now()));
								health.setPrime(premium);
								health.setType_contract(entities.Contract.type_contract.health);
								health.setClient(proxyClient.getClientByCin(Integer.parseInt(cin.getText())));
								health.setAlcohol(alcohole);
								health.setSmoke(smoke);
								health.setGeneral_health(generalHealth);
								health.setDangerous_sport(sport);
								health.setChronic_health(chronic);
								health.setOptions(Options);
								health.setFormulas(formuleContract);
								health.setInsured_people(familyNumber.getValue());
								health.setNbr_child(Integer.parseInt(nbrChild.getValue()));
								health.setBirthDate_PARTNER(Date.valueOf(birthdatePartner.getValue()));
								health.setPartner_job(professionPartner.getValue());
								health.setRescission(false);
								Agent agent = new Agent();
								health.setHealthcare(healthCare);
								health.setDate_creation(Date.valueOf(LocalDate.now()));
								health.setDate_end(Date.valueOf(LocalDate.now().plusYears(1)));
								agent.setId(2);
								health.setAgent(agent);

								proxyHealth.addHealth(health);
						/*		try {
									Stage primaryStage = new Stage();
									Parent root = FXMLLoader.load(getClass().getResource("/views/HealthManage.fxml"));
									Scene scene = new Scene(root);
									scene.getStylesheets()
											.add(getClass().getResource("/css/application.css").toExternalForm());
									primaryStage.setScene(scene);
									primaryStage.setTitle("Manage Health");
									Stage stage = (Stage) calculatePremuim.getScene().getWindow();
									stage.close();
									primaryStage.show();
								} catch (Exception e) {
									e.printStackTrace();
								}*/
						        FXMLLoader loader = containerParent.switchViewTo("/views/HealthManage.fxml");
						        ((HealthManage) loader.getController()).setContainer(containerParent);
								
								

							} catch (NamingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}

				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			// if add quotation is selected
			else if (result.get() == addQuoatation) {

				try {
					contextUser = new InitialContext();
					UserServiceRemote proxyUser = (UserServiceRemote) contextUser.lookup(jndiNameUser);

					if (proxyUser.getUserByCIN(Integer.parseInt(cin.getText())) == null) {
						User user = new User();
						user.setBirthDate(Date.valueOf(birthDate.getValue()));
						user.setCin(Integer.parseInt(cin.getText()));
						user.setEmail(txtFEmail.getText());
						user.setFamily_situation(familySituation.getValue());
						user.setFirstName(txtFFirnstName.getText());
						user.setLastName(txtFLastName.getText());
						if(gender.equals("man"))
						user.setGender(true);
						else user.setGender(false);
						user.setPhone(Integer.parseInt(txtFPhone.getText()));
						user.setSalary(Float.parseFloat(txtFSalary.getText()));
						proxyUser.addUser(user);
						Alert alert2 = new Alert(AlertType.CONFIRMATION);
						alert2.setTitle("Add Quotaion");
						alert2.setHeaderText(null);
						alert2.setContentText("User Added successfully!! \n Are you sure to add Quotation ?");

						ButtonType addQuoatation2 = new ButtonType("Add Quotation");

						ButtonType addQuoaCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

						alert2.getButtonTypes().setAll(addQuoatation2, addQuoaCancel);

						Optional<ButtonType> result2 = alert2.showAndWait();
						if (result2.get() == addQuoatation2) {

							try {
								contextQuotation = new InitialContext();
								IQuotationInterfaceRemote proxyQotation = (IQuotationInterfaceRemote) contextQuotation
										.lookup(jndiNameQotation);
								HealthQuotation quotation = new HealthQuotation();

							
								quotation.setCreation_date(Date.valueOf(LocalDate.now()));
								quotation.setPrime(premium);
								quotation.setType_contract(type_contract.health);
								quotation.setUser(proxyUser.getUserByCIN(Integer.parseInt(cin.getText())));
								quotation.setAlcohol(alcohole);
								quotation.setSmoke(smoke);
								quotation.setGeneral_health(generalHealth);
								quotation.setDangerous_sport(sport);
								quotation.setChronic_health(chronic);
								quotation.setOptions(Options);
								quotation.setInsured_people(familyNumber.getValue());
								quotation.setNbr_child(Integer.parseInt(nbrChild.getValue()));
								quotation.setBirthDate_PARTNER(Date.valueOf(birthdatePartner.getValue()));
								quotation.setPartner_job(professionPartner.getValue());
								quotation.setFormulas(formuleContract);
								quotation.setHealthcare(healthCare);

								proxyQotation.addHealthQuotation(quotation);
							/*	try {
									Stage primaryStage = new Stage();
									Parent root = FXMLLoader.load(getClass().getResource("/views/HealthManage.fxml"));
									Scene scene = new Scene(root);
									scene.getStylesheets()
											.add(getClass().getResource("/css/application.css").toExternalForm());
									primaryStage.setScene(scene);
									primaryStage.setTitle("Manage Health");
									Stage stage = (Stage) calculatePremuim.getScene().getWindow();
									stage.close();
									primaryStage.show();
								} catch (Exception e) {
									e.printStackTrace();
								}*/
						        FXMLLoader loader = containerParent.switchViewTo("/views/HealthManage.fxml");
						        ((HealthManage) loader.getController()).setContainer(containerParent);
								

							} catch (NamingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					} else {

						Alert alert2 = new Alert(AlertType.CONFIRMATION);
						alert2.setTitle("Add Quotaion");
						alert2.setHeaderText(null);
						alert2.setContentText(" Are you sure to add Quotation ?");

						ButtonType addQuoatation2 = new ButtonType("Add Quotation");

						ButtonType addQuoaCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

						alert2.getButtonTypes().setAll(addQuoatation2, addQuoaCancel);

						Optional<ButtonType> result2 = alert2.showAndWait();
						if (result2.get() == addQuoatation2) {

							try {
								contextQuotation = new InitialContext();
								IQuotationInterfaceRemote proxyQotation = (IQuotationInterfaceRemote) contextQuotation
										.lookup(jndiNameQotation);
								HealthQuotation quotation = new HealthQuotation();

							
								quotation.setCreation_date(Date.valueOf(LocalDate.now()));
								quotation.setPrime(premium);
								quotation.setType_contract(type_contract.health);
								quotation.setUser(proxyUser.getUserByCIN(Integer.parseInt(cin.getText())));
								quotation.setAlcohol(alcohole);
								quotation.setSmoke(smoke);
								quotation.setGeneral_health(generalHealth);
								quotation.setDangerous_sport(sport);
								quotation.setChronic_health(chronic);
								quotation.setOptions(Options);
								quotation.setInsured_people(familyNumber.getValue());
								quotation.setNbr_child(Integer.parseInt(nbrChild.getValue()));
								quotation.setBirthDate_PARTNER(Date.valueOf(birthdatePartner.getValue()));
								quotation.setPartner_job(professionPartner.getValue());
								quotation.setFormulas(formuleContract);
								quotation.setHealthcare(healthCare);

								proxyQotation.addHealthQuotation(quotation);

								/*try {
									Stage primaryStage = new Stage();
									Parent root = FXMLLoader.load(getClass().getResource("/views/HealthManage.fxml"));
									Scene scene = new Scene(root);
									scene.getStylesheets()
											.add(getClass().getResource("/css/application.css").toExternalForm());
									primaryStage.setScene(scene);
									primaryStage.setTitle("Manage Health");
									Stage stage = (Stage) calculatePremuim.getScene().getWindow();
									stage.close();
									primaryStage.show();
								} catch (Exception e) {
									e.printStackTrace();
								}*/
						        FXMLLoader loader = containerParent.switchViewTo("/views/HealthManage.fxml");
						        ((HealthManage) loader.getController()).setContainer(containerParent);

							} catch (NamingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}

				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Invalid fields");
			alert.setHeaderText("Please fill in the fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();

		}
	}

	@FXML
	void returnAction(ActionEvent event) {
	/*	try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/views/HealthManage.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manage Health");
			Stage stage = (Stage) btnCancel.getScene().getWindow();
			stage.close();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
        FXMLLoader loader = containerParent.switchViewTo("/views/HealthManage.fxml");
        ((HealthManage) loader.getController()).setContainer(containerParent);

	}

	@FXML
	void peoplechoose(MouseEvent event) {
		if (familyNumber.getValue().equals("You and your spouse")) {
			partnerForm.setVisible(true);
			childHbox.setVisible(false);
		}
		if (familyNumber.getValue().equals("You, your spouse and your children")) {
			partnerForm.setVisible(true);
			childHbox.setVisible(true);

		}
		if (familyNumber.getValue().equals("You and your children")) {
			childHbox.setVisible(true);
			partnerForm.setVisible(false);
		}
		if (familyNumber.getValue().equals("You")) {
			childHbox.setVisible(false);
			partnerForm.setVisible(false);
		}
	}

	@FXML
	void singleaction(MouseEvent event) {

		if (familySituation.getValue().contains("Single")) {

			familyNumber.setValue("you");
			familyNumber.setDisable(true);
		} else {

			familyNumber.setDisable(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		familySituation.getItems().add("Married                      ");
		familySituation.getItems().add("Single                       ");
		familySituation.getItems().add("Widower                      ");
		familySituation.getItems().add("Divorcee                     ");
		profission.getItems().add("Salaried                       ");
		profission.getItems().add("Executive employee             ");
		profission.getItems().add("Salaried employee              ");
		profission.getItems().add("Functionary                    ");
		profission.getItems().add("Trader                         ");
		profission.getItems().add("Liberal profession             ");
		profission.getItems().add("Teacher                        ");
		profission.getItems().add("Artisan                        ");
		profission.getItems().add("Entrepreneur                   ");
		profission.getItems().add("Farmer                         ");
		profission.getItems().add("Worker                         ");
		profission.getItems().add("Student                        ");
		profission.getItems().add("Retired person                 ");
		profission.getItems().add("No occupation                  ");
		profission.getItems().add("Auto entrepreneur              ");
		familyNumber.getItems().add("You");
		familyNumber.getItems().add("You and your spouse");
		familyNumber.getItems().add("You and your children");
		familyNumber.getItems().add("You, your spouse and your children");
		groupeGender = new ToggleGroup();
		groupeSmoke = new ToggleGroup();
		groupealcohol = new ToggleGroup();
		groupeGeneralHealth = new ToggleGroup();
		groupeChronicIlness = new ToggleGroup();
		groupeDangerousSport = new ToggleGroup();
		groupeFormulas = new ToggleGroup();
		groupeHealthCare = new ToggleGroup();

		economicFormula.setToggleGroup(groupeFormulas);
		budgetformula.setToggleGroup(groupeFormulas);
		confortformula.setToggleGroup(groupeFormulas);

		man.setToggleGroup(groupeGender);
		women.setToggleGroup(groupeGender);
		yesSmoke.setToggleGroup(groupeSmoke);
		noSmoke.setToggleGroup(groupeSmoke);
		yesAlcohol.setToggleGroup(groupealcohol);
		noAlcohol.setToggleGroup(groupealcohol);
		goodHealth.setToggleGroup(groupeGeneralHealth);
		veryGoodHealth.setToggleGroup(groupeGeneralHealth);
		veryBadHealth.setToggleGroup(groupeGeneralHealth);
		badHealth.setToggleGroup(groupeGeneralHealth);
		averageHealth.setToggleGroup(groupeGeneralHealth);
		yesChronicHealth.setToggleGroup(groupeChronicIlness);
		noChronicHealth.setToggleGroup(groupeChronicIlness);
		donotkhnowChronicHealth.setToggleGroup(groupeChronicIlness);
		yesDangerSport.setToggleGroup(groupeDangerousSport);
		noDangerSport.setToggleGroup(groupeDangerousSport);
		privateHealthCare.setToggleGroup(groupeHealthCare);
		publicHealthcare.setToggleGroup(groupeHealthCare);

		/// Partner Form

		partnerForm.setVisible(false);

		professionPartner.setValue("no");
		professionPartner.getItems().add("Salaried                       ");
		professionPartner.getItems().add("Executive employee             ");
		professionPartner.getItems().add("Salaried employee              ");
		professionPartner.getItems().add("Functionary                    ");
		professionPartner.getItems().add("Trader                         ");
		professionPartner.getItems().add("Liberal profession             ");
		professionPartner.getItems().add("Teacher                        ");
		professionPartner.getItems().add("Artisan                        ");
		professionPartner.getItems().add("Entrepreneur                   ");
		professionPartner.getItems().add("Farmer                         ");
		professionPartner.getItems().add("Worker                         ");
		professionPartner.getItems().add("Student                        ");
		professionPartner.getItems().add("Retired person                 ");
		professionPartner.getItems().add("No occupation                  ");
		professionPartner.getItems().add("Auto entrepreneur              ");

		// Children

		childHbox.setVisible(false);
		nbrChild.setValue("0");
		nbrChild.getItems().add("0");
		nbrChild.getItems().add("1");
		nbrChild.getItems().add("2");
		nbrChild.getItems().add("3");
		nbrChild.getItems().add("4");
		nbrChild.getItems().add("5");
		birthdatePartner.setValue(LocalDate.now());

	}
	


}