package no.hvl.dat109.controller;


import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.loginUtil.LoginUtil;



@Controller
@RequestMapping("/${app.url.start}")
public class StartController {
	
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.pomelding}") private String POMELDING_URL;

	/* 
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@GetMapping
    public String doGet(HttpSession session, RedirectAttributes ra) {
		
		return "startView";
    
	}

	/* 
	 * POST /webshop er forespørselen for å handle en/flere varer.
	 */
	@PostMapping
    public String doPost(@RequestParam String medlem, HttpSession session, RedirectAttributes ra) {
		
		if(medlem.equals("meld inn")) {
			return "redirect:" + POMELDING_URL;
		}
		if(medlem.equals("logg inn")) {
			return "redirect:" + LOGIN_URL;
		}
		
		return "redirect:" + POMELDING_URL;
    }
}
