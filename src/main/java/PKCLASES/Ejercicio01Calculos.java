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
        int meses = cbo.getSelectedIndex();
        String signoZ = "";
        if (cbo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debes de seleccionar un mes");
        } else {
            if ((dias >= 21 && meses == 3) || (dias <= 19 && meses == 4)) signoZ = "Aries";
            if ((dias >= 20 && meses == 4) || (dias <= 20 && meses == 5)) signoZ = "Tauro";
            if ((dias >= 21 && meses == 5) || (dias <= 20 && meses == 6)) signoZ = "Géminis";
            if ((dias >= 21 && meses == 6) || (dias <= 22 && meses == 7)) signoZ = "Cáncer";
            if ((dias >= 23 && meses == 7) || (dias <= 22 && meses == 8)) signoZ = "Leo";
            if ((dias >= 23 && meses == 3) || (dias <= 22 && meses == 9)) signoZ = "Virgo";
            if ((dias >= 23 && meses == 9) || (dias <= 22 && meses == 10)) signoZ = "Libra";
            if ((dias >= 23 && meses == 10) || (dias <= 21 && meses == 11)) signoZ = "Escorpio";
            if ((dias >= 22 && meses == 11) || (dias <= 21 && meses == 12)) signoZ = "Sagitario";
            if ((dias >= 22 && meses == 12) || (dias <= 19 && meses == 1)) signoZ = "Capricornio";
            if ((dias >= 20 && meses == 1) || (dias <= 18 && meses == 2)) signoZ = "Acuario";
            if ((dias >= 19 && meses == 2) || (dias <= 20 && meses == 3)) signoZ = "Piscis";
            
            lbl.setText("Usted tiene " + anio + " años de edad y su signo es " + signoZ + ".");
        }
    }
}
