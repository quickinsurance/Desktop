package tn.esprit;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import entities.Client;
import entities.Contract;
import entities.Guarantee;
import entities.Housing;
import entities.Sinister;
import entities.User;
import services.interf.IContracthomeServiceRemote;
import services.interf.IgarantieServiceRemote;
import services.interf.IhousingServiceRemote;

public class Test {

	
	public Client client1 ;
	
	
	
	public void addGuaranteeif() throws Exception{
		Test t = new Test();
		List<Guarantee> guarantees = findgurantees();
		List<Housing> housing =findContractsHousing();
		Guarantee gu = new Guarantee();
	for(Housing s :housing){
			
		gu.setAmount_franchise(150);
		gu.setAmount_limit(2000);
		gu.setDescription(s.getGuarantee());
        gu.setCode_guarantee(2);
        gu.setContract(s);
			System.out.println();
		System.out.println(t.findguranteesbyid(s.getContract_id()));
				if ((t.findguranteebyContract((s.getContract_id())).size()==0)){
					System.out.println(t.findguranteebyContract(s.getContract_id()));
					
                    ServiceAddGuarantee(gu);
				}
			}
		}
	
	

	public Contract ServicereturnContract(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/ContractHomeService!services.interf.IContracthomeServiceRemote";
		Context context = new InitialContext();
		IContracthomeServiceRemote proxy = (IContracthomeServiceRemote) context.lookup(jndiName);
		System.out.println("dd");
		Contract cnth = proxy.findContractById(id);
		System.out.println(cnth.getPrime()+""+cnth.getDate_creation());
		System.out.println("cc");
		return cnth ;
	}
	
