/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author amalg
 */
public class SideController implements Initializable {

    @FXML
    private VBox sidebar;
    @FXML
    private VBox vbox2;
    @FXML
    private JFXButton contracts;
    @FXML
    private VBox vbox21;
    @FXML
    private VBox vbox3;
    @FXML
    private JFXButton quot;
    @FXML
    private VBox vbox31;
    @FXML
    private VBox vbox4;
    @FXML
    private JFXButton guarantees;
    @FXML
    private VBox vbox41;
    @FXML
    private VBox vbox5;
    @FXML
    private JFXButton refunds;
    @FXML
    private VBox vbox51;
    @FXML
    private VBox vbox6;
    @FXML
    private JFXButton sinisters;
    @FXML
    private JFXButton vehicleQuotationBtn;
    @FXML
    private VBox vbox61;
 Map<VBox,VBox> map = new HashMap<VBox,VBox>();
 
 	public String s;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        	addMenusToMap();
                        vbox2.setPrefHeight(40);
                        vbox3.setPrefHeight(40);
                        vbox4.setPrefHeight(40);
                        vbox5.setPrefHeight(40);
                        vbox6.setPrefHeight(40);


                        contracts.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(vbox2,vbox21);
	        	 removeOtherMenus(vbox2);
                         vbox2.setPrefHeight(40);
	         }
			
	     });
                           quot.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(vbox3,vbox31);
	        	 removeOtherMenus(vbox3);
                         vbox3.setPrefHeight(40);
	         }
			
	     });
                              guarantees.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(vbox4,vbox41);
	        	 removeOtherMenus(vbox4);
                         vbox4.setPrefHeight(40);
	         }
			
	     });
                                 refunds.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(vbox5,vbox51);
	        	 removeOtherMenus(vbox5);
                         vbox5.setPrefHeight(40);
	         }
			
	     });
                                sinisters.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(vbox6,vbox61);
	        	 removeOtherMenus(vbox6);
                         vbox6.setPrefHeight(40);
	         }
			
	     });
    }    
     private void toolsSliderImpl(VBox menu,VBox subMenu) {
		   if(menu.getChildren().contains(subMenu)){
	    	   final FadeTransition transition = new FadeTransition(Duration.millis(500), menu);
       	    transition.setFromValue(0.5);
       	    transition.setToValue(1);
       	    transition.setInterpolator(Interpolator.EASE_IN);
       	 menu.getChildren().remove(subMenu);
       	    transition.play();
	       }else{
	    	   final FadeTransition transition = new FadeTransition(Duration.millis(500), menu);
       	    transition.setFromValue(0.5);
       	    transition.setToValue(1);
       	    transition.setInterpolator(Interpolator.EASE_IN);
       	 menu.getChildren().add(subMenu);
       	    transition.play();
	       }
	}
    public void addMenusToMap() {
		addMenusToMapImpl();
	}

	private void addMenusToMapImpl() {
		
		map.put(vbox2,vbox21);
                map.put(vbox3,vbox31);
                map.put(vbox4,vbox41);
                map.put(vbox5,vbox51);
                map.put(vbox6,vbox61);
	//	map.put(secondSubVBox, secondSubMenuList);
	//	map.put(thirdSubVBox,thirdSubMenuList);
	//	map.put(fourthSubVBox, fourthSubMenuList);
	//	map.put(fifthSubVBox, fifthSubMenuList);

		/**
		 * Remove the components from VBox on load of stage
		 */
		for (Map.Entry<VBox,VBox> entry : map.entrySet()) {
			entry.getKey().getChildren().remove(entry.getValue());
		}		
	}
/**
 * Menu slider
 * @param menu
 * @param subMenu
 */
	public void toolsSlider(VBox menu,VBox subMenu){
		toolsSliderImpl(menu,subMenu);
	}
        public void removeOtherMenus(VBox menu){
		removeOtherMenusImpl(menu);
	}
	private void removeOtherMenusImpl(VBox menu) {
		for (Map.Entry<VBox,VBox> entry : map.entrySet()) {
			if(!entry.getKey().equals(menu))
				entry.getKey().getChildren().remove(entry.getValue());
		}	
	}
	


    @FXML
    void showVehicleQuotationContentAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ContentArea.fxml"));
		//Parent showContract = loader.load();
		Parent pane = loader.load();
		((ContentAreaController)loader.getController()).setContent("/views/DisplayQuotationsView.fxml");

	/*	ContentAreaController controller = loader.<ContentAreaController>getController();
		controller.setContent("/views/DisplayQuotationsView.fxml");   */
		
    }
	
}
