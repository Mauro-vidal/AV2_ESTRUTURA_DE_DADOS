package arvore.binaria;

import java.util.Random;

public class MenuPrincipal {

    public static void main(String[] var){
////        var arvore = new ArvoreBinaria();
//        var arvore = new ArvoreAVL();
////        arvore.adicionar(1);
////        arvore.adicionar(2);
////        arvore.adicionar(3);
//        arvore.adicionar(33);
//        arvore.adicionar(32);
//        arvore.adicionar(37);
//        arvore.adicionar(36);
//        arvore.adicionar(42);
//        arvore.adicionar(40);
//
//        arvore.imprime();
//
//        //var no = arvore.busca(11);
//        //System.out.println(no.getValor());
//        arvore.remove(new No(37));
//        arvore.imprime();
//
        var arvore = new ArvoreBinaria();
//        var arvore = new ArvoreAVL();
        var valor = 0;
        for(int x = 0; x <= 5000; x++){
            valor = new Random().nextInt();
            arvore.adicionar(valor);
        }
//        arvore.imprime();
        var inicio = System.currentTimeMillis();
        arvore.busca(valor);
        System.out.println("Demorou: " + (System.currentTimeMillis() - inicio));
    }
}
