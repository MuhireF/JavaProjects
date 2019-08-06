package hrishi.gad.simple;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Starting Main..");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        System.out.println("After the context init");
        HelloClass hello1 = context.getBean(HelloClass.class);
        HelloClass hello2 = context.getBean(HelloClass.class);
        hello1.printMessage();
        hello2.printMessage();
        System.out.println(hello1 == hello2);
        System.out.println("Before context close");
        context.close();
        System.out.println("After context close");

    }
}
