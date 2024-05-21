package com.mycompany.desafio2;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Leonardo Reuter
 */
public class DESAFIO2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String usuario = System.getProperty("user.name");
        ArrayList <ESTUDANTE> Estudantes = new ArrayList <>();
        ArrayList <PROFESSOR> Professores = new ArrayList <>();
        ArrayList <TUTOR> Tutores = new ArrayList <>();
        int max = 15;
        DISCIPLINA_EAD DiscEAD [] = new DISCIPLINA_EAD[max];
        DISCIPLINA_PRESENCIAL DiscPresencial [] = new DISCIPLINA_PRESENCIAL[max];
        int escolha;
        
        
        System.out.println("        |Bem vindo "+usuario+"!|");
        do{
            try{
                limparConsole();
                exibirMenu();
                escolha = sc.nextInt();
                
                switch (escolha){
                    
                    //MANUTENÇAO DE PESSOAS
                    case 1 -> {
                        int escolhaMenu;
                        limparConsole();
                        do{
                            System.out.print("Você deseja ADICIONAR ou EDITAR alguma pessoa?\nDigite:\n1 - ADICIONAR\n2 - EDITAR\n3 - Voltar ao menu\n--->");
                            escolhaMenu = sc.nextInt();
                            if (escolhaMenu == 1){
                                adicionarPessoa(sc, Estudantes, Professores, Tutores, DiscEAD, DiscPresencial);
                            }else if (escolhaMenu == 2){
                                editarPessoa(sc, Estudantes, Professores, Tutores, DiscEAD, DiscPresencial);
                            }else if (escolhaMenu == 3){
                               System.out.println("Voltndo ao menu...");
                               break;
                            }else{
                                System.out.println("Você informou uma entrada não válida! Tente novamente:");
                            }
                        }while(escolhaMenu != 3);
                    }
                    
                    
                    //MANUTENÇAO DE DISCIPLINAS
                    case 2 -> {
                        int escolhaMenu;
                        limparConsole();
                        do{
                            System.out.print("Você deseja ADICIONAR ou EDITAR alguma disciplina?\nDigite:\n1 - ADICIONAR\n2 - EDITAR\n3 - Voltar ao menu\n--->");
                            escolhaMenu = sc.nextInt();
                            if (escolhaMenu == 1){
                                adicionarDisciplina(sc, Estudantes, Professores, Tutores, DiscEAD, DiscPresencial, max);
                            }else if (escolhaMenu == 2){
                                editarDisciplina(sc, Estudantes, Professores, Tutores, DiscEAD, DiscPresencial, max);
                            }else if (escolhaMenu == 3){
                               System.out.println("Voltndo ao menu...");
                               break;
                            }else{
                                System.out.println("Você informou uma entrada não válida! Tente novamente:");
                            }
                        }while(escolhaMenu != 3);
                    }
                    
                    
                    //MANUTENÇAO DE HORARIOS
                    case 3 -> {
                        
                    }
                    
                    
                    //MANUTENÇAO DE MATRICULAS
                    case 4 -> {
                        
                    }
                    
                    
                    //EXIBIR HORARIO    
                    case 5 -> {
                        
                    }
                    
                    
                    //Exibir matrícula do estudante
                    case 6 -> {
                        
                    }
                    
                    
                    //Exibir disciplinas por professor/tutor
                    case 7 -> {
                        
                    }
                    
                    
                    //SAIR
                    case 8 -> {
                        System.out.print("Obrigado, até mais!");
                    }
                    
                    default ->{
                        System.out.println("ENTRADA INVALIDA! Insira novamente");
                    }
                }
                
            }catch(InputMismatchException e) {
            System.out.println("ENTRADA INVALIDA! Insira novamente");
            sc.next();
            escolha = -1;
            }
        }while (escolha != 8);

   
    }
    
    //Geral
    public static void limparConsole(){
                try {
                    final String os = System.getProperty("os.name");
                    if (os.contains("Windows")) {
                        // Para Windows
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } else {
                        // Para outros sistemas operacionais (Linux, MacOS)
                        Runtime.getRuntime().exec("clear");
                    }
                } catch (IOException | InterruptedException e) {
                    // Tratar exceção, se necessário
                    System.out.println("Erro ao limpar o console: " + e.getMessage());
                }
    }

    public static void exibirMenu(){
        System.out.print("""
                        |----------------------------------------|
                         1. Manutenção de pessoas
                         2. Manutgenção de disciplinas
                         3. Manutenção de horário
                         4. Mantenção de matrículas
                         5. Exibir horário
                         6. Exibir matrícula do estudante
                         7. Exibir disciplinas por professor/tutor
                         8. Sair
                         
                         --->""");  
    }
    
    
    //Menu 1
    public static void adicionarPessoa(Scanner sc, ArrayList<ESTUDANTE> Estudantes, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores, DISCIPLINA_EAD[] DiscEAD, DISCIPLINA_PRESENCIAL[] DiscPresencial){
        limparConsole();
        System.out.print("""
                         Escolha a opção que desejar:
                         1. Adicionar Estudante
                         2. Adicionar Professor
                         3. Adicionar Tutor
                         4. Voltar
                         """);
        
        int escolhaMenu = sc.nextInt();
        limparConsole();
        switch(escolhaMenu){
            case 1 ->{
                System.out.println("Qual é o nome do Estudante?");
                sc.nextLine();
                String nome = sc.nextLine();
             
                System.out.println("Qual a sua matrícula?");
                int matricula = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Qual seu endereço?");
                String endereco = sc.nextLine();
                
                System.out.println("Qual é seu curso?");
                String curso = sc.nextLine();
                
                System.out.println("Qual ano ingressou?");
                int ano_ingresso = sc.nextInt();
                
                ESTUDANTE novoEstudante = new ESTUDANTE (nome,matricula,endereco,curso,ano_ingresso);
                Estudantes.add(novoEstudante);
                System.out.println("Cadastro completo!");
                System.out.println(novoEstudante);
                System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                sc.next();
                limparConsole();
            }
            case 2 ->{
                System.out.println("Qual o nome do professor?");
                sc.nextLine();
                String nome = sc.nextLine();
                
                System.out.println("Qual a sua matrícula?");
                int matricula = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Qual seu endereço?");
                String endereco = sc.nextLine();
                
                System.out.println("Qual é sua titulação?");
                String titulacao = sc.nextLine();
                
                System.out.println("Qual valor por hora?");
                float salario = sc.nextFloat();
                
                PROFESSOR novoProfessor = new PROFESSOR (nome, matricula, endereco, titulacao, salario);
                Professores.add(novoProfessor);
                System.out.println("Cadastro completo!");
                System.out.println(novoProfessor);
                System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                sc.next();
                limparConsole();
            }
            case 3 ->{
                System.out.println("Qual o nome do professor?");
                sc.nextLine();
                String nome = sc.nextLine();
                
                System.out.println("Qual a sua matrícula?");
                int matricula = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Qual seu endereço?");
                String endereco = sc.nextLine();
                
                System.out.println("Qual é sua área de formação?");
                String area_formacao = sc.nextLine();
                
                System.out.println("Qual valor por hora?");
                float salario = sc.nextFloat();
                
                TUTOR novoTutor = new TUTOR (nome, matricula, endereco, salario, area_formacao);
                Tutores.add(novoTutor);
                System.out.println("Cadastro completo!");
                System.out.println(novoTutor);
                System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
            }
            case 4 ->{
                return;
            }
        }
    }

    private static void editarPessoa(Scanner sc, ArrayList<ESTUDANTE> Estudantes, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores, DISCIPLINA_EAD[] DiscEAD, DISCIPLINA_PRESENCIAL[] DiscPresencial) {
        System.out.println("""
                           
                           Escolha a opção para editar:
                           1. Estudante
                           2. Professor
                           3. Tutor
                           4. Voltar
                           """);
        int tipoPessoa = sc.nextInt();
        switch(tipoPessoa){
            
            case 1 -> {
                limparConsole();
                System.out.println("Lista de Estudantes:");
                if (Estudantes.isEmpty()) {
                    System.out.println("Nenhum estudante encontrado.");
                    System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                    sc.next();
                    limparConsole();
                    break;
                }else{
                    for (ESTUDANTE Estudante : Estudantes) {
                        System.out.println(Estudante.getNome());
                    }}
                System.out.println("\nQual estudante você deseja editar?");
                sc.nextLine();
                String nomeEstudante =  sc.nextLine();
                for (ESTUDANTE Estudante : Estudantes)  {
                    if (Estudante.getNome().equals(nomeEstudante)) {
                       limparConsole();
                        System.out.print(Estudante+"\n\n");
                        System.out.print("""
                                         O que você quer editar?
                                         1. Nome
                                         2. Matricula
                                         3. Endereço
                                         4. Curso
                                         5. Ano de Ingresso
                                         
                                         -->""");
                        int escolhaOpc = sc.nextInt();
                        limparConsole();
                        
                        switch(escolhaOpc){
                            case 1 ->{
                                System.out.println("Digite o novo nome:");
                                sc.nextLine();
                                String novoNome = sc.nextLine();
                                Estudante.setNome(novoNome);
                                System.out.println("Estudante editado com sucesso!");}
                            case 2 ->{
                                System.out.println("Digite a nova matricula:");
                                int novaMatricula = sc.nextInt();
                                Estudante.setMatricula(novaMatricula);
                                System.out.println("Estudante editado com sucesso!");}
                            case 3 ->{
                                System.out.println("Digite o novo endereço:");
                                sc.nextLine();
                                String novoEndereço = sc.nextLine();
                                Estudante.setEndereco(novoEndereço);
                                System.out.println("Estudante editado com sucesso!");}
                            case 4 ->{
                                System.out.println("Digite o novo curso:");
                                sc.nextLine();
                                String novoCurso = sc.nextLine();
                                Estudante.setCurso(novoCurso);
                                System.out.println("Estudante editado com sucesso!");}
                            case 5 ->{
                                System.out.println("Digite o ano de ingressão:");
                                int novoAno = sc.nextInt();
                                Estudante.setAno_ingresso(novoAno);
                                System.out.println("Estudante editado com sucesso!");}    
                        }
                    }
                    else{
                        System.out.println("Estudante não encontrado!");
                    }
                System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                sc.next();
                limparConsole(); 
                }
            }
            case 2 -> {
                limparConsole();
                System.out.println("Lista de Professores:");
                if (Professores.isEmpty()) {
                    System.out.println("Nenhum professor encontrado.");
                    System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                    sc.next();
                    limparConsole();
                    break;
                }else{
                    for (PROFESSOR Professor : Professores) {
                        System.out.println(Professor.getNome());
                    }}
                System.out.println("\nQual professor você deseja editar?");
                sc.nextLine();
                String nomeProfessor = sc.nextLine();;
                for (PROFESSOR Professor : Professores) {
                    if (Professor.getNome().equals(nomeProfessor)) {
                        limparConsole();
                        System.out.print(Professor+"\n\n");
                        System.out.print("""
                                         O que você quer editar?
                                         1. Nome
                                         2. Matricula
                                         3. Endereço
                                         4. Titulação
                                         5. Valor por hora
                                         
                                         -->""");
                        int escolhaOpc = sc.nextInt();
                        limparConsole();
                        
                        switch(escolhaOpc){
                            case 1 ->{
                                System.out.println("Digite o novo nome:");
                                sc.nextLine();
                                String novoNome = sc.nextLine();
                                Professor.setNome(novoNome);
                                System.out.println("Professor editado com sucesso!");}
                            case 2 ->{
                                System.out.println("Digite a nova matricula:");
                                int novaMatricula = sc.nextInt();
                                Professor.setMatricula(novaMatricula);
                                System.out.println("Professor editado com sucesso!");}
                            case 3 ->{
                                System.out.println("Digite o novo endereço:");
                                sc.nextLine();
                                String novoEndereço = sc.nextLine();
                                Professor.setEndereco(novoEndereço);
                                System.out.println("Professor editado com sucesso!");}
                            case 4 ->{
                                System.out.println("Digite sua nova titulação?:");
                                sc.nextLine();
                                String novaTitulacao = sc.nextLine();
                                Professor.setTitulacao(novaTitulacao);
                                System.out.println("Professor editado com sucesso!");}
                            case 5 ->{
                                System.out.print("Digite o valor por hora:\nR$");
                                float novoValorHora = sc.nextFloat();
                                Professor.setValor_hora(novoValorHora);
                                System.out.println("Professor editado com sucesso!");}    
                        }
                    }
                    else{
                        System.out.println("Professor não encontrado!");
                    }
                System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                sc.next();
                limparConsole();
                }
            }
            case 3 -> {
                limparConsole();
                System.out.println("Lista de Tutores:");
                if (Tutores.isEmpty()) {
                    System.out.println("Nenhum tutor encontrado.");
                    System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                    sc.next();
                    limparConsole();
                    break;
                }else{
                    for (TUTOR Tutor : Tutores) {
                        System.out.println(Tutor.getNome());
                    }}
                System.out.println("\nQual Tutor você deseja editar?");
                sc.nextLine();
                String nomeTutor = sc.nextLine();
                for (TUTOR Tutor : Tutores) {
                    if (Tutor.getNome().equals(nomeTutor)) {
                        limparConsole();
                        System.out.print(Tutor+"\n\n");
                        System.out.print("""
                                         O que você quer editar?
                                         1. Nome
                                         2. Matricula
                                         3. Endereço
                                         4. Titulação
                                         5. Valor por hora
                                         
                                         -->""");
                        int escolhaOpc = sc.nextInt();
                        limparConsole();
                        
                        switch(escolhaOpc){
                            case 1 ->{
                                System.out.println("Digite o novo nome:");
                                sc.nextLine();
                                String novoNome = sc.nextLine();
                                Tutor.setNome(novoNome);
                                System.out.println("Tutor editado com sucesso!");}
                            case 2 ->{
                                System.out.println("Digite a nova matricula:");
                                int novaMatricula = sc.nextInt();
                                Tutor.setMatricula(novaMatricula);
                                System.out.println("Tutor editado com sucesso!");}
                            case 3 ->{
                                System.out.println("Digite o novo endereço:");
                                sc.nextLine();
                                String novoEndereço = sc.nextLine();
                                Tutor.setEndereco(novoEndereço);
                                System.out.println("Tutor editado com sucesso!");}
                            case 4 ->{
                                System.out.println("Digite sua Área de Formarção?:");
                                sc.nextLine();
                                String novaArea = sc.nextLine();
                                Tutor.setArea_formacao(novaArea);
                                System.out.println("Tutor editado com sucesso!");}
                            case 5 ->{
                                System.out.print("Digite o novo salario mensal:\nR$");
                                float novoSalario = sc.nextFloat();
                                Tutor.setSalario_mensal(novoSalario);
                                System.out.println("Tutor editado com sucesso!");}    
                        }
                    }
                    else{
                        System.out.println("Professor não encontrado!");
                    }
                System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                sc.next();
                limparConsole(); 
                }
            }
            case 4 -> {
                return;
            }
        }
    }

    
    //Menu 2
    public static void adicionarDisciplina(Scanner sc, ArrayList<ESTUDANTE> Estudantes, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores, DISCIPLINA_EAD[] DiscEAD, DISCIPLINA_PRESENCIAL[] DiscPresencial, int max){
        limparConsole();
        System.out.print("""
                         Escolha a opção que desejar:
                         1. Adicionar Disciplina EAD
                         2. Adicionar Disciplina Presencial
                         3. Voltar
                         """);
        
        int escolhaMenu = sc.nextInt();
        int contadorDiscpEAD = 0;
        int contadorDiscpPresencial = 0;
        limparConsole();
        switch(escolhaMenu){
            case 1 ->{
                if (contadorDiscpEAD == max){
                    System.out.println("Você já atingiu o número máximo de cadastro de disciplinas EAD!!\n\n");
                    System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                    sc.next();
                    limparConsole();
                    break;
                }
                System.out.println("Qual é o códgio da disciplina?");
                int codigo = sc.nextInt();
                
                System.out.println("Qual o nome do Curso?");
                sc.nextLine();
                String nome = sc.nextLine();
                
                System.out.println("Descreva a ementa:");
                String ementa = sc.nextLine();
                
                System.out.println("Qual o número de vagas?");
                int num_vagas = sc.nextInt();
                
                System.out.println("Qual o número de unidades?");
                int num_unidades = sc.nextInt();
                
                DISCIPLINA_EAD novaDiscEAD = new DISCIPLINA_EAD(codigo, nome, ementa, num_vagas, num_unidades);
                DiscEAD[contadorDiscpEAD] = novaDiscEAD;
                contadorDiscpEAD++;
                System.out.println("Cadastro completo!");
                System.out.println(novaDiscEAD);
                System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                sc.next();
                limparConsole();
            }
            
            case 2 ->{
                if (contadorDiscpPresencial == max){
                    System.out.println("Você já atingiu o número máximo de cadastro de disciplinas presenciais!!\n\n");
                    System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                    sc.next();
                    limparConsole();
                    break;
                }
                System.out.println("Qual é o códgio da disciplina?");
                int codigo = sc.nextInt();
                
                System.out.println("Qual o nome do Curso?");
                sc.nextLine();
                String nome = sc.nextLine();
                
                System.out.println("Descreva a ementa:");
                String ementa = sc.nextLine();
                
                System.out.print("Qual o turno ");               
                for (TURNO turno : TURNO.values()) {System.out.print(turno);}
                System.out.print("?");
                TURNO turno = null;
                while(true){
                    String turnon = sc.next().toUpperCase();
                    try {
                        turno = TURNO.valueOf(turnon);
                        break;
                    } catch (IllegalArgumentException e) {System.out.println("Cargo inválido! Tente novamente.");}  
                }
                System.out.println("Qual o número de vagas?");
                int num_vagas = sc.nextInt();
                
                System.out.println("Qual o número de aulas?");
                int num_aulas = sc.nextInt();

                DISCIPLINA_PRESENCIAL novaDiscPresencial = new DISCIPLINA_PRESENCIAL(codigo, nome, ementa, num_vagas, num_aulas, turno);
                DiscPresencial[contadorDiscpPresencial] = novaDiscPresencial;
                contadorDiscpPresencial++;
                System.out.println("Cadastro completo!");
                System.out.println(novaDiscPresencial);
                System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                sc.next();
                limparConsole();
            }
            
            case 3 ->{
                return;
            }
        }
    }

    public static void editarDisciplina(Scanner sc, ArrayList<ESTUDANTE> Estudantes, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores, DISCIPLINA_EAD[] DiscEAD, DISCIPLINA_PRESENCIAL[] DiscPresencial, int max){
        
    }







}

    
    
   
