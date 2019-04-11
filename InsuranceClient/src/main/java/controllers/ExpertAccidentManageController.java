package controllers;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Accident;
import entities.Expert;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.MouseEvent;
import services.interf.IAccidentInterfaceRemote;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;

public class ExpertAccidentManageController implements Initializable {
	  @FXML
	    private TableView<Accident> listAccident;

	    @FXML
	    private TableColumn<Accident, String> idAccident;

	    @FXML
	    private TableColumn<Accident, String> insuredNAme;

	    @FXML
	    private TableColumn<Accident, String> description;

	    @FXML
	    private TableColumn<Accident, String> dateAccident;
	    @FXML
	    void getAccident(MouseEvent event) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Consult Accident");
			alert.setHeaderText(null);
			alert.setContentText("Are sure to consult Accident?");

			ButtonType buttonTypeOne = new ButtonType("yes");

			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				if (listAccident.getSelectionModel().getSelectedItem() != null) {
					Accident selectedAccident = listAccident.getSelectionModel().getSelectedItem();
				/*	try {
		
						Stage primaryStage = new Stage();
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/addReport.fxml"));
						Parent root1 = (Parent) loader.load();
						primaryStage.setTitle("Accident");
						Scene scene = new Scene(root1);
						scene.getStylesheets().add("/css/application.css");
						primaryStage.setScene(scene);
						AddReportController mainController = loader.<AddReportController>getController();
						mainController.setId(selectedAccident.getAccident_id());
						Stage stage = (Stage) listAccident.getScene().getWindow();
						stage.close();
						primaryStage.show();
						}
					 catch (IOException e) {
						e.printStackTrace();
					}*/
					
					 FXMLLoader loader = containerParent.switchViewTo("/views/addReport.fxml");
				        ((AddReportController) loader.getController()).setContainer(containerParent);
				        ((AddReportController) loader.getController()).setId(selectedAccident.getAccident_id());


				}
			}
	    }
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			String jndiName = "Insurance-ear/Insurance-ejb/AccidentServiceImplem!services.interf.IAccidentInterfaceRemote";
			Context context;
			Expert expert = new Expert();
			expert.setId(29);
			try {
			
				context = new InitialContext();
				IAccidentInterfaceRemote proxy = (IAccidentInterfaceRemote)context.lookup(jndiName);
				List<Accident> accidents = proxy .getListAccidentNOtTreatedByExpert(expert);
				ObservableList<Accident> listm = FXCollections.observableArrayList();
				listm.addAll(accidents);
				idAccident.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAccident_id()+""));
				insuredNAme.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getHousing().getClient()
						.getFirstName()+ cellData.getValue().getHousing().getClient().getLastName()));
				dateAccident.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getDate_of_Accident().toString()));
				description.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getType_contract().toString()+" accident"));
				listAccident.setItems(listm);

				
			}
			catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
			private HousingExpertManageContainerController containerParent;
		
	    public void setContainer(HousingExpertManageContainerController container){
	        this.containerParent = container;
	    }

}
