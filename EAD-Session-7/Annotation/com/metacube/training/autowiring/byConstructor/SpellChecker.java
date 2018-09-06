package com.metacube.training.autowiring.byConstructor;

import org.springframework.beans.factory.annotation.Autowired;

public class SpellChecker {
	private String spellChecking;
	
	@Autowired
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
