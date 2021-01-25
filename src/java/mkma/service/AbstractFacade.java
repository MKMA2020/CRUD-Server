package mkma.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.ws.rs.ForbiddenException;
import mkma.entity.*;
import mkma.enumeration.*;
import mkma.exceptions.IncorrectCredentialsException;
import mkma.exceptions.DatabaseException;

/**
 *
 * @author Kerman Rodríguez, Martin Gros, Martin Valiente and Aitor García
 */
public abstract class AbstractFacade<T> {

    //TODO Add exception handling and queries.
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) throws Throwable {
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
     * @throws DatabaseException if there is an issue when reading
     */
    public List<Menu> findAllMenus() throws DatabaseException {
        List<Menu> menus = null;
        try {
            menus = getEntityManager().createNamedQuery("findAllMenus").getResultList();
        } catch (NoResultException ex) {
            
        } catch (Exception ex) {
            
        }
        return menus;
    }

    /**
     * Finds every menu with a certain type
     * @param type the type to search
     * @return a list of the menus by type
     * @throws DatabaseException if there is an issue when reading 
     */
    public List<Menu> findMenusByType(MenuType type) throws DatabaseException {
        List<Menu> menus;
        try {
            menus = getEntityManager().createNamedQuery("findMenusByType").setParameter("type", type).getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return menus;
    }
    /**
     * Finds every ingredient
     * @return a list of every ingredient
     * @throws DatabaseException if there is an issue when reading 
     */
    public List<Ingredient> findAllIngredients() throws DatabaseException {
        List<Ingredient> ingredients;
        try {
            ingredients = getEntityManager().createNamedQuery("findAllIngredients").getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }

        return ingredients;
    }

    /**
     * Finds ingredients of a type
     * @param type type of ingredient
     * @return a list of ingredients of a certain type
     * @throws DatabaseException if there is an issue when reading
     */
    public List<Ingredient> findAllIngredientsByType(IngredientType type) throws DatabaseException {
        List<Ingredient> ingredients;
        try {
            ingredients = getEntityManager().createNamedQuery("getIngredientsByType").setParameter("type", type).getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return ingredients;
    }

    /**
     * finds all recipes and orders them by their name
     * @return a list of recipes
     * @throws DatabaseException if there is an issue when reading
     */
    public List<Recipe> findAllRecipes() throws DatabaseException {
        List<Recipe> recipes;
        try {
            recipes = getEntityManager().createNamedQuery("findAllRecipes").getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return recipes;
    }

    /**
     * Receives the type and orders all receipes by their type
     * @param type The Recipe Type.
     * @return a list of recipes
     * @throws DatabaseException if there is an issue when reading
     */
    public List<Recipe> findRecipesByType(RecipeType type) throws DatabaseException {
        List<Recipe> recipes;
        try {
            recipes = getEntityManager().createNamedQuery("findRecipesByType").setParameter("type", type).getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return recipes;
    }

    /**
     * Returns a list of all the users.
     * @return users: contains all users.
     * @throws DatabaseException if there is an issue when reading
     */
    public List<User> findAllUsers() throws DatabaseException {
        List<User> users;
         try {
            users = getEntityManager().createNamedQuery("findAllUsers").getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return users;
    }

    /**
     * Returns a list of all premium users.
     * @param type The User type.
     * @return premUsers: contains all premium users.
     * @throws DatabaseException if there is an issue when reading
     */
    public List<User> findUsersByType(UserType type) throws DatabaseException {
        List<User> premUsers;
        try {
            premUsers = getEntityManager().createNamedQuery("findUsersByType").setParameter("type", type).getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return premUsers;
    }

    /**
     * Returns a list of users with the same full name.
     * @param fullName Name to search.
     * @return users: contains all user with the specified full name.
     * @throws DatabaseException if there is an issue when reading
     */
    public List<User> findUsersByFN(String fullName) throws DatabaseException {
        List<User> users;
        try {
            users = getEntityManager().createNamedQuery("findUserByFN").setParameter("fullName", fullName).getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return users;
    }

    /**
     * Returns a list of the Recipes from the menu.
     * @param id The menu id to be searched.
     * @return The recipe List from the selected menu.
     * @throws DatabaseException if there is an issue when reading
     */
    public List<Recipe> findRecipesByMenu(Long id) throws DatabaseException {
        List<Recipe> recipes;
        try {
            recipes = getEntityManager().createNamedQuery("findRecipesByMenu").setParameter("id", id).getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return recipes;
    }

    /**
     * Returns comments of a recipe
     * @param id id of the recipe
     * @return the comments of a recipe
     * @throws DatabaseException if there is an issue when reading
     */
    List<User_Recipe> findCommentsByRecipe(Long id) throws DatabaseException {
        List<User_Recipe> comments;
        try {
            comments = getEntityManager().createNamedQuery("findCommentsByRecipes").setParameter("id", id).getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return comments;
    }

    /**
     * Returns recipes of a user
     * @param id id of the user
     * @return recipes of the user
     * @throws DatabaseException if there is an issue when reading
     */
    public List<Recipe> findRecipesByUser(Long id) throws DatabaseException {
        List<Recipe> recipes;
        try {
            recipes = getEntityManager().createNamedQuery("findRecipesByUser").setParameter("id", id).getResultList();
        } catch (Exception ex) {
            throw new DatabaseException();
        }
        return recipes;
    }

    /**
     * Finds a user with login
     * @param login the login of the user
     * @param password the ciphered password of the user
     * @return the data of the user by login
     */
    public User userLogin(String login, String password) {
        User user;
        user = (User) getEntityManager().createNamedQuery("login").setParameter("login", login).setParameter("password", password).getSingleResult();
        if (user == null) {
            throw new ForbiddenException(new IncorrectCredentialsException());
        }
        return user;
    }
}
