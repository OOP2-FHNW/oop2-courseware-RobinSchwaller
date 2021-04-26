package oop2.module09.nationalratswahlen_solution.views;

import java.util.Locale;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import oop2.module09.nationalratswahlen_solution.presentationmodels.GemeindeResultatPM;
import oop2.module09.nationalratswahlen_solution.presentationmodels.GesamtResultatPM;

public class ApplicationUI extends VBox {
	private final GesamtResultatPM model;

	private TableView<GemeindeResultatPM> tabelle;
	private Label                         anzahlGemeinden;

	public ApplicationUI(GesamtResultatPM model) {
		this.model = model;
        initializeSelf();
        initializeControls();
		layoutControls();
		setupEventHandlers();
		setupValueChangedListeners();
		setupBindings();
	}

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    public void initializeControls() {
		tabelle = initializeResultatTabelle();
		anzahlGemeinden = new Label();
	}

	private TableView<GemeindeResultatPM> initializeResultatTabelle() {
		TableView<GemeindeResultatPM> tableView = new TableView<>(model.getAlleResultate());

        TableColumn<GemeindeResultatPM, String> idCol = new TableColumn<>("Gemeindenr.");
        idCol.setCellValueFactory(cell -> cell.getValue().gemeindeNrProperty());

        TableColumn<GemeindeResultatPM, String> nameCol = new TableColumn<>("Gemeindename");
        nameCol.setCellValueFactory(cell -> cell.getValue().gemeindeNamenProperty());

        TableColumn<GemeindeResultatPM, String> cantonCol = new TableColumn<>("Kanton");
        cantonCol.setCellValueFactory(cell -> cell.getValue().kantonProperty());
        cantonCol.setCellFactory(param -> new KantonTableCell());

        TableColumn<GemeindeResultatPM, String> fdpCol = new TableColumn<>("FDP");
        fdpCol.setCellValueFactory(cell -> cell.getValue().FDPProperty());

        TableColumn<GemeindeResultatPM, String> CVPCol = new TableColumn<>("CVP");
        CVPCol.setCellValueFactory(cell -> cell.getValue().CVPProperty());

        TableColumn<GemeindeResultatPM, String> SPSCol = new TableColumn<>("SPS");
        SPSCol.setCellValueFactory(cell -> cell.getValue().SPSProperty());

        TableColumn<GemeindeResultatPM, String> SVPCol = new TableColumn<>("SVP");
        SVPCol.setCellValueFactory(cell -> cell.getValue().SVPProperty());

        TableColumn<GemeindeResultatPM, String> LPSCol = new TableColumn<>("LPS");
        LPSCol.setCellValueFactory(cell -> cell.getValue().LPSProperty());


        // egal ob int, long, float, double, die TableColumn hat den Typparameter Number
        TableColumn<GemeindeResultatPM, Number> wahlberechtigteCol = new TableColumn<>("Wahlberechtigte");
        wahlberechtigteCol.setCellValueFactory(cell -> cell.getValue().wahlberechtigteProperty());

        TableColumn<GemeindeResultatPM, Number> waehlendeCol = new TableColumn<>("W\u00e4hlende");
        waehlendeCol.setCellValueFactory(cell -> cell.getValue().waehlendeProperty());

        // Variante bei numerischen Werten: Formatieren via asString
        TableColumn<GemeindeResultatPM, String> wahlbeteiligungCol = new TableColumn<>("Wahlbeteiligung");
        wahlbeteiligungCol.setCellValueFactory(cell -> cell.getValue().wahlbeteiligungProperty()
                                                           .asString(new Locale("de", "CH"), "%.2f %%"));


        tableView.getColumns().addAll(idCol, nameCol, cantonCol, fdpCol, CVPCol, SPSCol, SVPCol, LPSCol, wahlberechtigteCol, waehlendeCol, wahlbeteiligungCol);

		return tableView;
	}

	private void layoutControls() {
		setVgrow(tabelle, Priority.ALWAYS);

		getChildren().addAll(tabelle, anzahlGemeinden);
	}

	private void setupEventHandlers() {
	}

	private void setupValueChangedListeners() {
	}

    private void setupBindings() {
	}


}
