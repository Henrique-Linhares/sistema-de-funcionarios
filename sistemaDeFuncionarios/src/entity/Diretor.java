package entity;

public class Diretor extends Gerente{
    private Double participacaoDosLucros;
    private Boolean notebook;
    private Boolean socio;

    //Construtor Vazio
    public Diretor() {
    }

    //Construtor Completo
    public Diretor(String nome, int feriasDias, Boolean ferias, String genero, Double salarioBase, String cpf, String registro, 
    Double valeTransporte, Double valeAlimentacao, Boolean planoDeSaude, String departamento, int quantidadeDeSubordinados, boolean salaPropria,
    Double participacaoDosLucros, Boolean notebook, Boolean socio) {
        super(nome, feriasDias, ferias, genero, salarioBase, cpf, registro, valeTransporte, valeAlimentacao, planoDeSaude, departamento, quantidadeDeSubordinados, salaPropria);
        this.participacaoDosLucros = participacaoDosLucros;
        this.notebook = notebook;
        this.socio = socio;
    }

    //Metodos Getters e Setters
    public Double getParticipacaoDosLucros() {
        return participacaoDosLucros;
    }
    public void setParticipacaoDosLucros(Double participacaoDosLucros) {
        this.participacaoDosLucros = participacaoDosLucros;
    }
    public Boolean getNotebook() {
        return notebook;
    }
    public void setNotebook(Boolean notebook) {
        this.notebook = notebook;
    }
    public Boolean getSocio() {
        return socio;
    }
    public void setSocio(Boolean socio) {
        this.socio = socio;
    }

    //Metodos
    @Override
    public final double calcularSalarioLiquido(){
        return (getSalarioBase() + 2000 + (getSalarioBase() * 0.25) + getValeAlimentacao() + getValeTransporte()) * 0.85;
    }

   @Override
public String toString() {
    return super.toString() + 
           "\n| Tipo: Diretor" +
           "\n| Participação nos Lucros: R$ " +  participacaoDosLucros + 
           "\n| Notebook Corporativo: " + (notebook ? "Sim" : "Não") + 
           "\n| Sócio da Empresa: " + (socio ? "Sim" : "Não");
}

    
}
