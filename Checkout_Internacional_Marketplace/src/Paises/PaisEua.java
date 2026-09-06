package Paises;

import java.util.ArrayList;
import java.util.List;

import Enums.EstadoDestinoEua;
import Utils.Zip4Eua;

public class PaisEua extends PaisesCheckout {
    private EstadoDestinoEua tipoEstadoDestino;
    private Zip4Eua zip4Eua;

    private String nomePais = "Eua";
    private boolean possuiIdentificadorEin;
    private boolean possuiVerificacaoAVS;
    private boolean possuiPagamentoCredito;
    private double valor;


    public PaisEua(
            EstadoDestinoEua tipoEstadoDestino,
            Zip4Eua zip4Eua,
            boolean possuiIdentificadorEin,
            boolean possuiVerificacaoAVS,
            boolean possuiPagamentoCredito,
            double valor) {

        this.tipoEstadoDestino = tipoEstadoDestino;
        this.zip4Eua = zip4Eua;
        this.possuiIdentificadorEin = possuiIdentificadorEin;
        this.possuiVerificacaoAVS = possuiVerificacaoAVS;
        this.possuiPagamentoCredito = possuiPagamentoCredito;
        this.valor = valor;
    }

    @Override
    public String documentoFiscal(double valor){
        if (!possuiIdentificadorEin){
            return "Não é possível emitir Sales Invoice sem o EIN do vendedor."; 
        }

        if (tipoEstadoDestino == null){
            return "Não é possível emitir Sales Invoice: Estado de destino não cadastrado no sistema.";
        }

        double valorBase = (valor > 0) ? valor : this.valor;

        double taxa = tipoEstadoDestino.getSalesTax();

        if (taxa == 0){
            return String.format(
                "Sales Invoice | Estado: %s | Sales Tax: Isento | Total: $%.2f",
                tipoEstadoDestino.getEstado(),
                valorBase
            );
        }

        double valorTax = valorBase * taxa;
        double valorTotal = valorBase + valorTax;

        return String.format(
            "Sales Invoice | Estado: %s | Sales Tax (%.2f%%): $%.2f | Total: $%.2f",
            tipoEstadoDestino.getEstado(),
            taxa * 100,
            valorTax,
            valorTotal
        );
    }

    @Override
    public String processarPagamento(){
        List<String> erros = new ArrayList<>();
        
        if(!possuiVerificacaoAVS){
            erros.add("Não possui verificação AVS.");
        }

        if (!possuiPagamentoCredito){
            erros.add("Pagamento é processado apenas por cartão de crédito");
        }

        if (!erros.isEmpty()) {
            throw new IllegalArgumentException("Erro de Pagamento: " + String.join("; ", erros) + ".");
        }

        return "Pagamento processado com sucesso!";
    }

    @Override
    public String etiquetaEnvio(){
        if (zip4Eua == null) {
            return "Não é possível gerar etiqueta de envio: ZIP+4 não informado.";
        }

        return String.format("%s - %s", this.nomePais, zip4Eua.getNumZip());
    }
}
