package entity;

public class Gerente extends FuncionarioCLT {
    private String departamento;
    private int quantidadeDeSubordinados;
    private boolean salaPropria;

    //Construtor vazio 
    public Gerente() {
    }

    //Construtor
    public Gerente(String departamento, int quantidadeDeSubordinados, boolean salaPropria) {
        this.departamento = departamento;
        this.quantidadeDeSubordinados = quantidadeDeSubordinados;
        this.salaPropria = salaPropria;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getQuantidadeDeSubordinados() {
        return quantidadeDeSubordinados;
    }

    public void setQuantidadeDeSubordinados(int quantidadeDeSubordinados) {
        this.quantidadeDeSubordinados = quantidadeDeSubordinados;
    }

    public boolean isSalaPropria() {
        return salaPropria;
    }

    public void setSalaPropria(boolean salaPropria) {
        this.salaPropria = salaPropria;
    }

    

    

    

}
