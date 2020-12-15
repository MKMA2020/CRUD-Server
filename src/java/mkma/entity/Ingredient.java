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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
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
    ),
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
    @NotNull
    private String name;

    /**
     * Type of the ingredient
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    /**
     * Collection of recipes that use the ingredient.
     */
    @ManyToMany(mappedBy = "ingredients", cascade = MERGE, fetch = EAGER)
    private Set<Recipe> recipes;

    /**
     * Creator of the ingredient.
     */
    @ManyToOne
    private User user;
  
    /**
     * Defines if the ingredient is verified.
     */
    private boolean verified;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
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
