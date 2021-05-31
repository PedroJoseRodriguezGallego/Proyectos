package Chat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class Servidor extends JFrame implements ActionListener, Runnable
{
    static MulticastSocket multicastSocket = null;
    static byte[] buffer = new byte[1000];
    static InetAddress grupo = null;
    static int puerto = 12345;

    static JTextField jTextField = new JTextField();
    private JScrollPane jScrollPane;
    static JTextArea jTextArea;
    JButton botonEnviar = new JButton("Enviar");
    JButton botonDesconectar = new JButton("Salir");
    boolean repetir = true;
    String nombre;



    public Servidor(String nom)
    {
        super("Servidor actividad1 PJRG : " + nom);
        setLayout(null);
        this.nombre = nom;
        jTextField.setBounds(10, 10, 400, 30);
        add(jTextField);
        jTextArea = new JTextArea();
        jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setBounds(10, 50, 400, 300);
        add(jScrollPane);
        botonEnviar.setBounds(420, 10, 100, 30);
        add(botonEnviar);
        botonDesconectar.setBounds(420, 50, 100, 30);
        add(botonDesconectar);

        jTextArea.setEditable(false);
        botonEnviar.addActionListener(this);
        botonDesconectar.addActionListener(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == botonEnviar)
        {
            String texto = nombre + " : " + jTextField.getText();
            try
            {
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), grupo, puerto);
                multicastSocket.send(paquete);
            }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
        }

        if (e.getSource() == botonDesconectar)
        {
                multicastSocket.close();
                repetir = false;
                System.exit(0);
        }
    }


    public void run()
    {
        while (repetir)
        {
            try
            {
                DatagramPacket p = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(p);
                String texto = new String(p.getData(), 0, p.getLength());
                jTextArea.append(texto + "\n\n");
            }
            catch (Exception e)
            {
                System.out.println("Servidor cerrado");
            }
        }
    }

    public static void main(String args[]) throws IOException
    {
        multicastSocket = new MulticastSocket(puerto);
        grupo = InetAddress.getByName("225.0.0.1");
        multicastSocket.joinGroup(grupo);

        Servidor server = new Servidor("Servidor");
        server.setBounds(0, 0, 550, 400);
        server.setVisible(true);
        new Thread(server).start();
    }
}