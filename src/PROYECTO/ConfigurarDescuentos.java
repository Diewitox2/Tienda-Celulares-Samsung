package PROYECTO;

import javax.swing.*;
import java.awt.*;

public class ConfigurarDescuentos extends JFrame {

    public ConfigurarDescuentos() {
        setTitle("Configuración de Descuentos");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 240, 255));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        add(panel);

        JLabel titulo = new JLabel("\u2699\ufe0f Configurar Descuentos");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(new Color(0, 70, 140));
        panel.add(titulo);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JTextField txtEfectivo = crearCampo(panel, "Efectivo (%):", "0.0");
        JTextField txtBBVA = crearCampo(panel, "BBVA (%):", "5.0");
        JTextField txtMaster = crearCampo(panel, "MasterCard (%):", "3.0");

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton guardar = new JButton("Guardar Cambios");
        guardar.setAlignmentX(Component.CENTER_ALIGNMENT);
        guardar.setBackground(new Color(0, 102, 204));
        guardar.setForeground(Color.WHITE);
        guardar.setFocusPainted(false);
        guardar.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        guardar.addActionListener(e -> {
            String mensaje = "Descuentos actualizados:\n\n" +
                    "Efectivo: " + txtEfectivo.getText() + "%\n" +
                    "BBVA: " + txtBBVA.getText() + "%\n" +
                    "MasterCard: " + txtMaster.getText() + "%";
            JOptionPane.showMessageDialog(this, mensaje, "Cambios Guardados", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(guardar);
        setVisible(true);
    }

    private JTextField crearCampo(JPanel panel, String etiqueta, String valorInicial) {
        JLabel label = new JLabel(etiqueta);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField campo = new JTextField(valorInicial);
        campo.setMaximumSize(new Dimension(300, 30));
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(label);
        panel.add(campo);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        return campo;
    }

    public static void main(String[] args) {
        new ConfigurarDescuentos();
    }
}

