import java.awt.*;
import java.io.PrintStream;

public class ArvoreRubroNegra {
    NoRubroNegro raiz;
    private NoRubroNegro NIL;

    public ArvoreRubroNegra() {
        NIL = new NoRubroNegro();
        NIL.cor = Cor.PRETO;
        NIL.esquerda = null;
        NIL.direita = null;

        this.raiz = NIL;
    }

    private void rotacionarEsquerda(NoRubroNegro x) {
        NoRubroNegro y = x.direita;
        x.direita = y.esquerda;

        if (y.esquerda != NIL) {
            y.esquerda.pai = x;
        }

        y.pai = x.pai;

        if (x.pai == NIL) {
            this.raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }

        y.esquerda = x;
        x.pai = y;
    }

    private void rotacionarDireita(NoRubroNegro x) {
        NoRubroNegro y = x.esquerda;
        x.esquerda = y.direita;

        if (y.direita != NIL) {
            y.direita.pai = x;
        }

        y.pai = x.pai;

        if (x.pai == NIL) {
            this.raiz = y;
        } else if (x == x.pai.direita) {
            x.pai.direita = y;
        } else {
            x.pai.esquerda = y;
        }

        y.direita = x;
        x.pai = y;
    }

    public void inserir(int valor) {
        NoRubroNegro novoNo = new NoRubroNegro(valor);
        novoNo.esquerda = NIL;
        novoNo.direita = NIL;
        inserirNo(novoNo);
    }

    private void inserirNo(NoRubroNegro z) {
        NoRubroNegro y = NIL;
        NoRubroNegro x = this.raiz;

        while (x != NIL) {
            y = x;
            if (z.valor < x.valor) {
                x = x.esquerda;
            } else if (z.valor > x.valor) {
                x = x.direita;
            } else {
                System.out.println("Valor " + z.valor + " Numero já inserido");
                return;
            }
        }

        z.pai = y;

        if (y == NIL) {
            this.raiz = z;
        } else if (z.valor < y.valor) {
            y.esquerda = z;
        } else {
            y.direita = z;
        }

        if (z.pai == NIL) {
            z.cor = Cor.PRETO;
        } else {
            z.cor = Cor.VERMELHO;
        }

        consertoInsercao(z);
    }

    private void consertoInsercao(NoRubroNegro z) {
        while (z.pai.cor == Cor.VERMELHO) {
            if (z.pai == z.pai.pai.esquerda) {
                NoRubroNegro tio = z.pai.pai.direita;

                if (tio.cor == Cor.VERMELHO) {
                    z.pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    z.pai.pai.cor = Cor.VERMELHO;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.direita) {
                        z = z.pai;
                        rotacionarEsquerda(z);
                    }
                    z.pai.cor = Cor.PRETO;
                    z.pai.pai.cor = Cor.VERMELHO;
                    rotacionarDireita(z.pai.pai);
                }
            } else {
                NoRubroNegro tio = z.pai.pai.esquerda;

                if (tio.cor == Cor.VERMELHO) {
                    z.pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    z.pai.pai.cor = Cor.VERMELHO;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.esquerda) {
                        z = z.pai;
                        rotacionarDireita(z);
                    }
                    z.pai.cor = Cor.PRETO;
                    z.pai.pai.cor = Cor.VERMELHO;
                    rotacionarEsquerda(z.pai.pai);
                }
            }
            if (z == this.raiz) {
                break;
            }
        }
        this.raiz.cor = Cor.PRETO;
    }
    private void transplant(NoRubroNegro u, NoRubroNegro v){
        if(u.pai == null) raiz = v;
        else if (u == u.pai.esquerda) u.pai.esquerda = v;
        else u.pai.direita = v;
        v.pai = u.pai;
    }
    private NoRubroNegro minimum(NoRubroNegro noRN){
        while(noRN.esquerda != NIL) noRN = noRN.esquerda;
        return noRN;

    }

    public void delete(int valor){
        NoRubroNegro z = buscarNo(raiz, valor);
        if (z == NIL) return;

        NoRubroNegro y = z;
        Cor yOriginalColor = y.cor;
        NoRubroNegro x;
        if(z.esquerda == NIL){
            x = z.direita;
            transplant(z, z.direita);
        } else if (z.direita == NIL){
            x = z.esquerda;
            transplant(z, z.esquerda);

        }else {
            y = minimum(z.direita);
            yOriginalColor = y.cor;
            x = y.direita;
            if (y.pai == z) x.pai = y;
            else{
                transplant(y, y.direita);
                y.direita = z.direita;
                y.direita.pai = y;
            }
            transplant(z, y);
            y.esquerda = z.esquerda;
            y.esquerda.pai = y;
            y.cor = z.cor;

        }
        if (yOriginalColor == Cor.PRETO) deleteFix(x);
    }
    private void deleteFix(NoRubroNegro x){
        NoRubroNegro w;
        while (x != raiz && x.cor == Cor.PRETO){
            if(x == x.pai.esquerda){
                w = x.pai.direita;
                if(w.cor == Cor.VERMELHO){
                    w.cor = Cor.PRETO;
                    x.pai.cor = Cor.VERMELHO;
                    rotacionarEsquerda(x.pai);
                    w = x.pai.direita;
                }
                if (w.esquerda.cor == Cor.PRETO && w.direita.cor == Cor.PRETO){
                    w.cor = Cor.VERMELHO;
                    x = x.pai;
                }else {
                    if(w.direita.cor == Cor.PRETO){
                        w.esquerda.cor = Cor.PRETO;
                        w.cor = Cor.VERMELHO;
                        rotacionarDireita(w);
                        w = x.pai.direita;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.PRETO;
                    w.direita.cor = Cor.PRETO;
                    rotacionarEsquerda(x.pai);
                    x = raiz;
                }
            }else{
                w = x.pai.esquerda;
                if(w.cor == Cor.VERMELHO){
                    w.cor = Cor.PRETO;
                    x.pai.cor = Cor.VERMELHO;
                    rotacionarDireita(x.pai);
                    w = x.pai.esquerda;
                }
                if(w.direita.cor == Cor.PRETO && w.esquerda.cor == Cor.PRETO){
                    w.cor = Cor.VERMELHO;
                    x = x.pai;
                }else{
                    if(w.esquerda.cor == Cor.PRETO){
                        w.direita.cor = Cor.PRETO;
                        w.cor = Cor.VERMELHO;
                        rotacionarEsquerda(w);
                        w = x.pai.esquerda;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.PRETO;
                    w.esquerda.cor = Cor.PRETO;
                    rotacionarDireita(x.pai);
                    x = raiz;
                }
            }
        }
        x.cor = Cor.PRETO;

    }

    public NoRubroNegro buscar(int valor) {
        return buscarNo(this.raiz, valor);
    }

    private NoRubroNegro buscarNo(NoRubroNegro noAtual, int valor) {
        if (noAtual == NIL || noAtual.valor == valor) {
            return noAtual;
        }

        if (valor < noAtual.valor) {
            return buscarNo(noAtual.esquerda, valor);
        } else {
            return buscarNo(noAtual.direita, valor);
        }
    }
    public void inorder(){
        inorderHelper(raiz);
        System.out.println();
    }
    private void inorderHelper(NoRubroNegro noRN){
        if(noRN != NIL){
            inorderHelper(noRN.esquerda);
            String colorSuffix = (noRN.cor == Cor.VERMELHO) ? "R" : "B";
            System.out.println(noRN.valor + colorSuffix + " ");
            inorderHelper(noRN.direita);
        }
    }

}