package PKINTERFACES;

import javax.swing.JComboBox;
import javax.swing.JTable;

public interface IEjercicio04Datos {
    
    void AgregarColumnas(JTable jt);
    void AgregarArticulosTabla(JTable jt, JComboBox cboarticulos, double precio, int cantidad, double descuento, double total);
    void QuitarArticulosTabla(JTable jt);
    void CancelarArticulosTabla(JTable jt);
}
