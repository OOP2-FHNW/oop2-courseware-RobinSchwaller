package oop2.module09.colormemory;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import oop2.module09.colormemory.presentationmodels.CoolColorMemoryPM;
import oop2.module09.colormemory.views.ApplicationUI;

public class AppStarter extends Application {

	@Override
	public void start(Stage primaryStage) {
		CoolColorMemoryPM model = new CoolColorMemoryPM();

		Parent rootPanel = new ApplicationUI(model);

		Scene scene = new Scene(rootPanel);

		primaryStage.titleProperty().bind(model.windowTitleProperty());
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
