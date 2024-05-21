package com.mycompany.desafio2;

/**
 *
 * @author Leonardo Reuter
 */

public class DISCIPLINA_PRESENCIAL extends DISCIPLINA {
    private int numero_aulas;
    private TURNO turno;
    private DIA_SEMANA dia_semana;
    
    
    public DISCIPLINA_PRESENCIAL (int codigo, String nome, String ementa, int numero_vagas, int numero_aulas, TURNO turno, DIA_SEMANA dia_semana)   {
        this.codigo = codigo;
        this.nome = nome;
        this.ementa = ementa;
        this.numero_vagas = numero_vagas;
        this.numero_aulas = numero_aulas;
        this.turno = turno;
        this.dia_semana = dia_semana;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEmenta() {
        return ementa;
    }

    @Override
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    @Override
    public int getNumero_vagas() {
        return numero_vagas;
    }

    @Override
    public void setNumero_vagas(int numero_vagas) {
        this.numero_vagas = numero_vagas;
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

    public DIA_SEMANA getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(DIA_SEMANA dia_semana) {
        this.dia_semana = dia_semana;
    }
    
    @Override
    public String toString() {
        return numero_vagas + codigo + " - " + nome + "\nTurno: "+turno+" || Dia da semana: "+dia_semana+"\n" + ementa + "\nNúmero de vagas: "+ numero_vagas +" || n Número de vagas: "+ numero_vagas;
    
    }
    
}
