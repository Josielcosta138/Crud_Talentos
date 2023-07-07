package model;

public enum EnumCidades {

    CIDADE_CRICIUMA("Criciúma"),
    CIDADE_GUARULHOS("Guarulhos"),
    CIDADE_PORTO_ALEGRE("Porto alegre");

    private  String descricao;

    EnumCidades(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return "1";
    }
}
