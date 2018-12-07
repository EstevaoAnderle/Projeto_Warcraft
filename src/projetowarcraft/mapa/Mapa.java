package projetowarcraft.mapa;

import java.util.ArrayList;

/**
 * Guarda todas as posicoes dos objetos presentes no jogo
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Mapa {

    private static ArrayList<Posicao> posicoes = new ArrayList<>();

    /**
     * Acrescenta uma posicao mapa
     *
     * @param posicao - posição do objeto
     * @return a propria posicao adicionada
     */
    private static Posicao addPosicao(double x, double y) {
        Posicao posicao = new Posicao(x, y);
        Mapa.posicoes.add(posicao);
        return posicao;
    }

    /**
     * Retorna o objeto de uma posicao desejada. Se ele nao existir, cria um
     * novo.
     *
     * @param x - x que será retornado
     * @param y - y que será retornado
     * @return posicao com X,Y desejados
     */
    public static Posicao getPosicao(double x, double y) {
        for (Object p : Mapa.posicoes) {
            Posicao pos = (Posicao) p;
            if (pos.getX() == x && pos.getY() == y) {
                return pos;
            }
        }
        return Mapa.addPosicao(x, y);
    }

}
