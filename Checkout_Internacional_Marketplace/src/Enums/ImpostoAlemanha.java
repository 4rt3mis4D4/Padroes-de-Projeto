package Enums;

public enum ImpostoAlemanha {
    UMSATZSTEUER(0.19, "Umsatzsteuer"),
    PRODUTOS_ESSENCIAIS(0.07, "Produtos Essenciais");

    private double imposto;
    private String tipo;

    ImpostoAlemanha(double imposto, String tipo){
        this.imposto = imposto;
        this.tipo = tipo;
    }

    public double getImposto(){
        return imposto;
    }

    public String getTipo(){
        return tipo;
    }
}
