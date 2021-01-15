package mkma.entity;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import mkma.enumeration.IngredientType;

/**
 * Information of an Ingredient.
 *
 * @author Martin Valiente Ainz
 */
@Entity
@Table(name = "ingredient", schema = "mkma")
@NamedQueries({
    @NamedQuery(name = "findAllIngredients",
            query = "SELECT i FROM Ingredient i ORDER BY i.name ASC"
    )
    ,
    @NamedQuery(name = "getIngredientsByType",
            query = "SELECT i FROM Ingredient i WHERE i.type=:type"
    )
})

@XmlRootElement
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID of the Ingredient.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the Ingredient.
     */
    private String name;

    /**
     * Type of the ingredient
     */
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    /**
     * Defines if the ingredient is verified.
     */
    private boolean verified;

    /**
     * Creator of the ingredient.
     */
    @ManyToOne
    private User user;

    /**
     * Collection of recipes that use the ingredient.
     */
    @ManyToMany(mappedBy = "ingredients", cascade = MERGE, fetch = EAGER)
    private Set<Recipe> recipes;

    /**
     * @return Returns the ID of the Ingredient Object.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @return Returns the Name of the Ingredient Object.
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return Returns the Type of the Ingredient Object.
     */
    public IngredientType getType() {
        return type;
    }
    
    /**
     * @return Returns if the Ingredient is Verified.
     */
    public boolean getVerified() {
        return verified;
    }
    
    /**
     * @return Returns if the User object related to the Ingredient.
     */
    @XmlTransient
    public User getUser() {
        return user;
    }
    
    /**
     * @return Returns the Recipe collection related to the Ingredient.
     */
    @XmlTransient
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
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
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    //TODO Check whether commentary is necessary.
    @Override
    public String toString() {
        return "mkma.entity.Ingredient[ id=" + id + " ]";
    }
}
