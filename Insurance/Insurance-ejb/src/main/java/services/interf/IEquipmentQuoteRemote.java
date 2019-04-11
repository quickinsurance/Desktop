package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.EquipmentQuote;
import entities.Property;
import entities.Quotation;
import entities.User;


@Remote
public interface IEquipmentQuoteRemote {
	public int addEquipmentQuote(Property c);
	public void addAnotherProperty(Property c,int id);
	public List<Property> findProperty(int id);
	public void removeEquipmentQuote(int id);
	public void removeQuote(int id);
	public int addEquipmentQuote2(EquipmentQuote q);
	public int addEquipmentQuote3(EquipmentQuote q,int id);
	public void updateEquipmentQuote(EquipmentQuote q,int id);
	public EquipmentQuote findEquipmentQuoteById(int id);
	public List<Quotation> findEquipmentQuoteByUser(int id);
	public List<Quotation> findQuoteByType(String t,int id);
	public List<Quotation> findQuoteByTypeAndDate(String t,int id,String d);
	public List<Quotation> findMerge(int id ,String d,User u);
	public void updateProperty(Property p,int id);


}
