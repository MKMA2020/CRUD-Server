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

    private Long menuId;
    private Long recipeId;

    public Menu_RecipeId() {
    }

    public Menu_RecipeId(Long menuId, Long recipeId) {
        this.menuId = menuId;
        this.recipeId = recipeId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
    
}
