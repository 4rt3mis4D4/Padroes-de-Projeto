package Utils;

public class PlzAlemanha {
    private final String numPlz;

    public PlzAlemanha(String numPlz) {
        if (numPlz == null || !numPlz.trim().matches("\\d{5}")) {
            throw new IllegalArgumentException("PLZ inválido! O formato correto na Alemanha deve conter exatamente 5 dígitos numéricos (00000).");
        }
        this.numPlz = numPlz.trim();
    }

    public String getNumPlz() {
        return numPlz;
    }

    public String obterApenasNumeros() {
        return numPlz;
    }
}
