public class No {
    String valor;
    No esquerda, direita;

    public No (String valor){
        this.valor = valor;
        esquerda = direita = null;
    }
    public void buscarPreOrdem(No no){
        if (no != null){
            System.out.println(no.valor + " ");
            buscarPreOrdem(no.esquerda);
            buscarPreOrdem(no.direita);
        }
    }

}