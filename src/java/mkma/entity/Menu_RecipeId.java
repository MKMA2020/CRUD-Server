package mkma.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Contains the IDs of the Menu - Recipe relation.
 * 
 * @author Martin Gros
 */
@Embeddable
public class Menu_RecipeId implements Serializable {

    /**
     * Id of the menu.
     */
    private Long menuId;
    
    /**
     * Id of the recipe.
     */
    private Long recipeId;

    /**
     * Nullary constructor.
     */
    public Menu_RecipeId() {
    }

    /**
     * Non-nullary constructor.
     * @param menuId id of the menu.
     * @param recipeId id of the recipe.
     */
    public Menu_RecipeId(Long menuId, Long recipeId) {
        this.menuId = menuId;
        this.recipeId = recipeId;
    }

    /**
     * 
     * @return id of the menu.
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 
     * @param menuId the id of the menu to set.
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 
     * @return id of the recipe.
     */
    public Long getRecipeId() {
        return recipeId;
    }

    /**
     * 
     * @param recipeId the id of the recipe to set.
     */
    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
    
}
