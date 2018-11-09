package projetowarcraft.mapa;

import java.util.ArrayList;

/**
 * Guarda todas as posições dos objetos presentes no jogo
 * @author Estevão, Rafael
 */
public class Mapa {

    private ArrayList posicoes = new ArrayList<>();

    /**
     * Acrescenta uma posição no mapa
     * @param posicao 
     */
    public void addPosicao(Posicao posicao) {
        this.posicoes.add(posicao);
    }

    /**
     * Retorna um ArrayList de elemento(s) presente(s)
     * na posição indicada.
     * 
     * @param x
     * @param y
     * @return Elementos da posição indicada.
     */
    public ArrayList getPosicao(double x, double y) {
        ArrayList elementos = new ArrayList<>();
        for(Object p : this.posicoes){
            Posicao pos = (Posicao) p;
            if(pos.getX() == x && pos.getY() == y){
                elementos.add(pos);
            }
        }
        return elementos;
    }

}
