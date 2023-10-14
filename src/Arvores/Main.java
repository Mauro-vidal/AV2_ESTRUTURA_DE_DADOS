package Arvores;

import java.util.Scanner;

public class Main {
    private static ArvoreBinaria arvore;
    public static void main(String[]args){

        arvore = new ArvoreBinaria();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("============================================");
            System.out.println(" ÁRVORE BINÁRIA");
            System.out.println(" QUANTIDADE DE ELEMENTOS NA ÁRVORE -> " + arvore.getQtd());
            System.out.println("============================================");
            System.out.println(" 0 - Encerrar");
            System.out.println(" 1 - Inserir no");
            System.out.println(" 2 - Buscar no");
            System.out.println(" 3 - Remover no");
            System.out.println("=======================================================");
            System.out.println("4 - Imprimir");
            System.out.println("5 - Preencher árvore com alguns valores");
            System.out.println("\nOpção escolhida -> ");

            int opcao = sc.nextInt();

            if (opcao == 0) {
                System.out.println("===================FIM=========================");
                arvore.imprime(arvore.getRaiz());
                break;

            } else if (opcao == 1) {

                Scanner scanner = new Scanner(System.in);
                System.out.print("Informe o número ---> ");
                int id = scanner.nextInt();

                Elemento elemento = new Elemento(id);
                No<Elemento> noa = new No<>(id, elemento);

                if (arvore.inserir(arvore.getRaiz(), noa)) {
                    System.out.println("\nInsercao bem sucedida.");
                } else {
                    System.out.println("\n*** ERRO: insercao falhou (ver. se ja' nao consta este valor na arvore).");
                }

            } else if (opcao == 2) {
                Scanner scn2I = new Scanner(System.in);
                System.out.print("Informe o numero do elemento a ser localizado ---> ");
                int id = scn2I.nextInt();
                No[] no = arvore.buscar(id);
                if (no[1] == null) {
                    System.out.println("ERRO: O valor procurado não está na árvore.");
                } else {
                    System.out.println("\nElemento localizado:");
                    imprimeElemento(no[1]);
                }

            } else if (opcao == 3) {

                Scanner scanner = new Scanner(System.in);
                System.out.print("Informe o elemento que deseja remover da árvore ---> ");
                int id = scanner.nextInt();
                No no = arvore.remover(id);
                if (no == null) {
                    System.out.println("ERRO: esse valor não está na árvore.");
                } else {
                    System.out.println("\nElemento removido com sucesso:");
                    imprimeElemento(no);
                }

            }else if (opcao == 4){
                arvore.imprime(arvore.getRaiz());
            } else if (opcao == 5) {
                preencherArvore();
            }
        }
    }

    private static void imprimeElemento(No no) {
        Elemento elemento =(Elemento)no.getDados();
        System.out.println("Numero -> " + elemento.getNum());
    }

    private static void preencherArvore() {
        No<Elemento> a1 = new No<>(100, new Elemento(100));
        No<Elemento> a2 = new No<>(500, new Elemento(500));
        No<Elemento> a3 = new No<>(1000, new Elemento(1000));
        No<Elemento> a4 = new No<>(10000, new Elemento(10000));
        No<Elemento> a5 = new No<>(20000, new Elemento(20000));

        arvore.inserir(arvore.getRaiz(), a1);
        arvore.inserir(arvore.getRaiz(), a2);
        arvore.inserir(arvore.getRaiz(), a3);
        arvore.inserir(arvore.getRaiz(), a4);
        arvore.inserir(arvore.getRaiz(), a5);
    }

}
