package projetowarcraft.objetos;

import java.util.HashMap;
import projetowarcraft.mapa.Posicao;
import projetowarcraft.racas.Raca;

public abstract class Objeto {

    protected String imagem;
    protected Custo custo;
    protected boolean estado;
    protected int hp;
    protected int pontosAtaque;
    protected double alcance;
    protected Raca raca;
    protected Posicao posicao;

    public Objeto(String imagem, Custo custo, boolean estado, int hp,
            int pontosAtaque, double alcance, Raca raca, Posicao posicao) {
        this.imagem = imagem;
        this.custo = custo;
        this.estado = estado;
        this.hp = hp;
        this.pontosAtaque = pontosAtaque;
        this.alcance = alcance;
        this.raca = raca;
        this.posicao = posicao;
    }

    public void recebeDano(int pontos) {

    }

    //Getters
    public Posicao getPosicao() {
        return posicao;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getHp() {
        return hp;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }

    public Custo getCusto() {
        return custo;
    }

    public Raca getRaca() {
        return raca;
    }

    //Setters
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

}
