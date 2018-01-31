package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Magasin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="magasinName")
	private String magasinName;
	@OneToMany
	private List<Personne> personnes;
	@OneToMany
	private List<Article> articles;
	
	public Magasin() {
		this.personnes = new ArrayList<Personne>();
		this.articles = new ArrayList<Article>();
	}
	public Magasin(Integer id, String magasinName, List<Personne> personnes, List<Article> articles) {
		super();
		this.id = id;
		this.magasinName = magasinName;
		this.personnes = personnes;
		this.articles = articles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMagasinName() {
		return magasinName;
	}
	public void setMagasinName(String magasinName) {
		this.magasinName = magasinName;
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
}
