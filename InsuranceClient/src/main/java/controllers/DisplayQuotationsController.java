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
import entities.VehicleQuotation;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.interf.UserServiceRemote;
import services.interf.VehicleQuotationServiceRemote;

public class DisplayQuotationsController implements Initializable{
	@FXML
	private AnchorPane anchorParent;

	@FXML
	private TableView<VehicleQuotation> tblView;

	@FXML
	private TableColumn<VehicleQuotation, String> firstNameColumn;

	@FXML
	private TableColumn<VehicleQuotation, String> lastNameColumn;

	@FXML
	private TableColumn<VehicleQuotation, String> cinColumn;

	@FXML
	private TableColumn<VehicleQuotation, String> markColumn;

	@FXML
	private TableColumn<VehicleQuotation, String> optionColumn;

	@FXML
	private TableColumn<VehicleQuotation, String> primeColumn;
	
    @FXML
    private JFXTextField searchMarktxt;

	@FXML
	private Button btnaddContract;
    @FXML
    private Button consultContractsBtn;
    @FXML
    private ImageView iconBmwImage;

	private ObservableList<VehicleQuotation> data;
	List<VehicleQuotation> vehicleQuotationsList;
	
    private VehicleDisplaysController container;
    
    public void setContainer(VehicleDisplaysController container) {
        this.container = container;
    }

	public Object ServicefindAllVehicleQuotations() throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/VehicleQuotationServiceImpl!services.interf.VehicleQuotationServiceRemote";
		Context context = new InitialContext();
		VehicleQuotationServiceRemote proxy = (VehicleQuotationServiceRemote) context.lookup(jndiName);

		return proxy.findAllVehicleQuotations();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			displayQuotations();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void displayQuotations() throws Exception{
		vehicleQuotationsList = (List<VehicleQuotation>) ServicefindAllVehicleQuotations();
		data = FXCollections.observableArrayList(vehicleQuotationsList);
		firstNameColumn.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getUser().getFirstName()));
		lastNameColumn.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getUser().getLastName()));
		cinColumn.setCellValueFactory(cellData->new SimpleStringProperty(String.valueOf(cellData.getValue().getUser().getCin())));
		markColumn.setCellValueFactory(new PropertyValueFactory<>("Mark"));
		optionColumn.setCellValueFactory(new PropertyValueFactory<>("Option_vehicle"));
		primeColumn.setCellValueFactory(new PropertyValueFactory<>("primeQuotation"));
		tblView.setItems(null);
		tblView.setItems(data);
		ActionEvent event =null;
		OnsearchMarkAction(event);
	}

    @FXML
    void OnsearchMarkAction(ActionEvent event) {
    	FilteredList<VehicleQuotation> filteredDataa=new FilteredList<>(data,e->true);
		searchMarktxt.textProperty().addListener((observableValue,oldValue,newValue)->{
			filteredDataa.setPredicate((Predicate<? super VehicleQuotation>)vehicles->{
				if(newValue == null|| newValue.isEmpty()){
					return true;
				}
				String lowerCaseFilter =  newValue.toLowerCase();
				if(vehicles.getMark().toLowerCase().contains(lowerCaseFilter)){
					return true;
				}
				return false;
			});
		});
		SortedList<VehicleQuotation> sortedDataa=new SortedList<>(filteredDataa);
		sortedDataa.comparatorProperty().bind(tblView.comparatorProperty());
		tblView.setItems(sortedDataa);
		if(searchMarktxt.getText().equals("BMW")){
			iconBmwImage.setVisible(true);	
		}
    }

	@FXML
	void moveToAddContractAction(ActionEvent event) throws IOException {
		
		VehicleQuotation selected = tblView.getSelectionModel().getSelectedItem(); 
		//FXMLLoader loader= new FXMLLoader();
	/*	loader.setLocation(getClass().getResource("/views/AddContractView.fxml"));
		Parent addContract = loader.load();
		Scene addContractScene = new Scene(addContract);
		AddContractController controller = loader.getController();
		controller.setVehicleQuotation(selected);
		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(addContractScene);
		window.show();*/
        FXMLLoader loader = container.switchView("/views/AddContractView.fxml");
        ((AddContractController)loader.getController()).setContainer(container);
        ((AddContractController)loader.getController()).setVehicleQuotation(selected);
	}
    @FXML
    void showContractsAction(ActionEvent event) throws IOException {
		/*FXMLLoader loader= new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/DisplayVehicleContractsView.fxml"));
		Parent showContract = loader.load();
		Scene showContractScene = new Scene(showContract);
		DisplayVehicleContractsController controller = loader.getController();
		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(showContractScene);
		window.show();*/
        FXMLLoader loader = container.switchView("/views/DisplayVehicleContractsView.fxml");
        ((DisplayVehicleContractsController) loader.getController()).setContainer(container);
    }
}
