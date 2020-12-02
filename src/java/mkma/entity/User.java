package mkma.entity;

import java.sql.Timestamp;

/**
 * Class containing the information of a registered user.
 *
 * @author Aitor Garcia
 */
public class User {
    
    /**
     * id Will contain the ID of the User.
     */
    private long Id_user;
    
    /**
     * login Will contain the login String of the User.
     */
    private String login;
    
    /**
     * email Will contain the E-mail of the User.
     */
    private String email;
    
    /**
     * fullName Will contain the Full Name of the User.
     */
    private String fullName;
    
    /**
     * status Will contain the status (Active or Inactive) of the User.
     */
    private Boolean status;
    
    /**
     * password Will contain the password of the User.
     */
    private String password;
    
    /**
     * lastAccess Will contain the Last Access Timestamp of the User.
     */
    private Timestamp lastAccess;
    
    /**
     * lastsPasswordChange Will contain the Last Password Change Timestamp of the User.
     */
    private Timestamp lastsPasswordChange;

    public long getId_user() {
        return Id_user;
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

    public void setId_user(long Id_user) {
        this.Id_user = Id_user;
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

}
