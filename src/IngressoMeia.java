public class IngressoMeia extends Ingresso {
    TipoIngresso tipo = TipoIngresso.MEIA;

    IngressoMeia(Partida partida, Assento assento, double preco){
        this.partida = partida;
        this.assento = assento;
        this.preco = preco;
    }    
    
}
