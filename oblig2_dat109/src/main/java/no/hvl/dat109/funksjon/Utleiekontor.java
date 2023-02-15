package no.hvl.dat109.funksjon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "Selskap")
public class Utleiekontor{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private String addresse;	
	
	private String telefonnr;

	public Utleiekontor() {
		
	}
	
	public Utleiekontor(String addresse, String telefonnr) {

		this.addresse = addresse;
		this.telefonnr = telefonnr;
	}

	public Integer getId() {
		return id;
	}


	public String getAddresse() {
		return addresse;
	}

	public String getTelefonnr() {
		return telefonnr;
	}

}
