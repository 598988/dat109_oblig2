package no.hvl.dat109.funksjon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(schema = "Selskap")
public class Bil {

	@Id
	private String regnr;
	
	private String merke;	
	
	private String model;

	private String farge;
	
	private String utleiegr;
	
	private boolean erledig;
	
	private String størrelse;
	
	@ManyToOne
    @JoinColumn(name = "utleiekontor_id")
	private Utleiekontor utleiekontor_id;

	
	public Bil() {
		
	}

	public Bil(String regnr, String merke, String model, String farge, String utleiegr, boolean erledig,
			String størrelse, Utleiekontor utleiekontor_id) {
		this.regnr = regnr;
		this.merke = merke;
		this.model = model;
		this.farge = farge;
		this.utleiegr = utleiegr;
		this.erledig = erledig;
		this.størrelse = størrelse;
		this.utleiekontor_id = utleiekontor_id;
	}

	public String getRegnr() {
		return regnr;
	}


	public String getMerke() {
		return merke;
	}

	public String getModel() {
		return model;
	}

	public String getFarge() {
		return farge;
	}

	public String getUtleiegr() {
		return utleiegr;
	}

	public boolean isErledig() {
		return erledig;
	}

	public void setErledig(boolean erledig) {
		this.erledig = erledig;
	}

	public String getStørrelse() {
		return størrelse;
	}

	public Utleiekontor getUtleiekontor_id() {
		return utleiekontor_id;
	}


	


}