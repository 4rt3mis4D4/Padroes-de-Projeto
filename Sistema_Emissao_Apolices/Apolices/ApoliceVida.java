package Apolices;

import java.util.ArrayList;
import java.util.List;

/*
* o prêmio mensal é calculado por (idade do segurado × 12) + (capital
segurado × 0,002).
* Segurados fumantes recebem acréscimo de 50% sobre o prêmio.

* Contratações com capital segurado acima de R$ 500.000,00 exigem atestado médico;
* sem esse documento, a contratação deve ser rejeitada.

* Documentos exigidos: documento de identidade, CPF e, quando aplicável, atestado médico.
*/
public class ApoliceVida extends Produto {
    private static final String PREFIXO = "VID-";
    private static final double ACRESCIMO_FUMANTE = 0.50;
    private static final double CAPITAL_LIMITE = 500000.00;

    private int idade;
    private double capitalSegurado;
    private boolean fumante;
    private boolean possuiIdentidade;
    private boolean possuiCPF;
    private boolean possuiAtestadoMedico;

    public ApoliceVida(
            String segurado,
            int idade,
            double capitalSegurado,
            boolean fumante,
            boolean possuiIdentidade,
            boolean possuiCPF,
            boolean possuiAtestadoMedico
    ){
        super(PREFIXO, segurado);
        this.idade = idade;
        this.capitalSegurado = capitalSegurado;
        this.fumante = fumante;
        this.possuiIdentidade = possuiIdentidade;
        this.possuiCPF = possuiCPF;
        this.possuiAtestadoMedico = possuiAtestadoMedico;
    }

    @Override
    public double calcPremio(){
        double premio = (idade * 12) + (capitalSegurado * 0.002);
        if (fumante) {
            premio *= (1 + ACRESCIMO_FUMANTE);
        }
        return premio;
    }

    @Override
    public void validCobertura(){
        List<String> erros = new ArrayList<>();

        if (!possuiIdentidade){
            erros.add("identidade não apresentada.");
        }
        if (!possuiCPF){
            erros.add("CPF não apresentado.");
        }
        if (capitalSegurado > CAPITAL_LIMITE && !possuiAtestadoMedico){
            erros.add("capital segurado R$ " + capitalSegurado +
                    " supera R$ " + CAPITAL_LIMITE + " e atestado médico não foi apresentado.");
        }
        if (!erros.isEmpty()) {
            throw new IllegalArgumentException("Apólice VID rejeitada: " + String.join("; ", erros) + ".");
        }
    }

    @Override
    public List<String> listDocuments(){
        List<String> docs = new ArrayList<>(List.of("Documento de identidade", "CPF"));

        if(capitalSegurado > CAPITAL_LIMITE){
            docs.add("Atestado médico");
        }
        return docs;
    }
}
