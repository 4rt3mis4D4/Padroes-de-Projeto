public class Especializacao extends Disciplina{
    public char conceito;

    @Override
    public void getDefinirResultado(){
        if (this.conceito == 'D'){
            System.out.println("Aluno Reprovado.");
        } else {
            System.out.println("Aluno Aprovado!");
        }
    }
}
