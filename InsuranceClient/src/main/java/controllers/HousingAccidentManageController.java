package controllers;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.interf.IAccidentInterfaceRemote;
import services.interf.IExpertInterfaceRemote;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Accident;
import entities.Agent;
import entities.Expert;
import javafx.fxml.Initializable;

public class HousingAccidentManageController implements Initializable {

	Expert selectedExpert;
	Accident selectedAccident;
	String errorMessage ;
	   @FXML
	    private ImageView refresh;
	  @FXML
	    private TableView<Accident> tableViewAccident;

	    @FXML
	    private TableColumn<Accident, String> accident;
	    @FXML
	    private TableColumn<Accident, String> dateOFAccident;

	    @FXML
	    private TableColumn<Accident, String> insureName;

	    @FXML
	    private Button btnAddExpaert;

	    @FXML
	    private ListView<Expert> listExpert;

	    @FXML
	    private TableView<Accident> tblManagesinister;

	    @FXML
	    private TableColumn<Accident, String> accident2;

	    @FXML
	    private TableColumn<Accident, String> name2;

	    @FXML
	    private TableColumn<Accident, String> refundexpert;

	    @FXML
	    private TableColumn<Accident, String> opinionExpert;
	    
		private HousingAgentContainerController containerParent;
		
	    public void setContainer(HousingAgentContainerController container){
	        this.containerParent = container;
	    }

	    @FXML
	    void addExpert(ActionEvent event) {
	    	errorMessage ="";
	   	 if (tableViewAccident.getSelectionModel().getSelectedItem() == null || selectedAccident==null) {
	   		 errorMessage+="Choose Accident Please !! \n";
	   	 }
	   	 if(listExpert.getSelectionModel().getSelectedItem()==null|| selectedExpert==null){
	   		 errorMessage+="Choose expert Please !! \n";
	   	 }
	    	if(errorMessage.length()==0 || errorMessage==""){

	    		String jndiName = "Insurance-ear/Insurance-ejb/AccidentServiceImplem!services.interf.IAccidentInterfaceRemote";
	    		Context context;
	    		Alert alert2 = new Alert(AlertType.CONFIRMATION);
				alert2.setTitle("Assign expert");
				alert2.setHeaderText(null);
				alert2.setContentText("Are you sure to assign mister " +selectedExpert.getFirstName()+" "+selectedExpert.getLastName()+" to accident number " +selectedAccident.getAccident_id()+" ?");

				ButtonType assign = new ButtonType("Assign");

				ButtonType Cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

				alert2.getButtonTypes().setAll(assign, Cancel);

				Optional<ButtonType> resultContract = alert2.showAndWait();
				if (resultContract.get() == assign) {
	    		try {
	    			context = new InitialContext();
	    			IAccidentInterfaceRemote proxy = (IAccidentInterfaceRemote)context.lookup(jndiName);
	    			selectedAccident.setExpert(selectedExpert);
	    			selectedAccident.setTreated(true);
	    			proxy.updateAccidentAgent(selectedAccident);

	    		/*	try {
						Stage primaryStage = new Stage();
						Parent root = FXMLLoader.load(getClass().getResource("/views/HousingAccidentManage.fxml"));
						Scene scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
						primaryStage.setScene(scene);
						primaryStage.setTitle("Manage Health");
						Stage stage = (Stage) btnAddExpaert.getScene().getWindow();
						stage.close();
						primaryStage.show();
					} catch (Exception e) {
						e.printStackTrace();
					}*/
	    			
	    			  FXMLLoader loader = containerParent.switchViewTo("/views/HousingAccidentManage.fxml");
				        ((HousingAccidentManageController) loader.getController()).setContainer(containerParent);

	    			
	    		} catch (NamingException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}}
	    		
	    	}
	    	
	    	else{
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Invalid fields");
	            alert.setHeaderText("Please fill in the fields");
	            alert.setContentText(errorMessage);
	            alert.showAndWait();
	    	}
	    }
	    @FXML
	    void getExpert(MouseEvent event) {

	    	selectedExpert=listExpert.getSelectionModel().getSelectedItem();
	    }