	public List<Contract> ServicereturnallContract() throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/ContractHomeService!services.interf.IContracthomeServiceRemote";
		Context context = new InitialContext();
		IContracthomeServiceRemote proxy = (IContracthomeServiceRemote) context.lookup(jndiName);
		System.out.println("all");
		List<Contract> cnths = proxy.findAllContracths();
		System.out.println(cnths.size());
		System.out.println("123");
		return cnths ;
	}
	public void ServicedeleteContracth(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/ContractHomeService!services.interf.IContracthomeServiceRemote";
		Context context = new InitialContext();
		IContracthomeServiceRemote proxy = (IContracthomeServiceRemote) context.lookup(jndiName);
		System.out.println("all");
		
		proxy.removeContracth(id);
		System.out.println("done");
	
	}
	public void ServicedeleteContracthouse(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/HousingContractService!services.interf.IhousingServiceRemote";
		Context context = new InitialContext();
		IhousingServiceRemote proxy = (IhousingServiceRemote) context.lookup(jndiName);
		System.out.println("all");
		proxy.removeContracthouse(id);
		
		
	
	}
	public Housing ServicefindContracthouse(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/HousingContractService!services.interf.IhousingServiceRemote";
		Context context = new InitialContext();
		IhousingServiceRemote proxy = (IhousingServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		
		Housing houseC= proxy.findContracthouseById(id);
		
		return houseC ;
	
	}
	public void ServiceUpdateContracthouse(Housing house) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/HousingContractService!services.interf.IhousingServiceRemote";
		Context context = new InitialContext();
		IhousingServiceRemote proxy = (IhousingServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		
		 proxy.updateContracthouse(house);
		
		 
		
	 
	
	}
	public List<Contract> findContractsbyclient() throws Exception
	{	int id = 1;
	Client cl = new Client();
	cl.setId(1);
		String jndiName = "Insurance-ear/Insurance-ejb/ContractHomeService!services.interf.IContracthomeServiceRemote";
		Context context = new InitialContext();
		IContracthomeServiceRemote proxy = (IContracthomeServiceRemote) context.lookup(jndiName);
		System.out.println("one");
	
			
		List<Contract> contracts  =	proxy.findAllContractsbyclient(id);
		return contracts;

	}
	
	public List<Housing> findContractsHousing() throws Exception
	{	
		String jndiName = "Insurance-ear/Insurance-ejb/HousingContractService!services.interf.IhousingServiceRemote";
		Context context = new InitialContext();
		IhousingServiceRemote proxy = (IhousingServiceRemote) context.lookup(jndiName);
		System.out.println("one");
	
			
		List<Housing> contracts  =	proxy.findAllContracthous();
		return contracts;

	}
	
	public void addContract() throws Exception
	{	
	Client cl = new Client();
	Contract c = new Contract();
	c.setCommission(150);
	c.setPrime(150);
	c.setDate_creation(java.sql.Date.valueOf(java.time.LocalDate.now()));
	c.setDate_end(java.sql.Date.valueOf(java.time.LocalDate.now()));
	cl.setId(1);
		String jndiName = "Insurance-ear/Insurance-ejb/ContractHomeService!services.interf.IContracthomeServiceRemote";
		Context context = new InitialContext();
		IContracthomeServiceRemote proxy = (IContracthomeServiceRemote) context.lookup(jndiName);
		System.out.println("one");
	
			
	proxy.addContracth(c);
	


	}
	
	public List<Guarantee> findguranteebyContract(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/GuranteeService!services.interf.IgarantieServiceRemote";
		Context context = new InitialContext();
		IgarantieServiceRemote proxy = (IgarantieServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		List<Guarantee> gurantees  = proxy.findAllGuranteesbyContract(id);
		return gurantees;

	}
	public List<Guarantee> findgurantees() throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/GuranteeService!services.interf.IgarantieServiceRemote";
		Context context = new InitialContext();
		IgarantieServiceRemote proxy = (IgarantieServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		List<Guarantee> gurantees  = proxy.findAllGurantees();
		return gurantees;

	}
	public List<Guarantee> findguranteesbyclient(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/GuranteeService!services.interf.IgarantieServiceRemote";
		Context context = new InitialContext();
		IgarantieServiceRemote proxy = (IgarantieServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		List<Guarantee> gurantees  = proxy.findAllGuranteesbyclient(id);
		System.out.println(gurantees);

		return gurantees;

	}
	public List<Guarantee> findguranteesbyhousingContract() throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/GuranteeService!services.interf.IgarantieServiceRemote";
		Context context = new InitialContext();
		IgarantieServiceRemote proxy = (IgarantieServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		List<Guarantee> gurantees  = proxy.findAllGuranteesbyContractHousing();
		System.out.println(gurantees);

		return gurantees;

	}
	public void ServiceAddHousingContract(Housing house) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/HousingContractService!services.interf.IhousingServiceRemote";
		Context context = new InitialContext();
		IhousingServiceRemote proxy = (IhousingServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		
		 proxy.addContracthouse(house);

	}
	public void ServiceAddGuarantee(Guarantee Guarantee) throws Exception
	
	{
		
		
		String jndiName = "Insurance-ear/Insurance-ejb/GuranteeService!services.interf.IgarantieServiceRemote";
		Context context = new InitialContext();
		IgarantieServiceRemote proxy = (IgarantieServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		
		 proxy.addGuarantee(Guarantee);

	}
	
	public void ServiceAddclient(Client cl) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/HousingContractService!services.interf.IhousingServiceRemote";
		Context context = new InitialContext();
		IhousingServiceRemote proxy = (IhousingServiceRemote) context.lookup(jndiName);
		System.out.println("all");
		proxy.addclient(cl);
	

	}
	
	
	public User Servicegetuser(int cin) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/HousingContractService!services.interf.IhousingServiceRemote";
		Context context = new InitialContext();
		IhousingServiceRemote proxy = (IhousingServiceRemote) context.lookup(jndiName);
		System.out.println("all");
		return proxy.getUserByCIN(cin);

	}
	
	
	public List<Sinister> findsinisters() throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/GuranteeService!services.interf.IgarantieServiceRemote";
		Context context = new InitialContext();
		IgarantieServiceRemote proxy = (IgarantieServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		List<Sinister> gurantees  = proxy.findAllsinisters();
		return gurantees;

	}
	/*public void addhousing() throws Exception
	{	Housing h = new Housing();
	h.setAddress("aa");
	h.setArea("area");
	h.setCodePostal(1550);
	h.setGarage("yes");
	h.setHomemainsec("yes");
	h.setHouseduration("a");
	h.setHouseownertype("yes");
	h.setHousevalue("150");
	h.setSinisternmbr(2);
	h.setType_housing("aa");
	
	
	
	h.setCommission(150);
	h.setPrime(150);
	h.setDate_creation(java.sql.Date.valueOf(java.time.LocalDate.now()));
	h.setDate_end(java.sql.Date.valueOf(java.time.LocalDate.now()));
	
		
		
		
		String jndiName = "Insurance-ear/Insurance-ejb/HousingContractService!interfaces.IhousingServiceRemote";
		Context context = new InitialContext();
		IhousingServiceRemote proxy = (IhousingServiceRemote) context.lookup(jndiName);
		System.out.println("all");
		proxy.addContracthouse(h);
findAllContracthous
	}*/
	
	public Guarantee findguranteesbyid(int id) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/GuranteeService!services.interf.IgarantieServiceRemote";
		Context context = new InitialContext();
		IgarantieServiceRemote proxy = (IgarantieServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		Guarantee gurantee  = proxy.findGuaranteeById(id);
		System.out.println(gurantee);

		return gurantee;

	}
	public void updateGrantie(Guarantee gu ) throws Exception
	{
		String jndiName = "Insurance-ear/Insurance-ejb/GuranteeService!services.interf.IgarantieServiceRemote";
		Context context = new InitialContext();
		IgarantieServiceRemote proxy = (IgarantieServiceRemote) context.lookup(jndiName);
		System.out.println("one");
		proxy.updateGuarantee(gu);
		System.out.println(gu);


	}
	
}
