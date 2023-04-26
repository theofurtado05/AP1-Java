import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        //USUARIO DEVE
            // Realizar venda de um ingresso, onde o usuario escolhe um assento (fila e numero)
            // Programa deve exibir as informaçoes para validaçao do usuario
            // Programa deve sinalizar que a compra foi realizada

      
        //Exibir Informaçoes do ultimo ingresso vendido

        

        Partida partidaUsuario = null;
        Scanner scanner = new Scanner(System.in);
        TipoIngresso tipo;
      
        
        menuOptions();
        int entrada = scanner.nextInt();

        while (entrada != 6){
           switch(entrada){
                
                case 1:
                    //criando partida e atribuindo a um objeto partida
                    partidaUsuario = criarPartida();
                    break;

                case 2:
                    //chamar metodo de vender ingresso
                    if(partidaUsuario == null){
                        System.out.println("\nNenhuma partida disponivel no momento.\n");
                        break;
                    }
                    System.out.println("============BILHETERIA==========\n");
                        int opcao = 0;
                        //Identado assim apenas para melhor visualizaçao do codigo.
                        while(opcao != 1){
                            System.out.println("Qual tipo de ingresso deseja comprar? (1- INTEIRA/2- MEIA)");
                            int tipoInt = scanner.nextInt();

                            if(tipoInt == 1){
                                tipo = TipoIngresso.INTEIRA;

                            } else if(tipoInt == 2){
                                tipo = TipoIngresso.MEIA;
                            } else {
                                System.out.println("Valor invalido.");
                                continue;
                            }
                            
                            System.out.println("Quantos ingressos deseja comprar? ");
                            int qtdCompra = scanner.nextInt();

                            System.out.println("======CONFIRMAÇAO DE COMPRA======\n");
                            System.out.println("Tipo do Ingresso: " + tipo);
                            System.out.println("Quantidade: " + qtdCompra);
                            System.out.println("\n");
                            System.out.println("1- Confirmar");
                            System.out.println("2- Alterar");
                            opcao = scanner.nextInt();

                            if(opcao != 1 && opcao != 2){
                                System.err.println("Opçao Invalida.\n");
                            } else if(opcao == 2){
                                System.out.println("===ALTERAR===\n");
                            } else if(opcao == 1){
                                double valorTotalVenda = partidaUsuario.venderIngresso(tipo, qtdCompra);
                                
                                if(valorTotalVenda == 0){
                                    System.out.println("\n===VENDA INDISPONIVEL===\n");

                                }else{
                                    System.out.println("Valor Total: " + valorTotalVenda);
                                    System.out.println("===VENDA REALIZADA COM SUCESSO===\n");
                                }
   
                            }
                        }
                        
                        //passar para o usuario escolher a fila e o numero do assento tambem
                    break;

                case 3:
                    //Exibir informaçoes da partida
                    System.out.println("=======EXIBINDO PARTIDA=======\n");
                    System.out.println(partidaUsuario.toString()); 
                    System.out.println("==============================\n");
                    break;

                case 4:
                    //Exibir o número de ingressos restantes;
                    System.out.println("=======EXIBINDO INGRESSOS RESTANTES=======\n");
                   

                    System.out.println("Ingressos restantes: " + partidaUsuario.getIngressos());
                    System.out.println("==========\n");
                    break;

                case 5:
                    //Exibir informações do último ingresso vendido;;
                    System.out.println("5");
                    break;

                case 6:
                    //Fechar programa
                    System.out.println("\nFechando...\n");
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
        System.out.println("4- Exibir ingressos restantes");
        System.out.println("5- Exibir ultimo ingresso");
        System.out.println("6- Sair");
        
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
    
}
