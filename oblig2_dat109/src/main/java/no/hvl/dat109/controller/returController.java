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
import no.hvl.dat109.funksjon.KundeRepo;
import no.hvl.dat109.funksjon.Retur;
import no.hvl.dat109.funksjon.ReturRepo;
import no.hvl.dat109.funksjon.Utleie;
import no.hvl.dat109.funksjon.UtleieRepo;
import no.hvl.dat109.funksjon.Utleiekontor;
import no.hvl.dat109.loginUtil.LoginUtil;



@Controller
@RequestMapping("/${app.url.retur}")
public class returController {
	
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.betalretur}") private String BETAL_URL;
	
	 @Autowired 
	 private BilUtleieSelskap bus;
	 @Autowired 
	 private ReturRepo returRepo;

	/* 
	 * GET /hente fram nettsiden av valg av biler, utleiested og retursted, når det skal leies,
	 * eventuelt returernes.
	 */
	@GetMapping
    public String doGet(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		Kunde kunde = (Kunde) session.getAttribute("kunde");
		System.out.println(bus.getReturRepo().existsById(kunde.getMobil()));

		Retur retur = bus.getReturRepo().findById(kunde.getMobil()).orElse(null);

		if(retur != null) {
		bus.getReturRepo().delete(retur);
		} else {
					
		}
		Utleie utleie = bus.getUtleieRepo().findById(kunde.getMobil()).orElse(null);
		System.out.println( bus.getUtleieRepo().existsById(kunde.getMobil()));
		if(utleie !=null) {
			session.setAttribute("utleie", utleie);
		} else {
			
		}

		return "returView";
    }

	/* 
	 * POST /leie bil.
	 */
	@PostMapping
    public String doPost(HttpSession session,HttpServletRequest request, RedirectAttributes ra,
    	@RequestParam String dato, @RequestParam String tid, @RequestParam int kiloMeter) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		
		String mobil = (String) session.getAttribute("mobil");
		Kunde kunde = bus.getKundeRepo().findById(mobil).orElse(null);
		
		Retur retur = new Retur(kunde, dato, tid);
		
		bus.getReturRepo().save(retur);
		int totalPris = kiloMeter * bus.getPrisPerKM();
		
		session.setAttribute("retur", retur);
		session.setAttribute("total", totalPris);
		session.setAttribute("kiloMeter", kiloMeter);
		
		return "redirect:" + BETAL_URL;
    }
}
