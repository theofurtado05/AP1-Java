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
        return this.nome;
    }

    //retorna a data e horário da partida;
    public String getData(){
        return this.data;
    }

    //retorna o local onde será realizada a partida;
    public String getLocal(){
        return this.local;
    }
   
    //retorna o número de ingressos disponíveis (soma dos ingressos tipo inteira e meia);
    public int getIngressos(){
        return this.ingressosInteira + this.ingressosMeia;
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

    //Vender Ingresso
    public double venderIngresso(TipoIngresso tipo, int quantidade){
        double valorTotal = 0;
      

        if(!(isIngressoDisponivel(tipo, quantidade))){
            System.out.println("Quantidade indisponivel!");
            return valorTotal;
        }

        
        if(tipo == TipoIngresso.MEIA){
            //se for meia
            
            valorTotal = quantidade * 80/2;
            ingressosMeia -= quantidade;

        } else if(tipo == TipoIngresso.INTEIRA){
            //se for inteira
            
            valorTotal = quantidade * 80;
            ingressosInteira -= quantidade;
        }


        return valorTotal;
    }
   

    //Exibir partida
    @Override
    public String toString(){
        String mostrarPartida;

        mostrarPartida = "Nome da partida: " + this.nome + "\n";
        mostrarPartida += "Data: " + this.data + "\n";
        mostrarPartida += "Local: " + this.local + "\n";

        mostrarPartida += "Numero de ingressos Inteira: " + this.ingressosInteira + "\n";

        mostrarPartida += "Numero de ingressos Meia: " + this.ingressosMeia + "\n";

        return mostrarPartida;

    }

    //Exibir quantidade de ingressos restantes
    // public void exibirIngressosRestantes(){
    //     int ingressosTotal = this.ingressosInteira + this.ingressosMeia;

    //     System.out.println("Ingressos restantes: " + ingressosTotal);

    //     System.out.println("Ingressos Inteira restantes: " + this.ingressosInteira);

    //     System.out.println("Ingressos Inteira meia: " + this.ingressosMeia);

    // }

}
