package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.crypto.CipherInputStream;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.controlsfx.control.Rating;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;

import entities.User;
import entities.Vehicle;
import entities.VehicleQuotation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.interf.UserServiceRemote;

public class ManageEmployeesController implements Initializable{
	@FXML
	private AnchorPane anchorParent;

	@FXML
	private TableView<User> tblView;

	@FXML
	private TableColumn<User, String> column_FirstName;

	@FXML
	private TableColumn<User, String> column_LastName;

	@FXML
	private TableColumn<User, String> columnCin;

	@FXML
	private TableColumn<User, String> ColumnRole;

	@FXML
	private TableColumn<User, String> columnEmail;

	@FXML
	private TableColumn<User, String> ColumnNote;

	@FXML
	private JFXTextField txtFirstName;

	@FXML
	private JFXTextField txtLastName;

	@FXML
	private JFXTextField txtEmail;
	
    @FXML
    private JFXTextField txtcin;

	@FXML
	private ImageView EmployeeImageView;

	@FXML
	private Button updateBtn;

	@FXML
	private Button saveBtn;

	@FXML
	private Button btnDelete;

	@FXML
	private Label firstNameLabel;

	@FXML
	private Label lastNameLabel;

	@FXML
	private JFXTextField searchText;

    @FXML
    private TextField txtfieldDelete;

    @FXML
    private ImageView refreshImageView;
    @FXML
    private ImageView addEmployeeImage;
    
    @FXML
    private Rating ratingId;
    
    @FXML
    private JFXTextField phonetxt;
    
    @FXML
    private Label nombreAgentLabel;

    @FXML
    private Label nombreExpertsLabel;

    @FXML
    private Label nbreFinanciersLabel;
	
	@FXML
	private ImageView searchIcone;
	User user = new User();
	private ObservableList<User> data;
	private ObservableList<User> dataA;
	private ObservableList<User> dataE;
	private ObservableList<User> dataF;
	List<User> usersList;
	List<User> usersListA;
	List<User> usersListE;
	List<User> usersListF;
	
	private ManageEmployeesDisplaysController containerParent;
	
    public void setContainer(ManageEmployeesDisplaysController container){
        this.containerParent = container;
    }
	
