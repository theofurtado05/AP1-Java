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
        return true;
    }

    //Método venderIngresso(TipoIngresso tipo): realiza a venda de ingressos do tipo e quantidade especificados e retorna o valor total da venda;
    public double venderIngresso(TipoIngresso tipo){
        return 1.0;
    }



}
