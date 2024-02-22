package mx.arturogil.notepad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.*;

public class NotepadController {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextArea textArea;

    @FXML
    public void handleOpen (ActionEvent event) throws IOException {
        var chooser = new FileChooser();
        var textExtensionFilter = new FileChooser.ExtensionFilter("Text Files", "*.txt");
        chooser.getExtensionFilters().add(textExtensionFilter);

        File file = chooser.showOpenDialog(anchorPane.getScene().getWindow());
        if(file == null) return;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();

        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
            line = bufferedReader.readLine();
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        String text = stringBuilder.toString();
        textArea.setText(text);
        textArea.positionCaret(text.length());

    }
}