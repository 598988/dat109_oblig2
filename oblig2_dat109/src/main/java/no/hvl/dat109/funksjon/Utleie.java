package no.hvl.dat109.funksjon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(schema = "Selskap")
public class Utleie{

	
	
	@Id
	private String id;
	


	@MapsId
	@OneToOne
    @JoinColumn(name = "kunde")
	private Kunde kunde;
	
	@OneToOne
    @JoinColumn(name = "utleiested")
	private Utleiekontor utleiested;	
	
	@OneToOne
    @JoinColumn(name = "retursted")
	private Utleiekontor retursted;
	
	private String datofra;
	
	private String tidfra;
	
	private String datotil;
	
	private String tidtil;
	
	@OneToOne
    @JoinColumn(name = "regnr")
	private Bil regnr;

	public Utleie() {
		
	}

	public Utleie(Kunde kunde, Utleiekontor utleiested, Utleiekontor retursted, String datofra, String tidfra,
			String datotil, String tidtil, Bil regnr) {
		super();
		this.kunde = kunde;
		this.utleiested = utleiested;
		this.retursted = retursted;
		this.datofra = datofra;
		this.tidfra = tidfra;
		this.datotil = datotil;
		this.tidtil = tidtil;
		this.regnr = regnr;
	}
	
	public Kunde getKunde() {
		return kunde;
	}

	public Utleiekontor getUtleiested() {
		return utleiested;
	}

	public Utleiekontor getRetursted() {
		return retursted;
	}

	public String getDatofra() {
		return datofra;
	}

	public String getTidfra() {
		return tidfra;
	}

	public String getDatotil() {
		return datotil;
	}

	public String getTidtil() {
		return tidtil;
	}

	public Bil getRegnr() {
		return regnr;
	}

}
