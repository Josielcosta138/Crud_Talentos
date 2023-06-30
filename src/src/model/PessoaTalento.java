package model;

public abstract class PessoaTalento {

    private tipoAreaAtuacao tipo;

    private String nome;


    public tipoAreaAtuacao getTipo() {
        return tipo;
    }

    public void setTipo(tipoAreaAtuacao tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PessoaTalento{" +
                "tipo=" + tipo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
