package entity;

public class Funcionario {
    private String nome;
    private String cpf;
    private Double salarioBase;
    private String registro;
    private String genero;
    private Boolean ferias;
    private int feriasDias;

    //Construtor Vazio
    public Funcionario() {}

    // Construtor Parametrizado
    public Funcionario(String nome, int feriasDias, Boolean ferias, String genero, Double salarioBase, String cpf, String registro) {
        this.nome = nome;
        this.feriasDias = feriasDias;
        this.ferias = ferias;
        this.genero = genero;
        this.salarioBase = salarioBase;
        this.cpf = cpf;
        this.registro = registro;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFeriasDias() {
        return feriasDias;
    }

    public void setFeriasDias(int feriasDias) {
        this.feriasDias = feriasDias;
    }

    public Boolean getFerias() {
        return ferias;
    }

    public void setFerias(Boolean ferias) {
        this.ferias = ferias;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    // Método Listar Dados
    @Override
    public String toString() {
        return "Nome =" + nome + ", CPF =" + cpf + ", salário Base =" + salarioBase + ", registro =" + registro
                + ", gênero =" + genero + ", férias=" + ferias + ", Dias de Férias=" + feriasDias;
    }

    // Método de calcular o salário liquído
    public Double calcularSalarioLiquido(Double salarioBase) {
        return salarioBase;
    }

    // Atualiza o salario 
    public void atualizaSalario(Double valor) {
        setSalarioBase(valor);
        System.out.println("Seu novo salário é de: " + getSalarioBase());
    }

    // Atualiza as Férias do Funcionário
    public void atualizarFerias(int dias, boolean estado) {
        setFeriasDias(dias);
        if(estado == true) {
            System.out.println("O Funcionário está de férias por: " + getFeriasDias());
        } else {
            System.out.println("O Funcionário não está de férias.");
        }
    }

}
