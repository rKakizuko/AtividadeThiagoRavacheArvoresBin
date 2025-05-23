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

        private No inserirRecursivo(No node, String valor) { // * isso foi feito com ajuda do chat para eu conseguir visualizar melhor o que estava acontencendo
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

        public void buscaPreOrdem(No node) {
            if (node != null) {
                System.out.print(node.valor + " ");
                buscaPreOrdem(node.esquerda);
                buscaPreOrdem(node.direita);
            }
        }
        public void buscaEmOrdem(No node) {
            if (node != null) {
                buscaEmOrdem(node.esquerda);
                System.out.print(node.valor + " ");
                buscaEmOrdem(node.direita);
            }
        }
        public void buscaPosOrdem(No node) {
            if (node != null) {
                buscaPosOrdem(node.esquerda);
                buscaPosOrdem(node.direita);
                System.out.print(node.valor + " ");
            }
        }


        public void printTreeStructure() { // * isso foi feito com ajuda do chat para eu conseguir visualizar melhor o que estava acontencendo
            printTreeStructure(this.raiz, "", true);
        }

        private void printTreeStructure(No node, String prefix, boolean isLeft) {
            if (node != null) {
                System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.valor);
                printTreeStructure(node.esquerda, prefix + (isLeft ? "│   " : "    "), true);
                printTreeStructure(node.direita, prefix + (isLeft ? "│   " : "    "), false);
            }
        }
    }
}