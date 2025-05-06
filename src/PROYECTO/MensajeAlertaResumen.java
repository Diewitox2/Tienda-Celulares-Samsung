package PROYECTO;

import javax.swing.*;
import java.awt.*;

public class MensajeAlertaResumen extends JFrame {

    public MensajeAlertaResumen(int totalVentas, double importeAcumulado, double cuotaDiaria) {
        setTitle("Resumen de Ventas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 245, 255));

        JLabel titulo = new JLabel("\uD83D\uDCCA Mensaje de Alerta", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(titulo, BorderLayout.NORTH);

        JPanel panelDatos = new JPanel();
        panelDatos.setBackground(new Color(240, 245, 255));
        panelDatos.setLayout(new GridLayout(4, 1, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JLabel lblVentas = new JLabel("Total de Ventas: " + totalVentas);
        JLabel lblImporte = new JLabel("Importe Acumulado: $" + String.format("%.2f", importeAcumulado));
        double porcentaje = (importeAcumulado / cuotaDiaria) * 100;
        JLabel lblPorcentaje = new JLabel("Porcentaje de Cuota Diaria: " + String.format("%.2f", porcentaje) + "%");
        JLabel lblCuota = new JLabel("Meta Diaria: $" + (int) cuotaDiaria);

        for (JLabel label : new JLabel[]{lblVentas, lblImporte, lblPorcentaje, lblCuota}) {
            label.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            panelDatos.add(label);
        }

        add(panelDatos, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setPreferredSize(new Dimension(100, 30));
        btnCerrar.setBackground(new Color(110, 135, 180));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(e -> dispose());

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(240, 245, 255));
        panelBoton.add(btnCerrar);
        add(panelBoton, BorderLayout.SOUTH);

        setVisible(true);
    }
}

