package projetowarcraft.mapa;

import java.awt.geom.Point2D;

/**
 * Guarda a informação da posição (X,Y) de um objeto
 *
 * @author Estevão, Rafael
 */
public class Posicao extends Point2D {

    protected double x;
    protected double y;

    public Posicao(double x, double y) {
        this.setLocation(x, y);
    }

    public void moverParaNorte(double velocidade) {
        setY(y + velocidade);
    }

    public void moverParaSul(double velocidade) {
        if ((getY() - velocidade) > 0) {
            setY(y - velocidade);
        } else {
            System.out.println("Não é possível realizar essa ação.");
        }
    }

    public void moverParaLeste(double velocidade) {
        setX(x + velocidade);
    }

    public void moverParaOeste(double velocidade) {
        if ((getX() - velocidade) > 0) {
            setX(x - velocidade);
        } else {
            System.out.println("Não é possível realizar essa ação.");
        }
    }

    /**
     * Define a localização X do objeto
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Define a localização Y do objeto
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
