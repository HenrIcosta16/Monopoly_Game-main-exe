package itens;

import itens.objetos.CartaDeSorte;
import itens.objetos.CofreComunitario;
import itens.objetos.GrupoDePropriedades;
import itens.objetos.Lugar;
import itens.objetos.Player;
import itens.objetos.Prison;
import itens.objetos.Propriedade;
import itens.objetos.Regras;
import itens.objetos.Tabuleiro;
import itens.objetos.ValidacaoCor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Player[] jogadores;
    Tabuleiro tabuleiro;
    // CartaDeCofreC cartaDcofrec;
    CofreComunitario cofreComunitario;
    CartaDeSorte cartaDeSorte;
    GrupoDePropriedades grupoDePropriedades;

    int jogadorAtual;
    int totalJogadores;

    Scanner scanner;

    Regras validacaoCor = new ValidacaoCor();

    public Game(int totalJogadores, Tabuleiro tabuleiro, Scanner scanner) {
        this.totalJogadores = totalJogadores;
        this.tabuleiro = tabuleiro;
        this.scanner = scanner;
        // this.cartaDcofrec = new CartaDeCofreC();
        this.cofreComunitario = new CofreComunitario();
        // this.cartaDeSorte = new CartaDeSorte();
        this.cartaDeSorte = new CartaDeSorte(false);

    }

    public void iniciarJogo() {

        jogadores = new Player[totalJogadores];
        criarJogadores();

        jogar();
        scanner.close();
    }

    private GrupoDePropriedades inicializarGrupoDePropriedades() {

        List<Propriedade> propriedades = new ArrayList<>();

        propriedades.add(new Propriedade("Park Place", "Posição 38", 350, 35));
        propriedades.add(new Propriedade("Board work", "Posição 39", 400, 50));

        // Criando o grupo de propriedades
        return new GrupoDePropriedades("Grupo Azul", "Posição Especial", 750, 100, propriedades);

    }

    public void criarJogadores() {
        for (int i = 0; i < totalJogadores; i++) {
            System.out.println("Entre com o nome do jogador no. " + (i + 1));
            String nome = scanner.nextLine();

            String corEscolhida;
            while (true) {
                System.out.println("Escolha a cor do peão do jogador no. " + (i + 1)
                        + " entre as opções seguintes:\n[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]");
                corEscolhida = scanner.nextLine().trim().toLowerCase();

                if (validacaoCor.digiteCorValida(corEscolhida) && validacaoCor.corEscolhida(corEscolhida, jogadores)) {
                    break;
                }
            }

            jogadores[i] = new Player(nome, 1500, corEscolhida, 0);
        }
        System.out.println("O jogo Monopoly foi iniciado.");
    }

    public void jogar() {
        jogadorAtual = 0;
        while (totalJogadores > 1) {
            jogadaJogadorAtual();
            proximoJogador();
        }
    }

    public void jogadaJogadorAtual() {
        System.out.println("---------------------------------");
        System.out.println("|      Realize as jogadas       |");
        System.out.println("---------------------------------");
        System.out.println("A jogada de " + jogadores[jogadorAtual].getNome() + " começou.");

        if (jogadores[jogadorAtual].estaNaPrisao()) {
            System.out.println(jogadores[jogadorAtual].getNome() + " está na prisão.");
            Prison prisioneiro = new Prison(jogadores[jogadorAtual], scanner);
            prisioneiro.Acao(jogadores[jogadorAtual], jogadores, scanner);
        } else {
            while (true) {
                System.out.print("Comandos disponíveis: [1 = JOGAR] ");
                if (jogadores[jogadorAtual].getPropriedadesCompradas().size() > 0) {
                    System.out.print("[2 = CONSTRUIR] ");
                    System.out.print("[3 = VENDER] ");
                }
                System.out.print("[4 = STATUS] ");
                System.out.print("[5 = SAIR] ");
                System.out.println(" ");
                System.out.print("Entre com um comando: ");
                String comando = scanner.nextLine().trim().toLowerCase();

                if (comando.equals("1") || comando.equals("jogar")) {
                    jogarNormal(); // Realiza a jogada normal
                    break;
                } else if (comando.equals("4") || comando.equals("status")) {
                    mostrarStatus(); // Mostra o status do jogador
                    break;
                } else if (comando.equals("2") || comando.equals("construir")) {
                    construirCasaOuHotel();
                    break;
                } else if (comando.equals("3") || comando.equals("vender")) {
                    venderCasaOuHotel(); // Chama o método para vender casas ou hotéis
                    break;
                } else if (comando.equals("5") || comando.equals("sair")) {
                    sairJogo();
                    break;
                } else {
                    System.out.println("Comando inválido! Tente novamente.");
                }
            }
        }
    }

    public void mostrarStatus() {
        System.out.println("Status para o jogador " + jogadores[jogadorAtual].getNome());
        System.out.println("Cor: " + jogadores[jogadorAtual].getCor());
        System.out.println("Saldo: " + jogadores[jogadorAtual].getSaldo());
        System.out.println("Posição: " + jogadores[jogadorAtual].getPosicao());

        if (jogadores[jogadorAtual].estaNaPrisao()) {
            System.out.println("O jogador está na prisão.");
        } else {
            System.out.println("O jogador está livre.");
        }

        System.out.println("Propriedades compradas: ");
        List<Propriedade> propriedadesCompradas = jogadores[jogadorAtual].getPropriedadesCompradas();
        for (Propriedade propriedade : propriedadesCompradas) {
            System.out.println(propriedade.getNome());
        }
    }

    public void sairJogo() {
        System.out.println("Você tem certeza de que quer sair (s/n)?");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            System.out.println("Jogo encerrado.");
            totalJogadores = 0;
        } else {
            jogadaJogadorAtual();
        }
    }

    public void jogarNormal() {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;

        int soma = dado1 + dado2;
        System.out.println("O jogador " + jogadores[jogadorAtual].getNome() + " tirou " + dado1 + " e " + dado2);
        System.out.println("Somatório: " + soma);

        int novaPosicao = jogadores[jogadorAtual].getPosicao() + soma;
        novaPosicao = novaPosicao % 40;
        jogadores[jogadorAtual].setPosicao(novaPosicao);

        System.out.println("Nova posição do jogador " + jogadores[jogadorAtual].getNome() + ": " + novaPosicao);

        // Obtém o lugar correspondente à nova posição
        Lugar lugarAtual = tabuleiro.getLugar(novaPosicao);

        // Executa a ação do lugar
        if (lugarAtual != null) {
            lugarAtual.Acao(jogadores[jogadorAtual], jogadores, scanner);

            if (novaPosicao == 2 || novaPosicao == 7 || novaPosicao == 17 || novaPosicao == 22 || novaPosicao == 33) {
                cofreComunitario.cartacofre(jogadores[jogadorAtual], jogadores, scanner);

                if (novaPosicao == 2 || novaPosicao == 7 || novaPosicao == 17) {
                    cartaDeSorte.sortearCarta(jogadores[jogadorAtual], jogadores, scanner);

                }
            }
        } else {
            System.out.println("Nada aconteceu nesta posição.");
        }
    }

    public void construirCasaOuHotel() {
        System.out.println("Você pode construir casas ou hotéis nas seguintes propriedades:");
        List<Propriedade> propriedadesDisponiveis = jogadores[jogadorAtual].getPropriedadesCompradas();

        // Lista as propriedades onde o jogador pode construir
        for (int i = 0; i < propriedadesDisponiveis.size(); i++) {
            Propriedade propriedade = propriedadesDisponiveis.get(i);
            System.out.println((i + 1) + " - " + propriedade.getNome() +
                    " | Casas: " + propriedade.getCasas() +
                    " | Tem hotel: " + propriedade.temHotel() +
                    " | Custo para construir: " + propriedade.getPreco());
        }

        System.out.print("Escolha o número da propriedade para construir (0 para sair): ");
        int escolha = Integer.parseInt(scanner.nextLine());

        if (escolha == 0) {
            System.out.println("Operação de construção cancelada.");
            return; // Retorna sem passar a vez, pois o jogador cancelou a construção
        }

        Propriedade propriedadeEscolhida = propriedadesDisponiveis.get(escolha - 1);

        // Verificando se o jogador pode construir casas ou hotéis
        System.out.println("Você deseja construir uma casa ou um hotel? (1 para casa / 2 para hotel)");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            if (jogadores[jogadorAtual].podeConstruirCasa(propriedadeEscolhida)) {
                jogadores[jogadorAtual].construirCasa(propriedadeEscolhida);
            }
        } else if (opcao == 2) {
            if (jogadores[jogadorAtual].podeConstruirHotel(propriedadeEscolhida)) {
                jogadores[jogadorAtual].construirHotel(propriedadeEscolhida);

            }
        } else {
            System.out.println("Opção inválida! Tente novamente.");
        }

    }

    public void venderCasaOuHotel() { // classe lugar
        System.out.println("Você pode vender casas ou hotéis nas seguintes propriedades:");
        List<Propriedade> propriedadesDisponiveis = jogadores[jogadorAtual].getPropriedadesCompradas();

        // Verifica se há propriedades para vender
        if (propriedadesDisponiveis.isEmpty()) {
            System.out.println("Você não tem propriedades para vender.");
            return; // Sai da função se o jogador não tiver propriedades
        }

        // Lista as propriedades onde o jogador pode vender casas ou hotéis
        for (int i = 0; i < propriedadesDisponiveis.size(); i++) {
            Propriedade propriedade = propriedadesDisponiveis.get(i);
            System.out.println((i + 1) + " - " + propriedade.getNome() +
                    " | Casas: " + propriedade.getCasas() +
                    " | Tem hotel: " + propriedade.temHotel() +
                    " | Valor de venda: $" + (propriedade.getPreco() / 2));
        }

        // Loop para vender até o jogador cancelar ou não houver mais propriedades
        while (true) {
            System.out.print("Escolha o número da propriedade para vender (0 para sair): ");
            int escolha = Integer.parseInt(scanner.nextLine());

            if (escolha == 0) {
                System.out.println("Operação de venda cancelada.");
                break;
            }

            // Vrf se a escolha está dentro do intervalo válido
            if (escolha < 1 || escolha > propriedadesDisponiveis.size()) {
                System.out.println("Escolha inválida. Tente novamente.");
                continue;
            }

            Propriedade propriedadeEscolhida = propriedadesDisponiveis.get(escolha - 1);

            // Vrf se há casas ou hotéis para vender
            if (propriedadeEscolhida.getCasas() > 0) {
                System.out.println("Você vendeu uma casa de " + propriedadeEscolhida.getNome() + " por $"
                        + (propriedadeEscolhida.getPreco() / 2));
                propriedadeEscolhida.removerCasa();
                jogadores[jogadorAtual].ganharDinheiro(propriedadeEscolhida.getPreco() / 2);

            } else if (propriedadeEscolhida.temHotel()) {
                System.out.println("Você vendeu um hotel de " + propriedadeEscolhida.getNome() + " por $"
                        + (propriedadeEscolhida.getPreco() / 2));
                propriedadeEscolhida.removerHotel();
                jogadores[jogadorAtual].ganharDinheiro(propriedadeEscolhida.getPreco() / 2);

            } else {
                System.out.println("Esta propriedade não possui casas ou hotéis para vender.");
            }

            
            boolean aindaPodeVender = false;
            for (Propriedade propriedade : propriedadesDisponiveis) {
                if (propriedade.getCasas() > 0 || propriedade.temHotel()) {
                    aindaPodeVender = true;
                    break;
                }
            }

            if (!aindaPodeVender) {
                System.out.println("Você não tem mais casas ou hotéis para vender.");
                break;
            }
        }
    }

    private void removerJogador(int indice) {
        Player[] novoArray = new Player[totalJogadores - 1];
        int contador = 0;
        for (int i = 0; i < totalJogadores; i++) {
            if (i != indice) {
                novoArray[contador] = jogadores[i];
                contador++;
            }
        }
        jogadores = novoArray;
        totalJogadores--;
    }

    public void proximoJogador() {
        jogadorAtual = (jogadorAtual + 1) % totalJogadores;

        if (jogadores[jogadorAtual].getSaldo() <= 0) {
            removerJogador(jogadorAtual);
            if (totalJogadores == 1) {
                System.out.println("O jogador " + jogadores[0].getNome() + " venceu o jogo!");
                totalJogadores = 0;
            } else {
                if (jogadorAtual == totalJogadores) {
                    jogadorAtual = 0;
                }
            }
        } else if (totalJogadores == 1) {
            System.out.println("O jogador " + jogadores[0].getNome() + " venceu o jogo!");
            totalJogadores = 0;
        }

    }

}