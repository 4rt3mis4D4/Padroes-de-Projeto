package Criar;

import Apolices.Produto;
import Apolices.ApoliceViagem;

public class CriadorApoliceViagem extends CriadorApolices {
    private String segurado;
    private int diasViagem;
    private boolean internacional;
    private double coberturaAssistenciaMedica;
    private boolean possuiPassaporte;
    private boolean possuiIntinerario;

    public CriadorApoliceViagem(String segurado,
                                int diasViagem,
                                boolean internacional,
                                double coberturaAssistenciaMedica,
                                boolean possuiPassaporte,
                                boolean possuiIntinerario) {
        this.segurado = segurado;
        this.diasViagem = diasViagem;
        this.internacional = internacional;
        this.coberturaAssistenciaMedica = coberturaAssistenciaMedica;
        this.possuiPassaporte = possuiPassaporte;
        this.possuiIntinerario = possuiIntinerario;
    }

    @Override
    public Produto fabricar(){
        return new ApoliceViagem(segurado, diasViagem, internacional,
                coberturaAssistenciaMedica, possuiPassaporte, possuiIntinerario);
    }
}
