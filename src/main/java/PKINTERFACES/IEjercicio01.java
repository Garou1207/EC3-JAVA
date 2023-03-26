package PKINTERFACES;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

public interface IEjercicio01 {
    
    public void AgregarMeses(JComboBox cbo);
    public void Nuevo(JComboBox cbo, JSpinner jsp1, JSpinner jsp2);
    public void DiasDeMes(JSpinner jsp);
    public void RangoDeAnio(JSpinner jsp);
}
