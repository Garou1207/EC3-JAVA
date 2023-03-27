
package PKCLASES;

import PKINTERFACES.IEjercicio03;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Ejercicio03Calculos implements IEjercicio03 {
    
    DefaultListModel dlm = new DefaultListModel();

    @Override
    public void ValidarSoloLetras(JTextField txtN) {
        txtN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tecla=(int)e.getKeyChar();
                if(tecla>=65 && tecla<=90 || tecla>=97 && tecla<=122 ||
                         tecla==32 || tecla==8 || tecla==10){
                    if(tecla==10){ //Tecla enter
                        AgregarNom(txtN.getText());
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
        txtH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tecla = (int)e.getKeyChar();
                    if (tecla == 10) {
                        AgregarNum(Integer.parseInt(txtH.getText()));
                        txtH.setText(""); txtH.requestFocus();
                    } else 
                    e.consume();
            }
        });
    }

    @Override
    public void AgregarNum(int numero) {
        if (dlm.contains(numero)) {
                JOptionPane.showMessageDialog(null, "El numero ingresado ya existe");
        } else {
                dlm.addElement(numero);
        }
        
    }

    @Override
    public void AgregarNom(String nombre) {
        if(nombre.length()!=0){ //si la variable recibe un nombre
           //si el nombre ya existe dentro de la lista modelo
           if(dlm.contains(nombre.toUpperCase())){
               JOptionPane.showMessageDialog(null,"El nombre ya existe");
           }
           else{
               dlm.addElement(nombre.toUpperCase());
           }
       }
        
    }
    
}