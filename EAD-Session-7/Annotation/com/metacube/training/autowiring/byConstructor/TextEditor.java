package com.metacube.training.autowiring.byConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class TextEditor {
    
    private SpellChecker spellChecker;
    
    @Autowired
    public TextEditor(SpellChecker spellChecker) {
        super();
        this.spellChecker = spellChecker;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }
    
}
