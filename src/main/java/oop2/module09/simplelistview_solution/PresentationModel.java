package oop2.module09.simplelistview_solution;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Dieter Holz
 */
public class PresentationModel {
	private final StringProperty applicationTitle = new SimpleStringProperty("A very simple list");

	private final ObservableList<String> elements = FXCollections.observableArrayList();

	public void addNewElement() {
		elements.add(String.valueOf(elements.size()));
	}


	// all getters and setters

	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	public void setApplicationTitle(String applicationTitle) {
		this.applicationTitle.set(applicationTitle);
	}

	public ObservableList<String> getElements() {
		return elements;
	}
}
