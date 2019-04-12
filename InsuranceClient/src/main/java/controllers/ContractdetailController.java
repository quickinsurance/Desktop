package controllers;

import java.util.Date;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import entities.Contract;
import entities.Housing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tn.esprit.SwitchScreen;
import tn.esprit.Test;

public class ContractdetailController implements Initializable{

	   @FXML
	    private Label Address;

	    @FXML
	    private Label Address1;

	    @FXML
	    private Label HouseType1;

	    @FXML
	    private Label Area1;

	    @FXML
	    private Label Type1;

	    @FXML
	    private Label code1;

	    @FXML
	    private Label vlaue;

	    @FXML
	    private Label protection;

	    @FXML
	    private Label drinkerLabel;

	    @FXML
	    private Label objectS;

	    @FXML
	    private Label objectV;

	    @FXML
	    private Label unhabited;

	    @FXML
	    private Label yearnmbr;

	    @FXML
	    private Label ApparF;
	    
	    @FXML
	    private Label floor;
	    @FXML
	    private Label Gurantee1;
	    
	    @FXML
	    private Label sinister;

	    @FXML
	    private Label Prime;
	    
	    @FXML
	    private Button Primebutton;
	    
	    @FXML
	    private Label firstname;

	    @FXML
	    private Label lastname;


	    @FXML
	    private Label cinnumber;

	    @FXML
	    private Label rib;

	    @FXML
	    private ImageView image1;
	    @FXML
	    private Label fname;

	    @FXML
	    private Label lname;

	    @FXML
	    private Label cin;

	    @FXML
	    private Label rib1;

	    @FXML
	    private Label clientphone;

	    @FXML
	    private Label clientadress;

	    @FXML
	    private Button resiliatebuttom;
	    
	    @FXML
	    private Label refundAmount;

	    @FXML
	    private Label refund1;
	    @FXML
	    private Label resi;


	    
	    @FXML
	    private Button retour;
	    
	    @FXML
	    private Button AccepteButton;

	    @FXML
	    private Button refuseButton;
	    
	    File file ;
	    Test t = new Test();
	    
	    ContractHousingContainerController parentContainer;


	private int id1;
	 
	 
	 //int id = house1.getContract_id();
	
	 
	public void setid(int id) {

		this.id1=id;
		

	}
	
