package model;

public enum EnumEstado {

    SC("Sc"),
    PR("Pr"),
    RS("Rs");
    private String descricao;


    EnumEstado(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}