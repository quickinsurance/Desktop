package services.interf;


import java.util.List;

import javax.ejb.Local;

import entities.Claim;

@Local
public interface IClaimServiceLocal {
	public int addClaim(Claim c);
	public void removeClaim(int id);
	public Claim findClaimById(int id);
	public List<Claim> findClaimsBySubject(String sub);
	public List<Claim> findClaimsByTraitement(String sub);
	public List<Claim> FindMatch(String sub,int id);
	public void updateClaim(Claim c,String cc);
}