	public int ServiceAddUser(User u) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		return proxy.addUser(u);
	}

	public Object ServicefindAllUsers() throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		return proxy.findAllUsers();
	}
	public Object ServicefindAllExperts() throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		return proxy.findAllExperts();
	}
	public Object ServicefindAllAgents() throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		return proxy.findAllAgents();
	}
	public Object ServicefindAllFinanciers() throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		return proxy.findAllFinanciers();
	}
	
	

	public void ServiceRemoveUser(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		proxy.removeUser(id);
	}

	public User ServicefindUser(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		return proxy.findUserById(id);
	}

	public void ServiceUpdateUser(User user) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		proxy.updateUser(user);;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			afficher();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void afficher() throws Exception{
		usersList = (List<User>) ServicefindAllUsers();
		data= FXCollections.observableArrayList(usersList);
		usersListE= (List<User>) ServicefindAllExperts();
		usersListA=(List<User>) ServicefindAllAgents();
		usersListF=(List<User>) ServicefindAllFinanciers();
		
		dataA = FXCollections.observableArrayList(usersListA);
		dataE = FXCollections.observableArrayList(usersListE);
		dataF = FXCollections.observableArrayList(usersListF);
		
		data=FXCollections.concat(dataA, dataE, dataF);
		
		column_FirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		column_LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		ColumnNote.setCellValueFactory(new PropertyValueFactory<>("Note"));
		ColumnRole.setCellValueFactory(new PropertyValueFactory<>("Role"));
		columnCin.setCellValueFactory(new PropertyValueFactory<>("Cin"));
		tblView.setItems(null);
		tblView.setItems(data);
		ActionEvent event = null;
		SearchEmployeeAction(event);
	
		ObservableList<User> oblist=FXCollections.observableArrayList(usersList);
		int a =0;
		int b =0;
		int c=0;
		
		for (int i=0; i<oblist.size(); i++){
			
			if (oblist.get(i).getRole().equals("Financier"))
				{
					a++;
					}else if(oblist.get(i).getRole().equals("Expert")){
						b++;
					}
					else if(oblist.get(i).getRole().equals("Agent")){
						c++;
			}
			
		    nbreFinanciersLabel.setText(String.valueOf(a));
		    nombreExpertsLabel.setText(String.valueOf(b));
		    nombreAgentLabel.setText(String.valueOf(c));}
		
	}
    @FXML
    void refreshAction(MouseEvent event) throws Exception {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtEmail.setText("");
		txtcin.setText("");
		ratingId.setRating(0);
		phonetxt.setText("");
		firstNameLabel.setText("");
		lastNameLabel.setText("");
		EmployeeImageView.setImage(null);
		afficher();
    }

    
	@FXML
	void SearchEmployeeAction(ActionEvent event) {
		FilteredList<User> filteredData=new FilteredList<>(data,e->true);
		searchText.textProperty().addListener((observableValue,oldValue,newValue)->{
			filteredData.setPredicate((Predicate<? super User>)users->{
				if(newValue == null|| newValue.isEmpty()){
					return true;
				}
				String lowerCaseFilter =  newValue.toLowerCase();
				if(users.getRole().toLowerCase().contains(lowerCaseFilter)){
					return true;
				}
				return false;
			});
		});
		SortedList<User> sortedData=new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tblView.comparatorProperty());
		tblView.setItems(sortedData);
	}


    @FXML
    void Supp_click(MouseEvent event) {
    	User u=(User) tblView.getSelectionModel().getSelectedItem();
		txtfieldDelete.setText(String.valueOf(u.getId()));
    }

	@FXML
	void DeleteEmployeeAction(ActionEvent event) throws NumberFormatException, Exception {
		ServiceRemoveUser(Integer.parseInt(txtfieldDelete.getText()));
		afficher();
	}

	@FXML
	void updateEmployeeAction(ActionEvent event) {
		User selected = tblView.getSelectionModel().getSelectedItem();
		txtFirstName.setText(selected.getFirstName());
		txtLastName.setText(selected.getLastName());
		txtEmail.setText(selected.getEmail());
		txtcin.setText(String.valueOf(selected.getCin()));
		ratingId.setRating(selected.getNote());
		phonetxt.setText(String.valueOf(selected.getPhone()));
		String photoPath=selected.getPhoto();
		EmployeeImageView.setImage(new Image("file:"+photoPath));
		firstNameLabel.setText(selected.getFirstName());
		lastNameLabel.setText(selected.getLastName());
	}
	@FXML
	void SaveEmployeeAction(ActionEvent event) throws Exception {
		User selected = tblView.getSelectionModel().getSelectedItem();
		int ID = selected.getId();
		User u2 = new User();
		u2.setId(ID);
		u2.setFirstName(txtFirstName.getText());
		u2.setLastName(txtLastName.getText());
		u2.setEmail(txtEmail.getText());
		u2.setCin(Integer.parseInt(txtcin.getText()));
		u2.setNote((int)ratingId.getRating());
		u2.setPhone(Integer.parseInt(phonetxt.getText()));
		ServiceUpdateUser(u2);
		txtFirstName.setText("");
		txtLastName.setText("");
		txtEmail.setText("");
		txtcin.setText("");
		phonetxt.setText("");
		ratingId.setRating(0);
		firstNameLabel.setText("");
		lastNameLabel.setText("");
		EmployeeImageView.setImage(null);
		
		
		
		afficher();
	}

    @FXML
    void moveToAddEmloyeeAction(MouseEvent event) throws IOException {
		/*Parent dialog =  FXMLLoader.load(getClass().getResource("/views/EmployeInscriptionView.fxml"));
		Scene dialogScene = new Scene(dialog);
		Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(dialogScene);
		window.show();*/
        FXMLLoader loader = containerParent.switchViewTo("/views/EmployeInscriptionView.fxml");
        ((EmployeInscriptionController) loader.getController()).setContainer(containerParent);
    }

}
