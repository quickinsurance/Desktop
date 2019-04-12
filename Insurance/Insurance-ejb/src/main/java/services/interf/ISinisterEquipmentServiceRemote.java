package services.interf;
import java.util.List;

import javax.ejb.Remote;

import entities.Contract;
import entities.ContractProperty;
import entities.Equipment;
import entities.Property;
import entities.SinisterEquipment;


@Remote
public interface ISinisterEquipmentServiceRemote {
	public int findNumberSinister(Property p);
	public double MeanSinisterEquipment(Property p);
	public int findNumberSinisterC(ContractProperty p);
	public double MeanSinisterEquipmentC(ContractProperty p);
	public void updateSinsiter(String valid,int id,double pay);
	public SinisterEquipment findSinisterById(int id);
	public List<SinisterEquipment> findSinisterByValidation(String t);

}
