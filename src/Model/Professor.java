package Model;

import java.util.Scanner;

public class Professor extends Pessoa{

    /*   ATTRIBUTES   */
    private String formacaoAcademica, experiencia, estado;

    /*   CONSTRUCTOR   */
    public Professor() {
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

        setFormacaoAcademicaStart();
        setExperienciaStart();
        setEstadoStart();

        System.out.println("\nCadastro concluído com sucesso!");
        System.out.println("\nnome: " + super.getNome() +
                ", telefone: " + getTelefone() +
                ", Data Nascimento: " + super.getData_nascimento() +
                ", Cpf: " + super.getCpf() +
                ", Formação Acadêmica: " + formacaoAcademica +
                ", Experiência em Desenvolvimento: " + experiencia +
                ", Estado: " + estado +
                ", ID: " + super.getId());
    }

    public Professor(String nome, String telefone, String data_nascimento, String cpf){
        super(nome, telefone, data_nascimento, cpf);
    }

    /*   GETTERS AND SETTERS   */

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }
    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }
    public String getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*   METHODS   */
    private void setFormacaoAcademicaStart(){
        Scanner scInt = new Scanner(System.in);

        System.out.println("\nFormação Acadêmica: \n1 - Graduação incompleta \n2 - Graduação completa \n3 - Mestrado \n4 - Doutorado");
        int formacaoAcademica = scInt.nextInt();
        switch (formacaoAcademica) {
            case 1:
                this.formacaoAcademica = "Graduação incompleta";
                break;
            case 2:
                this.formacaoAcademica = "Graduação completa";
                break;
            case 3:
                this.formacaoAcademica = "Mestrado";
                break;
            case 4:
                this.formacaoAcademica = "Doutorado";
                break;
            default:
                System.out.println("\n\nResposta inválida!");
                setFormacaoAcademicaStart();
                break;
        }
    }

    private void setExperienciaStart(){
        Scanner scInt = new Scanner(System.in);

        System.out.println("\nExperiência em desenvolvimento: \n1 - Front-End \n2 - Back-End \n3 - Full-Stack");
        int experiencia = scInt.nextInt();

        switch (experiencia) {
            case 1:
                this.experiencia = "Front-End";
                break;
            case 2:
                this.experiencia = "Back-End";
                break;
            case 3:
                this.experiencia = "Full-Stack";
                break;
            default:
                System.out.println("\n\nResposta inválida!");
                setExperienciaStart();
                break;
        }
    }


    private void setEstadoStart(){
        Scanner scInt = new Scanner(System.in);

        System.out.println("\nEstado: \n1 - Ativo \n2 - Inativo");
        int estado = scInt.nextInt();

        switch (estado) {
            case 1:
                this.estado = "Ativo";
                break;
            case 2:
                this.estado = "Inativo";
                break;
            default:
                System.out.println("\n\nResposta inválida!");
                setEstadoStart();
                break;
            }
    }

    /*   TO STRING   */
    public String toString() {
        return "nome: " + super.getNome() +
                ", telefone: " + getTelefone() +
                ", Data Nascimento: " + super.getData_nascimento() +
                ", Cpf: " + super.getCpf() +
                ", Formação Acadêmica: " + formacaoAcademica +
                ", Experiência em Desenvolvimento: " + experiencia +
                ", Estado: " + estado +
                ", ID: " + super.getId();
    }
}
