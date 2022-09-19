package Model;

import java.util.Scanner;

public class Pedagogo extends Pessoa{

    /*   ATTRIBUTES   */
    private int totalAtdPedagogicos = 0;

    /*   CONSTRUCTOR   */
    public Pedagogo() {
        Scanner scStr = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);

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

        System.out.println("\nCadastro concluído com sucesso!");
        System.out.println("\n\n" +
                "nome: " + super.getNome() +
                ", telefone: " + getTelefone() +
                ", Data Nascimento: " + super.getData_nascimento() +
                ", Cpf: " + super.getCpf() +
                ", Total de Atendimentos: " + totalAtdPedagogicos +
                ", id: " + super.getId()
        );
    }

    /*   GETTERS AND SETTERS   */
    public int getTotalAtdPedagogicos() {
        return totalAtdPedagogicos;
    }
    public void setTotalAtdPedagogicos() {
        this.totalAtdPedagogicos++;
    }

    /*   TO STRING   */
    @Override
    public String toString() {
        return  "nome: " + super.getNome() +
                ", telefone: " + getTelefone() +
                ", Data Nascimento: " + super.getData_nascimento() +
                ", Cpf: " + super.getCpf() +
                ", Total de Atendimentos: " + totalAtdPedagogicos +
                ", id: " + super.getId();
    }
}
