package PKCLASES;

import PKINTERFACES.IEjercicio03;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ejercicio03Calculos implements IEjercicio03 {
    
    private int hTrabajadas;
    private double bHora;
    private double pTotal;
    private double boni;
    private double AFP;
    private double faytar;
    private double pagoNeto;
    
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
    public double getBoni() {
        return boni;
    }
    public void setBoni(double boni) {
        this.boni = boni;
    }
        public double getAFP() {
        return AFP;
    }
    public double getFaytar() {
        return faytar;
    }
    public double getPagoNeto() {
        return pagoNeto;
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
    public void ValidarAnios(JTextField txtA) {
        txtA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tecla = (int)e.getKeyChar();
                if(tecla >= 47 && tecla <= 57 && txtA.getText().length() < 10){
                } else {
                    e.consume();
                }
            }
        });
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();
        String fechaActualTexto = fechaActual.format(dateFormat);
        txtA.setText(fechaActualTexto);
    }
    
    @Override
    public void PagoTotal() {
        pTotal = hTrabajadas * bHora;
    }

    @Override
    public void Bonificacion(JTextField txtA) {
        boni = 0;
        String fechaIngresadaTexto = txtA.getText();
        int anioIngresado = Integer.parseInt(fechaIngresadaTexto.substring(6));
        LocalDate fechaActual = LocalDate.now();
        int anioActual = fechaActual.getYear();
        int anio = anioActual - anioIngresado;
        if (anio > 5) {
            boni = pTotal * 0.05;
        } 
    }

    @Override
    public void Descuentos(JCheckBox  afp, JCheckBox  fyT) {
         AFP = 0;
         faytar = 0;
        if (afp.isSelected()) 
            AFP = pTotal * 0.11;
        if (fyT.isSelected()) 
            faytar = pTotal * 0.16;
    }

    @Override
    public void PagoNeto() {
        pagoNeto = pTotal + boni - (AFP + faytar);
    }
}
