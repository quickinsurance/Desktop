package controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Agent;
import entities.Claim;
import entities.Client;
import entities.Contract;
import entities.ContractProperty;
import entities.Equipment;
import entities.User;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.interf.IClaimsServiceRemote;
import services.interf.IEquipmentServiceRemote;
import services.interf.UserServiceRemote;
import javafx.event.ActionEvent;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
public class ConsultEquipmentContractController implements Initializable{
	  @FXML
	    private VBox content_area;
	  @FXML
	    private JFXButton validate;

	    @FXML
	    private JFXButton refuse;

	    @FXML
	    private JFXButton archive;
	    @FXML
	    private ScrollPane scrollPane;

	    @FXML
	    private VBox ConsultNon;

	    @FXML
	    private ScrollPane scrollPane1;
	    @FXML
	    private Label attached;
	    @FXML
	    private VBox ConsultCours;

	    @FXML
	    private Label dateLabel;

	    @FXML
	    private Label labelClient;

	    @FXML
	    private Label labelPrime;
	    @FXML
	    private Label labelClient1;

	    @FXML
	    private Label labelClient2;

	    @FXML
	    private Label labelClient3;

	    @FXML
	    private Label labelClient4;
	   Contract cont;
	   Client cl;
	   Equipment equip;
	   List<ContractProperty> pro=new ArrayList<ContractProperty>();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			this.refresh();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@FXML
    void archive(ActionEvent event) throws NamingException {
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceEquiment!services.interf.IEquipmentServiceRemote";
		Context context = new InitialContext();
			IEquipmentServiceRemote proxy = (IEquipmentServiceRemote) context.lookup(jndiName);
			proxy.updateEquipment("en cours" , equip.getContract_id());
			this.refresh();

    }

    @FXML
    void refuse(ActionEvent event) throws NamingException {
    	String jndiName = "Insurance-ear/Insurance-ejb/ServiceEquiment!services.interf.IEquipmentServiceRemote";
		Context context = new InitialContext();
			IEquipmentServiceRemote proxy = (IEquipmentServiceRemote) context.lookup(jndiName);
			proxy.updateEquipment("refuse", equip.getContract_id());
			this.refresh();
    }

    @FXML
    void validate(ActionEvent event) throws NamingException {
    	String jndiName = "Insurance-ear/Insurance-ejb/ServiceEquiment!services.interf.IEquipmentServiceRemote";
		Context context = new InitialContext();
			IEquipmentServiceRemote proxy = (IEquipmentServiceRemote) context.lookup(jndiName);
			proxy.updateEquipment("valide", equip.getContract_id());
			this.refresh();

    }
	public void getContract(Contract l) throws NamingException
	{
	String jndiName = "Insurance-ear/Insurance-ejb/ServiceEquiment!services.interf.IEquipmentServiceRemote";
	Context context = new InitialContext();
		IEquipmentServiceRemote proxy = (IEquipmentServiceRemote) context.lookup(jndiName);
		
		String jndiName1 = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context1 = new InitialContext();
		UserServiceRemote proxy1 = (UserServiceRemote) context1.lookup(jndiName1);
		Client c=proxy1.findClientById(l.getClient().getId());
		Equipment eq=proxy.findEquipmentById(l.getContract_id());
		List<ContractProperty> prop=proxy.findCProperty(l.getContract_id());
		labelClient.setText(c.getFirstName());
		labelClient1.setText(c.getLastName());
		labelClient2.setText(String.valueOf(c.getPhone()));
		labelClient3.setText(c.getAddress());
		labelClient4.setText(c.getJob());
		labelPrime.setText(String.valueOf(eq.getPrime()));
		dateLabel.setText(String.valueOf(eq.getDate_creation()));
		cont=l;
		cl=c;
		equip=eq;
		if (pro!=null)
		{pro.clear();}
		pro.addAll(prop);
		System.out.println(cont.getCommission()+"*"+cl.getId()+"-"+equip.getContract_id()+"+"+prop.size());
	}

