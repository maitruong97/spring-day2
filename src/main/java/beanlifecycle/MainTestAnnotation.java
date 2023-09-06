package beanlifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTestAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationbasedconfiguration/beans.xml");
    context.close();
    }
    }

