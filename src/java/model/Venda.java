package model;

public class Venda {
    private int codVenda;
    private String nome;
    private String email;
    private String telefone;
    private String sexo;
    private String nascimento;
    private String cidade;
    private String estado;
    private String endereco;

    public Venda(){
    }

    public Venda(int codVenda, String nome, String email, String telefone, String sexo, String nascimento, String cidade, String estado, String endereco) {
        this.codVenda = codVenda;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
    }

    public Venda(String nome, String email, String telefone, String sexo, String nascimento, String cidade, String estado, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
}
