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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import mkma.enumeration.IngredientType;



/**
 * Contains the information of one Ingredient.
 * 
 * @author Martin Valiente Ainz
 */
@Entity
@Table(name="ingredient", schema="mkma")
public class Ingredient implements Serializable  {
    
    private static final long serialVersionUID = 1L;
    /**
     * Contains the ID of the Ingredient.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Contains the name of the Ingredient.
     */
    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private IngredientType type;
    
    @ManyToMany (mappedBy = "ingredients", cascade=MERGE,fetch=EAGER)
    private Set<Recipe> recipes;
    
    @ManyToOne
    private User user;
    
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "mkma.entity.Ingredient[ id=" + id + " ]";
    }
}