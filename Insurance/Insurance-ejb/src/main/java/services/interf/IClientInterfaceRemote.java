package services.interf;

import javax.ejb.Remote;

import entities.Client;
@Remote
public interface IClientInterfaceRemote {
	public Client getClientByCin(int cin);
	public void addClient(Client client);

}
