import javax.sound.sampled.Port;

public class teste_polimorf {
    public static void main(String[] args) {
        gerente Gerente = new gerente();
        funcionario Porteiro = new funcionario();

        Gerente.salario = 14000;
        Porteiro.salario = 5000;

        // Mostrar os dados de ambos
        System.out.println("Bonus do gerente:" + Gerente.getBonificacao());
        System.out.println("Bonus do porteiro:" + Porteiro.getBonificacao());

        financeiro Financeiro = new financeiro(); // classe que receberá argumentos polimórficos

        // Registra o porteiro e exibe o total em bonificações
        Financeiro.registraFuncionario(Porteiro);
        System.out.println(Financeiro.calculaBonificacao());

        // Registra o gerente e exbie o total em bonificações
        Financeiro.registraFuncionario(Gerente);
        System.out.println(Financeiro.calculaBonificacao());
    }
}