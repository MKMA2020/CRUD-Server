package mkma.service;

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
import javax.ws.rs.core.PathSegment;
import mkma.entity.Menu_Recipe;
import mkma.entity.Menu_RecipeId;

/**
 *
 * @author Aitor
 */
@Stateless
@Path("mkma.entity.menu_recipe")
public class Menu_RecipeFacadeREST extends AbstractFacade<Menu_Recipe> {

    @PersistenceContext(unitName = "mkmaPU")
    private EntityManager em;

    private Menu_RecipeId getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;menuId=menuIdValue;recipeId=recipeIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        // TODO: put your code here to create a primary key instance based on requested URI represented by pathSegment
        return null;
    }

    public Menu_RecipeFacadeREST() {
        super(Menu_Recipe.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Menu_Recipe entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(Menu_Recipe entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        mkma.entity.Menu_RecipeId key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Menu_Recipe find(@PathParam("id") PathSegment id) {
        mkma.entity.Menu_RecipeId key = getPrimaryKey(id);
        return super.find(key);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}