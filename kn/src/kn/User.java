package kn;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class User implements ToCSVable
{
	private String Password;
	private String LoginName; 
 
	
	public User(String firstName, String password)
    {
		LoginName = firstName;
        SetPassword(password);
    }
	
	/**
	 * Added to gain ability of using string.split(",") on database file
	 * @param data array of strings
	 */
	public User(String[] data)
    {
		LoginName = data[0];
        Password = data[1];
    }
	
    /**
     * Creates password and check if it's strong enough
     * @param password
     */
    public void SetPassword(String password)
    {
    	Encoder encoder = Base64.getEncoder();
    	byte[] b = new byte[] {23,32};
        
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), b, 10000, 256);
        Arrays.fill(password.toCharArray(), Character.MIN_VALUE);
        
        try 
        {
          SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
          Password = encoder.encodeToString(skf.generateSecret(spec).getEncoded());
        } 
        
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) 
        {
          throw new AssertionError("B³¹d podczas hashowania has³a: " + e.getMessage(), e);
        } 
        
        finally 
        {
          spec.clearPassword();
        }
    }
    
	/**
	 * Splits all variables into string
	 */
	public String ToCSV()
	{
		return GetLoginName() + "," + GetPassword();
	}
	
    public String GetLoginName()
    {
    	return LoginName;    	
    }
    
    public String GetPassword()
    {
    	return Password;
    }
    
}
