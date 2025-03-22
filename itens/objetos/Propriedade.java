package itens.objetos;

import java.util.Scanner;

public class Propriedade extends Lugar {
    private int preco;
    private int aluguel;
    private Habitacao habitacao;

    public Propriedade(String nome, String posicao, int preco, int aluguel) {
        super(nome, posicao);
        this.preco = preco;
        this.aluguel = aluguel;
        this.habitacao = new Casa(nome);
    }

    public int getPreco() {
        return preco;
    }

    public Habitacao getHabitacao() {
        return habitacao;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getAluguel() {
        return aluguel;
    }

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + this.getNome() + ", Posição: " + posicao + ", Tipo: Propriedade, Preço: " + preco
                + ", Aluguel: " + aluguel + ", Casas: " + getCasas() + ", Tem hotel: " + temHotel());
    }

    
    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        System.out.println("Caiu em " + this.getNome());

        boolean venda = false;
        for (Player jogador : jogadores) {
            if (this.getPosicao().equals(jogador.getCor())) {
                System.out.println("Essa propriedade já foi vendida.");
                venda = true;
                break;
            }
        }

        if (venda) {
            System.out.println("Você pagou o aluguel de " + this.getAluguel());
            jogadorAtual.fazerPagamento(this.getAluguel());
        } else {
            System.out.println("Você deseja comprar essa propriedade pelo preço de " + this.getPreco()
                    + "? (s/n) ");
            String comprar = scanner.nextLine();

            if (comprar.equalsIgnoreCase("s")) {
                if (jogadorAtual.getSaldo() <= this.getPreco()) {
                    jogadorAtual.fazerPagamento(this.getPreco());
                    jogadorAtual.comprarPropriedade(this);
                    System.out.println("O jogador " + jogadorAtual.getNome()
                            + " não conseguiu comprar a propriedade e faliu.");
                } else {
                    this.setPosicao(jogadorAtual.getCor());
                    jogadorAtual.fazerPagamento(this.getPreco());
                    jogadorAtual.comprarPropriedade(this);
                    System.out.println("Você comprou a propriedade " + this.getNome() + " por "
                            + this.getPreco());
                }
            } else if (comprar.equalsIgnoreCase("n")) {
                System.out.println("Você não comprou a propriedade " + this.getNome() + " por "
                        + this.getPreco());
            } else {
                System.out.println("Nada aconteceu.");
            }
        }
    }

    
    public int getCasas() {
        return habitacao.getCasas();
    }

    public boolean temHotel() {
        return habitacao.temHotel();
    }

    public void construirCasa(Player jogador) {
        habitacao.construir(jogador);
    }

    public void construirHotel(Player jogador) {
        habitacao.construirHotel(jogador);
    }

    public boolean podeConstruirCasa(Player jogador) {
        return habitacao.podeConstruir(jogador);
    }

    public boolean podeConstruirHotel(Player jogador) {
        return habitacao.podeConstruirHotel(jogador);
    }

    public void removerCasa() {
        habitacao.removerCasa();
    }

    public void removerHotel() {
        habitacao.removerHotel();
    }
}