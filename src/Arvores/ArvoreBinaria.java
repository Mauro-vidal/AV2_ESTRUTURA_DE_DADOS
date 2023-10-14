package Arvores;

public class ArvoreBinaria {
    private No raiz;
    private int qtd;

    public No getRaiz() {
        return raiz;
    }

    public int getQtd() {
        return qtd;
    }

    public boolean inserir(No raizArvore, No valor){
        if (raizArvore == null){
            raiz = valor;
            qtd ++;
            return true;
        }
        if (valor.getId() < raizArvore.getId()){
            if (raizArvore.getEsquerdo() != null){
                inserir(raizArvore.getEsquerdo(), valor);
            } else{
                raizArvore.setEsquerdo(valor);
                qtd ++;
                return true;
            }
        } else if (valor.getId() > raizArvore.getId()) {
            if (raizArvore.getDireito() != null){
                inserir(raizArvore.getDireito(), valor);
            } else {
                raizArvore.setDireito(valor);
                qtd ++;
                return true;
            }

        }
        return false;
    }

    public No[] buscar(int elemento){
        No[] no = new No[2];
        no[1] = raiz;

        while (true){
            if (no[1] == null || no[1].getId() == elemento){
                return no;
            }

            no[0] = no[1];

            if (elemento < no[0].getId()){
                no[1] = no[0].getEsquerdo();
            }else{
                no[1] = no[0].getDireito();
            }
        }
    }

    public No remover(int id) {
        No[] resultado = removerNum(raiz, id);
        if (resultado != null) {
            raiz = resultado[0];
            return resultado[1];
        }
        return null;
    }

    private No[] removerNum(No raizArvore, int id) {
        if (raizArvore == null) {
            return null;
        }

        if (id < raizArvore.getId()) {
            No[] resultado = removerNum(raizArvore.getEsquerdo(), id);
            raizArvore.setEsquerdo(resultado[0]);
            return new No[] { raizArvore, resultado[1] };
        } else if (id > raizArvore.getId()) {
            No[] resultado = removerNum(raizArvore.getDireito(), id);
            raizArvore.setDireito(resultado[0]);
            return new No[] { raizArvore, resultado[1] };
        } else {
            // Encontrou o nó a ser removido
            if (raizArvore.getEsquerdo() == null) {
                return new No[] { raizArvore.getDireito(), raizArvore };
            } else if (raizArvore.getDireito() == null) {
                return new No[] { raizArvore.getEsquerdo(), raizArvore };
            } else {
                // Nó com dois filhos, encontre o sucessor in-order (maior valor na subárvore esquerda)
                No[] resultado = maiorValorSubEsq(raizArvore);
                resultado[0].setEsquerdo(removerNum(raizArvore.getEsquerdo(), resultado[1].getId())[0]);
                resultado[1].setEsquerdo(raizArvore.getEsquerdo());
                resultado[1].setDireito(raizArvore.getDireito());
                return new No[] { resultado[1], raizArvore };
            }
        }
    }

    private No[] maiorValorSubEsq(No no) {

        No[] noa = new No[2];

        noa[0] = no;
        noa[1] = no.getEsquerdo();  // primeiro no da subarvore esquerda

        // o no maior esta no ramo mais a direita da subarvore
        while (noa[1].getDireito() != null) {
            noa[0] = noa[1];
            noa[1] = noa[1].getDireito();
        }
        return noa;
    }

    public void imprime(No no) {

        if (no != null) {
            imprime(no.getEsquerdo());
            System.out.println(no.getId() + " ");
            imprime(no.getDireito());
        }
    }

}
