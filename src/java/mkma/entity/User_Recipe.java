package mkma.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Defines the comment from a User on a Recipe.
 * 
 * @author Aitor & Kerman
 */
@Entity
@NamedQueries({
    @NamedQuery (name="findCommentsByRecipes",
            query ="SELECT ur FROM User_Recipe ur WHERE ur.recipes.id=:id"
    ),
        @NamedQuery (name="findRecipesByUser",
            query ="SELECT r FROM Recipe r WHERE r.id=(SELECT ur.recipes.id FROM User_Recipe ur WHERE ur.users.id=:id)"
    )
})
@Table (name = "user_recipe", schema="mkma")
@XmlRootElement
public class User_Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Id of the comment.
     */
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private User_RecipeId id;
    
    /**
     * Writer of the comment.
     */
    @MapsId("userId")
    @ManyToOne
    private User users;
    
    /**
     * Recipe that has the comment.
     */
    @MapsId("recipeId")
    @ManyToOne
    private Recipe recipes;
    
    /**
     * Text of the comment.
     */
    private String comment;
    /**
     * Rating of the comment.
     */
    private float rating;
    
    /**
     * Defines if the comment is verified.
     */
    private boolean verified;

    /**
     * 
     * @return id of the comment.
     */
    public User_RecipeId getId() {
        return id;
    }

    /**
     * 
     * @param id the id to set.
     */
    public void setId(User_RecipeId id) {
        this.id = id;
    }


    /**
     * 
     * @return user that created the comment.
     */
    public User getUsers() {
        return users;
    }

    /**
     * 
     * @param users the user to set.
     */
    public void setUsers(User users) {
        this.users = users;
    }

    /**
     * 
     * @return recipe that received the comment.
     */
    public Recipe getRecipes() {
        return recipes;
    }

    /**
     * 
     * @param recipes the recipe to set.
     */
    public void setRecipes(Recipe recipes) {
        this.recipes = recipes;
    }

    /**
     * 
     * @return text of the comment of the recipe.
     */
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @param comment the comment to set.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 
     * @return rating of the recipe in the comment.
     */
    public float getRating() {
        return rating;
    }

    /**
     * 
     * @param rating the rating to set.
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return whether the comment is verified or not.
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * 
     * @param verified the verified state to set.
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    
    
    
    /**
     * Returns a hashcode if the id is not null.
     * @return The hashcode of the id.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares this class to the parameter by their id. 
     * @param object The object that is compared to the current class.
     * @return Whether they are equal or not.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User_Recipe)) {
            return false;
        }
        User_Recipe other = (User_Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return The name and id of the class.
     */
    @Override
    public String toString() {
        return "mkma.entity.User_Recipe[ id=" + id + " ]";
    }
    
}
