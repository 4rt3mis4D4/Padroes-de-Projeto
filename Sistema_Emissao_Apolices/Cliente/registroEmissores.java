package Cliente;

import Criar.CriadorApolices;
import java.util.ArrayList;
import java.util.List;

public class registroEmissores {
    public interface FabricaEmissor {
        CriadorApolices fabricar();
    }

    private static class Registro {
        String tipo;
        FabricaEmissor fabrica;

        Registro(String tipo, FabricaEmissor fabrica){
            this.tipo = tipo;
            this.fabrica = fabrica;
        }
    }

    private final List<Registro> registros = new ArrayList<>();

    public void registrar(String tipo, FabricaEmissor fabrica){
        String tipoFormatado = tipo.toUpperCase();

        for (Registro r : registros){
            if(r.tipo.equals(tipoFormatado)){
                r.fabrica = fabrica;
                return;
            }
        }

        registros.add(new Registro(tipoFormatado, fabrica));
    }

    public CriadorApolices obter(String tipo){
        String tipoFormatado = tipo.toUpperCase();

        for(Registro r : registros){
            if (r.tipo.equals(tipoFormatado)){
                return r.fabrica.fabricar();
            }
        }

        throw new IllegalArgumentException("Tipo de apólice desconhecido: '" + tipo + "'.");
    }
}
