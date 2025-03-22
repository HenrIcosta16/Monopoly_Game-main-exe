package itens.objetos;

public abstract class Habitacao {
    protected int preco;
    protected boolean temHotel = false;
    protected int casas = 0;

    public abstract void construir(Player jogador);

    public abstract boolean podeConstruir(Player jogador);

    public abstract boolean podeConstruirHotel(Player jogador);

    public abstract void construirHotel(Player jogador);

    public abstract int getCasas();

    public abstract boolean temHotel();

    public abstract void removerCasa();

    public abstract void removerHotel();

}