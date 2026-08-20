// A partir das classes do exemplo acima, implemente a classe diretor,
// cuja bonificação é (1,5% do salário) multiplicado pelo número de
// funcionários sob sua gestão
public class diretor extends funcionario {
    public double getBonificacao(int numFunc){
        return (this.salario * 0.015) * numFunc;
    }
}
