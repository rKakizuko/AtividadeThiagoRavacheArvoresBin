public class NoEArvore {
    class No {
        String valor;
        No esquerda, direita;

        public No(String valor) {
            this.valor = valor;
            esquerda = direita = null;
        }
    }

    public class Arvore {
        No raiz;
        public Arvore() {
            this.raiz = null;
        }

        public Arvore(String valorRaiz) {
            this.raiz = new No(valorRaiz);
        }
        public void inserir(String valor) {
            raiz = inserirRecursivo(raiz, valor);
        }

        private No inserirRecursivo(No node, String valor) {
            if (node == null) {
                return new No(valor);
            }
            if (valor.compareTo(node.valor) < 0) {
                node.esquerda = inserirRecursivo(node.esquerda, valor);
            } else if (valor.compareTo(node.valor) > 0) {
                node.direita = inserirRecursivo(node.direita, valor);
            }
            return node;
        }
        public int contarNos(No node) {
            if (node == null) return 0;
            return 1 + contarNos(node.esquerda) + contarNos(node.direita);
        }

    }
}
