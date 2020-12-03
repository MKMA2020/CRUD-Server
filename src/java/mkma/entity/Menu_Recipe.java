/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkma.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import mkma.enumeration.Menu_recipeType;

/**
 * Defines the relation between Menu and Recipe.
 * 
 * @author 2dam
 */
@Entity
@Table (name = "menu_recipe", schema="mkma")
public class Menu_Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Enumerated(EnumType.STRING)
    private Menu_RecipeId id;
    
    @MapsId("menuId")
    @ManyToOne
    private Menu menus;
    
    @MapsId("recipeId")
    @ManyToOne
    private Recipe recipes;
    
    @Enumerated(EnumType.STRING)
    private Menu_recipeType type;

    public Menu_RecipeId getId() {
         return id;
    }

    public void setId(Menu_RecipeId id) {
        this.id = id;
    }

    public Menu getMenus() {
        return menus;
    }

    public void setMenus(Menu menus) {
        this.menus = menus;
    }

    public Recipe getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe recipes) {
        this.recipes = recipes;
    }

    public Menu_recipeType getType() {
        return type;
    }

    public void setType(Menu_recipeType type) {
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
}