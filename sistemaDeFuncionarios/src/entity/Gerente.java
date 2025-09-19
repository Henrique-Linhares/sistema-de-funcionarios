package entity;

public class Gerente extends FuncionarioCLT {
    private String departamento;
    private int quantidadeDeSubordinados;
    private boolean salaPropria;

    //Construtor vazio 
    public Gerente() {
    }

    //Construtor
    public Gerente(String nome, int feriasDias, Boolean ferias, String genero, Double salarioBase, String cpf, String registro, 
    Double valeTransporte, Double valeAlimentacao, Boolean planoDeSaude, String departamento, int quantidadeDeSubordinados, boolean salaPropria) {
        super(nome, feriasDias, ferias, genero, salarioBase, cpf, registro, valeTransporte, valeAlimentacao, planoDeSaude);
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

    //Métodos
    public double calcularSalarioLiquido() {
        double salario = getSalarioBase();
        double bonus = salario * 0.15;
        double descontos = salario * 0.15; // INSS + IRRF
        return salario + bonus - descontos;
    }

    @Override
    public String toString() {
        return "Gerente [departamento=" + departamento + ", quantidadeDeSubordinados=" + quantidadeDeSubordinados
                + ", salaPropria=" + salaPropria + "]";
    }

}
    

    
    


