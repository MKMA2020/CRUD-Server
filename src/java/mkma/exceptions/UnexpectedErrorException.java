package mkma.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception triggered by the server responding unexpectedly.
 *
 * @author Martin Gros
 */
public class UnexpectedErrorException extends Exception {

    public UnexpectedErrorException() {
        final Logger LOG = Logger.getLogger("mkma.enumeration.UnexpectedErrorException.java");
        LOG.log(Level.SEVERE, "Unexpected response from the server");
    }
}
