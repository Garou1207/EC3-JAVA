package PKINTERFACES;

import java.awt.Container;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public interface IEjercicio03 {
    
    void ValidarLetras(JTextField txtN);
    void ValidarNumeros(JTextField txtH);
    void ValidarAnios(JTextField txtA);
    void MostrarIMG(JLabel img);
    void BHHilanderia(JRadioButton hil, JTextField txt);
    void BHTintoleria(JRadioButton tin, JTextField txt);
    void PagoTotal();
    void Bonificacion(JTextField txtA);
    void Descuentos(JCheckBox  afp, JCheckBox  fyT);
    void PagoNeto();
    void Nuevo(Container c, ButtonGroup bg, JCheckBox a, JCheckBox f);
}
