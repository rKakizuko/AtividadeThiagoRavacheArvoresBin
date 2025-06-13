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
                System.out.println("Valor " + z.valor + " já existe na árvore. Inserção ignorada.");
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

}