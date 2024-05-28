/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafio2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Leonardo Reuter
 */
public class PROFESSOR extends PESSOA {
    private String titulacao;
    private float valor_hora;
    private ArrayList <String> disciplinas = new ArrayList <> ();

    public PROFESSOR(String nome, int matricula, String endereco, String titulacao, float valor_hora) {
        this.nome = nome;
        this.matricula = matricula;
        this.endereco = endereco;
        this.titulacao = titulacao;
        this.valor_hora = valor_hora;
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


    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public float getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(float valor_hora) {
        this.valor_hora = valor_hora;
    }
    
    public String getDisciplinas() {
        String result = "";
        if (this.disciplinas.isEmpty()){
           return "Nenhuma disciplina cursada!";
        }else{
            for(String disciplina : disciplinas){           
                result = result.concat(disciplina+", ");    
            }
        return result;
        }
    }
    
    public void setDisciplinas(String disciplina) {
        Scanner sc = new Scanner (System.in);
        sc.nextLine();
        this.disciplinas.add(disciplina);       
    }

    @Override
    public String toString() {
        return this.nome+": Matricula: "+ this.matricula+"\nEndereço: "+ this.endereco + "|| Titulação:" + titulacao + ", Valor da Hora: R$" + valor_hora + "| Disciplinas : " + this.getDisciplinas();
    }
    
}
