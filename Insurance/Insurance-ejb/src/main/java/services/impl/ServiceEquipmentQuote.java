package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.EquipmentQuote;
import entities.Messagerie;
import entities.Property;
import entities.Quotation;
import entities.User;
import services.interf.IEquipmentQuoteLocal;
import services.interf.IEquipmentQuoteRemote;

@Stateless
public class ServiceEquipmentQuote implements IEquipmentQuoteLocal, IEquipmentQuoteRemote {
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;

	@Override
	public int addEquipmentQuote(Property c) {
		em.persist(c);
		System.out.println("Out of addUser" + c.getId());
		return c.getEquipmentQuote().getQuotation_id();
	}

	@Override
	public void removeEquipmentQuote(int id) {
		em.remove(em.find(Property.class, id));

	}
	
	@Override
	public void removeQuote(int id) {
		em.remove(em.find(EquipmentQuote.class, id));

	}

	@Override
	public EquipmentQuote findEquipmentQuoteById(int id) {
		EquipmentQuote c = em.find(EquipmentQuote.class, id);
		return c;
	}

	@Override
	public void addAnotherProperty(Property c, int id) {
		em.createNativeQuery(
				"INSERT INTO property (EquipmentQuote_Quotation_ID, type_item, item,marque, Model, value, Condition_equipment) VALUES (?, ?, ?, ?, ?, ?, ?)")
				.setParameter(1, id)
				.setParameter(2, c.getType_item().toString())
				.setParameter(3, c.getItem().toString())
				.setParameter(4, c.getMarque().toString())
				.setParameter(5, c.getModel())
				.setParameter(6, c.getValue())
				.setParameter(7, c.getCondition_equipment()).executeUpdate();
	}

	@Override
	public void updateEquipmentQuote(EquipmentQuote q, int id) {
		int x = em.createQuery("update EquipmentQuote e set e.commision="+q.getCommision()+", e.premium="+q.getPremium()+" where e.quotation_id="+id).executeUpdate();

	}

	@Override
	public List<Quotation> findQuoteByType(String type, int id) {
		User u = em.find(User.class, id);
		javax.persistence.Query query = em.createQuery("select e from Property e  where e.type_item='" + type + "'",
				Property.class);
		@SuppressWarnings("unchecked")
		List<Property> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			for (int i=0;i<list.size();i++)
			{ if (list.get(i).getEquipmentQuote().getUser().getId()==id)
			{System.out.println("***");
			List<Quotation> q = em.createQuery(
					"select e from Quotation e where e.User='" + id+"' and e.type_contract='"+type+"'",Quotation.class).getResultList();
			;
			return q;}}
			return null;
		}
	}

	@Override
	public int addEquipmentQuote2(EquipmentQuote q) {
		em.createNativeQuery("INSERT INTO quotation (Creation_date, type_contract, user_id) VALUES (?, ?, ?)")
				.setParameter(1, q.getCreation_date())
				.setParameter(2, "equipment")
				.setParameter(3, q.getUser().getId()).executeUpdate();
		return q.getQuotation_id();
	}
	@Override
	public int addEquipmentQuote3(EquipmentQuote q,int id) {
		
		List<Quotation> k = em.createQuery(
				"select e from Quotation e where e.User=" + id,Quotation.class).getResultList();
		int y=0;
		for (int x=0;x<k.size();x++)
		{y=k.get(x).getQuotation_id();}
		em.createNativeQuery(
				"INSERT INTO equipmentquote (quotation_id, commision, premium) VALUES (?, ?, ?)")
				.setParameter(1, y)
				.setParameter(2, q.getCommision())
				.setParameter(3, q.getPremium())
				.executeUpdate();
		return y;
	}

	@Override
	public List<Quotation> findEquipmentQuoteByUser(int id) {
		List<Quotation> q = em.createQuery("select e from Quotation e where e.User=" + id,Quotation.class).getResultList();
		return q;
	}

	@Override
	public List<Property> findProperty(int id) {
		javax.persistence.Query query = em.createQuery("select e from Property e  where e.EquipmentQuote='" +id+ "'",Property.class);
		@SuppressWarnings("unchecked")
		List<Property> list = query.getResultList();		
		return list;
		}

	@Override
	public List<Quotation> findMerge(int id ,String d,User u) {
		javax.persistence.Query query = em.createQuery("select e FROM Quotation e where e.quotation_id!='"+id+"' and e.creation_date='"+d+"' and e.User='"+u.getId()+"'",
				Quotation.class);
		@SuppressWarnings("unchecked")
		List<Quotation> list = query.getResultList();		
		return list;
	}

	@Override
	public void updateProperty(Property p, int id) {
		int x = em.createQuery("update Property e set e.EquipmentQuote="+id+" where e.id="+p.getId()).executeUpdate();

	}

	@Override
	public List<Quotation> findQuoteByTypeAndDate(String t, int id, String d) {
		User u = em.find(User.class, id);
		javax.persistence.Query query = em.createQuery("select e from Property e  where e.type_item='" + t + "'",
				Property.class);
		@SuppressWarnings("unchecked")
		List<Property> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			for (int i=0;i<list.size();i++)
			{ if (list.get(i).getEquipmentQuote().getUser().getId()==id)
			{System.out.println("***");
			List<Quotation> q = em.createQuery(
					"select e from Quotation e where e.User='" + id+"'and e.creation_date='"+d+"'",Quotation.class).getResultList();
			;
			return q;}}
			return null;
		}
	}
}
