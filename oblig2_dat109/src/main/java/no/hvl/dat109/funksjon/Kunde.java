package no.hvl.dat109.funksjon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(schema = "Selskap")
public class Kunde {

	@Id
	private String mobil;
	
	private String fornavn;	
	
	private String etternavn;

	private String addresse;
	
	private String kortnr;
	
	public Kunde() {
		
	}

	public Kunde(String mobil, String fornavn, String etternavn, String addresse, String kortnr) {

		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.addresse = addresse;
		this.kortnr = kortnr;
	}

	public String getMobil() {
		return mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}


	public String getAddresse() {
		return addresse;
	}

	public String getKortnr() {
		return kortnr;
	}

}