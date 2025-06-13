class NoRubroNegro {
    NoRubroNegro esquerda, direita, pai;
    int valor;
    Cor cor;

    public NoRubroNegro() {
        this.valor = 0;
        this.cor = Cor.PRETO;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }

    public NoRubroNegro(int valor) {
        this.valor = valor;
        this.cor = Cor.VERMELHO;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}