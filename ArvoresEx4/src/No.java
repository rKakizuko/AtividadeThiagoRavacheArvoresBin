public class No {
    String valor;
    No esquerda, direita;

    public No (String valor){
        this.valor = valor;
        esquerda = direita = null;
    }

    public void contarEmOrdem(No no){
        if(no == null){
            contarEmOrdem(no.esquerda);
            System.out.println(no.valor + " ");
            contarEmOrdem(no.direita);
        }
    }


}