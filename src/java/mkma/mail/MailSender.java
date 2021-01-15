package mkma.mail;

import javax.mail.Authenticator;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Class that sends e-mails with the newly generated password to a user
 * @author Kerman
 */
public class MailSender {
     // User and password of sender
    private String user = null;
    private String pass = null;

    // Host and port of the sender service
    private String smtp_host = null;
    private int smtp_port = 0;

    @SuppressWarnings("unused")
    private MailSender() {
    }

    /**
     * Builds the MailSender. 
     * 
     * @param user login of sender
     * @param pass password of sender
     * @param host dns of the server
     * @param port port of the server
     */
    public MailSender(String user, String pass, String host, int port) {
            this.user = user;
            this.pass = pass;
            this.smtp_host = host;
            this.smtp_port = port;
    }

    /**
     * Sends the given <b>text</b> from the <b>sender</b> to the <b>receiver</b>. In
     * any case, both the <b>sender</b> and <b>receiver</b> must exist and be valid
     * mail addresses. The sender, mail's FROM part, is taken from this.user by 
     * default<br/>
     * <br/>
     * 
     * Note the <b>user</b> and <b>pass</b> for the authentication is provided in
     * the class constructor. Ideally, the <b>sender</b> and the <b>user</b>
     * coincide.
     * 
     * @param receiver The mail's TO part
     * @param subject  The mail's SUBJECT
     * @param text     The proper MESSAGE
     * @throws MessagingException Is something awry happens
     * 
     */
    public void sendMail(String receiver, String subject, String text) throws MessagingException {

            // Mail properties
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", true);
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", smtp_host);
            properties.put("mail.smtp.port", smtp_port);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.trust", smtp_host);
            properties.put("mail.imap.partialfetch", false);

            // Authenticator knows how to obtain authentication for a network connection.
            Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user, pass);
                    }
            });

            // MIME message to be sent
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver)); // Ej: receptor@gmail.com
            message.setSubject(subject); // Asunto del mensaje

            // A mail can have several parts
            Multipart multipart = new MimeMultipart();

            // A message part (the message, but can be also a File, etc...)
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(text, "text/html");
            multipart.addBodyPart(mimeBodyPart);

            // Adding up the parts to the MIME message
            message.setContent(multipart);

            // And here it goes...
            Transport.send(message);
    }

    public static void main(String[] args) {
        MailSender MailSender = new MailSender("mkma.info@gmail.com", 
                "abcd*1234", "smtp.gmail.com", 465);
        try {
            MailSender.sendMail("kerman.rlz@gmail.com", "Mensaje de prueba", 
                    "Correo de vital importancia");
            System.out.println("Ok, mail sent!");
        } catch (MessagingException e) {
            System.out.println("Doh! " + e.getMessage());
        }
    }
}