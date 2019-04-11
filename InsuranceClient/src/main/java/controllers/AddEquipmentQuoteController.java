package controllers;
import javafx.scene.control.Label;
import javafx.util.Duration;
import services.interf.IClaimsServiceRemote;
import services.interf.IEquipmentQuoteRemote;
import services.interf.IEquipmentServiceRemote;
import services.interf.ISinisterEquipmentServiceRemote;
import services.interf.UserServiceRemote;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import javafx.scene.paint.Paint;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.PopOver;
import org.controlsfx.tools.Platform;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import javafx.scene.input.MouseEvent;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXDatePicker;
import javafx.scene.control.DatePicker;
import entities.Agent;
import entities.Client;
import entities.Contract;
import entities.EquipmentQuote;
import entities.Property;
import entities.Quotation;
import entities.User;
import entities.Contract.type_contract;
import entities.ContractProperty;
import entities.Equipment;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
public class AddEquipmentQuoteController implements Initializable {
	@FXML
	private VBox content_area;
	@FXML
	private GridPane gridQuote;
	@FXML
	private GridPane gridPerson;
	@FXML
	private HBox menubar;
  
	@FXML
	private Pane gg;
	@FXML
	private HBox textarea;
	@FXML
	private JFXButton Mergebtn;
	@FXML
	private JFXTextField valueField;

	@FXML
	private JFXComboBox<String> type_item;
	@FXML
	private JFXTextField modelField;
	@FXML
	private JFXComboBox<String> item;

	@FXML
	private JFXComboBox<String> make;

	@FXML
	private VBox VboxMatch;

	@FXML
	private DatePicker dateValue;
	@FXML
	private Label type_label;



	@FXML
	private Label modelLabel;
	@FXML
	private JFXTextField first_name;

	@FXML
	private JFXTextField last_name;

	@FXML
	private JFXTextField email;

	@FXML
	private JFXTextField condition;
	@FXML
	private JFXTextField phone;
	Property c = new Property();
	@FXML
	private JFXTextField cinField;
	int quote_id;
	@FXML
	private JFXButton addContractbtn;

	@FXML
	private JFXTextField text1;

	@FXML
	private JFXTextField text2;

	@FXML
	private JFXTextField text3;
	@FXML
	private JFXTextField text4;
	@FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private Label optionLabel;
    private EquipmentQuotContainerController containerParent;
    public void setContainer(EquipmentQuotContainerController equipmentQuotContainerController) {
		this.containerParent = equipmentQuotContainerController;
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//type_label.setText("");
		type_item.getItems().add(c.getType_item().electronic.toString());
		type_item.setValue(c.getType_item().electronic.toString());
		type_item.setVisible(false);
		item.getItems().add(c.getItem().MobilePhone.toString());
		item.getItems().add(c.getItem().Laptop.toString());
		item.getItems().add(c.getItem().EReader.toString());
		item.getItems().add(c.getItem().MP3.toString());
		item.getItems().add(c.getItem().Games.toString());
		item.getItems().add(c.getItem().Camera.toString());
		item.getItems().add(c.getItem().DesktopPC.toString());
		item.getItems().add(c.getItem().homeAppliance.toString());
		addContractbtn.setDisable(true);
		optionLabel.setText("Standard");
		this.setValidd();

	}
    
