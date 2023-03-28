package PKCLASES;

import PKINTERFACES.IEjercicio04Datos;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ejercicio04Tabla implements IEjercicio04Datos{
    
    DefaultTableModel dfm = new DefaultTableModel();
    
    public void agregarColumnas(JTable jt)
    {
        jt.setModel(dfm);
        dfm.setColumnCount(0);
        dfm.addColumn("Producto");
        dfm.addColumn("Precio");
        dfm.addColumn("Cantidad");
        dfm.addColumn("Descuento");
        dfm.addColumn("Total");
        
        jt.getColumnModel().getColumn(0).setPreferredWidth(180);
        jt.getColumnModel().getColumn(1).setPreferredWidth(80);
        jt.getColumnModel().getColumn(2).setPreferredWidth(80);
        jt.getColumnModel().getColumn(3).setPreferredWidth(80);
        jt.getColumnModel().getColumn(4).setPreferredWidth(80);
        
    }
    
    public void agregarArticulosTabla(JTable jt, JComboBox cboarticulos, double precio, int cantidad, double descuento, double total)
    {
        for (int i = 0; i < jt.getRowCount(); i++){
            if(dfm.getValueAt(i,0).equals(cboarticulos.getSelectedItem())){
            JOptionPane.showMessageDialog(null,"El Producto ya existe");
            return;
            }
        }
        
        dfm.addRow(new Object[]{cboarticulos.getSelectedItem(), precio, cantidad, descuento, total});  
    }
    
    public  void quitarArticulosTabla(JTable jt) 
    {
    DefaultTableModel modelo = (DefaultTableModel) jt.getModel();
    int filaSeleccionada = jt.getSelectedRow();
    if (filaSeleccionada != -1) {
        modelo.removeRow(filaSeleccionada);
        }
    }
    
    public  void cancelarArticulosTabla(JTable jt)
    {
        DefaultTableModel modelo = (DefaultTableModel) jt.getModel();
        modelo.setRowCount(0);
    }
  
}
