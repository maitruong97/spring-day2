package beanlifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanLifeCycleAnnotation {
    @PostConstruct
    public void init(){
        System.out.println("Call method init");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Close Container and call method destroy()");
    }
}
