public class financeiro {
    private double totalBonus = 0;

    // Acumula as bonificações dos funcionários
    public boolean registraFuncionario(funcionario f){
        try {
            this.totalBonus += f.getBonificacao();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    // Retorna o total de bonificação
    public double calculaBonificacao(){
        return this.totalBonus;
    }
}
