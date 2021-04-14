package oop2.module06.calculatorchallenge.ruegsegger;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        CalculatorUI cui = new CalculatorUI();
        Group circles = cui.getCircles();
//        Parent rootPanel = new CalculatorUI();

        Scene scene = new Scene(cui);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);

        primaryStage.show();

        cui.createCircleAnimation(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}