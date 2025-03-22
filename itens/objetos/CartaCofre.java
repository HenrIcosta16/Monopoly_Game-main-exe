package itens.objetos;

public enum CartaCofre {

    AVANCE_PONTO_PARTIDA("Avance para o Ponto de Partida (Go). Receba $200.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.ganharDinheiro(200);
            jogadorAtual.setPosicao(0);
        }
    },

    ERRO_BANCO("Erro do banco em seu favor. Receba $200.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.ganharDinheiro(200);
        }
    },

    TAXA_MEDICO("Taxa do médico. Pague $50.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.fazerPagamento(50);
        }
    },

    ABERTURA_OPERA("Abertura da Grande Ópera. Receba $50 de cada jogador pelas entradas.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            for (Player jogador : jogadores) {
                if (!jogador.equals(jogadorAtual)) {
                    jogadorAtual.ganharDinheiro(50);
                }
            }
        }
    },

    LIQUIDACAO_ESTOQUE("Da liquidação fora de estoque. Receba $45.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.ganharDinheiro(45);
        }
    },

    SAIA_LIVRE_PRISAO("Saia livre da prisão, sem pagar. Esta carta pode ser mantida até o uso ou venda.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.setSaiaLivreDaPrisao(true);
        }
    },

    VAI_PARA_PRISAO("Vá para a prisão. Vá direto para a prisão.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.setNaPrisao(true);
            jogadorAtual.setPosicao(30);
        }
    },

    RESTITUICAO_IMPOSTO("Restituição do Imposto de Renda. Receba $20.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.ganharDinheiro(20);
        }
    },

    ANIVERSARIO_SEGURO("Aniversário do seguro de vida. Receba $100.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.ganharDinheiro(100);
        }
    },

    PAGAR_HOSPITAL("Pague o hospital. Pague $100.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.fazerPagamento(100);
        }
    },

    PAGAR_ESCOLA("Pague taxa da escola. Pague $150.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.fazerPagamento(150);
        }
    },

    SERVICOS("Receba por seus serviços. Receba $25.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.ganharDinheiro(25);
        }
    },

    ANIVERSARIO_FUNDO("Aniversário dos fundos de Natal. Receba $100.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.ganharDinheiro(100);
        }
    },

    SEGUNDO_LUGAR_CONCURSO("Você tirou o segundo lugar no concurso de beleza. Receba $10.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.ganharDinheiro(10);
        }
    },

    HERDAO("Você herdou. Receba $100.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            jogadorAtual.ganharDinheiro(100);
        }
    },

    REPAROS_RUA("Você deve pagar os reparos da rua. Pague $40 por cada casa, $115 por hotel.") {
        @Override
        public void executarAcao(Player jogadorAtual, Player[] jogadores) {
            int custo = 40 * jogadorAtual.getCasas() + 115 * jogadorAtual.getHoteis();
            jogadorAtual.fazerPagamento(custo);
        }
    };

    private final String descricao;

    CartaCofre(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void executarAcao(Player jogadorAtual, Player[] jogadores);
}
