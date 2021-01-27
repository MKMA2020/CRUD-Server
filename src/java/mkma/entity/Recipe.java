package mkma.entity;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import mkma.enumeration.RecipeType;

/**
 * Information of a recipe.
 *
 * @author Martin Gros
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "findAllRecipes", query = "SELECT r FROM Recipe r ORDER BY r.name ASC"
    )
    ,
    @NamedQuery(
            name = "findRecipesByType", query = "SELECT r FROM Recipe r WHERE r.type=:type"
    )
})
    
@Table(name = "recipe", schema = "mkma")
@XmlRootElement
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID of the Recipe.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the Recipe.
     */
    private String name;

    /**
     * Steps of the Recipe.
     */
    private String steps;

    /**
     * kCal value of the Recipe.
     */
    private float kcal;

    /**
     * Type of the Recipe.
     */
    @Enumerated(EnumType.STRING)
    private RecipeType type;

    /**
     * Ingredient collection of the recipe.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = MERGE)
    @JoinTable(name = "Recipe_Ingredient", schema = "mkma")
    private Set<Ingredient> ingredients;

    /**
     * Menu-recipes relation collection of the recipe.
     */
    @OneToMany(cascade = ALL, mappedBy = "recipes", fetch=EAGER)
    private Set<Menu_Recipe> menurecipes;

    /**
     * Creator of the recipe.
     */
    @ManyToOne
    private User user;
    
    /**
     * Defines if the recipe is verified.
     */
    private boolean verified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public float getKcal() {
        return kcal;
    }

    public void setKcal(float kcal) {
        this.kcal = kcal;
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }
    
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
    
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    @XmlTransient
    public Set<Menu_Recipe> getMenurecipes() {
        return menurecipes;
    }

    public void setMenurecipes(Set<Menu_Recipe> menurecipes) {
        this.menurecipes = menurecipes;
    }
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mkma.entity.Recipe[ id=" + id + " ]";
    }
}