	    @FXML
	    void getaccident(MouseEvent event) {
	    	 if (tableViewAccident.getSelectionModel().getSelectedItem() != null) {
	    	selectedAccident=tableViewAccident.getSelectionModel().getSelectedItem();
	    	}
	    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		Afficher();
	}
	
	

	public void Afficher(){
		
		String jndiName = "Insurance-ear/Insurance-ejb/AccidentServiceImplem!services.interf.IAccidentInterfaceRemote";
		Context context;
		String jndiNameExpert = "Insurance-ear/Insurance-ejb/ExpertServiceImplem!services.interf.IExpertInterfaceRemote";
		Context contextExpert;

		Agent agent = new Agent();
		agent.setId(1);
		
		try {
			
			//table 1
			context = new InitialContext();
			IAccidentInterfaceRemote proxy = (IAccidentInterfaceRemote)context.lookup(jndiName);
			List<Accident> accidents = proxy.getListHousingAccident(agent);
			ObservableList<Accident> listm = FXCollections.observableArrayList();

			listm.addAll(accidents);

			accident.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAccident_id()+""));
			insureName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getHousing().getClient()
					.getFirstName()+ cellData.getValue().getHousing().getClient().getLastName()));
			dateOFAccident.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getDate_of_Accident().toString()));
			tableViewAccident.setItems(listm);
			
			//list view
			contextExpert = new InitialContext();
			IExpertInterfaceRemote proxyExpert = (IExpertInterfaceRemote)contextExpert.lookup(jndiNameExpert);
			List<Expert> experts = proxyExpert.getExpertBySpeciality("housing");
			ObservableList<Expert> items = FXCollections.observableArrayList();
			items.addAll(experts);
			listExpert.setItems(items);
			listExpert.setCellFactory(param -> new ListCell<Expert>() {
			    @Override
			    protected void updateItem(Expert item, boolean empty) {
			        super.updateItem(item, empty);

			        if (empty || item == null ) {
			            setText(null);
			        } else {
			            setText(item.getFirstName()+ " "+item.getLastName());
			        }
			    }
			});
			
			
			
			//table 2
			
		
		 
			
		 	List<Accident> accidentsTreated =proxy.getListHousingAccidentTreatedByExpert(agent);
			ObservableList<Accident> listm2= FXCollections.observableArrayList();
			listm2.addAll(accidentsTreated);
			accident2.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAccident_id()+""));
			name2.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getHousing().getClient()
					.getFirstName()+ cellData.getValue().getHousing().getClient().getLastName()));
			refundexpert.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getExpert_refund()+""));
			opinionExpert.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getExpert_opinion()));
			tblManagesinister.setItems(listm2);
			
		
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    @FXML
    void getRepport(MouseEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Consult Report ");
		alert.setHeaderText(null);
		alert.setContentText("Are sure to consult Report?");

		ButtonType buttonTypeOne = new ButtonType("yes");

		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne) {
			if (tblManagesinister.getSelectionModel().getSelectedItem() != null) {
				Accident selectedAccident = tblManagesinister.getSelectionModel().getSelectedItem();
				/*try {
	
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ReportView.fxml"));
					Parent root1 = (Parent) loader.load();
					primaryStage.setTitle("Report");
					Scene scene = new Scene(root1);
					scene.getStylesheets().add("/css/application.css");
					primaryStage.setScene(scene);
					RepportViewController mainController = loader.<RepportViewController>getController();
					mainController.setId(selectedAccident.getAccident_id());
					Stage stage = (Stage) tblManagesinister.getScene().getWindow();
					stage.close();
					primaryStage.show();
					}
				 catch (IOException e) {
					e.printStackTrace();
				}*/
		        FXMLLoader loader = containerParent.switchViewTo("/views/ReportView.fxml");
		        ((RepportViewController) loader.getController()).setContainer(containerParent);
		        ((RepportViewController) loader.getController()).setId(selectedAccident.getAccident_id());

			}
		}
    }
    
    @FXML
    void refreshAction(MouseEvent event) {
    	Afficher();
    }

}
