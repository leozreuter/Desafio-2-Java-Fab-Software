/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafio2;

/**
 *
 * @author Leonardo Reuter
 */
public class DISCIPLINA_EAD extends DISCIPLINA {
    private int numero_unidades;
    
    public DISCIPLINA_EAD (int codigo, String nome, String ementa, int numero_vagas, int numero_unidades) {
        this.codigo = codigo;
        this.nome = nome;
        this.ementa = ementa;
        this.numero_vagas = numero_vagas;
        this.numero_unidades = numero_unidades;
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
        
    public int getNumero_unidades() {
        return numero_unidades;
    }

    public void setNumero_unidades(int numero_unidades) {
        this.numero_unidades = numero_unidades;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome + "\n" + ementa + "\nNúmero de vagas: "+ numero_vagas +" || Número de unidades: "+numero_unidades;
    }
    
    
}
