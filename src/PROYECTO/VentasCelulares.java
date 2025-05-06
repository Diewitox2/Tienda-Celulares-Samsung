package PROYECTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class VentasCelulares extends JFrame {
    private JTextField txtNombreCliente;
    private JComboBox<String> comboModelo;
    private JLabel lblPrecio;
    private JTextField txtCantidad;
    private JComboBox<String> comboPago;
    private JButton btnVender;

    private HashMap<String, Double> precios = new HashMap<>();
    private HashMap<String, Double> descuentos = new HashMap<>();

    // Variables acumuladas
    private static int totalVentas = 0;
    private static double importeAcumulado = 0;
    private static final double CUOTA_DIARIA = 5000.0;

    public VentasCelulares() {
        setTitle("Ventas de Celulares");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(239, 243, 255));
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("\uD83D\uDCF1 Realizar Venta");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(new Color(40, 60, 90));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(titulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        txtNombreCliente = crearCampo(panelPrincipal, "Nombre del Cliente:");

        precios.put("Galaxy S23 Ultra", 4899.0);
        precios.put("Galaxy A54", 1499.0);
        precios.put("Galaxy Z Fold5", 7999.0);
        precios.put("Galaxy A15", 699.0);
        precios.put("Galaxy S24+", 4299.0);

        comboModelo = new JComboBox<>(precios.keySet().toArray(new String[0]));
        comboModelo.setMaximumSize(new Dimension(300, 30));
        comboModelo.addActionListener(e -> actualizarPrecio());
        agregarCampo(panelPrincipal, "Modelo de Celular:", comboModelo);

        lblPrecio = new JLabel("Precio (unidad): S/0.00");
        lblPrecio.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(lblPrecio);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        actualizarPrecio();

        txtCantidad = crearCampo(panelPrincipal, "Cantidad:");

        comboPago = new JComboBox<>(new String[]{"Efectivo", "BBVA", "MasterCard"});
        comboPago.setMaximumSize(new Dimension(300, 30));
        agregarCampo(panelPrincipal, "Método de Pago:", comboPago);

        descuentos.put("Efectivo", 0.0);
        descuentos.put("BBVA", 0.05);
        descuentos.put("MasterCard", 0.03);

        btnVender = new JButton("Vender");
        btnVender.setBackground(new Color(108, 122, 137));
        btnVender.setForeground(Color.WHITE);
        btnVender.setFocusPainted(false);
        btnVender.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVender.addActionListener(e -> mostrarBoleta());
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnVender);

        add(panelPrincipal, BorderLayout.CENTER);
        setVisible(true);
    }

    private JTextField crearCampo(JPanel panel, String etiqueta) {
        JLabel label = new JLabel(etiqueta);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label);
        JTextField campo = new JTextField();
        campo.setMaximumSize(new Dimension(300, 30));
        panel.add(campo);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        return campo;
    }

    private void agregarCampo(JPanel panel, String etiqueta, JComponent componente) {
        JLabel label = new JLabel(etiqueta);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label);
        panel.add(componente);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    private void actualizarPrecio() {
        String modelo = (String) comboModelo.getSelectedItem();
        double precio = precios.getOrDefault(modelo, 0.0);
        lblPrecio.setText("Precio (unidad): S/" + precio);
    }

    private void mostrarBoleta() {
        String cliente = txtNombreCliente.getText();
        String modelo = (String) comboModelo.getSelectedItem();
        String metodoPago = (String) comboPago.getSelectedItem();
        double precioUnidad = precios.getOrDefault(modelo, 0.0);

        int cantidad;
        try {
            cantidad = Integer.parseInt(txtCantidad.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double subtotal = precioUnidad * cantidad;
        double porcentajeDescuento = descuentos.getOrDefault(metodoPago, 0.0);
        double descuento = subtotal * porcentajeDescuento;
        double total = subtotal - descuento;

        String regalo = "Ninguno";
        if (cantidad >= 1 && cantidad <= 2) regalo = "Audífonos Samsung";
        else if (cantidad >= 3 && cantidad <= 4) regalo = "PowerBank";
        else if (cantidad >= 5) regalo = "SmartWatch";

        StringBuilder boleta = new StringBuilder();
        boleta.append("\uD83D\uDCC4 BOLETA DE VENTA\n\n");
        boleta.append("\uD83D\uDC64 Cliente: ").append(cliente).append("\n");
        boleta.append("\uD83D\uDCF1 Modelo: ").append(modelo).append("\n");
        boleta.append("\uD83D\uDCB3 Método de Pago: ").append(metodoPago).append("\n");
        boleta.append("\uD83D\uDD22 Cantidad: ").append(cantidad).append("\n");
        boleta.append("\uD83D\uDCB0 Subtotal: S/").append(String.format("%.2f", subtotal)).append("\n");
        boleta.append("\u2796 Descuento: S/").append(String.format("%.2f", descuento)).append("\n");
        boleta.append("\uD83D\uDCB5 Total a Pagar: S/").append(String.format("%.2f", total)).append("\n\n");
        boleta.append("\uD83C\uDF81 Regalo: ").append(regalo);

        JOptionPane.showMessageDialog(this, boleta.toString(), "Boleta de Venta", JOptionPane.INFORMATION_MESSAGE);

        totalVentas++;
        importeAcumulado += total;

        new MensajeAlertaResumen(totalVentas, importeAcumulado, CUOTA_DIARIA);
    }

    public static void main(String[] args) {
        new VentasCelulares();
    }
}