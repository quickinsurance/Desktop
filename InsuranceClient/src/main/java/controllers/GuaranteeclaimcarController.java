package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import entities.Guarantee;
import entities.Sinister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import tn.esprit.Test;

public class GuaranteeclaimcarController {
	@FXML
    private Button refund;
    @FXML
    private ImageView moneyimg;
    @FXML
    private JFXTextField expertestim;
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
		adate.setText(s.getReport().getAccident().getDate_of_Accident().toString());
	name.setText(s.getReport().getAccident().getExpert_opinion());
		description.setText(s.getDescription());
		Relatedgua.setText(t.findguranteebyContract(s.getReport().getAccident().getVehicle().getContract_id()).get(0).getDescription());
		refund1.setText(String.valueOf(t.findguranteebyContract(s.getReport().getAccident().getVehicle().getContract_id()).get(0).getRefund()));
		if (t.findguranteebyContract(s.getReport().getAccident().getVehicle().getContract_id()).get(0).getRefund()!=0){
			tab.setVisible(false);
			listg.setVisible(false);
			
			expertestim.setVisible(false);
			   moneyimg.setVisible(false);
		
			
			
			Relatedgua1.setVisible(true);
			Relatedgua.setVisible(true);
			refund2.setVisible(true);
			refund1.setVisible(true);
			showgua.setVisible(true);
		}

			
			ObservableList<Guarantee> oblist;
			try {
				oblist = FXCollections.observableArrayList(t.findguranteebyContract(s.getReport().getAccident().getVehicle().getContract_id()));
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
    
    

	
    @FXML
    void calculerrefund(ActionEvent event) {

    }
    @FXML
    void update(MouseEvent event) throws Exception {
    	Test t = new Test();
    Guarantee gu =	tab.getSelectionModel().getSelectedItem();
    gu.setSinister(s);
    
    float fren = gu.getAmount_franchise();
    float limit = gu.getAmount_limit();
    float expertvalue=0;
     expertvalue =Integer.parseInt(expertestim.getText());
    float expertvalue1 = 50000;
   String gua= s.getReport().getAccident().getVehicle().getVehicleOption();

   String gr= s.getReport().getAccident().getVehicle().getVehicleGroup();

    
    if (gr!=""||gr!=""){
    	
    	
    if (gua.equals("All Risks")){
    	
    	if (expertvalue>limit){
    		 gu.setRefund(limit);
  	}else {
  		 gu.setRefund(expertvalue);
  	}
       
    	
    }else if (gua.equals("Tiers Etendu")){
    	
    	float refu =expertvalue-fren;
    	
    	if (refu>limit){
    		  gu.setRefund(limit-fren);
    	}else {
    		gu.setRefund(refu);
    	}
    	
    }else{
    	float refu =expertvalue;

    	if (refu>limit){
    		  gu.setRefund((limit-fren)*0.9f);
    	}else {
    		gu.setRefund(refu-fren);
    	}
    	
    }
    
    
    }
else {
    	
        if (gua.equals("All Risks")){
        	
        	if (expertvalue>limit){
        		 gu.setRefund(limit*0.9f);
      	}else {
      		 gu.setRefund(expertvalue*0.9f);
      	}
           
        	
        }else if (gua.equals("Tiers Etendu")){
        	
        	float refu =expertvalue-fren;
        	
        	if (refu>limit){
        		  gu.setRefund(limit-fren);
        	}else {
        		gu.setRefund(refu);
        	}
        	
        }else{
        	float refu =expertvalue;

        	if (refu>limit){
        		  gu.setRefund((limit-fren)*0.7f);
        	}else {
        		gu.setRefund(refu-fren);
        	}
    }
    
    }
    
    
   
 
   
  
    
  
    t.updateGrantie(gu);
    
    
    
    
	  FXMLLoader loader=new FXMLLoader(getClass().getResource("/views/Guaranteeclaimcarview.fxml"));
	  System.out.println(s.getSinister_id());
	  Parent root = (Parent) loader.load();
	  GuaranteeclaimController cd = loader.getController();
	  cd.setSinister(s);

	  Stage stage=new Stage();
	  stage.setScene(new Scene(root));
	  stage.show();

    }
    

    @FXML
    void showdiscrption(ActionEvent event) {
    	
String s1="policy offers you coverage and protection from all risks or perils that could damage your home or contents and personal property unless the risks are excluded specifically in the policy wording";
String s2="The tier system used by today's car insurance carriers is a new way of providing more accurate risk assessment data. ... A single accident would increase your car insurance costs by a significant amount.";
String s3="same as tier but with more detailed and more options in case of sinister";    	
    	if (s.getReport().getAccident().getVehicle().getVehicleOption().equals("All Risks")){
    		
    		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	        alert.setTitle("Guarantee details");
    	        alert.setHeaderText("Type All Risks");
    	        alert.setContentText(s1);
    	        alert.showAndWait();
    		
    	}else if(s.getReport().getAccident().getHousing().getGuarantee().equals("Tiers Etendu")) {
    		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	        alert.setTitle("Guarantee details");
    	        alert.setHeaderText("Type extended tier");
    	        alert.setContentText(s3);
    	        alert.showAndWait();
    	
    	}else {
    	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guarantee details");
            alert.setHeaderText("Type tier");
            alert.setContentText(s2);
            alert.showAndWait();
    		
    	}
   
    }

	
}
