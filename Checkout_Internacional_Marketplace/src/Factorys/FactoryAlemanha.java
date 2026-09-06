package Factorys;

import Enums.ImpostoAlemanha;
import Paises.PaisAlemanha;
import Paises.PaisesCheckout;
import Utils.PlzAlemanha;

public class FactoryAlemanha implements FactoryCheckout {

    private ImpostoAlemanha tipoImposto;
    private PlzAlemanha plzAlemanha;
    private boolean possuiVatId;
    private boolean possuiSepaDirectDebit;
    private double valor;

    public FactoryAlemanha(
            ImpostoAlemanha tipoImposto,
            PlzAlemanha plzAlemanha,
            boolean possuiVatId,
            boolean possuiSepaDirectDebit,
            double valor)
    {
        this.tipoImposto = tipoImposto;
        this.plzAlemanha = plzAlemanha;
        this.possuiVatId = possuiVatId;
        this.possuiSepaDirectDebit = possuiSepaDirectDebit;
        this.valor = valor;
    }

    @Override
    public PaisesCheckout criarPais() {
        return new PaisAlemanha(tipoImposto, plzAlemanha, possuiVatId, possuiSepaDirectDebit, valor);
    }
}
