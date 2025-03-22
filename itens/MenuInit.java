package itens;

import itens.objetos.Tabuleiro;
import java.util.Scanner;

public class MenuInit {

    public MenuInit() {
    }

    public void Monopolio() {
        // Inicializando o Tabuleiro diretamente dentro do MenuInit
        Tabuleiro tabuleiro = new Tabuleiro();

        // Scanner para interagir com o usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===================================");
        System.out.println("|       *MONOPOLY GAME*           |");
        System.out.println("===================================");
        System.out.println("|  1. Jogar                       |");
        System.out.println("|  2. SAIR                        |");
        System.out.println("===================================");
        int opc = scanner.nextInt();

        switch (opc) {
            case 1:
                System.out.println("---------------------------------");
                System.out.println("|     Selecione os Players      |");
                System.out.println("---------------------------------");

                int numeroPlayer = 0;
                boolean numeroValido = false;

                while (!numeroValido) {
                    System.out.println("Entre com o número de jogadores [2-8]: ");
                    numeroPlayer = scanner.nextInt();
                    scanner.nextLine();

                    if (numeroPlayer > 1) {
                        numeroValido = true;
                    } else {
                        System.out.println("Número inválido. Digite um número de jogadores maior que 1.");
                    }
                }

                Game player = new Game(numeroPlayer, tabuleiro, scanner);
                player.iniciarJogo();
                break;

            case 2:
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }
}

// package itens;

// import itens.objetos.Tabuleiro;
// import itens.objetos.Propriedade;
// import java.util.Scanner;

// public class MenuInit {

// public MenuInit() {
// }

// public void Monopolio() {
// Propriedade[] casa = new Propriedade[40];
// casa[0] = new Propriedade("Go", "1");
// casa[1] = new Propriedade("Mediterranean Avenue", 60, 2, "2");
// casa[2] = new Propriedade("Hotel Favela Recife", 200, 20, "3");
// casa[3] = new Propriedade("Baltic Avenue", 60, 4, "4");
// casa[4] = new Propriedade("Income Tax", "5");
// casa[5] = new Propriedade("Reading Railroad", 200, 0, "6");
// casa[6] = new Propriedade("Oriental Avenue", 100, 6, "7");
// casa[7] = new Propriedade("Copacabana Palace", 500, 50, "8");
// casa[8] = new Propriedade("Vermont Avenue", 100, 6, "9");
// casa[9] = new Propriedade("Connecticut Avenue", 120, 8, "10");
// casa[10] = new Propriedade("Jail - Just Visiting", "11");
// casa[11] = new Propriedade("St. Charles Place", 140, 10, "12");
// casa[12] = new Propriedade("Electric Company", 150, 0, "12");
// casa[13] = new Propriedade("States Avenue", 140, 10, "14");
// casa[14] = new Propriedade("Virginia Avenue", 160, 12, "15");
// casa[15] = new Propriedade("Pennsylvania Railroad", 200, 0, "16");
// casa[16] = new Propriedade("St. James Place", 180, 14, "17");
// casa[17] = new Propriedade("Hotel Favela Rocinha", 200, 20, "18");
// casa[18] = new Propriedade("Tennessee Avenue", 180, 14, "19");
// casa[19] = new Propriedade("New York Avenue", 200, 16, "20");
// casa[20] = new Propriedade("Free Parking", "21");
// casa[21] = new Propriedade("Kentucky Avenue", 220, 18, "22");
// casa[22] = new Propriedade("Hotel Praia de Pipa", 500, 50, "23");
// casa[23] = new Propriedade("Indiana Avenue", 220, 18, "24");
// casa[24] = new Propriedade("Illinois Avenue", 240, 20, "25");
// casa[25] = new Propriedade("B & O Railroad", 200, 0, "26");
// casa[26] = new Propriedade("Atlantic Avenue", 260, 22, "27");
// casa[27] = new Propriedade("Ventnor Avenue", 260, 22, "28");
// casa[28] = new Propriedade("Water Works", 150, 0, "29");
// casa[29] = new Propriedade("Marvin Gardens", 280, 24, "30");
// casa[30] = new Propriedade("Go to Jail", "31");
// casa[31] = new Propriedade("Pacific Avenue", 300, 26, "32");
// casa[32] = new Propriedade("North Carolina Avenue", 300, 26, "33");
// casa[33] = new Propriedade("Hotel Favela Manaus", 200, 20, "34");
// casa[34] = new Propriedade("Pennsylvania Avenue", 320, 28, "35");
// casa[35] = new Propriedade("Shortline Railroad", 200, 0, "36");
// casa[36] = new Propriedade("Fernando de Noronha Hostel", 500, 50, "37");
// casa[37] = new Propriedade("Park Place", 350, 35, "38");
// casa[38] = new Propriedade("Luxury Tax", "39");
// casa[39] = new Propriedade("Board Work", 400, 50, "40");

// Tabuleiro tabuleiro = new Tabuleiro(casa);

// Scanner scanner = new Scanner(System.in);

// System.out.println("\n===================================");
// System.out.println("| *MONOPOLY GAME* |");
// System.out.println("===================================");
// System.out.println("| 1. Jogar |");
// System.out.println("| 2. SAIR |");
// System.out.println("===================================");
// int opc = scanner.nextInt();

// switch (opc) {
// case 1:
// System.out.println("---------------------------------");
// System.out.println("| Selecione os Players |");
// System.out.println("---------------------------------");

// int numeroPlayer = 0;
// boolean numeroValido = false;

// while (!numeroValido) {
// System.out.println("Entre com o número de jogadores [2-8]: ");
// numeroPlayer = scanner.nextInt();
// scanner.nextLine();

// if (numeroPlayer > 1) {
// numeroValido = true;
// } else {
// System.out.println("Número inválido. Digite um número de jogadores maior que
// 1.");
// }
// }

// Game player = new Game(numeroPlayer, tabuleiro, scanner);
// player.iniciarJogo();
// case 2:
// break;
// default:
// System.out.println("Opção inválida!");
// }
// }
// }
