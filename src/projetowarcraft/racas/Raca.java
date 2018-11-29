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
    private ArrayList<Unidade> unidades = new ArrayList<>();
    private ArrayList<Construcao> construcoes = new ArrayList<>();
    private boolean extinta = false;
    private char tipo;//H - Humano; O - Orc
    private int populacao;
    private int nroConstrucoes;
    private int capacidadePopulacional;

    public Raca(char tipo, Posicao posicao) {
        this.tipo = tipo;
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
    
    public char getTipo() {
    	return tipo;
    }

   
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
            if (unidade.getEstado()) {//Verifica se a unidade estÃ¡ viva
                populacao++;
            }
        }
    }

    private void numeroConstrucoes() {
        for (Construcao construcao : construcoes) {
            if (construcao.getEstado()) {//Verifica se a construÃ§Ã£o estÃ¡ em pÃ©
                nroConstrucoes++;
            }
        }
    }

    public void verificaRacaExtinta() {
        if (populacao == 0 && nroConstrucoes == 0) {
            System.out.println("A raca foi extinta.");
        }
    }
    
    /**
     * Adiciona suprimentos.
     *
     * @param comida
     * @param madeira
     * @param ouro
     * @param mana
     */
    public void adicionarSuprimentos(int comida, int madeira, int ouro, int mana) {
        this.comida = comida + comida;
        this.madeira = madeira + madeira;
        this.ouro = ouro + ouro;
        this.mana = mana + mana;
    }

    /**
     * Diminui os suprimentos da raça com base no custo
     * do objeto criado.
     *
     * @param Custo
     */
    public void diminuirSuprimentos(Custo custo) {
        this.comida = comida - comida;
        this.madeira = madeira - madeira;
        this.ouro = ouro - ouro;
        this.mana = mana - mana;
    }

    /**
     * Diminui suprimentos, podendo informar quais.
     *
     * @param comida
     * @param madeira
     * @param ouro
     * @param mana
     */
    public void diminuirSuprimentosEspecificos(int comida, int madeira, int ouro, int mana) {
        this.comida = comida - comida;
        this.madeira = madeira - madeira;
        this.ouro = ouro - ouro;
        this.mana = mana - mana;
    }
    
    public boolean calculaSuprimentos(Custo custo) {
        if (this.comida >= custo.getComida() && this.madeira >= custo.getMadeira()
                && this.ouro >= custo.getOuro() && this.mana >= custo.getMana()) {
            return false;
        }
        return true;
    }

}
