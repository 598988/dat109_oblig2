package no.hvl.dat109.funksjon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(schema = "Selskap")
public class Retur{

	@Id
	String id;
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "kunde")
	private Kunde kunde;
	
	private String dato;
	
	private String tid;
	

	public Retur() {
		
	}


	public Retur(Kunde kunde, String dato, String tid) {
		super();
		this.kunde = kunde;
		this.dato = dato;
		this.tid = tid;
	}


	public Kunde getKunde() {
		return kunde;
	}

	public String getDato() {
		return dato;
	}

	public String getTid() {
		return tid;
	}

}

