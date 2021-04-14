package oop2.module08.calculatormodelbased;

import java.util.Arrays;
import java.util.Locale;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.NumberStringConverter;

/**
 * @author Dieter Holz
 */
public class CalculatorPM {

    public enum Operator {
		PLUS    ('+', (a, b) -> a + b),
		MINUS   ('-', (a, b) -> a - b),
		MULTIPLY('*', (a, b) -> a * b),
		DIVIDE  ('/', (a, b) -> a / b);

        private final char key;
        private final Evaluator evaluator;

        Operator(char key, Evaluator evaluator){
            this.key = key;
            this.evaluator = evaluator;
        }

		public double eval(double x, double y){
           return evaluator.eval(x, y);
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }

        @FunctionalInterface
		interface Evaluator {
		    double eval(double a, double b);
        }
	}

	private StringProperty           userFacingString = new SimpleStringProperty("0");
	private DoubleProperty           value            = new SimpleDoubleProperty(0.0);
	private ObjectProperty<Operator> lastOperator     = new SimpleObjectProperty<>();

	private Double operand1;
	private Double operand2;

	private boolean reset;

	public double getFirstOperand() {
		return operand1;
	}

	public CalculatorPM() {
		Bindings.bindBidirectional(userFacingString, value, new NumberStringConverter(new Locale("de", "CH")));
	}

	public void processNewInput(Character input){
        if (Character.isDigit(input)) {
            addToUserFacingString(input);
        }
        else if(isOperator(input)){
            setOperator(input);
        }
        else if(input == '.'){
            addDot();
        }
        else if(input == '\r'){
            equal();
        }
        else if(input == 'c') {
            clear();
        }
    }

	public void addToUserFacingString(char digit) {
		if (getUserFacingString().equals("0") || reset) {
			setUserFacingString(String.valueOf(digit));
		} else {
			setUserFacingString(getUserFacingString() + digit);
		}
		reset = false;
	}

	public void addDot() {
		setUserFacingString(getUserFacingString() + '.');
	}

	public void negate() {
		setValue(getValue() * -1.0);
	}

	public void clear() {
		operand1 = null;
		operand2 = null;
		this.lastOperator.set(null);
		setValue(0.0);
	}

	private boolean isOperator(char key){
        return Arrays.stream(Operator.values())
                     .anyMatch(operator -> operator.key == key);
    }

    private Operator operator(char key){
        return Arrays.stream(Operator.values())
                     .filter(operator -> operator.key == key)
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException("unknown operator"));
    }


	public void equal(){
		if(operand1 == null || getLastOperator() == null) {
			return;
		}
		operand1 = getLastOperator().eval(operand1, getValue());
		setValue(operand1);
		operand2 = null;
		lastOperator.set(null);
	}

    public void setOperator(Operator operator) {
        setOperands();

        reset = true;

        lastOperator.set(operator);
    }

	public void setOperator(char key) {
	    setOperator(operator(key));
	}

	public String getUserFacingString() {
		return userFacingString.get();
	}

	public StringProperty userFacingStringProperty() {
		return userFacingString;
	}

	private void setUserFacingString(String userFacingString) {
		this.userFacingString.set(userFacingString);
	}

	private void setOperands() {
		double value = getValue();
		if (operand1 == null) {
			operand1 = value;
		} else {
			operand2 = value;
		}
		if (operand2 != null && getLastOperator() != null) {
			operand1 = getLastOperator().eval(operand1, operand2);
			setValue(operand1);
			operand2 = null;
		}
	}

    public double getValue() {
  		return value.get();
  	}

  	public DoubleProperty valueProperty() {
  		return value;
  	}

  	public void setValue(double value) {
  		this.value.set(value);
  	}

  	public Operator getLastOperator() {
  		return lastOperator.get();
  	}

  	public ObjectProperty<Operator> lastOperatorProperty() {
  		return lastOperator;
  	}

}
