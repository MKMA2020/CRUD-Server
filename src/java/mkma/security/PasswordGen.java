package mkma.security;

import java.util.Random;

/**
 * Generates a new password.
 * @author Martin Gros
 */
public class PasswordGen {
    
    /**
     * Generates a random password.
     * @return generated password.
     */
    public static String generatePass(){
        
        String password = new Random().ints(10, 33, 122).collect(StringBuilder::new,
        StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        return password;

    }
    
}
