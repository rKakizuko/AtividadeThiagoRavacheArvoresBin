public class Main {
    public static void main(String[] args) {
        NoEArvore.Arvore arvore = new NoEArvore().new Arvore("L");
        //professor do ceu, fui criar a classe com nome de NoEArvore pra colocar as duas clases que voce tinha falado juntas... fui jovem.
        //A instancia desse negocio ficou horripilante
        arvore.inserir("C"); //embaralhado de proposito para ver como o insert esta funcionando
        arvore.inserir("M"); //nao sei se é o convencional como o chat ta falando mas ele adiciona na direta se for > que o antecessor e na esquerda se for <.
        arvore.inserir("A");
        arvore.inserir("D");
        arvore.inserir("N");
        System.out.println("Estrutura da Árvore:");
        arvore.printTreeStructure();

        System.out.println("Número de nós: " + arvore.contarNos(arvore.raiz));
        System.out.println("Buscando em pre Ordem: ");
        arvore.buscaPreOrdem(arvore.raiz);
        System.out.println("\n");
        System.out.println("Buscando em Ordem: ");
        arvore.buscaEmOrdem(arvore.raiz);
        System.out.println("\n");
        System.out.println("Buscando em Pos Ordem: ");
        arvore.buscaPosOrdem(arvore.raiz);
        System.out.println("\n");
        System.out.println("Buscando em Nivel: ");
        arvore.buscaEmNivel(); //nao passa parametro porque na funcao pega ja o no definido como raiz para adicionar o resto em LL e percorrer por nivel
        System.out.println("\n");



    }
}