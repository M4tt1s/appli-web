package pack;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Resultat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@OneToOne
	private Challenge challenge;
	
	private Boolean aReussi;
	
	public Resultat() {}
	
	public Resultat(Boolean b) {
		this.aReussi = b;
	}
	
	public void setBool(Boolean b) {
		this.aReussi = b;
	}
	
	public void setUtilisateur(Utilisateur u) {
		this.utilisateur = u;
	}
	
	public void setChallenge(Challenge c) {
		this.challenge = c;
	}
	
	public Boolean getBool() {
		return this.aReussi;
	}
	
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
	
	public Challenge getChallenge() {
		return this.challenge;
	}
}