package Criar;

import Apolices.Produto;
import Apolices.ApoliceAuto;

public class CriadorApoliceAuto extends CriadorApolices {
    private String segurado;
    private double valorFIPE;
    private int idade;
    private int tempoHabilitacaoAnos;
    private double coberturaContratada;
    private boolean possuiCNH;
    private boolean possuiCRLV;
    private boolean possuiComprovanteResidencia;

    public CriadorApoliceAuto(
            String segurado,
            double valorFIPE,
            int idade,
            int tempoHabilitacaoAnos,
            double coberturaContratada,
            boolean possuiCNH,
            boolean possuiCRLV,
            boolean possuiComprovanteResidencia
    ){
        this.segurado = segurado;
        this.valorFIPE = valorFIPE;
        this.idade = idade;
        this.tempoHabilitacaoAnos = tempoHabilitacaoAnos;
        this.coberturaContratada = coberturaContratada;
        this.possuiCNH = possuiCNH;
        this.possuiCRLV = possuiCRLV;
        this.possuiComprovanteResidencia = possuiComprovanteResidencia;
    }

    @Override
    public Produto fabricar(){
        return new ApoliceAuto(segurado, valorFIPE, idade, tempoHabilitacaoAnos, coberturaContratada, possuiCNH, possuiCRLV, possuiComprovanteResidencia);
    }
}
