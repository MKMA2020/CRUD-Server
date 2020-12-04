package mkma.entity;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import mkma.enumeration.MenuType;

/**
 * Information of a Menu.
 * 
 * @author Kerman Rodriguez
 */
@Entity
@Table (name="menu", schema="mkma")
@XmlRootElement
public class Menu implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
     * ID of the Ingredient.
     */
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    
    /**
     * Name of the Menu.
     */
    @NotNull
    private String name;
    
    /**
     * Type of the menu.
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private MenuType type;
    
    /**
     * Menu-recipe relation collection of the menu.
     */
    @OneToMany (cascade = ALL , mappedBy = "menus")
    private Set<Menu_Recipe> menurecipes;
    
    /**
     * Creator of the menu.
     */
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

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    //TODO Check whether commentary is necessary.
    @Override
    public String toString() {
        return "mkma.entity.Menu[ id=" + id + " ]";
    }

}
