package mkma.entity;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The Menu class will contain the information of one Menu.
 * @author Kerman Rodriguez
 */
@Entity
@Table (name="menu", schema="mkma")
public class Menu implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
     * id Will contain the ID of the Ingredient.
     */
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    
    /**
     * name Will contain the name of the Menu.
     */
    @NotNull
    private String name;
    
    /**
     * type Will contain the type of the Menu.
     */
    @NotNull
    private menuType type;
    
    @OneToMany (cascade = ALL , mappedBy = "menus")
    private Set<Menu_Recipe> menurecipes;
    
    @ManyToOne
    private User user;
   
    public Long getId() {
        return id;
    }

    public void setId_menu(Long id_Ingredient) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public menuType getType() {
        return type;
    }

    public void setType(menuType type) {
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mkma.entity.Menu[ id=" + id + " ]";
    }

}

/**
 * This enum will have the different types of Menus.
 *
 * @author Kerman Rodriguez
 */
enum menuType {
    Breakfast,
    Lunch,
    Snack,
    Dinner
}
