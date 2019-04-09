package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.jfoenix.controls.JFXTextField;

import entities.User;
import entities.Vehicle;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.interf.VehicleContractServiceRemote;

public class DisplayVehicleContractsController implements Initializable{
	 @FXML
	    private TableView<Vehicle> tblView;

	    @FXML
	    private TableColumn<Vehicle, String> firstNameColumn;

	    @FXML
	    private TableColumn<Vehicle, String> lastNameColumn;

	    @FXML
	    private TableColumn<Vehicle, String> cinColumn;

	    @FXML
	    private TableColumn<Vehicle, String> markColumn;

	    @FXML
	    private TableColumn<Vehicle, String> PrimeColumn;

	    @FXML
	    private TableColumn<Vehicle, String> optionColumn;

	    @FXML
	    private TableColumn<Vehicle, String> groupColumn;
	    
	    @FXML
	    private JFXTextField searchOptiontxt;

	    @FXML
	    private ImageView SearchOptionImg;
	    
	    @FXML
	    private Button consultQuotationsBtn;
	    
		private ObservableList<Vehicle> data;
		List<Vehicle> vehicleContractsList;
		
		private VehicleDisplaysController container;
		
	    public void setContainer(VehicleDisplaysController container){
	        this.container = container;
	    }
		
		
		public Object ServicefindAllVehicleContracts() throws Exception
		{
			String jndiName = "Insurance-ear/Insurance-ejb/VehicleContractServiceImpl!services.interf.VehicleContractServiceRemote";
			Context context = new InitialContext();
			VehicleContractServiceRemote proxy = (VehicleContractServiceRemote) context.lookup(jndiName);

			return proxy.findAllVehicleContracts();
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			afficher();
			ActionEvent event=null;
			OnsearchOption(event);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void afficher() throws Exception{
		
		vehicleContractsList = (List<Vehicle>) ServicefindAllVehicleContracts();
		data = FXCollections.observableArrayList(vehicleContractsList);
		firstNameColumn.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getClient().getFirstName()));
		lastNameColumn.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getClient().getLastName()));
		cinColumn.setCellValueFactory(cellData->new SimpleStringProperty(String.valueOf(cellData.getValue().getClient().getCin())));
		markColumn.setCellValueFactory(new PropertyValueFactory<>("Mark"));
		optionColumn.setCellValueFactory(new PropertyValueFactory<>("VehicleOption"));
		PrimeColumn.setCellValueFactory(new PropertyValueFactory<>("prime"));
		groupColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleGroup"));
		tblView.setItems(null);
		tblView.setItems(data);
	}
	
    @FXML
    void edittxtMarkAction(MouseEvent event) {
    	searchOptiontxt.setEditable(true);
    	searchOptiontxt.setOpacity(1);
    }
    

	
    @FXML
    void OnsearchOption(ActionEvent event) {
    	FilteredList<Vehicle> filteredDataa=new FilteredList<>(data,e->true);
		searchOptiontxt.textProperty().addListener((observableValue,oldValue,newValue)->{
			filteredDataa.setPredicate((Predicate<? super Vehicle>)vehicles->{
				if(newValue == null|| newValue.isEmpty()){
					return true;
				}
				String lowerCaseFilter =  newValue.toLowerCase();
				if(vehicles.getVehicleOption().toLowerCase().contains(lowerCaseFilter)){
					return true;
				}
				return false;
			});
		});
		SortedList<Vehicle> sortedDataa=new SortedList<>(filteredDataa);
		sortedDataa.comparatorProperty().bind(tblView.comparatorProperty());
		tblView.setItems(sortedDataa);
    }
    

    @FXML
    void ConsultQuotationsAction(ActionEvent event) throws IOException {
		/*FXMLLoader loader= new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/DisplayQuotationsView.fxml"));
		Parent showQuotation = loader.load();
		Scene showQuotationScene = new Scene(showQuotation);
		DisplayQuotationsController controller = loader.getController();
		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(showQuotationScene);
		window.show();*/
        FXMLLoader loader = container.switchView("/views/DisplayQuotationsView.fxml");
        ((DisplayQuotationsController)loader.getController()).setContainer(container);
    }
 
}
