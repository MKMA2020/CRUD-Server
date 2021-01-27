package mkma.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Contains the IDs of the User - Recipe relation.
 * 
 * @author Kerman and Aitor
 */
@Embeddable
public class User_RecipeId implements Serializable {

    /**
     * Id of the user.
     */
    private Long userId;
    
    /**
     * Id of the recipe.
     */
    private Long recipeId;

    /**
     * Nullary constructor.
     */
    public User_RecipeId() {
    }

    /**
     * Non-nullary constructor.
     * @param userId id of the user.
     * @param recipeId id of the recipe.
     */
    public User_RecipeId(Long userId, Long recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
    }

    /**
     * 
     * @return id of the user.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId the id of the user to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return id of the recipe.
     */
    public Long getRecipeId() {
        return recipeId;
    }

    /**
     * the id of the recipe to set.
     * @param recipeId 
     */
    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
    
    
}
