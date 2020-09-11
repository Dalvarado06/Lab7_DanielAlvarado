/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_danielalvarado;

import javax.swing.JProgressBar;
import javax.swing.JTable;

public class HiloTabla1 extends Thread{
    
    private JTable tabla1;
    private JProgressBar barra1;
    private Carro car;
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
    
    @Override
    public void run(){
        while(true){
            
            while(lavar){
                double size= 0;
                switch(car.getSize()){
                    case "Peque":
                        size = 1.5;
                        break;
                        
                    case "Mediano":
                        size = 1.8;
                        break;
                        
                    case "Grande":
                        size = 2.2;
                        break;
                }
                
                
                barra1.setValue((int)(size * car.getNivelSuciedad()));
                
                
                
                
                
            }
            
        }
    }
    
    
    
}
