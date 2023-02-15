package no.hvl.dat109.loginUtil;

public class test {
	
	 public static void main(String[] args) {

		
		
		String tid ="21:59";
		String dato= "31,11,2004";
		
		System.out.println(InputValidator.isValidDate(dato));
		System.out.println(InputValidator.isValidTime(tid));
		

	}

}
