
package PKCLASES;

import PKINTERFACES.IEjercicio03;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;


public class Ejercicio03Calculos implements IEjercicio03 {

    @Override
    public void ValidarSoloLetras(JTextField txtN) {
        txtN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tecla=(int)e.getKeyChar();
                if(tecla>=65 && tecla<=90 || tecla>=97 && tecla<=122 ||
                         tecla==32 || tecla==8 || tecla==10){
                    if(tecla==10){ //Tecla enter
                        txtN.setText(""); txtN.requestFocus();
                    }
                }else{
                    e.consume();// no permitir el ingreso de teclas
                }
            }            
        });
    }

    @Override
    public void ValidarSoloNumeros(JTextField txtH) {
        
    }
    
}
