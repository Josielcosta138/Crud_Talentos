package model;

public  class PessoaMentor extends Entity {
    private String nome;
    private EnumSexo enumSexo;
    private EnumEstado enumEstado;
    private EnumtipoAreaAtuacao enumtipoAreaAtuacao;

    private EnumContato enumContato;
    private int idade;
    private String cidade;
    private String historioDeMentorias;


    public PessoaMentor(String nome, EnumSexo enumSexo, EnumEstado enumEstado, EnumtipoAreaAtuacao enumtipoAreaAtuacao, EnumContato enumContato, int idade, String cidade, String historioDeMentorias) {
        this.nome = nome;
        this.enumSexo = enumSexo;
        this.enumEstado = enumEstado;
        this.enumtipoAreaAtuacao = enumtipoAreaAtuacao;
        this.enumContato = enumContato;
        this.idade = idade;
        this.cidade = cidade;
        this.historioDeMentorias = historioDeMentorias;
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

    public String getHistorioDeMentorias() {
        return historioDeMentorias;
    }

    public void setHistorioDeMentorias(String historioDeMentorias) {
        this.historioDeMentorias = historioDeMentorias;
    }

    public EnumEstado getEnumEstado() {
        return enumEstado;
    }

    public void setEnumEstado(EnumEstado enumEstado) {
        this.enumEstado = enumEstado;
    }

    public EnumtipoAreaAtuacao getEnumtipoAreaAtuacao() {
        return enumtipoAreaAtuacao;
    }

    public void setEnumtipoAreaAtuacao(EnumtipoAreaAtuacao enumtipoAreaAtuacao) {
        this.enumtipoAreaAtuacao = enumtipoAreaAtuacao;
    }

    public EnumContato getEnumContato() {
        return enumContato;
    }

    public void setEnumContato(EnumContato enumContato) {
        this.enumContato = enumContato;
    }

    @Override
    public String toString() {
        return "PessoaMentor{" +
                "nome='" + nome + '\'' +
                ", enumSexo=" + enumSexo +
                ", enumEstado=" + enumEstado +
                ", enumtipoAreaAtuacao=" + enumtipoAreaAtuacao +
                ", enumContato=" + enumContato +
                ", idade=" + idade +
                ", cidade='" + cidade + '\'' +
                ", historioDeMentorias='" + historioDeMentorias + '\'' +
                '}';
    }
}
