import Enums.*;
import Factorys.*;
import Paises.PaisesCheckout;
import Utils.*;

public class Main {

    public static void main(String[] args) {

        char[] chave1 = new char[44];
        char[] chave2 = new char[44];
        for (int i = 0; i < 44; i++) {
            chave1[i] = (char) ('0' + (i % 10));
            chave2[i] = (char) ('0' + ((i + 3) % 10));
        }

        // -- Casos de sucesso
        PaisesCheckout brasil1 = new FactoryBrasil(OperacoesBrasil.INTERESTADUAL, TributacaoBrasil.ICMS,
                TipoPagamentoBrasil.PIX, new CepBrasil("20040-020"), chave1, 500.00).criarPais();
        brasil1.documentoFiscal(500.00);
        brasil1.processarPagamento();
        brasil1.etiquetaEnvio();
        System.out.println(brasil1.gerarCheckout());

        PaisesCheckout brasil2 = new FactoryBrasil(OperacoesBrasil.ESTADUAL, TributacaoBrasil.CFOP,
                TipoPagamentoBrasil.BOLETO, new CepBrasil("01310-100"), chave2, 320.00).criarPais();
        brasil2.documentoFiscal(320.00);
        brasil2.processarPagamento();
        brasil2.etiquetaEnvio();
        System.out.println(brasil2.gerarCheckout());

        PaisesCheckout eua1 = new FactoryEua(EstadoDestinoEua.CALIFORNIA, new Zip4Eua("90210-1234"),
                true, true, true, 199.99).criarPais();
        eua1.documentoFiscal(199.99);
        eua1.processarPagamento();
        eua1.etiquetaEnvio();
        System.out.println(eua1.gerarCheckout());

        PaisesCheckout eua2 = new FactoryEua(EstadoDestinoEua.TEXAS, new Zip4Eua("75201-0000"),
                true, true, true, 350.00).criarPais();
        eua2.documentoFiscal(350.00);
        eua2.processarPagamento();
        eua2.etiquetaEnvio();
        System.out.println(eua2.gerarCheckout());

        PaisesCheckout eua3 = new FactoryEua(EstadoDestinoEua.OREGON, new Zip4Eua("97201-0000"),
                true, true, true, 75.00).criarPais();
        eua3.documentoFiscal(75.00);
        eua3.processarPagamento();
        eua3.etiquetaEnvio();
        System.out.println(eua3.gerarCheckout());

        PaisesCheckout alemanha1 = new FactoryAlemanha(ImpostoAlemanha.UMSATZSTEUER,
                new PlzAlemanha("10115"), true, true, 250.00).criarPais();
        alemanha1.documentoFiscal(250.00);
        alemanha1.processarPagamento();
        alemanha1.etiquetaEnvio();
        System.out.println(alemanha1.gerarCheckout());

        PaisesCheckout alemanha2 = new FactoryAlemanha(ImpostoAlemanha.PRODUTOS_ESSENCIAIS,
                new PlzAlemanha("80331"), true, true, 85.50).criarPais();
        alemanha2.documentoFiscal(85.50);
        alemanha2.processarPagamento();
        alemanha2.etiquetaEnvio();
        System.out.println(alemanha2.gerarCheckout());

        // -- Casos de falha

    //    PaisesCheckout brasilFalha = new FactoryBrasil(operacoesBrasil.INTERESTADUAL, tributacaoBrasil.ICMS,
    //            tipoPagamentoBrasil.BOLETO, null, chave1, 100.00).criarPais();
    //    brasilFalha.documentoFiscal(100.00);
    //    brasilFalha.processarPagamento();
    //    brasilFalha.etiquetaEnvio();
    //    System.out.println(brasilFalha.gerarCheckout());

    //    PaisesCheckout euaFalha1 = new FactoryEua(estadoDestinoEua.CALIFORNIA, new Zip4Eua("90210-1234"),
    //            true, false, false, 199.99).criarPais();
    //    euaFalha1.documentoFiscal(199.99);
    //    euaFalha1.processarPagamento();
    //    euaFalha1.etiquetaEnvio();
    //    System.out.println(euaFalha1.gerarCheckout());

    //    PaisesCheckout euaFalha2 = new FactoryEua(estadoDestinoEua.TEXAS, new Zip4Eua("75201-0000"),
    //            false, true, true, 150.00).criarPais();
    //    euaFalha2.documentoFiscal(150.00);
    //    euaFalha2.processarPagamento();
    //    euaFalha2.etiquetaEnvio();
    //    System.out.println(euaFalha2.gerarCheckout());

    //    PaisesCheckout alemanhaFalha1 = new FactoryAlemanha(impostoAlemanha.UMSATZSTEUER,
    //            new PlzAlemanha("10115"), false, true, 300.00).criarPais();
    //    alemanhaFalha1.documentoFiscal(300.00);
    //    alemanhaFalha1.processarPagamento();
    //    alemanhaFalha1.etiquetaEnvio();
    //    System.out.println(alemanhaFalha1.gerarCheckout());

    //    PaisesCheckout alemanhaFalha2 = new FactoryAlemanha(impostoAlemanha.PRODUTOS_ESSENCIAIS,
    //            new PlzAlemanha("80331"), true, false, 120.00).criarPais();
    //    alemanhaFalha2.documentoFiscal(120.00);
    //    alemanhaFalha2.processarPagamento();
    //    alemanhaFalha2.etiquetaEnvio();
    //    System.out.println(alemanhaFalha2.gerarCheckout());
    }
}
