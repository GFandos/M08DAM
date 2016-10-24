package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

public class Controller {


    public MenuItem closeMenu;
    public TextArea txtArea;

    public void close(ActionEvent actionEvent) {

        Platform.exit();

    }

    public void copy(ActionEvent actionEvent) {
        txtArea.copy();
    }

    public void paste(ActionEvent actionEvent) {
        txtArea.paste();
    }

    public void cut(ActionEvent actionEvent) {
        txtArea.cut();
    }

    public void undo(ActionEvent actionEvent) {
        txtArea.undo();
    }


    public void changeSize(ActionEvent actionEvent) {

        MenuItem mI = (MenuItem) actionEvent.getSource();
        switch(mI.getId()) {
            case "s10":
                txtArea.setFont(Font.font(txtArea.getFont().toString(), 10));
                break;

            case "s11":
                txtArea.setFont(Font.font(txtArea.getFont().toString(), 11));
                break;

            case "s12":
                txtArea.setFont(Font.font(txtArea.getFont().toString(), 12));
                break;

            case "s13":
                txtArea.setFont(Font.font(txtArea.getFont().toString(), 13));
                break;

            case "s14":
                txtArea.setFont(Font.font(txtArea.getFont().toString(), 14));
                break;

            case "s15":
                txtArea.setFont(Font.font(txtArea.getFont().toString(), 15));
                break;

            default: break;
        }

    }

    public void help(ActionEvent actionEvent) {

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Editor de text realitzat per Gerard Fandos Garcia.");
        a.showAndWait();

    }

    public void SystemFont(ActionEvent actionEvent) {
        txtArea.setFont(Font.font("System", txtArea.getFont().getSize()));
    }

    public void CantarellFont(ActionEvent actionEvent) {
        txtArea.setFont(Font.font("Cantarell", txtArea.getFont().getSize()));
    }

    public void FreeMonoFont(ActionEvent actionEvent) {
        txtArea.setFont(Font.font("FreeMono", txtArea.getFont().getSize()));
    }

    public void openFile(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        File f = fileChooser.showOpenDialog(stage);

        Scene scene = txtArea.getScene();

        Stage stage2 = (Stage) txtArea.getScene().getWindow();
        stage2.setTitle(f.getName());

        FileReader fr = new FileReader(f);

        BufferedReader bf = new BufferedReader(fr);

        String reading;
        String fileText = "";
        while((reading = bf.readLine())!=null) {
            fileText += reading + "\n";
        }

        txtArea.setText(fileText);

    }


    public void saveFile(ActionEvent actionEvent) throws IOException {

        final Stage stage = new Stage();
        stage.setTitle("File Chooser");

        Stage auxStage = (Stage) txtArea.getScene().getWindow();
        String fileName = auxStage.getTitle();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        FileWriter fw = new FileWriter(fileChooser.showSaveDialog(stage));
        fw.write(txtArea.getText());
        fw.close();
    }
}
