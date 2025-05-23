public class Main {
    public static void main(String[] args) {
        NoEArvore.Arvore arvore = new NoEArvore().new Arvore("A");
        //professor do ceu, fui criar a classe com nome de NoEArvore pra colocar as duas clases que voce tinha falado juntas... fui jovem.
        //A instancia desse negocio ficou horripilante
        arvore.inserir("B");
        arvore.inserir("C");
        arvore.inserir("D");
        arvore.inserir("E");
        arvore.inserir("F");

        System.out.println("Número de nós: " + arvore.contarNos(arvore.raiz));
    }
}
