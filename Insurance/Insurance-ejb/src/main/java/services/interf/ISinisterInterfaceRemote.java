package services.interf;

import javax.ejb.Remote;

import entities.Sinister;

@Remote
public interface ISinisterInterfaceRemote {
	public void addSinister(Sinister sinister);

}
