package entity;

public class FuncionarioCLT extends Funcionario {

    private Double valeTransporte;
    private Double valeAlimentacao;
    private Boolean planoDeSaude;

    // Construtor vazio
    public FuncionarioCLT() {}

    // Construtor parametrizado (chamando super + atributos da subclasse)
    public FuncionarioCLT(
        String nome, 
        int feriasDias, 
        Boolean ferias, 
        String genero, 
        Double salarioBase, 
        String cpf, 
        String registro, 
        Double valeTransporte, 
        Double valeAlimentacao, 
        Boolean planoDeSaude
    ) {
        super(nome, feriasDias, ferias, genero, salarioBase, cpf, registro);
        this.valeTransporte = valeTransporte;
        this.valeAlimentacao = valeAlimentacao;
        this.planoDeSaude = planoDeSaude;
    }

    // Sobrescrevendo calcularSalarioLiquido
    @Override
    public Double calcularSalarioLiquido(Double salarioBase) {
        Double liquido = super.calcularSalarioLiquido(salarioBase);
        return liquido + this.valeTransporte + this.valeAlimentacao;
    }

    // Sobrescrevendo listarDados (toString)
    @Override
    public String toString() {
        return super.toString() + 
               ", Vale Transporte=" + valeTransporte + 
               ", Vale Alimentação=" + valeAlimentacao + 
               ", Plano de Saúde=" + (planoDeSaude ? "Ativo" : "Inativo");
    }

    // Sobrescrevendo atualizarSalario
    @Override
    public void atualizaSalario(Double valor) {
        setSalarioBase(getSalarioBase() + valor);
        System.out.println("Novo salário CLT: " + getSalarioBase());
    }
 
    // Sobrescrevendo atualizarFerias
    @Override
    public void atualizarFerias(int dias, boolean estado) {
        super.atualizarFerias(dias, estado); // Mantém comportamento do pai
        System.out.println("Registro atualizado no sistema CLT.");
    }

    // Getters e Setters
    public Double getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(Double valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public Double getValeAlimentacao() {
        return valeAlimentacao;
    }

    public void setValeAlimentacao(Double valeAlimentacao) {
        this.valeAlimentacao = valeAlimentacao;
    }

    public Boolean getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(Boolean planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }
}
