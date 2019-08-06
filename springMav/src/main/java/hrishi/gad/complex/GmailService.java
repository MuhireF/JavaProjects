package hrishi.gad.complex;

import org.springframework.stereotype.Component;

@Component("gmailService")
public class GmailService implements EmailService {

    public GmailService() {
        System.out.println("Inside Gmail Constructor");
    }

    @Override
    public void sendEmail(String toEmail, String message) {
        System.out.println("--------Gmail Email Service------------");
        System.out.println("TO: " + toEmail);
        System.out.println("Body: " + message);
        System.out.println("--------------------------------------");
    }
}
