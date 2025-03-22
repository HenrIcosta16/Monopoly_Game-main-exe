package itens.Interfaces;

public interface PlayerInterface {
    String getNome();

    String getCor();

    int getSaldo();

    int getPosicao();

    void setPosicao(int posicao);

    void fazerPagamento(int valor);

    void ganharDinheiro(int valor);

    boolean estaNaPrisao();

    void setNaPrisao(boolean naPrisao);

    boolean temCarta();

    void receberCarta();

    void usarCarta(); // Usa a carta

    void incrementarTentativa(); // tntv dos dados

    void resetarTentativas(); // Rst a cont de tentativas

    boolean precisaPagar(); // Vrf se o jogador precisa pagar após 3 tentativas
}
