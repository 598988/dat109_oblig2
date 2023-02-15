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
import no.hvl.dat109.loginUtil.LoginUtil;



@Controller
@RequestMapping("/${app.url.pomelding}")
public class PomeldingController {
	
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.pomeldingbekreft}") private String POMBEK_URL;
	
	 @Autowired 
	 private BilUtleieSelskap bus;

	/* 
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@GetMapping
    public String doGet(HttpSession session, RedirectAttributes ra) {
		
		return "pomeldingView";
    }

	/* 
	 * POST /webshop er forespørselen for å handle en/flere varer.
	 */
	@PostMapping
    public String doPost(HttpServletRequest request, RedirectAttributes ra,
    		@RequestParam String fornavn, @RequestParam String etternavn, @RequestParam String mobil,
    		@RequestParam String addresse, @RequestParam String kortnummer, Kunde kunde) {

		kunde = new Kunde(mobil, fornavn, etternavn, addresse, kortnummer);
		
		bus.getKundeRepo().save(kunde);
		
		
		LoginUtil.loggInnBruker(request, kunde);
		
		return "redirect:" + POMBEK_URL;
    }
}
