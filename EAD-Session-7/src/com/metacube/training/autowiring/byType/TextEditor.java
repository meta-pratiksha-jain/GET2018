package com.metacube.training.autowiring.byType;

public class TextEditor {
    private SpellChecker spellChecker;
    
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

}
