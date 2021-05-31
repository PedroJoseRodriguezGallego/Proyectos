package Chat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class Cliente extends JFrame implements ActionListener, Runnable
{
    static MulticastSocket multicastSocket = null;
    static byte[] buffer = new byte[1000];
    static InetAddress grupo = null;
    static int puerto = 12345;

    private JScrollPane jScrollPane;
    static JTextArea jTextArea;
    static JTextField jTextField = new JTextField();

    JButton botonDesconectar = new JButton("Salir");
    JButton botonEnviar = new JButton("Enviar");
    boolean repetir = true;
    String nombre;



    public Cliente(String nom)
    {
        super("Cliente actividad1 PJRG : " + nom);
        setLayout(null);
        this.nombre = nom;

        jTextField.setBounds(10, 10, 400, 30);
        add(jTextField);
        jTextArea = new JTextArea();
        jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setBounds(10, 50, 400, 300);
        add(jScrollPane);

        botonDesconectar.setBounds(420, 50, 100, 30);
        add(botonDesconectar);

        botonEnviar.setBounds(420, 10, 100, 30);
        add(botonEnviar);

        jTextArea.setEditable(false);
        setResizable(false);
        botonDesconectar.addActionListener(this);
        botonEnviar.addActionListener(this);
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
                    System.out.println("Cliente cerrado");
                }
        }
    }



    public static void main(String args[]) throws IOException
    {
        String nombre = JOptionPane.showInputDialog("Usuario para cliente : ");

        multicastSocket = new MulticastSocket(puerto);
        grupo = InetAddress.getByName("225.0.0.1");
        multicastSocket.joinGroup(grupo);

        Cliente server = new Cliente(nombre);
        server.setBounds(0, 0, 550, 400);
        server.setVisible(true);
        new Thread(server).start();
    }
}