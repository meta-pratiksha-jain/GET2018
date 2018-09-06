package com.metacube.training.autowiring.byName;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	@Autowired
    private SpellChecker spellChecker;
    
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    @Autowired
    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }
    
}
