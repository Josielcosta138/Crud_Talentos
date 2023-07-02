package model;

public enum EnumSexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTROS("Outros");

    private String descricao;


    EnumSexo(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}