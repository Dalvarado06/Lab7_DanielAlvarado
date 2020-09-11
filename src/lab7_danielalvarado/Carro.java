/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_danielalvarado;

public class Carro {
    
    private String numPlaca;
    private String size;
    private int numPuertas;
    private int nivelSuciedad;

    public Carro() {
    }

    public Carro(String numPlaca, String size, int numPuertas, int nivelSuciedad) {
        this.numPlaca = numPlaca;
        this.size = size;
        this.numPuertas = numPuertas;
        this.nivelSuciedad = nivelSuciedad;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public int getNivelSuciedad() {
        return nivelSuciedad;
    }

    public void setNivelSuciedad(int nivelSuciedad) {
        this.nivelSuciedad = nivelSuciedad;
    }

    @Override
    public String toString() {
        return "Carro: " + "numPlaca=" + numPlaca + ", size=" + size + ", numPuertas=" + numPuertas + ", nivelSuciedad=" + nivelSuciedad + '}';
    }
    
    
}
