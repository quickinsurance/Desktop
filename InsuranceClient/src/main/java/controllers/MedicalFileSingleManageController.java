package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.MedicalFile;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.interf.IMedicalFileRemote;

public class MedicalFileSingleManageController implements Initializable {
	@FXML
	private ImageView imageMedicalFile;
	@FXML
	private Button btnAccepte;
	@FXML
	private Button BntRefuse;
	@FXML
	private Button btnCancel;

	@FXML
	private HBox hboxdrugs;

	@FXML
	private ChoiceBox<String> typemédicalFile;

	@FXML
	private ComboBox<String> medicament;

	@FXML
	private Label lblMedicament;
	String errorMessage;

	private float refund, refund2 = 0f;
	MedicalFile medicalFile;
	String jndiName = "Insurance-ear/Insurance-ejb/MedicalFileImplem!services.interf.IMedicalFileRemote";
	Context context;
	IMedicalFileRemote proxy;
	String medica;

	private ManageFileContainerController containerParent;

	public void setContainer(ManageFileContainerController manageFileContainerController) {
		this.containerParent = manageFileContainerController;

	}

	public void setMedicalFil(MedicalFile selectedMedicalfile) {
		Image image = new Image(selectedMedicalfile.getImage());
		imageMedicalFile.setImage(image);
		medicalFile = selectedMedicalfile;

	}

