import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        //USUARIO DEVE
            // - Cadastrar uma nova partida ✅
            // Realizar venda de um ingresso, onde o usuario escolhe um assento (fila e numero)
            // Programa deve exibir as informaçoes para validaçao do usuario
            // Programa deve sinalizar que a compra foi realizada

        //Exibir informaçoes da partida ✅
        //Exibir numero de ingressos restantes
        //Exibir Informaçoes do ultimo ingresso vendido

        //O programa só precisa armazenar uma partida e um ingresso por vez. Ou seja, se uma nova partida for cadastrada, a partida anterior é apagada.

        Partida partidaUsuario = null;
        Scanner scanner = new Scanner(System.in);
        
        menuOptions();
        int entrada = scanner.nextInt();

        while (entrada != 4){
           switch(entrada){
                
                case 1:
                    //criando partida e atribuindo a uma variavel
                    partidaUsuario = criarPartida();
                    break;

                case 2:
                    //chamar metodo de vender ingresso
                    System.out.println("✅");
                    break;

                case 3:
                    //exibir informaçoes da partida
                    ExibirPartida(partidaUsuario.nome, partidaUsuario.data, partidaUsuario.local, partidaUsuario.ingressosInteira, partidaUsuario.ingressosMeia);
                    break;

                case 4:
                    //Fechar programa
                    System.out.println("4");
                    scanner.close();
                    break;
                
                default:
                    break;

            }

            menuOptions();
            entrada = scanner.nextInt();

            
        }

    }
    
    public static void menuOptions(){
        System.out.println("========CRIADOR DE PARTIDAS========");
        System.out.println("1- Criar partida");
        System.out.println("2- Vender Ingresso");
        System.out.println("3- Exibir informações");
        System.out.println("4- Sair");
        
    }

    public static Partida criarPartida(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("===========CRIANDO PARTIDA===========");
        System.out.println("");
        
        System.out.println("Digite o nome da partida: ");
        String nomePartida = scanner.nextLine();

        System.out.println("Digite a data da partida: ");
        String dataPartida = scanner.nextLine();

        System.out.println("Digite o local da partida: ");
        String localPartida = scanner.nextLine();

        System.out.println("Quantos ingressos tipo Inteira seram disponibilizados? ");
        int ingressosInteira = scanner.nextInt();

        System.out.println("Quantos ingressos tipo Meia seram disponibilizados? ");
        int ingressosMeia = scanner.nextInt();


        Partida novaPartida = new Partida(nomePartida, dataPartida, localPartida, ingressosInteira, ingressosMeia);

        System.out.println("✅Sua partida foi criada com sucesso!✅");

        return novaPartida;
    }

    public static void ExibirPartida(String nomePartida, String dataPartida, String localPartida, int ingressosInteira, int ingressosMeia){
        System.out.println("===========PARTIDA ATUAL===========");
        System.out.println("");

        System.out.println("Nome da partida: " + nomePartida);
        System.out.println("Data da partida: " + dataPartida);
        System.out.println("Local da partida: " + localPartida);
        System.out.println("Quantidade de ingressos inteira: " + ingressosInteira);
        System.out.println("Quantidade de ingressos meia: " + ingressosMeia);
    }
}
