package PKCABSTRACTAS;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public abstract class Ejercicio01Abs {
    
    public abstract void AgregarMeses(JComboBox cbo);
    public abstract void Nuevo(JComboBox cbo, JSpinner jsp1, JSpinner jsp2, JLabel lbl);
    public abstract void DiaYMes(JSpinner jspDia, JSpinner jspanio);
    public abstract void CalculoYMensaje(JLabel lbl, JComboBox cbo);
    
}
