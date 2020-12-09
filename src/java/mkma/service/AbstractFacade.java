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
    
    public List<User> findAllUsers(){
        List<User> users;
        users = getEntityManager().createNamedQuery("findAllUsers").getResultList();
        return users;
    }
    
    public List<User> findPremUsers(){
        List<User> premUsers;
        premUsers = getEntityManager().createNamedQuery("getPremUsers").getResultList();
        return premUsers;
    }
    
    public List<User> findNormalUsers(){
        List<User> normalUsers;
        normalUsers = getEntityManager().createNamedQuery("getPremUsers").getResultList();
        return normalUsers;
    }
            
    public List<User> findUserById(){
        List<User> users;
        users = getEntityManager().createNamedQuery("findUserById").getResultList();
        return users;
    }
            
    public List<User> findUserByFN(){
        List<User> users;
        users = getEntityManager().createNamedQuery("findUserByFN").getResultList();
        return users;
    }
}
