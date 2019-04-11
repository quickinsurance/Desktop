package services.interf;


import java.util.List;

import javax.ejb.Local;

import entities.Client;
import entities.Contract;



@Local
public interface IcontracthomeServiceLocal{
public int addContracth(Contract cn);
public void removeContracth(int id);
public void updateContracth(Contract cn);
public Contract findContractById(int id);
public List<Contract> findAllContracths();
public List<Contract> findAllContractsbyclient(int id);

}
