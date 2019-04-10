package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.Agent;
import entities.Health;
import entities.MedicalFile;

@Remote
public interface IMedicalFileRemote {
public void AddMedicalFile(MedicalFile mfile);
public void updateMedicalFile(MedicalFile mfile);
public List<MedicalFile> getMedicalFileByContract(Health health);
public void removeMedicalFile(MedicalFile mfile);
public MedicalFile getMedicalFileByID(int idMedicalFile);
public List<MedicalFile> listMedicalFileByAgent(Agent agent);
}
