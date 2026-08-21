public class Main {
    public static void main(String[] args){
        Aluno alunoOne = new Aluno("Roberto", 6.5, 'D');
        Aluno alunoTwo = new Aluno("Claudia", 7.5, 'A');

        Graduacao graduacao = new Graduacao();
        graduacao.nota = alunoOne.nota;
        Especializacao especializacao = new Especializacao();
        especializacao.conceito = alunoTwo.conceito;


        System.out.println("Aluno: " + alunoOne.nome);
        System.out.println("Nota: " + alunoOne.nota);
        graduacao.getDefinirResultado();

        System.out.println();

        System.out.println("Aluno: " + alunoTwo.nome);
        System.out.println("Conceito: " + alunoTwo.conceito);
        especializacao.getDefinirResultado();
    }
}
