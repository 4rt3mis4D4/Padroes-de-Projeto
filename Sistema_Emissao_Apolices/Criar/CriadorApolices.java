package Criar;

import  Apolices.Produto;

public abstract class CriadorApolices {
    public abstract Produto fabricar();

    public void processarContratacao(){
        Produto produto = fabricar();
        produto.validCobertura();
        produto.gerarResumo();
    }
}
