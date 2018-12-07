package projetowarcraft.racas;

import java.util.ArrayList;
import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.construcoes.Casa;
import projetowarcraft.objetos.construcoes.Centro;
import projetowarcraft.objetos.construcoes.Construcao;
import projetowarcraft.objetos.unidades.Campones;
import projetowarcraft.objetos.unidades.Unidade;

/**
 * Classe onde está definido todos métodos e atributos que serão utilizados
 * pelas racas.
 *
 * @author Estevao Anderle, Rafael de Paula
 */
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
    private int capacidadePopulacional;

    public Raca(char tipo, Posicao posicao, int comida, int madeira, int ouro, int mana) {
        this.tipo = tipo;
        adicionarConstrucao(new Centro(this, posicao));
        adicionarUnidade(new Campones(this, posicao));
        adicionarUnidade(new Campones(this, posicao));
        adicionarUnidade(new Campones(this, posicao));
        adicionarUnidade(new Campones(this, posicao));
        adicionarUnidade(new Campones(this, posicao));
        this.adicionarSuprimentos(comida, madeira, ouro, mana);
        this.calculaCapacidadePopulacional();
    }

    /**
     * Retorna unidades.
     *
     * @return unidades
     */
    public ArrayList<Unidade> getUnidades() {
        return unidades;
    }

    /**
     * Retorna construcoes.
     *
     * @return construcoes
     */
    public ArrayList<Construcao> getConstrucoes() {
        return construcoes;
    }

    /**
     * Adiciona novas unidades, acrescendo na população e diminuindo os
     * suprimentos.
     *
     * @param unidade - unidade que será adicionada.
     */
    public void adicionarUnidade(Unidade unidade) {
        unidades.add(unidade);
        this.populacao += 1;
        this.diminuirSuprimentos(unidade.getCusto());
    }

    /**
     * Revive unidades.
     *
     * @param unidade - unidade que será revivida.
     */
    public void reviverUnidade(Unidade unidade) {
        unidades.add(unidade);
        this.populacao += 1;
    }

    /**
     * Remove unidades caso a mesma esteja morta e verifica se a raça está
     * extinta.
     *
     * @param unidade - unidade que será removida.
     */
    public void removerUnidade(Unidade unidade) {
        unidades.remove(unidade);
        this.populacao -= 1;
        this.verificaExtinta();
    }

    /**
     * Adiciona novas construções, diminuindo os suprimentos e calculando a
     * capacidade da população.
     *
     * @param construcao - construcao que será adicionada.
     */
    public void adicionarConstrucao(Construcao construcao) {
        construcoes.add(construcao);
        this.diminuirSuprimentos(construcao.getCusto());
        this.calculaCapacidadePopulacional();
    }

    /**
     * Remove a construção caso a mesma esteja destruída. Após, recalcula a
     * capacidade populacional e verifica se a raça está extinta.
     *
     * @param construcao
     */
    public void removerConstrucao(Construcao construcao) {
        construcoes.remove(construcao);
        this.calculaCapacidadePopulacional();
        this.verificaExtinta();
    }

    /**
     * Verifica se a raça está extinta.
     */
    public void verificaExtinta() {
        if (construcoes.size() == 0 && populacao == 0) {
            this.extinguirRaca();
        }
    }

    /**
     * Método que faz com que uma raça seja extinta.
     */
    private void extinguirRaca() {
        this.extinta = true;
        String raca;
        if (this.tipo == 'H') {
            raca = "humana";
        } else {
            raca = "orc";
        }
        System.out.println("A raça " + raca + " foi extinta!");
    }

    /**
     * Calcula a quantidade total de pessoas que podem ser criadas em uma raça.
     */
    private void calculaCapacidadePopulacional() {
        int capacidade = 0;
        for (Construcao construcao : construcoes) {
            if (construcao.getEstado()) {
                if (construcao instanceof Casa) {
                    capacidade = capacidade + 2;
                } else if (construcao instanceof Centro) {
                    capacidade = capacidade + 10;
                }
            }
        }
        this.capacidadePopulacional = capacidade;
    }

    /**
     * Verifica se a raça está extinta e se pode criar novas unidades. Após,
     * verifica se há espaço para novas unidades. Também, verifica se há recusos
     * suficientes para tal criação.
     *
     * @param unidade - unidade que será criada.
     * @return
     */
    public boolean podeCriar(Unidade unidade) {
        if (this.getExtinta()) {
            System.out.println("Esta raca esta extinta e nao pode criar unidades.");
            return false;
        }
        if (populacao >= capacidadePopulacional) {
            System.out.println("A quantidade maxima da populacao foi atingida.");
            return false;
        }
        if (!this.calculaSuprimentos(unidade.getCusto())) {
            System.out.println("Recursos nao sao suficientes!");
            return false;

        }
        return true;
    }

    /**
     * Verifica se é possível construir uma nova construção, verificando se a
     * raça está extinta e se há recursos suficientes.
     *
     * @param construcao
     * @return
     */
    public boolean podeConstruir(Construcao construcao) {
        if (this.getExtinta()) {
            System.out.println("Esta raca esta extinta e nao pode construir.");
            return false;
        }
        if (!this.calculaSuprimentos(construcao.getCusto())) {
            System.out.println("Recursos nao sao suficientes!");
            return false;
        }
        return true;
    }

    /**
     * Adiciona suprimentos.
     *
     * @param comida - adiciona comida
     * @param madeira - adiciona madeira
     * @param ouro - adiciona ouro
     * @param mana - adiciona mana
     */
    public void adicionarSuprimentos(int comida, int madeira, int ouro, int mana) {
        this.comida += comida;
        this.madeira += madeira;
        this.ouro += ouro;
        this.mana += mana;
    }

    /**
     * Diminui os suprimentos da raça com base no custo do objeto criado.
     *
     * @param custo - custo que será diminuido
     */
    public void diminuirSuprimentos(Custo custo) {
        this.comida -= custo.getComida();
        this.madeira -= custo.getMadeira();
        this.ouro -= custo.getOuro();
        this.mana -= custo.getMana();
    }

    /**
     * Diminui suprimentos, podendo informar quais.
     *
     * @param comida - quantidade de comida que será diminuida
     * @param madeira - quantidade de madeira que será diminuida
     * @param ouro - quantidade de ouro que será diminuido
     * @param mana - quantidade de mana que será diminuida
     */
    public void diminuirSuprimentosEspecificos(int comida, int madeira, int ouro, int mana) {
        this.comida -= comida;
        this.madeira -= madeira;
        this.ouro -= ouro;
        this.mana -= mana;
    }

    /**
     * Calcula a quantidade de suprimentos da raça.
     *
     * @param custo - custo da raça
     * @return
     */
    public boolean calculaSuprimentos(Custo custo) {
        if (this.comida >= custo.getComida() && this.madeira >= custo.getMadeira()
                && this.ouro >= custo.getOuro() && this.mana >= custo.getMana()) {
            return true;
        }
        return false;
    }

    /**
     * Retorna a posição da unidade.
     *
     * @param posicao - posicao da unidade.
     * @return posicao
     */
    public Unidade getUnidade(int posicao) {
        return unidades.get(posicao);
    }

    /**
     * Retorna a posição da construcao.
     *
     * @param posicao - posicao da construcao.
     * @return posicao
     */
    public Construcao getConstrucao(int posicao) {
        return construcoes.get(posicao);
    }

    /**
     * Retorna a quantidade de comida da raça.
     *
     * @return comida
     */
    public int getComida() {
        return comida;
    }

    /**
     * Retorna a quantidade de madeira da raça.
     *
     * @return madeira
     */
    public int getMadeira() {
        return madeira;
    }

    /**
     * Retorna a quantidade de mana da raça.
     *
     * @return mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * Retorna a quantidade de ouro da raça.
     *
     * @return ouro
     */
    public int getOuro() {
        return ouro;
    }

    /**
     * Retorna o tipo da raça.
     *
     * @return tipo.
     */
    public char getTipo() {
        return tipo;
    }

    /**
     * Retorna se a raça está extinta ou não.
     *
     * @return extinta
     */
    public boolean getExtinta() {
        return this.extinta;
    }

    /**
     * Exibe informações da raça desejada.
     */
    public void relatorio() {
        System.out.println("###################");
        for (Unidade unidade : unidades) {
            System.out.println(unidade);
        }
        for (Construcao construcao : construcoes) {
            System.out.println(construcao);
        }
        System.out.println("###################");
    }

    /**
     * Exibe relatório total da raça.
     */
    public void status() {
        System.out.println("##########################");
        System.out.println("STATUS DE RAÇA (" + this.tipo + ")");
        System.out.println("População: " + populacao + "/" + capacidadePopulacional);
        System.out.println("Construções: " + construcoes.size());
        System.out.println("Comida: " + getComida());
        System.out.println("Madeira: " + getMadeira());
        System.out.println("Ouro: " + getOuro());
        System.out.println("Mana: " + getMana());
        System.out.println("##########################");
    }
}
