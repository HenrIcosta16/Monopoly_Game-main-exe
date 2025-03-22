package itens.objetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class PilhaDeCofre {

    protected List<CartaCofre> cartas;

    public PilhaDeCofre() {
        cartas = new ArrayList<>();
        inicializarCartas();
    }

    protected abstract void inicializarCartas();

    public void embaralharCartas() {
        Collections.shuffle(cartas);
    }

    public CartaCofre cartacofre() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }

    public abstract void cartacofre(Player jogadorAtual, Player[] jogadores, Scanner scanner);
}
