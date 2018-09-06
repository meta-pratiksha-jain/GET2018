package com.metacube.training.beanScope.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    
    public static void main(String args[])
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("beansScopeSingleton.xml");
        Person person=(Person) context.getBean("person");
        System.out.println(person.getName());
        person.setName("Pratiksha");
        Person newPerson=(Person) context.getBean("person");
        System.out.println(newPerson.getName());
    }

}
