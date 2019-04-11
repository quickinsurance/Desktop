package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.Contract;
import entities.Guarantee;
import entities.Sinister;


@Remote
public interface IgarantieServiceRemote {

	
	public int addGuarantee(Guarantee gua);
	public void removeGuarantee(int id);
	public void updateGuarantee(Guarantee cn);
	public Guarantee findGuaranteeById(int id);
	
	public List<Guarantee> findAllGurantees();	
	public List<Guarantee> findAllGuranteesbyclient(int id);
	public List<Guarantee> findAllGuranteesbyContract(int id);
	public List<Guarantee> findAllGuranteesbyContractHousing();
	public List<Sinister> findAllsinisters();
}
