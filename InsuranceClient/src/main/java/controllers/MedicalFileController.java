package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Health;
import entities.MedicalFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.interf.IMedicalFileRemote;

public class MedicalFileController implements Initializable {
	List<MedicalFile> listMedicalfiles ;
	Health h;
	   @FXML
	    private TableView<MedicalFile> tableMedicaleFile;

	    @FXML
	    private TableColumn<MedicalFile, String> mideicalId;

	    @FXML
	    private TableColumn<MedicalFile, String> type;

	    @FXML
	    private TableColumn<MedicalFile, String> description;

	    @FXML
	    private TableColumn<MedicalFile, String> bill;
	    
	    @FXML
	    private TextField rechercheMedicalefile;

	    @FXML
	    private ImageView rechercheImge;
	    @FXML
	    private Button contract;
		private ManageHealthContractsContainerController containerParent;
		
	    public void setContainer(ManageHealthContractsContainerController container){
	        this.containerParent = container;
	    }

	    @FXML
	    void getMedicalFile(MouseEvent event) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Consult medical file");
			alert.setHeaderText(null);
			alert.setContentText("Are sure to consult medical file?");

			ButtonType buttonTypeOne = new ButtonType("yes");

			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				if (tableMedicaleFile.getSelectionModel().getSelectedItem() != null) {
					MedicalFile selectedMedicalfile = tableMedicaleFile.getSelectionModel().getSelectedItem();
					/*try {
		
						Stage primaryStage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/medicalFileImage.fxml"));
						Parent root1 = (Parent) loader.load();
						primaryStage.setTitle("Medicale File");
						Scene scene = new Scene(root1);
						scene.getStylesheets().add("/css/application.css");
						primaryStage.setScene(scene);
						MedicalFileImageController mainController = loader.<MedicalFileImageController>getController();
						mainController.setMedicaleFil(selectedMedicalfile);
						Stage stage = (Stage) tableMedicaleFile.getScene().getWindow();
						stage.close();
						primaryStage.show();
						}
					 catch (IOException e) {
						e.printStackTrace();
					}*/
			        FXMLLoader loader = containerParent.switchViewTo("/views/medicalFileImage.fxml");
			        ((MedicalFileImageController) loader.getController()).setContainer(containerParent);
			        ((MedicalFileImageController) loader.getController()).setMedicaleFil(selectedMedicalfile);


				}
			}
	    }
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			Image image = new Image("http://localhost/Img/de-recherche-zoom-icone-5053-128.png");
			rechercheImge.setImage(image);
			
		}
		
		public void setHealth(Health health) {
			h=health;
			String jndiName = "Insurance-ear/Insurance-ejb/MedicalFileImplem!services.interf.IMedicalFileRemote";
			Context context;
			try {
				context = new InitialContext();
				IMedicalFileRemote proxy = (IMedicalFileRemote) context.lookup(jndiName);
				listMedicalfiles = proxy.getMedicalFileByContract(health);
				ObservableList<MedicalFile> listm = FXCollections.observableArrayList();

				listm.addAll(listMedicalfiles);
				
				mideicalId.setCellValueFactory(new PropertyValueFactory<MedicalFile, String>("MedicalFile_id"));
				type.setCellValueFactory((new PropertyValueFactory<MedicalFile, String>("type")));
				description.setCellValueFactory(new PropertyValueFactory<MedicalFile, String>("Description"));
				bill.setCellValueFactory(new PropertyValueFactory<MedicalFile, String>("bill"));
				

				tableMedicaleFile.setItems(listm);
				}
			catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		  @FXML
		    void returnContract(ActionEvent event) {
			 /* try {
					
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HealthContract.fxml"));
					Parent root1 = (Parent) loader.load();
					primaryStage.setTitle("Contract");
					Scene scene = new Scene(root1);
					scene.getStylesheets().add("/css/application.css");
					primaryStage.setScene(scene);
					HealthConractController mainController = loader.<HealthConractController>getController();
					mainController.setId(h.getContract_id());
					Stage stage = (Stage) contract.getScene().getWindow();
					stage.close();
					primaryStage.show();
					}
				 catch (IOException e) {
					e.printStackTrace();
				}*/
		        FXMLLoader loader = containerParent.switchViewTo("/views/HealthContract.fxml");
		        ((HealthConractController) loader.getController()).setContainer(containerParent);
		    }
}
