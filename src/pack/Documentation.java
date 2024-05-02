package pack;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Documentation {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String titre;
		private String[] text; // Peut-être les mettre dans un fichier et les récupérer à partir d'un parser pour l'initiialisation
		
		public Documentation() {
		}
		
		public Documentation(String s1, String[] ts2) {
			this.titre = s1;
			this.text = ts2;
		}
		
		public void setTexte(String[] s) {
			this.text = s;
		}
		
		public void setTitre(String s) {
			this.titre = s;
		}
		
		public String getTitre() {
			return this.titre;
		}
		
		public String[] getTexte() {
			return this.text;
		}
}