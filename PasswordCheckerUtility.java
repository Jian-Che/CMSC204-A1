import java.util.ArrayList;

public class PasswordCheckerUtility {
	public static boolean isValidPassword(String passwordString)throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException 
	{	   
	    if (passwordString.length() < 6) {
            throw new LengthException();
        }
	    for (int i = 0; i < passwordString.length(); i++) {
	        char c = passwordString.charAt(i);
	        
	        if (!Character.isDigit(c)){
	            throw new NoDigitException();
	            
	        }
	        if (!Character.isLowerCase(c)) {
	            throw new NoLowerAlphaException();
	            
	        }
	        if (!Character.isUpperCase(c)) {
	            throw new NoUpperAlphaException();
	        }
	        
	    }
	    for (int i = 0; i < len; i++) {
            if ((i + 1 < len) && (i + 2 < len)) {
                if ((passwordString.charAt(i) == passwordString.charAt(i + 1))
                        && (passwordString.charAt(i + 1) 
                        == passwordString.charAt(i + 2))) {
                            throw new InvalidSequenceException();
                        }
            }
	    }
	    return true;
	}
		
	
	public static boolean isWeakPassword(String password) {
				return (password.length() >= 6 && password.length() <= 9);
	}

	 public static ArrayList<String> validPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPassword = new ArrayList<>();

        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception ex) {
                invalidPassword.add(password + " " + ex.getMessage());
            }
        }

        return invalidPassword;
    }
}
