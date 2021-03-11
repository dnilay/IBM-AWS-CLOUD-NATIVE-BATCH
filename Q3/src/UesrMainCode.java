
public class UesrMainCode {
	public static boolean validatePassword(String password)
	  {
	    boolean valid=true;
	    int i;
	    //Insert code here to check for valid password
	    int len=password.length();
	    if(len>=8)
	    {
	    	for(i=0;i<len;i++)
	    	{
	    		char ch=password.charAt(i);
	    		if(Character.isLowerCase(ch))
	    			break;
	    	}
	    	if(i>8)
	    		return false;
	    	
	    	for(i=0;i<len;i++)
	    	{
	    		char ch=password.charAt(i);
	    		if(Character.isUpperCase(ch))
	    			break;
	    	}
	    	if(i>8)
	    		return false;
	    	
	    	for(i=0;i<len;i++)
	    	{
	    		char ch=password.charAt(i);
	    		if(Character.isDigit(ch))
	    			break;
	    	}
	    	if(i>8)
	    		return false;
	    	for(i=0;i<len;i++)
	    	{
	    		char ch=password.charAt(i);
	    		if(!Character.isDigit(ch) && !Character.isLowerCase(ch) && !Character.isUpperCase(ch)  )
	    			break;
	    	}
	    	if(i>8)
	    		return false;
	    	if(password.contains(" "))
	    		return false;
	    	
	    	
	    }
	    return valid;
	  }

}
