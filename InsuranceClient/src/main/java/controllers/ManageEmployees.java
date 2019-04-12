package controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.tools.DocumentationTool.Location;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;

import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import services.interf.UserServiceRemote;
import javafx.stage.Stage;

public class ManageEmployees implements Initializable{

	@FXML
	private AnchorPane anchor_parent;

	@FXML
	private Pane pane;

	@FXML
	private JFXTextField txtSearch;

	@FXML
	private Button btnPreview;

	@FXML
	private JFXTextField txtFirstName;

	@FXML
	private JFXTextField txtLastName;

	@FXML
	private JFXTextField txtEmail;

	@FXML
	private JFXTextField txtPhone;

	@FXML
	private TextField txtfield_delete;

	@FXML
	private JFXComboBox<String> comboRole;

	@FXML
	private JFXDatePicker PickerBirth;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnDelete;

	@FXML
	private Button btnUpdate;

	@FXML
	private ImageView imageView;

	@FXML
	private Button browsebtn;

	@FXML
	private Button btnsave;
	@FXML
	private TableView<User> tblView;
	private ObservableList<User> data;


	@FXML
	private TableColumn<User, String> column_FirstName;

	@FXML
	private TableColumn<User, String> column_LastName;

	@FXML
	private TableColumn<User, String> ColumnRole;

	@FXML
	private TableColumn<User, String> columnEmail;

	@FXML
	private TableColumn<User, String> ColumnNote;
	@FXML
	private TextArea textArea;

	@FXML
	private JFXSpinner spinnerAct;

	@FXML
	private Spinner spinner;
	
    @FXML
    private Button btnAddNew;

	//User
	User user = new User();
	List<User> usersList;
	SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0);



	//combo Role
	private String aRole[] = {"Financier", "Expert", "Agent"};
	//Upload photo
	private FileChooser fileChooser;
	private File file;
	private Desktop desktop = Desktop.getDesktop();
	private Image image;
	


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
		
		this.spinner.setValueFactory(gradesValueFactory);
		initRole();
		// TODO Auto-generated method stub
		try {
			afficher();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initRole(){
		List<String> list = new ArrayList<String>();
		for(String content:aRole){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		comboRole.setItems(oblist);

	}



	public void afficher() throws Exception{
		usersList = (List<User>) ServicefindAllUsers();
		data = FXCollections.observableArrayList(usersList);
		column_FirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		column_LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		ColumnNote.setCellValueFactory(new PropertyValueFactory<>("Note"));
		ColumnRole.setCellValueFactory(new PropertyValueFactory<>("Role"));
		tblView.setItems(null);
		tblView.setItems(data);
		ActionEvent event = null;
		SearchUser(event);
	}
	@FXML
	void SearchUser(ActionEvent event) {
		FilteredList<User> filteredData=new FilteredList<>(data,e->true);
		txtSearch.textProperty().addListener((observableValue,oldValue,newValue)->{
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
	void addUser(ActionEvent event) throws Exception {
		user.setFirstName(txtFirstName.getText());
		user.setLastName(txtLastName.getText());
		user.setEmail(txtEmail.getText());
		user.setPhone(Integer.parseInt(txtPhone.getText()));
		user.setRole(comboRole.getValue());
		user.setPhoto(textArea.getText());
		user.setNote(0);
		ServiceAddUser(user);
		System.out.print("User added");
		txtFirstName.setText("");
		txtLastName.setText("");
		txtEmail.setText("");
		txtPhone.setText("");
		comboRole.setValue("");
		imageView.setImage(null);
		//	refreshFields(event);
		afficher();
	}

	@FXML
	void refreshFields(ActionEvent event) {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtEmail.setText("");
		txtPhone.setText("");
		comboRole.setValue("");
		imageView.setImage(null);
	}


	@FXML
	void browseFile(ActionEvent event) {
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Image Files", "*.png","*.jpg"),
				new ExtensionFilter("Text Files", "*txt"),
				new ExtensionFilter("Audio Files", "*.mp3"),
				new ExtensionFilter("All Files", "*.*")
				);
		file =fileChooser.showOpenDialog(null);
		if(file != null){
			//	desktop.open(file);
			textArea.setEditable(false);
			textArea.setText(file.getAbsolutePath());
			image= new Image(file.toURI().toString(), 100 ,150, true, true);
			imageView.setFitWidth(100);
			imageView.setFitHeight(150);
			imageView.setPreserveRatio(true);
			imageView.setImage(image);
		}
	}
	@FXML
	void Supp_click(MouseEvent event) {
		User u=(User) tblView.getSelectionModel().getSelectedItem();
		txtfield_delete.setText(String.valueOf(u.getId()));
	}
	@FXML
	void SupprimerAction(ActionEvent event) throws NumberFormatException, Exception {
		ServiceRemoveUser(Integer.parseInt(txtfield_delete.getText()));
		afficher();
	}
	@FXML
	void Update(ActionEvent event) {
		User selected = tblView.getSelectionModel().getSelectedItem();
		txtFirstName.setText(selected.getFirstName());
		txtLastName.setText(selected.getLastName());
		txtEmail.setText(selected.getEmail());
		txtPhone.setText(String.valueOf(selected.getPhone()));
		comboRole.setValue(selected.getRole());
		String photoPath=selected.getPhoto();
		imageView.setImage(new Image("file:"+photoPath));
		SpinnerValueFactory<Integer> gradesValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, selected.getNote());
		this.spinner.setValueFactory(gradesValueFactory2);

	}

	@FXML
	void save(ActionEvent event) throws Exception {
		User selected = tblView.getSelectionModel().getSelectedItem();
		int ID = selected.getId();
		User u2 = new User();
		u2.setId(ID);
		u2.setFirstName(txtFirstName.getText());
		u2.setLastName(txtLastName.getText());
		u2.setEmail(txtEmail.getText());
		u2.setPhone(Integer.parseInt(txtPhone.getText()));
		u2.setRole(comboRole.getValue());
		u2.setNote(Integer.parseInt(spinner.getValue().toString()));
		ServiceUpdateUser(u2);
		refreshFields(event);
		afficher();
	}
	


}
