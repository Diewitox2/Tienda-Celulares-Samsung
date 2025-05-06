package PROYECTO;

import javax.swing.*;
import java.awt.*;

public class MantenimientoCelulares extends JFrame {
    public MantenimientoCelulares() {
        setTitle("Mantenimiento de Celulares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(240, 245, 255));

        // Título
        JLabel lblTitulo = new JLabel("📱 Mantenimiento de Celulares", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(0, 70, 140));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Panel de tarjetas
        JPanel panelTarjetas = new JPanel();
        panelTarjetas.setLayout(new BoxLayout(panelTarjetas, BoxLayout.Y_AXIS));
        panelTarjetas.setBackground(new Color(240, 245, 255));

        String[] celulares = {
            "Galaxy S23 Ultra;Samsung;$1199;6.8\";12GB;512GB;5000mAh;108MP;Android 13",
            "Galaxy A54;Samsung;$449;6.4\";8GB;128GB;5000mAh;50MP;Android 13",
            "Galaxy Z Fold5;Samsung;$1799;7.6\";12GB;512GB;4400mAh;50MP;Android 13",
            "Galaxy S24+;Samsung;$999;6.7\";12GB;256GB;4900mAh;50MP;Android 14",
            "Galaxy A15 5G;Samsung;$199;6.5\";4GB;128GB;5000mAh;50MP;Android 14"
        };

        for (String info : celulares) {
            panelTarjetas.add(crearTarjeta(info));
            panelTarjetas.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        JScrollPane scrollPane = new JScrollPane(panelTarjetas);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setBackground(new Color(240, 245, 255));

        JButton btnActualizar = new JButton("🔄 Actualizar");
        JButton btnEliminar = new JButton("🗑 Eliminar");

        for (JButton btn : new JButton[]{btnActualizar, btnEliminar}) {
            btn.setBackground(new Color(0, 95, 180));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(120, 30));
            panelBotones.add(btn);
        }

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        add(panelPrincipal);
    }

    private JPanel crearTarjeta(String datos) {
        String[] d = datos.split(";");
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 220, 250)),
                BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        tarjeta.setMaximumSize(new Dimension(450, 180));
        tarjeta.setAlignmentX(Component.CENTER_ALIGNMENT);

        tarjeta.add(crearEtiqueta("📌 Modelo: " + d[0], true));
        tarjeta.add(crearEtiqueta("Marca: " + d[1], false));
        tarjeta.add(crearEtiqueta("Precio: " + d[2], false));
        tarjeta.add(crearEtiqueta("Pantalla: " + d[3], false));
        tarjeta.add(crearEtiqueta("RAM: " + d[4], false));
        tarjeta.add(crearEtiqueta("Almacenamiento: " + d[5], false));
        tarjeta.add(crearEtiqueta("Batería: " + d[6], false));
        tarjeta.add(crearEtiqueta("Cámara: " + d[7], false));
        tarjeta.add(crearEtiqueta("Sistema Operativo: " + d[8], false));
        return tarjeta;
    }

    private JLabel crearEtiqueta(String texto, boolean negrita) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Segoe UI", negrita ? Font.BOLD : Font.PLAIN, 13));
        lbl.setForeground(new Color(40, 40, 40));
        return lbl;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MantenimientoCelulares().setVisible(true);
        });
    }
}
