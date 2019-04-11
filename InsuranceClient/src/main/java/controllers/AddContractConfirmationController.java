package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import entities.Client;
import entities.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.interf.UserServiceRemote;
import services.interf.VehicleContractServiceRemote;

public class AddContractConfirmationController implements Initializable {

    @FXML
    private Button confirmBtn;
    @FXML
    private Button btnPrintPDF;
    
    private Vehicle vehicle;
	
    public Stage Dialog;
    @FXML
    private Label txtCin;
    public int cin;
    @FXML
    private TextField txtOption;

    @FXML
    private TextField txtMarque;

    @FXML
    private TextField txtImmatriculation;

    @FXML
    private TextField txtAdresse;
    
    @FXML
    private TextArea txtAreaContract;
    @FXML
    private ImageView returnBtn;

    private VehicleDisplaysController container;

    public void setContainer(VehicleDisplaysController container) {
        this.container = container;
    }
    
    public void setVehicleContract(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void setCin(int cin){
    	this.cin=cin;
    	txtCin.setText(String.valueOf(cin));
    }
	public void setParams(Stage Dialog){
		this.Dialog=Dialog;
	}  
	public void setImmatriculation(String i){
		this.txtImmatriculation.setText(i);
	}
	public void setMarque(String m){
		this.txtMarque.setText(m);
	}
	public void setAdresse(String a){
		this.txtAdresse.setText(a);
	}
	public void setOption(String o){
		this.txtOption.setText(o);
	}
	
	public Client ServicegetClientByCin(int cin) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		return proxy.getClientByCIN(cin);
	}
	public int ServiceAddVehicleContract(Vehicle vehicleContract) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/VehicleContractServiceImpl!services.interf.VehicleContractServiceRemote";
		Context context = new InitialContext();
		VehicleContractServiceRemote proxy = (VehicleContractServiceRemote) context.lookup(jndiName);

		return proxy.addVehicleContract(vehicleContract);
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
    @FXML
    void confirmContractAction(ActionEvent event) throws NumberFormatException, Exception {
		vehicle.setClient(ServicegetClientByCin(Integer.parseInt(txtCin.getText())));
		ServiceAddVehicleContract(vehicle);	
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operation Successful !");
        alert.setContentText("A new Contract Successfully Added");
        alert.showAndWait();
    }
    @FXML
    void printPdfContract(ActionEvent event) throws DocumentException, IOException {	
    	String f= vehicle.getClient().getFirstName();
    	String l =vehicle.getClient().getLastName();    	
    	OutputStream file = new FileOutputStream(new File("C:\\Users\\asus\\Desktop\\QuickInsuranceContracts\\"+l+f+"Contract.pdf"));
    	Document document = new Document();
    	PdfWriter.getInstance(document, file);
    	document.open();
    	Image img1 = Image.getInstance("C:\\Users\\asus\\Desktop\\QuickInsuranceContracts\\logo.png");
    	document.add(img1);
    	document.add(new Paragraph(""));
    	document.add(new Paragraph(""));
    	document.add(new Paragraph("                                                    Vehicle Insurance Contract"));
    	document.add(new Paragraph("."));
    	document.add(new Paragraph("."));
    	document.add(new Paragraph("First Name: "+vehicle.getClient().getFirstName()));
    	document.add(new Paragraph("Last Name: "+vehicle.getClient().getLastName()));
    	document.add(new Paragraph("CIN number:"+ vehicle.getClient().getCin()));
    	document.add(new Paragraph("Adresse: "+ txtAdresse.getText()));
    	document.add(new Paragraph("RIB Number: "+ vehicle.getClient().getRIB_Number()));
    	document.add(new Paragraph(txtAreaContract.getText()));
    	document.add(new Paragraph("Vehicle Mark: " + txtMarque.getText()));
    	document.add(new Paragraph("Vehicle Immatriculation: "+ txtImmatriculation.getText()));
    	document.add(new Paragraph("Option: " + txtOption.getText()));
    	Image img = Image.getInstance("C:\\Users\\asus\\Desktop\\QuickInsuranceContracts\\Signature.png");
    	document.add(new Paragraph("."));
    	document.add(new Paragraph("Signature"));
    	document.add(new Paragraph("."));
    	document.add(img);
    	document.close();
        file.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operation Successful !");
        alert.setHeaderText("A new Contract saved correctly.");
        alert.setContentText("A new Contract has been saved inside the folder QuickInsuranceContracts");
        alert.showAndWait();
    }

    @FXML
    void returnAction(MouseEvent event) {
     //   returnBtn.getScene().getWindow().hide();
    	 FXMLLoader loader = container.switchView("/views/AddContractView.fxml");
         ((AddContractController) loader.getController()).setContainer(container);
    }
}
