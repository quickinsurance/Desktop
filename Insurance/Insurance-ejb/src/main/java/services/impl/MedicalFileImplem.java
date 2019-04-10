package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Agent;
import entities.Health;
import entities.MedicalFile;
import services.interf.IMedicalFileRemote;

@Stateless
public class MedicalFileImplem implements IMedicalFileRemote {
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;

	@Override
	public void AddMedicalFile(MedicalFile mfile) {
		em.persist(mfile);
		System.out.println(mfile.toString());

	}

	@Override
	public void updateMedicalFile(MedicalFile mfile) {
		MedicalFile medicalFile = em.find(MedicalFile.class, mfile.getMedicalFile_id());
		medicalFile.setTreated(mfile.isTreated());
		medicalFile.setTotal_refund(mfile.getTotal_refund());
		medicalFile.setType(mfile.getType());

	}

	@Override
	public List<MedicalFile> getMedicalFileByContract(Health health) {
		javax.persistence.Query query = em.createQuery("select e from MedicalFile e where e.Health=:h",
				MedicalFile.class);
		query.setParameter("h", health);
		@SuppressWarnings("unchecked")
		List<MedicalFile> listMedFile = query.getResultList();
		return listMedFile;
	}

	@Override
	public void removeMedicalFile(MedicalFile mfile) {

		em.remove(em.find(MedicalFile.class, mfile.getMedicalFile_id()));

	}

	@Override
	public MedicalFile getMedicalFileByID(int idMedicalFile) {
		javax.persistence.Query query = em.createQuery("select e from MedicalFile e where e.MedicalFile_id=:id",
				MedicalFile.class);
		query.setParameter("id", idMedicalFile);

		return (MedicalFile) query.getSingleResult();
	}

	@Override
	public List<MedicalFile> listMedicalFileByAgent(Agent agent) {
		javax.persistence.Query query = em.createQuery("Select c From  MedicalFile c join c.Health co where co.Agent=:agent and c.treated=:treated", MedicalFile.class);
		query.setParameter("agent", agent);
		query.setParameter("treated", false);
		@SuppressWarnings("unchecked")
		List<MedicalFile> listMedFile = query.getResultList();
		return listMedFile;
	}

}
