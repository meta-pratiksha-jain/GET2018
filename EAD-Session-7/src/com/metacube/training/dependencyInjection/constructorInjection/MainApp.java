package com.metacube.training.dependencyInjection.constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    
    public static void main(String args[])
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("beansConstructorInjection.xml");
        TextEditor textEditor=(TextEditor) context.getBean("textEditor");
        System.out.println(textEditor.getSpellChecker().getSpellChecking());
    }

}
