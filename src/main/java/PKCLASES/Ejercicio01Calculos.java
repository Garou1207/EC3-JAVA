package PKCLASES;

import PKINTERFACES.IEjercicio01;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Ejercicio01Calculos implements IEjercicio01{
    
    
    private int anio;
    private int dia;
    
        public int getAnio() {
        return anio;
    }
    public void setAnio(int Anio) {
        this.anio = Anio;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int Dia) {
        this.dia = Dia;
    }
    
    @Override
    public void AgregarMeses(JComboBox cbo) {
        cbo.removeAllItems();
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
    public void Nuevo(JComboBox cbo, JSpinner jsp1, JSpinner jsp2, JLabel lbl) {
        cbo.setSelectedIndex(0);
        jsp1.setValue(1);
        jsp2.setValue(1970);
        lbl.setText("-");
    }
    @Override
    public void DiaYMes(JSpinner jspDia, JSpinner jspanio) {
        SpinnerNumberModel spdia = new SpinnerNumberModel(1, 1, 31, 1);
        jspDia.setModel(spdia);
        SpinnerNumberModel spanio = new SpinnerNumberModel(1970, 1970, 2010, 1);
        jspanio.setModel(spanio);
    }    

    @Override
    public void CalculoYMensaje(JLabel lbl, JComboBox cbo) {
        // Calculos
        int anios = LocalDate.now().getYear();
        anio = anios - getAnio();
        int dias = getDia();
        String signoZ = "";
        if (cbo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debes de seleccionar un mes");
        } else {
            if ((dias >= 21 && cbo.getSelectedIndex() == 4) || (dias <= 19 && cbo.getSelectedIndex() == 5)) {
                signoZ = "Aries";
            }
            lbl.setText("Usted tiene " + anio + " años de edad y su signo es " + signoZ);
        }
    }
}
