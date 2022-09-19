import Model.Aluno;
import Model.Pedagogo;
import Model.Pessoa;
import Model.Professor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    static ArrayList<Aluno> alunos = new ArrayList<>();
    static ArrayList<Professor> professores = new ArrayList<>();
    static ArrayList<Pedagogo> pedagogos = new ArrayList<>();
    static ArrayList<Pessoa> todos = new ArrayList<>();

    public static void main(String[] args) {

        StartSistema();
    }

    private static void StartSistema(){
        System.out.println("\nBem Vindo ao nosso sistema, o que você deseja fazer?\n");



        Scanner scInt = new Scanner(System.in);

        System.out.println("\n1 - Adicionar um aluno \n2 - Adicionar um professor \n3 - Adicionar um pedagogo \n4 - Relatórios Gerais \n5 - Relatórios dos alunos \n6 - Relatórios dos professores \n7 - Atendimento Pedagógico " +
                "\n8 - Aluno com mais atendimentos \n9 - Pedagogo com mais atendimentos \n10 - Alterar condição da matrícula \n11 - Sair \n\n");
        int escolha = scInt.nextInt();
        switch (escolha) {
            case 1:
                Aluno aluno = new Aluno();
                alunos.add(aluno);
                todos.add(aluno);
                StartSistema();
                break;
            case 2:
                Professor professor = new Professor();
                professores.add(professor);
                todos.add(professor);
                StartSistema();
                break;
            case 3:
                Pedagogo pedagogo = new Pedagogo();
                pedagogos.add(pedagogo);
                todos.add(pedagogo);
                StartSistema();
                break;
            case 4:
                gerarRelatorio();
                StartSistema();
                break;
            case 5:
                gerarRelatorioAlunos();
                StartSistema();
                break;
            case 6:
                gerarRelatorioProfessores();
                StartSistema();
                break;
            case 7:
                realizarAtedimento();
                StartSistema();
                break;
            case 8:
                AtomicInteger atendimentos = new AtomicInteger();
                AtomicReference<String> alunoComMaisAtendimentos = new AtomicReference<>("");
                alunos.forEach(e -> {
                    if(e.getTotalAtendimentos() > atendimentos.get()){
                        atendimentos.set(e.getTotalAtendimentos());
                        alunoComMaisAtendimentos.set(e.getNome() + ", id: " + e.getId());
                    }
                });
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                System.out.println("O Aluno com mais atendimentos foi: " + alunoComMaisAtendimentos + " com um total de: " + atendimentos + " atendimentos!");
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                StartSistema();
                break;
            case 9:
                AtomicInteger atendimentosPedagogicos = new AtomicInteger();
                AtomicReference<String> PedagogoComMaisAtendimentos = new AtomicReference<>("");
                pedagogos.forEach(e -> {
                    if(e.getTotalAtdPedagogicos() > atendimentosPedagogicos.get()){
                        atendimentosPedagogicos.set(e.getTotalAtdPedagogicos());
                        PedagogoComMaisAtendimentos.set(e.getNome() + ", id: " + e.getId());
                    }
                });
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                System.out.println("O Pedagogo com mais atendimentos foi: " + PedagogoComMaisAtendimentos + " com um total de: " + atendimentosPedagogicos + " atendimentos!");
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                StartSistema();
                break;
            case 10:
                System.out.println("Id do aluno: ");
                int num = scInt.nextInt();
                alunos.forEach(e -> {
                    if (e.getId() == num){
                        e.setCondicaoMatriculaStart();
                    }
                });
                StartSistema();
                break;
            case 11:
                System.exit(200);
                break;
            default:
                System.out.println("\nValor Inválido!");
                StartSistema();
                break;
        }

    }

    private static void gerarRelatorio(){
        Scanner scInt = new Scanner(System.in);
        System.out.println("\n\nVocê deseja ver os relatórios dos: \n1 - Alunos \n2 - Professores \n3 - Pedagogos \n4 - todos ");
        int num = scInt.nextInt();
        switch (num){
            case 1:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                alunos.forEach(e -> System.out.println("\nID: " + e.getId() + " Nome: " + e.getNome() + " CPF: " + e.getCpf()));
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 2:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                professores.forEach(e -> System.out.println("\nID: " + e.getId() + " Nome: " + e.getNome() + " CPF: " + e.getCpf()));
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 3:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                pedagogos.forEach(e -> System.out.println("\nID: " + e.getId() + " Nome: " + e.getNome() + " CPF: " + e.getCpf()));
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 4:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                todos.forEach(e -> System.out.println("\nID: " + e.getId() + " Nome: " + e.getNome() + " CPF: " + e.getCpf()));
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            default:
                System.out.println("Valor Inválido");
                gerarRelatorio();
        }
    }
    private static void gerarRelatorioAlunos(){
        Scanner scInt = new Scanner(System.in);
        System.out.println("\n\nVocê deseja ver os relatórios dos alunos com a categoria: \n1 - Ativa \n2 - Irregular \n3 - Atendimento pedagógico \n4 - Inativo \n5 - todos ");
        int num = scInt.nextInt();
        switch (num){
            case 1:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                alunos.forEach(e -> {
                    if (e.getCondicaoMatricula() == "Ativo"){
                        System.out.println("\nID: " + e.getId() + " Nota: " + e.getNotaEntrada() + " Total de Atendimentos: " + e.getTotalAtendimentos());
                    }
                });
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 2:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                alunos.forEach(e -> {
                    if (e.getCondicaoMatricula() == "Irregular"){
                        System.out.println("\nID: " + e.getId() + " Nota: " + e.getNotaEntrada() + " Total de Atendimentos: " + e.getTotalAtendimentos());
                    }
                });
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 3:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                alunos.forEach(e -> {
                    if (e.getCondicaoMatricula() == "Atendimento Pedagógico"){
                        System.out.println("\nID: " + e.getId() + " Nota: " + e.getNotaEntrada() + " Total de Atendimentos: " + e.getTotalAtendimentos());
                    }
                });
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 4:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                alunos.forEach(e -> {
                    if (e.getCondicaoMatricula() == "Inativo"){
                        System.out.println("\nID: " + e.getId() + " Nota: " + e.getNotaEntrada() + " Total de Atendimentos: " + e.getTotalAtendimentos());
                    }
                });
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 5:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                alunos.forEach(e -> System.out.println("\nID: " + e.getId() + " Nota: " + e.getNotaEntrada() + " Total de Atendimentos: " + e.getTotalAtendimentos()));
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            default:
                System.out.println("Valor Inválido");
                gerarRelatorio();
        }
    }
    private static void gerarRelatorioProfessores(){
        Scanner scInt = new Scanner(System.in);
        System.out.println("\n\nVocê deseja ver os relatórios dos professores com a categoria: \n1 - Front-End \n2 - Back-End \n3 - Full-Stack \n4 - todos ");
        int num = scInt.nextInt();
        switch (num){
            case 1:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                professores.forEach(e -> {
                    if (e.getExperiencia() == "Front-End"){
                        System.out.println("\nID: " + e.getId() + " Nome: " + e.getNome() + " CPF: " + e.getCpf());
                    }
                });
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 2:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                professores.forEach(e -> {
                    if (e.getExperiencia() == "Back-end"){
                        System.out.println("\nID: " + e.getId() + " Nome: " + e.getNome() + " CPF: " + e.getCpf());
                    }
                });
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 3:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                professores.forEach(e -> {
                    if (e.getExperiencia() == "Full-Stack"){
                        System.out.println("\nID: " + e.getId() + " Nome: " + e.getNome() + " CPF: " + e.getCpf());
                    }
                });
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            case 4:
                System.out.println("\\------------------------------------------------------------------------------------------------------------------\\\n\n");
                professores.forEach(e -> System.out.println("\nID: " + e.getId() + " Nome: " + e.getNome() + " CPF: " + e.getCpf()));
                System.out.println("\n\n\\------------------------------------------------------------------------------------------------------------------\\");
                break;
            default:
                System.out.println("Valor Inválido");
                gerarRelatorio();
        }
    }
    private static void realizarAtedimento(){
        Scanner scInt = new Scanner(System.in);
        System.out.println("ID aluno: ");
        int aluno = scInt.nextInt();
        alunos.forEach(e -> {
            if (e.getId() == aluno) {
                e.setTotalAtendimentos();
            }
        });
        System.out.println("ID pedagogo: ");
        int pedagogo = scInt.nextInt();
        pedagogos.forEach(e -> {
            if (e.getId() == pedagogo) {
                e.setTotalAtdPedagogicos();
            }
        });
    }

}
