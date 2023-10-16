package arvore.binaria;

public class ArvoreAVL extends ArvoreBinaria{

    @Override
    protected No adicionar(Integer valor, No noAtual){
        noAtual = super.adicionar(valor, noAtual);
        return verificaBalanceamento (noAtual);
    }

    private No verificaBalanceamento(No raizAtual){
        if(getFatorBalanceamento(raizAtual) == 2){
            if(getFatorBalanceamento(raizAtual.getDireito()) > 0 ){
                raizAtual = realizaRotacaoDireita(raizAtual);
            }else{
                raizAtual = realizaRotacaoDuplaDireita(raizAtual);
            }
        }else if(getFatorBalanceamento(raizAtual) == -2){
            if(getFatorBalanceamento(raizAtual.getEsquerdo()) < 0 ){
                raizAtual = realizaRotacaoEsquerda(raizAtual);
            }else{
                raizAtual = realizaRotacaoDuplaEsquerda(raizAtual);
            }
        }
        raizAtual.setAltura(maximo(altura(raizAtual.getEsquerdo()), altura(raizAtual.getDireito())) +1);
        return raizAtual;
    }

    private No realizaRotacaoDuplaEsquerda(No no) {
        no.setDireito(realizaRotacaoDireita(no.getDireito()));
        return realizaRotacaoEsquerda( no );
    }

    private No realizaRotacaoEsquerda(No no) {
        var direito = no.getDireito();
        no.setDireito(direito.getEsquerdo());
        direito.setEsquerdo(no);
        direito.setAltura(maximo(altura( direito.getEsquerdo() ), altura( direito.getDireito() ) ) + 1);
        no.setAltura(maximo(altura( no.getEsquerdo()), direito.getAltura() ) + 1);
        return direito;
    }

    private No realizaRotacaoDuplaDireita(No no) {
        no.setEsquerdo(realizaRotacaoEsquerda(no.getEsquerdo()));
        return realizaRotacaoDireita( no );
    }

    private No realizaRotacaoDireita(No no) {
        var esquerdo = no.getEsquerdo();
        no.setEsquerdo(esquerdo.getDireito());
        esquerdo.setDireito(no);
        no.setAltura(maximo(altura( no.getEsquerdo() ), altura( no.getDireito() ) ) + 1);
        esquerdo.setAltura(maximo(altura( esquerdo.getEsquerdo()), no.getAltura() ) + 1);
        return esquerdo;
    }

    private Integer maximo(int pesoEsquerdo, int pesoDireito) {
        return pesoEsquerdo > pesoDireito ? pesoEsquerdo : pesoDireito;
    }

    private int getFatorBalanceamento(No no) {
        return no == null? -1 : altura( no.getEsquerdo() ) - altura( no.getDireito());
    }

    private static int altura(No no) {
        return no == null ? -1 : no.getAltura();
    }

}
