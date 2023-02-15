package no.hvl.dat109.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.funksjon.Bil;
import no.hvl.dat109.funksjon.BilUtleieSelskap;
import no.hvl.dat109.funksjon.Kunde;
import no.hvl.dat109.funksjon.Utleie;
import no.hvl.dat109.funksjon.UtleieRepo;
import no.hvl.dat109.funksjon.Utleiekontor;
import no.hvl.dat109.loginUtil.LoginUtil;



@Controller
@RequestMapping("/${app.url.utleie}")
public class UtleieController {
	
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.utleiebekreft}") private String UTLEIEBEK_URL;
	@Value("${app.url.utleie}") private String UTLEIE_URL;
	
	 @Autowired 
	 private BilUtleieSelskap bus;
	

	/* 
	 * GET /hente fram nettsiden av valg av biler, utleiested og retursted, når det skal leies,
	 * eventuelt returernes.
	 */
	@GetMapping
    public String doGet(HttpSession session, RedirectAttributes ra,
    		@RequestParam(name="utleiesteder", required=false) List<Utleiekontor> utleiesteder,
    		@RequestParam(name="biler", required=false) List<Bil> biler) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		utleiesteder = bus.alleKontorer();
		biler = bus.alleBiler();
		
		session.setAttribute("biler", biler);
		session.setAttribute("utleiesteder", utleiesteder);
		Kunde kunde = (Kunde) session.getAttribute("kunde");
		
		System.out.println(bus.getUtleieRepo().existsById(kunde.getMobil()));
		Utleie utleie = bus.getUtleieRepo().getById(kunde.getMobil());
		if(utleie != null) {
		bus.getUtleieRepo().delete(utleie);
		} else {
			
		}
		return "utleieView";
    }

	/* 
	 * POST /leie bil.
	 */
	@PostMapping
    public String doPost(HttpSession session,HttpServletRequest request, RedirectAttributes ra,
    	@RequestParam Integer utleiested_nr,@RequestParam Integer retursted_nr,@RequestParam String datoFra,@RequestParam String tidFra,
    	@RequestParam String datoTil,@RequestParam String tidTil,@RequestParam String regnr) {
		
		String mobil= (String) session.getAttribute("mobil");
		Kunde kunde = bus.getKundeRepo().findById(mobil).orElse(null);
		
		Utleiekontor utleiested = bus.getuRepo().findById(utleiested_nr).orElse(null);
		Utleiekontor retursted = bus.getuRepo().findById(retursted_nr).orElse(null);
		Bil bil = bus.getBilRepo().findById(regnr).orElse(null);
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		if(utleiested.getId()!=bil.getUtleiekontor_id().getId()) {
			ra.addFlashAttribute("redirectMessage", "Velg en bil som tilhører utleiestedet");
			return "redirect:" + UTLEIE_URL;
		}
		
		Utleie save = new Utleie(kunde, utleiested, retursted, datoFra, tidFra, datoTil, tidTil, bil);
		
		bus.getUtleieRepo().save(save);
		
		session.setAttribute("utleie", save);
		
		return "redirect:" + UTLEIEBEK_URL;
    }
}