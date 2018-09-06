package com.metacube.training.collectionInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.metacube.training.beanScope.singleton.AppConfiguration;

import java.util.*;

public class MainApp {
    
    public static void main(String args[])
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
        PersonCollection personCollection=(PersonCollection) context.getBean(PersonCollection.class);
        List listOfPerson=personCollection.getListOfPerson();
        System.out.println("list of person name:");
        System.out.println(listOfPerson);
        Set setOfPerson=personCollection.getSetOfPerson();
        System.out.println("set of person name:");
        System.out.println(setOfPerson);
        Map mapOfPerson=personCollection.getMapOfPerson();
        System.out.println("map of person name with their key value as id:");
        System.out.println(mapOfPerson);
        
    }

}
