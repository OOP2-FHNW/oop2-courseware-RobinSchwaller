package oop2.module07.calculatorcalculating;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorUI extends GridPane {
	public enum Operator {
		EQUAL    { public double eval(double x, double y) { return 0; }},
		PLUS     { public double eval(double x, double y) { return x + y; } },
		MINUS    { public double eval(double x, double y) { return x - y; } },
		MULTIPLY { public double eval(double x, double y) { return x * y; } },
		DIVIDE   { public double eval(double x, double y) { return x / y; } };

		public abstract double eval(double x, double y);
	}

	private static final List<String> DIGITS = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

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

	private Double operand1;
	private Double operand2;

	private Operator lastOperator;

	private boolean reset;

	public CalculatorUI() {
		initializeControls();
		layoutControls();
		setupEventHandlers();
		clear();
	}

	private void initializeControls() {
		for (int i = 0; i < 10; i++) {
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

		display = new Label();
		display.setMaxWidth(Double.MAX_VALUE);

		getStyleClass().add("calculator");
		equal.getStyleClass().add("equals");
	}

	private Button createButton(String text, String styleClass) {
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

	private void setupEventHandlers() {
		plus.setOnAction(event -> setOperator(Operator.PLUS));
		minus.setOnAction(event -> setOperator(Operator.MINUS));
		multiply.setOnAction(event -> setOperator(Operator.MULTIPLY));
		divide.setOnAction(event -> setOperator(Operator.DIVIDE));
		equal.setOnAction(event -> setOperator(Operator.EQUAL));

		numberButtons.stream()
				.forEach(button -> button.setOnAction(event -> addToDisplay(button.getText())));
		dot.setOnAction(event -> addToDisplay("."));

		ac.setOnAction(event -> clear());
		plusminus.setOnAction(event -> negate());

		setOnKeyTyped(event -> {
			String character = event.getCharacter();
			if(DIGITS.contains(character)){
				addToDisplay(character);
			}
			switch (character) {
				case "+" :
					setOperator(Operator.PLUS);
					break;
				case "-" :
					setOperator(Operator.MINUS);
					break;
				case "*" :
					setOperator(Operator.MULTIPLY);
					break;
				case "/" :
					setOperator(Operator.DIVIDE);
					break;
				case "\r" :
					setOperator(Operator.EQUAL);
					break;
				case "c" :
					clear();
					break;
			}

		});
	}

	private void setOperator(Operator operator) {
		if (Operator.EQUAL != lastOperator) {
			doCalculation();
		}
		operand1 = currentValue();
		reset = true;
		this.lastOperator = operator;
	}

	private void negate() {
		display.setText(format(currentValue() * -1));
	}

	private void addToDisplay(String text) {
		if (display.getText().equals("0") || reset) {
			display.setText(text);
		} else {
			display.setText((display.getText() + text));
		}
		reset = false;
	}

	private Double currentValue() {
		try {
			return NumberFormat.getInstance().parse(display.getText()).doubleValue();
		} catch (ParseException e) {
			return 0.0;
		}
	}

	private String format(Double value) {
		return NumberFormat.getInstance().format(value);
	}

	private void doCalculation() {
		double value = currentValue();
		if (operand1 == null) {
			operand1 = value;
		} else {
			operand2 = value;
		}
		if (operand2 != null && lastOperator != null) {
			operand1 = lastOperator.eval(operand1, operand2);
			display.setText(format(operand1));
			operand2 = null;
		}
	}

	public void clear() {
		operand1 = null;
		operand2 = null;
		lastOperator = null;
		display.setText("0");
	}
}
