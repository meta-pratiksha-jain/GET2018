package com.metacube.training.autowiring.autodetect;

public class SpellChecker {
    private String spellChecking;
    
    public SpellChecker() {
        super();
    }
    
    public SpellChecker(String spellChecking) {
        super();
        this.spellChecking = spellChecking;
    }

    public String getSpellChecking() {
        return spellChecking;
    }        

}
