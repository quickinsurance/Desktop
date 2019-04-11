package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entities.Guarantee;
import entities.Sinister;
import entities.Contract.type_contract;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import util.Test;

public class GuaranteeCheckVehicleController implements Initializable{
	
    @FXML
    private Pane pane1;


    @FXML
    private HBox claim1box;
    @FXML
    private TableView<Guarantee> tab;

    @FXML
    private TableColumn<?, ?> Guarantee;

    @FXML
    private TableColumn<?, ?> Limited_Amount;

    @FXML
    private TableColumn<?, ?> Amount_Franchise;
    @FXML
    private TableColumn<Guarantee, String> prime;

    @FXML
    private TextField Contract;

    @FXML
    private TextField user;
    type_contract tc ;
    
	private GuaranteeCheckVehicleContainerController containerParent;
	
    public void setContainer(GuaranteeCheckVehicleContainerController container){
        this.containerParent = container;
    }


    Test t = new Test();
    
    void filterContract(String oldValue, String newValue) throws Exception {
    	Test t = new Test();
    	ObservableList<Guarantee> filteredList = FXCollections.observableArrayList();
        if (Contract.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            ObservableList<Guarantee> oblist=FXCollections.observableArrayList(t.findgurantees());
            tab.setItems(oblist) ;
        } else {

            newValue = newValue.toUpperCase();

            for (Guarantee e : tab.getItems()) {

                String filtertitre= String.valueOf(e.getContract().getClient().getCin());
               String filtre2 = String.valueOf(e.getContract().getClient().getFirstName());
               System.out.println(e.getContract().getClient().getFirstName());


             //  String filtre3 = String.valueOf(e.getContract().getClient().getLastName());
                if (filtertitre.toUpperCase().contains(newValue)||filtre2.toUpperCase().contains(newValue)) {
                    filteredList.add(e);
                    System.out.println(filtre2);
                }
            }
            tab.setItems(filteredList);
        }
}


	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
	
		
		
            try {
            	ObservableList<Sinister> oblist1=FXCollections.observableArrayList(t.findsinisters());
            	Node[] nodes = new Node[10];
                for (int i = 0; i < oblist1.size(); i++) {
                final int j = i;
                FXMLLoader x = new FXMLLoader(getClass().getResource("/views/ClaimboxView.fxml"));
                nodes[i] = x.load();
                ClaimboxController c = x.getController();
                c.setSinister(oblist1.get(i));
           
                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                claim1box.getChildren().add(nodes[i]);
                } } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
        }

    
		

		
		
		
		
		            
		    
		
	


		/*ObservableList<Sinister> oblist1;
		try {
			oblist1 = FXCollections.observableArrayList(t.findsinisters());
			
	
				for (int i=0; i<oblist1.size(); i++){
					name.setText(oblist1.get(i).getReport().getExpert().getFirstName()+oblist1.get(i).getReport().getExpert().getLastName());
				date.setText(oblist1.get(i).getReport().getDate_report().toString());
				System.out.println(oblist1.toString());
				}
				

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
	
			try {
				
				
				ObservableList<Guarantee> oblist=FXCollections.observableArrayList(t.findgurantees());
				for (Guarantee g  : oblist)
					if(g.getContract().getType_contract().toString()!="housing")
					{
						System.out.println("Element "+g.getContract()+"   type  "+g.getAmount_franchise());

						Guarantee.setCellValueFactory(new PropertyValueFactory<>("description"));
						Amount_Franchise.setCellValueFactory(new PropertyValueFactory<>("amount_franchise"));
						Limited_Amount.setCellValueFactory(new PropertyValueFactory<>("amount_limit"));
					
		

		
				
				tab.setItems(oblist);
				for (int i=0; i<oblist.size(); i++){
					System.out.println("Element "+i+oblist.get(i).getAmount_franchise()+"   type  "+oblist.get(i));}
				
	      /*      Image a1 = new Image("http://localhost/image/" + oblist.get(i).getPrime());
	            imageView.setImage(a1);
	            imageView.setFitHeight(120);
	            imageView.setFitWidth(150);
	    
	        
	        setGraphic(imageView);}*/
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		
		
		
		
			Contract.textProperty().addListener((observable, oldValue, newValue) -> {
				
				try {
					filterContract(oldValue, newValue);
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			    System.out.println("textfield changed from " + oldValue + " to " + newValue);
			});}

		




}