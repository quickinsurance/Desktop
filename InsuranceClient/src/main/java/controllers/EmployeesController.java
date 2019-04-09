package controllers;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javax.naming.Context;
import javax.naming.InitialContext;

import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import services.interf.UserServiceRemote;

public class EmployeesController implements Initializable{

	@FXML
	private AnchorPane anchorpane_parent;

	@FXML
	private Pane pane_top;

	@FXML
	private AnchorPane anchorpane_center;

	@FXML
	private AnchorPane anchorpane_left;

	@FXML
	private TextField txt_FirstName;

	@FXML
	private TextField txt_LastName;

	@FXML
	private TextField txt_Email;

	@FXML
	private ComboBox<String> combo_Role;

	@FXML
	private Button btndelete;

	@FXML
	private Button btnAdd;

	@FXML
	private AnchorPane anchorpane_right;

	@FXML
	private TableView<User> tblView;

	private ObservableList<User> data;

	@FXML
	private TableColumn<User, String> column_FirstName;

	@FXML
	private TableColumn<User, String> column_LastName;

	@FXML
	private TableColumn<User, String> column_Role;

	@FXML
	private TableColumn<User, String> Column_Email;
	
    @FXML
    private TableColumn<User, String> column_Note;

	@FXML
	private Button btnPreview;
	
	private BorderPane layout;

	@FXML
	private TextField Search;
	
    @FXML
    private TextArea textArea;

	@FXML
	private Button btnrefresh;

	@FXML
	private Button btnUpdate;
	ObservableList<String> items = FXCollections.observableArrayList();

	@FXML
	private Button btnsave;
	
    @FXML
    private ImageView imageView;
    
    private Image image;
	
    @FXML
    private Button browse;
	
	private FileChooser fileChooser;
	private File file;
	private Desktop desktop = Desktop.getDesktop();
	
    @FXML
    private Spinner spinner;

    @FXML
    private Label gradeLabel;
	
	@FXML
	private TextField txt_field;
	
    @FXML
    private TextField txtPhone;

	private String aRole[] = {"Financier", "Expert", "Agent"};
	User user = new User();

	List<User> usersList;
	
	SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0);

	//public SimpleStringProperty conversion(String string) {    
	//     return new SimpleStringProperty(string);}	
	//	Object Utilisateur ="u" ;
	//StringProperty var = new SimpleStringProperty((String) Utilisateur);
	

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
	//	column_Role.setCellValueFactory(new PropertyValueFactory<>("Role"));

		//initRole();
		try {
			afficher();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.spinner.setValueFactory(gradesValueFactory);
	}

	public void afficher() throws Exception{
		usersList = (List<User>) ServicefindAllUsers();
		data = FXCollections.observableArrayList(usersList);
		column_FirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		column_LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	//	column_Role.setCellValueFactory(new PropertyValueFactory<>("Role"));
		Column_Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
	//	column_Note.setCellValueFactory(new PropertyValueFactory<>("Note"));
		tblView.setItems(null);
		tblView.setItems(data);
	//	ActionEvent event = null;
	//	searchUser(event);
	}

	/*private void initRole(){
		List<String> list = new ArrayList<String>();
		for(String content:aRole){
			list.add(content);
		}
		ObservableList oblist= FXCollections.observableArrayList(list);
		combo_Role.setItems(oblist);
	}*/
	@FXML
	void addUser(ActionEvent event) throws Exception {
		user.setFirstName(txt_FirstName.getText());
		user.setLastName(txt_LastName.getText());
		user.setEmail(txt_Email.getText());
		user.setPhone(Integer.parseInt(txtPhone.getText()));
		//user.setRole(combo_Role.getValue());
		//user.setPhotoURL(textArea.getText());
		//user.setNote(spinner.getValue().toString());
		ServiceAddUser(user);
		System.out.print("User added");
		txt_FirstName.setText("");
		txt_LastName.setText("");
		txt_Email.setText("");
		combo_Role.setValue("");
		imageView.setImage(null);
	//	refreshFields(event);
		//afficher();
	}

	@FXML
	void allUsers(ActionEvent event) throws Exception {
		afficher();
	}
	
	@FXML
	void Supp_click(MouseEvent event) {
		//User u=(User) tblView.getSelectionModel().getSelectedItem();
		//txt_field.setText(String.valueOf(u.getId()));
	}
	@FXML
	void SupprimerAction(ActionEvent event) throws NumberFormatException, Exception {
		//ServiceRemoveUser(Integer.parseInt(txt_field.getText()));
		//afficher();
	}
	@FXML
	void refreshFields(ActionEvent event) throws Exception {
		txt_FirstName.setText("");
		txt_LastName.setText("");
		txt_Email.setText("");
		combo_Role.setValue("");	
		//tblView.getItems().clear();
		afficher();
	}
	@FXML
	void Update(ActionEvent event) throws Exception {
		User selected = tblView.getSelectionModel().getSelectedItem();
		txt_FirstName.setText(selected.getFirstName());
		txt_LastName.setText(selected.getLastName());
		txt_Email.setText(selected.getEmail());
	//	combo_Role.setValue(selected.getRole());
      //  String photoPath=selected.getPhotoURL();
       // imageView.setImage(new Image("file:"+photoPath));
        gradeLabel.setText(spinner.getValue().toString());
	}
	@FXML
	void save(ActionEvent event) throws Exception {
		User selected = tblView.getSelectionModel().getSelectedItem();
		int ID = selected.getId();
		User u2 = new User();
		u2.setId(ID);
		u2.setFirstName(txt_LastName.getText());
		u2.setLastName(txt_FirstName.getText());
		u2.setEmail(txt_Email.getText());
	//	u2.setRole(combo_Role.getValue());
	//	u2.setNote(spinner.getValue().toString());
		ServiceUpdateUser(u2);
		afficher();
	}
	@FXML
	void searchUser(ActionEvent event) throws Exception {

		FilteredList<User> filteredData=new FilteredList<>(data,e->true);
		Search.textProperty().addListener((observableValue,oldValue,newValue)->{
			filteredData.setPredicate((Predicate<? super User>)users->{
				if(newValue == null|| newValue.isEmpty()){
					return true;
				}
				String lowerCaseFilter =  newValue.toLowerCase();

				if(users.getFirstName().toLowerCase().contains(lowerCaseFilter)){
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
    void browseFile(ActionEvent event) {
    	fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().addAll(
    			new ExtensionFilter("Text Files", "*txt"),
    			new ExtensionFilter("Image Files", "*.png","*.jpg"),
    			new ExtensionFilter("Audio Files", "*.mp3"),
    			new ExtensionFilter("All Files", "*.*")
    			);
    	file =fileChooser.showOpenDialog(null);
    	if(file != null){
    		//try {
				//desktop.open(file);
				textArea.setEditable(false);
				textArea.setText(file.getAbsolutePath());
				
				image= new Image(file.toURI().toString(), 100 ,150, true, true);
				//imageView = new ImageView(image);
				imageView.setFitWidth(100);
				imageView.setFitHeight(150);
				imageView.setPreserveRatio(true);
				//layout = new BorderPane();
				//layout.setCenter(imageView);
				imageView.setImage(image);
			//} catch (IOException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
    	}
    }
	
	
	
}







