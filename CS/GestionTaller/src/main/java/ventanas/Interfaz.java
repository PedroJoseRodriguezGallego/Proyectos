package ventanas;

import conexion.Conexion;
import dao.TrabajoDAO;
import vo.Trabajo;

import java.awt.Desktop;
import java.io.File;
import java.util.*;
import javax.swing.JTable;
import net.sf.jasperreports.engine.*;


public class Interfaz extends javax.swing.JFrame 
{
    public Interfaz() 
    {
        setTitle("Proyecto Reportes PJRG");
        setResizable(false);
        
        initComponents();
        construirTabla();
        
        comboReportes.addItem("Todas las reparaciones");
        comboReportes.addItem("Todos los operarios");
        comboReportes.addItem("Reparacion segun operario");
        comboReportes.addItem("Reparacion segun fecha comienzo");
        comboReportes.addItem("Reparacion segun fecha fin");
        comboReportes.addItem("Operario segun DNI");
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        botonInsertarTrabajo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboReportes = new javax.swing.JComboBox();
        botonGenerarReporte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        textIdTrabajo = new javax.swing.JTextField();
        spinnerHorasTrabajadas = new javax.swing.JSpinner();
        spinnerReparacionesMecanicas = new javax.swing.JSpinner();
        spinnerReparacionesChapistas = new javax.swing.JSpinner();
        spinnerReparacionesRevisiones = new javax.swing.JSpinner();
        textPrecioMaterial = new javax.swing.JTextField();
        textIdOperario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        textFechaInicio = new javax.swing.JTextField();
        botonEliminarTrabajo = new javax.swing.JButton();
        botonModificarTrabajo = new javax.swing.JButton();
        botonBuscarID = new javax.swing.JButton();
        botonBuscarTodos = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textDNIOperario = new javax.swing.JTextField();
        textFechaFin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("ID Trabajo : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Descripción : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Horas trabajadas :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Precio del material : ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Reparaciones mecánicas : ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Fecha de inicio :");

        botonInsertarTrabajo.setText("Insertar");
        botonInsertarTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarTrabajoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Reparaciones chapistas  :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Reparaciones revisiones :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setText("ID Operario :");

        botonGenerarReporte.setText("Generar reporte");
        botonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarReporteActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        spinnerHorasTrabajadas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerReparacionesMecanicas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerReparacionesChapistas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerReparacionesRevisiones.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        textDescripcion.setColumns(20);
        textDescripcion.setRows(5);
        jScrollPane2.setViewportView(textDescripcion);

        botonEliminarTrabajo.setText("Eliminar");
        botonEliminarTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarTrabajoActionPerformed(evt);
            }
        });

        botonModificarTrabajo.setText("Modificar");
        botonModificarTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarTrabajoActionPerformed(evt);
            }
        });

        botonBuscarID.setText("Buscar por ID");
        botonBuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarIDActionPerformed(evt);
            }
        });

        botonBuscarTodos.setText("Buscar todos");
        botonBuscarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarTodosActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setText("DNI Operario :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setText("Fecha de fin :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonBuscarID, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBuscarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonInsertarTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonModificarTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonEliminarTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerReparacionesMecanicas)
                                    .addComponent(spinnerReparacionesChapistas)
                                    .addComponent(spinnerReparacionesRevisiones)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textPrecioMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(spinnerHorasTrabajadas)
                                    .addComponent(textIdOperario, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textDNIOperario)
                                    .addComponent(textFechaFin)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textIdTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(textFechaInicio))))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comboReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(botonGenerarReporte)
                        .addGap(258, 258, 258))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textIdTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(textIdOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textPrecioMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerHorasTrabajadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(textDNIOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerReparacionesMecanicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerReparacionesChapistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerReparacionesRevisiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonGenerarReporte)
                            .addComponent(comboReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonInsertarTrabajo)
                            .addComponent(botonEliminarTrabajo)
                            .addComponent(botonModificarTrabajo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonBuscarID)
                            .addComponent(botonBuscarTodos))
                        .addGap(15, 15, 15))))
        );

        pack();
    }

    private void botonInsertarTrabajoActionPerformed(java.awt.event.ActionEvent evt)
    {
        TrabajoDAO trabajoDAO = new TrabajoDAO();
        trabajoDAO.insertarTrabajo(textIdTrabajo, textDescripcion, spinnerHorasTrabajadas, textPrecioMaterial, spinnerReparacionesMecanicas, spinnerReparacionesChapistas, spinnerReparacionesRevisiones, textFechaInicio, textIdOperario);
        construirTabla();
    }

    private void botonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt)
    {
        String x = (String)comboReportes.getSelectedItem();
        
        TrabajoDAO trabajoDAO = new TrabajoDAO();
        trabajoDAO.obtenerFechaFin();
        
        if(x.equals("Todas las reparaciones"))
        {
            generarReporte("ReporteTrabajos");
        }
            else if(x.equals("Todos los operarios"))
            {
                generarReporte("ReporteOperarios");
            }
                else if(x.equals("Reparacion segun fecha comienzo"))
                {
                    generarReporte("ReporteFechaComienzo");
                }
                    else if(x.equals("Reparacion segun fecha fin"))
                    {
                        generarReporte("ReporteFechaFin");
                    }
                        else if(x.equals("Reparacion segun operario"))
                        {
                            generarReporte("ReporteTrabajoOperario");
                        }
                            else if(x.equals("Operario segun DNI"))
                            {
                                generarReporte("ReporteOperarioDNI");
                            }
        textIdOperario.setText(null);
        textDescripcion.setText(null);
        textDNIOperario.setText(null);
        textFechaFin.setText(null);
        textFechaInicio.setText(null);
        textIdTrabajo.setText(null);
        textPrecioMaterial.setText(null);
        spinnerHorasTrabajadas.setValue(0);
        spinnerReparacionesChapistas.setValue(0);
        spinnerReparacionesMecanicas.setValue(0);
        spinnerReparacionesRevisiones.setValue(0);
    }

    private void botonEliminarTrabajoActionPerformed(java.awt.event.ActionEvent evt)
    {
        TrabajoDAO trabajoDAO = new TrabajoDAO();
        trabajoDAO.eliminarTrabajo(textIdTrabajo, textDescripcion, spinnerHorasTrabajadas, textPrecioMaterial, spinnerReparacionesMecanicas, spinnerReparacionesChapistas, spinnerReparacionesRevisiones, textFechaInicio, textIdOperario, textDNIOperario, textFechaFin);
        construirTabla();
    }

    private void botonModificarTrabajoActionPerformed(java.awt.event.ActionEvent evt)
    {
        TrabajoDAO trabajoDAO = new TrabajoDAO();
        trabajoDAO.modificarTrabajo(textIdTrabajo, textDescripcion, spinnerHorasTrabajadas, textPrecioMaterial, spinnerReparacionesMecanicas, spinnerReparacionesChapistas, spinnerReparacionesRevisiones, textFechaInicio, textIdOperario);
        construirTabla();
    }

    private void botonBuscarTodosActionPerformed(java.awt.event.ActionEvent evt)
    {
        construirTabla();
    }

    private void botonBuscarIDActionPerformed(java.awt.event.ActionEvent evt)
    {
        construirTablaConcreto(Integer.parseInt(textIdTrabajo.getText()));
    }

    


    private javax.swing.JButton botonBuscarID;
    private javax.swing.JButton botonBuscarTodos;
    private javax.swing.JButton botonEliminarTrabajo;
    private javax.swing.JButton botonGenerarReporte;
    private javax.swing.JButton botonInsertarTrabajo;
    private javax.swing.JButton botonModificarTrabajo;
    private javax.swing.JComboBox comboReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spinnerHorasTrabajadas;
    private javax.swing.JSpinner spinnerReparacionesChapistas;
    private javax.swing.JSpinner spinnerReparacionesMecanicas;
    private javax.swing.JSpinner spinnerReparacionesRevisiones;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField textDNIOperario;
    private javax.swing.JTextArea textDescripcion;
    private javax.swing.JTextField textFechaFin;
    private javax.swing.JTextField textFechaInicio;
    private javax.swing.JTextField textIdOperario;
    private javax.swing.JTextField textIdTrabajo;
    private javax.swing.JTextField textPrecioMaterial;


    
    
    private void construirTabla() 
    {
        String titulos[] = { "ID Trabajo", "Descripcion", "Horas", "Precio", "Coste", "Mecanicanizados", "Chapados", "Revisiones", "Fecha Inicio", "Fecha Fin", "ID Operario" };
        String informacion[][] = obtenerDatos();
		
        tabla = new JTable(informacion, titulos);
        jScrollPane1.setViewportView(tabla);
    }
    
    
    
    private String[][] obtenerDatos() 
    {
        TrabajoDAO trabajoDAO = new TrabajoDAO();
        ArrayList<Trabajo> lista = trabajoDAO.buscarTrabajos();
		
        String Datos[][] = new String[lista.size()][11];
		
        for (int i = 0; i < lista.size(); i++) 
        {
            Datos[i][0] = lista.get(i).getId_trabajo() + "";
            Datos[i][1] = lista.get(i).getDescripcion() + "";
            Datos[i][2] = lista.get(i).getHoras() + "";
            Datos[i][3] = lista.get(i).getPrecio() + "";
            Datos[i][4] = lista.get(i).getCoste() + "";
            Datos[i][5] = lista.get(i).getReparacionesMecanicas() + "";
            Datos[i][6] = lista.get(i).getReparacionesChapistas() + "";
            Datos[i][7] = lista.get(i).getReparacionesRevisiones() + "";
            Datos[i][8] = lista.get(i).getFechaInicio() + "";
            Datos[i][9] = lista.get(i).getFechaFin() + "";
            Datos[i][10] = lista.get(i).getId_operario() + "";
        }
			
        return Datos;
    }
    
    
    
    private String[][] obtenerDatoConcreto(int num) 
    {
        TrabajoDAO trabajoDAO = new TrabajoDAO();
        ArrayList<Trabajo> lista = trabajoDAO.buscarTrabajoConcreto(num);
		
        String Datos[][] = new String[lista.size()][11];
		
        for (int i = 0; i < lista.size(); i++) 
        {
            Datos[i][0] = lista.get(i).getId_trabajo() + "";
            Datos[i][1] = lista.get(i).getDescripcion() + "";
            Datos[i][2] = lista.get(i).getHoras() + "";
            Datos[i][3] = lista.get(i).getPrecio() + "";
            Datos[i][4] = lista.get(i).getCoste() + "";
            Datos[i][5] = lista.get(i).getReparacionesMecanicas() + "";
            Datos[i][6] = lista.get(i).getReparacionesChapistas() + "";
            Datos[i][7] = lista.get(i).getReparacionesRevisiones() + "";
            Datos[i][8] = lista.get(i).getFechaInicio() + "";
            Datos[i][9] = lista.get(i).getFechaFin() + "";
            Datos[i][10] = lista.get(i).getId_operario() + "";
        }
			
        return Datos;
    }
    
    
    
    private void construirTablaConcreto(int num) 
    {
        String titulos[] = { "ID Trabajo", "Descripcion", "Horas", "Precio", "Coste", "Mecanicanizados", "Chapados", "Revisiones", "Fecha Inicio", "Fecha Fin", "ID Operario" };
        String informacion[][] = obtenerDatoConcreto(num);
		
        tabla = new JTable(informacion, titulos);
        jScrollPane1.setViewportView(tabla);
    }
    
    
    
    public void generarReporte(String reporte)
    {
        JasperReport archivo;

        try
        {
            archivo = JasperCompileManager.compileReport("src/main/resources/reportes/" + reporte + ".jrxml");
            Conexion con = new Conexion();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("dniJAVA",textDNIOperario.getText());
            map.put("fechaInicioJAVA",textFechaInicio.getText());
            map.put("fechaJAVA",textFechaFin.getText());
            map.put("operarioJAVA",textIdOperario.getText());
            JasperPrint prin = JasperFillManager.fillReport(archivo,map,con.getConnection());
            JasperExportManager.exportReportToPdfFile(prin,"src/main/resources/generados/" + reporte + ".pdf");

            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File("src/main/resources/generados/" + reporte + ".pdf"));
        }
            catch (Exception e)
            {
                e.printStackTrace();
            }
    }
    
}