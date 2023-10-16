package arvore.binaria;

public class ArvoreBinaria {

    private No raiz;
    private Integer quantidade = 0;


    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz){
        this.raiz = raiz;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public No adicionar(Integer valor){
        this.raiz = adicionar(valor, getRaiz());
        return this.raiz;
    }

    protected No adicionar(Integer valor, No noAtual){
        if( noAtual == null )
            noAtual = new No(valor);
        else if( valor<noAtual.getValor() ) noAtual.setEsquerdo(adicionar( valor, noAtual.getEsquerdo()));
        else if( valor>noAtual.getValor()) noAtual.setDireito(adicionar( valor, noAtual.getDireito() ));
        return noAtual;
    }

    public No busca(Integer valor){
        return busca(this.raiz, valor);
    }
    private No busca(No raizAtual, Integer valor){
        if(raizAtual == null){
            return null;
        }
        while (raizAtual.getValor() != valor){
            if(raizAtual.getEsquerdo() != null && raizAtual.getEsquerdo().getValor() >= valor){
                raizAtual = raizAtual.getEsquerdo();
            }else{
                raizAtual = raizAtual.getDireito();
            }
            if(raizAtual == null){
                return null;
            }
        }
        return raizAtual;
    }

    public void remove(No no){
         this.raiz = remove(this.raiz, no);
    }
    private No remove(No raizAtual, No no){
        if(raizAtual == null){
            return raizAtual;
        }
        if(no.getValor() < raizAtual.getValor()){
            raizAtual.setEsquerdo(remove(raizAtual.getEsquerdo(), no));
        }else if(no.getValor() > raizAtual.getValor()){
           raizAtual.setDireito(remove(raizAtual.getDireito(), no));
        }else{
            if(raizAtual.getEsquerdo() == null && raizAtual.getDireito() == null){
              //encontrado e é uma folha
              return null;
            }else if (raizAtual.getDireito() != null && raizAtual.getEsquerdo() != null){
                var maiorValorEsquerdo = maiorValor(raizAtual.getEsquerdo(), null);
                No maiorEsquerdo = busca(maiorValorEsquerdo);
                remove(maiorEsquerdo);
                maiorEsquerdo.setDireito(raizAtual.getDireito());
                maiorEsquerdo.setEsquerdo(raizAtual.getEsquerdo());
                return maiorEsquerdo;
            }else{
                if(raizAtual.getEsquerdo() != null){
                    return raizAtual.getEsquerdo();
                }else{
                    return raizAtual.getDireito();
                }
            }
        }
        return raizAtual;
    }

    private Integer maiorValor(No raizAtual, Integer valorAtual){
        if(raizAtual == null){
            return null;
        }
        if(valorAtual == null){
            valorAtual = raizAtual.getValor();
        }
        if(raizAtual.getValor() > valorAtual){
            valorAtual = raizAtual.getValor();
        }
        if(raizAtual.getEsquerdo() != null){
            return maiorValor(raizAtual.getEsquerdo(), valorAtual);
        }
        return valorAtual;
    }
    private Integer menorValor(No raizAtual, Integer valorAtual){
        if(raizAtual == null){
            return null;
        }
        if(raizAtual.getValor() > valorAtual){
            valorAtual = raizAtual.getValor();
        }
        if(raizAtual.getDireito() != null){
            return maiorValor(raizAtual.getDireito(), valorAtual);
        }
        return valorAtual;
    }

    public void imprime(){
        System.out.println("___________________________________________");
        System.out.println("");
        System.out.println(pretty());
        System.out.println("___________________________________________");
        System.out.println("");
    }
    private void imprime(No no) {
        if(no != null) {
            System.out.println(no.getValor());
            System.out.println("\\");
            imprime(no.getEsquerdo());
            System.out.println("/");
            imprime(no.getDireito());
        }
    }

    //Codigo para imprimir bonito
    //https://stackoverflow.com/questions/72621780/how-to-print-binary-search-tree-in-nice-diagram
    public String pretty() {
        return pretty(this.raiz, "", 1);
    }

    private String pretty(No root, String prefix, int dir) {
        if (root == null) {
            return "";
        }

        String space = " ".repeat(("" + root.getValorString()).length());
        return pretty(root.getDireito(), prefix + "│  ".charAt(dir) + space, 2)
                + prefix + "└ ┌".charAt(dir) + root.getValorString()
                + " ┘┐┤".charAt((root.getEsquerdo()  != null ? 2 : 0)
                + (root.getEsquerdo() != null ? 1 : 0)) + "\n"
                + pretty(root.getEsquerdo(), prefix + "  │".charAt(dir) + space, 0);
    }
}
