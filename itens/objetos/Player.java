package itens.objetos;

import itens.Interfaces.PlayerInterface;
import java.util.ArrayList;
import java.util.List;

public class Player implements PlayerInterface {
    String nome;
    int posicao;
    String cor;
    int saldo;
    private boolean naPrisao;
    private boolean temCarta;
    private int tentativasPrisa;
    private boolean saiaLivreDaPrisao;

    List<Propriedade> propriedadesCompradas;
    List<Ferrovia> ferroviasCompradas;
    List<ServicoPublico> servicosPublicosComprados;
    List<Go> GanhosemGo;
    List<JailJustVisiting> visitingjail;
    private List<Imposto> impostosEncontrados;
    List<IrparAprisao> irParaPrisao;
    List<FreeParking> visitaPark;

    private List<Casa> casasCompradas;
    private List<Hotel> hoteisComprados;

    public Player(String nome, int saldo, String cor, int posicao) {
        this.nome = nome;
        this.saldo = saldo;
        this.cor = cor;
        this.posicao = posicao;
        this.naPrisao = false;
        this.temCarta = false;
        this.tentativasPrisa = 0;
        this.propriedadesCompradas = new ArrayList<>();
        this.ferroviasCompradas = new ArrayList<>();
        this.servicosPublicosComprados = new ArrayList<>();
        this.irParaPrisao = new ArrayList<>();
        this.GanhosemGo = new ArrayList<>();
        this.visitingjail = new ArrayList<>();
        this.visitaPark = new ArrayList<>();

        this.casasCompradas = new ArrayList<>();
        this.hoteisComprados = new ArrayList<>();

    }

    public boolean possuiPropriedade(Propriedade propriedade) {
        return propriedadesCompradas.contains(propriedade);
    }

    public void setSaiaLivreDaPrisao(boolean status) {
        this.saiaLivreDaPrisao = status;
    }

    public List<Imposto> getImpostosEncontrados() {
        return impostosEncontrados;
    }

    public List<FreeParking> getvisitaPark() {
        return visitaPark;
    }

    public void VisitParkLivre(FreeParking parkFree) {
        visitaPark.add(parkFree);
    }

    public void MoneyGanhosemGo(Go gO) {
        GanhosemGo.add(gO);
    }

    public List<Go> getGanhosemGo() {
        return GanhosemGo;
    }

    public void adicionarImposto(Imposto imposto) {
        this.impostosEncontrados.add(imposto);
    }

    public String getNome() {
        return nome;
    }

    public int getHoteis() {
        return hoteisComprados.size();
    }

    public int getCasas() {
        return casasCompradas.size();
    }

    public void comprarHotel(Hotel hotel) {
        hoteisComprados.add(hotel);
    }

    
    public void comprarCasa(Casa casa) {
        casasCompradas.add(casa);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getPosicao() {
        return posicao;
    }

    @Override
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public void fazerPagamento(int valor) {
        saldo -= valor;
    }

    @Override
    public void ganharDinheiro(int valor) {
        saldo += valor;
    }

    public void visitandoprisa(JailJustVisiting jailjustVisiting) {
        visitingjail.add(jailjustVisiting);
    }

    public List<JailJustVisiting> getJailJustVisitings() {
        return visitingjail;
    }

    public void comprarServicoPublico(ServicoPublico servicoPublico) {
        servicosPublicosComprados.add(servicoPublico);
    }

    public List<ServicoPublico> getServicoPublico() {
        return servicosPublicosComprados;
    }

    public void comprarPropriedade(Propriedade propriedade) {
        propriedadesCompradas.add(propriedade);
    }

    public void comprarFerrovia(Ferrovia ferrovia) {
        ferroviasCompradas.add(ferrovia);
    }

    public List<Propriedade> getPropriedadesCompradas() {
        return propriedadesCompradas;
    }

    public List<Ferrovia> getFerroviasCompradas() {
        return ferroviasCompradas;
    }

    public boolean temCarta() {
        return temCarta;
    }

    public void receberCarta() {
        temCarta = true;
    }

    public void usarCarta() {
        temCarta = false;
    }

    public boolean isSaiaLivreDaPrisao() {
        return saiaLivreDaPrisao;
    }

    public void incrementarTentativa() {
        tentativasPrisa++;
    }

    public void resetarTentativas() {
        tentativasPrisa = 0;
    }

    public boolean precisaPagar() {
        return tentativasPrisa >= 3;
    }

    public boolean estaNaPrisao() {
        return naPrisao;
    }

    public void setNaPrisao(boolean naPrisao) {
        this.naPrisao = naPrisao;
    }

    public int jogaDadoEMultiplica(int fator) {
        int dado = (int) (Math.random() * 6) + 1;
        System.out.println(nome + " rolou um dado e obteve: " + dado);
        return dado * fator;
    }

    public int jogarDado() {
        return (int) (Math.random() * 6) + 1;
    }

    public boolean podeConstruirCasa(Propriedade propriedade) {
        
        return propriedade.podeConstruirCasa(this); 
    }

    public void construirCasa(Propriedade propriedade) {
       
        if (podeConstruirCasa(propriedade)) {
            propriedade.construirCasa(this);
        }
    }

    public boolean podeConstruirHotel(Propriedade propriedade) {
       
        return propriedade.podeConstruirHotel(this); 
    }

    public void construirHotel(Propriedade propriedade) {
        
        if (podeConstruirHotel(propriedade)) {
            propriedade.construirHotel(this);
        }

    }

}