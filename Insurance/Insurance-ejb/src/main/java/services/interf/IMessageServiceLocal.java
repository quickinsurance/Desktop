package services.interf;

import java.util.List;

import javax.ejb.Local;

import entities.Messagerie;
import entities.User;


@Local
public interface IMessageServiceLocal {
	public int addMessage(Messagerie msg);
	public void removeMessage(int id);
	public void removeConversation(int id);
	public User findUserById(int id);
	public User findUserByEmail(String email);
	public Messagerie findMessageById(int id);
	public List<Messagerie> findInbox(int id);
	public List<Messagerie> findStarredById(int id);
	public List<Messagerie> findSentById(int id);
	public List<Messagerie> findDraftsById(int id);
	public List<Messagerie> findImportantById(int id);

}
