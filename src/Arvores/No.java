package Arvores;

public class No<T> {
    private No esquerdo;
    private No direito;
    private int id;

    private final T dados;


    public No(int id, T dados) {
        this.id = id;
        this.dados = dados;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerda) {
        this.esquerdo = esquerda;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direita) {
        this.direito = direita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getDados(){
        return dados;
    }
}
