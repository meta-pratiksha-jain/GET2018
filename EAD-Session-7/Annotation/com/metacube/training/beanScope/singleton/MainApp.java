package com.metacube.training.beanScope.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    
    public static void main(String args[])
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
        Person person=(Person) context.getBean(Person.class);
        System.out.println(person.getName());
        person.setName("Pratiksha");
        Person newPerson=(Person) context.getBean("person");
        System.out.println(newPerson.getName());
    }

}
