package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.interf.IHealthInterfaceRemote;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Agent;
import entities.Health;
import javafx.fxml.Initializable;

public class HealthManage implements Initializable {

	@FXML
	private Button addHealth;

	@FXML
	private Button listRequest;

	@FXML
	private Button listRecission;

	@FXML
	private Button listUpdate;

	@FXML
	private Button listrequestrecission;

	@FXML
	private TableView<Health> tableHealth;

	@FXML
	private TableColumn<Health, String> idContract1;

	@FXML
	private TableColumn<Health, String> clientHealth1;

	@FXML
	private TableColumn<Health, String> optionHealth1;

	@FXML
	private TableColumn<Health, String> primeHealth;

	@FXML
	private TableColumn<Health, String> CommissionHealth;

	@FXML
	private ImageView imagerecherche;

	@FXML
	private TextField recherche;
	
	private ManageHealthContractsContainerController containerParent;
	
    public void setContainer(ManageHealthContractsContainerController container){
        this.containerParent = container;
    }

	@FXML
	void addhealthContract(ActionEvent event) {
	/*	try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/views/addHealthContract.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Add Contract");
			Stage stage = (Stage) addHealth.getScene().getWindow();
			stage.close();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
        FXMLLoader loader = containerParent.switchViewTo("/views/addHealthContract.fxml");
        ((AddHealthContractController) loader.getController()).setContainer(containerParent);
	}

	@FXML
	void getListRecission(ActionEvent event) {
	/*	try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/views/healthRescission.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manage Health");
			Stage stage = (Stage) listRecission.getScene().getWindow();
			stage.close();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
        FXMLLoader loader = containerParent.switchViewTo("/views/healthRescission.fxml");
        ((HealthRecissionController) loader.getController()).setContainer(containerParent);
		

	}

	@FXML
	void getListRequestRecission(ActionEvent event) {

	}

	@FXML
	void getlistHealthRequestAdd(ActionEvent event) {

	}

	@FXML
	void listUpdateRequest(ActionEvent event) {

	}

	@FXML
	void rechercheHealth(KeyEvent event) {

	}

	@FXML
	void getHealthContract(MouseEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Consult contract");
		alert.setHeaderText(null);
		alert.setContentText("Are sure to consult Contract?");

		ButtonType buttonTypeOne = new ButtonType("yes");

		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne) {
			if (tableHealth.getSelectionModel().getSelectedItem() != null) {
				Health selectedHealth = tableHealth.getSelectionModel().getSelectedItem();
				/*try {
	
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HealthContract.fxml"));
					Parent root1 = (Parent) loader.load();
					primaryStage.setTitle("Contract");
					Scene scene = new Scene(root1);
					scene.getStylesheets().add("/css/application.css");
					primaryStage.setScene(scene);
					HealthConractController mainController = loader.<HealthConractController>getController();
					mainController.setId(selectedHealth.getContract_id());
					Stage stage = (Stage) tableHealth.getScene().getWindow();
					stage.close();
					primaryStage.show();
					}
				 catch (IOException e) {
					e.printStackTrace();
				}*/
		        FXMLLoader loader = containerParent.switchViewTo("/views/HealthContract.fxml");
		        ((HealthConractController) loader.getController()).setContainer(containerParent);
		        ((HealthConractController) loader.getController()).setId(selectedHealth.getContract_id());
			}
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String jndiName = "Insurance-ear/Insurance-ejb/HealthServiceImplem!services.interf.IHealthInterfaceRemote";
		Context context;
		try {
			context = new InitialContext();

			IHealthInterfaceRemote proxy = (IHealthInterfaceRemote) context.lookup(jndiName);
			Agent agent = new Agent();
			agent.setId(1);
			List<Health> healths = proxy.getHealthByAgent(agent);

			ObservableList<Health> listm = FXCollections.observableArrayList();

			listm.addAll(healths);

			idContract1.setCellValueFactory(new PropertyValueFactory<Health, String>("contract_id"));
			clientHealth1.setCellValueFactory((new PropertyValueFactory<Health, String>("Client")));
			optionHealth1.setCellValueFactory(new PropertyValueFactory<Health, String>("options"));
			primeHealth.setCellValueFactory(new PropertyValueFactory<Health, String>("prime"));
			CommissionHealth.setCellValueFactory(new PropertyValueFactory<Health, String>("commission"));

			tableHealth.setItems(listm);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image image = new Image("http://localhost/Img/de-recherche-zoom-icone-5053-128.png");
		imagerecherche.setImage(image);
	}

}
