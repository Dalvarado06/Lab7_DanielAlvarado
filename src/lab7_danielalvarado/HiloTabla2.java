/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_danielalvarado;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dalva
 */
public class HiloTabla2 extends Thread{

    private JTable tabla2;
    private JProgressBar barra2;
    private Carro car;
    private Empleado e;
    private boolean lavar;

    public HiloTabla2(JTable tabla2, JProgressBar barra2) {
        this.tabla2 = tabla2;
        this.barra2 = barra2;
    }

    public Empleado getE() {
        return e;
    }

    public void setE(Empleado e) {
        this.e = e;
    }

    public boolean isLavar() {
        return lavar;
    }

    public void setLavar(boolean lavar) {
        this.lavar = lavar;
    }

    @Override
    public void run() {
        while (true) {

            while (lavar) {

                for (int i = 0; i < e.getCarrosLavar().size(); i++) {
                    Carro c = e.getCarrosLavar().get(i);

                    double t = 0;

                    switch (c.getSize()) {
                        case "Peque":
                            t = 1.5;
                            break;

                        case "Mediano":
                            t = 1.8;
                            break;

                        case "Grande":
                            t = 2.2;
                            break;
                    }

                    double tiempo = t * c.getNivelSuciedad();
                    barra2.setMaximum((int) (t * c.getNivelSuciedad()));

                    while (barra2.getValue() < barra2.getMaximum()) {
                        barra2.setValue(barra2.getValue() + 1);
                    }

                    DefaultTableModel modelo = (DefaultTableModel) tabla2.getModel();

                    Object newRow[] = {
                        c.getNumPlaca(),
                        c.getSize(),
                        c.getNivelSuciedad(),
                        tiempo
                    };

                    modelo.addRow(newRow);

                    tabla2.setModel(modelo);
                    
                    e.getCarrosLavar().remove(c);
                }

                lavar = false;

            }

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }

    }
}
