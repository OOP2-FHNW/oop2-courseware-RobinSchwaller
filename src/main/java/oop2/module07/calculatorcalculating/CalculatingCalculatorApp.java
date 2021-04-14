package oop2.module07.calculatorcalculating;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatingCalculatorApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent rootPanel = new CalculatorUI();

		Scene scene = new Scene(rootPanel);

		scene.getStylesheets().add(getClass().getResource("calculator.css").toExternalForm());

		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);

		primaryStage.centerOnScreen();

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
