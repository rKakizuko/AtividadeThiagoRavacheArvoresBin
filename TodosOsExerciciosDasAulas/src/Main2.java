public class Main2 {
    public static void main(String[] args) {
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        String [] chaves = {"10","20","30","40","50","25"};

        for(String valor : chaves) {
            arvoreAVL.raiz = arvoreAVL.inserirRecursivo(arvoreAVL.raiz, valor);
        }

        System.out.println("Percurso em ordem da árvore AVL: ");
        arvoreAVL.buscaEmOrdem(arvoreAVL.raiz);

    }
}
