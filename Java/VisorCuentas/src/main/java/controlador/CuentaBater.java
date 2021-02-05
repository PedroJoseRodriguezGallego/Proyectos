package controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class CuentaBater extends Application
{
    @Override
    public void start(Stage mainStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("vista.fxml"));
        Scene mainScene = new Scene(root,600,360);

        Image icono = new Image("src/main/resources/controlador/icono.png");
        mainStage.getIcons().add(icono);

        mainStage.setTitle("Aplicacion Cuentas Bancarias");
        mainStage.setResizable(false);
        mainStage.setScene(mainScene);
        mainStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }

}