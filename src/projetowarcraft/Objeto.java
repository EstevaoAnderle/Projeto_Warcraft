package projetowarcraft;

import java.awt.geom.Point2D;
import java.util.HashMap;

public abstract class Objeto {

    protected Point2D posicao;

    protected double posX;

    protected String imagem;

    protected HashMap custo;

    protected boolean estado;

    protected int hp;

    protected int pontosAtaque;

    protected double alcance;

    protected String tipo;

    public void recebeDano(int pontos) {

    }

}
