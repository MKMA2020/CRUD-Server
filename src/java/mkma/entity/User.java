package mkma.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
            query ="SELECT u FROM User u WHERE u.login=:login AND u.password=:password"
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
    private String login;

    /**
     * E-mail of the User.
     */
    private String email;

    /**
     * Full Name of the User.
     */
    private String fullName;

    /**
     * Status (Active or Inactive) of the User.
     */
    private Boolean status;

    /**
     * Password of the User.
     */
    private String password;

    /**
     * Last Access Timestamp of the User.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccess;

    /**
     * Last Password Change Timestamp of the User.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastsPasswordChange;

    /**
     * Type of the user.
     */
    @Enumerated(EnumType.STRING)
    private UserType type;

    /**
     * Recipe collection of the user.
     */
    @OneToMany(mappedBy = "user", fetch = EAGER)
    private Set<Recipe> recipes;

    /**
     * Menu collection of the user.
     */
    @OneToMany(mappedBy = "user", fetch = EAGER)
    private Set<Menu> menus;

    /**
     * Ingredient collection of the user.
     */
    @OneToMany(mappedBy = "user", fetch = EAGER)
    private Set<Ingredient> ingredients;

    /**
     *
     * @return id of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @return username of the user.
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @return email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return full name of the user.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     *
     * @return status of the user.
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     *
     * @return password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return time of the user's last access.
     */
    public Date getLastAccess() {
        return lastAccess;
    }

    /**
     *
     * @return time of the user's last password change.
     */
    public Date getLastsPasswordChange() {
        return lastsPasswordChange;
    }

    /**
     *
     * @return type of the user.
     */
    public UserType getType() {
        return type;
    }

    /**
     *
     * @return group of recipes created by user.
     */
    @XmlTransient
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    /**
     *
     * @return group of menus created by user.
     */
    @XmlTransient
    public Set<Menu> getMenus() {
        return menus;
    }

    /**
     *
     * @return group of ingredients created by user.
     */
    @XmlTransient
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     *
     * @param id the id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param login the username to set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @param email the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param fullName the full name to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     *
     * @param status the status to set.
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     *
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param lastAccess the last access Date to set.
     */
    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    /**
     *
     * @param lastsPasswordChange the last password change Date to set.
     */
    public void setLastsPasswordChange(Date lastsPasswordChange) {
        this.lastsPasswordChange = lastsPasswordChange;
    }

    /**
     *
     * @param type the type to set.
     */
    public void setType(UserType type) {
        this.type = type;
    }

    /**
     *
     * @param recipes the recipe group to set.
     */
    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     *
     * @param menus the menu group to set.
     */
    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    /**
     *
     * @param ingredients the ingredient group to be set.
     */
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Returns a hashcode if the id is not null.
     *
     * @return The hashcode of the id.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares this class to the parameter by their id.
     *
     * @param object The object that is compared to the current class.
     * @return Whether they are equal or not.
     */
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

    /**
     *
     * @return The name and id of the class.
     */
    @Override
    public String toString() {
        return "mkma.entity.User[ id=" + id + " ]";
    }

}