    public void setValidd() {
	
		/*ValidationSupport validationSupport = new ValidationSupport();
        validationSupport.registerValidator(cinField, Validator.createEmptyValidator("champ obligatoire"));
        ValidationSupport validationSupport1 = new ValidationSupport();
        validationSupport1.registerValidator(phone, Validator.createEmptyValidator("champ obligatoire"));
        ValidationSupport validationSupport2 = new ValidationSupport();
        validationSupport2.registerValidator(first_name, Validator.createEmptyValidator("champ obligatoire"));
        ValidationSupport validationSupport3 = new ValidationSupport();
        validationSupport3.registerValidator(last_name, Validator.createEmptyValidator("champ obligatoire"));
        ValidationSupport validationSupport4 = new ValidationSupport();
        validationSupport4.registerValidator(email, Validator.createEmptyValidator("champ obligatoire"));
        ValidationSupport validationSupport5 = new ValidationSupport();
        validationSupport5.registerValidator(condition, Validator.createEmptyValidator("champ obligatoire"));
        ValidationSupport validationSupport6 = new ValidationSupport();
        validationSupport6.registerValidator(valueField, Validator.createEmptyValidator("champ obligatoire"));
        */
    	cinField.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(8));
        phone.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(8));
        text3.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(23));
        text4.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(1));
        valueField.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(8));
        first_name.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(50));
        last_name.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(50));
        text1.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(50));
        text2.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(50));
        condition.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(50));
	}
	 @FXML
	    void setPremium(MouseEvent event) {
		 optionLabel.setText("Premium");
	    }

	    @FXML
	    void setStandard(MouseEvent event) {
			 optionLabel.setText("Standard");

	    }

	    @FXML
	    void setUltimate(MouseEvent event) {
			 optionLabel.setText("Ultimate");

	    }

	@FXML
	void chooseitem(ActionEvent event) {
		if (!item.getSelectionModel().isEmpty()) {
			if (item.getSelectionModel().getSelectedItem().equals("MobilePhone")) {
				make.getItems().clear();
				make.getItems().add(c.getMarque().Amazon.toString());
				make.getItems().add(c.getMarque().Apple.toString());
				make.getItems().add(c.getMarque().BlackBerry.toString());
				make.getItems().add(c.getMarque().Google.toString());
				make.getItems().add(c.getMarque().Honor.toString());
				make.getItems().add(c.getMarque().HTC.toString());
				make.getItems().add(c.getMarque().Huawei.toString());
				make.getItems().add(c.getMarque().LG.toString());
				make.getItems().add(c.getMarque().Microsoft.toString());
				make.getItems().add(c.getMarque().Motorola.toString());
				make.getItems().add(c.getMarque().Nokia.toString());
				make.getItems().add(c.getMarque().OnePlus.toString());
				make.getItems().add(c.getMarque().Razor.toString());
				make.getItems().add(c.getMarque().Samsung.toString());
				make.getItems().add(c.getMarque().Sony.toString());
			}
			if (item.getSelectionModel().getSelectedItem().equals("Laptop")) {
				make.getItems().clear();
				make.getItems().add(c.getMarque().Acer.toString());
				make.getItems().add(c.getMarque().Advent.toString());
				make.getItems().add(c.getMarque().Apple.toString());
				make.getItems().add(c.getMarque().Asus.toString());
				make.getItems().add(c.getMarque().Dell.toString());
				make.getItems().add(c.getMarque().FujitsuSiemens.toString());
				make.getItems().add(c.getMarque().Gigabyte.toString());
				make.getItems().add(c.getMarque().Hp.toString());
				make.getItems().add(c.getMarque().Lenovo.toString());
				make.getItems().add(c.getMarque().Medion.toString());
				make.getItems().add(c.getMarque().Microsoft.toString());
				make.getItems().add(c.getMarque().PackardBell.toString());
				make.getItems().add(c.getMarque().Samsung.toString());
				make.getItems().add(c.getMarque().SonyVaio.toString());
				make.getItems().add(c.getMarque().Toshiba.toString());

			}
			if (item.getSelectionModel().getSelectedItem().equals("EReader")) {
				make.getItems().clear();
				make.getItems().add(c.getMarque().Amazon.toString());
				make.getItems().add(c.getMarque().Mio.toString());
				make.getItems().add(c.getMarque().Sony.toString());
			}
			if (item.getSelectionModel().getSelectedItem().equals("Games")) {
				make.getItems().clear();
				make.getItems().add(c.getMarque().Archos.toString());
				make.getItems().add(c.getMarque().Microsoft.toString());
				make.getItems().add(c.getMarque().Nintendo.toString());
				make.getItems().add(c.getMarque().Sony.toString());

			}
			if (item.getSelectionModel().getSelectedItem().equals("MP3")) {
				make.getItems().clear();
				make.getItems().add(c.getMarque().Apple.toString());
				make.getItems().add(c.getMarque().Cowon.toString());
				make.getItems().add(c.getMarque().Creative.toString());
				make.getItems().add(c.getMarque().Microsoft.toString());
				make.getItems().add(c.getMarque().Philips.toString());
				make.getItems().add(c.getMarque().Sony.toString());
				make.getItems().add(c.getMarque().Yamaha.toString());
				make.getItems().add(c.getMarque().Zune.toString());

			}
			if (item.getSelectionModel().getSelectedItem().equals("Camera")) {
				make.getItems().clear();
				make.getItems().add(c.getMarque().Canon.toString());
				make.getItems().add(c.getMarque().Fuji.toString());
				make.getItems().add(c.getMarque().FujiFilm.toString());
				make.getItems().add(c.getMarque().GoPro.toString());
				make.getItems().add(c.getMarque().Kodak.toString());
				make.getItems().add(c.getMarque().Leica.toString());
				make.getItems().add(c.getMarque().Lomography.toString());
				make.getItems().add(c.getMarque().Nikon.toString());
				make.getItems().add(c.getMarque().Olympus.toString());
				make.getItems().add(c.getMarque().Panasonic.toString());
				make.getItems().add(c.getMarque().Pentax.toString());
				make.getItems().add(c.getMarque().Samsung.toString());
				make.getItems().add(c.getMarque().Sony.toString());

			}
			if (item.getSelectionModel().getSelectedItem().equals("DesktopPC")) {
				make.getItems().clear();
				make.getItems().add(c.getMarque().Acer.toString());
				make.getItems().add(c.getMarque().Apple.toString());
				make.getItems().add(c.getMarque().Asus.toString());
				make.getItems().add(c.getMarque().Dell.toString());
				make.getItems().add(c.getMarque().Gigabyte.toString());
				make.getItems().add(c.getMarque().Hp.toString());
				make.getItems().add(c.getMarque().Lenovo.toString());
				make.getItems().add(c.getMarque().Microsoft.toString());
				make.getItems().add(c.getMarque().Samsung.toString());
				make.getItems().add(c.getMarque().Toshiba.toString());
			}
		}
	}
	@FXML
    void RefreshQuotes(ActionEvent event) throws NamingException {
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		
		String jndiName1 = "Insurance-ear/Insurance-ejb/ServiceEquipmentQuote!services.interf.IEquipmentQuoteRemote";
		Context context1 = new InitialContext();
		IEquipmentQuoteRemote proxy1 = (IEquipmentQuoteRemote) context1.lookup(jndiName1);
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		if (!cinField.getText().equals(""))
		{
			User u=proxy.getUserByCIN(Integer.valueOf(cinField.getText()));
			List<Quotation> c=proxy1.findEquipmentQuoteByUser(u.getId());
			for (int i=0;i<c.size();i++)
			{System.out.println("55"+c.get(i).getCreation_date()+"+"+String.valueOf(date));
				if (c.get(i).getCreation_date().toString().equals(String.valueOf(date)))
						{
						proxy1.removeQuote(c.get(i).getQuotation_id());
						}
			}
		}
    }
	
	@FXML
    void searchUser(KeyEvent event) throws NamingException {
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		if (!cinField.getText().equals(""))
		{User u=proxy.getUserByCIN(Integer.valueOf(cinField.getText()));
		if (u!=null)
		{
			last_name.setText(u.getLastName());
			first_name.setText(u.getFirstName());
			phone.setText(String.valueOf(u.getPhone()));
			email.setText(u.getEmail());
		}
		else {
			last_name.clear();
			first_name.clear();
			phone.clear();
			email.clear();
		}
		}
		
    }

	@FXML
	void AddQuote(MouseEvent event) throws NamingException {
		if (item.getSelectionModel().isEmpty() || make.getSelectionModel().isEmpty() || modelField.getText().trim().isEmpty()
				|| valueField.getText().trim().isEmpty() || condition.getText().trim().isEmpty() || dateValue.getValue() == null
				|| first_name.getText().trim().isEmpty() || last_name.getText().trim().isEmpty() || 
				email.getText().trim().isEmpty() || phone.getText().trim().isEmpty() ||
				cinField.getText().trim().isEmpty() )
		{
			Notifications notif= Notifications.create().text("    Champs manquants")
	                .hideAfter(Duration.seconds(10)).position(Pos.CENTER);
	        notif.darkStyle().graphic(null);
	       notif.show();

		}
		else{
		addContractbtn.setDisable(false);
		addContractbtn.setText("Add Contract");
		addContractbtn.setVisible(true);
		String jndiName1 = "Insurance-ear/Insurance-ejb/ServiceEquipmentQuote!services.interf.IEquipmentQuoteRemote";
		Context context1 = new InitialContext();
		IEquipmentQuoteRemote proxy1 = (IEquipmentQuoteRemote) context1.lookup(jndiName1);

		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		User x = proxy.getUserByCIN((Integer) Integer.valueOf(cinField.getText()));
		EquipmentQuote q = new EquipmentQuote();
		q.setType_contract(q.getType_contract().equipment);
		q.setCreation_date(new Date(System.currentTimeMillis()));
		//q.setPremium(500);
		//q.setCommision(300);
		if (x == null) {
			User u = new User();
			u.setEmail(email.getText());
			u.setFirstName(first_name.getText());
			u.setLastName(last_name.getText());
			u.setPhone(Integer.valueOf(phone.getText()));
			u.setCin(Integer.valueOf(cinField.getText()));
			List<User> xx=proxy.findAllUsers();
			int existe=0;
			for (int i=0;i<xx.size();i++)
			{
				if (xx.get(i).getCin()==Integer.valueOf(cinField.getText()) || xx.get(i).getPhone()==Integer.valueOf(phone.getText()))
				{existe++;}
			}
			if (existe==0)
			{proxy.addUser(u);}
			else {
				Notifications notif= Notifications.create().text("   User existant")
		                .hideAfter(Duration.seconds(10)).position(Pos.CENTER);
		        notif.darkStyle().graphic(null);
		       notif.show();
			}

		}

		User a = proxy.getUserByCIN((Integer) Integer.valueOf(cinField.getText()));
		Property quote = new Property();
		quote.setEquipmentQuote(q);
		q.setUser(a);
		this.addQuote1(quote);
		this.CalculatePrimeOneProperty(quote,q);
		quote_id = proxy1.addEquipmentQuote(quote);

		Mergebtn.setVisible(true);}
	}

	@FXML
	void AnotherEquipment(ActionEvent event) throws Exception {
		make.getItems().clear();
		item.getItems().clear();

		item.getItems().add(c.getItem().MobilePhone.toString());
		item.getItems().add(c.getItem().Laptop.toString());
		item.getItems().add(c.getItem().EReader.toString());
		item.getItems().add(c.getItem().MP3.toString());
		item.getItems().add(c.getItem().Games.toString());
		item.getItems().add(c.getItem().Camera.toString());
		item.getItems().add(c.getItem().DesktopPC.toString());
		item.getItems().add(c.getItem().homeAppliance.toString());
		modelField.clear();
		valueField.clear();
		condition.clear();
		dateValue.setValue(null);
		optionLabel.setText("Standard");
		addContractbtn.setVisible(false);

	}

	@FXML
	void MergeQuote(ActionEvent event) throws NamingException {
		if (item.getSelectionModel().isEmpty() || make.getSelectionModel().isEmpty() || modelField.getText().trim().isEmpty()
				|| valueField.getText().trim().isEmpty() || condition.getText().trim().isEmpty() || dateValue.getValue() == null
				|| first_name.getText().trim().isEmpty() || last_name.getText().trim().isEmpty() || 
				email.getText().trim().isEmpty() || phone.getText().trim().isEmpty() ||
				cinField.getText().trim().isEmpty())
		{
			Notifications notif= Notifications.create().text("    Champs manquants")
	                .hideAfter(Duration.seconds(10)).position(Pos.CENTER);
	        notif.darkStyle().graphic(null);
	       notif.show();

		}
		else{
		addContractbtn.setDisable(false);
		addContractbtn.setText("Add your pack");
		addContractbtn.setVisible(true);
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		User x = proxy.getUserByCIN((Integer) Integer.valueOf(cinField.getText()));
		if (x != null) {
			String jndiName1 = "Insurance-ear/Insurance-ejb/ServiceEquipmentQuote!services.interf.IEquipmentQuoteRemote";
			Context context1 = new InitialContext();
			IEquipmentQuoteRemote proxy1 = (IEquipmentQuoteRemote) context1.lookup(jndiName1);
			java.sql.Date datet = new java.sql.Date(Calendar.getInstance().getTime().getTime());

			List<Quotation> quo = proxy1.findQuoteByTypeAndDate(type_item.getSelectionModel().getSelectedItem().toString(),
					x.getId(),datet.toString());
			List<Property> prop = new ArrayList<>();
			for (int i = 0; i < quo.size(); i++) {
				if (quo.get(i).getCreation_date().toString().equals(String.valueOf(date))) {
					prop.addAll(proxy1.findProperty(quo.get(i).getQuotation_id()));
				}
			}

			for (int j = 0; j < prop.size(); j++) {
				proxy1.updateProperty(prop.get(j), quo.get(0).getQuotation_id());
			}
			
			EquipmentQuote eqq=proxy1.findEquipmentQuoteById(quo.get(0).getQuotation_id());
			this.CalculatePrimeMultipleProperty(eqq);
			proxy1.updateEquipmentQuote(eqq, quo.get(0).getQuotation_id());
			List<Quotation> quo1 = new ArrayList<>();

			quo1.addAll(proxy1.findMerge(prop.get(0).getEquipmentQuote().getQuotation_id(), String.valueOf(date), x));
			for (int j = 0; j < quo1.size(); j++) {
				proxy1.removeQuote(quo1.get(j).getQuotation_id());
			}
			}
		}

	}

	@FXML
	void addConract(ActionEvent event) throws NamingException {
		
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		User x=proxy.getUserByCIN((Integer)Integer.valueOf(cinField.getText()));
		Client client=proxy.findClientById(x.getId());
		Agent agent=proxy.findAgentById(1);
		Client c=new Client();
		
		String jndiName2 = "Insurance-ear/Insurance-ejb/ServiceEquipmentQuote!services.interf.IEquipmentQuoteRemote";
		Context context2 = new InitialContext();
		IEquipmentQuoteRemote proxy2 = (IEquipmentQuoteRemote) context2.lookup(jndiName2);
		
		
		String jndiName1 = "Insurance-ear/Insurance-ejb/ServiceEquiment!services.interf.IEquipmentServiceRemote";
		Context context1 = new InitialContext();
		IEquipmentServiceRemote proxy1 = (IEquipmentServiceRemote) context1.lookup(jndiName1);

		if(addContractbtn.getText().equals("Add Contract") || addContractbtn.getText().equals("Add your pack"))
			{				text4.setVisible(true);

		
			if (client==null)
			{	text1.setVisible(true);
				text2.setVisible(true);
				text3.setVisible(true);
				
			}	if(addContractbtn.getText().equals("Add Contract")){addContractbtn.setText("Validate Contact");}
			else {
				addContractbtn.setText("Validate pack");
			}
			}

		else{
			if (item.getSelectionModel().isEmpty() || make.getSelectionModel().isEmpty() || modelField.getText().trim().isEmpty()
				|| valueField.getText().trim().isEmpty() || condition.getText().trim().isEmpty() || dateValue.getValue() == null
				|| first_name.getText().trim().isEmpty() || last_name.getText().trim().isEmpty() || 
				email.getText().trim().isEmpty() || phone.getText().trim().isEmpty() ||
				cinField.getText().trim().isEmpty() || text4.getText().trim().isEmpty())
		{
				Notifications notif= Notifications.create().text("     Champs manquants")
		                .hideAfter(Duration.seconds(10)).position(Pos.CENTER);
		        notif.darkStyle().graphic(null);
		        notif.show();

		}
			else{
		ContractProperty eq=new ContractProperty();
		Equipment q = new Equipment();
		if (client==null)
		{
			if (text1.getText().trim().isEmpty() || text2.getText().trim().isEmpty() || text3.getText().trim().isEmpty())
			{
				Notifications notif= Notifications.create().text("Would you please add client's informations")
		                .hideAfter(Duration.seconds(10)).position(Pos.CENTER);
		        notif.darkStyle().graphic(null);
		       notif.show();

			}
			else {
				c.setAddress(text2.getText());
		c.setRIB_Number(text3.getText());
		c.setJob(text1.getText());
		c.setEmail(email.getText());
		c.setFirstName(first_name.getText());
		c.setLastName(last_name.getText());
		c.setPhone(Integer.valueOf(phone.getText()));
		c.setCin(Integer.valueOf(cinField.getText()));
		List<Quotation> quo = proxy2.findEquipmentQuoteByUser(x.getId());	
		
		proxy.removeUser(x.getId());
		proxy.addClient(c);
		client=proxy.getClientByCIN((Integer)Integer.valueOf(cinField.getText()));
		q.setClient(client);
		q.setDate_creation(Date.valueOf(dateValue.getValue()));
		q.setDate_end(Date.valueOf(dateValue.getValue().plusYears(Long.valueOf(text4.getText()))));
		q.setType_contract(type_contract.equipment);
		q.setAgent(agent);
		q.setCategory(null);
		q.setClient(client);
		eq.setEquipment(q);
		//this.CalculatePrimeMultipleProperty1(q);
		eq.setOption_contract(eq.getOption_contract().valueOf(optionLabel.getText()));

		q.setValidation("valide");
		this.addContract1(eq);
		this.CalculatePrimeOneProperty1(eq,q);
		proxy1.addEquipment(eq);
			}}
		else {
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

			List<Quotation> qq=proxy2.findQuoteByTypeAndDate(type_item.getSelectionModel().getSelectedItem().toString(), client.getId(),date.toString());
			List<Property> prop=proxy2.findProperty(qq.get(0).getQuotation_id());
			Equipment equi=new Equipment();
			equi.setValidation("valide");
			equi.setAgent(agent);
			equi.setCategory(null);
			equi.setClient(client);
			equi.setDate_creation(new Date(System.currentTimeMillis()));
			Date d=new Date(System.currentTimeMillis());
			d.setYear(new Date(System.currentTimeMillis()).getYear()+Integer.valueOf(text4.getText()));
			equi.setDate_end(d);
			equi.setType_contract(type_contract.equipment);
			this.CalculatePrimeMultipleProperty1(equi);
			for (int i=0;i<prop.size();i++)
			{
				ContractProperty c1=new ContractProperty();
				c1.setCondition_equipment(prop.get(i).getCondition_equipment());
				c1.setItem(c1.getItem().valueOf(prop.get(i).getItem().toString()));
				c1.setOption_contract(c1.getOption_contract().valueOf(prop.get(i).getOption_quote().toString()));
				c1.setMarque(c1.getMarque().valueOf(prop.get(i).getMarque().toString()));
				c1.setType_item(c1.getType_item().valueOf(prop.get(i).getType_item().toString()));
				c1.setModel(prop.get(i).getModel());
				c1.setValue(prop.get(i).getValue());
				c1.setEquipment(equi);
				c1.setPrime(prop.get(i).getPrime());
				proxy1.addEquipment(c1);

			}
			System.out.println(qq.get(0).getQuotation_id());
			proxy2.removeQuote(qq.get(0).getQuotation_id());

			List<Contract> quo = proxy1.findContractByType(type_item.getSelectionModel().getSelectedItem().toString(),client.getId());

			List<ContractProperty> proper = new ArrayList<>();
			for (int i = 0; i < quo.size(); i++) {				
					proper.addAll(proxy1.findCProperty((quo.get(i).getContract_id())));
			}

			for (int j = 0; j < proper.size(); j++) {
				proxy1.updateCProperty(proper.get(j), quo.get(0).getContract_id());
			}
			
			Equipment eqq=proxy1.findEquipmentById(quo.get(0).getContract_id());
			this.CalculatePrimeMultipleProperty1(eqq);
			proxy1.updateEquipment1(eqq, quo.get(0).getContract_id());
			
			List<Contract> quo1 = new ArrayList<>();

			quo1.addAll(proxy1.findMerge(proper.get(0).getEquipment().getContract_id(), String.valueOf(date),client));
			for (int j = 0; j < quo1.size(); j++) {
				proxy1.removeContract(quo1.get(j).getContract_id());
			}
		
		}
			
		}}
		
		
	    }

	public void addQuote1(Property quote) {
	
			quote.setType_item(quote.getType_item().electronic);
			
			quote.setOption_quote(quote.getOption_quote().valueOf(optionLabel.getText()));
			quote.setItem(quote.getItem().valueOf(item.getSelectionModel().getSelectedItem().toString()));
			quote.setMarque(quote.getMarque().valueOf(make.getSelectionModel().getSelectedItem().toString()));

		quote.setModel(modelField.getText());
		quote.setValue(Double.valueOf(valueField.getText()));
		quote.setCondition_equipment(condition.getText());

	}

	public void addContract1(ContractProperty quote) {
		
			quote.setType_item(quote.getType_item().electronic);
			quote.setOption_contract(quote.getOption_contract().valueOf(optionLabel.getText()));
			quote.setItem(quote.getItem().valueOf(item.getSelectionModel().getSelectedItem().toString()));
			quote.setMarque(quote.getMarque().valueOf(make.getSelectionModel().getSelectedItem().toString()));
			quote.setModel(modelField.getText());
			quote.setValue(Double.valueOf(valueField.getText()));
			quote.setCondition_equipment(condition.getText());

	}
	 public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
		    return new EventHandler<KeyEvent>() {
		        @Override
		        public void handle(KeyEvent e) {
		            TextField txt_TextField = (TextField) e.getSource();                
		            if (txt_TextField.getText().length() >= max_Lengh) {                    
		                e.consume();
		            }
		            if(e.getCharacter().matches("[0-9]")){     
		                }
		            else{
		                e.consume();
		            }
		        }
		    };
		}    
		public EventHandler<KeyEvent> letter_Validation(final Integer max_Lengh) {
		    return new EventHandler<KeyEvent>() {
		        @Override
		        public void handle(KeyEvent e) {
		            TextField txt_TextField = (TextField) e.getSource();                
		            if (txt_TextField.getText().length() >= max_Lengh) {                    
		                e.consume();
		            }
		            if(e.getCharacter().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$")){ 
		            }else{
		                e.consume();
		            }
		        }
		    };
		}
		public void CalculatePrimeOneProperty(Property p,EquipmentQuote q) throws NamingException
		{
			//p.setPrime(500);
			String jndiName = "Insurance-ear/Insurance-ejb/ServiceSinisterEquipment!services.interf.ISinisterEquipmentServiceRemote";
			Context context = new InitialContext();
			ISinisterEquipmentServiceRemote proxy = (ISinisterEquipmentServiceRemote) context.lookup(jndiName);
			int x=proxy.findNumberSinister(p);
			double y=proxy.MeanSinisterEquipment(p);
			float xx=x;
			float nrisque=500;
			if (p.getItem().equals("Camera") || p.getItem().equals("Games")
					|| p.getItem().equals("MobilePhone") || p.getItem().equals("EReader")) 
			{
				nrisque=1000;
			}
			double frequence=x/nrisque;
			double tauxPrime=frequence*y;
			double Prime=tauxPrime*p.getValue()/100;
			q.setCommision((float)(Prime*0.09+5.9));
			q.setPremium((float)(Prime*1.09+5.9));
			p.setPrime((float)(Prime*1.09+5.9));
			
			Notifications notif= Notifications.create().text("Your quote is :"+(int)Prime+" DT")
	                .hideAfter(Duration.seconds(10)).position(Pos.CENTER);
	        notif.darkStyle().graphic(null);
	       notif.show();
			
		}
		
		public void CalculatePrimeOneProperty1(ContractProperty p,Contract c) throws NamingException
		{
			String jndiName = "Insurance-ear/Insurance-ejb/ServiceSinisterEquipment!services.interf.ISinisterEquipmentServiceRemote";
			Context context = new InitialContext();
			ISinisterEquipmentServiceRemote proxy = (ISinisterEquipmentServiceRemote) context.lookup(jndiName);
			int x=proxy.findNumberSinisterC(p);
			double y=proxy.MeanSinisterEquipmentC(p);
			float xx=x;
			float nrisque=500;
			if (p.getItem().equals("Camera") || p.getItem().equals("Games")
					|| p.getItem().equals("MobilePhone") || p.getItem().equals("EReader")) 
			{
				nrisque=1000;
			}
			double frequence=x/nrisque;
			double tauxPrime=frequence*y;
			double Prime=tauxPrime*p.getValue()/100;
			c.setCommission((float)(Prime*0.09+5.9));
			c.setPrime((float)(Prime*1.09+5.9));
			p.setPrime((float)(Prime*1.09+5.9));
			
			Notifications notif= Notifications.create().text("Your premium is :"+(int)Prime+" DT")
	                .hideAfter(Duration.seconds(10)).position(Pos.CENTER);
	        notif.darkStyle().graphic(null);
	       notif.show();
		}
		public void CalculatePrimeMultipleProperty(EquipmentQuote p) throws NamingException
		{
		String jndiName1 = "Insurance-ear/Insurance-ejb/ServiceEquipmentQuote!services.interf.IEquipmentQuoteRemote";
		Context context1 = new InitialContext();
		IEquipmentQuoteRemote proxy1 = (IEquipmentQuoteRemote) context1.lookup(jndiName1);
		List<Property> pp=proxy1.findProperty(p.getQuotation_id());
		float primePure=0;
		for (int i=0;i<pp.size();i++)
		{primePure=primePure+pp.get(i).getPrime();}
		double com=(primePure*0.09)+5.9;
		double primefinal=(primePure*1.09)+5.9;
		p.setCommision((float)com);
		p.setPremium((float)primefinal);
		Notifications notif= Notifications.create().text("Your premium quote is :"+(int)primefinal+" DT")
                .hideAfter(Duration.seconds(10)).position(Pos.CENTER);
        notif.darkStyle().graphic(null);
       notif.show();
		}
		public void CalculatePrimeMultipleProperty1(Equipment p) throws NamingException
		{
			String jndiName1 = "Insurance-ear/Insurance-ejb/ServiceEquiment!services.interf.IEquipmentServiceRemote";
			Context context1 = new InitialContext();
			IEquipmentServiceRemote proxy1 = (IEquipmentServiceRemote) context1.lookup(jndiName1);
			List<ContractProperty> pp=proxy1.findCProperty((p.getContract_id()));
			System.out.print(p.getContract_id());
			float primePure=0;
			for (int i=0;i<pp.size();i++)
			{primePure=primePure+pp.get(i).getPrime();}
			double com=(primePure*0.09)+5.9;
			double primefinal=(primePure*1.09)+5.9;
			p.setCommission((float)com);
			p.setPrime((float)primefinal);
			Notifications notif= Notifications.create().text("Your premium pack is :"+(int)primefinal+" DT")
	                .hideAfter(Duration.seconds(10)).position(Pos.CENTER);
	        notif.darkStyle().graphic(null);
	       notif.show();
		}
}
