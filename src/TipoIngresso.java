public enum TipoIngresso {
    MEIA(40),
    INTEIRA(80);

    double preco;

    TipoIngresso(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

}
