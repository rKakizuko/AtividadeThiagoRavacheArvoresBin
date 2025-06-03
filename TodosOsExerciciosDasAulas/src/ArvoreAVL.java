import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ArvoreAVL {
    NoAVL raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }


    public int altura(NoAVL no) {
        return (no == null) ? -1 : no.altura;
    }


    void atualizarAltura(NoAVL no) {
        if (no != null) {
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        }
    }


    int getFatorBalanceamento(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerda) - altura(no.direita);
    }


    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;


        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }


    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;


        y.esquerda = x;
        x.direita = T2;


        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    public void inserir(String valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    protected NoAVL inserirRecursivo(NoAVL no, String valor) {

        if (no == null) {
            return new NoAVL(valor);
        }

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = inserirRecursivo(no.direita, valor);
        } else {
            return no;
        }


        atualizarAltura(no);


        int fatorBalanceamento = getFatorBalanceamento(no);


        if (fatorBalanceamento > 1 && valor.compareTo(no.esquerda.valor) < 0) {
            return rotacaoDireita(no);
        }


        if (fatorBalanceamento < -1 && valor.compareTo(no.direita.valor) > 0) {
            return rotacaoEsquerda(no);
        }


        if (fatorBalanceamento > 1 && valor.compareTo(no.esquerda.valor) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }


        if (fatorBalanceamento < -1 && valor.compareTo(no.direita.valor) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }


        return no;
    }


    public int contarNos(NoAVL node) {
        if (node == null) return 0;
        return 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }

    public void contarNosSemRecursividadePilha() {
        if (raiz == null) {
            System.out.println("A árvore está vazia. Contagem de nós: 0");
            return;
        }
        Stack<NoAVL> pilha = new Stack<>();
        int contador = 0;
        pilha.push(raiz);
        while (!pilha.isEmpty()) {
            NoAVL atual = pilha.pop();
            contador++;

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
        System.out.println("Contagem de nós (Iterativo - Pilha): " + contador);
    }

    public void contarNosSemRecursividade() {
        if (raiz == null) {
            System.out.println("A árvore está vazia. Contagem de nós: 0");
            return;
        }
        Queue<NoAVL> fila = new LinkedList<>();
        int contador = 0;
        fila.add(raiz);
        while (!fila.isEmpty()) {
            NoAVL atual = fila.poll();
            contador++;

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
        System.out.println("Contagem de nós (Iterativo - Fila): " + contador);
    }

    public int contarNosFolha(NoAVL node) {
        if (node == null) {
            return 0;
        }
        if (node.esquerda == null && node.direita == null) {
            return 1;
        }
        return contarNosFolha(node.esquerda) + contarNosFolha(node.direita);
    }

    public void contarNosFolhaSemRecursividade() {
        if (raiz == null) {
            System.out.println("A árvore está vazia. Contagem de folhas: 0");
            return;
        }
        Queue<NoAVL> fila = new LinkedList<>();
        int contadorFolha = 0;
        fila.add(raiz);
        while (!fila.isEmpty()) {
            NoAVL atual = fila.poll();


            if (atual.esquerda == null && atual.direita == null) {
                contadorFolha++;
            }

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
        System.out.println("Contagem de nós folha (Iterativo): " + contadorFolha);
    }


    public void buscaPreOrdem(NoAVL node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            buscaPreOrdem(node.esquerda);
            buscaPreOrdem(node.direita);
        }
    }

    public void buscaPreOrdemSemRecursividade() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }
        Stack<NoAVL> stack = new Stack<>();
        stack.push(raiz);

        System.out.print("Pré-ordem (Iterativo): ");
        while (!stack.isEmpty()) {
            NoAVL node = stack.pop();
            System.out.print(node.valor + " ");

            if (node.direita != null) {
                stack.push(node.direita);
            }
            if (node.esquerda != null) {
                stack.push(node.esquerda);
            }
        }
        System.out.println();
    }

    public void buscaEmOrdem(NoAVL node) {
        if (node != null) {
            buscaEmOrdem(node.esquerda);
            System.out.print(node.valor + " ");
            buscaEmOrdem(node.direita);
        }
    }

    public void buscaEmOrdemSemRecursividade() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Stack<NoAVL> stack = new Stack<>();
        NoAVL current = raiz;

        System.out.print("Em-ordem (Iterativo): ");
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.esquerda;
            }
            current = stack.pop();
            System.out.print(current.valor + " ");
            current = current.direita;
        }
        System.out.println();
    }

    public void buscaPosOrdem(NoAVL node) {
        if (node != null) {
            buscaPosOrdem(node.esquerda);
            buscaPosOrdem(node.direita);
            System.out.print(node.valor + " ");
        }
    }

    public void buscaPosOrdemSemRecursividade() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Stack<NoAVL> stack1 = new Stack<>();
        Stack<NoAVL> stack2 = new Stack<>();
        stack1.push(raiz);

        while (!stack1.isEmpty()) {
            NoAVL temp = stack1.pop();
            stack2.push(temp);

            if (temp.esquerda != null) stack1.push(temp.esquerda);
            if (temp.direita != null) stack1.push(temp.direita);
        }

        System.out.print("Pós-ordem (Iterativo): ");
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().valor + " ");
        }
        System.out.println();
    }

    public void buscaEmNivel() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Queue<NoAVL> fila = new LinkedList<>();
        fila.add(raiz);

        System.out.print("Em Nível (BFS): ");
        while (!fila.isEmpty()) {
            NoAVL atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
        System.out.println();
    }


    public void printTreeStructure() {
        System.out.println("\nEstrutura da Árvore:");
        printTreeStructure(this.raiz, "", true);
    }

    private void printTreeStructure(NoAVL node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.valor + " (Altura: " + node.altura + ", FB: " + getFatorBalanceamento(node) + ")");
            printTreeStructure(node.esquerda, prefix + (isLeft ? "│   " : "    "), true);
            printTreeStructure(node.direita, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}