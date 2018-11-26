package projetowarcraft.objetos;

/**
 * Armazena o custo de um objeto e faz
 * as devidas comparações para sua criação.
 * 
 * @author Estevao Anderle, Rafael de Paula
 */
public class Custo {

    private int comida;
    private int madeira;
    private int ouro;
    private int mana;

    public Custo(int comida, int madeira, int ouro, int mana) {
        this.comida = comida;
        this.madeira = madeira;
        this.ouro = ouro;
        this.mana = mana;
    }

    /**
     * Adiciona suprimentos.
     *
     * @param comida
     * @param madeira
     * @param ouro
     * @param mana
     *
    public void adicionarSuprimentos(int comida, int madeira, int ouro, int mana) {
        this.comida = comida + comida;
        this.madeira = madeira + madeira;
        this.ouro = ouro + ouro;
        this.mana = mana + mana;
    }*/

    /**
     * Diminui todos os suprimentos.
     *
     * @param custo
     *
    public void diminuirSuprimentosTotais(Custo custo) {
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
     *
    public void diminuirSuprimentosEspecificos(int comida, int madeira, int ouro, int mana) {
        this.comida = comida - comida;
        this.madeira = madeira - madeira;
        this.ouro = ouro - ouro;
        this.mana = mana - mana;
    }*/

    //VERIFICAR SE ISSO ESTÃ� CORRETO
    public boolean compararCustos(Custo custo) {
        if (this.comida >= custo.getComida() && this.madeira >= custo.getMadeira()
                && this.ouro >= custo.getOuro() && this.mana >= custo.getMana()) {
            return false;
        }
        return true;
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
