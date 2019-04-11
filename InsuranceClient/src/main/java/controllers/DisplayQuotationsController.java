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
import javafx.scene.control.Label;
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
   
    @FXML
    private Label contractsNumberLabel;

    @FXML
    private Label tiersEtenduLabel;

    @FXML
    private Label tiersNumberlabel;

    @FXML
    private Label allrisksNumber;

    @FXML
    private Label BmwLabel;

    @FXML
    private Label kiaLabel;

    @FXML
    private Label FiatLabel;

    @FXML
    private Label minicooperLabel;

    @FXML
    private Label nissanLabel;

    @FXML
    private Label volswagenLabel;

    @FXML
    private Label toyotaLabel;

    @FXML
    private Label renaultLabel;

    @FXML
    private Label citroenLabel;

    @FXML
    private Label audiLabel;

    @FXML
    private Label daciaLabel;

    @FXML
    private Label peugoetLabel;
    



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
		
		ObservableList<VehicleQuotation> oblist=FXCollections.observableArrayList(vehicleQuotationsList);
		int a =0;
		int b =0;
		int c=0;
		int d=0;
		int e=0;
		int f=0;
		int g=0;
		int h=0;
		int j=0;
		int k=0;
		int m=0;
		int n=0;
		int x=0;
		int y=0;
		int z=0;
		int w=0;
				
		for (int i=0; i<oblist.size(); i++){
		
		if (oblist.get(i).getMark().equals("BMW"))
			{
				a++;
				}else if(oblist.get(i).getMark().equals("FIAT")){
					b++;
				}
				else if(oblist.get(i).getMark().equals("KIA")){
					c++;
		}
				else if(oblist.get(i).getMark().equals("NISSAN")){
					d++;
		}
				else if(oblist.get(i).getMark().equals("TOYOTA")){
					e++;
		}
				else if(oblist.get(i).getMark().equals("MINI COOPER")){
					f++;
		}
				else if(oblist.get(i).getMark().equals("VOLKSWAGEN")){
					g++;
		}
				else if(oblist.get(i).getMark().equals("RENAULT")){
					h++;
		}
				else if(oblist.get(i).getMark().equals("CITROEN")){
					j++;
		}
				else if(oblist.get(i).getMark().equals("AUDI")){
					k++;
		}
				else if(oblist.get(i).getMark().equals("DACIA")){
					m++;
		}
				else if(oblist.get(i).getMark().equals("PEUGEOT")){
					n++;
		}
			   if(oblist.get(i).getOption_vehicle().equals("All Risks")){
					y++;
		}
				else if(oblist.get(i).getOption_vehicle().equals("Tiers")){
					z++;
		}
				else if(oblist.get(i).getOption_vehicle().equals("Tiers Etendu")){
					w++;
		}
		
		    BmwLabel.setText(String.valueOf(a));
		    FiatLabel.setText(String.valueOf(b));
		    kiaLabel.setText(String.valueOf(c));
		    nissanLabel.setText(String.valueOf(d));
		    toyotaLabel.setText(String.valueOf(e));
		    minicooperLabel.setText(String.valueOf(f));
		    volswagenLabel.setText(String.valueOf(g));
		    renaultLabel.setText(String.valueOf(h));
		    citroenLabel.setText(String.valueOf(j));
		    audiLabel.setText(String.valueOf(k));
		    daciaLabel.setText(String.valueOf(m));
		    peugoetLabel.setText(String.valueOf(n));
		    contractsNumberLabel.setText(String.valueOf(oblist.size()));
		    allrisksNumber.setText(String.valueOf(y));
		    tiersNumberlabel.setText(String.valueOf(z));
		    tiersEtenduLabel.setText(String.valueOf(w));   
		}
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
