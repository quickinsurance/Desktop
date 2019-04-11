package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entities.Contract;
import entities.Housing;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.SwitchScreen;
import tn.esprit.Test;

public class ContracthousingController implements Initializable{

	
    @FXML
    private AnchorPane pane2;

    @FXML
    private Button add;

    @FXML
    private TableColumn<Housing,String> prime1;
    @FXML
    private TableColumn<Housing,String> Area1;
    
    
    @FXML
    private Pane pnlCustomer;
    @FXML
    
    private TextField textfieldchercher;
    
    @FXML
    private Label total;

    @FXML
    private Label refusedcontra;

    @FXML
    private Label AcceptedContra;

    @FXML
    private Label onhold;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox pnItems;

    @FXML
    private TableView<Housing> tab;

    @FXML
    private TableColumn<?, ?> status;
    
    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> type;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<Housing, String> Area;
    
public Housing house ;
    @FXML
    private Button go;
    private ContractHousingContainerController containerParent;
    


    void filterContract(String oldValue, String newValue) throws Exception {
    	Test t = new Test();
    	ObservableList<Housing> filteredList = FXCollections.observableArrayList();
        if (textfieldchercher.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            ObservableList<Housing> oblist=FXCollections.observableArrayList(t.findContractsHousing());
            tab.setItems(oblist) ;
        } else {

            newValue = newValue.toUpperCase();

            for (Housing e : tab.getItems()) {

                String filtertitre= e.getEtatdemande().toString();
                String filtre2 = e.getDate_creation().toString();

                if (filtertitre.toUpperCase().contains(newValue)||filtre2.toUpperCase().contains(newValue)) {
                    filteredList.add(e);
                }
            }
            tab.setItems(filteredList);
        }
    }
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pane2.setVisible(false);
		
       /* Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("ClaimboxView.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
		
		
		
		
		
		
		
		
		
		
		Test t = new Test();
		try {
			
			
			ObservableList<Housing> oblist=FXCollections.observableArrayList(t.findContractsHousing());
		String link ;
		
		status.setCellValueFactory(new PropertyValueFactory<>("etatdemande"));
			date.setCellValueFactory(new PropertyValueFactory<>("Date_creation"));
			name.setCellValueFactory(new PropertyValueFactory<>("type_housing"));
			Area.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getClient().getFirstName()+
					cellData.getValue().getClient().getFirstName()));
			type.setCellValueFactory(new PropertyValueFactory<>("guarantee"));
			prime1.setCellValueFactory(cellData->new SimpleStringProperty(String.valueOf(cellData.getValue().getPrime())));
			Area1.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getArea()));
					link=status.getText();
			System.out.println(oblist.size());
			
			
			tab.setItems(oblist);
			for (int i=0; i<oblist.size(); i++){
				System.out.println("Element "+i+oblist.get(i)+"   type  "+oblist.get(i));}
			
      /*      Image a1 = new Image("http://localhost/image/" + oblist.get(i).getPrime());
            imageView.setImage(a1);
            imageView.setFitHeight(120);
            imageView.setFitWidth(150);
    
        
        setGraphic(imageView);}*/
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		try {
			
			ObservableList<Housing> oblist=FXCollections.observableArrayList(t.findContractsHousing());
			int a =0;
			int b =0;
			int c=0;
			int to=0;
			int oo=0;
			for (int i=0; i<oblist.size(); i++){
			
			if (oblist.get(i).getEtatdemande().equals("on hold"))
				{
					a++;
					}else if(oblist.get(i).getEtatdemande().equals("Accepted")){
						b++;
						
					}else if(oblist.get(i).getEtatdemande().equals("resiliated")){
						oo++;
						
					}
					else{
						c++;
					}
			
			
			if(oblist.get(i).getEtatdemande().equals("Refused")||oblist.get(i).getEtatdemande().equals("Accepted")){
				to++;
			}
				}  



			    onhold.setText(String.valueOf(a));
			    AcceptedContra.setText(String.valueOf(b));
			    refusedcontra.setText(String.valueOf(c));
			    total.setText(String.valueOf(oblist.size()));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		textfieldchercher.textProperty().addListener((observable, oldValue, newValue) -> {
			
			try {
				filterContract(oldValue, newValue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("textfield changed from " + oldValue + " to " + newValue);
		});

	}
	
    @FXML
    void go(ActionEvent event) throws Exception {
SwitchScreen ss = new SwitchScreen();

Test t = new Test();
t.addGuaranteeif();
t.addoptionif();
    	ss.switchScreen("/views/GuaranteeCheckVehicleView.fxml", go);
//ss.switchScreen("/views/GuaranteeCheckHousingView.fxml", go);
    }


    @FXML
    void AddContract(ActionEvent event) throws IOException {
SwitchScreen ss = new SwitchScreen();
    	
    	//ss.switchScreen("HousingGuranteeview.fxml", go);
//ss.switchScreen("/views/AddUserforHousingView.fxml", add);

FXMLLoader loader = containerParent.switchViewTo("/views/AddUserforHousingView.fxml");
((AddUserforHousingController) loader.getController()).setContainer(containerParent);

    }
    
    
    


    @FXML
    void onMouseClick(MouseEvent event) throws Exception {
    	Test t = new Test();
    	
        
       Contract c1 = (Contract) tab.getSelectionModel().getSelectedItem();
   int     id = c1.getContract_id();
  Housing h1= t.ServicefindContracthouse(id);
  System.out.println(h1.getCodePostal());
  //pane2.setVisible(true);
  //AnchorPane pane = FXMLLoader.load(getClass()
    //      .getResource("Contractdetail.fxml"));
  //pane2.getChildren().setAll(pane);
  
  int id1=h1.getContract_id();
  System.out.println(id1+"aa");

  FXMLLoader loader=new FXMLLoader(getClass().getResource("/views/ContractHousingDetailView.fxml"));
 
  Parent root = (Parent) loader.load();
  ContractdetailController cd = loader.getController();
  cd.setid(id1);
  System.out.println(id1+"bb");

  
  Stage stage=new Stage();
  stage.setScene(new Scene(root));
  stage.show();
cd.startstage();



    }
    
    
    
  
	public int gethouse() {
		System.out.println(house.getContract_id());
		return house.getContract_id();
		

	}

	ContractHousingContainerController parentContainer;

	public void setContainer(ContractHousingContainerController contractHousingContainerController) {
		this.parentContainer=contractHousingContainerController;
		
	}

}