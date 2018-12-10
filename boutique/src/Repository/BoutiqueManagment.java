package Repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Categorie;
import Model.Produit;

public class BoutiqueManagment {
	private EntityManager em ; //qui remplace $conn Control base de donne/mapping avec base 
	public BoutiqueManagment() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persis");//remplace classform w haka drivermanager
		em=factory.createEntityManager();
	}
	public List<Produit> getAllProduit(){
		em.getTransaction().begin();
		Query q = em.createQuery("select p from Produit p");
		List<Produit> result = q.getResultList();
		em.getTransaction().commit();
		return result;
		
	}
	public List<Categorie> getAllCategorie(){
		em.getTransaction().begin();
		Query q = em.createQuery("select b from Categorie b");
		List<Categorie> result = q.getResultList();
		em.getTransaction().commit();
		return result;
		
	}
	public List<Produit> getProduitByCategorie(int id){
		em.getTransaction().begin();
		Query q = em.createQuery("select p from Produit p where p.categorie.id= :idd");//:idd ce un attribut qui declare et passe en parametre
		q.setParameter("idd", id);
		List<Produit> result = q.getResultList();
		em.getTransaction().commit();
		return result;
		
	}
	public Produit getProduitById(int id) {
		em.getTransaction().begin();
		Produit p = em.find(Produit.class, id);//telewig ken kif yebda we7id bark fi belasit query w requete mete3ina
		em.getTransaction().commit();
		return p ;
	}
}
