package controllers;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
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
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ContentAreaController implements Initializable {


    @FXML
    private HBox menubar;

    @FXML
    private Button showBtn;

    /**
     * Initializes the controller class.
     */
    boolean flag = true;

 Map<VBox,VBox> map = new HashMap<VBox,VBox>();
 

 @FXML
 private AnchorPane paneAnc;


 public String sa;
 
 
 	 public String getText(String s){
 		 return this.sa=s;
 	 }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addMenusToMap();
                }
    @FXML

    private void open_sidebar(ActionEvent event) throws IOException {
        BorderPane border_pane = (BorderPane) ((Node) event.getSource()).getScene().getRoot();
        if (flag == true) {
            Parent sidebar = FXMLLoader.load(getClass().getResource("/views/side.fxml"));
            border_pane.setLeft(sidebar);
            flag = false;
        } else {
            border_pane.setLeft(null);
            flag = true;
        }

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
    public FXMLLoader setContent(String path) throws IOException{
    		//paneAnc.setId("");
    		FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        	System.out.println(path+1);
            AnchorPane newLoadedPane =  loader.load();
        	System.out.println(path+2);
            paneAnc.getChildren().clear();
        	System.out.println(path+3);

            paneAnc.getChildren().add(newLoadedPane);
        	System.out.println(path);

            newLoadedPane.prefWidthProperty().bind(paneAnc.widthProperty());
            newLoadedPane.prefHeightProperty().bind(paneAnc.heightProperty());
			return loader;
            
            
           /* newLoadedPane.prefWidthProperty().bind(paneAnc.widthProperty());
            newLoadedPane.prefHeightProperty().bind(paneAnc.heightProperty());*/
            
    }
  /*  public FXMLLoader setMainContent(String path) throws IOException{
        return setContent(path);
    }*/
    

    @FXML
    void showContentAction(ActionEvent event) throws IOException {

       /* FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/DisplayQuotationsView.fxml"));
        AnchorPane newLoadedPane =  loader.load();
        paneAnc.getChildren().clear();
        paneAnc.getChildren().add(newLoadedPane);*/
    	
    }
    
    
    
}
