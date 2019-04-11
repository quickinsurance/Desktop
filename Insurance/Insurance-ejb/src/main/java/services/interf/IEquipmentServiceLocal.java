package services.interf;

import java.util.List;

import javax.ejb.Local;

import entities.Contract;
import entities.ContractProperty;
import entities.Equipment;
import entities.User;


@Local
public interface IEquipmentServiceLocal {
	public int addEquipment(ContractProperty c);
	public void removeEquipment(int id);
	public Equipment findEquipmentById(int id);
	public List<Contract> findContractByType(String t,int id);
	public List<ContractProperty> findCProperty(int id);
	public void updateCProperty(ContractProperty p,int id);
	public void removeContract(int id);
	public List<Contract> findMerge(int id ,String d,User u);
	public List<Contract> findContractByValidation(String t,int id);
	public void updateEquipment(String valid,int id);
	public void updateEquipment1(Equipment q,int id);



}
