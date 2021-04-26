package oop2.module09.nationalratswahlen.presentationmodels;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class GesamtResultatPM {
    private static final String FILE_NAME = "Nationalratswahlen2007.txt";

    private static final String DELIMITER = "\t";

    private final StringProperty applicationTitle = new SimpleStringProperty("Nationalratswahlen 2007");

    private final ObservableList<GemeindeResultatPM> alleResultate = FXCollections.observableArrayList();

    public GesamtResultatPM() {
        alleResultate.addAll(readFromFile());
    }

    private List<GemeindeResultatPM> readFromFile() {
        //todo implement
        return null;
    }

    public void save() {
        //todo implement
    }


    private BufferedReader getReader(String fileName) {
        InputStream inputStream = getClass().getResourceAsStream(fileName);  // damit kann man vom File lesen
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8); // lesen von Text-File

        return new BufferedReader(reader);  // damit man zeilenweise lesen kann
    }

    private BufferedWriter getWriter(String fileName) {
        try {
            String file = getClass().getResource(fileName).getFile();
            return new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalStateException("wrong file " + fileName);
        }
    }

   	// all getters and setters

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public ObservableList<GemeindeResultatPM> getAlleResultate() {
        return alleResultate;
    }
}