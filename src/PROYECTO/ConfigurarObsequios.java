
package PROYECTO;

import javax.swing.*;
import java.awt.*;

public class ConfigurarObsequios extends JFrame {

    public ConfigurarObsequios() {
        setTitle("Configuración de Obsequios");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 240, 255));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        add(panel);

        JLabel titulo = new JLabel("\uD83C\uDF81 Configurar Obsequios");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(new Color(0, 70, 140));
        panel.add(titulo);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JTextField txtObsequio1 = crearCampo(panel, "1 - 2 unidades:", "Audífonos Samsung");
        JTextField txtObsequio2 = crearCampo(panel, "3 - 4 unidades:", "PowerBank");
        JTextField txtObsequio3 = crearCampo(panel, "5 o más unidades:", "SmartWatch");

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton guardar = new JButton("Guardar Cambios");
        guardar.setAlignmentX(Component.CENTER_ALIGNMENT);
        guardar.setBackground(new Color(0, 102, 204));
        guardar.setForeground(Color.WHITE);
        guardar.setFocusPainted(false);
        guardar.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        guardar.addActionListener(e -> {
            String mensaje = "Obsequios actualizados:\n\n" +
                    "1 - 2 unidades: " + txtObsequio1.getText() + "\n" +
                    "3 - 4 unidades: " + txtObsequio2.getText() + "\n" +
                    "5 o más unidades: " + txtObsequio3.getText();
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
        new ConfigurarObsequios();
    }
}