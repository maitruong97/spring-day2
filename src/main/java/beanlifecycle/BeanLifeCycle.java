package beanlifecycle;

public class BeanLifeCycle {
    public void init(){
        System.out.println("Call method init");
    }
    public void destroy(){
        System.out.println("Close Container and call method destroy()");
    }
}
