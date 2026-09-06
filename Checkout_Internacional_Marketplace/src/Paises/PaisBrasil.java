package Paises;

import Enums.*;
import Utils.CepBrasil;

public class PaisBrasil extends PaisesCheckout {
    private OperacoesBrasil tipoOperacoes;
    private TributacaoBrasil tipoTributo;
    private TipoPagamentoBrasil tipoPagamento;
    private CepBrasil cep;

    private String nomePais = "Brasil";
    private char[] chaveAcesso = new char[44];
    private double valor;

    public PaisBrasil(
            OperacoesBrasil tipoOperacoes,
            TributacaoBrasil tipoTributo,
            TipoPagamentoBrasil tipoPagamento,
            CepBrasil cep,
            char[] chaveAcesso,
            double valor)
    {
        this.tipoOperacoes = tipoOperacoes;
        this.tipoTributo = tipoTributo;
        this.tipoPagamento = tipoPagamento;
        this.cep = cep;
        this.chaveAcesso = chaveAcesso;
        this.valor = valor;
    }

    @Override
    public String documentoFiscal(double valor){
        if (tipoOperacoes == null){
            return "Não é possível emitir documento fiscal sem o tipo de operação configurado.";
        }

        double valorBase = (valor > 0) ? valor : this.valor;

        double valorIcms = valorBase * (1 + tipoOperacoes.getIcms());

        String chave = new String(this.chaveAcesso);

        if (tipoTributo == TributacaoBrasil.CFOP){
            return String.format(
                "NFe Emitida (CFOP %s) || Valor TotaL: r$ %.2f | Chave: %s",
                tipoOperacoes.getCfop(),
                valorIcms,
                chave
            );
        }

        if (tipoTributo == TributacaoBrasil.ICMS) {
            return String.format(
                "NFe Emitida (ICMS %.0f%%) || Valor TotaL: r$ %.2f | Chave: %s",
                tipoOperacoes.getIcms() * 100,
                valorIcms,
                chave
            );
        }

        return "Erro ao emitir documento fiscal: Tipo de operação não configurado no sistema.";
    }

    @Override
    public String processarPagamento(){

        if (tipoPagamento == null){
            return "Tipo de pagamento não cadastrado no sistema";
        }

        if (tipoPagamento == TipoPagamentoBrasil.PIX){
            double valorDesconto = this.valor * (1 - tipoPagamento.getDesconto());

            return String.format(
                "Pagamento via %s realizado com sucesso! Valor final (%.0f%% de desconto): R$ %.2f",
                tipoPagamento.getTipo(),
                tipoPagamento.getDesconto() * 100,
                valorDesconto
            );
        }

        if (tipoPagamento == TipoPagamentoBrasil.BOLETO){
            return "Compensação em 3 dias úteis.";
        }

        return "Tipo de Pagamento não cadastrado no sistema.";
    }

    @Override
    public String etiquetaEnvio(){
        if (cep == null) {
            return "Não é possível gerar etiqueta de envio: CEP não informado.";
        }

        return String.format("%s - CEP: %s", this.nomePais, cep.getNumCep());
    }
}
