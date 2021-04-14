package oop2.module08.colormixer;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorMixerApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		Parent rootPanel = new ColorMixerUI();

		Scene scene = new Scene(rootPanel);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Mix It!");

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
