package PKCLASES;

import PKINTERFACES.IEjercicio02;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ejercicio02Calculos implements IEjercicio02 {
    
    DefaultListModel dlm = new DefaultListModel();
    
    public Ejercicio02Calculos(JList jl) {
        jl.setModel(dlm);
    }
    
    @Override
    public void AgregarN(int numero) {
        if (dlm.contains(numero)) {
                JOptionPane.showMessageDialog(null, "El numero ingresado ya existe");
        } else {
                dlm.addElement(numero);
        }
    }
    
    @Override
    public void ValidarNumeros(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tecla = (int)e.getKeyChar();
                    if (tecla == 10) {
                        AgregarN(Integer.parseInt(txt.getText()));
                        txt.setText(""); txt.requestFocus();
                    }
                if(tecla >= 48 && tecla <= 57){
                } else 
                    e.consume();
            }
        });
    }

    @Override
    public void SumarNumeros(JTextField num) {
        int suma = 0;
        for (int i = 0; i < dlm.size(); i++) {
            suma += (int)dlm.get(i);
        }
        num.setText("" + suma);
    }

    @Override
    public void OrdernarAscendente() {
        int ascen = 0;  
        for (int i = 0; i < dlm.size(); i++) {
            for (int j = 1; j < dlm.size() - i; j++) {
                if (Integer.parseInt(dlm.getElementAt(j-1).toString()) > 
                        Integer.parseInt(dlm.getElementAt(j).toString())) {
                    ascen = Integer.parseInt(dlm.getElementAt(j-1).toString());
                    dlm.set(j-1, dlm.getElementAt(j));
                    dlm.set(j, ascen);
                }
            }
        }
    }
}
