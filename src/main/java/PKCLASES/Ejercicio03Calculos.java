package PKCLASES;

import PKINTERFACES.IEjercicio03;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ejercicio03Calculos implements IEjercicio03 {
    
    private int hTrabajadas;
    private double bHora;
    private double pTotal;
    
    public int gethTrabajadas() {
        return hTrabajadas;
    }
    public void sethTrabajadas(int hTrabajadas) {
        this.hTrabajadas = hTrabajadas;
    }
    public double getbHora() {
        return bHora;
    }
    public double getpTotal() {
        return pTotal;
    }
    
    @Override
    public void ValidarLetras(JTextField txtN) {
        txtN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tecla=(int)e.getKeyChar();
                if(tecla>=65 && tecla<=90 || tecla>=97 && tecla<=122 ||
                         tecla==32 || tecla==8 || tecla==10){
                }else{
                    e.consume();
                }
            }            
        });
    }

    @Override
    public void ValidarNumeros(JTextField txtH) {
        txtH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tecla=(int)e.getKeyChar();
                if(tecla >= 48 && tecla <= 57){
                } else {
                    e.consume();
                }
            }
        });
    }

    @Override
    public void MostrarIMG(JLabel img) {
        ImageIcon icono = new ImageIcon("src/main/java/PKIMAGENES" + "/Textileria" + ".jpg");
        Icon icon = new ImageIcon(icono.getImage().getScaledInstance(
                  img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT));
        img.setIcon(icon);
    }
        
    @Override
    public void BHHilanderia(JRadioButton hil, JTextField txt) {
        hil.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hil.isSelected()) {
                    bHora = 20;
                    txt.setText("" + bHora);
                } 
            }
        });
    }
    
    @Override
    public void BHTintoleria(JRadioButton tin, JTextField txt) {
        tin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tin.isSelected()) {
                    bHora = 22;
                    txt.setText("" + bHora);
                }
            }
        });
    }
  
    @Override
    public void PagoTotal() {
        pTotal = hTrabajadas * bHora;
    }

    @Override
    public void ValidarAnios(JTextField txtA) {
        txtA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tecla = (int)e.getKeyChar();
                if(tecla >= 48 && tecla <= 57 && txtA.getText().length() < 4){
                } else {
                    e.consume();
                }
            }
        });
    }
}
