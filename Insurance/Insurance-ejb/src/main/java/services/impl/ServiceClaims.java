package services.impl;


import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Claim;
import services.interf.IClaimServiceLocal;
import services.interf.IClaimsServiceRemote;

@Stateful
public class ServiceClaims implements IClaimServiceLocal, IClaimsServiceRemote {
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;

	@Override
	public int addClaim(Claim c) {
		em.persist(c);
		System.out.println("Out of addUser" + c.getClaim_id());
		return c.getClaim_id();
	}

	@Override
	public void removeClaim(int id) {
		em.remove(em.find(Claim.class, id));
	}

	@Override
	public Claim findClaimById(int id) {
		Claim c=em.find(Claim.class, id);
		return c;
	}

	@Override
	public List<Claim> findClaimsBySubject(String sub) {
		Query query = em.createQuery("select c from Claim c where c.type_subject='"+sub+"'",Claim.class);
	  // query.setParameter("sub", sub);
	    List<Claim> claims = query.getResultList();
		return claims;
		
	}

	@Override
	public List<Claim> FindMatch(String sub,int id) {
		Query query = em.createQuery("select c from Claim c where c.traitement='traite' and c.type_subject='"+sub+"' and c.claim_id!="+id,Claim.class);
		  // query.setParameter("sub", sub);
		    List<Claim> claims = query.getResultList();
			return claims;
	}

	@Override
	public List<Claim> findClaimsByTraitement(String sub) {
		Query query = em.createQuery("select c from Claim c where c.traitement='"+sub+"'",Claim.class);
		    List<Claim> claims = query.getResultList();
			return claims;
	}

	@Override
	public void updateClaim(Claim c, String cc) {
		int x = em.createQuery("update Claim e set e.insurance_response='"+cc+"' , e.traitement='traite' where e.claim_id="+c.getClaim_id()).executeUpdate();
		
	}
	

}
