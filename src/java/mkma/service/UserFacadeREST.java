package mkma.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mkma.entity.User;
import mkma.enumeration.UserType;
import security.AlgorithmSHA;

/**
 *
 * @author Aitor Garcia
 */
@Stateless
@Path("user")
public class UserFacadeREST extends AbstractFacade<User> {

    @PersistenceContext(unitName = "mkmaPU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(User entity) {
        //DESENCRIPTAR CONTRASEÑA
        //HASHEAR CONTRASEÑA
        entity.setPassword(AlgorithmSHA.encrypt(entity.getPassword()));
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(User entity) {
        entity.setPassword(AlgorithmSHA.encrypt(entity.getPassword()));
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public User find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Returns a list with all the users.
     *
     * @return List with all the users.
     */
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findAll() {
        return super.findAllUsers();
    }

    /**
     * Returns a list with users of a type.
     *
     * @param type Type of the users.
     * @return List with the searched users.
     */
    @GET
    @Path("type/{type}")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findByType(@PathParam("type") UserType type) {
        return super.findUsersByType(type);
    }

    /**
     * Returns a list of users with a specific name.
     *
     * @param fullName name of the user
     * @return List with the searched users.
     */
    @GET
    @Path("fullName/{fullName}")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findByFN(@PathParam("fullName") String fullName) {
        return super.findUsersByFN(fullName);
    }
    
    /**
     * Returns the user with the specified login
     * @param login login of the user
     * @return the data of the user
     */
    @GET
    @Path("login/{login}")
    @Produces({MediaType.APPLICATION_XML})
    public User login(@PathParam("login") String login) {
        return super.userLogin(login);
    }
}
