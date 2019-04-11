package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Contract;
import entities.ContractProperty;
//import entities.ContractProperty;
import entities.Equipment;
import entities.EquipmentQuote;
import entities.Property;
import entities.Quotation;
import entities.User;
import services.interf.IEquipmentServiceLocal;
import services.interf.IEquipmentServiceRemote;

@Stateless
public class ServiceEquiment implements IEquipmentServiceLocal,IEquipmentServiceRemote{
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	

	@Override
	public void removeEquipment(int id) {
		em.remove(em.find(Equipment.class, id));
		
	}

	@Override
	public Equipment findEquipmentById(int id) {
		Equipment c=em.find(Equipment.class, id);
		return c;
	}

	@Override
	public int addEquipment(ContractProperty c) {
		em.persist(c);
		System.out.println("Out of addUser" + c.getEquipment().getContract_id());
		return c.getEquipment().getContract_id();
	}

	@Override
	public List<Contract> findContractByType(String t, int id) {
		javax.persistence.Query query = em.createQuery("select e from ContractProperty e  where e.type_item='" + t + "'",
				ContractProperty.class);
		@SuppressWarnings("unchecked")
		List<ContractProperty> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			for (int i=0;i<list.size();i++)
			{ if (list.get(i).getEquipment().getClient().getId()==id)
			{System.out.println("***");
			List<Contract> q = em.createQuery(
					"select e from Contract e where e.Client='" + id+"' and e.type_contract='"+t+"'",Contract.class).getResultList();
			;
			return q;}}
			return null;
		}
	}

	@Override
	public List<ContractProperty> findCProperty(int id) {
		javax.persistence.Query query = em.createQuery("select e from ContractProperty e  where e.Equipment='" +id+ "'",ContractProperty.class);
		@SuppressWarnings("unchecked")
		List<ContractProperty> list = query.getResultList();		
		return list;
	}

	@Override
	public void updateCProperty(ContractProperty p, int id) {
		int x = em.createQuery("update ContractProperty e set e.Equipment="+id+" where e.id="+p.getId()).executeUpdate();
		
	}

	@Override
	public void removeContract(int id) {
		em.remove(em.find(Equipment.class, id));
		
	}

	@Override
	public List<Contract> findMerge(int id, String d, User u) {
		javax.persistence.Query query = em.createQuery("select e FROM Contract e where e.contract_id!='"+id+"' and e.date_creation='"+d+"' and e.Client='"+u.getId()+"'",
				Contract.class);
		@SuppressWarnings("unchecked")
		List<Contract> list = query.getResultList();		
		return list;
	}

	@Override
	public List<Contract> findContractByValidation(String t, int id) {
		javax.persistence.Query query = em.createQuery("select e from Equipment e  where e.Validation='" + t + "'",
				Equipment.class);
		@SuppressWarnings("unchecked")
		List<Equipment> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {List<Contract> q=new ArrayList<>();
			for (int i=0;i<list.size();i++)
			{
			 q.addAll( em.createQuery(
					"select e from Contract e where e.Agent='" + id+"' and e.contract_id="+list.get(i).getContract_id(),Contract.class).getResultList());
			}			return q;

		}	

	}

	@Override
	public void updateEquipment(String valid, int id) {
		int x = em.createQuery("update Equipment e set e.Validation='"+valid+"' where e.contract_id="+id).executeUpdate();
		
	}

	@Override
	public void updateEquipment1(Equipment q, int id) {
		Contract c=em.find(Contract.class, id);
		int x = em.createQuery("update Contract e set e.commission='"+q.getCommission() +"', e.prime="+q.getPrime()+" where e.contract_id="+id).executeUpdate();	
	}

}
