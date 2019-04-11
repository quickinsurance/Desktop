package controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;

import entities.Agent;
import entities.Client;
import entities.Contract;
import entities.ContractProperty;
import entities.Equipment;
import entities.SinisterEquipment;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.interf.IEquipmentServiceRemote;
import services.interf.ISinisterEquipmentServiceRemote;
import services.interf.UserServiceRemote;
import javafx.event.ActionEvent;

public class SinisterEquipmentConsultController implements Initializable{
    private SinisterEquipmentContainterController containerParent;

    @FXML
    private VBox content_area;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox ConsultNon;

    @FXML
    private Label dateLabel;

    @FXML
    private Label attached;

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

    @FXML
    private Label property;

    @FXML
    private Label sinisterDate;

    @FXML
    private Label cause;

    @FXML
    private Label bill;

    @FXML
    private Label attached1;

    @FXML
    private JFXButton validate;

    @FXML
    private JFXButton refuse;

    @FXML
    private JFXButton archive;
    SinisterEquipment cont;
	   Client cl;
	   Equipment equip;
	   List<ContractProperty> pro=new ArrayList<ContractProperty>();
    @FXML
    void archive(ActionEvent event) {

    }
    
    @FXML
    void refuse(ActionEvent event) throws NamingException {
    	String jndiName = "Insurance-ear/Insurance-ejb/ServiceSinisterEquipment!services.interf.ISinisterEquipmentServiceRemote";
		Context context = new InitialContext();
		ISinisterEquipmentServiceRemote proxy = (ISinisterEquipmentServiceRemote) context.lookup(jndiName);
			proxy.updateSinsiter("refuse", equip.getContract_id(),Double.valueOf("0"));
			this.refresh();
    }

    @FXML
    void validate(ActionEvent event) throws NamingException {
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceSinisterEquipment!services.interf.ISinisterEquipmentServiceRemote";
		Context context = new InitialContext();
		ISinisterEquipmentServiceRemote proxy = (ISinisterEquipmentServiceRemote) context.lookup(jndiName);
		double payement=0;
		String f="";
		String[] array = cont.getContractProperty().getCondition_equipment().split("\\s", -1);
		int i=0;
		while (i<array.length){
			if (cont.getContractProperty().getCondition_equipment().equals("neuf"))
			{
				f="neuf";
				break;
			}
			if (cont.getContractProperty().getCondition_equipment().equals("occasion"))
			{
				f="occasion";
				break;
			}
			i++;
		}
		if (cont.getContractProperty().getOption_contract().toString().equals("Standard"))
		{
			if (f.equals("neuf"))
			{ payement=0.65*cont.getBill();}
			else{
				payement=0.60*cont.getBill();
			}
		}
		if (cont.getContractProperty().getOption_contract().toString().equals("Premium"))
		{
			if (f.equals("neuf"))
			{payement=0.75*cont.getBill(); }
			else{
				payement=0.70*cont.getBill();
			}
		}
		if (cont.getContractProperty().getOption_contract().toString().equals("Ultimate"))
		{
			if (f.equals("neuf"))
			{ payement=0.85*cont.getBill();}
			else{
				payement=0.80*cont.getBill();
			}
		}
		System.out.println(payement);
		proxy.updateSinsiter("valide",cont.getId(),payement);
			this.refresh();
    }

