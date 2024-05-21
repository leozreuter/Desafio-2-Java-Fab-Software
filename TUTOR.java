/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafio2;

/**
 *
 * @author Leonardo Reuter
 */
public class TUTOR extends PESSOA {
    private float salario_mensal;
    private String area_formacao;

    public TUTOR(String nome, int matricula, String endereco, float salario_mensal, String area_formacao) {
        this.nome = nome;
        this.matricula = matricula;
        this.endereco = endereco;
        this.salario_mensal = salario_mensal;
        this.area_formacao = area_formacao;
    }

    @Override
    public int getMatricula() {
        return matricula;
    }

    @Override
    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public float getSalario_mensal() {
        return salario_mensal;
    }

    public void setSalario_mensal(float salario_mensal) {
        this.salario_mensal = salario_mensal;
    }

    public String getArea_formacao() {
        return area_formacao;
    }

    public void setArea_formacao(String area_formacao) {
        this.area_formacao = area_formacao;
    }

    @Override
    public String toString() {
        return this.nome+": Matricula:"+ this.matricula+", Endereço: "+ this.endereco + ", Area de formaçãoo:" + area_formacao + ", Salario Mensal: R$" + salario_mensal;
    }
    
    
}
