package mkma.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import mkma.enumeration.Menu_recipeType;

/**
 * Relation between Menu and Recipe.
 * 
 * @author Martin Gros
 */
@Entity
@NamedQueries({
    @NamedQuery (name="findRecipesByMenu",
            query ="SELECT r FROM Recipe r WHERE r.id=(SELECT mr.recipes.id FROM Menu_Recipe mr WHERE mr.menus.id=:id)"
    )
})
@Table (name = "menu_recipe", schema="mkma")
@XmlRootElement
public class Menu_Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    /**
     * Id of the relation between a menu and a recipe.
     */
    @Enumerated(EnumType.STRING)
    private Menu_RecipeId id;
    
    /**
     * Menu that contains the recipe.
     */
    @MapsId("menuId")
    @ManyToOne
    private Menu menus;
    
    /**
     * Recipes contained in the menu.
     */
    @MapsId("recipeId")
    @ManyToOne
    private Recipe recipes;
    
    /**
     * Type of the recipe.
     */
    @Enumerated(EnumType.STRING)
    private Menu_recipeType type;

    /**
     * 
     * @return id of the relation.
     */
    public Menu_RecipeId getId() {
         return id;
    }

    /**
     * 
     * @param id the id to set.
     */
    public void setId(Menu_RecipeId id) {
        this.id = id;
    }
    
    /**
     * 
     * @return the menu of the relation.
     */
    @XmlTransient
    public Menu getMenus() {
        return menus;
    }

    /**
     * 
     * @param menus the menu to set.
     */
    public void setMenus(Menu menus) {
        this.menus = menus;
    }

    /**
     * 
     * @return the recipe of the relation.
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
     * @return the type of the relation.
     */
    public Menu_recipeType getType() {
        return type;
    }

    /**
     * 
     * @param type the type to set.
     */
    public void setType(Menu_recipeType type) {
        this.type = type;
    }

    /**
     * Returns a hashcode if the id is not null.
     *
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
     *
     * @param object The object that is compared to the current class.
     * @return Whether they are equal or not.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu_Recipe)) {
            return false;
        }
        Menu_Recipe other = (Menu_Recipe) object;
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
        return "mkma.entity.Menu_Recipe[ id=" + id + " ]";
    }
}