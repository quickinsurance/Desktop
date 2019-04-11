package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;

import entities.User;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.interf.UserServiceRemote;

public class ExpertMainController implements Initializable {

    @FXML
    private JFXButton deconnect;
   
	@FXML
	private VBox sidebar;

	@FXML
	private ImageView agent;

	@FXML
	private VBox vbox6;

	@FXML
	private JFXButton sinisters;

	@FXML
	private VBox vbox61;

	@FXML
	private JFXButton VehicleSinisterBtn;

	@FXML
	private JFXButton housingSinistersBtn;

	@FXML
	private VBox content_area;

	@FXML
	private HBox menubar;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private ScrollPane scrollPane;

	Map<VBox, VBox> map = new HashMap<VBox, VBox>();

	@FXML
	private Label expertName;
	
	User userConnected;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		addMenusToMap();

		vbox6.setPrefHeight(40);
		sinisters.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				toolsSlider(vbox6, vbox61);
				removeOtherMenus(vbox6);
				vbox6.setPrefHeight(40);
			}

		});

	}

	@FXML
	void open_sidebar(ActionEvent event) {
		// TODO Auto-generated method stub
		addMenusToMap();

		vbox6.setPrefHeight(40);

		sinisters.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				toolsSlider(vbox6, vbox61);
				removeOtherMenus(vbox6);
				vbox6.setPrefHeight(40);
			}

		});

	}

	public void toolsSlider(VBox menu, VBox subMenu) {
		toolsSliderImpl(menu, subMenu);
	}

	public void removeOtherMenus(VBox menu) {
		removeOtherMenusImpl(menu);
	}

	private void removeOtherMenusImpl(VBox menu) {
		for (Map.Entry<VBox, VBox> entry : map.entrySet()) {
			if (!entry.getKey().equals(menu))
				entry.getKey().getChildren().remove(entry.getValue());
		}
	}

	private void toolsSliderImpl(VBox menu, VBox subMenu) {
		if (menu.getChildren().contains(subMenu)) {
			final FadeTransition transition = new FadeTransition(Duration.millis(500), menu);
			transition.setFromValue(0.5);
			transition.setToValue(1);
			transition.setInterpolator(Interpolator.EASE_IN);
			menu.getChildren().remove(subMenu);
			transition.play();
		} else {
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

		map.put(vbox6, vbox61);
		// map.put(secondSubVBox, secondSubMenuList);
		// map.put(thirdSubVBox,thirdSubMenuList);
		// map.put(fourthSubVBox, fourthSubMenuList);
		// map.put(fifthSubVBox, fifthSubMenuList);

		/**
		 * Remove the components from VBox on load of stage
		 */
		for (Map.Entry<VBox, VBox> entry : map.entrySet()) {
			entry.getKey().getChildren().remove(entry.getValue());
		}
	}

	public FXMLLoader setContentAnchor(String path, AnchorPane paneAnc) throws IOException {
		// paneAnc.setId("");
		FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		AnchorPane newLoadedPane = loader.load();
		paneAnc.getChildren().clear();
		paneAnc.getChildren().add(newLoadedPane);
		System.out.println(path);
		newLoadedPane.prefWidthProperty().bind(paneAnc.widthProperty());
		newLoadedPane.prefHeightProperty().bind(paneAnc.heightProperty());
		return loader;
	}

	@FXML
	void showHousingSinistersAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/HousingExpertManageContainerView.fxml", anchorPane);

	}

	@FXML
	void showVehcileSinisterAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/ExpertManageVehicleContainerView.fxml", anchorPane);

	}

	public void setIdUser(int id) throws NamingException {
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);

		userConnected = proxy.findUserById(id);
		expertName.setText(userConnected.getFirstName() + " " + userConnected.getLastName());

	}
	 @FXML
	    void deconnexion(ActionEvent event) throws IOException {
	    	Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
			Parent root1 = (Parent) loader.load();
			Scene scene = new Scene(root1);
			primaryStage.setScene(scene);
			Stage stage = (Stage) deconnect.getScene().getWindow();
			stage.close();
			primaryStage.show();
	    }
}
