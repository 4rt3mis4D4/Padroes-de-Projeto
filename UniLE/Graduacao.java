public class Graduacao extends Disciplina {
    public double nota;

    @Override
    public void getDefinirResultado() {
        if (this.nota >= 7.0) {
            System.out.println("Aluno Aprovado!");
        } else {
            System.out.println("Aluno Reprovado.");
        }
    }
}