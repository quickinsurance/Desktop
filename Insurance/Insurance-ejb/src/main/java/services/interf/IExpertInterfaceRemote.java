package services.interf;
import java.util.List;

import javax.ejb.Remote;

import entities.Expert;
@Remote
public interface IExpertInterfaceRemote {

	public List<Expert> getExpertBySpeciality(String speciality);
}
