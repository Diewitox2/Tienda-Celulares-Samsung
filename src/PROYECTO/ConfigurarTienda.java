package PROYECTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfigurarTienda extends JFrame {

    public ConfigurarTienda() {
        setTitle("Acerca de Tienda");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Colores Samsung
        Color azulSamsung = new Color(0, 51, 160);
        Color fondo = Color.WHITE;

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(fondo);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Logo Samsung (asegúrate de tener esta ruta válida)
        ImageIcon logo = new ImageIcon("C:\\Users\\Usuario\\OneDrive\\Imágenes\\12.PNG");
        Image img = logo.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblLogo);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel lblTitulo = new JLabel("Tienda 1.0");
        lblTitulo.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
        lblTitulo.setForeground(azulSamsung);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTitulo);

        panel.add(Box.createRigidArea(new Dimension(0, 12)));

        JSeparator separador = new JSeparator();
        separador.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        panel.add(separador);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel lblAutores = new JLabel("Autores");
        lblAutores.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblAutores.setForeground(new Color(50, 50, 50));
        lblAutores.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblAutores);
        panel.add(Box.createRigidArea(new Dimension(0, 12)));

        String[] nombres = {
            "Diego Renato Alcantara Delgadillo",
            "Brayan Saul Calzada Tinta",
            "Francesco Carlos Ayala Barrera"
        };

        for (String nombre : nombres) {
            JLabel lblNombre = new JLabel(nombre);
            lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblNombre.setForeground(new Color(80, 80, 80));
            lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(lblNombre);
        }

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBackground(azulSamsung);
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCerrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrar.setPreferredSize(new Dimension(100, 30));
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(btnCerrar);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ConfigurarTienda();
    }
}