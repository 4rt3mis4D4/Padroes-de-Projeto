package Enums;

public enum EstadoDestinoEua {
    CALIFORNIA(0.0725, "Califórnia"),
    TEXAS(0.0625, "Texas"),
    OREGON(0.00, "Oregon");

    private double salesTax;
    private String estado;

    EstadoDestinoEua(double salesTax, String estado){
        this.salesTax = salesTax;
        this.estado = estado;
    }

    public double getSalesTax(){
        return salesTax;
    }

    public String getEstado(){
        return estado;
    }
}
