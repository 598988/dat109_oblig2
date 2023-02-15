package no.hvl.dat109.controller;


import javax.servlet.http.HttpServletRequest;

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
import no.hvl.dat109.loginUtil.InputValidator;
import no.hvl.dat109.loginUtil.LoginUtil;

	

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {
	
	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.minside}") private String MINSIDE_URL;
	
	@Autowired 
	 private BilUtleieSelskap bus;
	@Autowired
	KundeRepo kundeRepo;
	/* 
	 * GET /login er forespørselen for å hente login-skjema.
	 */
	@GetMapping
    public String hentLoginSkjema() {
		return "loginView";
    }

	/* 
	 * POST /login er forespørselen for å logge inn.
	 */
	@PostMapping
    public String provAaLoggeInn(@RequestParam String mobil,
    		HttpServletRequest request,	RedirectAttributes ra) {
		
		//Kunde kunde = kundeRepo.findById(mobil).orElse(null);
		Kunde kunde = bus.getKundeRepo().findById(mobil).orElse(null);
		
		if (!InputValidator.isValidUser(kunde)) {
			ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		LoginUtil.loggInnBruker(request, kunde);
		
		return "redirect:" + MINSIDE_URL;
    }
}
