public class No {
    String valor;
    No esquerda, direita;

    public No (String valor){
        this.valor = valor;
        esquerda = direita = null;
    }

    public void contarPosOrdem(No no){
        if(no != null){
            contarPosOrdem(no.esquerda);
            contarPosOrdem(no.direita);
            System.out.println(no.valor + " ");
        }
    }


}