	Housing house;
	 


    
    public void startstage(){
    	System.out.println(id1+1);
    	ApparF.setVisible(false);
    	floor.setVisible(false);
		AccepteButton.setVisible(false);
		refuseButton.setVisible(false);
    
    	

    	
    try {
    	
    	
    	

    		

			 house =t.ServicefindContracthouse(id1);
			
			 fname.setText(house.getClient().getFirstName());
			lname.setText(house.getClient().getLastName());
			clientadress.setText(house.getClient().getAddress());
			clientphone.setText(String.valueOf(house.getClient().getPhone()));
			cin.setText(String.valueOf(house.getClient().getCin()));
			rib1.setText(house.getClient().getRIB_Number());
			Address1.setText(String.valueOf(house.getAddress()));
			HouseType1.setText(String.valueOf(house.getType_housing()));
			Area1.setText(String.valueOf(house.getArea()));
			
			code1.setText(String.valueOf(house.getCodePostal()));
			vlaue.setText(String.valueOf(house.getHousevalue()));
			protection.setText(String.valueOf(house.getHouseProtection()));
			objectV.setText(String.valueOf(house.getObjectsvalue()));

			unhabited.setText(String.valueOf(house.getHouseempty()));
			yearnmbr.setText(String.valueOf(house.getHouseduration()));
			yearnmbr.setText(String.valueOf(house.getHouseduration()));
			Prime.setText(String.valueOf(house.getPrime()));
			if (house.getType_housing().equals("appartement")){
ApparF.setVisible(true);
floor.setVisible(true);

			}

			if (house.getEtatdemande().equals("on hold")){
				resiliatebuttom.setVisible(true);
		    	AccepteButton.setVisible(true);
				refuseButton.setVisible(true);
			}
			
			
			java.sql.Date today =java.sql.Date.valueOf(java.time.LocalDate.now());
			String datt = today.toString();
			LocalDate dateBefore = LocalDate.parse(datt);
			LocalDate datenext = LocalDate.parse(house.getDate_end().toString());
			long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore,datenext);
			float s= (house.getPrime()*(365-noOfDaysBetween))/365;
			if (house.getEtatdemande().equals("resiliated")){
				
		
				resiliatebuttom.setVisible(false);
				
			refundAmount.setText(String.valueOf(s));
				refund1.setVisible(true);
				refundAmount.setVisible(true);
				resi.setVisible(true);
				
			}
			
			
			ApparF.setText(String.valueOf(house.getFloorapartment()));
			sinister.setText(String.valueOf(house.getSinisternmbr()));
			Gurantee1.setText(String.valueOf(house.getGuarantee()));

			/*file = new File(house.getImage());
	     
            Image a1 = new Image("http://localhost/images/" +house.getImage()+".jpg");
    		System.out.println(house.getImage());
            image1.setImage(a1);
            image1.setFitHeight(200);
            image1.setFitWidth(250);*/
			String[] array = house.getObjectsinsured().split("\\s", -1);
			for (int i=0; i<array.length+1; i++)
			{
			objectS.setText(array[i]+"  "+array[i+1]+" ");
    }
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    
    
   /* public void setContainer(ContractdetailController container){
        this.container = container;
    }*/
    @FXML
    void Accepte(ActionEvent event) throws Exception {

 
		System.out.println(id1);

    	Test t = new Test();
		Housing house =t.ServicefindContracthouse(id1);
    	
		 house.setEtatdemande("Accepted");
		 t.ServiceUpdateContracthouse(house);
		System.out.println(house.getEtatdemande());
	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operation Successful !");
        alert.setHeaderText("A new Contract saved correctly.");
        alert.setContentText("A new Contract has been saved inside the folder QuickInsuranceContracts");
        alert.showAndWait();
    }

    @FXML
    void Refuse(ActionEvent event) throws Exception {
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operation Successful !");
        alert.setHeaderText("A  Contract Refuse.");
        alert.setContentText("A new Contract has been Refused");
        alert.showAndWait();
    		

    	Test t = new Test();
		Housing house =t.ServicefindContracthouse(id1);
    	
		 house.setEtatdemande("Refuse");
		 t.ServiceUpdateContracthouse(house);
		System.out.println(house.getEtatdemande());

    }

    @FXML
    void calculatePrime(ActionEvent event) throws Exception {
    	
		//Housing house =t.ServicefindContracthouse(id);

    }

    @FXML
    void retourevt(ActionEvent event) throws IOException {

SwitchScreen ss = new SwitchScreen();
    	
    	ss.switchScreen("/views/Contracthousingview.fxml", retour);

    }






	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	} 
    
