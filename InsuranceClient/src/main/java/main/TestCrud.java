package main;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Accident;
import entities.Agent;
import entities.Client;
import entities.Expert;
import services.interf.IAccidentInterfaceRemote;

public class TestCrud {

	public static void main(String[] args) throws NamingException {
		String jndiName = "Insurance-ear/Insurance-ejb/AccidentServiceImplem!services.interf.IAccidentInterfaceRemote";
		Context context = new InitialContext();
		IAccidentInterfaceRemote proxy = (IAccidentInterfaceRemote)context.lookup(jndiName);
		Client client = new Client();
		client.setId(2);
	
	//System.out.println(proxy.getUserByCIN(58967412).toString());
		Agent agent =new Agent();
		agent.setId(2);
		Expert expert = new Expert();
		expert.setId(15);
	    List<Accident> healths =proxy.getListAccidentNOtTreatedByExpert(expert);
	    for( Accident h : healths){
	    	System.out.println(h.getType_contract());
	    
	    ///	System.out.println(h.getHealth().getClient().toString());
	    	//String s =h.getOptions();
	    /*	String[] parts = s.trim().split(",");
	    	for(String t :parts){
	    		System.out.println(t);
	    	}*/
	    }
		/*User u = new User();
		u.setFirstName("Rim");
		u.setLastName("Garaali");
		u.setBirthDate(Date.valueOf(LocalDate.of(1995, 12, 12)));
		u.setCin(Integer.parseInt("25874169"));
		u.setEmail("asma.garaali@gmail.com");
		u.setFamily_situation("Single");
		u.setGender("women");
		u.setPhone(54378390);
		u.setSalary(5000);
		proxy.addUser(u);*/
	/*	String jndiNameQotation = "Insurance-ear/Insurance-ejb/HealthQuotationServiceImlem!services.interf.IQuotationInterfaceRemote";
		Context contextQuotation;
		contextQuotation = new InitialContext();
		IQuotationInterfaceRemote proxyQotation = (IQuotationInterfaceRemote) contextQuotation.lookup(jndiNameQotation);
		HealthQuotation quotation = new HealthQuotation();

		quotation.setCommission(300);
		quotation.setCreation_date(Date.valueOf(LocalDate.now()));
		quotation.setPrime(500);
		quotation.setType_contract(type_contract.health);
		quotation.setUser(proxy.getUserByCIN(Integer.parseInt("09788146")));
		quotation.setAlcohol("no");
		quotation.setSmoke("no");
		quotation.setGeneral_health("good");
		quotation.setDangerous_sport("no");
		quotation.setChronic_health("no");
		quotation.setOptions("optical");
		System.out.println(quotation.toString());
		proxyQotation.addHealthQuotation(quotation);*/
	}

}
