/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_danielalvarado;

import java.util.ArrayList;

/**
 *
 * @author dalva
 */
public class Empleado extends Persona{
    
    private ArrayList<Carro> carrosLavar = new ArrayList();

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public ArrayList<Carro> getCarrosLavar() {
        return carrosLavar;
    }

    public void setCarrosLavar(ArrayList<Carro> carrosLavar) {
        this.carrosLavar = carrosLavar;
    }

    @Override
    public String toString() {
        return "Empleado: "+super.toString();
    }
    
    
}
