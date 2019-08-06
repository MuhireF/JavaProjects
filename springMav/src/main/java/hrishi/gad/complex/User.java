package hrishi.gad.complex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class User {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        System.out.println("After Context init");
        NotifyService notify = context.getBean(NotifyService.class);
        notify.sendNotify("hrishi.gad", "Sprng complex App");
        context.close();
    }
}
