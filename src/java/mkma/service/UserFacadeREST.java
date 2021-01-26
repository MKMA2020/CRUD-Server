package mkma.service;

import java.util.Date;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mkma.entity.User;
import mkma.enumeration.UserType;
import mkma.exceptions.DatabaseException;
import mkma.exceptions.UserExistsException;
import mkma.mail.MailSender;
import mkma.security.AlgorithmSHA;
import static mkma.security.PasswordGen.generatePass;
import mkma.security.Ciphering;


/**
 *
 * @author Aitor Garcia
 */
@Stateless
@Path("user")
public class UserFacadeREST extends AbstractFacade<User> {

    private Ciphering ciphering = new Ciphering();
    private AlgorithmSHA hashPass = new AlgorithmSHA();

    @PersistenceContext(unitName = "mkmaPU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})

    public void create(User entity) throws Throwable {
        byte[] pass = ciphering.descifrarTexto(entity.getPassword());
        String hashedPass = hashPass.encrypt(Arrays.toString(pass));
        entity.setPassword(hashedPass);
        entity.setStatus(Boolean.TRUE);
        entity.setType(UserType.Normal);
        entity.setLastAccess(new Date());
        entity.setLastsPasswordChange(new Date());

        List <User> users = super.findAllUsers();
        for (User u:users) {
            if (u.getLogin().equals(entity.getLogin()))
                throw new ForbiddenException(new UserExistsException()) ;
        }
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public User find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Returns a list with all the users.
     *
     * @return List with all the users.
     * @throws DatabaseException if there is an issue when reading
     */
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findAll() throws DatabaseException {
        return super.findAllUsers();
    }

    /**
     * Returns a list with users of a type.
     *
     * @param type Type of the users.
     * @return List with the searched users.
     * @throws DatabaseException if there is an issue when reading
     */
    @GET
    @Path("type/{type}")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findByType(@PathParam("type") UserType type) throws DatabaseException {
        return super.findUsersByType(type);
    }

    /**
     * Returns a list of users with a specific name.
     *
     * @param fullName name of the user
     * @return List with the searched users.
     * @throws DatabaseException if there is an issue when reading
     */
    @GET
    @Path("fullName/{fullName}")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findByFN(@PathParam("fullName") String fullName) throws DatabaseException {
        return super.findUsersByFN(fullName);
    }

    /**
     * Returns the user with the specified login
     *
     * @param login login of the user
     * @param password un-hashed password of the user
     * @return the data of the user
     */
    @GET
    @Path("login/{login}/{password}")
    @Produces({MediaType.APPLICATION_XML})
    public User login(@PathParam("login") String login, @PathParam("password") String password) {
        byte[] pass = ciphering.descifrarTexto(password);
        String hashedPass = hashPass.encrypt(Arrays.toString(pass));
        return super.userLogin(login, hashedPass);
    }
    
    @GET
    @Path("reset/{login}/{email}")
    public void resetPassword(@PathParam("login") String login, @PathParam("email") String email) throws DatabaseException, MessagingException {
        List<User> users = super.findAllUsers();
        User t = null;
        for (User user: users) {
            if(user.getEmail().equalsIgnoreCase(email) && user.getLogin().equalsIgnoreCase(login)){
                t = user;
                break;
            }
            
        }
        String newPass = generatePass();
        MailSender mail = new MailSender("mkma.info@gmail.com", "abcd*1234", "smtp.gmail.com", 465);
        String subject = "PocketChef: Your password has been reset!";
        String text = ("Hello " + t.getLogin()+ ", Your password has been reset, so here's your new one: " + newPass);
        mail.sendMail(email, subject, text);
        // Set and encrypt new password to entity
        t.setPassword(AlgorithmSHA.encrypt(newPass));
        t.setLastsPasswordChange(new Date());
        
        super.edit(t);
    }
}
