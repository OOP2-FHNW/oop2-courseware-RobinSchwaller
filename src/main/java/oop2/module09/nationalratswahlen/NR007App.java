package oop2.module09.nationalratswahlen;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import oop2.module09.nationalratswahlen.presentationmodels.GesamtResultatPM;
import oop2.module09.nationalratswahlen.views.ApplicationUI;

public class NR007App extends Application {

	@Override
	public void start(Stage primaryStage) {
		GesamtResultatPM pm = new GesamtResultatPM();

		Parent rootPanel = new ApplicationUI(pm);

		Scene scene = new Scene(rootPanel);

		primaryStage.titleProperty().bind(pm.applicationTitleProperty());
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
