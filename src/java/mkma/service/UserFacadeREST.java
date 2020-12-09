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
 *
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

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(User entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(User entity) {
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
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> findAllUsers(){
        return super.findAllUsers();
    }
    
    @GET
    @Path("prem")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> findPremUsers(){
        return super.findPremUsers();
    }
    
    @GET
    @Path("normal")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> findNormalUsers(){
        return super.findNormalUsers();
    }
    
    @GET
    @Path("id")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> findUserById(){
        return super.findUserById();
    }
    
    @GET
    @Path("name")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> findUserByFN(){
        return super.findUserByFN();
    }
}
