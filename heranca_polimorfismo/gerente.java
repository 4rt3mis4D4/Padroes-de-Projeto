// Classe Especializada
public class gerente extends funcionario {
    private int senha;
    private int numeroDeFuncionariosGerenciados;

    public void AutorizarCompra(){
        System.out.println("Procedimento de autorização de compra");
    }

//    @Override // Sobrescreve a lógica de um método herdado
//    public double getBonificacao(){
//        return this.salario * 0.2;
//    }

    public double getBonificacao(double adicional){
        return super.getBonificacao() + adicional;
    }
}
