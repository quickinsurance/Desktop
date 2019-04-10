package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Guarantee;
import entities.Sinister;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import tn.esprit.Test;

public class GuaranteeclaimController implements Initializable{


	
	@FXML
    private Button refund;
	
    @FXML
    private TableView<Guarantee> tab;
    @FXML
    private TextFlow description1;
    

    @FXML
    private TableColumn<?, ?> Guarantee;

    @FXML
    private TableColumn<?, ?> franchise;

    @FXML
    private TableColumn<?, ?> LimitedAmount;
    @FXML
    private Label date;

    @FXML
    private Label name;

    @FXML
    private Label description;
    @FXML
    private Label adate;

    @FXML
    private Label sdate;
    @FXML
    private Label Relatedgua1;

    @FXML
    private Label Relatedgua;

    @FXML
    private Label refund2;

    @FXML
    private Label refund1;

    @FXML
    private Button showgua;

    @FXML
    private Label listg;

    @FXML
    private Button calcule;
 private  Sinister s;
 
 public void  setSinister(Sinister s) throws Exception{
	 
	 this.s=s;
		Test t = new Test();
		System.out.println(s.getSinister_id()+"aaaa");
		date.setText(s.getReport().getDate_report().toString());
	name.setText(s.getReport().getAccident().getExpert_opinion());
		description.setText(s.getDescription());
		Relatedgua.setText(t.findguranteebyContract(s.getReport().getAccident().getHousing().getContract_id()).get(0).getDescription());
		refund1.setText(String.valueOf(t.findguranteebyContract(s.getReport().getAccident().getHousing().getContract_id()).get(0).getRefund()));
		if (s.getRefund()==0){
			tab.setVisible(false);
			listg.setVisible(false);
			Relatedgua1.setVisible(true);
			Relatedgua.setVisible(true);
			refund2.setVisible(true);
			refund1.setVisible(true);
			showgua.setVisible(true);
		}

			
			ObservableList<Guarantee> oblist;
			try {
				oblist = FXCollections.observableArrayList(t.findguranteebyContract(s.getReport().getAccident().getHousing().getContract_id()));
				for (Guarantee g:oblist){
		
					
				Guarantee.setCellValueFactory(new PropertyValueFactory<>("description"));
				franchise.setCellValueFactory(new PropertyValueFactory<>("amount_franchise"));
				LimitedAmount.setCellValueFactory(new PropertyValueFactory<>("amount_limit"));
				tab.setItems(oblist);
				 
		}
				
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
 }
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	

		

		    

			
		
		
		
		
	}
	
    @FXML
    void calculerrefund(ActionEvent event) {
    	
    	
    	

    }
    @FXML
    void update(MouseEvent event) throws Exception {
    	Test t = new Test();
    Guarantee gu =	tab.getSelectionModel().getSelectedItem();
    gu.setSinister(s);
    gu.setRefund(1500);
    t.updateGrantie(gu);

    }
    

    @FXML
    void showdiscrption(ActionEvent event) {
    	
String s1="A basic policy that protects against all 11 perils the HO-1 covers as well as others. Additional perils covered by an HO-2 policy include: damage from falling objects; and water damage from accidental overflow of plumbing, heating air-conditioning and household appliances. Like the HO-1, the HO-2 is a named peril policy and only the perils specifically listed are covered - no others. The HO-2 also covers personal property in the home.";
String s2="The HO-3 is the most common policy form because of its broad range of coverage. It is an extended or special homeowners insurance policy form that protects against all 16 of the most common perils and almost any other peril, except those specifically excluded (such as earthquake, flood, landslide or mudslide, nuclear accident and sinkholes). However, HO-3 policies only cover personal belongings in the home against the same perils covered by an HO-2 policy form.";

String s3="The HO-5 policy form is identical to an HO-3, only with a twist. Like an HO-3, the HO-5 covers all 16 perils plus any peril that is not specifically listed as an exclusion. Unlike the HO-3, the HO-5 is more comprehensive and covers personal property from almost every peril, unless the item is explicitly excluded. The depth of the coverage makes this policy cost more than others.";
String s4="An HO-8 policy form is designed for older homes that have a replacement cost that exceeds the actual cash value of the home. For that reason, the HO-8 policy form is frequently used to insure registered landmarks and architecturally significant structures.";
    	
    	if (s.getReport().getAccident().getHousing().getGuarantee().equals("HO-1")){
    		
    		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	        alert.setTitle("Guarantee details");
    	        alert.setHeaderText("Type HO-2");
    	        alert.setContentText(s1);
    	        alert.showAndWait();
    		
    	}else if(s.getReport().getAccident().getHousing().getGuarantee().equals("HO-3")) {
    		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	        alert.setTitle("Guarantee details");
    	        alert.setHeaderText("Type HO-3");
    	        alert.setContentText(s2);
    	        alert.showAndWait();
    	
    	}else if (s.getReport().getAccident().getHousing().getGuarantee().equals("HO-5")){
    	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guarantee details");
            alert.setHeaderText("Type HO-5");
            alert.setContentText(s3);
            alert.showAndWait();
    		
    	}else if (s.getReport().getAccident().getHousing().getGuarantee().equals("HO-8"))
    	{  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guarantee details");
        alert.setHeaderText("Type HO-8");
        alert.setContentText(s4);
        alert.showAndWait();
    		
    	}
   
    }

	
	
	
	
}
