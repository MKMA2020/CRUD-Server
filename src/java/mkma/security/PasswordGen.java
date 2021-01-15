package mkma.security;

import java.util.Random;

/**
 *
 * @author 2dam
 */
public class PasswordGen {
    
    public static String generatePass(){
        
        String password = new Random().ints(10, 33, 122).collect(StringBuilder::new,
        StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        return password;

    }
    
}
