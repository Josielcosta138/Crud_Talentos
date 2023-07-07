package model;
public enum EnumFormacao {
    ENSINO_FUNDAMENTAL("Ensino Fundamental"),
    ENSINO_MEDIO("Ensino Médio"),
    ENSINO_TECNICO("Ensino Técnico"),
    GRADUACAO("Graduação"),
    POS_GRADUACAO("Pós-graduação"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado");

    private  String descricao;

    public static EnumFormacao getType(Integer type){
        if(type == 0){
            return ENSINO_FUNDAMENTAL;
        } else if (type == 1) {
            return ENSINO_MEDIO;
        } else if (type == 2) {
            return ENSINO_TECNICO;
        } else if (type == 3) {
            return GRADUACAO;
        } else if (type == 4) {
            return POS_GRADUACAO;
        }else if (type == 5) {
            return MESTRADO;
        } else if (type == 6) {
            return MESTRADO;
        }else if (type == 7) {
            return DOUTORADO;
        }
        return  DOUTORADO;
    }


    EnumFormacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
