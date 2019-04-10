package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLWarning;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import entities.Client;
import entities.User;
import entities.Vehicle;
import entities.VehicleQuotation;
import entities.Contract.type_contract;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.interf.UserServiceRemote;
import services.interf.VehicleContractServiceRemote;
import services.interf.VehicleQuotationServiceRemote;
import util.MailVerification;

public class AddContractController implements Initializable{
	@FXML
	private AnchorPane anchorParent;

	@FXML
	private JFXTextField firstNametxt;

	@FXML
	private JFXTextField lastNametxt;

	@FXML
	private JFXTextField cintxt;

	@FXML
	private JFXTextField immatriculationtxt;

	@FXML
	private JFXTextField Optiontxt;

	@FXML
	private JFXTextField marktxt;

	@FXML
	private JFXTextField primetxt;

	@FXML
	private JFXDatePicker birthDatePicker;
	@FXML
	private ImageView penImageView;

	@FXML
	private Button ValidateContractBtn;

	//public Stage Dialog;

	private VehicleQuotation vehicleQuotation;

	@FXML
	private JFXTextField RibNumberTxt;
	@FXML
	private JFXTextField adresseTxt;

	@FXML
	private JFXTextField emailtxt;

	@FXML
	private JFXComboBox<String> comboJob;

	@FXML
	private Button backBtn;
    @FXML
    private ImageView BmwIcon;

    @FXML
    private ImageView volswagenIcon;
    
    @FXML
    private ImageView KiaIcon;

    @FXML
    private ImageView MiniCooperIcon;

    @FXML
    private ImageView toyotaIcon;

    @FXML
    private ImageView fiatIcon;

    @FXML
    private ImageView nissanIcon;
    
    @FXML
    private Label firstNameLabel;

    @FXML
    private Label jobLabel;

    @FXML
    private Label ribLabel;

    @FXML
    private Label primeLabel;

    @FXML
    private Label optionLabel;

    @FXML
    private Label immatriculationLabel;

    @FXML
    private Label markLabel;

    @FXML
    private Label cinLabel;

    @FXML
    private Label birthDateLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label addressLabel;
    
    private VehicleDisplaysController container;

    public void setContainer(VehicleDisplaysController container) {
        this.container = container;
    }

	Vehicle vehicleContract = new Vehicle();
	Client client = new Client();
	private String aJob[] = {"Etudiant", "Retraité", "Artisan","Enseignant","Commerçant","Agriculteur","Chef d'entreprise","Profession libérale"};


	/*public void setParams(Stage Dialog){
		this.Dialog=Dialog;

	}*/
	public void setVehicleQuotation(VehicleQuotation vehicleQuotation) {
		this.vehicleQuotation = vehicleQuotation;
	}

	public int ServiceAddVehicleContract(Vehicle vehicleContract) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/VehicleContractServiceImpl!services.interf.VehicleContractServiceRemote";
		Context context = new InitialContext();
		VehicleContractServiceRemote proxy = (VehicleContractServiceRemote) context.lookup(jndiName);

