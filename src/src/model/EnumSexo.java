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

    public static EnumSexo getType(Integer type){
        if(type == 0){
            return MASCULINO;
        } else if (type == 1) {
            return FEMININO;
        } else if (type == 2) {
            return OUTROS;
        }
        return  OUTROS;
    }
}