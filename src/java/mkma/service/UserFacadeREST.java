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
import mkma.exceptions.DatabaseException;

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
    public void create(User entity) throws Throwable {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Long id, User entity) {
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
     * @throws DatabaseException if there is an issue when reading
     */
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findAll() throws DatabaseException {
        return super.findAllUsers();
    }

    /**
     * Returns a list with users of a type.
     *
     * @param type Type of the users.
     * @return List with the searched users.
     * @throws DatabaseException if there is an issue when reading
     */
    @GET
    @Path("type/{type}")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findByType(@PathParam("type") UserType type) throws DatabaseException {
        return super.findUsersByType(type);
    }

    /**
     * Returns a list of users with a specific name.
     *
     * @param fullName name of the user
     * @return List with the searched users.
     * @throws DatabaseException if there is an issue when reading
     */
    @GET
    @Path("fullName/{fullName}")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findByFN(@PathParam("fullName") String fullName) throws DatabaseException {
        return super.findUsersByFN(fullName);
    }
    
    /**
     * Returns the user with the specified login
     * @param login login of the user
     * @param password hashed password of the user
     * @return the data of the user
     */
    @GET
    @Path("login/{login}/{password}")
    @Produces({MediaType.APPLICATION_XML})
    public User login(@PathParam("login") String login, @PathParam("password") String password) {
        return super.userLogin(login, password);
    }
}
