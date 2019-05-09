package managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="vehicleScoringBean")
@SessionScoped
public class VehicleScoringBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String mark;
	private int sinisterNumber;
	private float vehicleValue;
	private int vehicleAge;
	private int vehicleFinalValue;
	
	public VehicleScoringBean(){}
	
	
	public int scoringVehicle(){
		VehicleScoringBean vb = new VehicleScoringBean();
		
    	float BmwValue = 264220f;
    	float AudiValue = 93090f;
    	float FiatValue = 49085f;
    	float VolkswagenValue=54090f;
    	float KiaValue=29080f;
    	float NissanValue=39099f;
    	float MiniCooperValue=107290f;
    	float CitroenValue=45260f;
    	float ToyotaValue=43850f;
    	float DaciaValue=43950f;
    	float RenaultValue=41920f;
    	
    	
    	//BMW
    	
    	if(mark.equals("BMW")){
    		if(sinisterNumber==0){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.92);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.91);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.90);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.85);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.77);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}}
        	
        	else if(sinisterNumber==1){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.90);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.87);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.85);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.79);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.77);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.75);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.72);
        			}}
        	
        		else if(sinisterNumber==2){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.79);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.77);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.75);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.73);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.71);
        			}}
        	
        		else if(sinisterNumber==3){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.86);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.84);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.82);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.80);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.77);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.75);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.73);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.71);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.69);
            			}}
        	
        		else if(sinisterNumber==4){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.84);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.82);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.80);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.77);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.75);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.73);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.71);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.69);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.67);
            			}}
    		
    
    		
    		
    		
    		
    //CITROEN	
    		
        		else if(mark.equals("CITROEN")){
        		if(sinisterNumber==0){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.925);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.912);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.904);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.892);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.852);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.84);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.82);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.80);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.77);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			}}
            	
            	else if(sinisterNumber==1){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.90);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.89);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.87);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.85);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.77);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.75);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			}}
            	
            		else if(sinisterNumber==2){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.88);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.86);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.84);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.82);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.77);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.75);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.73);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.71);
            			}}
            	
            		else if(sinisterNumber==3){
                		
                		if(vehicleAge==1){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.86);}
                		
                		else if (vehicleAge==2){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.84);
                			}
                		else if (vehicleAge==3){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.82);
                			}
                		else if (vehicleAge==4){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.80);
                			}
                		else if (vehicleAge==5){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.79);
                			}
                		else if (vehicleAge==6){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.77);
                			}
                		
                		else if (vehicleAge==7){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.75);
                			
                			}
                		else if (vehicleAge==8){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.73);
                			}
                		else if (vehicleAge==9){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.71);
                			}
                		
                		else if (vehicleAge==10){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.69);
                			}}
            	
            		else if(sinisterNumber==4){
                		
                		if(vehicleAge==1){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.84);}
                		
                		else if (vehicleAge==2){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.82);
                			}
                		else if (vehicleAge==3){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.80);
                			}
                		else if (vehicleAge==4){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.79);
                			}
                		else if (vehicleAge==5){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.77);
                			}
                		else if (vehicleAge==6){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.75);
                			}
                		
                		else if (vehicleAge==7){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.73);
                			
                			}
                		else if (vehicleAge==8){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.71);
                			}
                		else if (vehicleAge==9){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.69);
                			}
                		
                		else if (vehicleAge==10){
                			
                			vehicleFinalValue=(int) (vehicleValue*0.67);
                			}}
    	                }}
    	
    	
    	//TOYOTA
    	
    	else if(mark.equals("TOYOTA")){
    		if(sinisterNumber==0){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.91);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.90);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.87);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.79);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.77);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.75);
        			}}
        	
        	else if(sinisterNumber==1){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.73);
        			}}
        	
        		else if(sinisterNumber==2){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.87);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.85);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.72);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.70);
        			}}
        	
        		else if(sinisterNumber==3){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.85);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.70);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.68);
            			}}
        	
        		else if(sinisterNumber==4){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.70);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.68);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.66);
            			}}
	                }
    	
	//AUDI
    	
    	else if(mark.equals("AUDI")){
    		if(sinisterNumber==0){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.904);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.902);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.879);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.846);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.75);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}}
        	
        	else if(sinisterNumber==1){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.79);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.77);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.73);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.72);
        			}}
        	
        		else if(sinisterNumber==2){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.79);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.77);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.75);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.73);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.71);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.69);
        			}}
        	
        		else if(sinisterNumber==3){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.84);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.82);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.80);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.77);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.75);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.73);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.71);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.69);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.67);
            			}}
        	
        		else if(sinisterNumber==4){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.82);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.80);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.77);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.75);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.73);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.71);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.69);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.67);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.65);
            			}}
	                }
    	
    	
    	
    //MINI COOPER
    	
    	else if(mark.equals("MINI COOPER")){
    		if(sinisterNumber==0){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.91);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.90);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.79);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.73);
        			}}
        	
        	else if(sinisterNumber==1){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.87);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.71);
        			}}
        	
        		else if(sinisterNumber==2){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.85);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.72);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.70);
        			}}
        	
        		else if(sinisterNumber==3){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.85);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.70);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.67);
            			}}
        	
        		else if(sinisterNumber==4){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.70);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.68);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.66);
            			}}
	                }
    	
    	
    	
    	//FIAT
    	
    	else if(mark.equals("FIAT")){
    		if(sinisterNumber==0){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.91);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.90);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.79);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.73);
        			}}
        	
        	else if(sinisterNumber==1){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.71);
        			}}
        	
        		else if(sinisterNumber==2){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.87);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.85);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.72);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.70);
        			}}
        	
        		else if(sinisterNumber==3){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.85);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.70);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.68);
            			}}
        	
        		else if(sinisterNumber==4){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.70);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.68);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.66);
            			}}
	                }
    	
    	//RENAULT
    	
    	else if(mark.equals("RENAULT")){
    		if(sinisterNumber==0){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.90);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.87);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.79);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.75);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.72);
        			}}
        	
        	else if(sinisterNumber==1){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.87);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.71);
        			}}
    		
        	
        		else if(sinisterNumber==2){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.87);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.85);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.72);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.70);
        			}}
        	
        		else if(sinisterNumber==3){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.85);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.70);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.68);
            			}}
        	
        		else if(sinisterNumber==4){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.70);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.68);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.66);
            			}}
	                }
    	
    	
    	//KIA
    	
    	else if(mark.equals("KIA")){
    		if(sinisterNumber==0){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.91);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.90);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.79);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.73);
        			}}
        	
        	else if(sinisterNumber==1){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.89);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.88);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.86);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.84);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.82);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			}
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.71);
        			}}
        	
        		else if(sinisterNumber==2){
        		
        		if(vehicleAge==1){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.87);}
        		
        		else if (vehicleAge==2){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.85);
        			}
        		else if (vehicleAge==3){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.83);
        			}
        		else if (vehicleAge==4){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.81);
        			}
        		else if (vehicleAge==5){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.80);
        			}
        		else if (vehicleAge==6){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.78);
        			}
        		
        		else if (vehicleAge==7){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.76);
        			
        			}
        		else if (vehicleAge==8){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.74);
        			}
        		
        		else if (vehicleAge==9){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.72);
        			}
        		
        		else if (vehicleAge==10){
        			
        			vehicleFinalValue=(int) (vehicleValue*0.70);
        			}}
        	
        		else if(sinisterNumber==3){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.85);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.74);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.70);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.68);
            			}}
        	
        		else if(sinisterNumber==4){
            		
            		if(vehicleAge==1){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.83);}
            		
            		else if (vehicleAge==2){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.81);
            			}
            		else if (vehicleAge==3){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.79);
            			}
            		else if (vehicleAge==4){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.78);
            			}
            		else if (vehicleAge==5){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.76);
            			}
            		else if (vehicleAge==6){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.75);
            			}
            		
            		else if (vehicleAge==7){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.72);
            			
            			}
            		else if (vehicleAge==8){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.71);
            			}
            		else if (vehicleAge==9){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.64);
            			}
            		
            		else if (vehicleAge==10){
            			
            			vehicleFinalValue=(int) (vehicleValue*0.62);
            			}}
    		
    		
    		
	                }
    	
    	
    	
    		return vehicleFinalValue;
			}


	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}


	public int getSinisterNumber() {
		return sinisterNumber;
	}


	public void setSinisterNumber(int sinisterNumber) {
		this.sinisterNumber = sinisterNumber;
	}


	public float getVehicleValue() {
		return vehicleValue;
	}


	public void setVehicleValue(float vehicleValue) {
		this.vehicleValue = vehicleValue;
	}


	public int getVehicleAge() {
		return vehicleAge;
	}


	public void setVehicleAge(int vehicleAge) {
		this.vehicleAge = vehicleAge;
	}


	public int getVehicleFinalValue() {
		return vehicleFinalValue;
	}


	public void setVehicleFinalValue(int vehicleFinalValue) {
		this.vehicleFinalValue = vehicleFinalValue;
	}
}
