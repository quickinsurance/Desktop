package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.HealthQuotation;
import entities.User;

@Remote
public interface IQuotationInterfaceRemote {
public void addHealthQuotation(HealthQuotation healthQuotatin);
public List<HealthQuotation> getQuotations();
public List<HealthQuotation> getQuotationsByUser(User  user);
}
