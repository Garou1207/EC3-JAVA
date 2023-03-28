package PKINTERFACES;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface IEjercicio04 {
    
    void actualizarFechaHora(JLabel lblReloj, JLabel lblFecha) ;
    void agregarEmpleados(JComboBox cboEmpleados);
    void agregarClientes(JComboBox cboClientes);
    void agregarArticulos(JComboBox cboarticulos);
    void mostrarImagen(String nombre, JLabel jfoto);
    double obtenerPrecio(int indice);
    double obtenerDescuento(double precio, int descuento, int cantidad);
    double obtenerTotal(double precio, int descuento, int cantidad);
    double obtenerTotalVenta(JTable jt);
    double obtenerIgv(double precio, double igv);
    double obtenerTotalIgv(double importe, double igv);
    void actualizarCampos(JTable jt, JTextField txtnroproductos, JTextField txtotalventa);
    void limpiarCampos(JTextField [] contenidoText, JComboBox[] contenidoCombo, JTable[] 
            contenidoTable, JCheckBox[] contenidoCheck, JSpinner contenidoSpinner);
}
