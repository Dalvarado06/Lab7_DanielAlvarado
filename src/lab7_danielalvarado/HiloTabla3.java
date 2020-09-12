/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_danielalvarado;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HiloTabla3 extends Thread{
    
    private JTable tabla3;
    private JProgressBar barra3;
    private Carro car;
    private Empleado e;
    private boolean lavar;

    public HiloTabla3(JTable tabla3, JProgressBar barra3) {
        this.tabla3 = tabla3;
        this.barra3 = barra3;
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
                    barra3.setMaximum((int) (t * c.getNivelSuciedad()));

                    while (barra3.getValue() < barra3.getMaximum()) {
                        barra3.setValue(barra3.getValue() + 1);
                    }

                    DefaultTableModel modelo = (DefaultTableModel) tabla3.getModel();

                    Object newRow[] = {
                        c.getNumPlaca(),
                        c.getSize(),
                        c.getNivelSuciedad(),
                        tiempo
                    };

                    modelo.addRow(newRow);

                    tabla3.setModel(modelo);
                    
                    e.getCarrosLavar().remove(c);
                    
                    barra3.setValue(0);
                }

                lavar = false;

            }

            try {
                Thread.sleep(7500);
            } catch (Exception e) {
            }
        }

    }
}
