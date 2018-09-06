package com.metacube.training.autowiring.byType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public TextEditor textEditor()
    {
        TextEditor textEditor=new TextEditor();
        return textEditor;
    }
    
    @Bean 
    public SpellChecker spellChecker()
    {
        SpellChecker spellChecker=new SpellChecker();
        spellChecker.setSpellChecking("checking spelling");
        return spellChecker;
    }
    
}
