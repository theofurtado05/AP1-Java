public abstract class Ingresso{
    Partida partida;
    TipoIngresso tipo;

    Assento assento;
    double preco = 80.00;

    public double getPreco(){
        return this.preco;
    }

}
