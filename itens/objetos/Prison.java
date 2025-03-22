package itens.objetos;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prison extends Lugar {
    private Player jogador;
    private Scanner scanner;
    private int tentativas = 0;

    private final List<String> comandosValidos = Arrays.asList("pagar", "carta", "jogar", "status", "sair");

    public Prison(Player jogador, Scanner scanner) {
        super("Go to Jail", "30");
        this.jogador = jogador;
        this.scanner = scanner;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Você está na " + nome + ", posição: " + posicao);
    }

    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
       
        if (jogadorAtual.estaNaPrisao()) {

           
            System.out.println("Comandos disponíveis: [pagar][carta][jogar][status][sair]");

           
            String comando = scanner.nextLine().trim().toLowerCase();

            if (comandosValidos.contains(comando)) {
                if (comando.equals("pagar")) {
                    pagarParaSairDaPrisao(jogadorAtual);
                } else if (comando.equals("carta")) {
                    usarCartaParaSairDaPrisao(jogadorAtual);
                } else if (comando.equals("jogar")) {
                    tentarSairDaPrisao(jogadorAtual);
                } else if (comando.equals("status")) {
                    mostrarStatus(jogadorAtual);
                } else if (comando.equals("sair")) {
                    sairJogo();
                } else {
                    System.out.println("Comando inválido! Tente novamente.");
                    Acao(jogadorAtual, jogadores, scanner);
                }
            }
        }
    }

   
    private void pagarParaSairDaPrisao(Player jogadorAtual) {
        System.out.println(jogadorAtual.getNome() + " pagou 50 para sair da prisão.");
        jogadorAtual.fazerPagamento(50);
        jogadorAtual.setNaPrisao(false);
        System.out.println(jogadorAtual.getNome() + " saiu da prisão.");
    }

    
    public void usarCartaParaSairDaPrisao(Player jogadorAtual) {
        System.out.println(jogadorAtual.getNome() + " usou uma carta para sair da prisão.");
        jogadorAtual.setNaPrisao(false);
        System.out.println(jogadorAtual.getNome() + " saiu da prisão.");
    }

   
    private void tentarSairDaPrisao(Player jogadorAtual) {
        int dado1 = (int) (Math.random() * 6 + 1);
        int dado2 = (int) (Math.random() * 6 + 1);
        System.out.println(jogadorAtual.getNome() + " rolou os dados: " + dado1 + ", " + dado2);

        if (dado1 == dado2) {
            System.out.println(jogadorAtual.getNome() + " saiu da prisão com sucesso!");
            jogadorAtual.setNaPrisao(false);
        } else {
            tentativas++;
            if (tentativas >= 3) {
                System.out.println(jogadorAtual.getNome() + " tentou sair da prisão 3 vezes e não conseguiu.");
                pagarParaSairDaPrisao(jogadorAtual);
            } else {
                System.out.println(jogadorAtual.getNome() + " não conseguiu sair da prisão.");
            }
        }
    }

   
    private void mostrarStatus(Player jogadorAtual) {
        System.out.println("Status para o jogador " + jogadorAtual.getNome());
        System.out.println("Cor: " + jogadorAtual.getCor());
        System.out.println("Saldo: " + jogadorAtual.getSaldo());
        System.out.println("Posição: " + jogadorAtual.getPosicao());
        System.out.println("Propriedades compradas: ");
        for (Propriedade propriedade : jogadorAtual.getPropriedadesCompradas()) {
            System.out.println(propriedade.getNome());
        }
    }

    private void sairJogo() {
        System.out.println("Você tem certeza de que quer sair (s/n)?");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            System.out.println("Jogo encerrado.");
            System.exit(0);
        }
    }
}
