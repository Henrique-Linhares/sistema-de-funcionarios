package entity;

public class Funcionário {
    private String nome;
    private String cpf;
    private Double salarioBase;
    private String registro;
    private String genero;
    private Boolean ferias;
    private int feriasDias;

    //Construtor Vazio
    public Funcionário() {}

    // Construtor
    public Funcionário(String nome, int feriasDias, Boolean ferias, String genero, Double salarioBase, String cpf, String registro) {
        this.nome = nome;
        this.feriasDias = feriasDias;
        this.ferias = ferias;
        this.genero = genero;
        this.salarioBase = salarioBase;
        this.cpf = cpf;
        this.registro = registro;
    }

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


}
