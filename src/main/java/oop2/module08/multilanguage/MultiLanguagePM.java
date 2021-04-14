package oop2.module08.multilanguage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

	private final StringProperty applicationTitle = new SimpleStringProperty("Switch It!");



	public MultiLanguagePM() {

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

}
