package model;

public class AreaAtuacao {

    private int id;
    private String nomeAreaAtuacao;


    public AreaAtuacao(int id, String nomeAreaAtuacao) {
        this.id = id;
        this.nomeAreaAtuacao = nomeAreaAtuacao;
    }

    public String getNomeAreaAtuacao() {
        return nomeAreaAtuacao;
    }

    public void setNomeAreaAtuacao(String nomeAreaAtuacao) {
        this.nomeAreaAtuacao = nomeAreaAtuacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AreaAtuacao{" +
                "id=" + id +
                ", nomeAreaAtuacao='" + nomeAreaAtuacao + '\'' +
                '}';
    }
}
