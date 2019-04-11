package services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Claim;
import entities.Contract;
import entities.ContractProperty;
import entities.Equipment;
import entities.Property;
import entities.SinisterEquipment;
import services.interf.ISinisterEquipmentServiceRemote;

@Stateless
public class ServiceSinisterEquipment implements ISinisterEquipmentServiceRemote{
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	@Override
	public int findNumberSinister(Property p) {
        java.sql.Date date2 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		int year=date2.getYear();
		date2= new java.sql.Date((year-2),8,31);
		java.sql.Date date3=new java.sql.Date((year-1),8,31);
		Query query = em.createQuery("select c from ContractProperty c where c.item='"+p.getItem()
				+"' and c.marque='"+p.getMarque()
				+"' and c.Model='"+p.getModel()
				+"' and c.condition_equipment='"+p.getCondition_equipment()
				+"' and c.option_contract='"+p.getOption_quote().toString()
				+"'",ContractProperty.class);
		    List<ContractProperty> list = query.getResultList();
			if (list.isEmpty()) {
				return 0;
			} else {		List<SinisterEquipment> q=new ArrayList();

				int x=0;
				for (int i=0;i<list.size();i++)
				{
					q.addAll(em.createQuery("select e from SinisterEquipment e where e.ContractProperty='"+ list.get(i).getId()+
						"' and (e.date_siniter BETWEEN '"+date2+"' and'"+date3+"')",SinisterEquipment.class).getResultList());
				
				}
				x=x+q.size();
				return x;
			}
	}

	@Override
	public double  MeanSinisterEquipment(Property p) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		int year=date.getYear();
		java.sql.Date date2= new java.sql.Date((year-2),Calendar.DECEMBER,31);
		java.sql.Date date3=new java.sql.Date((year-1),Calendar.DECEMBER,31);
		Query query = em.createQuery("select c from ContractProperty c where c.item='"+p.getItem()
		+"' and c.marque='"+p.getMarque()
		+"' and c.Model='"+p.getModel()
		+"' and c.condition_equipment='"+p.getCondition_equipment()
		+"' and c.option_contract='"+p.getOption_quote().toString()
		+"'",ContractProperty.class);
    List<ContractProperty> list = query.getResultList();
	if (list.isEmpty()) {
		return 0;
	} else {
		List<SinisterEquipment> q=new ArrayList();
		for (int i=0;i<list.size();i++)
		{		

			List<SinisterEquipment> q1=em.createQuery("select e from SinisterEquipment e where e.ContractProperty='"+ list.get(i).getId()+
					"' and (e.date_siniter BETWEEN'"+date2+"' and '"+date3+"')",SinisterEquipment.class).getResultList();
		q.addAll(q1);
		}
		double y=0;
		for (int i=0;i<q.size();i++)
		{
			y=y+q.get(i).getPayement();
		}
		return y/q.size();
	}
	}

	@Override
	public int findNumberSinisterC(ContractProperty p) {
		java.sql.Date date2 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		int year=date2.getYear();
		date2= new java.sql.Date((year-2),8,31);
		java.sql.Date date3=new java.sql.Date((year-1),8,31);
		Query query = em.createQuery("select c from ContractProperty c where c.item='"+p.getItem()
				+"' and c.marque='"+p.getMarque()
				+"' and c.Model='"+p.getModel()
				+"' and c.condition_equipment='"+p.getCondition_equipment()
				+"' and c.option_contract='"+p.getOption_contract().toString()
				+"'",ContractProperty.class);
		    List<ContractProperty> list = query.getResultList();
			if (list.isEmpty()) {
				return 0;
			} else {		List<SinisterEquipment> q=new ArrayList();

				int x=0;
				for (int i=0;i<list.size();i++)
				{
					q.addAll(em.createQuery("select e from SinisterEquipment e where e.ContractProperty='"+ list.get(i).getId()+
						"' and (e.date_siniter BETWEEN '"+date2+"' and'"+date3+"')",SinisterEquipment.class).getResultList());
				
				}
				x=x+q.size();
				return x;
			}
	}

	@Override
	public double MeanSinisterEquipmentC(ContractProperty p) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		int year=date.getYear();
		java.sql.Date date2= new java.sql.Date((year-2),Calendar.DECEMBER,31);
		java.sql.Date date3=new java.sql.Date((year-1),Calendar.DECEMBER,31);
		Query query = em.createQuery("select c from ContractProperty c where c.item='"+p.getItem()
		+"' and c.marque='"+p.getMarque()
		+"' and c.Model='"+p.getModel()
		+"' and c.condition_equipment='"+p.getCondition_equipment()
		+"' and c.option_contract='"+p.getOption_contract().toString()
		+"'",ContractProperty.class);
    List<ContractProperty> list = query.getResultList();
	if (list.isEmpty()) {
		return 0;
	} else {
		List<SinisterEquipment> q=new ArrayList();
		for (int i=0;i<list.size();i++)
		{		

			List<SinisterEquipment> q1=em.createQuery("select e from SinisterEquipment e where e.ContractProperty='"+ list.get(i).getId()+
					"' and (e.date_siniter BETWEEN'"+date2+"' and '"+date3+"')",SinisterEquipment.class).getResultList();
		q.addAll(q1);
		}
		double y=0;
		for (int i=0;i<q.size();i++)
		{
			y=y+q.get(i).getPayement();
		}
		return y/q.size();
	}
	}

	@Override
	public void updateSinsiter(String valid, int id,double pay) {
		int x = em.createQuery("update SinisterEquipment e set e.validation='"+valid+"' , e.payement='"+pay+"' where e.id="+id).executeUpdate();
		
	}

	@Override
	public SinisterEquipment findSinisterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SinisterEquipment> findSinisterByValidation(String t) {
		javax.persistence.Query query = em.createQuery("select e from SinisterEquipment e  where e.validation='" + t + "'",
				SinisterEquipment.class);
		@SuppressWarnings("unchecked")
		List<SinisterEquipment> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list;

		}	

	}

}
