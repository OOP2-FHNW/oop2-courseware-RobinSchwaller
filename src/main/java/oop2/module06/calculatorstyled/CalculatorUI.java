package oop2.module06.calculatorstyled;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

public class CalculatorUI extends GridPane {

	private ArrayList<Button> numberButtons = new ArrayList<>();

	private Button dot;

	private Button plus;
	private Button minus;
	private Button multiply;
	private Button divide;

	private Button plusminus;

	private Button equal;
	private Button ac;

	private Label display;

	public CalculatorUI() {
		initializeControls();
		layoutControls();
	}

	private void initializeControls() {
		for(int i = 0; i<10; i++) {
			numberButtons.add(createButton(String.valueOf(i), "button-white"));
		}

		dot       = createButton(".", "button-white");
		plus      = createButton("+", "button-brown");
		minus     = createButton("-", "button-brown");
		multiply  = createButton("*", "button-brown");
		divide    = createButton("/", "button-brown");

		plusminus = createButton("+/-", "button-gray");
		plusminus.setId("plusMinusButton");

		equal     = createButton("=", "button-yellow");
		ac        = createButton("C", "button-red");

		display = new Label("0");
		display.setMaxWidth(Double.MAX_VALUE);

		getStyleClass().add("calculator");
		equal.getStyleClass().add("equals");

	}

	private Button createButton(String text, String styleClass){
		Button button = new Button(text);
		button.setMaxWidth(Double.MAX_VALUE);
		button.setMaxHeight(Double.MAX_VALUE);
		button.getStyleClass().add(styleClass);

		return button;
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
		add(plusminus, 1, 1);
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

}
