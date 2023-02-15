package no.hvl.dat109.loginUtil;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import no.hvl.dat109.funksjon.Kunde;


public class LoginUtil {
	
	private final static int MAX_INTERACTIVE_INTERVAL = 60;

	public static void loggUtBruker(HttpSession session) {
        session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, Kunde kunde) {
    	
        loggUtBruker(request.getSession());
        String mobil = kunde.getMobil();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("kunde", kunde);
        session.setAttribute("mobil", mobil);
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null 
				&& session.getAttribute("kunde") != null;
	}

}
