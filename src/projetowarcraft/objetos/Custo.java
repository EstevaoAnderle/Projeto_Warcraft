package projetowarcraft.objetos;

/**
 * Armazena o custo de um objeto e faz as devidas comparações para sua criação.
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Custo {

    private int comida = 0;
    private int madeira = 0;
    private int ouro = 0;
    private int mana = 0;

    public Custo(int comida, int madeira, int ouro, int mana) {
        this.comida = comida;
        this.madeira = madeira;
        this.ouro = ouro;
        this.mana = mana;
    }

    //getters
    /**
     * Retorna a quantidade de comida disponível na raça.
     *
     * @return comida
     */
    public int getComida() {
        return comida;
    }

    /**
     * Retorna a quantidade de madeira disponível na raça.
     *
     * @return madeira
     */
    public int getMadeira() {
        return madeira;
    }

    /**
     * Retorna a quantidade de ouro disponível na raça.
     *
     * @return ouro
     */
    public int getOuro() {
        return ouro;
    }

    /**
     * Retorna a quantidade de mana disponível na raça.
     *
     * @return mana
     */
    public int getMana() {
        return mana;
    }

}
