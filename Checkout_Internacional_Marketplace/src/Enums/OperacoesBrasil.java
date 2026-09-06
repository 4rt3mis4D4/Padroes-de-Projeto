package Enums;

public enum OperacoesBrasil {
    ESTADUAL("5102", 0.18),
    INTERESTADUAL("6102", 0.12);

    private String cfop;
    private double icms;

    OperacoesBrasil(String cfop, double icms){
        this.cfop = cfop;
        this.icms = icms;
    }

    public String getCfop(){
        return cfop;
    }

    public double getIcms(){
        return icms;
    }
}
