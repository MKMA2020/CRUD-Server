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
import javax.persistence.OneToMany;
import mkma.enumeration.UserType;

/**
 * Contains the information of a registered user.
 *
 * @author Aitor Garcia
 */
@Entity
@Table(name = "user", schema = "mkma")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id Will contain the ID of the User.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * login Will contain the login String of the User.
     */
    @NotNull
    private String login;

    /**
     * email Will contain the E-mail of the User.
     */
    @NotNull
    private String email;

    /**
     * fullName Will contain the Full Name of the User.
     */
    @NotNull
    private String fullName;

    /**
     * status Will contain the status (Active or Inactive) of the User.
     */
    @NotNull
    private Boolean status;

    /**
     * password Will contain the password of the User.
     */
    @NotNull
    private String password;

    /**
     * lastAccess Will contain the Last Access Timestamp of the User.
     */
    @NotNull
    private Timestamp lastAccess;

    /**
     * lastsPasswordChange Will contain the Last Password Change Timestamp of
     * the User.
     */
    @NotNull
    private Timestamp lastsPasswordChange;
    
    @OneToMany(mappedBy = "user", fetch=EAGER)
    private Set<Recipe> recipes;
    
    @OneToMany(mappedBy = "user", fetch=EAGER)
    private Set<Menu> menus;
    
    @OneToMany(mappedBy = "user", fetch=EAGER)
    private Set<Ingredient> ingredients;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType type;

    public long getId_user() {
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

    public void setId_user(long Id_user) {
        this.id = Id_user;
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
