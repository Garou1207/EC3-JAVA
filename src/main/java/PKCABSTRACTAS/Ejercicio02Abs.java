package PKCABSTRACTAS;

import javax.swing.JLabel;
import javax.swing.JTextField;

public  abstract  class Ejercicio02Abs {
    
    public abstract void AgregarN(int numero);
    public abstract void ValidarNumeros(JTextField txt);
    public abstract void SumarNumeros(JTextField num, JLabel sumar);
    public abstract void SumarPares(JTextField numero, JLabel sumarPar);
    public abstract void SumarImpares(JTextField numero, JLabel sumarImp);
    public abstract void OrdernarAscendente();
    public abstract void Limpiar(JTextField txt, JLabel sumar);
    
}
