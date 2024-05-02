package pack;

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
	
	@OneToOne
	private Premium premium;
	
	private String titre;
	private String[] text; // Peut-être les mettre dans un fichier et les récupérer à partir d'un parser pour l'initiialisation
	private Integer points;
	
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
	
	public void SetPremium(Premium p) {
		this.premium = p;
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
	
	public Premium getPremium() {
		return this.premium;
	}
}