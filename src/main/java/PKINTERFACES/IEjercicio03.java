package PKINTERFACES;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public interface IEjercicio03 {
    
    void ValidarLetras(JTextField txtN);
    void ValidarNumeros(JTextField txtH);
    void MostrarIMG(JLabel img);
    void BHHilanderia(JRadioButton hil, JTextField txt);
    void BHTintoleria(JRadioButton tin, JTextField txt);
    //void BasicoHora(JRadioButton hil, JRadioButton tin, JTextField txt);
    void PagoTotal();
}
