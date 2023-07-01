package model;

public enum EnumStartup {
    INNOVATETECH("InnovateTech"),
    TECHLAB("TechLab"),
    DIGITALLABS("DigitalLabs"),
    CONNECTX("ConnectX"),
    NEXUSTECH("NexusTech");

    private String descricao;
    EnumStartup(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}
