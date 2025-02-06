package controler;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Emails{
    
    private static final String EMAIL_FROM = "erronka2t5@gmail.com\r\n";
    private static final String PASSWORD_FROM = "ynvv fdhi ituq qsti"; // Usa una contraseña de aplicación

    public static void main(String[] args) {
        String emailTo = "jon.olandaar@elorrieta-errekamari.com";
        String subject = "Me pican los cocos";
        String content = "Iker melero es gay";

        // Configurar y enviar correo
        new Emails().sendEmail(emailTo, subject, content);
    }

    public void sendEmail(String emailTo, String subject, String content) {
        try {
            // Configurar propiedades del servidor SMTP
            Properties mProperties = new Properties();
            mProperties.put("mail.smtp.host", "smtp.gmail.com");
            mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            mProperties.put("mail.smtp.starttls.enable", "true");
            mProperties.put("mail.smtp.port", "587");
            mProperties.put("mail.smtp.auth", "true");

            // Crear sesión con autenticación
            Session mSession = Session.getInstance(mProperties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EMAIL_FROM, PASSWORD_FROM);
                }
            });

            // Crear correo
            MimeMessage mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(EMAIL_FROM));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content, "UTF-8");

            // Enviar correo
            try (Transport mTransport = mSession.getTransport("smtp")) {
                mTransport.connect();
                mTransport.sendMessage(mCorreo, mCorreo.getAllRecipients());
            }

            JOptionPane.showMessageDialog(null, "Correo enviado correctamente");

        } catch (MessagingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al enviar el correo", ex);
            JOptionPane.showMessageDialog(null, "Error al enviar el correo: " + ex.getMessage());
        }
    }
}

