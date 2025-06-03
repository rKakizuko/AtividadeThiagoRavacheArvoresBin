public class Main2 {
    public static void main(String[] args) {
        ArvoreAVL arvoreAVL = new ArvoreAVL(); //copia da main passada atualizada

        System.out.println("Inserindo elementos:");
        arvoreAVL.inserir("D");
        arvoreAVL.inserir("B");
        arvoreAVL.inserir("F");
        arvoreAVL.inserir("A");
        arvoreAVL.inserir("C");
        arvoreAVL.inserir("E");
        arvoreAVL.inserir("G");
        arvoreAVL.inserir("H");
        arvoreAVL.inserir("I");
        arvoreAVL.inserir("J");


        arvoreAVL.printTreeStructure();

        System.out.println("\nTestando Contagens:");
        arvoreAVL.contarNosSemRecursividade();
        arvoreAVL.contarNosSemRecursividadePilha();
        System.out.println("Contagem de nós (Recursivo): " + arvoreAVL.contarNos(arvoreAVL.raiz));
        arvoreAVL.contarNosFolhaSemRecursividade();
        System.out.println("Contagem de nós folha (Recursivo): " + arvoreAVL.contarNosFolha(arvoreAVL.raiz));

        System.out.println("\nTestando Buscas:");
        System.out.print("Pré-ordem (Recursivo): ");
        arvoreAVL.buscaPreOrdem(arvoreAVL.raiz);
        System.out.println();
        arvoreAVL.buscaPreOrdemSemRecursividade();

        System.out.print("Em-ordem (Recursivo): ");
        arvoreAVL.buscaEmOrdem(arvoreAVL.raiz);
        System.out.println();
        arvoreAVL.buscaEmOrdemSemRecursividade();

        System.out.print("Pós-ordem (Recursivo): ");
        arvoreAVL.buscaPosOrdem(arvoreAVL.raiz);
        System.out.println();
        arvoreAVL.buscaPosOrdemSemRecursividade();

        arvoreAVL.buscaEmNivel();

    }
}
