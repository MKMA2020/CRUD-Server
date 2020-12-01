package mkma.entity;

import java.io.Serializable;

/**
 *Claas for the menu and I'ts methods
 * @author 2dam
 */
@Entity
@Table (name="menu", schema="mkma")
public class Menu implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private menuType menuType;
    
   
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

    public menuType getMenuType() {
        return menuType;
    }

    public void setMenuType(menuType menuType) {
        this.menuType = menuType;
    }
    
    
    
    
    
    
/**
 * enum declarated outside the main body.
 */   
}
enum menuType {
    Breakfast,
    Lunch,
    Snack,
    Dinner
}

