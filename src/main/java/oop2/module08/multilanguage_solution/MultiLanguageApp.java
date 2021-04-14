package oop2.module08.multilanguage_solution;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MultiLanguageApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		MultiLanguagePM model = new MultiLanguagePM();

		Parent rootPanel = new MultiLanguageUI(model);

		Scene scene = new Scene(rootPanel);

		primaryStage.titleProperty().bind(model.applicationTitleProperty());
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
