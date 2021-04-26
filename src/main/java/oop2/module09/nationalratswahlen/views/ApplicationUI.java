package oop2.module09.nationalratswahlen.views;

import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import oop2.module09.nationalratswahlen.presentationmodels.GemeindeResultatPM;
import oop2.module09.nationalratswahlen.presentationmodels.GesamtResultatPM;

public class ApplicationUI extends VBox {
    private final GesamtResultatPM model;

    private TableView<GemeindeResultatPM> tabelle;

    public ApplicationUI(GesamtResultatPM model) {
        this.model = model;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    public void initializeControls() {
    }

    public void layoutControls() {
        setVgrow(tabelle, Priority.ALWAYS);

        getChildren().addAll(tabelle);
    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    public void setupBindings() {
    }

}
