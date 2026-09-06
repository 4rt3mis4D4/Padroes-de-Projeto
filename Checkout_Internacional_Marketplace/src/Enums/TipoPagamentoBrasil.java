package Enums;

public enum TipoPagamentoBrasil
{
        PIX(0.05, "Pix"),
        BOLETO(0.00, "Boleto Bancário");

        private double desconto;
        private String tipo;

        TipoPagamentoBrasil(double desconto, String tipo){
                this.desconto = desconto;
                this.tipo = tipo;
        }

        public double getDesconto(){
                return desconto;
        }

        public String getTipo(){
                return tipo;
        }
}
