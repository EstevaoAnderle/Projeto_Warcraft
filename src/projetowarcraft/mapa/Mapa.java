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
     * @return a própria posição adicionada
     */
    private Posicao addPosicao(double x, double y) {
        Posicao posicao = new Posicao(x, y);
        this.posicoes.add(posicao);
        return posicao;
    }

    /**
     * Retorna o objeto de uma posição desejada. Se ele não existir,
     * cria um novo.
     * 
     * @param x
     * @param y
     * @return posição com X,Y desejados
     */
    public Posicao getPosicao(double x, double y) {
        for(Object p : this.posicoes){
            Posicao pos = (Posicao) p;
            if(pos.getX() == x && pos.getY() == y){
                return pos;
            }
        }
        return this.addPosicao(x, y);
    }

}
