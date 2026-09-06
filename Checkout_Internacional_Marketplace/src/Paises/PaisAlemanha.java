package Paises;

import Enums.ImpostoAlemanha;
import Utils.PlzAlemanha;

public class PaisAlemanha extends PaisesCheckout{
    private ImpostoAlemanha tipoImposto;
    private PlzAlemanha plzAlemanha;

    private String nomePais = "Alemanha";
    private boolean possuiVatId;
    private boolean possuiSepaDirectDebit;
    private double valor;

    public PaisAlemanha(
            ImpostoAlemanha tipoImposto,
            PlzAlemanha plzAlemanha,
            boolean possuiVatId,
            boolean possuiSepaDirectDebit,
            double valor) {

        this.tipoImposto = tipoImposto;
        this.plzAlemanha = plzAlemanha;
        this.possuiVatId = possuiVatId;
        this.possuiSepaDirectDebit = possuiSepaDirectDebit;
        this.valor = valor;
    }

    @Override
    public String documentoFiscal(double valor){
        if (!possuiVatId){
            return "Não é possível emitir documento fiscal sem VAT-ID do vendedor.";
        }

        if (tipoImposto == null){
            return "Não é possível emitir documento fiscal sem o tipo de imposto definido.";
        }

        double valorBase = (valor > 0) ? valor : this.valor;
        double imposto = tipoImposto.getImposto();

        if (imposto == 0){
            return String.format(
                "Documento Fiscal (Alemanha) | Tipo: %s | Não possui impostos | Total: R$ %.2f",
                tipoImposto.getTipo(),
                valorBase
            );
        }

        double valorImposto = valorBase * imposto;
        double valorTotal = valorBase + valorImposto;

        return String.format(
            "Documento Fiscal (Alemanha) | Tipo: %s | Imposto (%.0f%%): R$ %.2f | Total: R$ %.2f",
            tipoImposto.getTipo(),
            imposto * 100,
            valorImposto,
            valorTotal
        );
    }

    @Override
    public String processarPagamento(){
        if(!possuiSepaDirectDebit){
            return "Processamento de Pagamento Cancelado: procassamento apenas com SEPA DIRECT DEBIT";
        }

        return "Processamento de Pagamento realizado com sucesso!";
    }

    @Override
    public String etiquetaEnvio(){
        if (plzAlemanha == null) {
            return "Não é possível gerar etiqueta de envio: PLZ não informado.";
        }

        return String.format("%s - PLZ: %s", this.nomePais, plzAlemanha.getNumPlz());
    }
}
