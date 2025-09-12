package entity;

public class FuncionarioCLT extends Funcionario {
    private Double ValeTransporte;
    private Double ValeAlimentacao;
    private Boolean PlanoDeSaude;
   
    //Construtor vazio
    public FuncionarioCLT() {}

    //Constutor
    

    //Métodos getters e setters
    public Double getValeTransporte() {
        return ValeTransporte;
    }
    public void setValeTransporte(Double valeTransporte) {
        ValeTransporte = valeTransporte;
    }
    public Double getValeAlimentacao() {
        return ValeAlimentacao;
    }
    public void setValeAlimentacao(Double valeAlimentacao) {
        ValeAlimentacao = valeAlimentacao;
    }
    public Boolean getPlanoDeSaude() {
        return PlanoDeSaude;
    }
    public void setPlanoDeSaude(Boolean planoDeSaude) {
        PlanoDeSaude = planoDeSaude;
    }

}
