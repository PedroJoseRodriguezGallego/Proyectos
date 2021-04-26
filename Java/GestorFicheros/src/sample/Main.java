package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("UT1 - Pedro");
        primaryStage.setScene(new Scene(root, 720, 357));
        primaryStage.show();
        Controller controlador = loader.getController();
        controlador.ponEscena(primaryStage);
        controlador.nuevoArchivo(null);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
