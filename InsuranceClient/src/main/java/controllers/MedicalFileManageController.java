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
import entities.MedicalFile;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.interf.IMedicalFileRemote;

public class MedicalFileManageController implements Initializable {

    @FXML
    private TableView<MedicalFile> tbViewMedicalFile;

    @FXML
    private TableColumn<MedicalFile, String> id_medicaleFile;

    @FXML
    private TableColumn<MedicalFile, String> consultationDate;

    @FXML
    private TableColumn<MedicalFile, String> insuredName;

    @FXML
    private TableColumn<MedicalFile, String> formulas;

    @FXML
    private TableColumn<MedicalFile, String> bill;

    @FXML
    private TableColumn<MedicalFile, String> type;
	
	List<MedicalFile> listMedicalfiles;
	Agent agent ;
	
	private ManageFileContainerController containerParent;

	public void setContainer(ManageFileContainerController manageFileContainerController) {
        this.containerParent = manageFileContainerController;

		
	}
	
	  @FXML
	    void getListMedicalFile(MouseEvent event) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Consult medical file");
			alert.setHeaderText(null);
			alert.setContentText("Are sure to consult medical file?");

			ButtonType buttonTypeOne = new ButtonType("yes");

			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				if (tbViewMedicalFile.getSelectionModel().getSelectedItem() != null) {
					MedicalFile selectedMedicalfile = tbViewMedicalFile.getSelectionModel().getSelectedItem();
				/*	try {
		
						Stage primaryStage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MedicalFileSingleManage.fxml"));
						Parent root1 = (Parent) loader.load();
						primaryStage.setTitle("Medicale File");
						Scene scene = new Scene(root1);
						scene.getStylesheets().add("/css/application.css");
						primaryStage.setScene(scene);
						MedicalFileSingleManageController mainController = loader.<MedicalFileSingleManageController>getController();
						mainController.setMedicalFil(selectedMedicalfile);
						Stage stage = (Stage) tbViewMedicalFile.getScene().getWindow();
						stage.close();
						primaryStage.show();
						}
					 catch (IOException e) {
						e.printStackTrace();
					}*/
					
					  FXMLLoader loader = containerParent.switchViewTo("/views/MedicalFileSingleManage.fxml");
				        ((MedicalFileSingleManageController) loader.getController()).setContainer(containerParent);
				        
				        ((MedicalFileSingleManageController) loader.getController()).setMedicalFil(selectedMedicalfile);


				}
			}
		 
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 agent = new Agent();
		  agent.setId(13);
		  String jndiName = "Insurance-ear/Insurance-ejb/MedicalFileImplem!services.interf.IMedicalFileRemote";
			Context context;
			try {
				context = new InitialContext();
				IMedicalFileRemote proxy = (IMedicalFileRemote) context.lookup(jndiName);
				listMedicalfiles = proxy.listMedicalFileByAgent(agent);
				ObservableList<MedicalFile> listm = FXCollections.observableArrayList();

				listm.addAll(listMedicalfiles);				
				id_medicaleFile.setCellValueFactory(new PropertyValueFactory<MedicalFile, String>("MedicalFile_id"));
				type.setCellValueFactory((new PropertyValueFactory<MedicalFile, String>("type")));
				consultationDate.setCellValueFactory(new PropertyValueFactory<MedicalFile, String>("consultation_date"));
				bill.setCellValueFactory(new PropertyValueFactory<MedicalFile, String>("bill"));
				insuredName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue()
						.getHealth().getClient().getFirstName()+" "+cellData.getValue()
						.getHealth().getClient().getLastName()));
				formulas.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue()
						.getHealth().getFormulas()));
				

				tbViewMedicalFile.setItems(listm);
				}
			catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}


}
