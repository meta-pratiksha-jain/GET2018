package com.metacube.training.beanScope.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

    @Bean
    @Scope("prototype")
    public Person person()
    {
        Person person=new Person();
        person.setName("default");
        return person;
    }
    
}
