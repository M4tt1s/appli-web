package pack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Challenge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="challenge")
	private Collection<Resultat> resultats;
	
	private String titre;
	private String[] text; // Peut-être les mettre dans un fichier et les récupérer à partir d'un parser pour l'initiialisation
	private Integer points;
	private Boolean isPremium;
	private String reponse;
	
	public Challenge() {
	}
	
	public Challenge(String s1, String[] ts2, Integer n) {
		this.titre = s1;
		this.text = ts2;
		this.points = n;
	}
	
	public void setTexte(String[] s) {
		this.text = s;
	}
	
	public void setTitre(String s) {
		this.titre = s;
	}
	
	public void setPoints(Integer n) {
		this.points = n;
	}
	
	public void SetIsPremium(Boolean b) {
		this.isPremium = b;
	}

	public void SetReponse(String rep) {
		this.reponse = rep;
	}

	public void SetResultats(Collection<Resultat> res) {
		this.resultats = res;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public String[] getTexte() {
		return this.text;
	}
	
	public Integer getPoints() {
		return this.points;
	}
	
	public Boolean getIsPremium() {
		return this.isPremium;
	}

	public String getReponse() {
		return this.reponse;
	}

	public Collection<Resultat> getResultats() {
		return this.resultats;
	}
}