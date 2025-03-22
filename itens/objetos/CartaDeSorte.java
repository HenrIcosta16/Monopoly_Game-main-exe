package itens.objetos;

import java.util.Scanner;

public class CartaDeSorte extends PilhaDeSorte {

    public CartaDeSorte(boolean reves) {
        super(reves);
    }

    @Override
    protected void inicializarCartas() {
        if (isReves()) {
            // Adiciona cartas de revés
            cartas.add(TipoDeCartaSorte.IMPOSTO_DE_POBREZA);
            cartas.add(TipoDeCartaSorte.AVANCE_FERROVIA);
            cartas.add(TipoDeCartaSorte.VAI_PARA_PRISAO);
            cartas.add(TipoDeCartaSorte.VOLTE_3_ESPACOS);
            cartas.add(TipoDeCartaSorte.AVANCE_SERVICO_PUBLICO);
            cartas.add(TipoDeCartaSorte.MANUTENCAO_PROPRIEDADES);
            cartas.add(TipoDeCartaSorte.PRESIDENTE_TABULEIRO);

        } else {
            // Adiciona cartas de sorte
            cartas.add(TipoDeCartaSorte.AVANCE_PONTO_PARTIDA);
            cartas.add(TipoDeCartaSorte.AVANCE_ILLOINOIS);
            cartas.add(TipoDeCartaSorte.AVANCE_ST_CHARLES);
            cartas.add(TipoDeCartaSorte.DIVIDENDOS);
            cartas.add(TipoDeCartaSorte.ANIVERSARIO_EMPRESTIMOS);
            cartas.add(TipoDeCartaSorte.GET_OUT_OF_JAIL_FREE);
            cartas.add(TipoDeCartaSorte.CAMINHADA_BOARDWALK);
            cartas.add(TipoDeCartaSorte.LEITURA);

        }
    }

    @Override
    public void sortearCarta(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        TipoDeCartaSorte cartaSorteada = sortearCarta();
        if (cartaSorteada != null) {
            System.out.println("Carta sorteada: " + cartaSorteada.getDescricao());
            cartaSorteada.executarAcao(jogadorAtual, jogadores);
        } else {
            System.out.println("Não há mais cartas de Sorte/Reves para sortear.");
        }
    }
}
