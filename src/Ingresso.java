public abstract class Ingresso{
    Partida partida;
    TipoIngresso tipo;

    Assento assento;
    double preco = 80;

    public double getPreco(){
        return this.preco;
    }

    public Assento getAssento() {
        return this.assento;
    }
}
