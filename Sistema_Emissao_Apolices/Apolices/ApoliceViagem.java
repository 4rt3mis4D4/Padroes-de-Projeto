package Apolices;

/*
    * o prêmio é calculado por (dias de viagem × R$ 15,00), acrescido de R$
    100,00 quando o destino for internacional.
    * Viagens internacionais exigem cobertura de
    assistência médica contratada de, no mínimo, US$ 30.000,00 e apresentação de passaporte;
    * a ausência de qualquer um dos dois deve rejeitar a contratação.
    * Documentos exigidos: itinerário de viagem e, quando aplicável, passaporte.
*/

import java.util.ArrayList;
import java.util.List;

public class ApoliceViagem extends Produto{
    private static final String PREFIXO = "VIA";
    private static final double DIARIA = 15.00;
    private static final double ACRESCIMO_INTERNACIONAL = 100.00;
    private static final double COBERTURA_MEDICA_MINIMA = 30000.00;

    private int diasViagem;
    private boolean internacional;
    private double coberturaAssistenciaMedica;
    private boolean possuiPassaporte;
    private boolean possuiIntinerario;

    public ApoliceViagem(
            String segurado,
            int diasViagem,
            boolean internacional,
            double coberturaAssistenciaMedica,
            boolean possuiPassaporte,
            boolean possuiIntinerario
    ){
        super(PREFIXO, segurado);
        this.diasViagem = diasViagem;
        this.internacional = internacional;
        this.coberturaAssistenciaMedica = coberturaAssistenciaMedica;
        this.possuiPassaporte = possuiPassaporte;
        this.possuiIntinerario = possuiIntinerario;
    }

    @Override
    public double calcPremio(){
       double premio = diasViagem * DIARIA;
       if(internacional){
           premio += ACRESCIMO_INTERNACIONAL;
       }
       return premio;
    }

    @Override
    public void validCobertura(){
        List<String> erros = new ArrayList<>();

        if(!possuiIntinerario){
            erros.add("itinerário de viagem não apresentado.");
        }
        if (internacional){
            if (coberturaAssistenciaMedica < COBERTURA_MEDICA_MINIMA){
                erros.add("cobertura de assistência médica (" + coberturaAssistenciaMedica +
                        ") abaixo do mínimo exigido de US$ " + COBERTURA_MEDICA_MINIMA + " para destino internacional.");
            }
            if (!possuiPassaporte){
                erros.add("passaporte não apresentado para destino internacional.");
            }
        }
        if (!erros.isEmpty()) {
            throw new IllegalArgumentException("Apólice VIA rejeitada: " + String.join("; ", erros) + ".");
        }
    }

    @Override
    public List<String> listDocuments(){
        List<String> docs = new ArrayList<>(List.of("Itinerário de viagem"));
        if (internacional) {
            docs.add("Passaporte");
        }
        return docs;
    }
}
