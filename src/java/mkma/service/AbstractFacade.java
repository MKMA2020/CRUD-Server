package mkma.service;

import java.util.List;
import javax.persistence.EntityManager;
import mkma.entity.Menu;
import mkma.enumeration.MenuType;

/**
 *
 * @author Kerman Rodríguez
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
     * Finds every menu
     * @return a list of the menus
     */
    public List<Menu> findAllMenus() {
        List<Menu> menus;
        menus = getEntityManager().createNamedQuery("findAllMenus").getResultList();

        return menus;
    }
    
    /**
     * Finds every menu with a certain type
     * @param type the type to search
     * @return a list of the menus by type
     */
    public List<Menu> findMenusByType(MenuType type) {
        List<Menu> menus;
        menus = getEntityManager().createNamedQuery("findMenusByType").setParameter("type", type).getResultList();

        return menus;
    }

    public List<Ingredient> findAllIngredientsASC() {

        List<Ingredient> ingredients;
        ingredients = getEntityManager().createNamedQuery("findAllIngredientsASC").getResultList();
        return ingredients;
    }

    public List<Ingredient> findAllIngredientsDESC() {

        List<Ingredient> ingredients;
        ingredients = getEntityManager().createNamedQuery("findAllIngredientsDESC").getResultList();
        return ingredients;
    }

    public List<Ingredient> findAllIngredientsByType(IngredientType type) {

        List<Ingredient> ingredients;
        ingredients = getEntityManager().createNamedQuery("getIngredientsByType").setParameter("type", type).getResultList();
        return ingredients;
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


