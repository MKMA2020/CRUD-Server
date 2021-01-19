package mkma.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SHA encrypt Class.
 * @author Martin Valiente Ainz
 */
public class AlgorithmSHA {

    static final Logger LOG = Logger.getLogger(AlgorithmSHA.class.getName());

    /**
     * Applies SHA to the text parameter.
     *
     * @param text String to digest.
     * @return SHA digested String.
     */
    public static String encrypt(String text) {
      
        MessageDigest messageDigest;
        byte[] bytes = null;
        
        try {
            // Obtén una instancia de MessageDigest que usa SHA
            messageDigest = MessageDigest.getInstance("SHA-1");
            
            // Convierte el texto en un array de bytes
            bytes = text.getBytes();
            
            // Actualiza el MessageDigest con el array de bytes
            messageDigest.update(bytes);
            
            // Calcula el resumen (función digest)
            bytes = messageDigest.digest();
            
            LOG.log(Level.INFO, "ÑamÑamÑam");
        } catch (NoSuchAlgorithmException e) {
            LOG.log(Level.SEVERE, "Specified algorithm does not exist.");
        }
        return Arrays.toString(bytes);
    }

}
