package pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Vendeur extends Personne implements Serializable{
	@OneToMany
	private List<Article> articles;

	public Vendeur(List<Article> articles, String nom) {	
		super(nom);
		this.articles = articles;
	}
	
	public void addArticle(Article article) {
		this.articles.add(article);
	}
	
	public void clearArticles() {
		this.articles.clear();
	}
	
	
	private Vendeur () {
		this.articles = new ArrayList<>();
	}
	
	public Vendeur(String string) {
		// TODO Auto-generated constructor stub
		super(string);
		this.articles = new ArrayList<>();
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
}
