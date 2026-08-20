public class teste_heranca {
    public static void main(String[] args){
        // === GERENTE ===
        gerente Gerente = new gerente();

        Gerente.nome = "Pedro de Lara";
        Gerente.cpf = "888";
        System.out.println(Gerente.nome);

        // Invocar métodos da classe base
        Gerente.salario = 10000;
        //System.out.println(Gerente.getBonificacao());
        System.out.println(Gerente.getBonificacao(1000));

        double gerenteSalario = Gerente.salario + Gerente.getBonificacao(1000);
        System.out.println("Salario Final Gerente: " + gerenteSalario);
        System.out.println();

        // === DIRETOR ===
        diretor Diretor = new diretor();

        Diretor.nome = "Sebastian Roberto";
        Diretor.cpf = "999";
        System.out.println(Diretor.nome);

        Diretor.salario = 25000;
        System.out.println(Diretor.getBonificacao(5));

        double diretorSalario = Diretor.salario + Diretor.getBonificacao(5);
        System.out.println("Salário Final Diretor: " + diretorSalario);
    }
}
