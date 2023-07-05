package model;

import java.util.List;

public  class PessoaMentor extends Entity {
    private String nome;
    private int idade;
    private EnumSexo enumSexo;
    private EnumFormacao enumFormacao;
    private EnumCidades enumCidades;
    private EnumtipoAreaAtuacao enumtipoAreaAtuacao;
    private String historioDeMentorias;
    private List<EnumContato> contatos;
    private String DescricaoContato;

    public PessoaMentor(String nome, int idade, EnumSexo enumSexo, EnumFormacao enumFormacao, EnumCidades enumCidades, EnumtipoAreaAtuacao enumtipoAreaAtuacao, String historioDeMentorias, List<EnumContato> contatos, String descricaoContato) {
        this.nome = nome;
        this.idade = idade;
        this.enumSexo = enumSexo;
        this.enumFormacao = enumFormacao;
        this.enumCidades = enumCidades;
        this.enumtipoAreaAtuacao = enumtipoAreaAtuacao;
        this.historioDeMentorias = historioDeMentorias;
        this.contatos = contatos;
        DescricaoContato = descricaoContato;
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


    public String getHistorioDeMentorias() {
        return historioDeMentorias;
    }

    public void setHistorioDeMentorias(String historioDeMentorias) {
        this.historioDeMentorias = historioDeMentorias;
    }

    public EnumtipoAreaAtuacao getEnumtipoAreaAtuacao() {
        return enumtipoAreaAtuacao;
    }

    public void setEnumtipoAreaAtuacao(EnumtipoAreaAtuacao enumtipoAreaAtuacao) {
        this.enumtipoAreaAtuacao = enumtipoAreaAtuacao;
    }

    public EnumFormacao getEnumFormacao() {
        return enumFormacao;
    }

    public void setEnumFormacao(EnumFormacao enumFormacao) {
        this.enumFormacao = enumFormacao;
    }

    public EnumCidades getEnumCidades() {
        return enumCidades;
    }

    public void setEnumCidades(EnumCidades enumCidades) {
        this.enumCidades = enumCidades;
    }

    public List<EnumContato> getContatos() {
        return contatos;
    }

    public void setContatos(List<EnumContato> contatos) {
        this.contatos = contatos;
    }

    public String getDescricaoContato() {
        return DescricaoContato;
    }

    public void setDescricaoContato(String descricaoContato) {
        DescricaoContato = descricaoContato;
    }



}
