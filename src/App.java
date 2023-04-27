import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {      
        //Exibir Informaçoes do ultimo ingresso vendido

        Partida partidaUsuario = null;
        Ingresso ingressoInteira = new IngressoInteira(partidaUsuario, null, 100);
        Ingresso ingressoMeia = new IngressoMeia(partidaUsuario, null, 50);

        Scanner scanner = new Scanner(System.in);
        TipoIngresso tipo = null;
        
      
        
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
                    abrirBilheteria(partidaUsuario, tipo, scanner);
                    break;

                case 3:
                    //Exibir informaçoes da partida
                    System.out.println("=======EXIBINDO PARTIDA=======\n");
                    if(partidaUsuario == null){
                        System.out.println("Nenhuma partida cadastrada\n");
                        break;
                    }
                    
                    System.out.println(partidaUsuario.toString());
                    
                    System.out.println("==============================\n");
                    
                    break;

                case 4:
                    //Exibir o número de ingressos restantes;
                    System.out.println("=======EXIBINDO INGRESSOS RESTANTES=======\n");
                   
                    if(partidaUsuario == null){
                        System.out.println("Nenhuma partida cadastrada\n");
                        break;
                    }

                    System.out.println("Ingressos restantes: " + partidaUsuario.getIngressos());

                    System.out.println("\n==========================================\n");

                    break;

                case 5:
                    //Exibir informações do último ingresso vendido;
                    System.out.println("=======ULTIMO INGRESSO VENDIDO=======\n");
                    if(partidaUsuario == null){
                        System.out.println("Nenhuma partida cadastrada, logo, nenhum ingresso vendido.\n");
                        break;
                    }

                    //FALTA AQUIIIIIIIIIIII!!!!!!!
                    System.out.println();
                    
                    System.out.println("\n==========================================\n");
                    
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
        System.out.println("5- Exibir ultimo ingresso vendido");
        System.out.println("6- Sair\n");
        
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

        System.out.println("\n✅Sua partida foi criada com sucesso!✅\n");

        return novaPartida;
    }
    
    public static void abrirBilheteria(Partida partidaUsuario, TipoIngresso tipo, Scanner scanner){
                
        int opcao = 0;
        
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

            //qtdCompra dentro do assento => numero de assentos que serão selecionados, 
            //com base na qtd de ingressos comprados
            Assento[] assentosUsuario = new Assento[qtdCompra];
            
            for(int i = 0; i < qtdCompra; i++){
                System.out.println("Digite a letra da fila do " + (i+1) + "o ingresso.");
                char letraFila = scanner.next().charAt(0);
                
                System.out.println("Digite o numero do assento: ");
                int numAssento = scanner.nextInt();

                //passando letraFila para uppercase
                String letraFilaString = Character.toString(letraFila);
                String letraFilaStringUpperCase = letraFilaString.toUpperCase();
                
                //char que ira ser usado
                char letraFilaUpperCase = letraFilaStringUpperCase.charAt(0);


                //verifica se o assento ta disponivel
                boolean assentoDisponivel = true;
                    //como se fosse um for int i in lista
                for (Assento j : assentosUsuario) {
                    if ((j != null) && (j.getFila() == letraFilaUpperCase) && (j.getNumero() == numAssento)) {
                        assentoDisponivel = false;
                        break;
                    }
                }

                if (!assentoDisponivel) {
                    System.out.println("O assento " + numAssento + letraFilaUpperCase + " já foi comprado. Por favor, escolha outro assento.");
                    i--; 
                    //volta um valor no for para o usuário escolher outro assento
                } else {
                    assentosUsuario[i] = new Assento(numAssento, letraFilaUpperCase);
                }
            }

            System.out.println("======CONFIRMAÇAO DE COMPRA======\n");
            System.out.println("Tipo do Ingresso: " + tipo);
            System.out.println("Quantidade: " + qtdCompra);

            System.out.println("Assentos: \n");

            for(int i = 0; i < assentosUsuario.length; i++){
                System.out.println("Assento " + assentosUsuario[i].numero + " na fila: " + assentosUsuario[i].fila + "\n");
            }

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
                        
    }

}
