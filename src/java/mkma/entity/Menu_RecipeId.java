package mkma.entity;

import javax.persistence.Embeddable;

/**
 * Contains the IDs of the Menu - Recipe relation.
 * 
 * @author Martin Gros
 */
@Embeddable
public class Menu_RecipeId {

    private Long menuId;
    private Long recipeId;

    public Menu_RecipeId(Long menuId, Long recipeId) {
        this.menuId = menuId;
        this.recipeId = recipeId;
    }
}