		return proxy.addVehicleContract(vehicleContract);
	}
	public int ServiceAddClient(Client c) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		return proxy.addClient(c);
	}
	public void ServiceRemoveUser(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		proxy.removeUser(id);
	}
	public User ServicegetUserByCin(int cin) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		return proxy.getUserByCIN(cin);
	}

	private void initJob(){
		List<String> list = new ArrayList<String>();
		for(String content:aJob){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		comboJob.setItems(oblist);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initJob();
	}
	@FXML
	void showInformationAction(MouseEvent event) {
		Optiontxt.setText(vehicleQuotation.getOption_vehicle());
		marktxt.setText(vehicleQuotation.getMark());
		primetxt.setText(String.valueOf(vehicleQuotation.getPrimeQuotation()));	
		firstNametxt.setText(vehicleQuotation.getUser().getFirstName());
		lastNametxt.setText(vehicleQuotation.getUser().getLastName());
		cintxt.setText(String.valueOf(vehicleQuotation.getUser().getCin()));
		if(marktxt.getText().equals("BMW")){
			BmwIcon.setVisible(true);
		}
		else if(marktxt.getText().equals("VOLKSWAGEN")){
			volswagenIcon.setVisible(true);
		}
		else if(marktxt.getText().equals("KIA")){
			KiaIcon.setVisible(true);
		}
		else if(marktxt.getText().equals("NISSAN")){
			nissanIcon.setVisible(true);
		}
		else if(marktxt.getText().equals("FIAT")){
			fiatIcon.setVisible(true);
		}
		else if(marktxt.getText().equals("MINI COOPER")){
			MiniCooperIcon.setVisible(true);
		}
		else if(marktxt.getText().equals("TOYOTA")){
			toyotaIcon.setVisible(true);
		}
	}

	@FXML
	void removeUserAction(ActionEvent event) throws NumberFormatException, Exception {
		ServiceRemoveUser(ServicegetUserByCin(Integer.parseInt(cintxt.getText())).getId());
	}

	@FXML
	void addContractAction(ActionEvent event) throws Exception {
       boolean valid=true;
       

       
       if (cintxt.getText().length()!=8 || cintxt.getText().equals("")) {
           cinLabel.setText("Invalid cin !");
           cinLabel.setVisible(true);
           valid = false;
       } else {
           cinLabel.setText("");
       }
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
       if (immatriculationtxt.getText().equals("")) {
           immatriculationLabel.setText("Field is empty !");
           immatriculationLabel.setVisible(true);
           valid = false;
       } else {
           immatriculationLabel.setText("");
       }
       if (primetxt.getText().equals("")) {
           primeLabel.setText("Field is empty !");
           primeLabel.setVisible(true);
           valid = false;
       } else {
           primeLabel.setText("");
       }
       if (adresseTxt.getText().equals("")) {
           addressLabel.setText("Field is empty !");
           addressLabel.setVisible(true);
           valid = false;
       } else {
           addressLabel.setText("");
       }
       if (RibNumberTxt.getText().equals("")) {
           ribLabel.setText("Field is empty !");
           ribLabel.setVisible(true);
           valid = false;
       } else {
           ribLabel.setText("");
       }
       if (marktxt.getText().equals("")) {
           markLabel.setText("Field is empty !");
           markLabel.setVisible(true);
           valid = false;
       } else {
           markLabel.setText("");
       }
       if (birthDatePicker.getValue() == null) {
           birthDateLabel.setText("Field is empty !");
           birthDateLabel.setVisible(true);
           valid = false;
       }else{
       	birthDateLabel.setText("");
       }

       if(birthDatePicker.getValue()!=null &&birthDatePicker.getValue().isAfter(LocalDate.now().minusYears(18))){
           birthDatePicker.getStyleClass().add("error");
           Alert alert = new Alert(Alert.AlertType.ERROR, "Customer must at least 18 years old!", ButtonType.OK);
           alert.show();
           return;	   
       }
       
       if (comboJob.getValue() == null) {
           jobLabel.setText("Field is empty !");
           jobLabel.setVisible(true);
           valid = false;
       }else{
       	jobLabel.setText("");
       }
       if (emailtxt.getText().equals("")) {
           emailLabel.setText("Field is empty !");
           emailLabel.setVisible(true);
           valid = false;
       } else {
           emailLabel.setText("");
       }
       if (!MailVerification.validate(emailtxt.getText())) {
           emailLabel.setText("E-mail is not valid !");
           emailLabel.setVisible(true);
           valid = false;
       } else {
       	emailLabel.setText("E-mail valid !");
           emailLabel.setTextFill(Color.web("GREEN"));;
           emailLabel.setVisible(true);
       }
  
		if(!valid) return;
	        
		client.setCin(Integer.parseInt(cintxt.getText()));
		client.setFirstName(firstNametxt.getText());
		client.setLastName(lastNametxt.getText());
		client.setBirthDate(java.sql.Date.valueOf(birthDatePicker.getValue()));
		client.setRIB_Number(RibNumberTxt.getText());
		client.setAddress(adresseTxt.getText());
		client.setEmail(emailtxt.getText());
		client.setJob(comboJob.getValue());
		client.setRole("Client");
		ServiceAddClient(client);

		vehicleContract.setMatriculation(immatriculationtxt.getText());
		vehicleContract.setPrime(Float.valueOf(primetxt.getText()));
		vehicleContract.setDate_creation(Date.valueOf(LocalDate.now()));
		vehicleContract.setDate_end(Date.valueOf(LocalDate.now().plusYears(1)));
		vehicleContract.setMark(marktxt.getText());
		vehicleContract.setVehicleOption(Optiontxt.getText());
		if(Float.valueOf(primetxt.getText())<=400){
			vehicleContract.setVehicleGroup("Group 1");
		}
		else if(Float.valueOf(primetxt.getText())>400 &&Float.valueOf(primetxt.getText())<=700){
			vehicleContract.setVehicleGroup("Group 2");
		}
		else if(Float.valueOf(primetxt.getText())>700 &&Float.valueOf(primetxt.getText())<=1000){
			vehicleContract.setVehicleGroup("Group 3");
		}
		else if(Float.valueOf(primetxt.getText())>1000 &&Float.valueOf(primetxt.getText())<=1300){
			vehicleContract.setVehicleGroup("Group 4");
		}
		else if(Float.valueOf(primetxt.getText())>1300 &&Float.valueOf(primetxt.getText())<=1600){
			vehicleContract.setVehicleGroup("Group 5");
		}
		else if(Float.valueOf(primetxt.getText())>1600 &&Float.valueOf(primetxt.getText())<=1900){
			vehicleContract.setVehicleGroup("Group 6");
		}
		else if(Float.valueOf(primetxt.getText())>1900 &&Float.valueOf(primetxt.getText())<=2200){
			vehicleContract.setVehicleGroup("Group 7");
		}
		else if(Float.valueOf(primetxt.getText())>2200 &&Float.valueOf(primetxt.getText())<=2500){
			vehicleContract.setVehicleGroup("Group 8");
		}
		else if(Float.valueOf(primetxt.getText())>2500 &&Float.valueOf(primetxt.getText())<=2800){
			vehicleContract.setVehicleGroup("Group 9");
		}
		else if(Float.valueOf(primetxt.getText())>2800 &&Float.valueOf(primetxt.getText())<=3100){
			vehicleContract.setVehicleGroup("Group 10");
		}
		else if(Float.valueOf(primetxt.getText())>3100 &&Float.valueOf(primetxt.getText())<=3400){
			vehicleContract.setVehicleGroup("Group 11");
		}
		vehicleContract.setType_contract(type_contract.Vehicle);
		showContractConfirmation();

	}
	public void showContractConfirmation() throws IOException{

		int cin = Integer.parseInt(cintxt.getText());
		String immatriculation = String.valueOf(immatriculationtxt.getText());
		String adresse = adresseTxt.getText();
		String option = Optiontxt.getText();
		String marque = marktxt.getText();
	/*	FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("/views/AddContractConfirmationView.fxml"));
		try {
			Loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddContractConfirmationController  display = Loader.getController();
		display.setCin(cin);
		display.setVehicleContract(vehicleContract);
		display.setImmatriculation(immatriculation);
		display.setOption(option);
		display.setMarque(marque);
		display.setAdresse(adresse);

		Parent p= Loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
		stage.showAndWait();*/
   	   FXMLLoader loader = container.switchView("/views/AddContractConfirmationView.fxml");
       ((AddContractConfirmationController) loader.getController()).setContainer(container);
       ((AddContractConfirmationController) loader.getController()).setCin(cin);
       ((AddContractConfirmationController) loader.getController()).setVehicleContract(vehicleContract);
       ((AddContractConfirmationController) loader.getController()).setImmatriculation(immatriculation);
       ((AddContractConfirmationController) loader.getController()).setOption(option);
       ((AddContractConfirmationController) loader.getController()).setMarque(marque);
       ((AddContractConfirmationController) loader.getController()).setAdresse(adresse);
		}

	@FXML
	void backAction(ActionEvent event) throws IOException {
		/*FXMLLoader loader= new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/DisplayQuotationsView.fxml"));
		Parent showQuotations = loader.load();
		Scene showQuotationsScene = new Scene(showQuotations);
		DisplayQuotationsController controller = loader.getController();
		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(showQuotationsScene);
		window.show();*/
        FXMLLoader loader = container.switchView("/views/DisplayQuotationsView.fxml");
        ((DisplayQuotationsController) loader.getController()).setContainer(container);
	}
}

