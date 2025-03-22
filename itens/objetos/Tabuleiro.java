package itens.objetos;

import itens.Interfaces.TabuleiroInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabuleiro implements TabuleiroInterface {
    private static final int LUGARES = 40;
    private static final int INICIO = 0;
    private static final int FIM = LUGARES - 1;

    private Map<Integer, Lugar> lugares = new HashMap<>();
    private static List<Player> listaDeJogadores = new ArrayList<>();

    public Tabuleiro() {
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        lugares.put(0, new Go("Go", "1"));
        lugares.put(1, new Propriedade("Mediterranean Avenue", "2", 60, 2));
        lugares.put(2, new Propriedade("Hotel Favela Recife", "3", 200, 20));
        lugares.put(3, new Propriedade("Baltic Avenue", "4", 60, 4));
        lugares.put(4, new ImpostoDeRenda("Income Tax", "5", 200));
        lugares.put(5, new Ferrovia("Reading Railroad", "6", 200));
        lugares.put(6, new Propriedade("Oriental Avenue", "7", 100, 6));
        lugares.put(7, new Propriedade("Copacabana Palace", "8", 500, 50));
        lugares.put(8, new Propriedade("Vermont Avenue", "9", 100, 6));
        lugares.put(9, new Propriedade("Connecticut Avenue", "10", 120, 8));
        lugares.put(10, new JailJustVisiting("Jail - Just Visiting", "11"));
        lugares.put(11, new Propriedade("St. Charles Place", "12", 140, 10));
        lugares.put(12, new ServicoPublico("Electric Company", "13", 150, 0));
        lugares.put(13, new Propriedade("States Avenue", "14", 140, 10));
        lugares.put(14, new Propriedade("Virginia Avenue", "15", 160, 12));
        lugares.put(15, new Ferrovia("Pennsylvania Railroad", "16", 200));
        lugares.put(16, new Propriedade("St. James Place", "17", 180, 14));
        lugares.put(17, new Propriedade("Hotel Favela Rocinha", "18", 200, 20));
        lugares.put(18, new Propriedade("Tennessee Avenue", "19", 180, 14));
        lugares.put(19, new Propriedade("New York Avenue", "20", 200, 16));
        lugares.put(20, new FreeParking("Free Parking", "21"));
        lugares.put(30, new IrparAprisao("Go to Jail", "31", 0, 0));
        lugares.put(38, new ImpostoDeRiqueza("Luxury Tax", "39", 75));
        lugares.put(39, new Propriedade("Board Work", "40", 400, 50));
    }

    public static List<Player> getJogadores() {
        return listaDeJogadores;
    }

    @Override
    public Lugar getLugar(int posicao) {
        return lugares.get(posicao);
    }

    @Override
    public int getLugarSeguinte(int posicao) {
        return posicao == FIM ? INICIO : posicao + 1;
    }
}