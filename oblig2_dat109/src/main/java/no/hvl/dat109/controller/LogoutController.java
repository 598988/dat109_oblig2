package no.hvl.dat109.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.loginUtil.LoginUtil;



@Controller
@RequestMapping("/${app.url.logout}")
public class LogoutController {
	
	@Value("${app.message.loggedOut}") private String LOGGED_OUT_MESSAGE;
	@Value("${app.url.login}") private String LOGIN_URL;
	
	/* 
	 * POST /logout er forespørselen for å logge ut.
	 */
	@PostMapping
    public String loggUt(HttpSession session, RedirectAttributes ra) {
		
		if (LoginUtil.erBrukerInnlogget(session)) {
			LoginUtil.loggUtBruker(session);
		}
   	
		ra.addFlashAttribute("redirectMessage", LOGGED_OUT_MESSAGE);
		return "redirect:" + LOGIN_URL;
    }
}