	// Event Listener on Button[#btnAccepte].onAction
	@FXML
	public void AccepteAction(ActionEvent event) {
		errorMessage = "";
		if (typemédicalFile.getValue() == null || typemédicalFile.getValue().length() == 0) {
			errorMessage += "Choose the type of Medical File Please : ! \n";

		} else if (typemédicalFile.getValue().equals("Pharmaceuticals")) {

			if (medicament.getValue() == null || medicament.getValue().length() == 0)
				errorMessage += "Choose the type of drugs  Please : ! \n";
		}

		if (errorMessage.length() == 0) {

			medicalFile.setType(typemédicalFile.getValue());
			String options = medicalFile.getHealth().getOptions();

			String formula = medicalFile.getHealth().getFormulas();
			String type = medicalFile.getType();
			float bill = medicalFile.getBill();
			System.out.println(options);
			System.out.println(options.contains(type));

			System.out.println(formula);
			if (options.contains(type)) {
				if (formula.contains("budget formula")) {
					if (type.equals("Consultations or visits")) {
						refund = bill * 60 / 100;
					}
					if (type.equals("Pharmaceuticals")) {

						medica = medicament.getValue();
						if (medica.equals("irreplaceable drugs"))

							refund2 = bill * 100 / 100;
						else if (medica.equals("important drugs"))
							refund2 = bill * 65 / 100;
						else if (medica.equals("medical service moderate"))
							refund2 = bill * 30 / 100;
						else if (medica.equals("low medical service drugs"))
							refund2 = bill * 15 / 100;
						else if (medicament.getValue() == null || medicament.getValue().length() == 0) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setTitle("Invalid fields");
							alert.setHeaderText("Please fill in the fields");
							alert.setContentText("add Type drugs ");
							alert.showAndWait();
						}

						refund = refund2 * 90 / 100;

					}
					if (type.equals("Medical analysis")) {

						refund = bill * 80 / 100;

					}
					if (type.equals("Radiology")) {

						refund = bill * 80 / 100;

					}
					if (type.equals("Optical")) {

						refund = bill * 50 / 100;

					}
					if (type.equals("Dental care")) {

						refund = bill * 60 / 100;

					}
					if (type.equals("Surgery")) {

						refund = bill * 70 / 100;

					}

					System.out.println(refund + "");
				} else if (formula.contains("comfort formula"))

				{

					if (type.equals("Consultations or visits")) {

						refund = bill * 70 / 100;

					}
					if (type.equals("Pharmaceuticals")) {
						medica = medicament.getValue();

						if (medica.equals("irreplaceable drugs"))

							refund2 = bill * 100 / 100;
						else if (medica.equals("important drugs"))
							refund2 = bill * 65 / 100;
						else if (medica.equals("medical service moderate"))
							refund2 = bill * 30 / 100;
						else if (medica.equals("low medical service drugs"))
							refund2 = bill * 15 / 100;
						else if (medica == null || medica.length() == 0) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setTitle("Invalid fields");
							alert.setHeaderText("Please fill in the fields");
							alert.setContentText("add Type drugs ");
							alert.showAndWait();
						}

						refund = refund2 * 100 / 100;

					}
					if (type.equals("Medical analysis")) {

						refund = bill * 100 / 100;

					}
					if (type.equals("Radiology")) {

						refund = bill * 100 / 100;

					}
					if (type.equals("Optical")) {

						refund = bill * 60 / 100;

					}
					if (type.equals("Dental care")) {

						refund = bill * 70 / 100;

					}
					if (type.equals("Surgery")) {

						refund = bill * 80 / 100;

					}

				} else if (formula.contains("economic formula"))

				{

					if (type.equals("Consultations or visits")) {

						refund = bill * 50 / 100;

					}
					if (type.equals("Pharmaceuticals")) {

						medica = medicament.getValue();
						if (medica.equals("irreplaceable drugs"))

							refund2 = bill * 100 / 100;
						else if (medica.equals("important drugs"))
							refund2 = bill * 65 / 100;
						else if (medica.equals("medical service moderate"))
							refund2 = bill * 30 / 100;
						else if (medica.equals("low medical service drugs"))
							refund2 = bill * 15 / 100;
						else if (medica == null || medica.length() == 0) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setTitle("Invalid fields");
							alert.setHeaderText("Please fill in the fields");
							alert.setContentText("add Type drugs ");
							alert.showAndWait();
						}

						refund = refund2 * 75 / 100;

					}
					if (type.equals("Medical analysis")) {

						refund = bill * 60 / 100;

					}
					if (type.equals("Radiology")) {

						refund = bill * 60 / 100;

					}
					if (type.equals("Optical")) {

						refund = bill * 40 / 100;

					}
					if (type.equals("Dental care")) {

						refund = bill * 50 / 100;

					}
					if (type.equals("Surgery")) {

						refund = bill * 60 / 100;

					}

				}}
			else refund=0;

				Alert alert2 = new Alert(AlertType.CONFIRMATION);
				alert2.setTitle("Medical File");
				alert2.setHeaderText(null);
				alert2.setContentText("refund =" + refund);

				ButtonType addContractConfirmation = new ButtonType("Medical File Manage");

				ButtonType addContractCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

				alert2.getButtonTypes().setAll(addContractConfirmation, addContractCancel);
				Optional<ButtonType> resultContract = alert2.showAndWait();
				if (resultContract.get() == addContractConfirmation) {

					try {
						context = new InitialContext();
						proxy = (IMedicalFileRemote) context.lookup(jndiName);
						medicalFile.setTotal_refund(refund);
						medicalFile.setTreated(true);
						medicalFile.setType(typemédicalFile.getValue());
						proxy.updateMedicalFile(medicalFile);

					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					/*
					 * try { Stage primaryStage = new Stage(); FXMLLoader loader
					 * = new FXMLLoader(getClass().getResource(
					 * "/views/medicalFileManage.fxml")); Parent root1 =
					 * (Parent) loader.load();
					 * primaryStage.setTitle("Medicals Files"); Scene scene =
					 * new Scene(root1);
					 * scene.getStylesheets().add("/css/application.css");
					 * primaryStage.setScene(scene); Stage stage = (Stage)
					 * btnAccepte.getScene().getWindow(); stage.close();
					 * primaryStage.show(); } catch (Exception e) {
					 * e.printStackTrace(); }
					 */

					FXMLLoader loader = containerParent.switchViewTo("/views/medicalFileManage.fxml");
					((MedicalFileManageController) loader.getController()).setContainer(containerParent);
				}
			
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Invalid fields");
			alert.setHeaderText("Please fill in the fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();

		}

	}

	// Event Listener on Button[#BntRefuse].onAction
	@FXML
	public void refuseAction(ActionEvent event) {
		errorMessage = "";
		if (typemédicalFile.getValue() == null || typemédicalFile.getValue().length() == 0)
			errorMessage += "Choose the type of Medical File Please : ! \n";
		else if (typemédicalFile.getValue().equals("Pharmaceuticals")) {

			if (medicament.getValue() == null || medicament.getValue().length() == 0)
				errorMessage += "Choose the type of drugs  Please : ! \n";
		}
		if (errorMessage.length() == 0) {
			medicalFile.setType(typemédicalFile.getValue());

			try {
				context = new InitialContext();
				proxy = (IMedicalFileRemote) context.lookup(jndiName);
				medicalFile.setTotal_refund(refund);
				medicalFile.setTreated(true);
				medicalFile.setType(typemédicalFile.getValue());
				proxy.updateMedicalFile(medicalFile);
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * try { Stage primaryStage = new Stage(); FXMLLoader loader = new
			 * FXMLLoader(getClass().getResource("/views/medicalFileManage.fxml"
			 * )); Parent root1 = (Parent) loader.load();
			 * primaryStage.setTitle("Medicals Files"); Scene scene = new
			 * Scene(root1); scene.getStylesheets().add("/css/application.css");
			 * primaryStage.setScene(scene); Stage stage = (Stage)
			 * BntRefuse.getScene().getWindow(); stage.close();
			 * primaryStage.show(); } catch (Exception e) { e.printStackTrace();
			 * }
			 */

			FXMLLoader loader = containerParent.switchViewTo("/views/medicalFileManage.fxml");
			((MedicalFileManageController) loader.getController()).setContainer(containerParent);
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Invalid fields");
			alert.setHeaderText("Please fill in the fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();

		}
	}

	// Event Listener on Button[#btnCancel].onAction
	@FXML
	public void cancelAction(ActionEvent event) {

		/*
		 * try { Stage primaryStage = new Stage(); FXMLLoader loader = new
		 * FXMLLoader(getClass().getResource("/views/medicalFileManage.fxml"));
		 * Parent root1 = (Parent) loader.load();
		 * primaryStage.setTitle("Medicals Files"); Scene scene = new
		 * Scene(root1); scene.getStylesheets().add("/css/application.css");
		 * primaryStage.setScene(scene); Stage stage = (Stage)
		 * btnCancel.getScene().getWindow(); stage.close(); primaryStage.show();
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

		FXMLLoader loader = containerParent.switchViewTo("/views/medicalFileManage.fxml");
		((MedicalFileManageController) loader.getController()).setContainer(containerParent);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		typemédicalFile.getItems().add("Consultations or visits");
		typemédicalFile.getItems().add("Pharmaceuticals");
		typemédicalFile.getItems().add("Medical analysis");
		typemédicalFile.getItems().add("Optical");
		typemédicalFile.getItems().add("Dental care");
		typemédicalFile.getItems().add("Radiology");
		typemédicalFile.getItems().add("Surgery");

		hboxdrugs.setVisible(false);

		medicament.getItems().add("irreplaceable drugs");
		medicament.getItems().add("important drugs");
		medicament.getItems().add("medical service moderate");
		medicament.getItems().add("low medical service drugs");

	}

	@FXML
	void getmedicamentType(MouseEvent event) {

		if (typemédicalFile.getValue().equals("Pharmaceuticals")) {

			hboxdrugs.setVisible(true);

		} else {
			hboxdrugs.setVisible(false);

		}

	}

}
