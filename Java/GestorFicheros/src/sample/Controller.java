package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Date;
import java.util.Objects;

public class Controller {
    public Stage escena;
    public String nombre = "";
    public Button botonEditar;
    public Button botonCopiar;
    public Button botonCntPalabras;
    public Button botonCifrar;
    public Button botonCntVocales;
    public TextArea txtResultado;
    public Label etiNombre;
    public Label etiUltimaMod;
    public Label etiTamano;
    public Label etiRuta;
    public Label etiExtension;
    public Button btnGuardar;
    public Button btnCancelar;
    public Button btnDetalles;
    public Button btnNuevo;

    public void leerContenido(ActionEvent actionEvent) {
        btnGuardar.setVisible(true);
        btnCancelar.setVisible(true);
        String linea;
        String texto = "";
        File archivo = crearSelector(1,1);
        FileReader lector;
        BufferedReader lectorBuffer;
        try {
            lector = new FileReader(archivo);
            lectorBuffer = new BufferedReader(lector);
            while((linea = lectorBuffer.readLine()) != null) {
                texto = texto + linea + "\n";
            }
            txtResultado.setText(texto);
            lectorBuffer.close();
            lector.close();
        } catch (IOException e) {
            txtResultado.setText("(Ha ocurrido un error en la lectura o escritura)");
            e.printStackTrace();
        }
    }
    public void escribeContenido(ActionEvent actionEvent) {
        String[] arrayNombre = etiNombre.getText().split(": ");
        String[] arrayRuta = etiRuta.getText().split(": ");
        File archivo = new File(arrayRuta[arrayRuta.length - 1] + "/" + arrayNombre[arrayNombre.length - 1]);
        String texto = txtResultado.getText();
        if(escribeFichero(archivo,texto)) {
            txtResultado.setText("Archivo grabado.");
        } else {
            txtResultado.setText("Algo ha fallado.");
        }
        btnNuevo.setVisible(true);
    }
    public boolean escribeFichero(File archivo,String texto) {
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        FileWriter escritor;
        BufferedWriter escritorBuffer;
        try {
            escritor = new FileWriter(archivo);
            escritorBuffer = new BufferedWriter(escritor);
            escritorBuffer.write(texto);
            escritorBuffer.flush();
            escritorBuffer.close();
            escritor.close();
            return true;
        } catch (IOException e) {
            txtResultado.setText("(Ha ocurrido un error en la lectura o escritura)");
            e.printStackTrace();
            return false;
        }
    }
    public void cancelaEdicion(ActionEvent actionEvent) {
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        txtResultado.setText("(Aquí aparecerán los resultados de la operación o los datos escritos en el fichero)");
        etiNombre.setText("Nombre: (Nombre del archivo)");
        etiExtension.setText("Extensión: (Extensión del archivo)");
        etiUltimaMod.setText("Última modificación: (Extensión del archivo)");
        etiTamano.setText("Tamaño: (Tamaño en kilobytes del archivo o carpeta)");
        etiRuta.setText("Ruta absoluta: (Ruta completa al archivo)");
        btnNuevo.setVisible(true);
    }
    public void verDetallesDirectorio(ActionEvent actionEvent) {
        crearSelector(2,0);
    }
    public void nuevoArchivo(ActionEvent actionEvent) {
        btnNuevo.setVisible(false);
        btnGuardar.setVisible(true);
        btnCancelar.setVisible(true);
        etiRuta.setText(crearSelector(2,1).getPath());
        etiNombre.setText("Nombre: nuevo.txt");
        txtResultado.setText("Escribe aquí el texto del nuevo fichero...");
    }
    public void copiarArchivo(ActionEvent actionEvent) {
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        byte[] array = leeArchivo();
        String[] lista = nombre.split("\\.");
        String inicioNombre = "";
        for(int i = 0;i < lista.length - 1;i++) {
            inicioNombre = inicioNombre + lista[i];
        }
        nombre = inicioNombre + "_COPIA." + lista[lista.length - 1];
        if(escribeArchivo(array)) {
            txtResultado.setText("Archivo copiado.");
        } else {
            txtResultado.setText("Algo ha fallado.");
        }
    }
    public byte[] leeArchivo() {
        byte[] arrayDeBytes = null;
        File archivo = crearSelector(1,1);
        nombre = archivo.getName();
        FileInputStream lector;
        BufferedInputStream lectorBuffer;
        try {
            lector = new FileInputStream(archivo);
            lectorBuffer = new BufferedInputStream(lector);
            arrayDeBytes = new byte[lectorBuffer.available()];
            lectorBuffer.read(arrayDeBytes);
            lectorBuffer.close();
            lector.close();
        } catch (IOException e) {
            txtResultado.setText("Ha ocurrido un problema en la lectura");
            e.printStackTrace();
        }
        return arrayDeBytes;
    }
    public boolean escribeArchivo(byte[] array) {
        File archivo = crearSelector(1,3);
        FileOutputStream escritor;
        BufferedOutputStream escritorBuffer;
        try {
            escritor = new FileOutputStream(archivo);
            escritorBuffer = new BufferedOutputStream(escritor);
            escritorBuffer.write(array);
            escritorBuffer.close();
            escritor.close();
            return true;
        } catch (IOException e) {
            txtResultado.setText("Ha ocurrido un problema en la escritura");
            e.printStackTrace();
            return false;
        }
    }
    public void contarPalabras(ActionEvent actionEvent) {
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        int contador = 0;
        String linea;
        File archivo = crearSelector(1,1);
        FileReader lector;
        BufferedReader lectorBuffer;
        try {
            lector = new FileReader(archivo);
            lectorBuffer = new BufferedReader(lector);
            while((linea = lectorBuffer.readLine()) != null) {
                if(!linea.equals("")) {
                    for(int i = 0;i < linea.length();i++) {
                        if(linea.charAt(i) == 32) {
                            contador++;
                        }
                    }
                    contador++;
                }
            }
            txtResultado.setText("Hay " + contador + " palabras.");
            lectorBuffer.close();
            lector.close();
        } catch (IOException e) {
            txtResultado.setText("(Ha ocurrido un error en la lectura o escritura)");
            e.printStackTrace();
        }
    }
    public void contarVocales(ActionEvent actionEvent) {
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        int contador = 0;
        String linea;
        File archivo = crearSelector(1,1);
        FileReader lector;
        BufferedReader lectorBuffer;
        try {
            lector = new FileReader(archivo);
            lectorBuffer = new BufferedReader(lector);
            while((linea = lectorBuffer.readLine()) != null) {
                for(int i = 0;i < linea.length();i++) {
                    if(esVocal(linea.charAt(i))) {
                        contador++;
                    }
                }
            }
            txtResultado.setText("Hay " + contador + " vocales.");
            lectorBuffer.close();
            lector.close();
        } catch (IOException e) {
            txtResultado.setText("(Ha ocurrido un error en la lectura o escritura)");
            e.printStackTrace();
        }
    }
    public void cifrarArchivo(ActionEvent actionEvent) {
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        String linea;
        String[] palabras;
        File archivo = crearSelector(1,1);
        String nombre = archivo.getName();
        String[] nombres = nombre.split("\\.");
        nombre = "";
        for(int i = 0;i < nombres.length - 1;i++) {
            nombre = nombre + nombres[i];
        }
        File archivoCifrado = new File(archivo.getParent() + "/" + nombre + "_CIFRADO." + nombres[nombres.length - 1]);
        FileReader lector = null;
        FileWriter escritor = null;
        BufferedReader lectorBuffer = null;
        BufferedWriter escritorBuffer = null;
        try {
            lector = new FileReader(archivo);
            lectorBuffer = new BufferedReader(lector);
            escritor = new FileWriter(archivoCifrado);
            escritorBuffer = new BufferedWriter(escritor);
            while ((linea = lectorBuffer.readLine()) != null) {
                palabras = linea.split(" ");
                linea = "";
                for(int i = 0;i < palabras.length;i++) {
                    if(i != palabras.length - 1) {
                        linea = linea + cifraPalabra(palabras[i]) + " ";
                    } else {
                        linea = linea + cifraPalabra(palabras[i]);
                    }
                }
                escritorBuffer.write(linea);
                escritorBuffer.newLine();
            }
            escritorBuffer.close();
            escritor.close();
            lectorBuffer.close();
            lector.close();
            txtResultado.setText("Archivo cifrado.");
        } catch (IOException e) {
            txtResultado.setText("(Ha ocurrido un error en la lectura o escritura)");
            e.printStackTrace();
        }
    }
    public File crearSelector(int contenido,int modo) {
        File archivo = null;
        if(contenido == 1) {
            FileChooser selector = new FileChooser();
            selector.setInitialDirectory(new File("resources"));
            if(modo == 1) {
                archivo = selector.showOpenDialog(escena);
            } else if(modo == 2){
                archivo = selector.showSaveDialog(escena);
            } else if(modo == 3) {
                selector.setInitialFileName(nombre);
                archivo = selector.showSaveDialog(escena);
            }
        } else if(contenido == 2) {
            DirectoryChooser selector = new DirectoryChooser();
            selector.setInitialDirectory(new File("resources"));
            archivo = selector.showDialog(escena);
        }
        sacarInfo(archivo,contenido);
        return archivo;
    }
    public void sacarInfo(File archivo,int contenido) {
        etiNombre.setText("Nombre: " + archivo.getName());
        etiUltimaMod.setText("Última modificación: " + new Date(archivo.lastModified()));
        if(contenido == 1) {
            String[] elementos = archivo.getName().split("\\.");
            etiRuta.setText("Ruta absoluta: " + archivo.getParent());
            etiTamano.setText("Tamaño: " + archivo.length() / 1024d + " KB");
            etiExtension.setText("Extensión: " + elementos[elementos.length - 1]);
        } else if(contenido == 2) {
            etiRuta.setText("Ruta absoluta: " + archivo.getPath());
            etiTamano.setText("Tamaño: " + sacaTamanoCarpeta(archivo) / 1024d + " KB");
            etiExtension.setText("Extensión: (Extensión del archivo)");
        }
    }
    public double sacaTamanoCarpeta(File farchivo) {
        double tamano = 0;
        for(File archivo : Objects.requireNonNull(farchivo.listFiles())) {
            if(archivo.isFile()) {
                tamano += archivo.length();
            } else {
                tamano += sacaTamanoCarpeta(archivo);
            }
        }
        return tamano;
    }
    public void ponEscena(Stage escenaVentana) {
        this.escena = escenaVentana;
    }
    public boolean esVocal(char letra) {
        return "aeiouAEIOUáéíóúÁÉÍÓÚüÜ".indexOf(letra) > -1;
    }
    public String cifraPalabra(String paraCifrar) {
        String cifrada = String.valueOf(paraCifrar.charAt(0));
        for(int i = paraCifrar.length() - 2;i >= 1;i--) {
            cifrada = cifrada + paraCifrar.charAt(i);
        }
        cifrada = cifrada + paraCifrar.charAt(paraCifrar.length() - 1);
        return cifrada;
    }
}
