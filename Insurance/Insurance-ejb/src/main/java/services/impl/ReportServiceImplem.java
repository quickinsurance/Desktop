package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Report;
import services.interf.IReportInterfaceRemote;
@Stateless
public class ReportServiceImplem implements IReportInterfaceRemote {
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	@Override
	public void addReport(Report report) {
		em.persist(report);

	}

}
