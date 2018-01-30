package com.tutorialspoint.editor;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Íæ¿á
 * 
 */
public class TextEditor {
	private SpellChecker checker;
	private String name;

	// public TextEditor() {
	// System.out.println("Inside TextEditor constructor.");
	// }

	@Autowired
	public TextEditor(SpellChecker checker) {
		this.checker = checker;
		System.out.println("Inside TextEditor constructor.");
	}

	public SpellChecker getChecker() {
		return checker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void spellChecker() {
		checker.checkSpelling();
	}

}
