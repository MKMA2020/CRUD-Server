package mkma.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 * The Ingredient class will contain the information of one Ingredient.
 * @author Martin Valiente Ainz
 */
@Entity
@Table(name="ingredient", schema="mkma")
public class Ingredient implements Serializable  {
    
    private static final long serialVersionUID = 1L;
    /**
     * id Will contain the ID of the Ingredient.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * name Will contain the name of the Ingredient.
     */
    @NotNull
    private String name;

    /**
     * type Will contain the type of the Ingredient.
     */
    @NotNull
    private IngredientType type;

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

/**
 * This enum will have the different types of Ingredients.
 *
 * @author Martin Valiente Ainz
 */
enum IngredientType {
    Dairy,
    FatAndOil,
    Additive,
    Mushroom,
    Legume,
    Vegetable,
    Fruit,
    Egg,
    Cereal,
    Fish,
    Seafood,
    Meat,
    Drink,
    Dessert;
}
