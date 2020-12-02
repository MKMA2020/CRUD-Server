package mkma.entity;

import javax.persistence.Embeddable;

/**
 * 
 * @author Martin Gros
 */
@Embeddable
public class Menu_RecipeId {

    private Long menuId;
    private Long recipeId;

    public Menu_RecipeId() {

    }

    public Menu_RecipeId(Long menuId, Long recipeId) {
        this.menuId = menuId;
        this.recipeId = recipeId;

    }
}
