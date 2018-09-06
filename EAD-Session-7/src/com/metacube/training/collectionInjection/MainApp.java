package com.metacube.training.collectionInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

public class MainApp {
    
    public static void main(String args[])
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("beansCollectionInjection.xml");
        PersonCollection personCollection=(PersonCollection) context.getBean("personCollection");
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
