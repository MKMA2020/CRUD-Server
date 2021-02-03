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
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mkma.entity.Recipe;
import mkma.enumeration.RecipeType;
import mkma.exceptions.DatabaseException;

/**
 *
 * @author 2dam
 */
@Stateless
@Path("recipe")
public class RecipeFacadeREST extends AbstractFacade<Recipe> {

    @PersistenceContext(unitName = "mkmaPU")
    private EntityManager em;

    public RecipeFacadeREST() {
        super(Recipe.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Recipe entity) throws DatabaseException {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Long id, Recipe entity) throws DatabaseException {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) throws DatabaseException {
        super.remove(super.find(id));
    }
    /**
     * Find a recipe by an id
     * @param id
     * @return 
     */

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Recipe find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * find all recipes and orders them by theirn name on asc
     * @return
     * @throws DatabaseException if there is an issue when reading
     */
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<Recipe> findAll() throws DatabaseException {
        return super.findAllRecipes();
    }
    /**
     * Find recipes by their type. The method receives the type
     * @param type
     * @return 
     * @throws DatabaseException if there is an issue when reading
     */
    @GET
    @Path("type/{type}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Recipe> findByType( @PathParam("type") RecipeType type) throws DatabaseException {
        return super.findRecipesByType(type);
    }
    @GET
    @Path("update")
    @Override
    public void updateRecipes() throws DatabaseException {
        try {
            super.updateRecipes();
        } catch (DatabaseException ex) {
            throw new InternalServerErrorException(ex);
        }
    }
   
}
