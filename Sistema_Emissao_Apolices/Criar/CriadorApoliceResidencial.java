package Criar;

import Apolices.Produto;
import Apolices.ApoliceResidencial;

public class CriadorApoliceResidencial extends CriadorApolices {
    private String segurado;
    private double valorImovel;
    private boolean imovelAltoPadrao;
    private boolean possuiEscrituraOuLocacao;
    private boolean possuiComprovanteResidencia;

    public CriadorApoliceResidencial(
            String segurado,
            double valorImovel,
            boolean imovelAltoPadrao,
            boolean possuiEscrituraOuLocacao,
            boolean possuiComprovanteResidencia
    ){
        this.segurado = segurado;
        this.valorImovel = valorImovel;
        this.imovelAltoPadrao = imovelAltoPadrao;
        this.possuiEscrituraOuLocacao = possuiEscrituraOuLocacao;
        this.possuiComprovanteResidencia = possuiComprovanteResidencia;
    }

    @Override
    public Produto fabricar(){
        return new ApoliceResidencial(segurado, valorImovel, imovelAltoPadrao, possuiEscrituraOuLocacao, possuiComprovanteResidencia);
    }
}
