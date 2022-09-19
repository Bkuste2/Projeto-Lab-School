package Model;

public class Pessoa {

    /*   ATTRIBUTES   */
    private static int counter = 1;
    private String nome, telefone, data_nascimento, cpf;
    private int id;

    /*   CONSTRUCTOR   */
    public Pessoa(){
        this.id = counter++;
    }
    public Pessoa(String nome, String telefone, String data_nascimento, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.id = counter++;
    }

    /*   GETTERS AND SETTERS   */
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getId() {
        return id;
    }

    /*   METHODS   */


    /*   TO STRING   */
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", data_nascimento='" + data_nascimento + '\'' +
                ", cpf='" + cpf + '\'' +
                ", id=" + id +
                '}';
    }
}
