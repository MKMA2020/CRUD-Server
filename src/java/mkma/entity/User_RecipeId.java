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
}
