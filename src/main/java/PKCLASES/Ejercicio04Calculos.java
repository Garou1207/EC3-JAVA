package PKCLASES;

//Importar Funciones
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class Ejercicio04Calculos {
    
    public static void actualizarFechaHora(JLabel lblReloj, JLabel lblFecha) 
    {
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
    
    public static double obtenerPrecio(int indice)
    {
        double[] precios={0.00,1600.55,800.50,120.34,500.50,200.50,140.20,180.50,80.50};
        return precios[indice];
    }

    public static double obtenerDescuento(double precio, int descuento, int cantidad)
    {
        double precioOriginal = precio * cantidad;
        double porcentaje =  descuento / 100.0;
        double descuentoAplicado = precioOriginal * porcentaje;
        return descuentoAplicado;
    }
    
    public static double obtenerTotal(double precio, int descuento, int cantidad)
    {
        double precioOriginal = precio * cantidad;
        double porcentaje =  descuento / 100.0;
        double descuentoAplicado = precioOriginal * porcentaje;
        double precioConDescuento = precioOriginal - descuentoAplicado;
        return precioConDescuento;
    }
    
    static DefaultTableModel dfm = new DefaultTableModel();
    public static double obtenerTotalVenta(JTable jt)
    {
        double sumatotal = 0;
            for(int i=0; i<jt.getRowCount(); i++){
                sumatotal += (double)dfm.getValueAt(i,3);
            }
        return sumatotal;
    } 
    
    public static double obtenerIgv(double precio, double igv) {
        return precio * igv;
    }
    
    public static double obtenerTotalIgv(double importe, double igv) {
        return importe - igv;
    }

    public static void actualizarCampos(JTable jt, JTextField txtnroproductos, JTextField txtotalventa) 
    {
        DefaultTableModel modelo = (DefaultTableModel) jt.getModel();
        int nroProductos = modelo.getRowCount();
        double totalVenta = 0.0;
        for (int i = 0; i < nroProductos; i++) {
            double precioConDescuento = Double.parseDouble(modelo.getValueAt(i, 4).toString());
            totalVenta += precioConDescuento;
        }
        txtnroproductos.setText(String.valueOf(nroProductos));
        txtotalventa.setText(String.format(Locale.US, "%.2f", totalVenta));
    }
    
    public static void limpiarCampos(JTextField [] contenidoText, JComboBox[] contenidoCombo, JTable[] contenidoTable, JCheckBox[] contenidoCheck, JSpinner contenidoSpinner)
    {
    for (int i = 0; i < contenidoText.length; i++) {
        contenidoText[i].setText("0.00");
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
