package com.capgemini.healthcare.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.healthcare.dto.CustomerRequest;

public class Validations {
	public static boolean idVal(String id)
	{
		try {
			long l = Long.parseLong(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
public static boolean nameVal(String name) {
		
		return ((name != null) && (!name.equals(""))&& (name.matches("^[a-zA-Z]*$")));
	}
	
public static boolean passwordVal(String password) {
	String pwdregex = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
	Pattern pattern = Pattern.compile(pwdregex);
	Matcher matcher = pattern.matcher((CharSequence)password);
	return matcher.matches();
}

public static boolean validateUser(CustomerRequest customerRequest){
if(!Validations.nameVal(customerRequest.getName())) {
return false;
}
if(!Validations.passwordVal(customerRequest.getName())) {
return false;
}

if(!Validations.phonenoVal(customerRequest.getPhoneno())) {
return false;
}

return true;
}

public static boolean phonenoVal(Long phno){
if(phno<1) {return false;}

String Strph = phno+"";

if(Strph.length()>10){return false;}

return true;
}

}
