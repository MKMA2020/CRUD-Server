package mkma.entity;

import javax.persistence.Embeddable;

/**
 * 
 * @author Kerman & Aitor
 */
@Embeddable
public class User_RecipeId {

    private Long userId;
    private Long recipeId;

    public User_RecipeId() {

    }

    public User_RecipeId(Long userId, Long recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;

    }
}
