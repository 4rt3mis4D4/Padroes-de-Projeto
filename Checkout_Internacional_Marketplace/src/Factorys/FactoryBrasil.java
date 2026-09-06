package Factorys;

import Enums.OperacoesBrasil;
import Enums.TipoPagamentoBrasil;
import Enums.TributacaoBrasil;
import Paises.PaisBrasil;
import Paises.PaisesCheckout;
import Utils.CepBrasil;

public class FactoryBrasil implements FactoryCheckout {

    private OperacoesBrasil tipoOperacoes;
    private TributacaoBrasil tipoTributo;
    private TipoPagamentoBrasil tipoPagamento;
    private CepBrasil cep;
    private char[] chaveAcesso;
    private double valor;

    public FactoryBrasil(
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
    public PaisesCheckout criarPais() {
        return new PaisBrasil(tipoOperacoes, tipoTributo, tipoPagamento, cep, chaveAcesso, valor);
    }
}
