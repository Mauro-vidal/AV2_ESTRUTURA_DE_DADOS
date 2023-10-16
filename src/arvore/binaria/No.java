package arvore.binaria;

public class No {
    private Integer valor;
    private Integer altura = 0;
    private No esquerdo;
    private No direito;

    public No(Integer valor){
        this.valor = valor;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getValor() {
        return valor;
    }

    public String getValorString() {
        return valor + "(" + getAltura() + ")";
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }
}
