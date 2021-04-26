package oop2.module09.simplelistview_solution;

import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ApplicationUI extends VBox {
    private final PresentationModel model;

    private Button           button;
    private ListView<String> listView;

    public ApplicationUI(PresentationModel model) {
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
        button   = new Button("Add New Element");
        listView = new ListView<>(model.getElements());
    }

    private void layoutControls() {
        setPadding(new Insets(10));
        setSpacing(10);

        button.setMaxWidth(Double.MAX_VALUE);
        setVgrow(listView, Priority.ALWAYS);

        getChildren().addAll(listView, button);
    }

    private void setupEventHandlers() {
        button.setOnAction(event -> model.addNewElement());
    }

    private void setupValueChangedListeners() {
        model.getElements().addListener((ListChangeListener<String>) c -> {
            while (c.next()) {
                listView.scrollTo(c.getFrom());
            }
        });
    }

    private void setupBindings() {
    }
}
