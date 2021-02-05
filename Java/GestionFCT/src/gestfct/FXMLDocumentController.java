/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestfct;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import modelo.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javax.swing.table.DefaultTableModel;
import modelo.emp;

/**
 * FXML Controller class
 *
 * @author David
 */
public class FXMLDocumentController implements Initializable{

    @FXML
    private Tab paneHome;
    @FXML
    private Tab gestionEmp;
    @FXML
    private Tab fichTab;
    @FXML
    private Tab asigAlum;
    @FXML
    private TextField codigoEmpresaText;
    @FXML
    private TextField nombreEmpresaText;
    @FXML
    private TextField cifText;
    @FXML
    private TextField localidadText;
    @FXML
    private TextField cpText;
    @FXML
    private ComboBox<String> TipoJorComb;
    private ObservableList<String> lista;
    
    @FXML
    private TextField dniRespText;
    @FXML
    private TextField nombreTutorText;
    @FXML
    private TextField apellidoTutorText;
    @FXML
    private TextField telefonoText;
    @FXML
    private Button Insertar;
    @FXML
    private Button Borrar;
    @FXML
    private Button Modificar;
    @FXML
    private TextField mailText;
  
    @FXML
    private TextField direcciontext;
    @FXML
    private TextField dniText;
    @FXML
    
    private TextField apellidoRespText;
    @FXML
    private TextField nombreRespText;
    @FXML
    private TableView<emp> tablaM;
    @FXML
    private TableColumn<emp,String> COD_EMPRESA;
    @FXML
    private TableColumn<emp,String> NOM_EMPRESA;
    @FXML
    private TableColumn<emp,String> CIF;
    @FXML
    private TableColumn<emp,String> DIREC;
    @FXML
    private TableColumn<emp,String> LOCALI;
    @FXML
    private TableColumn<emp,String> CP;
    @FXML
    private TableColumn<emp,String> TIP_JORNADA;
     @FXML
    private TableColumn<emp, String> DNI_RESP;
    @FXML
    private TableColumn<emp, String> NOMBRE_RESP;
    @FXML
    private TableColumn<emp, String> APELLIDO_RESP;
    @FXML
    private TableColumn<emp,String> DNI_TUTOR;
    @FXML
    private TableColumn<emp,String> NOM_TUTOR;
    @FXML
    private TableColumn<emp,String> APE_TUTOR;
    @FXML
    private TableColumn<emp,String> MAIL_TUTOR;
    @FXML
    private TableColumn<emp,String> TLF_TUTOR;
    @FXML
    private ImageView imagenHome;
    @FXML
    private ImageView imagenTab;
    @FXML
    private ComboBox<String> ComboAlumno;
    @FXML
    private ComboBox<String> ComboEmpresa;
    @FXML
    private ComboBox<String> ComboTutor;
    @FXML
    private TextArea Resultado;
    @FXML
    private Label resultadoConsulta;
    @FXML
    private Button borratab;
    @FXML
    private Button Insertab;
    @FXML
    private Button borraAsig;
    @FXML
    private Label etiatbla;
   
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           
            
            
            //inicializa los campos tabla
            
