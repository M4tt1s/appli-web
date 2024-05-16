package pack;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Singleton
@Path("/")
public class Facade {

	@PersistenceContext
	EntityManager em;
	
	@POST
	@Path("/adduser")
    @Consumes({ "application/json" })
	public void addUtilisateur(Utilisateur u) {
		em.persist(u);
	}
	
	@POST
	@Path("/addpremium")
    @Consumes({ "application/json" })
	public void addPremium(Premium p) {
		em.persist(p);
	}
	
	@POST
	@Path("/adddoc")
    @Consumes({ "application/json" })
	public void addDoc(Documentation d) {
		em.persist(d);
	}
	
	@POST
	@Path("/addresultat")
    @Consumes({ "application/json" })
	public void addResult(Resultat r) {
		em.persist(r);
	}
	
	@POST
	@Path("/addclassement")
    @Consumes({ "application/json" })
	public void addClassement(Classement c) {
		em.persist(c);
	}
	
	@POST
	@Path("/addchallenge")
    @Consumes({ "application/json" })
	public void addChallenge(Challenge c) {
		em.persist(c);
	}
	
	@POST
	@Path("/addmessage")
    @Consumes({ "application/json" })
	public void addMessage(Message m) {
		em.persist(m);
	}
	
	
	// au-dessus sont les fonctions qui permettent d'ajouter un objet à la db
	
	
	
	
	//Page classement.html
	
	@GET
	@Path("/listusers")
    @Produces({ "application/json" })
	public Collection<Utilisateur> listUsers() {
		return em.createQuery("from Utilisateur", Utilisateur.class).getResultList();
	}
	
	@GET
	@Path("/listtop10")
    @Produces({ "application/json" })
	public Collection<Classement> classement() {
		return em.createQuery("from Classement", Classement.class).getResultList();
	}
	
	@GET
	@Path("/listclassementusercourant")
    @Produces({ "application/json" })
	public Classement listUCourantClassement(Utilisateur u) {
		return u.getClassement();
	}
	
	//Fin page classement.html
	
	//Page documentation.html
	
	@GET
	@Path("/listdocu")
    @Produces({ "application/json" })
	public Collection<Documentation> listDocumentations() {
		return em.createQuery("from Documentation", Documentation.class).getResultList();
	}
	
	//Fin page documentation.html
	
	//Page challenge.html concrètement home.html
	
	@GET
	@Path("/listchallenge")
    @Produces({ "application/json" })
	public Collection<Challenge> listChallenges() {
		return em.createQuery("from Challenge", Challenge.class).getResultList();
	}
	
	@POST
	@Path("/addcompresult")
    @Consumes({ "application/json" })
	public Boolean addMessage(String reponse, String titre) {
		Challenge c = (Challenge) em.createQuery("SELECT FROM Challenge WHERE TITRE =" + titre + "", Challenge.class);
		return reponse.equals(c.getReponse());
	}
	
	//Fin page challenge.html
	
	//Page signup.html
	
	//on appelle adduser du top
	
	//Fin page signup.html
	
	//Page signin.html
	
	@POST
	@Path("/addlogin")
    @Consumes({ "application/json" })
	public Boolean verifLogin(String utilisateur, String mdp) {
		Utilisateur u = (Utilisateur) em.createQuery("SELECT FROM Utilisateur WHERE pseudo =" + utilisateur + " AND passwordHash= "+ mdp +"", Utilisateur.class);
		if(u == null) {
			return false;
		}
		u.generateToken(); //faut écrire le code de cette fonction
		return true;
	}
	
	//Fin page signup.html
	
}
