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
import mkma.entity.Ingredient;
import mkma.enumeration.IngredientType;
import mkma.exceptions.DatabaseException;

/**
 * RESTful web service class that has CRUD operations for {@link Ingredient}
 * entities.
 *
 * @author Martin Valiente Ainz
 */
@Stateless
@Path("ingredient")
public class IngredientFacadeREST extends AbstractFacade<Ingredient> {

    @PersistenceContext(unitName = "mkmaPU")
    private EntityManager em;

    public IngredientFacadeREST() {
        super(Ingredient.class);
    }

    /**
     * RESTful method to create a {@link Ingredient} object.
     *
     * @param entity The {@link Ingredient} object.
     * @throws mkma.exceptions.DatabaseException
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Ingredient entity) throws DatabaseException {
        super.create(entity);
    }

    /**
     * RESTful method to update a {@link Ingredient} object.
     *
     * @param id The {@link Ingredient} Id.
     * @param entity The {@link Ingredient} object.
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Long id, Ingredient entity) throws DatabaseException {
        super.edit(entity);
    }

    /**
     * RESTful method to delete a {@link Ingredient} object.
     *
     * @param id The {@link Ingredient} Id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) throws DatabaseException {
        super.remove(super.find(id));
    }

    /**
     * RESTful method to get a {@link Ingredient} object by id.
     *
     * @param id The {@link Ingredient} Id.
     * @return The {@link Ingredient} object.
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Ingredient find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * RESTful method to get all {@link Ingredient} objects ordered ascending.
     *
     * @return The {@link Ingredient} List.
     */
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<Ingredient> findAll(){
        try {
            return super.findAllIngredients();
        } catch (DatabaseException ex) {
            throw new InternalServerErrorException(ex);
        }
        
    }

    /**
     * RESTful method to get all {@link Ingredient} objects by type.
     *
     * @param type The {@link IngredientType}.
     * @return The {@link Ingredient} List.
     * @throws DatabaseException if there is an issue when reading.
     */
    @GET
    @Path("type/{type}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Ingredient> findByType(@PathParam("type") IngredientType type) throws DatabaseException {
        try {
            return super.findAllIngredientsByType(type);
        } catch (DatabaseException ex) {
            throw new InternalServerErrorException(ex);
        }       
    }
    
    /**
     * Entity Manager getter.
     * @return The Entity Manager Object.
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
