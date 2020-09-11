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
public class Cliente extends Persona{
    
    private ArrayList<Carro> carrosPropios = new ArrayList();

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public ArrayList<Carro> getCarrosPropios() {
        return carrosPropios;
    }

    public void setCarrosPropios(ArrayList<Carro> carrosPropios) {
        this.carrosPropios = carrosPropios;
    }

    @Override
    public String toString() {
        return "Cliente: "+super.toString();
    }
   
    
    
    
    
    
}
