package Apolices;

/*
        O prêmio mensal corresponde a 8% do valor de tabela FIPE do veículo, dividido por 12.
        Se o condutor tiver menos de 25 anos, aplica-se um acréscimo de 30% sobre o prêmio anual;
        se o tempo de habilitação for inferior a 2 anos, aplica-se um acréscimo adicional de 20%.
        A apólice exige cobertura contratada contra terceiros de, no mínimo, R$ 50.000,00;
        caso contrário, a contratação deve ser rejeitada. Documentos exigidos: CNH, CRLV e comprovante de residência.
 */

import java.util.ArrayList;
import java.util.List;

public class ApoliceAuto extends Produto {

    private static final String PREFIXO = "AUTO-";
    private static final double TAXA_MENSAL = 0.08;
    private static final double ACRESCIMO_ABORRECENTE = 0.30;
    private static final double ACRESCIMO_HABILITACAO = 0.20;
    private static final double COBERTURA_MINIMA = 50000.00;

    private double valorFIPE;
    private int idade;
    private int tempoHabilitacaoAnos;
    private double coberturaContratada;
    private boolean possuiCNH;
    private boolean possuiCRLV;
    private boolean possuiComprovanteResidencia;

    public ApoliceAuto(
            String segurado,
            double valorFIPE,
            int idade,
            int tempoHabilitacaoAnos,
            double coberturaContratada,
            boolean possuiCNH,
            boolean possuiCRLV,
            boolean possuiComprovanteResidencia
    ){
        super(PREFIXO, segurado);
        this.valorFIPE = valorFIPE;
        this.idade = idade;
        this.tempoHabilitacaoAnos = tempoHabilitacaoAnos;
        this.coberturaContratada = coberturaContratada;
        this.possuiCNH = possuiCNH;
        this.possuiCRLV = possuiCRLV;
        this.possuiComprovanteResidencia = possuiComprovanteResidencia;
    }

    @Override
    public double calcPremio(){
        double premioMensal = valorFIPE * TAXA_MENSAL;
        if (idade < 25){
            premioMensal *= (1 + ACRESCIMO_ABORRECENTE);
        }
        if (tempoHabilitacaoAnos < 2){
            premioMensal *= (1 + ACRESCIMO_HABILITACAO);
        }
        return premioMensal / 12;
    }

    @Override
    public void validCobertura(){
        List<String> erros = new ArrayList<>();

        if (coberturaContratada < COBERTURA_MINIMA){
            erros.add("cobertura contra terceiros R$ "
                    + coberturaContratada + " abaixo do mínimo exigido de R$ " + COBERTURA_MINIMA);
        }

        if(!possuiCNH){
            erros.add("CNH não apresentada.");
        }

        if(!possuiCRLV){
            erros.add("CRLV não apresentada.");
        }

        if(!possuiComprovanteResidencia){
            erros.add("Comprovante de residência não apresentado.");
        }
        if (!erros.isEmpty()) {
            throw new IllegalArgumentException("Apólice Auto rejeitada: " + String.join("; ", erros) + ".");
        }
    }

    @Override
    public List<String> listDocuments(){
        return List.of("CNH", "CRLV", "Comprovante de Residência");
    }
}