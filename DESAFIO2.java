package com.mycompany.desafio2;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;


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
        Contadores Contador = new Contadores();
        
        
        System.out.println("        |Bem vindo "+usuario+"!|");
        do{
            try{
                limparConsole();
                exibirMenu();
                escolha = sc.nextInt();
                switch (escolha){
                    
                    //Manutenção de Pessoas
                    case 1 -> {
                        int escolhaMenu;
                        sc.nextLine();
                        limparConsole();
                        do{
                            System.out.print("Você deseja ADICIONAR ou EDITAR alguma pessoa?\nDigite:\n1 - ADICIONAR\n2 - EDITAR\n3 - Voltar ao menu\n--->");
                            escolhaMenu = sc.nextInt();
                            if (escolhaMenu == 1){
                                adicionarPessoa(sc, Estudantes, Professores, Tutores);
                            }else if (escolhaMenu == 2){
                                editarPessoa(sc, Estudantes, Professores, Tutores);
                            }else if (escolhaMenu == 3){
                               System.out.println("Voltndo ao menu...");
                               break;
                            }else{
                                System.out.println("Você informou uma entrada não válida! Tente novamente:");
                            }
                        }while(escolhaMenu != 3);
                    }
                    
                    //Manutenção de Disciplinas
                    case 2 -> {
                        int escolhaMenu;
                        sc.nextLine();
                        limparConsole();
                        do{
                            System.out.print("Você deseja ADICIONAR ou EDITAR alguma disciplina?\nDigite:\n1 - ADICIONAR\n2 - EDITAR\n3 - Voltar ao menu\n--->");
                            escolhaMenu = sc.nextInt();
                            if (escolhaMenu == 1){
                                limparConsole();
                                adicionarDisciplina(sc, Estudantes, Professores, Tutores, DiscEAD, DiscPresencial, max, Contador);
                            }else if (escolhaMenu == 2){
                                limparConsole();
                                editarDisciplina(sc, Estudantes, Professores, Tutores, DiscEAD, DiscPresencial, max, Contador);
                            }else if (escolhaMenu == 3){
                               System.out.println("Voltndo ao menu...");
                               break;
                            }else{
                                System.out.println("Você informou uma entrada não válida! Tente novamente:");
                            }
                        }while(escolhaMenu != 3);
                    }
                    
                    //Manutenção de horário
                    case 3 -> {
                        sc.nextLine();
                        manutHorario(sc, DiscPresencial, Contador);
                    }
                    
                    //Mantenção de matrículas
                    case 4 -> {
                        sc.nextLine();
                        manutMatricula(sc, Estudantes, Professores, Tutores, DiscEAD, DiscPresencial, max, Contador);
                    }
                    
                    //Exibir horário
                    case 5 -> {
                        sc.nextLine();
                        exibeHorario(sc, DiscPresencial, Contador, max);
                    }
                    
                    //Exibir matrícula do estudante
                    case 6 -> {
                        sc.nextLine();
                        exibeMatriculaEstudante(sc, Estudantes);
                    }
                    
                    //Exibir disciplinas por professor/tutor
                    case 7 -> {
                        sc.nextLine();
                        exibeDisc(sc, Professores, Tutores);
                    }
                    
                    //Sair
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
                         2. Manutenção de disciplinas
                         3. Manutenção de horário
                         4. Mantenção de matrículas
                         5. Exibir horário
                         6. Exibir matrícula do estudante
                         7. Exibir disciplinas por professor/tutor
                         8. Sair
                         
                         --->""");  
    }
    
    
    //Menu 1
    public static void adicionarPessoa(Scanner sc, ArrayList<ESTUDANTE> Estudantes, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores){
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

    private static void editarPessoa(Scanner sc, ArrayList<ESTUDANTE> Estudantes, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores) {
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
                String nomeProfessor = sc.nextLine();
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
    public static void adicionarDisciplina(Scanner sc, ArrayList<ESTUDANTE> Estudantes, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores, DISCIPLINA_EAD[] DiscEAD, DISCIPLINA_PRESENCIAL[] DiscPresencial, int max, Contadores Contador){
        limparConsole();
        System.out.print("""
                         Escolha a opção que desejar:
                         1. Adicionar Disciplina EAD
                         2. Adicionar Disciplina Presencial
                         3. Voltar
                         """);
        
        int escolhaMenu = sc.nextInt();
        limparConsole();
        switch(escolhaMenu){
            case 1 ->{
                if (Contador.getContadorDiscpEAD() == max){
                    System.out.println("Você já atingiu o número máximo de cadastro de disciplinas EAD!!\n\n");
                    System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                    sc.next();
                    limparConsole();
                    break;
                }
                System.out.println("Qual é o códgio da disciplina?");
                int codigo = sc.nextInt();
                
                System.out.println("Qual o nome da disciplina?");
                sc.nextLine();
                String nome = sc.nextLine();
                
                System.out.println("Descreva a ementa:");
                String ementa = sc.nextLine();
                
                System.out.println("Qual o número de vagas?");
                int num_vagas = sc.nextInt();
                
                System.out.println("Qual o número de unidades?");
                int num_unidades = sc.nextInt();
                
                DISCIPLINA_EAD novaDiscEAD = new DISCIPLINA_EAD(codigo, nome, ementa, num_vagas, num_unidades);
                DiscEAD[Contador.getContadorDiscpEAD()] = novaDiscEAD;
                Contador.setContadorDiscpEAD(Contador.getContadorDiscpEAD()+1);
                System.out.println("Cadastro completo!");
                System.out.println(novaDiscEAD);
                System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                sc.next();
                limparConsole();
            }
            
            case 2 ->{
                if (Contador.getContadorDiscpPresencial()== max){
                    System.out.println("Você já atingiu o número máximo de cadastro de disciplinas presenciais!!\n\n");
                    System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                    sc.next();
                    limparConsole();
                    break;
                }
                System.out.println("Qual é o códgio da disciplina?");
                int codigo = sc.nextInt();
                
                System.out.println("Qual o nome da disciplina?");
                sc.nextLine();
                String nome = sc.nextLine();
                
                System.out.println("Descreva a ementa:");
                String ementa = sc.nextLine();
                
                System.out.print("Qual o turno ");               
                for (TURNO turno : TURNO.values()) {System.out.print(" | "+turno);}
                System.out.print("  ?\n");
                TURNO turno = null;
                while(true){
                    String turnon = sc.next().toUpperCase();
                    try {
                        turno = TURNO.valueOf(turnon);
                        break;
                    } catch (IllegalArgumentException e) {System.out.println("Turno inválido! Tente novamente.");}  
                }
                
                System.out.print("Qual dia da semana ");               
                for (DIA_SEMANA dia_semana : DIA_SEMANA.values()) {System.out.print(" | "+dia_semana);}
                System.out.print(" ?\n");
                DIA_SEMANA dia_semana = null;
                while(true){
                    String dia_semanan = sc.next().toUpperCase();
                    try {
                        dia_semana = DIA_SEMANA.valueOf(dia_semanan);
                        break;
                    } catch (IllegalArgumentException e) {System.out.println("Dia inválido! Tente novamente.");}  
                }
                
                System.out.println("Qual o número de vagas?");
                int num_vagas = sc.nextInt();
                
                System.out.println("Qual o número de aulas?");
                int num_aulas = sc.nextInt();

                DISCIPLINA_PRESENCIAL novaDiscPresencial = new DISCIPLINA_PRESENCIAL(codigo, nome, ementa, num_vagas, num_aulas, turno, dia_semana);
                DiscPresencial[Contador.getContadorDiscpPresencial()] = novaDiscPresencial;
                Contador.setContadorDiscpPresencial(Contador.getContadorDiscpPresencial()+1);
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

    public static void editarDisciplina(Scanner sc, ArrayList<ESTUDANTE> Estudantes, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores, DISCIPLINA_EAD[] DiscEAD, DISCIPLINA_PRESENCIAL[] DiscPresencial, int max, Contadores Contador){
        System.out.println("""
                           
                           Escolha a opção para editar:
                           1. Disc. Presencial
                           2. Disc. EAD
                           3. Voltar
                           """);
        
        int escolhaMenu = sc.nextInt();
        
        switch(escolhaMenu){
            case 1 -> {
                limparConsole();
                System.out.println("Lista de Disciplinas Presenciais:");
                if (Contador.getContadorDiscpPresencial() == 0) {
                    System.out.println("Nenhuma disciplina encontrada.");
                    System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                    sc.next();
                    limparConsole();
                    break;
                }else{
                    for (int i = 0; i > Contador.getContadorDiscpPresencial(); i++) {
                        System.out.println(i+"- "+ DiscPresencial[i].getNome());
                    }
                    System.out.println("\nQual disciplina você deseja editar? Digite o indice:");
                    int indice = sc.nextInt();

                    while (indice >= Contador.getContadorDiscpPresencial()) {
                        System.out.println("Esse indice não existe!");
                        System.out.print("Digite o indice do funcionario que deseja editar:\n-->");
                        indice = sc.nextInt();
                    }

                    limparConsole();

                    int escolhaedit = 0;

                    System.out.println("\nO que você deseja editar?");
                    System.out.println("1- Código: " + DiscPresencial[escolhaedit].getCodigo());
                    System.out.println("2- Nome: "+  DiscPresencial[escolhaedit].getNome());
                    System.out.println("3- Ementa: " + DiscPresencial[escolhaedit].getEmenta());
                    System.out.println("4- Numero de vagas: "+  DiscPresencial[escolhaedit].getNumero_vagas());  
                    System.out.println("5- Numero de aulas: " + DiscPresencial[escolhaedit].getNumero_aulas());
                    System.out.println("6- Turno: "+  DiscPresencial[escolhaedit].getTurno());
                    System.out.println("7- Dia da semana: "+ DiscPresencial[escolhaedit].getDia_semana());
                    System.out.println("8- Remover disciplina");
                    System.out.println("9- Sair");

                    switch (escolhaedit) {
                        case 1 ->{
                            System.out.print("\nDigite o novo código: ");
                            int novoCod = sc.nextInt();
                            DiscPresencial[escolhaedit].setCodigo(novoCod);
                        }
                        case 2 -> {
                            System.out.print("\nDigite o novo nome: ");
                            String novonome = sc.nextLine();
                            DiscPresencial[escolhaedit].setNome(novonome);
                        }
                        case 3 ->{
                            System.out.print("\nDigite a nova ementa: ");
                            String novoEmenta = sc.nextLine();
                            DiscPresencial[escolhaedit].setEmenta(novoEmenta);
                        }

                        case 4 ->{
                            System.out.print("\nDigite o novo numero de vagas: ");
                            int novoNumVagas = sc.nextInt();
                            DiscPresencial[escolhaedit].setNumero_vagas(novoNumVagas);
                        }

                        case 5 ->{
                            System.out.print("\nDigite o novo numero de aulas: ");
                            int novoNumAulas = sc.nextInt();
                            DiscPresencial[escolhaedit].setNumero_aulas(novoNumAulas);
                        }
                        case 6 -> {
                            System.out.print("Qual o novo turno ");               
                            for (TURNO turno : TURNO.values()) {System.out.print(turno);}
                            System.out.print("?");
                            TURNO turno = null;
                            while(true){
                                String turnon = sc.next().toUpperCase();
                                try {
                                    turno = TURNO.valueOf(turnon);
                                    break;
                                }catch (IllegalArgumentException e) {System.out.println("Cargo inválido! Tente novamente.");}  
                            }
                            DiscPresencial[escolhaedit].setTurno(turno);
                        }
                        
                        case 7 ->{      
                            System.out.print("Qual o novo dia da semana ");  
                            for (DIA_SEMANA dia_semana : DIA_SEMANA.values()) {System.out.print(" | "+dia_semana);}
                            System.out.print("  ?");
                            DIA_SEMANA dia_semana = null;
                            while(true){
                                String dia_semanan = sc.next().toUpperCase();
                                try {
                                    dia_semana = DIA_SEMANA.valueOf(dia_semanan);
                                    break;
                                } catch (IllegalArgumentException e) {System.out.println("Dia inválido! Tente novamente.");}  
                            }
                            DiscPresencial[escolhaedit].setDia_semana(dia_semana);
                        }

                        case 8->{
                            System.out.println("Voce tem certeza que deseja excluir a disciplina: --> Código: "+DiscPresencial[escolhaedit].getCodigo()+" || Nome: "+DiscPresencial[escolhaedit].getNome()+" ?");
                            System.out.print("Se sim, digite 'S'\nSe não, digite 'N'\n-->");
                            String crtz = sc.next();
                            if ("S".equalsIgnoreCase(crtz)){
                                for (int i = escolhaedit; i < Contador.getContadorDiscpPresencial()-1; i++) {
                                    DiscPresencial[i] = DiscPresencial[i+1];
                                }
                                System.out.print("Registro deletado com sucesso!");
                                DiscPresencial[Contador.getContadorDiscpPresencial() - 1] = null;
                                Contador.setContadorDiscpPresencial(Contador.getContadorDiscpPresencial()-1);
                            }else{
                                break;
                            }
                        }
                        case 9->{
                           return; 
                        }
                    }
                }
            }
            
            case 2  ->{
                limparConsole();
                System.out.println("Lista de Disciplinas EAD's:");
                if (Contador.getContadorDiscpEAD() == 0) {
                    System.out.println("Nenhuma disciplina encontrada.");
                    System.out.println("\n\nInforme qualquer tecla para voltar ao menu...");
                    sc.next();
                    limparConsole();
                    break;
                }else{
                    for (int i = 0; i > Contador.getContadorDiscpEAD(); i++) {
                        System.out.println(i+"- "+ DiscEAD[i].getNome());
                    }
                    System.out.println("\nQual disciplina você deseja editar? Digite o indice:");
                    int indice = sc.nextInt();

                    while (indice >= Contador.getContadorDiscpEAD()) {
                        System.out.println("Esse indice não existe!");
                        System.out.print("Digite o indice do funcionario que deseja editar:\n-->");
                        indice = sc.nextInt();
                    }

                    limparConsole();

                    int escolhaedit = 0;

                    System.out.println("\nO que você deseja editar?");
                    System.out.println("1- Código: " + DiscEAD[escolhaedit].getCodigo());
                    System.out.println("2- Nome: "+  DiscEAD[escolhaedit].getNome());
                    System.out.println("3- Ementa: " + DiscEAD[escolhaedit].getEmenta());
                    System.out.println("4- Numero de vagas :"+ DiscEAD[escolhaedit].getNumero_vagas());
                    System.out.println("5- Numero de unidades :"+ DiscEAD[escolhaedit].getNumero_unidades());
                    System.out.println("6- Remover disciplina");
                    System.out.println("7- Sair");

                    switch (escolhaedit) {
                        case 1 ->{
                            System.out.print("\nDigite o novo código: ");
                            int novoCod = sc.nextInt();
                            DiscEAD[escolhaedit].setCodigo(novoCod);
                        }
                        case 2 -> {
                            System.out.print("\nDigite o novo nome: ");
                            String novonome = sc.nextLine();
                            DiscEAD[escolhaedit].setNome(novonome);
                        }
                        case 3 ->{
                            System.out.print("\nDigite a nova ementa: ");
                            String novoEmenta = sc.nextLine();
                            DiscEAD[escolhaedit].setEmenta(novoEmenta);
                        }

                        case 4 ->{
                            System.out.print("\nDigite o novo numero de vagas: ");
                            int novoNumVagas = sc.nextInt();
                            DiscEAD[escolhaedit].setNumero_vagas(novoNumVagas);
                        }

                        case 5 ->{
                            System.out.print("\nDigite o novo numero de unidades: ");
                            int novoNumUnidades = sc.nextInt();
                            DiscEAD[escolhaedit].setNumero_unidades(novoNumUnidades);
                        }
                       
                        case 6->{
                            System.out.println("Voce tem certeza que deseja excluir a disciplina: --> Código: "+DiscEAD[escolhaedit].getCodigo()+" || Nome: "+DiscEAD[escolhaedit].getNome()+" ?");
                            System.out.print("Se sim, digite 'S'\nSe não, digite 'N'\n-->");
                            String crtz = sc.next();
                            if ("S".equalsIgnoreCase(crtz)){
                                for (int i = escolhaedit; i < Contador.getContadorDiscpEAD()-1; i++) {
                                    DiscEAD[i] = DiscEAD[i+1];
                                }
                                System.out.print("Registro deletado com sucesso!");
                                DiscEAD[Contador.getContadorDiscpEAD() - 1] = null;
                                Contador.setContadorDiscpEAD(Contador.getContadorDiscpEAD()-1);
                            }else{
                                break;
                            }
                        }
                        case 7->{
                           return; 
                        }
                    }
                }
            }
            
            case 3 -> {
                break;
            }
        }
    }

    
    //MENU 3
    private static void manutHorario(Scanner sc, DISCIPLINA_PRESENCIAL[] DiscPresencial, Contadores Contador) {
        sc.nextLine();
        //Se não houver nenhum disciplina presencial cadastrada
        if (Contador.getContadorDiscpPresencial()== 0){
            System.out.print("Nenhuma disciplina cadastrada!\n\n");
            System.out.println("Pressione qualquer tecla para voltar...");
            sc.nextLine();
            return;
        }
        
        limparConsole();
        System.out.println("Qual disciplina quer manutenir?");

        
        //Printa o nome das disciplinas
        for (int i = 0; i < Contador.getContadorDiscpPresencial(); i++){
            System.out.println(i+"-"+DiscPresencial[i].getNome());
        }
        int escolhaManut = sc.nextInt();
        if (escolhaManut > Contador.getContadorDiscpPresencial()){
            System.out.print("Você informou um indice inexistente!\n\n");
            System.out.print("Pressione qualquer tecla para voltar...");
            sc.nextLine();
            limparConsole();
            return;
        }
        
        limparConsole();
        System.out.print("Quer editar:\n1- Turno\n2- Dia da semana\n-->");
        int escolhaTurnoDia = sc.nextInt();
        switch(escolhaTurnoDia){
            case 1 ->{
                System.out.print("Qual o novo turno ");               
                    for (TURNO turno : TURNO.values()) {System.out.print(" | "+turno);}
                    System.out.println("  ?");
                    TURNO turno = null;
                    while(true){
                        String turnon = sc.next().toUpperCase();
                        try {
                            turno = TURNO.valueOf(turnon);
                            break;
                        }catch (IllegalArgumentException e) {System.out.println("Cargo inválido! Tente novamente.");}  
                    }
                    DiscPresencial[escolhaManut].setTurno(turno);
            }
            
            case 2 ->{
                System.out.print("Qual o novo dia da semana ");  
                for (DIA_SEMANA dia_semana : DIA_SEMANA.values()) {System.out.print(" | "+dia_semana);}
                    System.out.println("  ?");
                    DIA_SEMANA dia_semana = null;
                    while(true){
                        String dia_semanan = sc.next().toUpperCase();
                        try {
                            dia_semana = DIA_SEMANA.valueOf(dia_semanan);
                            break;
                        } catch (IllegalArgumentException e) {System.out.println("Dia inválido! Tente novamente.");}  
                    }
                    DiscPresencial[escolhaManut].setDia_semana(dia_semana);
            }
        }
        
    }

    
    //MENU 4
    private static void manutMatricula(Scanner sc, ArrayList<ESTUDANTE> Estudantes, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores, DISCIPLINA_EAD[] DiscEAD, DISCIPLINA_PRESENCIAL[] DiscPresencial, int max, Contadores Contador) {
        limparConsole();
        System.out.print("""
                         Qual você quer manutenir a matrícula:
                         1- Estudante
                         2- Professor
                         3- Tutor
                         4- Sair
                         
                         -->""");
        int escolhaMenu = sc.nextInt();
        sc.nextLine();
        
        limparConsole();
        switch(escolhaMenu){
            //ESTUDANTES
            case 1 ->{
                //verifica se está vazio
                if (Estudantes.isEmpty()){
                    System.out.println("Não há estudantes cadastrados!");
                    System.out.println("\n\nInforme qualquer tecla para voltar...");
                    sc.nextLine();
                    limparConsole();
                    return;
                }


                //printa os estudantes cadastrados
                System.out.println("Qual dos estudantes quer mudar a matricula?\n");
                for (ESTUDANTE Estudante : Estudantes){
                    System.out.print("- "+Estudante.getNome()+" || Matricula: "+ Estudante.getMatricula());
                }
                System.out.print("\nDigite o nome:\n-->");
                String nomeEstudante =  sc.nextLine();

                int i;
                for (ESTUDANTE Estudante : Estudantes) {
                    if (Estudante.getNome().equals(nomeEstudante)) {
                        limparConsole();

                        //nova matricula
                        System.out.print("Escolha a nova disciplina cursada:\n1- EAD\n2- Presencial\n-->");
                        int escolhaDisc = sc.nextInt();
                        sc.nextLine();
                        limparConsole();

                        switch (escolhaDisc){
                            case 1->{
                                if(Contador.getContadorDiscpEAD()==0){
                                    System.out.println("Não existem disciplinas EAD casdastradas!");
                                    System.out.print("\n\nPressione qualquer tecla para voltar...");
                                    sc.nextLine();
                                    return;
                                }


                                //printa as disciplinas
                                for (i = 0; i < Contador.getContadorDiscpEAD(); i++){
                                    System.out.println(i+"- "+DiscEAD[i].getNome());
                                }
                                System.out.println("");
                                System.out.println("Qual a disciplina escolhida?\n-->");
                                int chooseDisc = sc.nextInt();


                                while (chooseDisc>=Contador.getContadorDiscpEAD()){
                                    System.out.print("Indice inválido! Tente novamente!");
                                    chooseDisc = sc.nextInt();
                                }

                                Estudante.setDisciplinas_cursadas(DiscEAD[chooseDisc].getNome());
                                System.out.println("Matriculado!");
                                return;
                            }
                            case 2 ->{
                                if(Contador.getContadorDiscpPresencial()==0){
                                    System.out.println("Não existem disciplinas presencial casdastradas!");
                                    System.out.print("\n\nPressione qualquer tecla para voltar...");
                                    sc.nextLine();
                                    return;
                                }

                                //printa as disciplinas
                                for (i = 0; i < Contador.getContadorDiscpPresencial(); i++){
                                    System.out.print(i+"- "+DiscPresencial[i].getNome());
                                }
                                System.out.println("");
                                System.out.print("Qual a disciplina escolhida? Digite o indice:\n-->");
                                int chooseDisc = sc.nextInt();


                                while (chooseDisc>=Contador.getContadorDiscpPresencial()){
                                    System.out.print("Indice inválido! Tente novamente!");
                                    chooseDisc = sc.nextInt();
                                }
                                Estudante.setDisciplinas_cursadas(DiscPresencial[chooseDisc].getNome());
                                System.out.println("Matriculado!");
                                return;
                            }
                        }
                    }
                    //indice inexistente
                    else{
                        System.out.print("Pessoa não encontrada!");
                        System.out.print("\n\nPressione qualquer tecla para voltar...");
                        sc.nextLine();
                        return;
                    }
                } 
            }
            
            //PROFESSORES
            case 2 ->{
                //verifica se está vazio
                if (Professores.isEmpty()){
                    System.out.println("Não há professores cadastrados!");
                    System.out.println("\n\nInforme qualquer tecla para voltar...");
                    sc.nextLine();
                    limparConsole();
                    return;
                }


                //printa os estudantes cadastrados
                System.out.println("Qual dos estudantes quer mudar a matricula?\n");
                for (PROFESSOR Professor : Professores){
                    System.out.print("- "+Professor.getNome()+" || Matricula: "+ Professor.getMatricula());
                }
                System.out.print("\nDigite o nome:\n-->");
                String nomeProfessores =  sc.nextLine();

                int i;
                for (PROFESSOR Professor : Professores) {
                    if (Professor.getNome().equals(nomeProfessores)) {
                        limparConsole();

                        //nova matricula
                        System.out.print("Escolha a nova disciplina cursada:\n1- EAD\n2- Presencial\n-->");
                        int escolhaDisc = sc.nextInt();
                        sc.nextLine();
                        limparConsole();

                        switch (escolhaDisc){
                            case 1->{
                                if(Contador.getContadorDiscpEAD()==0){
                                    System.out.println("Não existem disciplinas EAD casdastradas!");
                                    System.out.print("\n\nPressione qualquer tecla para voltar...");
                                    sc.nextLine();
                                    return;
                                }


                                //printa as disciplinas
                                for (i = 0; i < Contador.getContadorDiscpEAD(); i++){
                                    System.out.println(i+"- "+DiscEAD[i].getNome());
                                }
                                System.out.println("");
                                System.out.println("Qual a disciplina escolhida?\n-->");
                                int chooseDisc = sc.nextInt();


                                while (chooseDisc>=Contador.getContadorDiscpEAD()){
                                    System.out.print("Indice inválido! Tente novamente!");
                                    chooseDisc = sc.nextInt();
                                }

                                Professor.setDisciplinas(DiscEAD[chooseDisc].getNome());
                                System.out.println("Matriculado!");
                                return;
                            }
                            case 2 ->{
                                if(Contador.getContadorDiscpPresencial()==0){
                                    System.out.println("Não existem disciplinas presencial casdastradas!");
                                    System.out.print("\n\nPressione qualquer tecla para voltar...");
                                    sc.nextLine();
                                    return;
                                }

                                //printa as disciplinas
                                for (i = 0; i < Contador.getContadorDiscpPresencial(); i++){
                                    System.out.print(i+"- "+DiscPresencial[i].getNome());
                                }
                                System.out.println("");
                                System.out.print("Qual a disciplina escolhida? Digite o indice:\n-->");
                                int chooseDisc = sc.nextInt();


                                while (chooseDisc>=Contador.getContadorDiscpPresencial()){
                                    System.out.print("Indice inválido! Tente novamente!");
                                    chooseDisc = sc.nextInt();
                                }
                                Professor.setDisciplinas(DiscPresencial[chooseDisc].getNome());
                                System.out.println("Matriculado!");
                                return;
                            }
                        }
                    }
                    //indice inexistente
                    else{
                        System.out.print("Pessoa não encontrada!");
                        System.out.print("\n\nPressione qualquer tecla para voltar...");
                        sc.nextLine();
                        return;
                    }
                }
            }
            
            //TUTORES
            case 3 ->{
                //verifica se está vazio
                if (Tutores.isEmpty()){
                    System.out.println("Não há professores cadastrados!");
                    System.out.println("\n\nInforme qualquer tecla para voltar...");
                    sc.nextLine();
                    limparConsole();
                    return;
                }


                //printa os estudantes cadastrados
                System.out.println("Qual dos estudantes quer mudar a matricula?\n");
                for (TUTOR Tutor : Tutores){
                    System.out.print("- "+Tutor.getNome()+" || Matricula: "+ Tutor.getMatricula());
                }
                System.out.print("\nDigite o nome:\n-->");
                String nomeTutor=  sc.nextLine();

                int i;
                for (TUTOR Tutor : Tutores) {
                    if (Tutor.getNome().equals(nomeTutor)) {
                        limparConsole();

                        //nova matricula
                        System.out.print("Escolha a nova disciplina tutorada:");

                        if(Contador.getContadorDiscpEAD()==0){
                            System.out.println("Não existem disciplinas EAD casdastradas!");
                            System.out.print("\n\nPressione qualquer tecla para voltar...");
                            sc.nextLine();
                            return;
                        }


                        //printa as disciplinas
                        for (i = 0; i < Contador.getContadorDiscpEAD(); i++){
                            System.out.println(i+"- "+DiscEAD[i].getNome());
                        }
                        System.out.println("");
                        System.out.println("Qual a disciplina escolhida?\n-->");
                        int chooseDisc = sc.nextInt();


                        while (chooseDisc>=Contador.getContadorDiscpEAD()){
                            System.out.print("Indice inválido! Tente novamente!");
                            chooseDisc = sc.nextInt();
                        }

                        Tutor.setDisciplinas(DiscEAD[chooseDisc].getNome());
                        System.out.println("Matriculado!");
                        return;
                    }
                    //indice inexistente
                    else{
                        System.out.print("Pessoa não encontrada!");
                        System.out.print("\n\nPressione qualquer tecla para voltar...");
                        sc.nextLine();
                        return;
                    }
                }
            }
            
            //SAIR
            case 4 ->{
                limparConsole();
                return;
            }
            
            default ->{
                System.out.print("\n\nErro! Indice inexistente!\nTente novamente:\n");
            }
        }
    }

    
    //MENU 5
    private static void exibeHorario(Scanner sc, DISCIPLINA_PRESENCIAL[] DiscPresencial, Contadores Contador, int max) {
        sc.nextLine();
        limparConsole();
        System.out.print("Quer exibir horário de disciplinas:\n1- Presencial\n2- Voltar\n-->");
        int escolhaExibe = sc.nextInt();
        sc.nextLine();
        limparConsole();
        int i;
        
        switch (escolhaExibe) {
            case 1 -> {
                if (Contador.getContadorDiscpPresencial()==0){
                    System.out.print("Nenhuma disciplina cadastrada!\n\n");
                    System.out.println("Pressione qualquer tecla para voltar...");
                    sc.nextLine();
                    return;
                }
                System.out.println("Disciplinas Presencial:");
                for (DIA_SEMANA dia_semana : DIA_SEMANA.values()){
                    System.out.println("\n\n---"+dia_semana+"---\n");
                    for (i=0;i<Contador.getContadorDiscpPresencial();i++){
                        if (DiscPresencial[i].getDia_semana()==dia_semana){
                            System.out.print("-"+DiscPresencial[i].getNome()+"||"+DiscPresencial[i].getTurno());
                        }
                    }
                }
            }
            case 2 -> {
                System.out.println("Pressione qualquer tecla para voltar...");
                sc.nextLine();
                return;
            }
            default -> {
                System.out.print("Entrada inválida!\n");
                System.out.println("Pressione qualquer tecla para voltar...");
                sc.nextLine();
                return;
            }
        }
        System.out.println("\n\nPressione qualquer tecla para voltar...");
        sc.nextLine();
        }

    
    //MENU 6
    private static void exibeMatriculaEstudante(Scanner sc, ArrayList<ESTUDANTE> Estudantes) {
        limparConsole();
        if (Estudantes.isEmpty()){
            System.out.println("Não há estudantes matriculados!");
            System.out.println("\n\nPressione qualquer tecla para voltar...");
            sc.nextLine();
            return;
        }
        
        for (ESTUDANTE Estudante : Estudantes){
            System.out.print("Nome: "+Estudante.getNome()+ "|| Matricula: "+ Estudante.getMatricula()+"|| Curso: "+Estudante.getCurso() + "|| Disciplinas cursadas: " + Estudante.getDisciplinas_cursadas());
        }
        System.out.println("\n\nPressione qualquer tecla para voltar...");
        sc.nextLine();
    }

    
    //MENU 7
    private static void exibeDisc(Scanner sc, ArrayList<PROFESSOR> Professores, ArrayList<TUTOR> Tutores) {
        if (Professores.isEmpty() && Tutores.isEmpty()){
            System.out.print("Nenhum professor/tutor cadastrado!");
            System.out.println("\n\nPressione qualquer tecla para voltar...");
            sc.nextLine();
            return;
        }
        
        System.out.print("Professores: \n\n");
        if(!(Professores.isEmpty())){
            for (PROFESSOR Professor : Professores){
            System.out.println(Professor.getNome()+" - "+Professor.getDisciplinas());
            }
        }else{
            System.out.println("Nenhum professor cadastrado!\n\n");
        }
        
        System.out.print("Tutores: \n\n");
        if(!(Tutores.isEmpty())){
            for (TUTOR Tutor : Tutores){
            System.out.println(Tutor.getNome()+" - "+Tutor.getDisciplinas());
            }
        }else{
            System.out.println("Nenhum tutor cadastrado!\n\n");
        }
        
        System.out.println("\n\nPressione qualquer tecla para voltar...");
        sc.nextLine();
        return;
    }
}