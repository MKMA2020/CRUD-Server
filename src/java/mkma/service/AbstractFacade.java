package mkma.service;

import java.util.List;
import javax.persistence.EntityManager;
import mkma.entity.Menu;
import mkma.enumeration.MenuType;

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
}
