public class Partida {
    String nome, data, local;

    //mapa com a quantidade de ingressos tipo inteira disponíveis;
    int ingressosInteira;

    //mapa com a quantidade de ingressos tipo meia disponíveis;
    int ingressosMeia;


    //CONSTRUTOR
    Partida(String nome, String data, String local, int ingressosInteira, int ingressosMeia){
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.ingressosInteira = ingressosInteira;
        this.ingressosMeia = ingressosMeia;
    }

    //retorna o nome da partida;
    public String getName(){
        return nome;
    }

    //retorna a data e horário da partida;
    public String getData(){
        return data;
    }

    //retorna o local onde será realizada a partida;
    public String getLocal(){
        return local;
    }
   
    //retorna o número de ingressos disponíveis (soma dos ingressos tipo inteira e meia);
    public int getIngressos(){
        return ingressosInteira + ingressosMeia;
    }

    //verifica se há ingressos disponíveis para o tipo e quantidade especificados; isIngressoDisponivel(TipoIngresso tipo, int quantidade)
    public boolean isIngressoDisponivel(TipoIngresso tipo, int quantidade){
        if(tipo == TipoIngresso.MEIA){
            //verifica meia
            if(ingressosMeia > quantidade){
                System.out.println(ingressosMeia + " ingressos meia estao disponiveis no momento.");
                return true;
                } 
            } else if(tipo == TipoIngresso.INTEIRA){
            //verifica inteira
            if(ingressosInteira > quantidade){
                System.out.println(ingressosInteira + " ingressos meia estao disponiveis no momento.");
                return true;
            } 
        }
        return false;
    }

    //Método venderIngresso(TipoIngresso tipo): realiza a venda de ingressos do tipo e quantidade especificados e retorna o valor total da venda;
    public double venderIngresso(TipoIngresso tipo, int quantidade, Partida partida){
        double valorTotal = 0;
        
       for(int qtd = 0; qtd < quantidade; qtd++){
            Ingresso novoIngresso;

        if(tipo == TipoIngresso.INTEIRA){

            novoIngresso = new IngressoInteira(partida, null, qtd);
            ingressosInteira -= qtd;

        } else {
            novoIngresso = new IngressoMeia(partida, null, qtd);
            ingressosMeia -= qtd;
        }

        valorTotal += novoIngresso.getPreco();
       }
       
        return valorTotal;
    }

}
