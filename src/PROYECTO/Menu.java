package PROYECTO;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Menu extends JFrame {

    private JPanel contentPane;
    private JPanel botonera;
    private JButton btnRegistrar;
    private JButton btnConsultar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnListar;
    private JButton btnEstadisticas;
    private JButton btnSalir;

    public Menu() {
        setTitle("Sistema de Gestion de Casos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 245, 255));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel titulo = new JLabel("Sistema de Gestion de Casos");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(100, 20, 400, 30);
        contentPane.add(titulo);

        JLabel logo = new JLabel();
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setIcon(new ImageIcon("C:\\Users\\Usuario\\OneDrive\\Imágenes\\12 (1).png")); // Cambiar si es necesario
        logo.setBorder(new LineBorder(Color.GRAY, 1, true));
        logo.setBounds(150, 70, 300, 100);
        contentPane.add(logo);

        botonera = new JPanel();
        botonera.setBounds(100, 200, 400, 220);
        botonera.setLayout(new GridLayout(3, 2, 20, 20));
        botonera.setBackground(new Color(240, 245, 255));
        botonera.setBorder(new LineBorder(new Color(200, 220, 255), 1, true));
        contentPane.add(botonera);

        // Crear botones directamente (sin usar método auxiliar)
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(new Color(200, 220, 255));
        btnRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnRegistrar.setFocusPainted(false);
        botonera.add(btnRegistrar);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBackground(new Color(200, 220, 255));
        btnConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnConsultar.setFocusPainted(false);
        botonera.add(btnConsultar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(new Color(200, 220, 255));
        btnActualizar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnActualizar.setFocusPainted(false);
        botonera.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(200, 220, 255));
        btnEliminar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEliminar.setFocusPainted(false);
        botonera.add(btnEliminar);

        btnListar = new JButton("Listar");
        btnListar.setBackground(new Color(200, 220, 255));
        btnListar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnListar.setFocusPainted(false);
        botonera.add(btnListar);

        btnEstadisticas = new JButton("Estadisticas");
        btnEstadisticas.setBackground(new Color(200, 220, 255));
        btnEstadisticas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEstadisticas.setFocusPainted(false);
        botonera.add(btnEstadisticas);

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(200, 220, 255));
        btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnSalir.setFocusPainted(false);
        btnSalir.setBounds(240, 430, 100, 30);
        btnSalir.addActionListener(e -> System.exit(0));
        contentPane.add(btnSalir);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
}