 /*   public void mapInitialized() {
	 double 	lat =  0 ; //33.8869;
		double lon = 0; // 9.5375 ;
 MapOptions mapOptions = new MapOptions();
 mapOptions.center(new LatLong(lat, lon))
         .mapType(MapTypeIdEnum.ROADMAP)
         .zoom(10);

     map = mapid.createMap(mapOptions, false);
     MarkerOptions markerOptions = new MarkerOptions();
     markerOptions.position(new LatLong(lat, lon))
             .visible(Boolean.TRUE)
             .title("My Marker");
     if (marker == null) {
         marker = new Marker(markerOptions);
         map.addMarker(marker);
     } else {
         map.removeMarker(marker);
         marker = new Marker(markerOptions);
         map.addMarker(marker);
     }}

   geocodingService = new GeocodingService();
    MapOptions mapOptions = new MapOptions();
    
    mapOptions.center(new LatLong(36.8524946, 10.157720799999993))
            .mapType(MapTypeIdEnum.ROADMAP)
            .overviewMapControl(false)
            .panControl(false)
            .rotateControl(false)
            .scaleControl(false)
            .streetViewControl(false)
            .zoomControl(false)
            .zoom(12);
    String adresse = "tunisie";
    map = googlemap.createMap(mapOptions);
    geocodingService.geocode(adresse, (GeocodingResult[] results, GeocoderStatus status) -> {
        
        LatLong latLong = null;
        Marker mark;
       MarkerOptions markerOptions = new MarkerOptions();
        System.out.println(results[0].getFormattedAddress());
        markerOptions.position(  new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude()))
            .visible(Boolean.TRUE)
            .title("My Marker");

        Marker marker = new Marker( markerOptions );

         map.addMarker(marker);
        if( status == GeocoderStatus.ZERO_RESULTS) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
            alert.show();
            return;
        } else if( results.length > 1 ) {
           // Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
            //alert.show();
            latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
        } else {
            latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
        }
        
        map.setCenter(latLong);

    });
    
    
    
}*/
    
	
	  @FXML
	    void printPdfContract(ActionEvent event) throws DocumentException, IOException {	
	    	String f= house.getClient().getFirstName();
	    	String l =house.getClient().getLastName();    	
	    	FileOutputStream file = new FileOutputStream(new File("C:\\Users\\haythem\\Desktop\\Contract\\"+l+f+"Contract.pdf"));
	    	Document document = new Document();
	    	PdfWriter.getInstance(document, file);
	    	document.open();
	   
	    	document.add(new Paragraph(""));
	    	document.add(new Paragraph(""));
	    	document.add(new Paragraph("                                                    House Insurance Contract"));
	    	document.add(new Paragraph("."));
	    	document.add(new Paragraph("."));
	    	document.add(new Paragraph("First Name:    "+house.getClient().getFirstName()));
	    	document.add(new Paragraph("Last Name:     "+house.getClient().getLastName()));
	    	document.add(new Paragraph("CIN number:    "+ house.getClient().getCin()));
	    	document.add(new Paragraph("Adresse:       "+ Address1.getText()));
	    	document.add(new Paragraph("RIB Number:    "+ house.getClient().getRIB_Number()));
	    	
	    	document.add(new Paragraph("Prime value"+Prime.getText()));
	    	document.add(new Paragraph("House value: " + vlaue.getText()));
	    	document.add(new Paragraph("secured objects value: "+ objectV.getText()));
	    	document.add(new Paragraph("Gurantee option: " + Gurantee1.getText()));
	    	document.add(new Paragraph("                          /n"));
	    	document.add(new Paragraph("Signature"));
	    	document.add(new Paragraph("."));
	    	document.close();
	        file.close();
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Operation Successful !");
	        alert.setHeaderText("A new Contract saved correctly.");
	        alert.setContentText("A new Contract has been saved inside the folder QuickInsuranceContracts");
	        alert.showAndWait();
	    }




		public void setContainer(ContractHousingContainerController parentContainer) {
			this.parentContainer = parentContainer;
		}
		
	    @FXML
	    void resiliate(ActionEvent event) throws Exception {
	    	
			java.sql.Date today =java.sql.Date.valueOf(java.time.LocalDate.now());
			String datt = today.toString();
			LocalDate dateBefore = LocalDate.parse(datt);
			LocalDate datenext = LocalDate.parse(house.getDate_end().toString());
			long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore,datenext);
			float s= (house.getPrime()*(365-noOfDaysBetween))/365;
			refundAmount.setText(String.valueOf(s));
	    	Test t = new Test();
			Housing house =t.ServicefindContracthouse(id1);
	    	
			 house.setEtatdemande("resiliated");
			 t.ServiceUpdateContracthouse(house);
			System.out.println(house.getEtatdemande());
		    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Operation Successful !");
	        alert.setHeaderText("A  Contract Resiliated.");
	        alert.setContentText("A Contract has been Resiliated");
	        alert.showAndWait();
	    	
	      
	    	FXMLLoader loader1 = parentContainer.switchViewTo("/views/ContractHousingDetailView.fxml");
	    	((ContractdetailController)loader1.getController()).setContainer(parentContainer);

	    	((ContractdetailController)loader1.getController()).setid(id1);
	    	((ContractdetailController)loader1.getController()).startstage();

	    }
	

}
    
    


