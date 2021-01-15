package mkma.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception triggered when the entity already exists.
 *
 * @author Martin Gros
 */
public class RecordExistsException extends Exception {

    public RecordExistsException() {
        final Logger LOG = Logger.getLogger("mkma.enumeration.EntityExistsException.java");
        LOG.log(Level.SEVERE, "This object already exists");
    }
}
