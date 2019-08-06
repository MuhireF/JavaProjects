package hrishi.gad.complex;

import org.springframework.stereotype.Component;

@Component("awsService")
public class AWSEmailService implements EmailService {

    public AWSEmailService() {
        System.out.println("Inside AWS Constructor");
    }

    @Override
    public void sendEmail(String toEmail, String message) {
        System.out.println("---------AWS Email Service------------");
        System.out.println("TO: " + toEmail);
        System.out.println("Body: " + message);
        System.out.println("--------------------------------------");
    }
}
