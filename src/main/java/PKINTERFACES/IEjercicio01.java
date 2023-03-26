package PKINTERFACES;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public interface IEjercicio01 {
    
    public void AgregarMeses(JComboBox cbo);
    public void Nuevo(JComboBox cbo, JSpinner jsp1, JSpinner jsp2, JLabel lbl);
    public void DiaYMes(JSpinner jspDia, JSpinner jspanio);
    public void CalculoYMensaje(JLabel lbl, JComboBox cbo);
}
