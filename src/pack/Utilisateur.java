package pack;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pseudo;
	private String mail;
	private String passwordHash;
	
	@OneToOne
	private Premium premium;

	@OneToMany(mappedBy="utilisateur")
	private Collection<Resultat> resultats;
	
	public Utilisateur() {}
	
	public Utilisateur(String s1, String s2, String s3) {
		this.pseudo = s1;
		this.mail = s2;
		this.passwordHash = s3;
	}
	
	public void setPseudo(String s) {
		this.pseudo = s;
	}
	
	public void setMail(String s) {
		this.mail = s;
	}
	
	public void setPasswordHash(String s) {
		this.passwordHash = s;
	}
	
	public void SetPremium(Premium p) {
		this.premium = p;
	}

	public void SetResultat(Collection<Resultat> res) {
		this.resultats = res;
	}
	
	public String getPseudo() {
		return this.pseudo;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public String getPasswordHash() {
		return this.passwordHash;
	}
	
	public Premium getPremium() {
		return this.premium;
	}

	public Collection<Resultat> getResultats() {
		return this.resultats;
	}
}