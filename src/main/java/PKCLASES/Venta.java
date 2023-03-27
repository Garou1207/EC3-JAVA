package PKCLASES;

import javax.swing.Icon;
import java.awt.Image;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.util.Locale;

public class Venta {
       
    public static void actualizarHoraYFecha(JLabel lblReloj, JLabel lblFecha) {
        Timer timer = new Timer(1000, (ActionEvent e) -> {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String fecha = dateFormat.format(date);
        String hora = timeFormat.format(date);
        lblFecha.setText(fecha);
        lblReloj.setText(hora);
    });
    timer.setInitialDelay(0);
    timer.start();
    }
    
    public static void agregarArticulos(JComboBox cboarticulos)
    {
        cboarticulos.removeAllItems();
        cboarticulos.addItem("Seleccione");
        cboarticulos.addItem("Cpu");
        cboarticulos.addItem("Impresora");
        cboarticulos.addItem("Lectora");
        cboarticulos.addItem("Monitor");
        cboarticulos.addItem("Mouse");
        cboarticulos.addItem("Scanner");
        cboarticulos.addItem("Teclado");
        cboarticulos.addItem("Webcam");
    }
    
    public static void mostrarImagen(String nombre, JLabel jfoto)
    {
        ImageIcon icono = new ImageIcon("src/main/java/PKIMAGENES/"+nombre+".jpg");
        Icon icon = new ImageIcon(icono.getImage().getScaledInstance(jfoto.getWidth(),jfoto.getHeight(),Image.SCALE_DEFAULT));
        jfoto.setIcon(icon);
    }
    
    public static void agregarEmpleados(JComboBox cboEmpleados)
    {
        String[] empleados = { "Seleccione", "Juan Perez", "Maria Alarcon", "Jose Hernandez", "Julia Lopez", "Pedro Gomez" };
        cboEmpleados.setModel(new javax.swing.DefaultComboBoxModel<>(empleados));
        cboEmpleados.setSelectedIndex(0);
    }
    
    public static void agregarClientes(JComboBox cboClientes)
    {
        String[] clientes = { "Seleccione", "Carlos Garcia", "Juana Rodrigez", "Ana Huaman", "Rodrigo Sanchez", "Mauro Castillo" };
        cboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(clientes));
        cboClientes.setSelectedIndex(0);
    }
    
    static DefaultTableModel dfm = new DefaultTableModel();
    public static void columnas(JTable jt){
        jt.setModel(dfm);
        dfm.setColumnCount(0);
        dfm.addColumn("Producto");
        dfm.addColumn("Precio");
        dfm.addColumn("Cantidad");
        dfm.addColumn("Descuento");
        dfm.addColumn("Total");
        
        jt.getColumnModel().getColumn(0).setPreferredWidth(180);
        jt.getColumnModel().getColumn(1).setPreferredWidth(80);
        jt.getColumnModel().getColumn(2).setPreferredWidth(80);
        jt.getColumnModel().getColumn(3).setPreferredWidth(80);
        jt.getColumnModel().getColumn(4).setPreferredWidth(80);
        
    }
    
    public static double obtenerPrecio(int indice)
    {
        double[] precios={0.0,1600.5,800.5,120.34,500.5,200.5,140.20,180.5,80.5};
        return precios[indice];
    }
    
    public static double obtenerDescuento(double precio, int descuento, int cantidad){
        double precioOriginal = precio * cantidad;
        double porcentaje =  descuento / 100.0;
        double descuentoAplicado = precioOriginal * porcentaje;
        return descuentoAplicado;
    }
    
    public static double obtenerTotal(double precio, int descuento, int cantidad){
        double precioOriginal = precio * cantidad;
        double porcentaje =  descuento / 100.0;
        double descuentoAplicado = precioOriginal * porcentaje;
        double precioConDescuento = precioOriginal - descuentoAplicado;
        return precioConDescuento;
    }
    
    public static double obtenerTotalVenta(JTable jt){
        double sumatotal = 0;
            for(int i=0; i<jt.getRowCount(); i++){
                sumatotal += (double)dfm.getValueAt(i,3);
            }
        return sumatotal;
    } 
    
    public static void actualizarNumeroProductos(JTable jt, JTextField txtnroproductos, JTextField txtotalventa) {
        DefaultTableModel modelo = (DefaultTableModel) jt.getModel();
        int nroProductos = modelo.getRowCount();
        double totalVenta = 0.0;
        for (int i = 0; i < nroProductos; i++) {
            double precioConDescuento = Double.parseDouble(modelo.getValueAt(i, 3).toString());
            int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());
            totalVenta += precioConDescuento * cantidad;
        }
        txtnroproductos.setText(String.valueOf(nroProductos));
        txtotalventa.setText(String.format(Locale.US, "%.2f", totalVenta));
    }
  
    public static void agregarArticulosTabla(JTable jt, JComboBox cboarticulos, double precio, int cantidad, double descuento, double total){
        for (int i = 0; i < jt.getRowCount(); i++){
            if(dfm.getValueAt(i,0).equals(cboarticulos.getSelectedItem())){
            JOptionPane.showMessageDialog(null,"El Producto ya existe");
            return;
            }
        }
        
        dfm.addRow(new Object[]{cboarticulos.getSelectedItem(), precio, cantidad, descuento, total});  
    }
    
    public static void quitarArticulosTabla(JTable jt) {
    DefaultTableModel modelo = (DefaultTableModel) jt.getModel();
    int filaSeleccionada = jt.getSelectedRow();
    if (filaSeleccionada != -1) {
        modelo.removeRow(filaSeleccionada);
        }
    }
    
    public static void cancelarArticulosTabla(JTable jt){
        DefaultTableModel modelo = (DefaultTableModel) jt.getModel();
        modelo.setRowCount(0);
    }

    
    public static void limpiarControles(JTextField[] contenidoText, JComboBox[] contenidoCombo, JTable[] contenidoTable, JCheckBox[] contenidoCheck, JSpinner contenidoSpinner)
    {
    for (int i = 0; i < contenidoText.length; i++) {
        contenidoText[i].setText("");
    }
    for (int i = 0; i < contenidoCombo.length; i++) {
        contenidoCombo[i].setSelectedIndex(0);
    }
    for (int i = 0; i < contenidoTable.length; i++) {
        DefaultTableModel modelo = (DefaultTableModel) contenidoTable[i].getModel();
        modelo.setRowCount(0);
    }
    for (int i = 0; i < contenidoCheck.length; i++) {
        contenidoCheck[i].setSelected(false);
    }
    contenidoSpinner.setValue(0);
    }
}
