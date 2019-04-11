package controllers;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.interf.IHealthInterfaceRemote;

public class HealthRecissionController  implements Initializable {

	 @FXML
	    private TableView<Health> tablerescission;

	    @FXML
	    private TableColumn<Health, String> RescissionId;

	    @FXML
	    private TableColumn<Health, String> clientRecission;

	    @FXML
	    private TableColumn<Health, String> optionsRescission;

	    @FXML
	    private TableColumn<Health, String> primeRescission;

	    @FXML
	    private TableColumn<Health, String> commissionRecission;

	    @FXML
	    private TextField rechercheRescission;

	    @FXML
	    private ImageView imageRescission;

	    @FXML
	    private Button cancelRescission;
	    
	    
		private ManageHealthContractsContainerController containerParent;
		
	    public void setContainer(ManageHealthContractsContainerController container){
	        this.containerParent = container;
	    }

	    @FXML
	    void cancelRescissionAction(ActionEvent event) {
	    /*	try {
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/views/HealthManage.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Manage Health");
				Stage stage = (Stage) cancelRescission.getScene().getWindow();
				stage.close();
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}*/
	        FXMLLoader loader = containerParent.switchViewTo("/views/HealthManage.fxml");
	        ((HealthManage) loader.getController()).setContainer(containerParent);
	    }

	    @FXML
	    void getRescission(MouseEvent event) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Consult contract");
			alert.setHeaderText(null);
			alert.setContentText("Are sure to consult Contract?");

			ButtonType buttonTypeOne = new ButtonType("yes");

			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				if (tablerescission.getSelectionModel().getSelectedItem() != null) {
					Health selectedHealth = tablerescission.getSelectionModel().getSelectedItem();
					/*try {
		
						Stage primaryStage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/consultHealthRescission.fxml"));
						Parent root1 = (Parent) loader.load();
						primaryStage.setTitle("Contract");
						Scene scene = new Scene(root1);
						scene.getStylesheets().add("/css/application.css");
						primaryStage.setScene(scene);
						ConsultRescissionHealth mainController = loader.<ConsultRescissionHealth>getController();
						mainController.setId(selectedHealth.getContract_id());
						Stage stage = (Stage) tablerescission.getScene().getWindow();
						stage.close();
						primaryStage.show();
						}
					 catch (IOException e) {
						e.printStackTrace();
					}*/
			        FXMLLoader loader = containerParent.switchViewTo("/views/consultHealthRescission.fxml");
			        ((ConsultRescissionHealth) loader.getController()).setContainer(containerParent);
			        ((ConsultRescissionHealth) loader.getController()).setId(selectedHealth.getContract_id());							

				}
			}


	    }

	    @FXML
	    void rechrcheRescission(KeyEvent event) {

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
				List<Health> healths = proxy.getRecissionByAgent(agent);

				ObservableList<Health> listm = FXCollections.observableArrayList();

				listm.addAll(healths);

				RescissionId.setCellValueFactory(new PropertyValueFactory<Health, String>("contract_id"));
				clientRecission.setCellValueFactory((new PropertyValueFactory<Health, String>("Client")));
				optionsRescission.setCellValueFactory(new PropertyValueFactory<Health, String>("options"));
				primeRescission.setCellValueFactory(new PropertyValueFactory<Health, String>("prime"));
				commissionRecission.setCellValueFactory(new PropertyValueFactory<Health, String>("commission"));

				tablerescission.setItems(listm);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Image image = new Image("http://localhost/Img/de-recherche-zoom-icone-5053-128.png");
			imageRescission.setImage(image);
			
		}
}
