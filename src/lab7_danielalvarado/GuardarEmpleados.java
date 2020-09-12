/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_danielalvarado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

public class GuardarEmpleados {
    
    private JComboBox cb_Empleados;
    private File archivo;

    public GuardarEmpleados(JComboBox cb_Empleados) {
        this.cb_Empleados = cb_Empleados;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void escribirEmpleados() throws IOException{
        FileOutputStream fo = null;
        ObjectOutputStream op = null;
        
        try {
            DefaultComboBoxModel modelo = (DefaultComboBoxModel)cb_Empleados.getModel();
            archivo = new File("./empleados.ink");
            fo = new FileOutputStream(archivo);
            op = new ObjectOutputStream(fo);
            
            for (int i = 0; i < modelo.getSize(); i++) {
                Empleado e = (Empleado)modelo.getElementAt(i);
                
                op.writeObject(e);
            }
            
            op.flush();
            
        } catch (Exception e) {
        }
        
        op.close();
        fo.close();
    }
    
    public void escribirLista(){
        FileInputStream fi = null;
        ObjectInputStream ob = null;
        archivo = new File("./empleados.ink");
        
        if(archivo.exists()){
            
            try {
                DefaultComboBoxModel modelo = (DefaultComboBoxModel) cb_Empleados.getModel();
                fi = new FileInputStream(archivo);
                ob = new ObjectInputStream(fi);
                Empleado em;
                
                try {
                    while((em = (Empleado)ob.readObject()) != null){
                        modelo.addElement(em);
                    }
                    
                } catch (Exception e) {
                }
                
               
                
            } catch (Exception e) {
            }
            
            
            try {
                ob.close();
                fi.close();
            } catch (Exception e) {
            }
            
        }
        
        
    }
   
    
}
