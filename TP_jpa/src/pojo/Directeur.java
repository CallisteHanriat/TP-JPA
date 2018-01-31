package pojo;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Directeur extends Personne implements Serializable{
	public Directeur() {
	}
	
	public Directeur(String nom) {
		super(nom);	
	}
}
