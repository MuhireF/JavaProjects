package hrishi.gad.complex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class NotifyService {
    //property based DI
    @Autowired //needed
    @Qualifier("gmailService")
    private EmailService emailService;

//    //constructor based dependency
//    @Autowired //not needed
//    public NotifyService(EmailService emailService){
//        System.out.println("Inside Notify Constructor");
//        this.emailService = emailService;
//    }
    public void sendNotify(String sendTo, String message){
        System.out.println("Inside sendNotify method");
        this.emailService.sendEmail(sendTo, message);
    }
//
//    @Autowired //setter based DI
//    public void setEmailService(EmailService emailService) {
//        this.emailService = emailService;
//    }
}
