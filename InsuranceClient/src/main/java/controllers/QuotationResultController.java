package controllers;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import entities.User;
import entities.VehicleQuotation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.interf.UserServiceRemote;
import services.interf.VehicleQuotationServiceRemote;

public class QuotationResultController implements Initializable {
	@FXML
	private AnchorPane anchorParent;

	@FXML
	private JFXTextField QuotationResultTxtField;

	public Stage Dialog;
	public VehicleQuotationController controller;

	@FXML
	private Button showResult;

	@FXML
	private ImageView loveReaction;

	@FXML
	private ImageView happyReaction;

	@FXML
	private ImageView suspiciousReaction;

	@FXML
	private ImageView angryReaction;
    private VehicleQuotation vehicleQuotation;
    
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
    @FXML
    private JFXTextArea CommentText;

    @FXML
    private ImageView editPen;
    @FXML
    private JFXTextField QuotationByMonthTxtField;
    @FXML
    private ImageView monthTarif;
    @FXML
    private Label labelPrime;
    
    public int cin;
    
    public User user;
    @FXML
    private Label labelIdUser;
    
    NumberFormat formatter = new DecimalFormat("#0.00");

    
    private VehicleQuotationController container;
        
    public void setController(VehicleQuotationController container) {
        this.container = container;
    }

    public void setCin(int cin){
    	this.cin=cin;
    	labelIdUser.setText(String.valueOf(cin));
    }

	public void setParams(Stage Dialog){
		this.Dialog=Dialog;
	}  
	public void setResult(String s){
		this.QuotationResultTxtField.setText(String.format("%.2f", Double.valueOf(s)));
		this.labelPrime.setText(s);
	}

    public void setVehicleQuotation(VehicleQuotation vehicleQuotation) {
        this.vehicleQuotation = vehicleQuotation;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CommentText.setVisible(false);
	}
	@FXML
	void onAngryClick(MouseEvent event) {
		angryReaction.setOpacity(1);
		vehicleQuotation.setQuotationReaction("Furieux");
		happyReaction.setOpacity(0.4);
		suspiciousReaction.setOpacity(0.4);
		loveReaction.setOpacity(0.4);
	}

	@FXML
	void onHappyClick(MouseEvent event) {
		happyReaction.setOpacity(1);
		vehicleQuotation.setQuotationReaction("Satisfait");
		angryReaction.setOpacity(0.4);
		suspiciousReaction.setOpacity(0.4);
		loveReaction.setOpacity(0.4);
	}

	@FXML
	void onLoveClick(MouseEvent event) {
		loveReaction.setOpacity(1);
		vehicleQuotation.setQuotationReaction("Trés satisfait");
		angryReaction.setOpacity(0.4);
		suspiciousReaction.setOpacity(0.4);
		happyReaction.setOpacity(0.4);
	}

	@FXML
	void onScowClick(MouseEvent event) {
		suspiciousReaction.setOpacity(1);
		vehicleQuotation.setQuotationReaction("Surpris");
		angryReaction.setOpacity(0.4);
		loveReaction.setOpacity(0.4);
		happyReaction.setOpacity(0.4);
	}
	
	public int ServiceAddVehicleQuotation(VehicleQuotation vehicleQuotation) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/VehicleQuotationServiceImpl!services.interf.VehicleQuotationServiceRemote";
		Context context = new InitialContext();
		VehicleQuotationServiceRemote proxy = (VehicleQuotationServiceRemote) context.lookup(jndiName);

		return proxy.addVehicleQuotation(vehicleQuotation);
	}
	
	public User ServicegetUserByCin(int cin) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context.lookup(jndiName);
		return proxy.getUserByCIN(cin);
	}
	
    @FXML
    void showMonthTarif(MouseEvent event) {
		double f= Double.valueOf(labelPrime.getText())/12;
		QuotationByMonthTxtField.setText(formatter.format(f));
    }
    @FXML
    void addComment(MouseEvent event) {
    	CommentText.setVisible(true);
    	CommentText.setEditable(true);
    	CommentText.setOpacity(1);
    }

	@FXML
	void backAction(ActionEvent event) throws Exception {
		vehicleQuotation.setUser(ServicegetUserByCin(Integer.parseInt(labelIdUser.getText())));
		vehicleQuotation.setPrimeQuotation(Float.parseFloat(labelPrime.getText()));
		vehicleQuotation.setCommentary(CommentText.getText());
		ServiceAddVehicleQuotation(vehicleQuotation);
		Dialog.close();
	}
}
