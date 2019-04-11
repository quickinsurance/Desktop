package services.interf;

import java.util.List;

import javax.ejb.Local;

import entities.Client;
import entities.Housing;
import entities.User;


@Local
public interface IhousingServiceLocal {
	public int addContracthouse(Housing cn);
	public void removeContracthouse(int id);
	public void updateContracthouse(Housing cn);
	public Housing findContracthouseById(int id);
	public List<Housing> findAllContracthous();
	public List<Housing> findHouseContractsbyclient(int id);
	public int addclient(Client cl);
	public User getUserByCIN(int cin);
}
