/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author 2dam
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
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") Long id) {
        return super.find(id);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * find all users and orders them by their name on asc
     * @return 
     */
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findAllUsers() {
        return super.findAllUsers();
    }
    
    /**
     * Find users by their type. The method receives the type.
     * @param type
     * @return 
     */
    @GET
    @Path("type/premium")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findPremUsers() {
        return super.findPremUsers();
    }
    
    /**
     * Find users by their type. The method receives the type.
     * @param type
     * @return 
     */
    @GET
    @Path("type/normal")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findNormalUsers() {
        return super.findNormalUsers();
    }
    
    /**
     * Finds all users and orders them by their full name.
     * @return 
     */
    @GET
    @Path("fullName/{fullName}")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findUserByFN(@PathParam("fullName") String fullName) {
        return super.findUserByFN(fullName);
    }
}
