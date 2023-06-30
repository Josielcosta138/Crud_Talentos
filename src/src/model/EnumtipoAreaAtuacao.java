package model;
public enum EnumtipoAreaAtuacao {
    MARKTING("Marketing"),
    ANALISTA_DE_SISTEMA("Analista de Sistemas"),
    DIREITO_EMPRESARIAL("Direito Empresarial"),
    GESTAO_FINANCEIRA("Gestão Financeira"),
    MENTOR_EM_INOVACAO("Mentor em Inovação"),
    EDUCAO_PARA_MIDIAS("Educao para Midias"),
    QA("QA"),
    DESENVOLVEDOR_BACKEND("Desenvolvedor Back-End"),
    DESENVOLVEDOR_FRONTEND("Desenvolvedor Front-End"),
    ANALISTA_DE_NEGOCIO("Analista de Negocio"),
    PO ("PO"),
    SCRUMMASTER("Scrum Master"),

    OUTROS("Outros");

    private String descricao;
    EnumtipoAreaAtuacao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}