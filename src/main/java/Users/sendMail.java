package Users;

import com.sun.mail.smtp.SMTPTransport;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class sendMail {
    public String EMAIL_TO;
    public String UrlToSend;
    public String EMAIL_TEXT;
    public String username;
    public String password;
    public String SMTP = "smtp.gmail.com";
    public String USERNAME = "welcometoboardgames@gmail.com";


    public sendMail() {
        super();
    }

    public sendMail(String EMAIL_TO, String username, String password) {
        this.EMAIL_TO = EMAIL_TO;
        this.username = username;
        this.password = password;
        this.UrlToSend = "http://localhost:8080/Gradle___org_example___BoardGames_1_0_SNAPSHOT_war/";
        this.EMAIL_TEXT = "<h1>Hello and Welcome to BoardGames !</h1>\\n" + "<p>To connect enter the username and the password that has been sent with this email and go to the Profile section to change your username and password</p>" +
                 "<p>Username : " + username + "</p>" + "<p>Password : " + password + "</p>" +
                "<p>Please change the default password setted by our admins through this link -></p>" +
                "<a href=\"" + this.UrlToSend + "\">" + "Change Default Password" + "<a/>";
    }

    public Properties setProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        return properties;
    }

    Properties prop = setProperties();





    Session session = Session.getDefaultInstance(prop, null);
    Message msg = new MimeMessage(session);
    public void sendtheemail() {
        try {
            msg.setFrom(new InternetAddress("welcometoboardgames@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO, false));
            msg.setSubject("Change default password");
            msg.setDataHandler(new DataHandler(new HTMLDataSource(EMAIL_TEXT)));
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
            t.connect("smtp.gmail.com", USERNAME, "svhyqkqgujkwweym");
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }



    static class HTMLDataSource implements DataSource {

        private String html;

        public HTMLDataSource(String htmlString) {
            html = htmlString;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            if (html == null) throw new IOException("html message is null!");
            return new ByteArrayInputStream(html.getBytes());
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            throw new IOException("This DataHandler cannot write HTML");
        }

        @Override
        public String getContentType() {
            return "text/html";
        }

        @Override
        public String getName() {
            return "HTMLDataSource";
        }
    }
}
