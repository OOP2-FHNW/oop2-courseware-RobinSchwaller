package oop2.module08.calculatormodelbased;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ModelBasedCalculatorApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		CalculatorPM calculator = new CalculatorPM();
		Parent       rootPanel  = new CalculatorUI(calculator);

		Scene scene = new Scene(rootPanel);

		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);

		primaryStage.centerOnScreen();

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
