package mkma.service;

import java.util.List;
import javax.persistence.EntityManager;
import mkma.entity.User;

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
     * Returns a list of all the users.
     * @return users: contains all users.
     */
    public List<User> findAllUsers(){
        List<User> users;
        users = getEntityManager().createNamedQuery("findAllUsers").getResultList();
        return users;
    }
    
    /**
     * Returns a list of all premium users.
     * @return premUsers: contains all premium users.
     */
    public List<User> findPremUsers(){
        List<User> premUsers;
        premUsers = getEntityManager().createNamedQuery("getPremUsers").getResultList();
        return premUsers;
    }
    
    /**
     * Returns a list of all normal users.
     * @return normalUsers: contains all non premium users.
     */
    public List<User> findNormalUsers(){
        List<User> normalUsers;
        normalUsers = getEntityManager().createNamedQuery("getPremUsers").getResultList();
        return normalUsers;
    }

    /**
     * Returns a list of users with the same full name.
     * @param fullName Name to search.
     * @return users: contains all user with the specified full name.
     */
    public List<User> findUserByFN(String fullName){
        List<User> users;
        users = getEntityManager().createNamedQuery("findUserByFN").setParameter("fullName", fullName).getResultList();
        return users;
    }
}
