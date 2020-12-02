/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkma.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author 2dam
 */
@Entity
@Table (name = "menu_recipe", schema="mkma")
public class Menu_Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Menu_RecipeId id;
    
    @MapsId("menuId")
    @ManyToOne
    private Menu menus;
    
    @MapsId("recipeId")
    @ManyToOne
    private Recipe recipes;
    
    private menu_recipeType type;

    public Menu_RecipeId getId() {
         return id;
    }

    public void setId(Menu_RecipeId id) {
        this.id = id;
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
        if (!(object instanceof Menu_Recipe)) {
            return false;
        }
        Menu_Recipe other = (Menu_Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mkma.entity.Menu_Recipe[ id=" + id + " ]";
    }
    /**
     * 
     */



}
enum menu_recipeType {
    Starter,
    Main,
    Secondary,
    Dessert,
    Side,
    Drink;
}
