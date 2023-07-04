package model;
public enum EnumFormacao {
    ENSINO_FUNDAMENTAL("Ensino Fundamental"),
    ENSINO_MEDIO("Ensino Médio"),
    ENSINO_TECNICO("Ensino Técnico"),
    GRADUACAO("Graduação"),
    POS_GRADUACAO("Pós-graduação"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado");

    private final String descricao;

    EnumFormacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
