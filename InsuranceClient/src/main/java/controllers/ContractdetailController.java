package controllers;

import java.util.ResourceBundle;

import entities.Contract;
import entities.Housing;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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
	    private Button retour;
	    
	    @FXML
	    private Button AccepteButton;

	    @FXML
	    private Button refuseButton;
	    
	    File file ;
	    Test t = new Test();
	    
	


	private int id1;
	 
	 
	 //int id = house1.getContract_id();
	
	 
	public void setid(int id) {

		this.id1=id;
		

	}
	 


    
    public void startstage(){
    	System.out.println(id1+1);
    	ApparF.setVisible(false);
    	floor.setVisible(false);
		AccepteButton.setVisible(false);
		refuseButton.setVisible(false);
    
    	

    	
    try {
    	
    	
    	

    		

			Housing house =t.ServicefindContracthouse(id1);
			
			
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

		    	AccepteButton.setVisible(true);
				refuseButton.setVisible(true);
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
    }

    @FXML
    void Refuse(ActionEvent event) throws Exception {
       
  	
    		

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
    

}
    
    


