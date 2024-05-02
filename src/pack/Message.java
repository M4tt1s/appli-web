package pack;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String[] texte;
	private Date date;
	
	@OneToOne
	private Utilisateur utilisateur;
	
	
	public Message() {}
	
	public Message(Date d, String[] t) {
		this.date = d;
		this.texte = t;
	}
	
	public void setDate(Date d) {
		this.date = d;
	}
	
	public void setTexte(String[] t) {
		this.texte = t;
	}
	
	public void setUtilisateur(Utilisateur u) {
		this.utilisateur = u;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String[] getTexte() {
		return this.texte;
	}
	
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
}