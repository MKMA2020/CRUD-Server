package mkma.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception triggered when the network isn't responding correctly.
 *
 * @author Martin Gros
 */
public class NetworkErrorException extends Exception {

    public NetworkErrorException() {
        final Logger LOG = Logger.getLogger("mkma.enumeration.NetworkErrorException.java");
        LOG.log(Level.SEVERE, "The network is not responding correctly");
    }
}
