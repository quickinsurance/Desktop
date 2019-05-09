package managedbeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import services.impl.*;
import entities.*;

@ManagedBean(name = "GuranteeBean") 
@SessionScoped
public class GuranteeBean  implements Serializable {
	float primemonth;
	float primemo;
	float startpri;
	int nbrmonth ;
	float startcoff  ;
	String type;
	float virtualpercentage;
	float percentage;
    Date birthdate ;
    Date retirementdate ;
    Date workstart ;
    float Startingprime ;
    float growth ;
    float tmm ;
    String job;
    String kids ;
    float kidscoff;
    String options;
    float refund ;
    float primeend;
    float sommestart ;
    float sommeend ;
	public List<Housing > h1 ;
	public float t ;
	
	HousingContractService HousingContractService ;
	
	GuranteeService GuranteeService ;
	public List<Housing> getContract() {
		List<Housing> h1 =HousingContractService.findHouseContractsbyclient(LoginBean.getInstance().getUser().getCin());
		t =h1.get(0).getPrime();
		/*List<Contract> Contracts  = GuranteeService.findContractbyclient(LoginBean.getInstance().getUser().getCin());*/
		t= h1.get(0).getClient().getId();
		System.out.println(h1.get(0).getClient().getId());
		
		return h1;
	}
	public void calculeretirement(){

	    primeend=0;
		percentage=0;
		refund=0;
		primemo=0;
		startpri=0;
		birthdate= new Date();
		workstart =new Date();
		retirementdate = new Date();
		
	   primemonth=primemo*percentage;
	   Startingprime=startpri*percentage;
	   
	   
	   
	    		LocalDate dateb = LocalDate.parse(birthdate.toString());
	    		LocalDate datew = LocalDate.parse(workstart.toString());
	    		LocalDate today = LocalDate.parse(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
	    		LocalDate dater = LocalDate.parse(retirementdate.toString());

	    		
	    		float noOfYearsBetween = ChronoUnit.YEARS.between(dateb,datew);
	    		float noOfMonthsBetween1 = ChronoUnit.MONTHS.between(datew,today);
	    		float noOfMonthsBetween2 = ChronoUnit.MONTHS.between(today,dater);
	    		
	    		 growth =((primemonth/Startingprime)*100*12)/noOfMonthsBetween1;
	    		 
	    	
	    		
	    		
	    		if (noOfYearsBetween>26){
	    			startcoff =0.9f;
	    		}else{
	    			startcoff = 1;
	    		}
	    		kids="";
	    		if (kids=="yes")
	    		{kidscoff =0.9f;
	    		
	    		}else{
	    			kidscoff=1f;
	    		}
	    		
	    		
	    		virtualpercentage = percentage-((refund/primeend)*100);
	    		
	    		if (refund>primeend){
	    			refund =primeend;
	    			percentage=virtualpercentage;
	    		}
	    		
	    		

	    float i; 
        float f=growth;
        primeend=primemonth; 
for(i=1;i<=noOfMonthsBetween2/12;i++){    
    
	primeend=(primemonth*f)+primeend;    
}  
	    		

 
	    
sommestart = ((primemonth+primeend)*noOfMonthsBetween2)/2;
	    		
	    		
	    float i1; 
float f1=0.08f;
sommeend=sommestart; 
for(i1=1;i<=noOfMonthsBetween2/12;i1++){    

	sommeend=(sommestart*f1)+sommeend;    
}  
    	
float growthsomme =sommeend/sommestart;

		
refund=		(sommestart*kidscoff*startcoff*growthsomme)/noOfMonthsBetween2;
		


		
	}
/*	public void addoptionif() throws Exception{
		Test t = new Test();
		List<Guarantee> guarantees = findgurantees();
		List<Vehicle> Vehicles =findvehiculeContracts();
		Guarantee gu = new Guarantee();
	for(Vehicle s :Vehicles){
if (s.getVehicleOption().equals("All Risks"))
{
	gu.setAmount_franchise(0);
	gu.setAmount_limit(50000);
	gu.setDescription(s.getVehicleOption());
    gu.setCode_guarantee(2);
    gu.setType("vehicle");
    gu.setContract(s);

	System.out.println();
System.out.println(t.findguranteesbyid(s.getContract_id()));
		if ((t.findguranteebyContract((s.getContract_id())).size()==0)){
			System.out.println(t.findguranteebyContract(s.getContract_id()));
			
            ServiceAddGuarantee(gu);
		}
	
		}else if (s.getVehicleOption().equals("Tiers"))
		{	gu.setAmount_franchise(200);
		gu.setAmount_limit(4000);
		gu.setDescription(s.getVehicleOption());
        gu.setCode_guarantee(2);
        gu.setType("vehicle");
        gu.setContract(s);

		System.out.println();
	System.out.println(t.findguranteesbyid(s.getContract_id()));
			if ((t.findguranteebyContract((s.getContract_id())).size()==0)){
				System.out.println(t.findguranteebyContract(s.getContract_id()));
				
                ServiceAddGuarantee(gu);
			}
		
		}else if (s.getVehicleOption().equals("Tiers Etendu"))
		{
			gu.setAmount_franchise(100);
			gu.setAmount_limit(10000);
			gu.setDescription(s.getVehicleOption());
	        gu.setCode_guarantee(2);
	        gu.setType("vehicle");
	        gu.setContract(s);

			System.out.println();
		System.out.println(t.findguranteesbyid(s.getContract_id()));
				if ((t.findguranteebyContract((s.getContract_id())).size()==0)){
					System.out.println(t.findguranteebyContract(s.getContract_id()));
					
                    ServiceAddGuarantee(gu);
				}
		}


			}
		}*/
	
	
	
	
	public GuranteeService getGuranteeService() {
		return GuranteeService;
	}
	public void setGuranteeService(GuranteeService guranteeService) {
		GuranteeService = guranteeService;
	}
	public HousingContractService getHousingContractService() {
		return HousingContractService;
	}
	public void setHousingContractService(HousingContractService housingContractService) {
		HousingContractService = housingContractService;
	}
	public List<Housing> getH1() {
		return h1;
	}
	public void setH1(List<Housing> h1) {
		this.h1 = h1;
	}
	public float getT() {
		return t;
	}
	public void setT(float t) {
		this.t = t;
	} 
	
	
	
	
	
	

}
