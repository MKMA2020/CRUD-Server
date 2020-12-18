package mkma.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import mkma.enumeration.UserType;

/**
 * Information of a registered user.
 *
 * @author Aitor Garcia
 */
@Entity
@Table(name = "user", schema = "mkma")
@XmlRootElement
@NamedQueries({
    @NamedQuery (name="findAllUsers",
            query ="SELECT u FROM User u ORDER BY u.fullName ASC"
    ),
    @NamedQuery (name="findUsersByType",
            query ="SELECT u FROM User u WHERE u.type=:type"
    ),
    @NamedQuery (name="findUserByFN",
            query ="SELECT u FROM User u WHERE u.fullName=:fullName"
    ),
    @NamedQuery (name="login",
            query ="SELECT u FROM User u WHERE u.login=:login"
    )
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID of the User.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Login String of the User.
     */
    @NotNull
    private String login;

    /**
     * E-mail of the User.
     */
    @NotNull
    private String email;

    /**
     * Full Name of the User.
     */
    @NotNull
    private String fullName;

    /**
     * Status (Active or Inactive) of the User.
     */
    @NotNull
    private Boolean status;

    /**
     * Password of the User.
     */
    @NotNull
    private String password;

    /**
     * Last Access Timestamp of the User.
     */
    @NotNull
    private Timestamp lastAccess;

    /**
     * Last Password Change Timestamp of
     * the User.
     */
    @NotNull
    private Timestamp lastsPasswordChange;
    
    /**
     * Type of the user.
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType type;
    
    /**
     * Recipe collection of the user.
     */
    @OneToMany(mappedBy = "user", fetch=EAGER)
    private Set<Recipe> recipes;
    
    /**
     * Menu collection of the user.
     */
    @OneToMany(mappedBy = "user", fetch=EAGER)
    private Set<Menu> menus;
    
    /**
     * Ingredient collection of the user.
     */
    @OneToMany(mappedBy = "user", fetch=EAGER)
    private Set<Ingredient> ingredients;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getLastAccess() {
        return lastAccess;
    }

    public Timestamp getLastsPasswordChange() {
        return lastsPasswordChange;
    }

    public UserType getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastAccess(Timestamp lastAccess) {
        this.lastAccess = lastAccess;
    }

    public void setLastsPasswordChange(Timestamp lastsPasswordChange) {
        this.lastsPasswordChange = lastsPasswordChange;
    }

    public void setType(UserType type) {
        this.type = type;
    }
    
    @XmlTransient
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
    
    @XmlTransient
    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
    
    @XmlTransient
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mkma.entity.User[ id=" + id + " ]";
    }

}