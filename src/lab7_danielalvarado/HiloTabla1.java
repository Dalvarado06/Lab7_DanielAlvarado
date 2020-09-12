/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_danielalvarado;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HiloTabla1 extends Thread {

    private JTable tabla1;
    private JProgressBar barra1;
    private Carro car;
    private Empleado e;
    private boolean lavar;

    public HiloTabla1(JTable tabla1, JProgressBar barra1) {
        this.tabla1 = tabla1;
        this.barra1 = barra1;
    }

    
    
    public Carro getCar() {
        return car;
    }

    public void setCar(Carro car) {
        this.car = car;
    }

    public boolean isLavar() {
        return lavar;
    }

    public void setLavar(boolean lavar) {
        this.lavar = lavar;
    }

    public Empleado getE() {
        return e;
    }

    public void setE(Empleado e) {
        this.e = e;
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
                    barra1.setMaximum((int) (t * c.getNivelSuciedad()));

                    while (barra1.getValue() < barra1.getMaximum()) {
                        barra1.setValue(barra1.getValue() + 1);
                    }

                    DefaultTableModel modelo = (DefaultTableModel) tabla1.getModel();

                    Object newRow[] = {
                        c.getNumPlaca(),
                        c.getSize(),
                        c.getNivelSuciedad(),
                        tiempo
                    };

                    modelo.addRow(newRow);

                    tabla1.setModel(modelo);
                    
                    e.getCarrosLavar().remove(c);
                    barra1.setValue(0);
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
