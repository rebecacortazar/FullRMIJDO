package es.deusto.server.jdo;

import java.util.Set;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.util.HashSet;

@PersistenceCapable (detachable = "true")
public class User {
	@PrimaryKey
	String login=null;
	String password=null;
	Set<Message> messages = new HashSet<Message>();

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}

	public void removeMessage(Message message) {
		messages.remove(message);
	}

	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	 public Set<Message> getMessages() {return this.messages;}
	 
	 public String toString() {
		StringBuffer messagesStr = new StringBuffer();
		for (Message message: this.messages) {
			messagesStr.append(message.toString() + " - ");
		}
        return "User: login --> " + this.login + ", password -->  " + this.password + ", messages --> [" + messagesStr + "]";
    }
}