	public void setContainer(SinisterEquipmentContainterController sinisterEquipmentContainterController) {
		this.containerParent =sinisterEquipmentContainterController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			this.refresh();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getContract(SinisterEquipment l) throws NamingException
	{
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceEquiment!services.interf.IEquipmentServiceRemote";
	Context context = new InitialContext();
	IEquipmentServiceRemote proxy = (IEquipmentServiceRemote) context.lookup(jndiName);
		
		String jndiName1 = "Insurance-ear/Insurance-ejb/UserServiceImpl!services.interf.UserServiceRemote";
		Context context1 = new InitialContext();
		UserServiceRemote proxy1 = (UserServiceRemote) context1.lookup(jndiName1);
		
		Client c=proxy1.findClientById(l.getContractProperty().getEquipment().getClient().getId());
		Equipment eq=proxy.findEquipmentById(l.getContractProperty().getEquipment().getContract_id());
		List<ContractProperty> prop=proxy.findCProperty(l.getContractProperty().getEquipment().getContract_id());
		labelClient.setText(c.getFirstName());
		labelClient1.setText(c.getLastName());
		labelClient2.setText(String.valueOf(c.getPhone()));
		labelClient3.setText(c.getAddress());
		labelClient4.setText(c.getJob());
		labelPrime.setText(String.valueOf(eq.getPrime()));
		dateLabel.setText(String.valueOf(eq.getDate_creation()));
		property.setText("An "+l.getContractProperty().getMarque()+" "+l.getContractProperty().getItem()
				+" having "+l.getContractProperty().getOption_contract().toString()+" option ");
		sinisterDate.setText(l.getDate_siniter().toString());
		cause.setText(l.getCause().toString());
		bill.setText(String.valueOf(l.getBill()));
		attached.setOnMouseClicked((MouseEvent event33)->{
			System.out.print("555555");
			try {
				this.generatePdf(eq);
			} catch (IOException | DocumentException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		attached1.setOnMouseClicked((MouseEvent event)->{
			  byte[] b = l.getDocument();
				OutputStream out;
				try {
					out = new FileOutputStream("E:\\doc.jpg");
					out.write(b);
					out.close();
					File myFile = new File("E:\\doc.jpg");
					Desktop.getDesktop().open(myFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		});
		cont=l;
		cl=c;
		equip=eq;
		if (pro!=null)
		{pro.clear();}
		pro.addAll(prop);
		//System.out.println(cont.getCommission()+"*"+cl.getId()+"-"+equip.getContract_id()+"+"+prop.size());
	}
	
	public void refresh() throws NamingException
	{
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceSinisterEquipment!services.interf.ISinisterEquipmentServiceRemote";
		Context context = new InitialContext();
		ISinisterEquipmentServiceRemote proxy = (ISinisterEquipmentServiceRemote) context.lookup(jndiName);
			
			ConsultNon.getChildren().clear();
			GridPane grid = new GridPane();
			grid.alignmentProperty();
			grid.setHgap(50);
			grid.setPadding(new Insets(5, 5, 5, 5));
			ConsultNon.getChildren().add(grid);
			scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
	 
			List<SinisterEquipment> sinis = new ArrayList<>();
			sinis = proxy.findSinisterByValidation("non traite");
			int cols = 1, colCnt = 0, rowCnt = 0;
			List<SinisterEquipment> l =new ArrayList<>();
			if (sinis!=null)
			{			 l.addAll(sinis);
				for (int i = 0; i < sinis.size(); i++) {
				int k = i;
					HBox gd = new HBox();
					grid.setMargin(gd, (new Insets(5, 5, 10, 100)));
					gd.setStyle( 
							"-fx-background-color:#F1F5F8;-fx-border-color:#eaf2f7 ;-fx-border-radius: 30px 30px 30px 30px;-fx-background-radius: 30px 30px 30px 30px;-fx-effect: dropshadow(three-pass-box, #dad4d4, 1, 1, 1,1);");
					Label l1 = new Label(String.valueOf("Contract's ref :"+sinis.get(i).getContractProperty().getEquipment().getContract_id()));
					l1.setPadding(new Insets(5, 5, 5, 5));
					l1.setMaxSize(200, 50);
					l1.setMinSize(100, 50);
					Label l2 = new Label(sinis.get(i).getDate_siniter().toString());
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
						//archive.setVisible(true);
						try {
							this.getContract(l.get(k));
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						attached.setOnMouseClicked((MouseEvent event2) -> {
						});
					});
				
			}}

		
	}
	public void generatePdf(Contract c) throws MalformedURLException, IOException, DocumentException, NamingException
	{
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("E:\\contract.pdf"));
        document.open();

        Paragraph paragraph1 = new Paragraph();
        paragraph1.setSpacingBefore(50);
        document.add(paragraph1);

        Paragraph title1 = new Paragraph("Quick Insurance", FontFactory.getFont(
                        FontFactory.TIMES, 18, Font.BOLDITALIC, new CMYKColor(86,
                                        87, 89, 17)));

        Chapter chapter1 = new Chapter(title1, 1);
        chapter1.setNumberDepth(0);

        Paragraph title11 = new Paragraph("Contract ref"+c.getContract_id(),
                        FontFactory.getFont(FontFactory.TIMES, 16, Font.BOLD,
                                        new CMYKColor(86, 87, 89, 17)));

        Section section1 = chapter1.addSection(title11);
        document.add(chapter1);
      	document.add(new Paragraph(""));
    	document.add(new Paragraph(""));
    	document.add(new Paragraph("                                                    Equipment Insurance Contract"));
    	document.add(new Paragraph(" "));
    	document.add(new Paragraph(" "));
    	String x="In application of Article L 113-15-1 of the Insurance Code, this person has become one of"+
    			  
    	    
    		"	our insureds for a equipment insurance."+

"This insurance contract is the convention by which our company undertakes, in case of"+
"realization of the risk or at the term fixed in the contract, to provide to our insured a cash "+
"benefit in consideration for a remuneration called premium or contribution."+
"All amendment or addition to the initial contract must be noted by anendorsement signed"+
"by both parties.";

    	document.add(new Paragraph(x));
    	 Image image2 = Image.getInstance("D:\\cont.jpg");
         image2.scaleAbsolute(500f, 500f);
         document.add(image2);
    	document.add(new Paragraph("First Name: "+c.getClient().getFirstName()));
    	document.add(new Paragraph("Last Name: "+c.getClient().getLastName()));
    	document.add(new Paragraph("CIN number:"+c.getClient().getCin()));
    	document.add(new Paragraph("Adresse: "+ c.getClient().getAddress()));
    	document.add(new Paragraph("RIB Number: "+c.getClient().getRIB_Number() ));
    	
    	String jndiName1 = "Insurance-ear/Insurance-ejb/ServiceEquiment!services.interf.IEquipmentServiceRemote";
		Context context1 = new InitialContext();
		IEquipmentServiceRemote proxy1 = (IEquipmentServiceRemote) context1.lookup(jndiName1);
		List<ContractProperty> p =proxy1.findCProperty(c.getContract_id());

    	PdfPTable t = new PdfPTable(2);
        t.setWidthPercentage(100);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);


    	for (int i=0;i<p.size();i++)
    	{
        PdfPCell c1 = new PdfPCell(new Paragraph("Option: " + p.get(i).getOption_contract()+
    			"\n item :    "+p.get(i).getItem()+
    			"\n make:     "+p.get(i).getMarque()+
    			"\n model:    "+p.get(i).getModel()+
    			"\n value of this property :    "+p.get(i).getValue()+
    			"\n condition of this property :   "+p.get(i).getCondition_equipment()+
    			"\n Primmium  :  "+p.get(i).getPrime(),FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL,new BaseColor(61,62, 63))));
       // c1.setColspan(2);
        t.addCell(c1);

    	}
        document.add(t);
       
        document.close();
        File myFile = new File("D:\\contract.pdf");
		Desktop.getDesktop().open(myFile);
	}
}
