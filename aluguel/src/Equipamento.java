public class Equipamento {
    private String codigoIdentificacao;
    private String descricao;
    private double valor;

    
    public Equipamento(String codigoIdentificacao, String descricao, double valor) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.descricao = descricao;
        this.valor = valor;
    }
    
    public String getCodigoIdentificacao() {
        return codigoIdentificacao;
    }

    public void setCodigoIdentificacao(String codigoIdentificacao) {
        this.codigoIdentificacao = codigoIdentificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
 