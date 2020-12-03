package mkma.entity;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import mkma.enumeration.RecipeType;

/**
 * Contains the information of a recipe.
 *
 * @author Martin Gros
 */
@Entity
@Table(name="recipe", schema="mkma")
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id Will contain the ID of the Recipe.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name Will contain the Name of the Recipe.
     */

    @NotNull
    private String Name;

    /**
     * steps Will contain the steps of the Recipe.
     */
    @NotNull
    private String steps;

    /**
     * kCal Will contain the kCal value of the Recipe.
     */
    @NotNull
    private float kCal;

    /**
     * type Will contain the type of the Recipe.
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private RecipeType type;
    
    @ManyToMany (fetch = FetchType.EAGER, cascade=MERGE)
    @JoinTable (name = "Recipe_Ingredient", schema = "mkma")
    private Set <Ingredient> ingredients;
    
    @OneToMany (cascade = ALL , mappedBy = "recipes")
    private Set<Menu_Recipe> menurecipes;
    
    @ManyToOne
    private User user;
     

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public float getkCal() {
        return kCal;
    }

    public void setkCal(float kCal) {
        this.kCal = kCal;
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
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


