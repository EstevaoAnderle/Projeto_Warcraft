package projetowarcraft.objetos;

/**
 * Armazena o custo de um objeto e faz
 * as devidas comparações para sua criação.
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
    public int getComida() {
        return comida;
    }

    public int getMadeira() {
        return madeira;
    }

    public int getOuro() {
        return ouro;
    }

    public int getMana() {
        return mana;
    }

}
