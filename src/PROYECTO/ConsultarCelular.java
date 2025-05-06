package PROYECTO;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ConsultarCelular extends JFrame {

    private JTextField txtPrecio;
    private JTextField txtPantalla;
    private JTextField txtRam;
    private JTextField txtAlmacenamiento;
    private JTextField txtBateria;
    private JTextField txtCamara;
    private JTextField txtSO;

    public ConsultarCelular() {
        setTitle("Consultar Celular");
        setSize(360, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 248, 255)); // Fondo estilo Samsung

        // Ícono (opcional)
        // setIconImage(new ImageIcon("ruta/del/logo.png").getImage());

        JLabel titulo = new JLabel("Consulta de celular");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setBounds(70, 20, 250, 30);
        add(titulo);

        int y = 70;
        int separacion = 35;

        addLabel("Precio:", 30, y);
        txtPrecio = addField(y);
        y += separacion;

        addLabel("Pantalla:", 30, y);
        txtPantalla = addField(y);
        y += separacion;

        addLabel("RAM:", 30, y);
        txtRam = addField(y);
        y += separacion;

        addLabel("Almacenamiento:", 30, y);
        txtAlmacenamiento = addField(y);
        y += separacion;

        addLabel("Bateria:", 30, y);
        txtBateria = addField(y);
        y += separacion;

        addLabel("Camara:", 30, y);
        txtCamara = addField(y);
        y += separacion;

        addLabel("Sistema Operativo:", 30, y);
        txtSO = addField(y);
        y += separacion;

        // Botón elegante de cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(120, y + 10, 100, 30);
        btnCerrar.setBackground(new Color(0, 120, 215)); // Azul Samsung
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar);

        mostrarDatosEjemplo(); // Datos de muestra para previsualización
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setBounds(x, y, 150, 25);
        add(label);
    }

    private JTextField addField(int y) {
        JTextField field = new JTextField();
        field.setBounds(160, y, 150, 25);
        field.setEditable(false);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(field);
        return field;
    }

    private void mostrarDatosEjemplo() {
        txtPrecio.setText("999.99");
        txtPantalla.setText("6.5 pulgadas");
        txtRam.setText("8 GB");
        txtAlmacenamiento.setText("128 GB");
        txtBateria.setText("5000 mAh");
        txtCamara.setText("64 MP");
        txtSO.setText("Android 13");
    }

    // Método main para probar esta pantalla
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ConsultarCelular frame = new ConsultarCelular();
            frame.setVisible(true);
        });
    }
}