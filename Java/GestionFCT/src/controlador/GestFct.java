/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import javafx.scene.input.KeyEvent;
import help.Help;

import java.sql.SQLException;

public class GestFct extends Application {
    
    @Override
    public void start(Stage stage) throws Exception,SQLException {
        Image image = new Image("vista/images/logo_safa_azul_icono.png");

        Parent root = FXMLLoader.load(getClass().getResource("/vista/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.F1) {
                    Help help = new Help();
                    help.setVisible(true);
                }
            }
        });

        stage.setScene(scene);
        stage.getIcons().add(image);
        stage.setTitle("Programa Gestión FCT");
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        launch(args);
    }
    
}