	public void refresh() throws NamingException
	{
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceEquiment!services.interf.IEquipmentServiceRemote";
		Context context = new InitialContext();
			IEquipmentServiceRemote proxy = (IEquipmentServiceRemote) context.lookup(jndiName);
			
			String jndiName1 = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
			Context context1 = new InitialContext();
			UserServiceRemote proxy1 = (UserServiceRemote) context1.lookup(jndiName1);
			Agent agent=proxy1.findAgentById(1);
			
			ConsultNon.getChildren().clear();
			GridPane grid = new GridPane();
			grid.alignmentProperty();
			grid.setHgap(50);
			grid.setPadding(new Insets(5, 5, 5, 5));
			ConsultNon.getChildren().add(grid);
			scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
	 
			List<Contract> contracts = new ArrayList<>();
			contracts = proxy.findContractByValidation("non traite",agent.getId());
			int cols = 1, colCnt = 0, rowCnt = 0;
			List<Contract> l =new ArrayList<>();
			if (contracts!=null)
			{			 l.addAll(contracts);
				for (int i = 0; i < contracts.size(); i++) {
				int k = i;
					HBox gd = new HBox();
					grid.setMargin(gd, (new Insets(5, 5, 10, 100)));
					gd.setStyle( 
							"-fx-background-color:#F1F5F8;-fx-border-color:#eaf2f7 ;-fx-border-radius: 30px 30px 30px 30px;-fx-background-radius: 30px 30px 30px 30px;-fx-effect: dropshadow(three-pass-box, #dad4d4, 1, 1, 1,1);");
					Label l1 = new Label(String.valueOf("Contract's ref :"+contracts.get(i).getContract_id()));
					l1.setPadding(new Insets(5, 5, 5, 5));
					l1.setMaxSize(200, 50);
					l1.setMinSize(100, 50);
					Label l2 = new Label(contracts.get(i).getDate_creation().toString());
					l2.setPadding(new Insets(15, 5, 5, 5));
					gd.getChildren().add(l1);
					gd.getChildren().add(l2);
					grid.add(gd, colCnt, rowCnt);
					colCnt++;
					if (colCnt == cols) {
						colCnt = 0;
						rowCnt++;
					}					
				
					gd.setOnMouseClicked((MouseEvent event1) -> {	
						validate.setVisible(true);
						refuse.setVisible(true);
						archive.setVisible(true);
						try {
							this.getContract(l.get(k));
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						attached.setOnMouseClicked((MouseEvent event2) -> {
							try {
								this.generatePdf();
							} catch (IOException | DocumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						});
					});
				
			}}
			
			ConsultCours.getChildren().clear();
			GridPane grid1 = new GridPane();
			grid1.alignmentProperty();
			grid1.setHgap(50);
			grid1.setPadding(new Insets(5, 5, 5, 5));
			ConsultCours.getChildren().add(grid1);
			scrollPane1.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	        scrollPane1.setHbarPolicy(ScrollBarPolicy.NEVER);
	 
			List<Contract> contracts1 = new ArrayList<>();
			contracts1 = proxy.findContractByValidation("en cours",agent.getId());
			int cols1 = 1, colCnt1 = 0, rowCnt1 = 0;
			List<Contract> l1 =new ArrayList<>();
			if (contracts1!=null)
			{    l1.addAll(contracts1);
				for (int i = 0; i < contracts1.size(); i++) {
				int k = i;
				if (contracts1.get(i) != null) {
					HBox gd1 = new HBox();
					gd1.setCenterShape(true);
					grid1.setMargin(gd1, (new Insets(5, 5, 10, 100)));
					gd1.setStyle( 
							"-fx-background-color:#F1F5F8;-fx-border-color:#eaf2f7 ;-fx-border-radius: 30px 30px 30px 30px;-fx-background-radius: 30px 30px 30px 30px;-fx-effect: dropshadow(three-pass-box, #dad4d4, 1, 1, 1,1);");
					Label l11 = new Label(String.valueOf("Contrat's ref :"+contracts1.get(i).getContract_id()));
					l11.setPadding(new Insets(5, 5, 5, 5));
					l11.setMaxSize(200, 50);
					l11.setMinSize(100, 50);
					Label l21 = new Label(contracts1.get(i).getDate_creation().toString());
					l21.setPadding(new Insets(15, 5, 5, 5));
					gd1.getChildren().add(l11);
					gd1.getChildren().add(l21);
					grid1.add(gd1, colCnt1, rowCnt1);
					colCnt1++;
					if (colCnt1 == cols1) {
						colCnt1 = 0;
						rowCnt1++;
					}
					gd1.setOnMouseClicked((MouseEvent event1) -> {
						validate.setVisible(true);
						refuse.setVisible(true);
						archive.setVisible(true);
						try {
							this.getContract(l1.get(k));
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						attached.setOnMouseClicked((MouseEvent event2) -> {
							try {
								this.generatePdf();
							} catch (IOException | DocumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						});
					});
				}}
			}

		
	}
	public void generatePdf() throws MalformedURLException, IOException, DocumentException
	{
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("E:\\contract.pdf"));
        document.open();

        // Listing 3. Creation of paragraph object
        Anchor anchorTarget = new Anchor("First page of the document.");
        anchorTarget.setName("BackToTop");

        Paragraph paragraph1 = new Paragraph();
        paragraph1.setSpacingBefore(50);
        paragraph1.add(anchorTarget);
        document.add(paragraph1);

        document.add(new Paragraph("Some more text on the first page with different color and font type.",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,new CMYKColor(0, 255, 0, 0))));

        document.add(new Paragraph("u r answers are \n a \n b \n c \n d"));

        // Listing 4. Creation of chapter object
        Paragraph title1 = new Paragraph("Chapter 1", FontFactory.getFont(
                        FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0,
                                        255, 255, 17)));

        Chapter chapter1 = new Chapter(title1, 1);
        chapter1.setNumberDepth(0);

        // Listing 5. Creation of section object
        Paragraph title11 = new Paragraph("This is Section 1 in Chapter 1",
                        FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD,
                                        new CMYKColor(0, 255, 255, 17)));

        Section section1 = chapter1.addSection(title11);
        Paragraph someSectionText = new Paragraph(
                        "This text comes as part of section 1 of chapter 1.");
        section1.add(someSectionText);
        someSectionText = new Paragraph("Following is a 3 X 2 table.");
        section1.add(someSectionText);

        // Listing 6. Creation of table object
        PdfPTable t = new PdfPTable(2);

        t.setSpacingBefore(25);
        t.setSpacingAfter(25);

        PdfPCell c1 = new PdfPCell(new Paragraph("First Name",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,new CMYKColor(0, 255, 0, 0))));
        t.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Paragraph("Last Name",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,new CMYKColor(0, 255, 0, 0))));
        t.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Paragraph("Enrolment No.",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,new CMYKColor(0, 255, 0, 0))));
        t.addCell(c3);
        PdfPCell c4 = new PdfPCell(new Paragraph("Password",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,new CMYKColor(0, 255, 0, 0))));
        t.addCell(c4);


        /*try
        {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","admin","123456");
                Statement st =con.createStatement();
                ResultSet rs = st.executeQuery("SELECT firstname,lastname,asn,password from reg1 where branchname='IT' and sem='3'");

                while(rs.next())
                {
                        t.addCell(rs.getString(1));
                        t.addCell(rs.getString(2));
                        t.addCell(rs.getString(3));
                        t.addCell(rs.getString(4));
                }
        }
        catch (Exception e) 
        {
                System.out.print("Parth: " +e);
        }*/




        //section1.add(t);
        document.add(t);

        // Listing 7. Creation of list object
    /*    List l = new List(true, false, 10);
        l.add(new ListItem("First item of list"));
        l.add(new ListItem("Second item of list"));
        section1.add((Element) l);
*/
        // Listing 8. Adding image to the main document

        Image image2 = Image.getInstance("C:\\Users\\amalg\\Desktop\\pi1\\kk.jpg");
        image2.scaleAbsolute(120f, 120f);
        section1.add(image2);

        // Listing 9. Adding Anchor to the main document.
        Paragraph title2 = new Paragraph("Using Anchor", FontFactory.getFont(
                        FontFactory.HELVETICA, 16, Font.BOLD, new CMYKColor(0, 255, 0,
                                        0)));
        section1.add(title2);

        title2.setSpacingBefore(5000);
        Anchor anchor2 = new Anchor("Back To Top");
        anchor2.setReference("#BackToTop");

        section1.add(anchor2);


        // Listing 10. Addition of a chapter to the main document
        document.add(chapter1);
        document.close();
	}
}
