package com.metacube.training.dependencyInjection.constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    
    public static void main(String args[])
    {

        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
        TextEditor textEditor=(TextEditor) context.getBean(TextEditor.class);
        System.out.println(textEditor.getSpellChecker().getSpellChecking());
    }

}
