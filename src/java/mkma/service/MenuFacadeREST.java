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
import mkma.entity.Menu;
import mkma.enumeration.MenuType;

/**
 * Contains the RESTful methods for the menu entity
 * @author Kerman Rodríguez
 */
@Stateless
@Path("menu")
public class MenuFacadeREST extends AbstractFacade<Menu> {

    @PersistenceContext(unitName = "mkmaPU")
    private EntityManager em;

    public MenuFacadeREST() {
        super(Menu.class);
    }
    /**
     * Inserts a menu object into the menu table
     * @param a menu object 
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Menu entity) {
        super.create(entity);
    }
    
    /**
     * Updates a menu object 
     * @param a menu object 
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(Menu entity) {
        super.edit(entity);
    }
    /**
     * Deletes a menu object by id
     * @param menu's id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    /**
     * Finds a menu by id
     * @param menu's id
     * @return menu's data
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Menu find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * Returns an entity manager
     * @return the entity manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Finds every menu
     * @return a list of the menus
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Menu> findAll() {               
            return super.findAllMenus();  
    }
    
    /**
     * Finds every menu of a certain type
     * @param type the type to be searched
     * @return a list of the menus with that type
     */
    @GET
    @Path("type/{type}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Menu> findByType(@PathParam("type") MenuType type) {               
            return super.findMenusByType(type);  
    }
    
}
