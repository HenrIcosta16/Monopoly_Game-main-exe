package itens.objetos;

import java.util.Scanner;

public class CofreComunitario extends PilhaDeCofre {

    @Override
    protected void inicializarCartas() {
        cartas.add(CartaCofre.AVANCE_PONTO_PARTIDA);
        cartas.add(CartaCofre.ERRO_BANCO);
        cartas.add(CartaCofre.TAXA_MEDICO);
        cartas.add(CartaCofre.ABERTURA_OPERA);
        cartas.add(CartaCofre.LIQUIDACAO_ESTOQUE);
        cartas.add(CartaCofre.SAIA_LIVRE_PRISAO);
        cartas.add(CartaCofre.VAI_PARA_PRISAO);
        cartas.add(CartaCofre.RESTITUICAO_IMPOSTO);
        cartas.add(CartaCofre.ANIVERSARIO_SEGURO);
        cartas.add(CartaCofre.PAGAR_HOSPITAL);
        cartas.add(CartaCofre.PAGAR_ESCOLA);
        cartas.add(CartaCofre.SERVICOS);
        cartas.add(CartaCofre.ANIVERSARIO_FUNDO);
        cartas.add(CartaCofre.SEGUNDO_LUGAR_CONCURSO);
        cartas.add(CartaCofre.HERDAO);
        cartas.add(CartaCofre.REPAROS_RUA);
    }

    @Override
    public void cartacofre(Player jogadorAtual, Player[] jogadores, Scanner scanner) {
        CartaCofre carta = cartacofre();
        if (carta != null) {
            System.out.println("Cofre Comunitário: " + carta.getDescricao());
            carta.executarAcao(jogadorAtual, jogadores);
        } else {
            System.out.println("Não há mais cartas de Cofre Comunitário para sortear.");
        }
    }
}
