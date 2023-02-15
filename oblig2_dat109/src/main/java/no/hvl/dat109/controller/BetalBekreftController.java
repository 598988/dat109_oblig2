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

import no.hvl.dat109.funksjon.BilUtleieSelskap;
import no.hvl.dat109.funksjon.Kunde;
import no.hvl.dat109.funksjon.KundeRepo;
import no.hvl.dat109.funksjon.Retur;
import no.hvl.dat109.funksjon.ReturRepo;
import no.hvl.dat109.funksjon.Utleie;
import no.hvl.dat109.loginUtil.LoginUtil;



@Controller
@RequestMapping("/${app.url.betalbekreft}")
public class BetalBekreftController {
	
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.minside}") private String MINSIDE_URL;
	
	 @Autowired 
	 private BilUtleieSelskap bus;
	 //@Autowired 
	 //private ReturRepo returRepo;
	 
	/* 
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@GetMapping
    public String doGet(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		//session.getAttribute("utleie");
		
		return "betalbekreftView";
    }

	/* 
	 * POST /webshop er forespørselen for å handle en/flere varer.
	 */
	@PostMapping
    public String doPost(HttpSession session ,HttpServletRequest request, RedirectAttributes ra) {

		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		Kunde kunde = (Kunde) session.getAttribute("kunde");
		Utleie utleie = bus.getUtleieRepo().getById(kunde.getMobil());
		//Retur retur = returRepo.getById(kunde.getMobil()); 
		Retur retur = bus.getReturRepo().getById(kunde.getMobil());
		bus.getUtleieRepo().delete(utleie);
		//returRepo.delete(retur);
		bus.getReturRepo().delete(retur);
		
		return "redirect:" + MINSIDE_URL;
    }
}