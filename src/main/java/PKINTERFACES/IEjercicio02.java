package PKINTERFACES;

import javax.swing.JLabel;
import javax.swing.JTextField;

public interface IEjercicio02 {
    
    void AgregarN(int numero);
    void ValidarNumeros(JTextField txt);
    void SumarNumeros(JTextField num, JLabel sumar);
    void SumarPares(JTextField numero, JLabel sumarPar);
    void SumarImpares(JTextField numero, JLabel sumarImp);
    void OrdernarAscendente();
    void Limpiar(JTextField txt, JLabel sumar);
}
