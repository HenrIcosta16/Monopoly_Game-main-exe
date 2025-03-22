package itens.objetos;

import java.util.Scanner;

public enum TipoDeCartaSorte {

    AVANCE_PONTO_PARTIDA("Avance para o Ponto de Partida. Receba $200.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.ganharDinheiro(200);
            jogadorAtual.setPosicao(0); 
        }
    },

    AVANCE_ILLOINOIS("Avance para Illinois Avenue. O jogador não recebe $200 se passar pelo Ponto de Partida.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.setPosicao(24);
        }
    },

    AVANCE_ST_CHARLES("Avance para St. Charles Place. Se passar pelo ponto de partida receba $200.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.setPosicao(11);
           
            if (jogadorAtual.getPosicao() < 11) {
                jogadorAtual.ganharDinheiro(200);
            }
        }
    },

    AVANCE_SERVICO_PUBLICO(
            "Avance o peão para o serviço público mais próximo. Se não tiver dono, você pode comprá-lo do banco. Se tiver, lance os dados e pague ao dono 10 vezes o resultado do lançamento.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            Tabuleiro tabuleiro = (Tabuleiro) args[0];
            Scanner scanner = (Scanner) args[1];

            int posicaoAtual = jogadorAtual.getPosicao();
            int novaPosicao = (posicaoAtual < 12 || posicaoAtual > 28) ? 12 : 28;
            jogadorAtual.setPosicao(novaPosicao);

            ServicoPublico servico = (ServicoPublico) tabuleiro.getLugar(novaPosicao);
            if (servico.getDono() == null) {
                servico.Acao(jogadorAtual, tabuleiro.getJogadores().toArray(new Player[0]), scanner);
            } else {
                int dado = jogadorAtual.jogarDado();
                int pagamento = dado * 10;
                jogadorAtual.fazerPagamento(pagamento);
                servico.getDono().ganharDinheiro(pagamento);
                System.out.println(
                        jogadorAtual.getNome() + " pagou " + pagamento + " para " + servico.getDono().getNome() + ".");
            }
        }
    },

    AVANCE_FERROVIA(
            "Avance o peão para a ferrovia mais próxima. Pague ao dono duas vezes o valor que ele deveria receber normalmente.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            Tabuleiro tabuleiro = (Tabuleiro) args[0];
            Scanner scanner = (Scanner) args[1];

            int posicaoAtual = jogadorAtual.getPosicao();
            int novaPosicao;
            if (posicaoAtual < 5 || (posicaoAtual > 35 && posicaoAtual <= 39)) {
                novaPosicao = 5;
            } else if (posicaoAtual < 15) {
                novaPosicao = 15;
            } else if (posicaoAtual < 25) {
                novaPosicao = 25;
            } else {
                novaPosicao = 35;
            }
            jogadorAtual.setPosicao(novaPosicao);

            Ferrovia ferrovia = (Ferrovia) tabuleiro.getLugar(novaPosicao);
            ferrovia.Acao(jogadorAtual, tabuleiro.getJogadores().toArray(new Player[0]), scanner);
        }
    },

    DIVIDENDOS("O banco lhe pagou dividendos de $50.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.ganharDinheiro(50);
        }
    },

    VOLTE_3_ESPACOS("Volte 3 espaços.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            int novaPosicao = jogadorAtual.getPosicao() - 3;
            if (novaPosicao < 0)
                novaPosicao = 0;
            jogadorAtual.setPosicao(novaPosicao);
        }
    },

    VAI_PARA_PRISAO("Vá diretamente para a Prisão. Não passe pelo Ponto de Partida, não receba $200.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.setPosicao(30); 
            jogadorAtual.setNaPrisao(true);
        }
    },

    MANUTENCAO_PROPRIEDADES(
            "Faça a manutenção de todas as suas propriedades. Para cada casa pague $25, para cada hotel $10.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            int casas = jogadorAtual.getCasas();
            int hoteis = jogadorAtual.getHoteis();
            int totalPagamento = casas * 25 + hoteis * 10;
            jogadorAtual.fazerPagamento(totalPagamento);
            System.out.println(
                    jogadorAtual.getNome() + " pagou " + totalPagamento + " pela manutenção das propriedades.");
        }
    },

    IMPOSTO_DE_POBREZA("Pague imposto de pobreza de $15.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.fazerPagamento(15);
        }
    },

    GET_OUT_OF_JAIL_FREE("Esta carta pode ser mantida até seu uso ou venda. 'Get Out Of Jail Free'.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.setSaiaLivreDaPrisao(true);
        }
    },

    LEITURA("Dê uma volta na Reading. Se você passar pelo Ponto de Partida, receba $200.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.setPosicao(5); 
            if (jogadorAtual.getPosicao() < 5) {
                jogadorAtual.ganharDinheiro(200);
            }
        }
    },

    CAMINHADA_BOARDWALK("Dê uma caminhada no Board Walk. Avance o peão para Board Walk.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.setPosicao(39); 
        }
    },

    PRESIDENTE_TABULEIRO("Você foi eleito presidente do tabuleiro. Pague $50 para cada jogador.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            Tabuleiro tabuleiro = (Tabuleiro) args[0];
            for (Player jogador : tabuleiro.getJogadores()) {
                if (!jogador.equals(jogadorAtual)) {
                    jogadorAtual.fazerPagamento(50);
                }
            }
        }
    },

    ANIVERSARIO_EMPRESTIMOS("Seus empréstimos e investimento fizeram aniversário. Receba $150.") {
        @Override
        public void executarAcao(Player jogadorAtual, Object... args) {
            jogadorAtual.ganharDinheiro(150);
        }
    };

    private final String descricao;

    TipoDeCartaSorte(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
 
    public abstract void executarAcao(Player jogadorAtual, Object... args);
}