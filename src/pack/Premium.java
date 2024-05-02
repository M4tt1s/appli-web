package pack;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Premium {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	public Premium(){}
	
	public Premium(String s) {
		this.code = s;
	}
	
	public void setCode(String s) {
		this.code = s;
	}
	
	public String getCode(){
		return this.code;
	}	
}