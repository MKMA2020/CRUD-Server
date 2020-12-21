package mkma.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mkma.entity.Menu;
import mkma.enumeration.MenuType;
import mkma.exceptions.ReadingException;

/**
 * Contains the RESTful methods for the menu entity
 *
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
     *
     * @param entity a menu object
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Menu entity) throws Throwable {
        super.create(entity);
    }

    /**
     * Updates a menu object
     *
     * @param entity a menu object
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(Menu entity) {
        super.edit(entity);
    }

    /**
     * Deletes a menu object by id
     *
     * @param id menu's id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    /**
     * Finds a menu by id
     *
     * @param id menu's id
     * @return menu's data
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Menu find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * Returns an entity manager
     *
     * @return the entity manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Finds every menu
     *
     * @return a list of the menus
     * @throws ReadingException if there is an issue when reading
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Menu> findAll() throws ReadingException {
        try {
        return super.findAllMenus();
        } catch (ReadingException ex) {
            throw new InternalServerErrorException(ex);
        }
    }

    /**
     * Finds every menu of a certain type
     *
     * @param type the type to be searched
     * @return a list of the menus with that type
     * @throws ReadingException if there is an issue when reading
     */
    @GET
    @Path("type/{type}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Menu> findByType(@PathParam("type") MenuType type) throws ReadingException {
        try {
            return super.findMenusByType(type);
        } catch (ReadingException ex) {
            throw new InternalServerErrorException(ex);
        }
    }

}
