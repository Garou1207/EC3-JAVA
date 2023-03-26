package PKINTERFACES;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public interface IEjercicio01 {
    
    void AgregarMeses(JComboBox cbo);
    void Nuevo(JComboBox cbo, JSpinner jsp1, JSpinner jsp2, JLabel lbl);
    void DiaYMes(JSpinner jspDia, JSpinner jspanio);
    void CalculoYMensaje(JLabel lbl, JComboBox cbo);
}
