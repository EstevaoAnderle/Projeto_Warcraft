package projetowarcraft.mapa;

import java.awt.geom.Point2D;

/**
 * Guarda a informacao da posicao (X,Y) de um objeto
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Posicao extends Point2D {

    protected double x;
    protected double y;

    public Posicao(double x, double y) {
        this.setLocation(x, y);
    }
    
    @Override
    public String toString() {
    	return "(" + this.x + ", " + this.y + ")";
    }

    /**
     * Move o objeto para o norte.
     *
     * @param velocidade
     * @return a nova posicao do objeto no mapa
     */
    public Posicao moverParaNorte(double velocidade) {
        return Mapa.getPosicao(this.x, this.y + velocidade);
    }

    /**
     * Move o objeto para o sul.
     *
     * @param velocidade
     * @return a nova posicao do objeto no mapa
     */
    public Posicao moverParaSul(double velocidade) {
        if ((getY() - velocidade) > 0) {
            return Mapa.getPosicao(this.x, this.y - velocidade);
        } else {
            System.out.println("Nao e possivel realizar essa acao.");
            return this;
        }
    }

    /**
     * Move o objeto para o leste.
     *
     * @param velocidade
     * @return a nova posicao do objeto no mapa
     */
    public Posicao moverParaLeste(double velocidade) {
        return Mapa.getPosicao(this.x + velocidade, this.y);
    }

    /**
     * Move o objeto para o oeste.
     *
     * @param velocidade
     * @return a nova posicao do objeto no mapa
     */
    public Posicao moverParaOeste(double velocidade) {
        if ((getX() - velocidade) > 0) {
            return Mapa.getPosicao(this.x - velocidade, this.y);
        } else {
        	System.out.println("Nao e possivel realizar essa acao.");
            return this;
        }
    }

    /**
     * Define a localizacao X do objeto
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Define a localizacao Y do objeto
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
