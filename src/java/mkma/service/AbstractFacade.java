package mkma.service;

import java.util.List;
import javax.persistence.EntityManager;
import mkma.entity.*;
import mkma.enumeration.*;

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
     *
     * @return a list of the menus
     */
    public List<Menu> findAllMenus() {
        List<Menu> menus;
        menus = getEntityManager().createNamedQuery("findAllMenus").getResultList();
        return menus;
    }

    /**
     * Finds every menu with a certain type
     *
     * @param type the type to search
     * @return a list of the menus by type
     */
    public List<Menu> findMenusByType(MenuType type) {
        List<Menu> menus;
        menus = getEntityManager().createNamedQuery("findMenusByType").setParameter("type", type).getResultList();
        return menus;
    }

    public List<Ingredient> findAllIngredients() {

        List<Ingredient> ingredients;
        ingredients = getEntityManager().createNamedQuery("findAllIngredients").getResultList();
        return ingredients;
    }

    public List<Ingredient> findAllIngredientsByType(IngredientType type) {

        List<Ingredient> ingredients;
        ingredients = getEntityManager().createNamedQuery("getIngredientsByType").setParameter("type", type).getResultList();
        return ingredients;
    }

    /**
     * finds all recipes and orders them by their name
     *
     * @return a list of recipes
     */
    public List<Recipe> findAllRecipes() {
        List<Recipe> recipes;
        recipes = getEntityManager().createNamedQuery("findAllRecipes").getResultList();
        return recipes;
    }

    /**
     * Receives the type and orders all receipes by their type
     *
     * @param type
     * @return a list of recipes
     */

    public List<Recipe> findRecipesByType(RecipeType type) {
        List<Recipe> recipes;
        recipes = getEntityManager().createNamedQuery("findRecipesByType").getResultList();
        return recipes;
    }

    /**
     * Orders all receipes by their calorie count
     *
     * @return a list of recipes
     */
    public List<Recipe> OrderBykCal() {
        List<Recipe> recipes;
        recipes = getEntityManager().createNamedQuery("OrderBykCal").getResultList();
        return recipes;
    }

    /**
     * Returns a list of all the users.
     *
     * @return users: contains all users.
     */
    public List<User> findAllUsers() {
        List<User> users;
        users = getEntityManager().createNamedQuery("findAllUsers").getResultList();
        return users;
    }

    /**
     * Returns a list of all premium users.
     *
     * @param type
     * @return premUsers: contains all premium users.
     */
    public List<User> findUsersByType(UserType type) {
        List<User> premUsers;
        premUsers = getEntityManager().createNamedQuery("findUsersByType").setParameter("type", type).getResultList();
        return premUsers;
    }

    /**
     * Returns a list of users with the same full name.
     *
     * @param fullName Name to search.
     * @return users: contains all user with the specified full name.
     */
    public List<User> findUsersByFN(String fullName) {
        List<User> users;
        users = getEntityManager().createNamedQuery("findUserByFN").setParameter("fullName", fullName).getResultList();
        return users;
    }

    /**
     * Returns a list of the Recipes from the menu.
     * 
     * @param id The menu id to be searched.
     * @return The recipe List from the selected menu.
     */
    public List<Recipe> findRecipesByMenu(Long id) {
        List<Recipe> recipes;
        recipes = getEntityManager().createNamedQuery("findRecipesByMenu").setParameter("id", id).getResultList();
        return recipes;
    }
    
    /**
     * Returns comments of a recipe
     * @param id id of the recipe
     * @return the comments of a recipe
     */
    List<User_Recipe> findCommentsByRecipe(Long id) {
        List<User_Recipe> comments;
        comments = getEntityManager().createNamedQuery("findCommentsByRecipes").setParameter("id", id).getResultList();
        return comments;
    }
    
    /**
     * Returns recipes of a user
     * @param id id of the user
     * @return recipes of the user
     */
    public List<Recipe> findRecipesByUser(Long id) {
        List<Recipe> recipes;
        recipes = getEntityManager().createNamedQuery("findRecipesByUser").setParameter("id", id).getResultList();
        return recipes;
    }
}
