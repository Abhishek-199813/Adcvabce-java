package cdac.webprojectday2;

public class checkDuplicateEmail {
	public boolean emailCheck(String emailcounter, String email) {
		if(emailcounter.equals(email))
			return true;
		else
			return false;
	}
}
