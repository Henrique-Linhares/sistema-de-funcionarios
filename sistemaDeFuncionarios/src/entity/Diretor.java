
public class Diretor extends Gerente{
    private Double participacaoDosLucros;
    private Boolean notebook;
    private Boolean socio;

    //Construtor Vazio
    public Diretor() {
    }

    //Construtor Completo
    public Diretor(Double participacaoDosLucros, Boolean notebook, Boolean socio) {
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

}
