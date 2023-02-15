package no.hvl.dat109.funksjon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class BilUtleieSelskap {
	
	 @Autowired 
	 private UtleiekontorRepo uRepo;
	 @Autowired 
	 private BilRepo bilRepo;
	 @Autowired 
	 private KundeRepo kundeRepo;
	 @Autowired 
	 private UtleieRepo utleieRepo;
	 @Autowired 
	 private ReturRepo returRepo;

	private String navn = "forløpig ingen navn";
	 private String Telefonnumer = "111 00 111";
	 private String addresse = "flesland";
	 
	 private int PrisPerKM= 25;
	
	
	public BilUtleieSelskap() {
		
	}
	
	public List<Bil> alleLedigeBiler(List<Bil> biler){
		biler = bilRepo.findAll();
		List<Bil> ledgieBiler = new ArrayList<Bil>();
		
		for(Bil b: biler) {
			if(b.isErledig()==true) {
				ledgieBiler.add(b);
			}
		}
		return bilRepo.findAll();
	}
	
	public void setBilOpptatt(Bil bil) {
		bil.setErledig(false);
	}
	public void setBilLedig(Bil bil) {
		bil.setErledig(true);
	}
	
	public List<Utleiekontor> alleKontorer(){
		return uRepo.findAll();
	}
	
	public List<Bil> alleBiler(){
		return bilRepo.findAll();
	}
	
	public List<Kunde> allekunde(){
		return kundeRepo.findAll();
	}
	
	 public KundeRepo getKundeRepo() {
		return kundeRepo;
	}

	
	public UtleiekontorRepo getuRepo() {
		return uRepo;
	}

	public BilRepo getBilRepo() {
		return bilRepo;
	}

	public String getNavn() {
		return navn;
	}

	public String getTelefonnumer() {
		return Telefonnumer;
	}
	public String getAddresse() {
		return addresse;
	}

	public UtleieRepo getUtleieRepo() {
		return utleieRepo;
	}
	public int getPrisPerKM() {
		return PrisPerKM;
	}

	public ReturRepo getReturRepo() {
		return returRepo;
	}	
	
}
