package model;

public class Contato {


    private static String descricaoContato;
    private static EnumContato enumContato;

    private static long id;
    private static long Idd;


    public Contato(String descricaoContato, EnumContato enumContato) {
        this.descricaoContato = descricaoContato;
        this.enumContato = enumContato;
    }


    public static String getDescricaoContato() {
        return descricaoContato;
    }

    public static long getId() {
        return id;
    }

    public static long getIdd() {
        return 1;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setDescricaoContato(String descricaoContato) {
        this.descricaoContato = descricaoContato;
    }


    public static EnumContato getEnumContato() {
        return enumContato;
    }


    @Override
    public String toString() {
        return "Contato{" +
                ", descricaoContato='" + descricaoContato + '\'' +
                ", enumContato=" + enumContato +
                '}';
    }
}
