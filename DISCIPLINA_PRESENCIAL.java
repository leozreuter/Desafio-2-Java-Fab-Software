package com.mycompany.desafio2;

/**
 *
 * @author Leonardo Reuter
 */

public class DISCIPLINA_PRESENCIAL extends DISCIPLINA {
    private int numero_aulas;
    private TURNO turno;
    
    public DISCIPLINA_PRESENCIAL (int codigo, String nome, String ementa, int numero_vagas, int numero_aulas, TURNO turno)   {
        this.codigo = codigo;
        this.nome = nome;
        this.ementa = ementa;
        this.numero_vagas = numero_vagas;
        this.numero_aulas = numero_aulas;
        this.turno = turno;
    }

    public int getNumero_aulas() {
        return numero_aulas;
    }

    public void setNumero_aulas(int numero_aulas) {
        this.numero_aulas = numero_aulas;
    }

    public TURNO getTurno() {
        return turno;
    }

    public void setTurno(TURNO turno) {
        this.turno = turno;
    }
    
    @Override
    public String toString() {
        return numero_vagas + codigo + " - " + nome + "\nTurno: "+turno+"\n" + ementa + "\nNúmero de vagas: "+ numero_vagas +" || n Número de vagas: "+ numero_vagas;
    
    }
    
}
