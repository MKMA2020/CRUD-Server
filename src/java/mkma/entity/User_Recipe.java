package mkma.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Defines the relation between User and Recipe.
 * 
 * @author Aitor & Kerman
 */
@Entity
@Table (name = "user_recipe", schema="mkma")
public class User_Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Id of the relation between a user and a recipe.
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

    public User_RecipeId getId() {
        return id;
    }

    public void setId(User_RecipeId id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Recipe getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe recipes) {
        this.recipes = recipes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    
    //TODO Check whether commentary is necessary.
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    //TODO Check whether commentary is necessary.
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

    //TODO Check whether commentary is necessary.
    @Override
    public String toString() {
        return "mkma.entity.User_Recipe[ id=" + id + " ]";
    }
    
}
