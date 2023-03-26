package PKCLASES;

import PKINTERFACES.IEjercicio01;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Ejercicio01Calculos implements IEjercicio01{
    
    @Override
    public void AgregarMeses(JComboBox cbo) {
        cbo.removeAll();
        cbo.addItem("Selecciona mes");
        cbo.addItem("Enero");
        cbo.addItem("Febrero");
        cbo.addItem("Marzo");
        cbo.addItem("Abril");
        cbo.addItem("Mayo");
        cbo.addItem("Junio");
        cbo.addItem("Julio");
        cbo.addItem("Agosto");
        cbo.addItem("Septiembre");
        cbo.addItem("Octubre");
        cbo.addItem("Noviembre");
        cbo.addItem("Diciembre");
        
    }

    @Override
    public void Nuevo(JComboBox cbo, JSpinner jsp1, JSpinner jsp2) {
        cbo.setSelectedIndex(0);
        jsp1.setValue(1);
        jsp2.setValue(1970);
    }

    @Override
    public void DiasDeMes(JSpinner jsp) {
        SpinnerNumberModel spnumero = new SpinnerNumberModel(1, 1, 31, 1);
        jsp.setModel(spnumero);
    }    

    @Override
    public void RangoDeAnio(JSpinner jsp) {
        SpinnerNumberModel spnumero = new SpinnerNumberModel(1970, 1970, 2010, 1);
        jsp.setModel(spnumero);
    }
}
