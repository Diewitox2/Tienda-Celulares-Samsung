package PROYECTO;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ActualizarCelular extends JFrame {

    private JPanel contentPane;
    private JTextField txtPrecio, txtPantalla, txtRAM, txtAlmacenamiento, txtBateria, txtCamara, txtSO;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ActualizarCelular frame = new ActualizarCelular();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ActualizarCelular() {
        setTitle("Actualizar Celular");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        // Colores Samsung
        Color azulSamsung = new Color(180, 200, 255);
        Color fondo = new Color(240, 245, 255);

        contentPane = new JPanel();
        contentPane.setBackground(fondo);
        contentPane.setBorder(new EmptyBorder(20, 30, 20, 30));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 20));

        // Panel superior con icono + título
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelSuperior.setBackground(fondo);

        JLabel lblIcono = new JLabel("\u260E"); // Teléfono unicode
        lblIcono.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        lblIcono.setForeground(new Color(100, 130, 200));
        panelSuperior.add(lblIcono);

        JLabel lblTitulo = new JLabel("Actualizar datos del celular");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(Color.DARK_GRAY);
        panelSuperior.add(lblTitulo);

        contentPane.add(panelSuperior, BorderLayout.NORTH);

        // Panel central con formulario
        JPanel panelFormulario = new JPanel(new GridLayout(7, 2, 10, 10));
        panelFormulario.setBackground(fondo);
        contentPane.add(panelFormulario, BorderLayout.CENTER);

        Font fuente = new Font("Segoe UI", Font.PLAIN, 14);

        panelFormulario.add(crearEtiqueta("Precio:", fuente));
        txtPrecio = new JTextField(); panelFormulario.add(txtPrecio);

        panelFormulario.add(crearEtiqueta("Pantalla:", fuente));
        txtPantalla = new JTextField(); panelFormulario.add(txtPantalla);

        panelFormulario.add(crearEtiqueta("RAM:", fuente));
        txtRAM = new JTextField(); panelFormulario.add(txtRAM);

        panelFormulario.add(crearEtiqueta("Almacenamiento:", fuente));
        txtAlmacenamiento = new JTextField(); panelFormulario.add(txtAlmacenamiento);

        panelFormulario.add(crearEtiqueta("Batería:", fuente));
        txtBateria = new JTextField(); panelFormulario.add(txtBateria);

        panelFormulario.add(crearEtiqueta("Cámara:", fuente));
        txtCamara = new JTextField(); panelFormulario.add(txtCamara);

        panelFormulario.add(crearEtiqueta("Sistema Operativo:", fuente));
        txtSO = new JTextField(); panelFormulario.add(txtSO);

        // Botón Actualizar
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(azulSamsung);
        btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setBorder(new LineBorder(Color.GRAY, 1, true));
        contentPane.add(btnActualizar, BorderLayout.SOUTH);
    }

    private JLabel crearEtiqueta(String texto, Font fuente) {
        JLabel etiqueta = new JLabel(texto, SwingConstants.RIGHT);
        etiqueta.setFont(fuente);
        return etiqueta;
    }
}