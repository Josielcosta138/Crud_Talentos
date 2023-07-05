package model;

public enum EnumCidades {

    CIDADE_CRICIUMA("Criciúma"),
    CIDADE_GUARULHOS("Guarulhos"),
    CIDADE_PORTO_ALEGRE("Porto alegre");

    private final String descricao;

    EnumCidades(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
