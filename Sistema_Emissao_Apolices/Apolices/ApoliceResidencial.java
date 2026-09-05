package Apolices;

/*
    * o prêmio mensal corresponde a 1,5% do valor do imóvel ao ano,
    dividido por 12.
    * Imóveis classificados como alto padrão recebem acréscimo de 25% sobre o
    prêmio anual.
    * A contratação exige a apresentação de escritura ou contrato de locação; sem
    esse documento, a contratação deve ser rejeitada.
    * Documentos exigidos: escritura ou contrato
    de locação e comprovante de residência.
*/

import java.util.ArrayList;
import java.util.List;

public class ApoliceResidencial extends Produto {
    private static final String PREFIXO = "RES-";
    private static final double TAXA_MENSAL = 0.015;
    private static final double ACRESCIMO_ALTO_PADRAO = 0.25;

    private double valorImovel;
    private boolean imovelAltoPadrao;
    private boolean possuiEscrituraOuLocacao;
    private boolean possuiComprovanteResidencia;

    public ApoliceResidencial(
            String segurado,
            double valorImovel,
            boolean imovelAltoPadrao,
            boolean possuiEscrituraOuLocacao,
            boolean possuiComprovanteResidencia
    ){
        super(PREFIXO, segurado);
        this.valorImovel = valorImovel;
        this.imovelAltoPadrao = imovelAltoPadrao;
        this.possuiEscrituraOuLocacao = possuiEscrituraOuLocacao;
        this.possuiComprovanteResidencia = possuiComprovanteResidencia;
    }

    @Override
    public double calcPremio(){
        double premioMensal = valorImovel * TAXA_MENSAL;

        if(imovelAltoPadrao){
            premioMensal *= (1 + ACRESCIMO_ALTO_PADRAO);
        }
        return premioMensal / 12;
    }

    @Override
    public void validCobertura(){
        List<String> erros = new ArrayList<>();

        if(!possuiEscrituraOuLocacao){
            erros.add("escritura ou contrato de locação não apresentado.");
        }
        if(!possuiComprovanteResidencia){
            erros.add("comprovante de residência não apresentado.");
        }
        if (!erros.isEmpty()) {
            throw new IllegalArgumentException("Apólice RES rejeitada: " + String.join("; ", erros) + ".");
        }
    }

    @Override
    public List<String> listDocuments(){
        return List.of("Escritura ou Contato de Locação", "Comprovante de Residência");
    }
}
