package Apolices;

import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public abstract class Produto{
    private String numero; // (AUTO-, RES-, VID-, VIA-).
    private String segurado;
    private LocalDate dataEmissao;
    private double premioCalculado;

    public Produto(String prefixo, String segurado){
        this.numero = prefixo + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.dataEmissao = LocalDate.now();
        this.segurado = segurado;
    }

    public abstract double calcPremio();

    public abstract void validCobertura();

    public abstract List<String> listDocuments();

    public void gerarResumo(){
        System.out.println("Apólice: " + this.numero);
        System.out.println("Segurado: " + this.segurado);
        System.out.println("Data de Emissão: " + this.dataEmissao);
        System.out.printf("Prêmio Mensal Calculado: R$ %.2f\n", this.premioCalculado);
        System.out.println("Documentos Exigidos: " + listDocuments());
    }
}
