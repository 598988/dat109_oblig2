package no.hvl.dat109.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import no.hvl.dat109.funksjon.Bil;
import no.hvl.dat109.funksjon.BilRepo;
import no.hvl.dat109.funksjon.BilUtleieSelskap;
import no.hvl.dat109.funksjon.Kunde;
import no.hvl.dat109.funksjon.Utleiekontor;
import no.hvl.dat109.funksjon.UtleiekontorRepo;

@Controller
public class testController {

	 //@Autowired 
	  //private UtleiekontorRepo uRepo;
	 //@Autowired 
	 // private BilRepo bilRepo;
	 
	 @Autowired 
	 private BilUtleieSelskap bus;
	
	   @GetMapping(value = "/kontor")
	   @ResponseBody
	    public List<Utleiekontor> utleiekontor() {  
		   	return bus.alleKontorer();
	    	
	    }
	   
	    @GetMapping(value = "/biler")
	    @ResponseBody
	    public List<Bil> biler() {
	    	return bus.alleBiler();
	    }
	    
	    @GetMapping(value = "/kunde")
	    @ResponseBody
	    public List<Kunde> kunder() {
	    	//return bus.allekunde();
	    	return bus.getKundeRepo().findAll();
	    }
	
}
