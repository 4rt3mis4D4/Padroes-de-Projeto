package Utils;

public class CepBrasil {
    private final String numCep;

    public CepBrasil(String numCep) {
        if (numCep == null || !numCep.trim().matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("CEP inválido! O formato correto é 00000-000.");
        }
        this.numCep = numCep.trim();
    }

    public String getNumCep() {
        return numCep;
    }

    public String obterApenasNumeros() {
        return numCep.replace("-", "");
    }
}
