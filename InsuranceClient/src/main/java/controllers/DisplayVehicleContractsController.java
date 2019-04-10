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
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	    
	    @FXML
	    private Label contractsNumberLabel;

	    @FXML
	    private Label tiersEtenduLabel;

	    @FXML
	    private Label tiersNumberlabel;

	    @FXML
	    private Label allrisksNumber;
	    
	    private final ObservableList<PieChart.Data> details = FXCollections.observableArrayList();
	    @FXML
	    private PieChart pieChart;	
	    @FXML
	    private Label group1Label;

	    @FXML
	    private Label group2Label;

	    @FXML
	    private Label group3Label;

	    @FXML
	    private Label group4label;

	    @FXML
	    private Label group5Label;

	    @FXML
	    private Label group6Label;

	    @FXML
	    private Label group7label;

	    @FXML
	    private Label group8label;

	    @FXML
	    private Label group9label;

	    @FXML
	    private Label group10label;

	    @FXML
	    private Label group11label;
	    @FXML
	    private ImageView statisticsImg;
	    
	    		
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
						
		ObservableList<Vehicle> oblist=FXCollections.observableArrayList(vehicleContractsList);
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
			   if(oblist.get(i).getVehicleOption().equals("All Risks")){
					y++;
		}
				else if(oblist.get(i).getVehicleOption().equals("Tiers")){
					z++;
		}
				else if(oblist.get(i).getVehicleOption().equals("Tiers Etendu")){
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
		
		    int g1 =0;
		    int g2=0;
		    int g3=0;
		    int g4=0;
		    int g5=0;
		    int g6=0;
		    int g7=0;
		    int g8=0;
		    int g9=0;
		    int g10=0;
		    int g11=0;
		    for (int i2=0; i2<oblist.size(); i2++){
				
				if (oblist.get(i2).getVehicleGroup().equals("Group 1"))
					{
						g1++;
						}else if(oblist.get(i2).getVehicleGroup().equals("Group 2")){
							g2++;
						}
						else if(oblist.get(i2).getVehicleGroup().equals("Group 3")){
							g3++;
				}
						else if(oblist.get(i2).getVehicleGroup().equals("Group 4")){
							g4++;
				}
						else if(oblist.get(i2).getVehicleGroup().equals("Group 5")){
							g5++;
				}
						else if(oblist.get(i2).getVehicleGroup().equals("Group 6")){
							g6++;
				}
						else if(oblist.get(i2).getVehicleGroup().equals("Group 7")){
							g7++;
				}
						else if(oblist.get(i2).getVehicleGroup().equals("Group 8")){
							g8++;
				}
						else if(oblist.get(i2).getVehicleGroup().equals("Group 9")){
							g9++;
				}
						else if(oblist.get(i2).getVehicleGroup().equals("Group 10")){
							g10++;
				}
						else if(oblist.get(i2).getVehicleGroup().equals("Group 11")){
							g11++;
				}
				group1Label.setText(String.valueOf(g1));
				group2Label.setText(String.valueOf(g2));
				group3Label.setText(String.valueOf(g3));
				group4label.setText(String.valueOf(g4));
				group5Label.setText(String.valueOf(g5));
				group6Label.setText(String.valueOf(g6));
				group7label.setText(String.valueOf(g7));
				group8label.setText(String.valueOf(g8));
				group9label.setText(String.valueOf(g9));
				group10label.setText(String.valueOf(g10));
				group11label.setText(String.valueOf(g11));				
		    }
			details.addAll(new PieChart.Data("Group1",Integer.parseInt(group1Label.getText())),
					new PieChart.Data("Group2",Integer.parseInt(group2Label.getText())),
					new PieChart.Data("Group3",Integer.parseInt(group3Label.getText())),
					new PieChart.Data("Group4",Integer.parseInt(group4label.getText())),
					new PieChart.Data("Group5",Integer.parseInt(group5Label.getText())),
					new PieChart.Data("Group6",Integer.parseInt(group6Label.getText())),
					new PieChart.Data("Group7",Integer.parseInt(group7label.getText())),
					new PieChart.Data("Group8",Integer.parseInt(group8label.getText())),
					new PieChart.Data("Group9",Integer.parseInt(group9label.getText())),
					new PieChart.Data("Group10",Integer.parseInt(group10label.getText())),
					new PieChart.Data("Group11",Integer.parseInt(group11label.getText())));
			pieChart.setData(details);
		//	pieChart.setLabelsVisible(true);
			//pieChart.setTitle("Contribution Groups");
			pieChart.setLegendSide(Side.BOTTOM);
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
    void showStatistics(MouseEvent event) {
    	pieChart.setVisible(true);
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
