package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Agent;
import entities.Retreat;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import services.interf.IRetreatInterfaceRemote;

public class RetreatContractManageController implements Initializable {
	
	
	 @FXML
	    private Button addContract;

	    @FXML
	    private Button listRecission;

	    @FXML
	    private TableView<Retreat> tableHealth;

	    @FXML
	    private TableColumn<Retreat, String> idContract1;

	    @FXML
	    private TableColumn<Retreat, String> clientHealth1;

	    @FXML
	    private TableColumn<Retreat, String> optionHealth1;

	    @FXML
	    private TableColumn<Retreat, String> primeHealth;
	    RetreatManageContainerController containerParent;
	    
	    public void setContainer(RetreatManageContainerController retreatManageContainerController) {
	    	   this.containerParent = retreatManageContainerController;
			
		}


	  
	    @FXML
	    void addContractAction(ActionEvent event) {
	    	
	    	
	    	 FXMLLoader loader = containerParent.switchViewTo("/views/AddRetreatContractView.fxml");
		    ((AddRetreatContractController) loader.getController()).setContainer(containerParent);


	    }

	    @FXML
	    void getContract(MouseEvent event) {
	    	// FXMLLoader loader = containerParent.switchViewTo("/views/VehicleAccidentManege.fxml");
		     //   ((VehicleAccideentMAnageController) loader.getController()).setContainer(containerParent);

	    }

	    @FXML
	    void getListRecission(ActionEvent event) {

	    	 FXMLLoader loader = containerParent.switchViewTo("/views/RessionRetreatView.fxml");
			    ((RessionRetreatController) loader.getController()).setContainer(containerParent);


	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			String jndiName = "Insurance-ear/Insurance-ejb/RetreatServiceImplem!services.interf.IRetreatInterfaceRemote";
			Context context;
			try {
				context = new InitialContext();

				IRetreatInterfaceRemote proxy = (IRetreatInterfaceRemote) context.lookup(jndiName);
				Agent agent = new Agent();
				agent.setId(13);
				List<Retreat> retreats = proxy.listRetreatByagent(agent);

				ObservableList<Retreat> listm = FXCollections.observableArrayList();

				listm.addAll(retreats);
				

				idContract1.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getContract_id()+""));
				clientHealth1.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue()
						.getClient().getFirstName()+" "+cellData.getValue().getClient().getLastName()));
				optionHealth1.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRetreatDate().toString()));
				primeHealth.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getPrime()+""));

				tableHealth.setItems(listm);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		

}
