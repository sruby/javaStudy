package io.github.sruby.spring.di.setterbased;

import io.github.sruby.spring.di.constructorbased.SpellChecker;

public class TextEditor
{
	
	private SpellChecker spellChecker;
	
	// a setter method to inject the dependency.
	public void setSpellChecker(SpellChecker spellChecker)
	{
		System.out.println("Inside setSpellChecker.");
		this.spellChecker = spellChecker;
	}
	
	// a getter method to return spellChecker
	public SpellChecker getSpellChecker()
	{
		return spellChecker;
	}
	
	public void spellCheck()
	{
		spellChecker.checkSpelling();
	}
}
