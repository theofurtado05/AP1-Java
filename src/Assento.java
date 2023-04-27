public class Assento {
    int numero;
    char fila;

    public Assento(int numero, char fila){
        this.numero = numero;
        this.fila = fila;
    }

    public int getNumero(){
        return this.numero;
    }

    public char getFila(){
        return this.fila;
    }
}


//Realize a venda de um ingresso, em que o usuário escolhe um 

//-assento (fila e número), 

//- o tipo do ingresso (inteira ou meia), 
//-e o programa gera um ingresso e exibe na tela as informações. O usuário deve confirmar se as informações estão corretas e o programa deve sinalizar que a compra foi realizada;