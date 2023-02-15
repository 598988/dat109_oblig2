package no.hvl.dat109.controller;


import java.util.List;


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
import no.hvl.dat109.funksjon.Utleie;
import no.hvl.dat109.loginUtil.LoginUtil;



@Controller
@RequestMapping("/${app.url.minside}")
public class MinsideController {
	
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.utleie}") private String UTLEIE_URL;
	@Value("${app.url.retur}") private String RETUR_URL;
	@Value("${app.url.minside}") private String MINSIDE_URL;

	@Autowired 
	 private BilUtleieSelskap bus;
	/* 
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@GetMapping
    public String doGet(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		return "minsideView";
    
	}

	/* 
	 * POST /webshop er forespørselen for å handle en/flere varer.
	 */
	@PostMapping
    public String doPost(@RequestParam String valg, HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		String mobil = (String) session.getAttribute("mobil");
		Utleie utleie = bus.getUtleieRepo().findById(mobil).orElse(null);
		
		if(valg.equals("utleie")) {
			return "redirect:" + UTLEIE_URL;
		}
		if(valg.equals("retur")) {
			if(utleie==null) {
				ra.addFlashAttribute("redirectMessage", "Du må leie en bil for returnere en bil lol");
				return "redirect:" + MINSIDE_URL;
			}
			
			return "redirect:" + RETUR_URL;
		}
		
		return "redirect:" + UTLEIE_URL;
    }
}