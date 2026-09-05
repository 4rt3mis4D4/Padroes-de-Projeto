package Cliente;

import Criar.*;

public class Main {
    public static void main(String[] args) {
        // -- Inicializações
        registroEmissores registro = new registroEmissores();
        SistemaContratacao sistema = new SistemaContratacao(registro);

        // -- Testes que em teori deveriam dar certo kkkk (Amém)
        registro.registrar("AUTO_1.0", () -> new CriadorApoliceAuto(
                "João Silva", 60000.0, 24, 1, 100000.0, true, true, true));

        registro.registrar("RESIDENCIAL_2.0", () -> new CriadorApoliceResidencial(
                "Maria Souza", 500000.0, true, true, true));

        registro.registrar("VIDA_3.0", () -> new CriadorApoliceVida(
                "Carlos Lima", 45, 600000.0, false, true, true, true));

        registro.registrar("VIAGEM_4.0", () -> new CriadorApoliceViagem(
                "Ana Costa", 15, true, 50000.0, true, true));


        // -- Testando casos de falha
        registro.registrar("AUTO_1.1", () -> new CriadorApoliceAuto(
                "Pedro Santos", 40000.0, 30, 10, 40000.0, true, false, true));

        registro.registrar("RESIDENCIAL_2.1", () -> new CriadorApoliceResidencial(
                "Lucas Alves", 300000.0, false, false, true));

        registro.registrar("VIDA_3.1", () -> new CriadorApoliceVida(
                "Julia Dias", 50, 800000.0, true, true, true, false));

        registro.registrar("VIAGEM_4.1", () -> new CriadorApoliceViagem(
                "Marcos Reis", 10, true, 20000.0, false, true));


        // -- Executando método contratar
        System.out.println("\n=== PROCESSAR CONTRATAÇÃO && VALIDAR COBERTURA ===\n");
        String[] apolices = {"AUTO_1.0", "RESIDENCIAL_2.0", "VIDA_3.0", "VIAGEM_4.0",
                            "AUTO_1.1", "RESIDENCIAL_2.1", "VIDA_3.1", "VIAGEM_4.1"};

        for (String apolice : apolices) {
            try {
                String resultado = sistema.contratar(apolice);
                System.out.println(resultado + "\n");
            } catch (Exception e) {
                System.err.println("Erro inesperado no caso " + apolice + ": " + e.getMessage());
            }
        }
    }
}
