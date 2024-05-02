package pack;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Classement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private Integer position;
	
	@OneToOne
	private Utilisateur utilisateur;
	
	
	public Classement() {}
	
	public Classement(Integer pos) {
		this.position = pos;
	}
	
	public void setPosition(Integer pos) {
		this.position = pos;
	}
	
	public void setUtilisateur(Utilisateur u) {
		this.utilisateur = u;
	}
	
	public Integer getPosition() {
		return this.position;
	}
	
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
}