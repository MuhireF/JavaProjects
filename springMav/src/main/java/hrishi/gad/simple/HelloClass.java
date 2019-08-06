package hrishi.gad.simple;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
// @Scope("prototype")
public class HelloClass { //implements InitializingBean, DisposableBean {

    public HelloClass(){
        System.out.println("Inside Constructor");
    }

    public void printMessage(){
        System.out.println("Hello World");
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        System.out.println("After property set");
    }

    @PreDestroy
    public void calledBeforeDestroy() throws Exception {
        System.out.println("Inside destroy method");
    }
}
