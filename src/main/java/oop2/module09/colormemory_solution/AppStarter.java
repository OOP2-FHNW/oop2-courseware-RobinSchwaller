package oop2.module09.colormemory_solution;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import oop2.module09.colormemory_solution.presentationmodels.CoolColorMemoryPM;
import oop2.module09.colormemory_solution.views.ApplicationUI;

public class AppStarter extends Application {

	@Override
	public void start(Stage primaryStage) {
		CoolColorMemoryPM pm = new CoolColorMemoryPM();

		Parent rootPanel = new ApplicationUI(pm);

		Scene scene = new Scene(rootPanel);

		primaryStage.titleProperty().bind(pm.windowTitleProperty());
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
