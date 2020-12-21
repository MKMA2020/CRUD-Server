package mkma.service;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAuthorizedException;
import mkma.entity.*;
import mkma.enumeration.*;
import mkma.exceptions.IncorrectCredentialsException;
import mkma.exceptions.ReadingException;
import mkma.exceptions.UserExistsException;

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
        try {
            getEntityManager().persist(entity);
        } catch (EntityExistsException e) {
            if (entity instanceof User) {
                throw new InternalServerErrorException(e);
            } else {
                throw new InternalServerErrorException(new UserExistsException());
            }
        }
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
     * @throws ReadingException if there is an issue when reading
     */
    public List<Menu> findAllMenus() throws ReadingException {
        List<Menu> menus;
        try {
            menus = getEntityManager().createNamedQuery("findAllMenus").getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return menus;
    }

    /**
     * Finds every menu with a certain type
     * @param type the type to search
     * @return a list of the menus by type
     * @throws ReadingException if there is an issue when reading 
     */
    public List<Menu> findMenusByType(MenuType type) throws ReadingException {
        List<Menu> menus;
        try {
            menus = getEntityManager().createNamedQuery("findMenusByType").setParameter("type", type).getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return menus;
    }
    /**
     * Finds every ingredient
     * @return a list of every ingredient
     * @throws ReadingException if there is an issue when reading 
     */
    public List<Ingredient> findAllIngredients() throws ReadingException {
        List<Ingredient> ingredients;
        try {
            ingredients = getEntityManager().createNamedQuery("findAllIngredients").getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }

        return ingredients;
    }

    /**
     * Finds ingredients of a type
     * @param type type of ingredient
     * @return a list of ingredients of a certain type
     * @throws ReadingException if there is an issue when reading
     */
    public List<Ingredient> findAllIngredientsByType(IngredientType type) throws ReadingException {
        List<Ingredient> ingredients;
        try {
            ingredients = getEntityManager().createNamedQuery("getIngredientsByType").setParameter("type", type).getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return ingredients;
    }

    /**
     * finds all recipes and orders them by their name
     * @return a list of recipes
     * @throws ReadingException if there is an issue when reading
     */
    public List<Recipe> findAllRecipes() throws ReadingException {
        List<Recipe> recipes;
        try {
            recipes = getEntityManager().createNamedQuery("findAllRecipes").getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return recipes;
    }

    /**
     * Receives the type and orders all receipes by their type
     * @param type
     * @return a list of recipes
     * @throws ReadingException if there is an issue when reading
     */
    public List<Recipe> findRecipesByType(RecipeType type) throws ReadingException {
        List<Recipe> recipes;
        try {
            recipes = getEntityManager().createNamedQuery("findRecipesByType").setParameter("type", type).getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return recipes;
    }

    /**
     * Returns a list of all the users.
     * @return users: contains all users.
     * @throws ReadingException if there is an issue when reading
     */
    public List<User> findAllUsers() throws ReadingException {
        List<User> users;
         try {
            users = getEntityManager().createNamedQuery("findAllUsers").getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return users;
    }

    /**
     * Returns a list of all premium users.
     * @param type
     * @return premUsers: contains all premium users.
     * @throws ReadingException if there is an issue when reading
     */
    public List<User> findUsersByType(UserType type) throws ReadingException {
        List<User> premUsers;
        try {
            premUsers = getEntityManager().createNamedQuery("findUsersByType").setParameter("type", type).getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return premUsers;
    }

    /**
     * Returns a list of users with the same full name.
     * @param fullName Name to search.
     * @return users: contains all user with the specified full name.
     * @throws ReadingException if there is an issue when reading
     */
    public List<User> findUsersByFN(String fullName) throws ReadingException {
        List<User> users;
        try {
            users = getEntityManager().createNamedQuery("findUserByFN").setParameter("fullName", fullName).getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return users;
    }

    /**
     * Returns a list of the Recipes from the menu.
     * @param id The menu id to be searched.
     * @return The recipe List from the selected menu.
     * @throws ReadingException if there is an issue when reading
     */
    public List<Recipe> findRecipesByMenu(Long id) throws ReadingException {
        List<Recipe> recipes;
        try {
            recipes = getEntityManager().createNamedQuery("findRecipesByMenu").setParameter("id", id).getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return recipes;
    }

    /**
     * Returns comments of a recipe
     * @param id id of the recipe
     * @return the comments of a recipe
     * @throws ReadingException if there is an issue when reading
     */
    List<User_Recipe> findCommentsByRecipe(Long id) throws ReadingException {
        List<User_Recipe> comments;
        try {
            comments = getEntityManager().createNamedQuery("findCommentsByRecipes").setParameter("id", id).getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
        }
        return comments;
    }

    /**
     * Returns recipes of a user
     * @param id id of the user
     * @return recipes of the user
     * @throws ReadingException if there is an issue when reading
     */
    public List<Recipe> findRecipesByUser(Long id) throws ReadingException {
        List<Recipe> recipes;
        try {
            recipes = getEntityManager().createNamedQuery("findRecipesByUser").setParameter("id", id).getResultList();
        } catch (Exception ex) {
            throw new ReadingException();
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
            throw new NotAuthorizedException(new IncorrectCredentialsException());
        }
        return user;
    }
}
