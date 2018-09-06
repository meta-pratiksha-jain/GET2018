package com.metacube.training.autowiring.byName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    
    public static void main(String args[])
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("beansAutowiringByName.xml");
        TextEditor textEditor=(TextEditor) context.getBean("textEditor");
        System.out.println(textEditor.getSpellChecker().getSpellChecking());
    }

}
