package com.metacube.training.dependencyInjection.constructorInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public TextEditor textEditor(SpellChecker spellChecker)
    {
        return new TextEditor(spellChecker);
    }
    
    @Bean 
    public SpellChecker spellChecker()
    {
        return new SpellChecker("checking spelling");
    }
    
}
