package mkma.entity;

/**
 *Claas for the menu and I'ts methods
 * @author 2dam
 */
public class Menu {
    private Long id_menu;
    private String name;
    private menuType menuType;
    
   
    public Long getId_menu() {
        return id_menu;
    }

    public void setId_menu(Long id_Ingredient) {
        this.id_menu = id_menu;
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