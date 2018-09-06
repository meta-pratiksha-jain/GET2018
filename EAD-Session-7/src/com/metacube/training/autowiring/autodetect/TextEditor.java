package com.metacube.training.autowiring.autodetect;

public class TextEditor {
    private SpellChecker spellChecker;
    
    public TextEditor(SpellChecker spellChecker) {
        super();
        this.spellChecker = spellChecker;
    }
    
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }
}
