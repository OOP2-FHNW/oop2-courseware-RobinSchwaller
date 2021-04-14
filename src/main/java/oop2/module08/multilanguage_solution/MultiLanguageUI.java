package oop2.module08.multilanguage_solution;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MultiLanguageUI extends GridPane {
    private final MultiLanguagePM model;

    private Button germanButton;
    private Button englishButton;
    private Label  label;

    public MultiLanguageUI(MultiLanguagePM model) {
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

    private void initializeControls() {
        germanButton  = new Button();
        englishButton = new Button();
        label         = new Label();
    }

    private void layoutControls() {
        setPadding(new Insets(10));
        setVgap(20);
        setHgap(20);

        ColumnConstraints cGrow = new ColumnConstraints();
        cGrow.setHgrow(Priority.ALWAYS);

        getColumnConstraints().addAll(cGrow, cGrow);

        RowConstraints rGrow = new RowConstraints();
        rGrow.setVgrow(Priority.ALWAYS);
        getRowConstraints().add(rGrow);

        setHalignment(englishButton, HPos.RIGHT);

        add(label, 0, 0, 2, 1);
        addRow(1, germanButton, englishButton);
    }

    private void setupEventHandlers() {
        germanButton.setOnAction(event  -> model.setLanguage(MultiLanguagePM.Lang.DE));
        englishButton.setOnAction(event -> model.setLanguage(MultiLanguagePM.Lang.EN));
    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
        germanButton.textProperty().bind(model.germanButtonTextProperty());
        englishButton.textProperty().bind(model.englishButtonTextProperty());
        label.textProperty().bind(model.labelTextProperty());

    }
}
