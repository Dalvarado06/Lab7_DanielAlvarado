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
import java.io.Serializable;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class GuardarClientes implements Serializable{
    
    private JList listaClientes;
    private File archivo;

    public GuardarClientes() {
    }

    public GuardarClientes(JList listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
    
    public JList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(JList listaClientes) {
        this.listaClientes = listaClientes;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void escribirClientes() throws IOException{
        FileOutputStream fo = null;
        ObjectOutputStream op = null;
        
        try {
            DefaultListModel modelo = (DefaultListModel) listaClientes.getModel();
            archivo = new File("./clientes.ink");
            fo = new FileOutputStream(archivo);
            op = new ObjectOutputStream(fo);
            
            for (int i = 0; i < modelo.getSize(); i++) {
                Cliente c = (Cliente)modelo.getElementAt(i);
                
                op.writeObject(c);
            }
            
            op.flush();
            
        } catch (Exception e) {
        }
        
        op.close();
        fo.close();
    }
    
    public JList escribirLista(){
        FileInputStream fi = null;
        ObjectInputStream ob = null;
        archivo = new File("./clientes.ink");
        
        if(archivo.exists()){
            
            try {
                DefaultListModel modelo = (DefaultListModel) listaClientes.getModel();
                fi = new FileInputStream(archivo);
                ob = new ObjectInputStream(fi);
                Cliente c;
                
                try {
                    while((c = (Cliente)ob.readObject()) != null){
                        modelo.addElement(c);
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
        
        return listaClientes;
    }
   
    
}
