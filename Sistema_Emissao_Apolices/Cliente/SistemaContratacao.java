package Cliente;

import Criar.CriadorApolices;

public class SistemaContratacao {
    private registroEmissores registro;

    public SistemaContratacao(registroEmissores registro){

        this.registro = registro;
    }

    public String contratar(String tipo){
        CriadorApolices criador = registro.obter(tipo);
        criador.processarContratacao();

        return "Contratação do tipo " + tipo + " processada com sucesso.";
    }
}
