public class IngressoInteira extends Ingresso {
    TipoIngresso tipo = TipoIngresso.INTEIRA;

    IngressoInteira(Partida partida, Assento assento, double preco){
        this.partida = partida;
        this.assento = assento;
        this.preco = preco;
    }    
}
