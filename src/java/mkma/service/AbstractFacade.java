package mkma.service;

import java.util.List;
import javax.persistence.EntityManager;
import mkma.entity.Recipe;
import mkma.enumeration.RecipeType;

/**
 * 
 * @author Aitor
 */
public abstract class AbstractFacade<T> {

    //TODO Add exception handling and queries.
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    /**
     * finds all recipes and orders them by their name
     * @return a list of recipes
     */
    public List <Recipe> findAllRecipes (){
        List <Recipe> recipes;
        recipes = getEntityManager().createNamedQuery("findAllRecipes").getResultList();
        return recipes;
    }
    /**
     * Receives the type and orders all receipes by their type
     * @param type
     * @return a list of recipes
     */

    public List<Recipe> getRecipesByType(RecipeType type) {
        List <Recipe> recipes;
        recipes = getEntityManager().createNamedQuery("getRecipesByType").getResultList();
        return recipes;
    }
    /**
     * Orders all receipes by their calorie count
     * @return a list of recipes
     */
    public List<Recipe> OrderBykCal() {
        List <Recipe> recipes;
        recipes = getEntityManager().createNamedQuery("OrderBykCal").getResultList();
        return recipes;
    }
}

