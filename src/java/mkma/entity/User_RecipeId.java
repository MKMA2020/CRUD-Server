package mkma.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Contains the IDs of the User - Recipe relation.
 * 
 * @author Kerman & Aitor
 */
@Embeddable
public class User_RecipeId implements Serializable {

    private Long userId;
    private Long recipeId;

    public User_RecipeId(Long userId, Long recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
    
    
}
