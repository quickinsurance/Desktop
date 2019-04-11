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

import entities.Agent;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.interf.IAccidentInterfaceRemote;
import services.interf.UserServiceRemote;
import util.Test;

public class SecondMainController implements Initializable {
    @FXML
    private JFXButton deconnect;
	
    @FXML
    private ImageView logo;
    
	String jndiName = "Insurance-ear/Insurance-ejb/AccidentServiceImplem!services.interf.IAccidentInterfaceRemote";
	
	@FXML
	private VBox sidebar;

	@FXML
	private ImageView agent;

	@FXML
	private VBox vbox2;

	@FXML
	private JFXButton contracts;

	@FXML
	private VBox vbox21;
	@FXML
	private JFXButton vehicleContractBtn;

	@FXML
	private VBox vbox3;

	@FXML
	private JFXButton quot;

	@FXML
	private VBox vbox31;
	
    @FXML
    private Label AgentName;

    @FXML
    private Label AgenceAgenT;

	@FXML
	private JFXButton vehicleQuotationBtn;

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
	private JFXButton retretementContractbtn;

	@FXML
	private VBox vbox6;

	@FXML
	private JFXButton sinisters;

	@FXML
	private VBox vbox61;

	@FXML
	private VBox content_area;

	@FXML
	private HBox menubar;

	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Button scoringBtn;

	@FXML
	private JFXButton housingSinistersBtn;

	@FXML
	private JFXButton ContractHealthBtn;

	@FXML
	private JFXButton VehicleSinisterBtn;
	@FXML
	private JFXButton healthSinisterBtn;
	@FXML
    private JFXButton equipmentContractbtn;
	
	Agent agentConnected;


	@FXML
	private ScrollPane scrollPane;
	Map<VBox, VBox> map = new HashMap<VBox, VBox>();
	boolean flag = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		//logo.setImage(new Image("Users\\asus\\Desktop\\photoshop\\logo.PNG"));
		addMenusToMap();
		vbox2.setPrefHeight(40);
		vbox3.setPrefHeight(40);
		vbox4.setPrefHeight(40);
		vbox5.setPrefHeight(40);
		vbox6.setPrefHeight(40);

		contracts.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				toolsSlider(vbox2, vbox21);
				removeOtherMenus(vbox2);
				vbox2.setPrefHeight(40);
			}

		});
		quot.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				toolsSlider(vbox3, vbox31);
				removeOtherMenus(vbox3);
				vbox3.setPrefHeight(40);
			}

		});
		guarantees.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				toolsSlider(vbox4, vbox41);
				removeOtherMenus(vbox4);
				vbox4.setPrefHeight(40);
			}

		});
		refunds.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				toolsSlider(vbox5, vbox51);
				removeOtherMenus(vbox5);
				vbox5.setPrefHeight(40);
			}

		});
		sinisters.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				toolsSlider(vbox6, vbox61);
				removeOtherMenus(vbox6);
				vbox6.setPrefHeight(40);
			}

		});

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

		map.put(vbox2, vbox21);
		map.put(vbox3, vbox31);
		map.put(vbox4, vbox41);
		map.put(vbox5, vbox51);
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

	/**
	 * Menu slider
	 * 
	 * @param menu
	 * @param subMenu
	 */
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

	@FXML
	void open_sidebar(ActionEvent event) throws IOException {
		BorderPane border_pane = (BorderPane) ((Node) event.getSource()).getScene().getRoot();
		if (flag == true) {
			// Parent sidebar =
			// FXMLLoader.load(getClass().getResource("/views/side.fxml"));
			border_pane.setLeft(sidebar);
			flag = false;
		} else {
			border_pane.setLeft(null);
			flag = true;
		}

	}

	public FXMLLoader setContent(String path, AnchorPane paneAnc) throws IOException {
		// paneAnc.setId("");
		FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		ScrollPane newLoadedPane = loader.load();
		paneAnc.getChildren().clear();
		paneAnc.getChildren().add(newLoadedPane);
		System.out.println(path);
		newLoadedPane.prefWidthProperty().bind(paneAnc.widthProperty());
		newLoadedPane.prefHeightProperty().bind(paneAnc.heightProperty());
		return loader;
	}
	public FXMLLoader setContent1(String path) throws IOException {
		// paneAnc.setId("");
		FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		ScrollPane newLoadedPane = loader.load();
		anchorPane.getChildren().clear();
		anchorPane.getChildren().add(newLoadedPane);
		System.out.println(path);
		newLoadedPane.prefWidthProperty().bind(anchorPane.widthProperty());
		newLoadedPane.prefHeightProperty().bind(anchorPane.heightProperty());
		return loader;
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
	void showVehicleQuotationContentAction(ActionEvent event) throws IOException {
		setContent("/views/VehicleQuotation.fxml", anchorPane);
	}

	@FXML
	void showVehicleContractAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/VehicleDisplaysView.fxml", anchorPane);
	}

	@FXML
	void showScoringAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/ScoringClient.fxml", anchorPane);
	}

	@FXML
	void showHousingSinistersAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/HousingAgentContainerView.fxml", anchorPane);
	}

	@FXML
	void showContractHealthAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/ManageContractsHealthContainerView.fxml", anchorPane);
	}

	@FXML
	void showVehcileSinisterAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/VehicleSinisterContainerView.fxml", anchorPane);
	}

	@FXML
	void showHealthSinisterAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/ManageFileContainerView.fxml", anchorPane);

	}

	@FXML
	void showRetreatContractAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/RetreatManageContainerView.fxml", anchorPane);
	}
	
    
    @FXML
    void showEquipmentContractAction(ActionEvent event) throws IOException {
		setContentAnchor("/views/EquipmentContractContainerView.fxml", anchorPane);

    }
    
    @FXML
    void QuotationEquipmentView(ActionEvent event) throws IOException {
    	setContentAnchor("/views/EquipmentQuotContainer.fxml", anchorPane);
    }
    @FXML
    void ConsultClaims(ActionEvent event) throws IOException {
    	setContentAnchor("/views/ClaimsContainer.fxml", anchorPane);

    }
    
    @FXML
    void ShowEquipmentSinister(ActionEvent event) throws IOException {
    	setContentAnchor("/views/SinisterEquipmentContainer.fxml", anchorPane);

    }
    
    
    @FXML
    void showHousingGuarantee(ActionEvent event) throws Exception {
    	Test t = new Test();
    	t.addGuaranteeif();
    	t.addoptionif();
    	setContentAnchor("/views/GuaranteeCheckHousingContainerView.fxml", anchorPane);

    }
    
    @FXML
    void showContractsHousing(ActionEvent event) throws IOException {
    	setContentAnchor("/views/ContractHousingContainerView.fxml", anchorPane);

    }

	

	public void setIdUser(int id) throws NamingException {
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote)context.lookup(jndiName);
		
		agentConnected=proxy.findAgentById(id);
		AgentName.setText(agentConnected.getFirstName()+" "+agentConnected.getLastName());
		
		AgenceAgenT.setText(agentConnected.getAgence());
		Image image = new Image("file:"+agentConnected.getPhoto());
		agent.setImage(image);
		
				
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
