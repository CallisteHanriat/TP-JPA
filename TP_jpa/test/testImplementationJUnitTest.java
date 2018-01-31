import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import pojo.Article;
import pojo.Directeur;
import pojo.Magasin;
import pojo.Personne;
import pojo.Vendeur;

public class testImplementationJUnitTest {

	@Test
	public void test() {
		
		//AJOUTER UN DIRECTEUR ET DES VENDEURS
		Directeur directeur = new Directeur("HANRIAT");
		Vendeur vendeur1 = new Vendeur("V1");
		Vendeur vendeur2 = new Vendeur("V2");
		ArrayList<Personne> personnes = new ArrayList<>();
		
		personnes.add(directeur); personnes.add(vendeur1); personnes.add(vendeur2);
		
		//AJOUTER UN ARTICLE
		Article art = new Article();
		Article art2 = new Article();
		art.setNomArticle("topCase");
		art.setPrix(150);
		art2.setNomArticle("Frein");
		art2.setPrix(45);
		vendeur2.addArticle(art);
		vendeur2.addArticle(art2);
		
		
		//CREATION D'UN MAGASIN
		Magasin m = new Magasin();
		m.setMagasinName("DafyMoto");
		m.setPersonnes(personnes);
		
		//TRAITEMENT
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP_jpa");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		//ON AJOUTE TOUS LES OBJETS
		entityManager.persist(m);
		entityManager.persist(directeur);
		entityManager.persist(vendeur1);
		entityManager.persist(vendeur2);
		
		entityManager.persist(art);
		
		Vendeur vendRecup = entityManager.find(Vendeur.class, vendeur2.getId());
		System.out.println("Vendeur " + vendRecup.getName() + " trouvé");
		int total=0;
		for (Article a : vendRecup.getArticles()) {
			System.out.println("Vente de article " + a.getNomArticle() + " au prix de " + a.getPrix());
			total += a.getPrix();
		}
		System.out.println("Vente total de " + vendRecup.getId() + " = " + total);
	}

}
