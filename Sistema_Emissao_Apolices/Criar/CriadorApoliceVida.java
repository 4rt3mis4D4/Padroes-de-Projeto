package Criar;

import Apolices.Produto;
import Apolices.ApoliceVida;

public class CriadorApoliceVida extends CriadorApolices {

    private String segurado;
    private int idade;
    private double capitalSegurado;
    private boolean fumante;
    private boolean possuiIdentidade;
    private boolean possuiCPF;
    private boolean possuiAtestadoMedico;

    public CriadorApoliceVida(String segurado,
                              int idade,
                              double capitalSegurado,
                              boolean fumante,
                              boolean possuiIdentidade,
                              boolean possuiCPF,
                              boolean possuiAtestadoMedico){
        this.segurado = segurado;
        this.idade = idade;
        this.capitalSegurado = capitalSegurado;
        this.fumante = fumante;
        this.possuiIdentidade = possuiIdentidade;
        this.possuiCPF = possuiCPF;
        this.possuiAtestadoMedico = possuiAtestadoMedico;
    }

    @Override
    public Produto fabricar(){
        return new ApoliceVida(segurado, idade, capitalSegurado, fumante, possuiIdentidade, possuiCPF, possuiAtestadoMedico);
    }
}
