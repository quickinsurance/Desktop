package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javafx.scene.control.Label;
import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.*;
import entities.Claim;
import entities.User;
import entities.Claim.type_subject;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.interf.IClaimsServiceRemote;
import services.interf.IMessageServiceRemote;
import tn.esprit.CompareClaims;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXTextArea;

public class ClaimController implements Initializable {
	@FXML
	private VBox content_area;

	@FXML
	private Label dateLabel;

	@FXML
	private Label labelSubject;

	@FXML
	private Label labelRef;

    @FXML
    private AnchorPane textarea;
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ScrollPane scrollPane2;

    @FXML
    private VBox Match;
    @FXML
    private JFXTextArea response;

    @FXML
    private ScrollPane scrollPane1;

    @FXML
    private VBox Respond;
	private Claim claim;
	TreeSet<CompareClaims> MatchOrdered = new TreeSet<>();

/*
	void add(ActionEvent event) throws Exception {
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceClaims!services.interf.IClaimsServiceRemote";
		Context context = new InitialContext();
		IClaimsServiceRemote proxy = (IClaimsServiceRemote) context.lookup(jndiName);
		Claim c = proxy.findClaimById(claim.getClaim_id());
		byte[] b = c.getDocument();
		// download it
		OutputStream out = new FileOutputStream("E:\\kk.pdf");
		out.write(b);
		out.close();
		// open file
		File myFile = new File("E:\\kk.pdf");
		Desktop.getDesktop().open(myFile);
		// delete it
		// if (myFile.exists()) {
		// myFile.delete();}

	}*/

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void findMatch(String[] array,String st) throws NamingException {
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceClaims!services.interf.IClaimsServiceRemote";
		Context context = new InitialContext();
		IClaimsServiceRemote proxy = (IClaimsServiceRemote) context.lookup(jndiName);
		Claim c = proxy.findClaimById(claim.getClaim_id());
		List<Claim> claims = proxy.FindMatch(claim.getType_subject().toString(), claim.getClaim_id());
		int match;
		for (int i = 0; i < claims.size(); i++) {
			int x = 0;
			String[] array1 = claims.get(i).getDescription().split("\\s", -1);
			for (int j = 0; j < array1.length; j++) {
				for (int k = 0; k < array.length; k++) {
					if (array[k].trim().equals(array1[j].trim()) && !array[k].trim().equals("")) {
						

						x++;
					}
				}
			}
			CompareClaims cc = new CompareClaims();

			if (x!=0 && x==(array.length-1))
			{  			
			cc.setC(claims.get(i));
			cc.LevensthienDistance(st, claims.get(i).getDescription());
			cc.LongestCommonSubsequence(st, claims.get(i).getDescription());
			cc.CodeComparisonScoresHelper(st, claims.get(i).getDescription());
			MatchOrdered.add(cc);
			}
		}
		System.out.println("**"+MatchOrdered.size());
		int cols2 = 1, colCnt2 = 0, rowCnt2 = 0;
		Match.getChildren().clear();
		GridPane grid2 = new GridPane();
		grid2.alignmentProperty();
		grid2.setHgap(50);
		grid2.setPadding(new Insets(5, 5, 5, 5));
		Match.getChildren().add(grid2);
		scrollPane2.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane2.setHbarPolicy(ScrollBarPolicy.NEVER);
        
		for (CompareClaims e : MatchOrdered) {
				HBox gd = new HBox();
				grid2.setMargin(gd, (new Insets(5, 5, 10, 5)));
				gd.setStyle( 
						"-fx-background-color:#F1F5F8;-fx-border-color:#eaf2f7 ;-fx-border-radius: 30px 30px 30px 30px;-fx-background-radius: 30px 30px 30px 30px;-fx-effect: dropshadow(three-pass-box, #dad4d4, 1, 1, 1,1);");
				Label l1 = new Label(e.getC().getDescription());
				l1.setPadding(new Insets(5, 5, 5, 5));
				l1.setMaxSize(300, 100);
				l1.setMinSize(300, 100);
				gd.getChildren().add(l1);
				grid2.add(gd, colCnt2, rowCnt2);
				colCnt2++;
				if (colCnt2 == cols2) {
					colCnt2 = 0;
					rowCnt2++;
				}
				gd.setOnMouseClicked((MouseEvent event1) -> {
					response.clear();
					response.setText(e.getC().getInsurance_response());
				});
			
		}
		
	}
	 @FXML
	    void Respond(ActionEvent event) throws NamingException {
		 String s=response.getText();
		 String jndiName = "Insurance-ear/Insurance-ejb/ServiceClaims!services.interf.IClaimsServiceRemote";
			Context context = new InitialContext();
			IClaimsServiceRemote proxy = (IClaimsServiceRemote) context.lookup(jndiName);
			proxy.updateClaim(claim, s);
	    }


	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}


	

	public Label getDateLabel() {
		return dateLabel;
	}

	public void setDateLabel(Label dateLabel) {
		this.dateLabel = dateLabel;
	}

	public Label getLabelSubject() {
		return labelSubject;
	}

	public void setLabelSubject(Label labelSubject) {
		this.labelSubject = labelSubject;
	}

	public Label getLabelRef() {
		return labelRef;
	}

	public void setLabelRef(Label labelRef) {
		this.labelRef = labelRef;
	}


	public ScrollPane getScrollPane() {
		return scrollPane;
	}


	public void setScrollPane(ScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	public AnchorPane getTextarea() {
		return textarea;
	}


	public void setTextarea(AnchorPane textarea) {
		this.textarea = textarea;
	}

}
