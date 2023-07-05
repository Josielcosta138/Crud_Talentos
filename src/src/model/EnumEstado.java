package model;

import java.util.Objects;

public enum EnumEstado {

    SC("Sc"),
    PR("Pr"),
    RS("Rs");
    private String descricao;


    EnumEstado(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        if (Objects.equals(getDescricao(), "sp")){
            return "1";

        }else {
            return "2";
        }

    }
}