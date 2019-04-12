package controllers;

import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.scene.layout.Pane;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.*;
import com.jfoenix.controls.JFXTextArea;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.impl.EmailMessages;
import services.interf.IMessageServiceRemote;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import entities.Messagerie;
import entities.User;
import entities.Messagerie.type_message;
public class MessagerieController implements Initializable {

	@FXML
	private VBox content_area;

	@FXML
	private HBox menubar;

	@FXML
	private HBox menubar1;

	@FXML
	private VBox displayMail;

    @FXML
    private FontAwesomeIcon square;

    @FXML
    private FontAwesomeIcon star;
    String type;
    
    @FXML
    private Pane composePane;
    @FXML
    private JFXTextField receiverTxt;

    @FXML
    private JFXTextField subjectTxt;
    @FXML
    private JFXTextArea ContenuTxt;
    @FXML
    private VBox MessageVbox;
	@FXML
	void DesplayInbox(ActionEvent event) throws Exception {
		type="inbox";
		displayInobxMail();
	}
	@FXML
    void Compose(ActionEvent event) {
		MessageVbox.setVisible(true);
		System.out.println(		MessageVbox.isVisible());
    }

    @FXML
    void sendMessage(ActionEvent event) throws Exception{
    	String jndiName = "Insurance-ear/Insurance-ejb/ServiceMessages!services.interf.IMessageServiceRemote";
		Context context=new InitialContext();
		IMessageServiceRemote proxy = (IMessageServiceRemote) context.lookup(jndiName);
    	User sender= proxy.findUserById(1);
    	User receiver= proxy.findUserByEmail(receiverTxt.getText());
    	Messagerie m=new Messagerie();
    	m.setContenu(ContenuTxt.getText());
    	m.setSubject(subjectTxt.getText());
    	m.setType_message(type_message.sent);
    	m.setSender(sender);
    	m.setReceiver(receiver);
    	m.getMessageriePk().setDate_envoie(new Date());
    	proxy.addMessage(m);
    	EmailMessages email=new EmailMessages(sender,receiver,m);
    }
    
    @FXML
    void DesplayStarred(ActionEvent event) throws Exception{
		type="Starred";
		displayInobxMail();
    }

    @FXML
    void DisplayDrafts(ActionEvent event) throws Exception{
		type="Drafts";
		displayInobxMail();

    }

    @FXML
    void DisplayImportant(ActionEvent event) throws Exception{
		type="Important";
		displayInobxMail();

    }

    @FXML
    void DisplaySent(ActionEvent event) throws Exception{
		type="Sent";
		displayInobxMail();
    }

    @FXML
    void Refresh(ActionEvent event) {

    }

	public void displayInobxMail()throws Exception {
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceMessages!services.interf.IMessageServiceRemote";
		Context context=new InitialContext();
		IMessageServiceRemote proxy = (IMessageServiceRemote) context.lookup(jndiName);
		
		displayMail.getChildren().clear();
		GridPane grid = new GridPane();
		grid.alignmentProperty();
		grid.setHgap(50);
		grid.setPadding(new Insets(5, 5, 5, 5));
		displayMail.getChildren().add(grid);
		List<Messagerie> msg=new ArrayList<>();
		if (type.equals("inbox")){msg= proxy.findInbox(1);}
		if (type.equals("Starred")){msg= proxy.findStarredById(1);}
		if (type.equals("Drafts")){msg= proxy.findDraftsById(1);}
		if (type.equals("Important")){msg= proxy.findImportantById(1);}
		if (type.equals("Sent")){msg= proxy.findSentById(1);}

		int cols = 1, colCnt = 0, rowCnt = 0;

		for (int i = 0; i < msg.size(); i++) {
			if (msg.get(i) != null) {
				HBox gd = new HBox();
				JFXButton b1=new JFXButton();
				JFXButton b2=new JFXButton();
				b1.setGraphic(square);
				b2.setGraphic(star);
				Label l1= new Label(msg.get(i).getSender().getFirstName()+msg.get(i).getSender().getLastName());
				l1.setPrefWidth(100);
				l1.setStyle("-fx-text-fill:BLACK");
				Label l2=new Label(msg.get(i).getSubject());
				l2.setPrefWidth(100);
				l2.setStyle("-fx-text-fill:BLACK");
				Label l3=new Label(msg.get(i).getContenu());
				l3.setPrefWidth(200);
				Label l4=new Label(msg.get(i).getMessageriePk().getDate_envoie().toString());
				l4.setPrefWidth(100);
				l4.setStyle("-fx-text-fill:BLACK");
				gd.getChildren().add(b1);
				gd.getChildren().add(b2);
				gd.getChildren().add(l1);
				gd.getChildren().add(l2);
				gd.getChildren().add(l3);
				gd.getChildren().add(l4);

				grid.add(gd, colCnt, rowCnt);
				colCnt++;
				if (colCnt == cols) {
					colCnt = 0;
					rowCnt++;
				}
			}
		}
	}

	
	@FXML
	void open_sidebar(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		type="inbox";
		try {
			displayInobxMail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

}
