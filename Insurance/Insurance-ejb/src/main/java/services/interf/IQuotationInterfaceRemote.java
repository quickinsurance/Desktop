package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.HealthQuotation;

@Remote
public interface IQuotationInterfaceRemote {
public void addHealthQuotation(HealthQuotation healthQuotatin);
public List<HealthQuotation> getQuotations();
}
