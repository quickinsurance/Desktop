package controllers;


import java.net.URL;
import java.util.ResourceBundle;

import entities.Health;
import entities.MedicalFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MedicalFileImageController implements Initializable {
	Health m ;
    @FXML
    private ImageView imageMedicaleFile;

    @FXML
    private Button returnbtn;
    
	private ManageHealthContractsContainerController containerParent;
	
    public void setContainer(ManageHealthContractsContainerController container){
        this.containerParent = container;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void setMedicaleFil(MedicalFile selectedMedicalfile) {
		Image image = new Image(selectedMedicalfile.getImage());
		imageMedicaleFile.setImage(image);
		returnbtn.setText("Return to Medical Files list ");
		m=selectedMedicalfile.getHealth();
		
	}

    @FXML
    void retour(MouseEvent event) {
    	/*try {
    		Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/consultMedicalFile.fxml"));
			Parent root1 = (Parent) loader.load();
			primaryStage.setTitle("Medicals Files");
			Scene scene = new Scene(root1);
			scene.getStylesheets().add("/css/application.css");
			primaryStage.setScene(scene);
			MedicalFileController mainController = loader.<MedicalFileController>getController();
			mainController.setHealth(m);
			Stage stage = (Stage) returnbtn.getScene().getWindow();
			stage.close();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
        FXMLLoader loader = containerParent.switchViewTo("/views/consultMedicalFile.fxml");
        ((MedicalFileController) loader.getController()).setContainer(containerParent);
    }

}
