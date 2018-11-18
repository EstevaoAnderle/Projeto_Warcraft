package projetowarcraft.racas;

import java.util.ArrayList;
import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.construcoes.Casa;
import projetowarcraft.objetos.construcoes.Centro;
import projetowarcraft.objetos.construcoes.Construcao;
import projetowarcraft.objetos.unidades.Campones;
import projetowarcraft.objetos.unidades.Unidade;

public class Raca {

    private int comida;
    private int madeira;
    private int mana;
    private int ouro;
    private Custo custo;
    private Posicao posicao;
    private ArrayList<Unidade> unidades = new ArrayList<>();
    private ArrayList<Construcao> construcoes = new ArrayList<>();
    private boolean extinta = false;
    private char tipo;//H - Humano; O - Orc
    private int populacao;
    private int nroConstrucoes;
    private int capacidadePopulacional;

    public Raca(char tipo, Posicao posicao) {
        this.tipo = tipo;
        this.posicao = posicao;
        construcoes.add(new Centro(new Posicao(1, 1), this));
        unidades.add(new Campones(this, new Posicao(2, 2)));
        unidades.add(new Campones(this, new Posicao(3, 3)));
        unidades.add(new Campones(this, new Posicao(3, 3)));
        unidades.add(new Campones(this, new Posicao(3, 3)));
        unidades.add(new Campones(this, new Posicao(3, 3)));
    }

    public ArrayList<Unidade> listaUnidades() {
        return unidades;
    }

    public ArrayList<Construcao> listaConstrucoes() {
        return construcoes;
    }

    public void adicionarUnidade(Unidade unidade) {
        unidades.add(unidade);
    }

    public void adicionarConstrucao(Construcao construcao) {
        construcoes.add(construcao);
    }

    public Unidade getUnidade(int posicao) {
        return unidades.get(posicao);
    }

    public Construcao getConstrucao(int posicao) {
        return construcoes.get(posicao);
    }

    public Custo getCusto() {
        return custo;
    }

    /**
     * @return the comida
     */
    public int getComida() {
        return comida;
    }

    /**
     * @return the madeira
     */
    public int getMadeira() {
        return madeira;
    }

    /**
     * @return the mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * @return the ouro
     */
    public int getOuro() {
        return ouro;
    }

    //VERIFICAR MÉTODOS PRA ADICIONAR OS RECURSOS
    //VERIFICAR NECESSIDADE DE UM RECURSO PRA CONSUMIR MANA
    public void exibirRecursos() {
        System.out.println("Total de recursos:");
        System.out.println("Comida: " + getComida());
        System.out.println("Madeira: " + getMadeira());
        System.out.println("Mana: " + getMana());
        System.out.println("Ouro: " + getOuro());
    }

    private int calculaCapacidadePopulacional() {
        for (Construcao construcao : construcoes) {
            if (construcao.getEstado()) {
                if (construcao instanceof Casa) {
                    capacidadePopulacional = capacidadePopulacional + 2;
                } else if (construcao instanceof Centro) {
                    capacidadePopulacional = capacidadePopulacional + 10;
                }
            }
        }
        return capacidadePopulacional;
    }

    public boolean podeCriar() {
        return populacao < capacidadePopulacional;
    }

    private void numeroUnidades() {
        for (Unidade unidade : unidades) {
            if (unidade.getEstado()) {//Verifica se a unidade está viva
                populacao++;
            }
        }
    }

    private void numeroConstrucoes() {
        for (Construcao construcao : construcoes) {
            if (construcao.getEstado()) {//Verifica se a construção está em pé
                nroConstrucoes++;
            }
        }
    }

    public void verificaRacaExtinta() {
        if (populacao == 0 && nroConstrucoes == 0) {
            System.out.println("A raça foi extinta.");
        }
    }

}
