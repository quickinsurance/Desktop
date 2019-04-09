package services.interf;

import javax.ejb.Remote;

import entities.Report;
@Remote
public interface IReportInterfaceRemote {

	public void addReport(Report report);
}
