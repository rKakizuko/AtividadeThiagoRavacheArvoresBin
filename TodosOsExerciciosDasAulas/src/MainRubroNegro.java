public class MainRubroNegro {
    public static void main(String[] args) {
        ArvoreRubroNegra arvoreRN = new ArvoreRubroNegra();
        int [] valores = {10, 20, 30, 15, 5 ,25};
        for(int valor : valores){
            arvoreRN.inserir(valor);
        }
        System.out.println("Arvore apos inserções (in-order): ");
        arvoreRN.inorder();

        arvoreRN.delete(15);
        arvoreRN.delete(10);

        System.out.println("Arvore apos remoções (in-order): ");
        arvoreRN.inorder();
    }
}
