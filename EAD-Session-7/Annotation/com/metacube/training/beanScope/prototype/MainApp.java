package com.metacube.training.beanScope.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.metacube.training.autowiring.byType.TextEditor;

public class MainApp {
    
    public static void main(String args[])
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
        Person person=(Person) context.getBean(Person.class);
        System.out.println(person.getName());
        person.setName("Pratiksha");
        Person newPerson=(Person) context.getBean(Person.class);
        System.out.println(newPerson.getName());
    }

}
