package oop2.module07.assignment_example;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class A3ExampleUI extends GridPane {
    private Label     labelName;
    private Label     labelEmail;
    private TextField textFieldName;
    private TextField textFieldMail;
    private Button    buttonSave;
    private Button    buttonCancel;

    public A3ExampleUI() {
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        labelName  = new Label("Name");
        labelEmail = new Label("Email");

        textFieldName = new TextField();
        textFieldMail = new TextField();

        buttonSave   = new Button("save");
        buttonCancel = new Button("cancel");
    }

    private void layoutControls() {
        //ein wenig Abstand zum Rand
        setPadding(new Insets(10));

        //Platz zwischen den Grid-Zellen
        setHgap(10);
        setVgap(10);

        ColumnConstraints cc      = new ColumnConstraints();
        ColumnConstraints ccHgrow = new ColumnConstraints();
        ccHgrow.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, ccHgrow);

        RowConstraints rc = new RowConstraints();

        RowConstraints rcVgrow = new RowConstraints();
        rcVgrow.setVgrow(Priority.ALWAYS);
        rcVgrow.setValignment(VPos.BOTTOM);  //beide Buttons am unteren Rand

        getRowConstraints().addAll(rc, rc, rcVgrow);

        //jetzt ist der Button sicher rechtsbuendig
        setHalignment(buttonCancel, HPos.RIGHT);

        add(labelName, 0, 0);
        add(labelEmail, 0, 1);
        add(textFieldName, 1, 0);
        add(textFieldMail, 1, 1);
        add(buttonSave, 0, 2);
        add(buttonCancel, 1, 2);
    }
}