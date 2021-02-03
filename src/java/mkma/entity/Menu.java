package mkma.entity;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import mkma.enumeration.MenuType;

/**
 * Information of a Menu.
 *
 * @author Kerman Rodriguez
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "findAllMenus", query = "SELECT m FROM Menu m ORDER BY m.name ASC")
    ,
    @NamedQuery(
            name = "findMenusByType", query = "SELECT m FROM Menu m WHERE m.type=:type")
    ,
    @NamedQuery(
            name = "updateSnack", query = "UPDATE Menu m SET m.description='qweerty' WHERE m.type=mkma.enumeration.MenuType.Snack")
    ,
    @NamedQuery(
            name = "updateSnackWithName", query = "UPDATE Menu m SET m.description=:description WHERE m.type=mkma.enumeration.MenuType.Snack")
})
@Table(name = "menu", schema = "mkma")
@XmlRootElement
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID of the Ingredient.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the Menu.
     */
    @NotNull
    private String name;
    
    /**
     * Short description of the menu.
     */
    @NotNull
    private String description;

    /**
     * Type of the menu.
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private MenuType type;

    /**
     * Menu-recipe relation collection of the menu.
     */
    @OneToMany(cascade = ALL, mappedBy = "menus", fetch = EAGER)
    private Set<Menu_Recipe> menurecipes;

    /**
     * Creator of the menu.
     */
    @ManyToOne
    private User user;
    /**
     * @return id of menu
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id of menu
     * @param id of menu
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets the description of the menu
     * @return description of menu
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description for the menu    
     * @param description of the menu
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    

    /**
     * @return name of menu
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of menu
     * @param name of menu
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return type of menu
     */
    public MenuType getType() {
        return type;
    }

    /**
     * Sets menu type
     * @param type of menu
     */
    public void setType(MenuType type) {
        this.type = type;
    }

    /**
     * @return relational field with recipes 
     */
    public Set<Menu_Recipe> getMenurecipes() {
        return menurecipes;
    }
    
    /**
     * Defines the relation of menu and recipes
     * @param menurecipes the relation with recipes
     */
    public void setMenurecipes(Set<Menu_Recipe> menurecipes) {
        this.menurecipes = menurecipes;
    }
    
    /**
     * 
     * @return the user creator of the menu 
     */
    @XmlTransient
    public User getUser() {
        return user;
    }

    /**
     * Sets the creator user
     * @param user that created the menu
     */
    public void setUser(User user) {
        this.user = user;
    }

    //TODO Check whether commentary is necessary.
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    //TODO Checks    
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