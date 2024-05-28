package com.mycompany.desafio2;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Leonardo Reuter
 */
public class ESTUDANTE extends PESSOA {
    private int ano_ingresso;
    private String curso;
    private ArrayList <String> disciplinas_cursadas = new ArrayList <> ();

    public ESTUDANTE(String nome, int matricula, String endereco, String curso, int ano_ingresso){
        this.nome = nome;
        this.ano_ingresso = ano_ingresso;
        this.curso = curso;
        this.matricula = matricula;
        this.endereco = endereco;
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
    
    public int getAno_ingresso() {
        return ano_ingresso;
    }

    public void setAno_ingresso(int ano_ingresso) {
        this.ano_ingresso = ano_ingresso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDisciplinas_cursadas() {
        String result = "";
        if (this.disciplinas_cursadas.isEmpty()){
           return "Nenhuma disciplina cursada!";
        }else{
            for(String disciplina : disciplinas_cursadas){           
                result = result.concat(disciplina+", ");    
            }
        return result;
        }
    }
    
    public void setDisciplinas_cursadas(String disciplina) {
        Scanner sc = new Scanner (System.in);
        sc.nextLine();
        this.disciplinas_cursadas.add(disciplina);       
    }
    
    @Override
    public String toString() {
        return this.nome+": Matricula:"+ this.matricula+" | Endereço: "+ this.endereco + " | Ano Ingresso:" + this.ano_ingresso + "\n| Curso: " + this.curso + " | Disciplinas cursadas: " + this.getDisciplinas_cursadas();
    }
    
}

