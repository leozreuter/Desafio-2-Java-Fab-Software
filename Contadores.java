package com.mycompany.desafio2;

/**
 *
 * @author Leonardo Reuter
 */
public class Contadores {
    private int contadorDiscpEAD;
    private int contadorDiscpPresencial;

    public Contadores() {
        this.contadorDiscpEAD = 0;
        this.contadorDiscpPresencial = 0;
    }

    public Contadores(int contadorDiscpEAD, int contadorDiscpPresencial) {
        this.contadorDiscpEAD = contadorDiscpEAD;
        this.contadorDiscpPresencial = contadorDiscpPresencial;
    }

    public int getContadorDiscpEAD() {
        return contadorDiscpEAD;
    }

    public void setContadorDiscpEAD(int contadorDiscpEAD) {
        this.contadorDiscpEAD = contadorDiscpEAD;
    }

    public int getContadorDiscpPresencial() {
        return contadorDiscpPresencial;
    }

    public void setContadorDiscpPresencial(int contadorDiscpPresencial) {
        this.contadorDiscpPresencial = contadorDiscpPresencial;
    }
}
