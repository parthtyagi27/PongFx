
package pongfx;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Crypt
{
    public static String key = "Parth123Parth123";
    private static String encryptedString;
    private static String decryptedString;
    
    public static String encrypt(String property, boolean config)
    {
        String configString = "" + config;
        String toBeEncrypted = property + ":" + configString;
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        
        try
        {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encryptedBytes = cipher.doFinal(toBeEncrypted.getBytes());
            encryptedString = new String(encryptedBytes);
            System.out.println(encryptedString);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return encryptedString;
    }
    
    
    public static String decrypt(String encryptedString)
    {
        
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        
        try
        {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decryptedBytes = cipher.doFinal(encryptedString.getBytes());
            decryptedString = new String(decryptedBytes);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return decryptedString;
    }
}
