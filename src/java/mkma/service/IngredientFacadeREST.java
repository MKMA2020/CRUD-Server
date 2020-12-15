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
import mkma.entity.Ingredient;
import mkma.enumeration.IngredientType;

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
     * @param ingredient The {@link Ingredient} object.
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Ingredient entity) {
        super.create(entity);
    }

    /**
     * RESTful method to update a {@link Ingredient} object.
     *
     * @param ingredient The {@link Ingredient} object.
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Ingredient entity) {
        super.edit(entity);
    }

    /**
     * RESTful method to delete a {@link Ingredient} object.
     *
     * @param ingredient The {@link Ingredient} object.
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    /**
     * RESTful method to get a {@link Ingredient} object by id.
     *
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
    public List<Ingredient> findByASC() {
        return super.findAllIngredientsASC();
    }

    /**
     * RESTful method to get all {@link Ingredient} objects ordered descending.
     *
     * @return The {@link Ingredient} List.
     */
    @GET
    @Path("desc")
    @Produces({MediaType.APPLICATION_XML})
    public List<Ingredient> findByDESC() {
        return super.findAllIngredientsDESC();
    }

    /**
     * RESTful method to get all {@link Ingredient} objects by type.
     *
     * @param type The {@link IngredientType}.
     * @return The {@link Ingredient} List.
     */
    @GET
    @Path("type/{type}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Ingredient> findByType(@PathParam("type") IngredientType type) {
        return super.findAllIngredientsByType(type);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
