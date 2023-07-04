package model;

import java.util.List;

public  class PessoaMentor extends Entity {
    private String nome;
    private int idade;
    private EnumSexo enumSexo;
    private String cidade;
    private EnumEstado enumEstado;
    private EnumtipoAreaAtuacao enumtipoAreaAtuacao;
    private String historioDeMentorias;
    private List<EnumContato> contatos;

    public PessoaMentor(String nome, int idade, EnumSexo enumSexo, String cidade, EnumEstado enumEstado, EnumtipoAreaAtuacao enumtipoAreaAtuacao, String historioDeMentorias, List<EnumContato> contatos) {
        this.nome = nome;
        this.idade = idade;
        this.enumSexo = enumSexo;
        this.cidade = cidade;
        this.enumEstado = enumEstado;
        this.enumtipoAreaAtuacao = enumtipoAreaAtuacao;
        this.historioDeMentorias = historioDeMentorias;
        this.contatos = contatos;
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

    public List<EnumContato> getContatos() {
        return contatos;
    }

    public void setContatos(List<EnumContato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "PessoaMentor{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", enumSexo=" + enumSexo +
                ", cidade='" + cidade + '\'' +
                ", enumEstado=" + enumEstado +
                ", enumtipoAreaAtuacao=" + enumtipoAreaAtuacao +
                ", historioDeMentorias='" + historioDeMentorias + '\'' +
                ", contatos=" + contatos +
                '}';
    }
}
