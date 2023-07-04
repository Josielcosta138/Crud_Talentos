package model;

public enum EnumContato {
    TELEFONE("Telefone"),
    WHATSAPP("Whatsapp"),
    FACEBOOK("Facebook"),
    INSTAGRAM("Instagram"),
    LINKEDIN("LinkedIn"),
    TWITTER("Twitter");

    private String descricao;
    EnumContato(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}
