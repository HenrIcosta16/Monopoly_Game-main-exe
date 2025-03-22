package itens.objetos;

import java.util.Scanner;

public class Ferrovia extends Lugar {
    private int preco;
    private Player dono;

    public Ferrovia(String nome, String posicao, int preco) {
        super(nome, posicao);
        this.preco = preco;
        this.dono = null;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Player getDono() {
        return dono;
    }

    public void setDono(Player dono) {
        this.dono = dono;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome + ", Posição: " + posicao + ", Tipo: Ferrovia, Preço: " + preco);
    }

   
    @Override
    public void Acao(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        System.out.println("Caiu na Ferrovia: " + this.getNome());

        if (this.dono != null) {
            System.out.println("Essa ferrovia já foi comprada por " + this.dono.getNome() + ".");

            int quantidadeFerrovias = this.dono.getFerroviasCompradas().size();
            int aluguel = 0;

            if (quantidadeFerrovias == 1) {
                aluguel = 25;
            } else if (quantidadeFerrovias == 2) {
                aluguel = 50;
            } else if (quantidadeFerrovias == 3) {
                aluguel = 75;
            } else if (quantidadeFerrovias == 4) {
                aluguel = 100;
            }

            System.out.println(this.dono.getNome() + " tem " + quantidadeFerrovias + " ferrovias e você pagou "
                    + aluguel + " de aluguel.");
            jogadorAtual.fazerPagamento(aluguel);
        } else {

            System.out.println("Você deseja comprar essa ferrovia pelo preço de " + this.getPreco() + " reais? (s/n)");

            String resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals("s")) {
                if (jogadorAtual.getSaldo() >= this.getPreco()) {
                    jogadorAtual.fazerPagamento(this.getPreco());
                    this.dono = jogadorAtual;
                    jogadorAtual.comprarFerrovia(this);
                    System.out.println(
                            "Você comprou a ferrovia " + this.getNome() + " por " + this.getPreco() + " reais.");
                } else {

                    System.out.println("Você não tem dinheiro suficiente para comprar a ferrovia.");
                }
            } else {
                System.out.println("Você optou por não comprar a ferrovia.");
            }
        }
    }
}