            this.COD_EMPRESA.setCellValueFactory(new PropertyValueFactory("codigo"));
            this.NOM_EMPRESA.setCellValueFactory(new PropertyValueFactory("nom_emp"));
            this.CIF.setCellValueFactory(new PropertyValueFactory("cif"));
            this.DIREC.setCellValueFactory(new PropertyValueFactory("direccion"));
            this.LOCALI.setCellValueFactory(new PropertyValueFactory("locali"));
            this.CP.setCellValueFactory(new PropertyValueFactory("cp"));
            this.TIP_JORNADA.setCellValueFactory(new PropertyValueFactory("tip_jonada"));
            this.DNI_RESP.setCellValueFactory(new PropertyValueFactory("dni_resp"));
           this. NOMBRE_RESP.setCellValueFactory(new PropertyValueFactory("nom_resp"));
           this. APELLIDO_RESP.setCellValueFactory(new PropertyValueFactory("apellido_resp"));
            this.DNI_TUTOR.setCellValueFactory(new PropertyValueFactory("dni_tutor"));
            this.NOM_TUTOR.setCellValueFactory(new PropertyValueFactory("nom_tutor"));
            this.APE_TUTOR.setCellValueFactory(new PropertyValueFactory("ape_tutor"));
            this.MAIL_TUTOR.setCellValueFactory(new PropertyValueFactory("mail_tutor"));
            this.TLF_TUTOR.setCellValueFactory(new PropertyValueFactory("tlf_tutor"));
            ///llenado de los campos
            
   
            fctImp con = new fctImp();
            ObservableList<emp> items = con.consulta();
            tablaM.setItems(items);
           
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   
      
    }    

    @FXML
    private void selectHome(Event event) throws SQLException {
        
    }

    @FXML
    private void selecEmpre(Event event) throws SQLException {
        //llenado de combo
        lista=FXCollections.observableArrayList();
            lista.addAll("Completa","Parcial");
             TipoJorComb.setItems(lista);
    }

    @FXML
    private void selectAlum(Event event) throws SQLException {
        fctImp con = new fctImp();
        ComboAlumno.setItems(con.rellenaCombalum());
        ComboEmpresa.setItems(con.rellenaCombempre());
        ComboTutor.setItems(con.rellenaCombtut());
    }

    @FXML
    private void selecTab(Event event) {
        
          
    }

    @FXML
    private void inserta (ActionEvent event)throws SQLException{
           try{
                
           
                    fctImp tabla =new fctImp();
                    String cod= codigoEmpresaText.getText();
                    String nomE= nombreEmpresaText.getText();
                    String cf= cifText.getText();
                    String dire=direcciontext.getText();
                    String loc= localidadText.getText();
                    String cp= cpText.getText();
                    String tipJor= (String) TipoJorComb.getValue();
                    String dniResp=dniText.getText();
                    String nomResp=nombreRespText.getText();
                    String apeRes=apellidoRespText.getText();
                    String dniTut= dniRespText.getText();
                    String nomTut= nombreTutorText.getText();
                    String apeTut= apellidoTutorText.getText();
                    String mailTu= mailText.getText();
                    String tfTut= telefonoText.getText();

                   resultadoConsulta.setText(tabla.inserta(cod,nomE,cf,dire,loc,cp,tipJor,dniResp,nomResp,apeRes,dniTut,nomTut,apeTut,mailTu,tfTut));
                   //tabla.inserta(cod,nomE,cf,dire,loc,cp,tipJor,dniResp,nomResp,apeRes,dniTut,nomTut,apeTut,mailTu,tfTut);



                   fctImp con = new fctImp();
            ObservableList<emp> items = con.consulta();
            tablaM.setItems(items);


                } catch(NumberFormatException | SQLException ex){
                    codigoEmpresaText.setText("Solo puedes escribir numeros");


                }
    }

    @FXML
    private void borra(ActionEvent event) throws SQLException {
       
                try{
                    fctImp tabla =new fctImp();
                    String COD_EMPRESA= codigoEmpresaText.getText();

                    resultadoConsulta.setText(tabla.borra(COD_EMPRESA));
                    //tabla.borra(COD_EMPRESA);


                } catch(NumberFormatException | SQLException ex){
                    codigoEmpresaText.setText("solo puedes escribir numeros");

                } 
                fctImp con = new fctImp();
            ObservableList<emp> items = con.consulta();
            tablaM.setItems(items);
    }

    @FXML
    private void modifica(ActionEvent event) {
         try{
                    fctImp tabla =new fctImp();
                    String COD_EMPRESA= codigoEmpresaText.getText();
                    String NOM_EMPRESA= nombreEmpresaText.getText();
                    String CIF= cifText.getText();
                    String DIREC=direcciontext.getText();
                    String LOCALI= localidadText.getText();
                    String CP= cpText.getText();
                    String TIP_JORNADA= (String) TipoJorComb.getValue();
                    String DNI_RESP=dniText.getText();
                    String NOM_RESP=nombreRespText.getText();
                    String APELLIDO_RESP=apellidoRespText.getText();
                    String DNI_TUTOR= dniRespText.getText();
                    String NOM_TUTOR= nombreTutorText.getText();
                    String APE_TUTOR= apellidoTutorText.getText();
                    String MAIL_TUTOR= mailText.getText();
                    String TLF_TUTOR= telefonoText.getText();

                   resultadoConsulta.setText(tabla.modfica(COD_EMPRESA,NOM_EMPRESA,CIF,DIREC,LOCALI,CP,TIP_JORNADA,DNI_RESP,NOM_RESP,APELLIDO_RESP,DNI_TUTOR,NOM_TUTOR,APE_TUTOR,MAIL_TUTOR,TLF_TUTOR));
                  // tabla.modfica(COD_EMPRESA,NOM_EMPRESA,CIF,DIREC,LOCALI,CP,TIP_JORNADA,DNI_RESP,NOM_RESP,APELLIDO_RESP,DNI_TUTOR,NOM_TUTOR,APE_TUTOR,MAIL_TUTOR,TLF_TUTOR);


                   fctImp con = new fctImp();
                    ObservableList<emp> items = con.consulta();
                    tablaM.setItems(items);



                } catch(NumberFormatException | SQLException ex){
                    codigoEmpresaText.setText("Solo puedes escribir numeros");


                }
    }

    @FXML
    private void combox(ActionEvent event) {
          
      
    }

    @FXML
    private void Insertarclick(ActionEvent event) throws SQLException {
        
         fctImp con =new fctImp();
               
         try{
                //Recogemos Los datos seleccionados del JcomboBox
                String Nombrealum = (String) ComboAlumno.getValue();
                String Nombreempre = (String) ComboEmpresa.getValue();
                String Nombretutor = (String) ComboTutor.getValue();
                 Resultado.setText(con.texto(Nombrealum,Nombreempre,Nombretutor));
         }catch (NullPointerException g) {
                    Resultado.setText("Combo vacio");
                }

               
    }

    @FXML
    private void borratablas(ActionEvent event) {
         fctImp funciones =new fctImp();
                try {
                  
                    etiatbla.setText(funciones.borraTut());
                    etiatbla.setText(funciones.borraAlum());
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
    }

    @FXML
    private void InsertaTablas(ActionEvent event) {
        ///Funcionalidad
                fctImp funciones =new fctImp();
                try {
                    etiatbla.setText(funciones.FicherosATabla());
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        
    }

    @FXML
    private void borraAsignados(ActionEvent event) throws SQLException {
        fctImp con = new fctImp();
       
        
       Resultado.setText( con.borraAsig());
    }
    @FXML
    private void ayuda(ActionEvent event) {
        fctImp fctImp = new fctImp();
        fctImp.ayuda();
    }
}
