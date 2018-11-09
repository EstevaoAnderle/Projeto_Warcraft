package projetowarcraft.mapa;

import java.awt.geom.Point2D;

/**
 * Guarda a informação da posição (X,Y) de um objeto
 * @author Estevão, Rafael
 */
public class Posicao extends Point2D {

    protected double x;
    protected double y;
    
    public Posicao(double x, double y){
        this.setLocation(x, y);
    }
    
    /**
     * Define a localização X do objeto
     * @param x
     */
    public void setX(double x){
        this.x = x;
    }
    
    /**
     * Define a localização Y do objeto
     * @param y 
     */
    public void setY(double y){
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
