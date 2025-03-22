package itens.objetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class PilhaDeSorte {

    protected List<TipoDeCartaSorte> cartas;
    protected boolean reves; 

    public PilhaDeSorte(boolean reves) {
        this.reves = reves;
        cartas = new ArrayList<>();
        inicializarCartas();
    }

    protected abstract void inicializarCartas();

    public void embaralharCartas() {
        Collections.shuffle(cartas);
    }

    public TipoDeCartaSorte sortearCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }

    public boolean isReves() {
        return reves;
    }

    public abstract void sortearCarta(Player jogadorAtual, Player[] jogadores, Scanner scanner);
}
