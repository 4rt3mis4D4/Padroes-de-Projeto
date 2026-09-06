package Utils;

public class Zip4Eua {
    private final String numZip;

    public Zip4Eua(String numZip) {
        if (numZip == null || !numZip.trim().matches("\\d{5}-\\d{4}")) {
            throw new IllegalArgumentException("ZIP+4 inválido! O formato correto é 00000-0000.");
        }
        this.numZip = numZip.trim();
    }

    public String getNumZip() {
        return numZip;
    }

    public String obterApenasNumeros() {
        return numZip.replace("-", "");
    }
}
