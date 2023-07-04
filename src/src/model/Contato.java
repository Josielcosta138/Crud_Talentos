package model;

public class Contato {


    private String descricaoContato;

    private EnumContato enumContato;

    public Contato(String descricaoContato, EnumContato enumContato) {
        this.descricaoContato = descricaoContato;
        this.enumContato = enumContato;
    }

    public String getDescricaoContato() {
        return descricaoContato;
    }

    public void setDescricaoContato(String descricaoContato) {
        this.descricaoContato = descricaoContato;
    }

    public EnumContato getEnumContato() {
        return enumContato;
    }

    public void setEnumContato(EnumContato enumContato) {
        this.enumContato = enumContato;
    }

    @Override
    public String toString() {
        return "Contato{" +
                ", descricaoContato='" + descricaoContato + '\'' +
                ", enumContato=" + enumContato +
                '}';
    }
}
