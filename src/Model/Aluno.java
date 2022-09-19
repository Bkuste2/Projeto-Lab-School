package Model;

import java.util.List;
import java.util.Scanner;

public class Aluno extends Pessoa{

    /*   ATTRIBUTES   */
    private String condicaoMatricula;
    private int notaEntrada;
    private int totalAtendimentos = 0;

    /*   CONSTRUCTOR   */
    public Aluno() {
        Scanner scStr = new Scanner(System.in);
        Scanner scDou = new Scanner(System.in);

        System.out.println("\nInforme o Nome: ");
        String nome = scStr.nextLine();
        super.setNome(nome);

        System.out.println("\nInforme o Telefone: ");
        String telefone = scStr.nextLine();
        super.setTelefone(telefone);

        System.out.println("\nInforme a Data de Nascimento: ");
        String dtn = scStr.nextLine();
        super.setData_nascimento(dtn);

        System.out.println("\nInforme o CPF: ");
        String cpf = scStr.nextLine();
        super.setCpf(cpf);

        System.out.println("\nInforme sua Nota de Entrada");
        this.notaEntrada = scDou.nextInt();

        setCondicaoMatriculaStart();
        System.out.println("\nCadastro concluído com sucesso!");
        System.out.println("\nnome: " + super.getNome() +
                ", telefone: " + getTelefone() +
                ", Data Nascimento: " + super.getData_nascimento() +
                ", Cpf: " + super.getCpf() +
                ", Nota de Entrada: " + notaEntrada +
                ", Condição da Matrícula: " + condicaoMatricula +
                ", id: " + super.getId() +
                "\n"
        );
    }

    public Aluno(String nome, String telefone, String data_nascimento, String cpf, String condicaoMatricula, int notaEntrada){
        super(nome, telefone, data_nascimento, cpf);
        this.notaEntrada = notaEntrada;
        this.condicaoMatricula = condicaoMatricula;
    }

    /*   GETTERS AND SETTERS   */
    public String getCondicaoMatricula() {
        return condicaoMatricula;
    }
    public void setCondicaoMatricula(String condicaoMatricula) {
        this.condicaoMatricula = condicaoMatricula;
    }
    public int getNotaEntrada() {
        return notaEntrada;
    }
    public void setNotaEntrada(int notaEntrada) {
        this.notaEntrada = notaEntrada;
    }
    public int getTotalAtendimentos() {
        return totalAtendimentos;
    }
    public void setTotalAtendimentos() {
        this.totalAtendimentos = totalAtendimentos += 1;
    }

    /*   METHODS   */
    private void setCondicaoMatriculaStart(){
        Scanner scInt = new Scanner(System.in);

        System.out.println("\nCondição da Matrícula: \n1 - Ativo \n2 - Irregular \n3 - Atendimento Pedagógico \n4 - Inativo");
        int condicaoMatricula = scInt.nextInt();

        switch (condicaoMatricula) {
            case 1:
                this.condicaoMatricula = "Ativo";
                break;
            case 2:
                this.condicaoMatricula = "Irregular";
                break;
            case 3:
                this.condicaoMatricula = "Atendimento Pedagógico";
                break;
            case 4:
                this.condicaoMatricula = "Inativo";
                break;
            default:
                System.out.println("Resposta inválida!");
                setCondicaoMatriculaStart();
                break;
        }
    }

    /*   TO STRING   */
    @Override
    public String toString() {
        return  "nome: " + super.getNome() +
                ", telefone: " + getTelefone() +
                ", Data Nascimento: " + super.getData_nascimento() +
                ", Cpf: " + super.getCpf() +
                ", Nota de Entrada: " + notaEntrada +
                ", Condição da Matrícula: " + condicaoMatricula +
                ", id: " + super.getId();
    }
}
