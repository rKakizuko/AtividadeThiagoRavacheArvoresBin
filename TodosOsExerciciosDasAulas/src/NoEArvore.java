import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        public void contarNosSemRecursividade(No node){
            if (node == null){
                System.out.println("Vazio");
            }
            Queue <No> fila = new LinkedList<>();
            int contador = 0;
            fila.add(raiz);
            while (!fila.isEmpty()) {
                No atual = fila.poll();

                if (atual.esquerda != null) fila.add(atual.esquerda);
                if (atual.direita != null) fila.add(atual.direita);
                contador ++;
            }
            System.out.println(contador + "\n");


        }
        public int contarNosFolha(No node){
            if (node == null){
                return 0;
            }
            if (node.esquerda == null && node.direita == null){
                return 1;
            }
            return contarNosFolha(node.esquerda) + contarNosFolha(node.direita);
        }
        public void contarNosFolhaSemRecursividade(No node){
            if (node == null){
                System.out.println("Vazio");
            }
            Queue <No> fila = new LinkedList<>();
            int contadorFolha = 0;
            fila.add(raiz);
            while (!fila.isEmpty()) {
                No atual = fila.poll();

                if (atual.esquerda != null) {
                    fila.add(atual.esquerda);
                }
                if (atual.direita != null){
                    fila.add(atual.direita);
                }
                else if (atual.esquerda == null & atual.direita == null){
                    contadorFolha++;
                }
            }
            System.out.println(contadorFolha + "\n");


        }


        public void buscaPreOrdem(No node) {
            if (node != null) {
                System.out.print(node.valor + " ");
                buscaPreOrdem(node.esquerda);
                buscaPreOrdem(node.direita);
            }
        }

        public void buscaPreOrdemSemRecursividade(){
            if (raiz == null){
                return;
            }
            Stack <No> stack = new Stack<>();
            stack.push(raiz);

            while (!stack.isEmpty()){
                No node = stack.pop();
                System.out.print(node.valor + " ");

                if (node.direita != null) {
                    stack.push(node.direita);
                }
                if (node.esquerda != null){
                    stack.push(node.esquerda);
                }

            }
        }
        public void buscaEmOrdem(No node) {
            if (node != null) {
                buscaEmOrdem(node.esquerda);
                System.out.print(node.valor + " ");
                buscaEmOrdem(node.direita);
            }
        }
        public void buscaEmOrdemSemRecursividade() {
            if (raiz == null) return;


            Stack<No> stack = new Stack<>();
            No current = raiz;


            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.esquerda;
                }
                current = stack.pop();
                System.out.print(current.valor + " ");
                current = current.direita;
            }
        }
        public void buscaPosOrdem(No node) {
            if (node != null) {
                buscaPosOrdem(node.esquerda);
                buscaPosOrdem(node.direita);
                System.out.print(node.valor + " ");
            }
        }
        public void buscaPosOrdemSemRecursividade() {
            if (raiz == null) return;


            Stack<No> stack1 = new Stack<>();
            Stack<No> stack2 = new Stack<>();
            stack1.push(raiz);


            while (!stack1.isEmpty()) {
                No temp = stack1.pop();
                stack2.push(temp);


                if (temp.esquerda != null) stack1.push(temp.esquerda);
                if (temp.direita != null) stack1.push(temp.direita);
            }


            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().valor + " ");
            }
            System.out.println();
        }
        public void buscaEmNivel() {
            if (raiz == null) return;

            Queue<No> fila = new LinkedList<>();
            fila.add(raiz);

            while (!fila.isEmpty()) {
                No atual = fila.poll();
                System.out.print(atual.valor + " ");

                if (atual.esquerda != null) fila.add(atual.esquerda);
                if (atual.direita != null) fila.add(atual.direita);
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