package Factorys;

import Enums.EstadoDestinoEua;
import Paises.PaisEua;
import Paises.PaisesCheckout;
import Utils.Zip4Eua;

public class FactoryEua implements FactoryCheckout {

    private EstadoDestinoEua tipoEstadoDestino;
    private Zip4Eua zip4Eua;
    private boolean possuiIdentificadorEin;
    private boolean possuiVerificacaoAVS;
    private boolean possuiPagamentoCredito;
    private double valor;

    public FactoryEua(
            EstadoDestinoEua tipoEstadoDestino,
            Zip4Eua zip4Eua,
            boolean possuiIdentificadorEin,
            boolean possuiVerificacaoAVS,
            boolean possuiPagamentoCredito,
            double  valor) 
    {
        this.tipoEstadoDestino = tipoEstadoDestino;
        this.zip4Eua = zip4Eua;
        this.possuiIdentificadorEin = possuiIdentificadorEin;
        this.possuiVerificacaoAVS = possuiVerificacaoAVS;
        this.possuiPagamentoCredito = possuiPagamentoCredito;
        this.valor = valor;
    }

    @Override
    public PaisesCheckout criarPais() {
        return new PaisEua(
            tipoEstadoDestino, zip4Eua,
            possuiIdentificadorEin, possuiVerificacaoAVS, possuiPagamentoCredito,
            valor
        );
    }
}
