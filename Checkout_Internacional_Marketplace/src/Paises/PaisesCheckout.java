package Paises;

public abstract class PaisesCheckout{

    public abstract String documentoFiscal(double valor);

    public abstract String processarPagamento();

    public abstract String etiquetaEnvio();

    public String gerarCheckout(){
        StringBuilder resumo = new StringBuilder();

        resumo.append("=== CHECKOUT INTERNACIONAL ===\n");
        resumo.append("1. Documento Fiscal:\n");
        resumo.append(this.documentoFiscal(0)).append("\n\n");
        resumo.append("2. Processamento do Pagamento:\n");
        resumo.append(this.processarPagamento()).append("\n\n");
        resumo.append("3. Etiqueta de Envio:\n");
        resumo.append(this.etiquetaEnvio()).append("\n\n");

        return resumo.toString();
    }
}
