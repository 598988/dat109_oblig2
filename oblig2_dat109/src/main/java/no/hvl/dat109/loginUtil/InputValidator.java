package no.hvl.dat109.loginUtil;

import no.hvl.dat109.funksjon.Kunde;

public class InputValidator {

    public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
    public static final String THREE_OR_MORE_TIMES = "{3,}";
    public static final String TID = "[0-2]{1}[0-9]{1}[:]{1}[0-5]{1}[0-9]{1}";
    public static final String DATO = "[0-3]{1}[0-9]{1}[,]{1}[0-1]{1}[0-9]{1}[,]{1}[0-9]{4}";

    /**
     * 
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     * 
     * Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
     * er bokstaver (små og store) inkl. de norske bokstavene og tall.
     * Brukernavnet kan ikke begynne med et tall.
     */
    
    public static boolean isValidUser(Kunde kunde) {
    	return kunde!=null;
    }
    
    
    public static boolean isValidDate(String username) {
    	return username != null && username.matches("^" + DATO + "$");
    }
    
    public static boolean isValidTime(String username) {
    	return username != null && username.matches("^" + TID + "$");
    }
    /*
    public static boolean isValidUsername(String username) {
    	return username != null && username.matches("^" + ANY_LETTER
    			+ ANY_LETTER_OR_DIGIT + THREE_OR_MORE_TIMES + "$");
    }
    */
}






