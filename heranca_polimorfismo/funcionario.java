// Classe Base
public class funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;
    protected String senha;

    public double getBonificacao(){
        return this.salario * 0.15;
    }

    public boolean autentica(String senha){
        if (this.senha == senha){
            System.out.println("Acesso Permitido!");
            return true;
        } else {
            System.out.println("Acesso Negado!");
            return false;
        }
    }
}
