package model;

public  class PessoaMentor extends Entity {
    private String nome;
    private EnumtipoAreaAtuacao enumtipoAreaAtuacao;

    private EnumSexo enumSexo;
    private int idade;
    private String cidade;
    private String estado;
    private String email;
    private String linkdin;
    private String especialidade;
    private String historioDeMentorias;
    private EnumStartup enumStartup;


    public PessoaMentor(EnumtipoAreaAtuacao enumtipoAreaAtuacao, String nome, EnumSexo enumSexo, int idade, String cidade, String estado, String email, String linkdin, String especialidade, String historioDeMentorias, EnumStartup enumStartup) {
        this.enumtipoAreaAtuacao = enumtipoAreaAtuacao;
        this.nome = nome;
        this.enumSexo = enumSexo;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.linkdin = linkdin;
        this.especialidade = especialidade;
        this.historioDeMentorias = historioDeMentorias;
        this.enumStartup = enumStartup;
    }

    public EnumtipoAreaAtuacao getEnumtipoAreaAtuacao() {
        return enumtipoAreaAtuacao;
    }

    public void setEnumtipoAreaAtuacao(EnumtipoAreaAtuacao enumtipoAreaAtuacao) {
        this.enumtipoAreaAtuacao = enumtipoAreaAtuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnumSexo getEnumSexo() {
        return enumSexo;
    }

    public void setEnumSexo(EnumSexo enumSexo) {
        this.enumSexo = enumSexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkdin() {
        return linkdin;
    }

    public void setLinkdin(String linkdin) {
        this.linkdin = linkdin;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getHistorioDeMentorias() {
        return historioDeMentorias;
    }

    public void setHistorioDeMentorias(String historioDeMentorias) {
        this.historioDeMentorias = historioDeMentorias;
    }

    public EnumStartup getEnumStartup() {
        return enumStartup;
    }

    public void setEnumStartup(EnumStartup enumStartup) {
        this.enumStartup = enumStartup;
    }

    @Override
    public String toString() {
        return "PessoaTalento{" +
                "enumtipoAreaAtuacao=" + enumtipoAreaAtuacao +
                ", nome='" + nome + '\'' +
                ", enumSexo=" + enumSexo +
                ", idade=" + idade +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", email='" + email + '\'' +
                ", linkdin='" + linkdin + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", historioDeMentorias='" + historioDeMentorias + '\'' +
                ", enumStartup=" + enumStartup +
                '}';
    }
}
