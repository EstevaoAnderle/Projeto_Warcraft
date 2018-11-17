/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetowarcraft.objetos;

/**
 *
 * @author estev
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

    public void adicionarSuprimentos(int comida, int madeira, int ouro, int mana) {
        this.comida = comida + comida;
        this.madeira = madeira + madeira;
        this.ouro = ouro + ouro;
        this.mana = mana + mana;
    }

    public void diminuirSuprimentosTotais(Custo custo) {
        this.comida = comida - comida;
        this.madeira = madeira - madeira;
        this.ouro = ouro - ouro;
        this.mana = mana - mana;
    }

    public void diminuirSuprimentosEspecíficos(int comida, int madeira, int ouro, int mana) {
        this.comida = comida - comida;
        this.madeira = madeira - madeira;
        this.ouro = ouro - ouro;
        this.mana = mana - mana;
    }

    //Verificar se isso está correto
    public boolean compararCustos(Custo custo) {
        if (this.comida >= custo.getComida() && this.madeira >= custo.getMadeira()
                && this.ouro >= custo.getOuro() && this.ouro >= custo.getOuro()) {
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
