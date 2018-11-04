package projetowarcraft.objetos;

import java.awt.geom.Point2D;
import java.util.HashMap;

public abstract class Objeto {

    protected String imagem;
    protected HashMap custo;
    protected boolean estado;
    protected int hp;
    protected int pontosAtaque;
    protected double alcance;
    protected String tipo;
    protected Point2D posicao = new Point2D.Double();

    public void recebeDano(int pontos) {

    }

}
