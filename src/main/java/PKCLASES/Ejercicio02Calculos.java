package PKCLASES;

import PKINTERFACES.IEjercicio02;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JTextField;

public class Ejercicio02Calculos implements IEjercicio02 {
    
    public static ArrayList ANumeros = new ArrayList();
    
    @Override
    public void ValidarNumeros(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tecla = (int)e.getKeyChar();
                if(tecla >= 48 && tecla <= 57){
                    if (tecla == 13) {
                        
                    }
                } else {
                    e.consume();
                }
            }
        });
    }
}
