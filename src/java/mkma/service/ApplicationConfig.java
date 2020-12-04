package mkma.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Aitor
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(mkma.service.IngredientFacadeREST.class);
        resources.add(mkma.service.MenuFacadeREST.class);
        resources.add(mkma.service.Menu_RecipeFacadeREST.class);
        resources.add(mkma.service.RecipeFacadeREST.class);
        resources.add(mkma.service.UserFacadeREST.class);
        resources.add(mkma.service.User_RecipeFacadeREST.class);
    }
    
}
