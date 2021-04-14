package oop2.module08.calculatormodelbased;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class CalculatorUI extends GridPane {
    private final CalculatorPM calculator;

    private ArrayList<Button> numberButtons = new ArrayList<>();

    private Button dot;

    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;

    private Button plusMinus;

    private Button equal;
    private Button ac;

    private Label display;

    public CalculatorUI(CalculatorPM calculator) {
        this.calculator = calculator;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupBindings();
    }

    private void initializeSelf() {
        getStylesheets().add(getClass().getResource("fonts.css").toExternalForm());
        getStylesheets().add(getClass().getResource("calculator.css").toExternalForm());
    }

    private void initializeControls() {
        for (int i = 0; i < 10; i++) {
            numberButtons.add(createButton(String.valueOf(i)));
        }

        dot       = createButton(".");
        plus      = createButton("+");
        minus     = createButton("-");
        multiply  = createButton("*");
        divide    = createButton("/");
        plusMinus = createButton("+/-");
        equal     = createButton("=");
        ac        = createButton("C");

        plusMinus.setId("plusMinusButton");
        equal.getStyleClass().add("equals");

        display = new Label();
        display.setMaxWidth(Double.MAX_VALUE);
    }

    private void layoutControls() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc, cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(new RowConstraints(), rc, rc, rc, rc, rc);

        add(display, 0, 0, 4, 1);

        add(ac, 0, 1);
        add(plusMinus, 1, 1);
        add(divide, 2, 1);
        add(multiply, 3, 1);

        add(numberButtons.get(7), 0, 2);
        add(numberButtons.get(8), 1, 2);
        add(numberButtons.get(9), 2, 2);
        add(minus, 3, 2);

        add(numberButtons.get(4), 0, 3);
        add(numberButtons.get(5), 1, 3);
        add(numberButtons.get(6), 2, 3);
        add(plus, 3, 3);

        add(numberButtons.get(1), 0, 4);
        add(numberButtons.get(2), 1, 4);
        add(numberButtons.get(3), 2, 4);
        add(equal, 3, 4, 1, 2);

        add(numberButtons.get(0), 0, 5, 2, 1);
        add(dot, 2, 5);
    }

    private void setupEventHandlers() {
        plus.setOnAction(event      -> calculator.setOperator(CalculatorPM.Operator.PLUS));
        minus.setOnAction(event     -> calculator.setOperator(CalculatorPM.Operator.MINUS));
        multiply.setOnAction(event  -> calculator.setOperator(CalculatorPM.Operator.MULTIPLY));
        divide.setOnAction(event    -> calculator.setOperator(CalculatorPM.Operator.DIVIDE));
        equal.setOnAction(event     -> calculator.equal());
        dot.setOnAction(event       -> calculator.addDot());
        ac.setOnAction(event        -> calculator.clear());
        plusMinus.setOnAction(event -> calculator.negate());

        numberButtons.forEach(button -> button.setOnAction(event -> calculator.addToUserFacingString(button.getText().charAt(0))));

        setOnKeyTyped(event -> calculator.processNewInput(event.getCharacter().charAt(0)));
    }

    private void setupBindings() {
        display.textProperty().bind(calculator.userFacingStringProperty());
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);

        return button;
    }

}
