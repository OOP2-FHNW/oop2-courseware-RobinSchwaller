package oop2.module08.multilanguage_solution;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static oop2.module08.multilanguage_solution.MultiLanguagePM.Caption.*;

/**
 * @author Dieter Holz
 */
public class MultiLanguagePM {

	enum Lang {DE, EN}

	enum Caption {
		WINDOW_TITLE       ("App in English", "App auf Deutsch"),
		LABEL_TEXT         ("some Label",     "eine Beschriftung"),
		GERMAN_BUTTON_TEXT ("German",         "Deutsch"),
		ENGLISH_BUTTON_TEXT("English",        "Englisch");

		private final String english;
		private final String german;

		Caption(String english, String german) {
			this.english = english;
			this.german  = german;
		}

		public String getEnglish() {
			return english;
		}

		public String getGerman() {
			return german;
		}

		public String getText(Lang lang){
			switch (lang){
				case DE:
					return getGerman();
				case EN:
					return getEnglish();
				default:
					return getEnglish();
			}
		}
	}

	private final StringProperty applicationTitle  = new SimpleStringProperty();

	private final StringProperty labelText         = new SimpleStringProperty();
	private final StringProperty germanButtonText  = new SimpleStringProperty();
	private final StringProperty englishButtonText = new SimpleStringProperty();

	public MultiLanguagePM() {
		setLanguage(Lang.EN);
	}

	public void setLanguage(Lang lang) {
		setApplicationTitle(WINDOW_TITLE.getText(lang));
		setLabelText(LABEL_TEXT.getText(lang));
		setGermanButtonText(GERMAN_BUTTON_TEXT.getText(lang));
		setEnglishButtonText(ENGLISH_BUTTON_TEXT.getText(lang));
	}

	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	private void setApplicationTitle(String applicationTitle) {
		this.applicationTitle.set(applicationTitle);
	}

	public String getLabelText() {
		return labelText.get();
	}

	public StringProperty labelTextProperty() {
		return labelText;
	}

	private void setLabelText(String labelText) {
		this.labelText.set(labelText);
	}

	public String getGermanButtonText() {
		return germanButtonText.get();
	}

	public StringProperty germanButtonTextProperty() {
		return germanButtonText;
	}

	private void setGermanButtonText(String germanButtonText) {
		this.germanButtonText.set(germanButtonText);
	}

	public String getEnglishButtonText() {
		return englishButtonText.get();
	}

	public StringProperty englishButtonTextProperty() {
		return englishButtonText;
	}

	private void setEnglishButtonText(String englishButtonText) {
		this.englishButtonText.set(englishButtonText);
	}
}
