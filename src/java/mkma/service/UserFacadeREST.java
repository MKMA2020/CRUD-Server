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

/**
 * Auto-generated REST for the class User.
 * @author Aitor
 */
@Stateless
@Path("mkma.entity.user")
public class UserFacadeREST extends AbstractFacade<User> {

    @PersistenceContext(unitName = "mkmaPU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

    /**
     * Creates a new user.
     * @param entity User to be created.
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(User entity) {
        super.create(entity);
    }

    /**
     * Edit a new user.
     * @param entity User to be edited.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(User entity) {
        super.edit(entity);
    }

    /**
     * Remove an existing user.
     * @param id of the searched user.
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    /**
     * Find an existing user.
     * @param id of the searched user.
     * @return 
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public User find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * Returns entity manager.
     * @return Entity manager.
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Returns a function from AbstractFacade when the path is all.
     * @return findAllUsers: a list of all users
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> findAllUsers(){
        return super.findAllUsers();
    }
    
    /**
     * Returns a function from AbstractFacade with.
     * @return findAllUsers: a list of all premium users.
     */
    @GET
    @Path("prem")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> findPremUsers(){
        return super.findPremUsers();
    }
    
    /**
     * Returns a function from AbstractFacade with the users that are "normal".
     * @return findAllUsers: a list of all non premium users.
     */
    @GET
    @Path("normal")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> findNormalUsers(){
        return super.findNormalUsers();
    }
    
    /**
     * Returns a function from AbstractFacade with users with an specific name.
     * @param fullName Name to be searched.
     * @return A list of users with the specified name.
     */
    @GET
    @Path("name/{fullName}")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> findUserByFN(String fullName){
        return super.findUserByFN(fullName);
    }
}
