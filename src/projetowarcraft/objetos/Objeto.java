package projetowarcraft.objetos;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.unidades.Unidade;
import projetowarcraft.racas.Raca;

public abstract class Objeto {

    protected String imagem;
    protected Custo custo;
    protected boolean estado;
    protected int hp;
    protected int hpMaximo;
    protected Posicao posicao;
    
    protected Raca raca;
    protected int pontosAtaque;
    protected double alcance;

    public Objeto(String imagem, Custo custo, boolean estado, int hp, 
    		Raca raca, Posicao posicao) {
        this.imagem = imagem;
        this.custo = custo;
        this.estado = estado;
        this.hp = hp;
        this.hpMaximo = hp;
        this.raca = raca;
        this.posicao = posicao;
    }
    
    public Objeto(String imagem, Custo custo, boolean estado, int hp, 
    		Raca raca, Posicao posicao, int pontosAtaque, double alcance) {
        this.imagem = imagem;
        this.custo = custo;
        this.estado = estado;
        this.hp = hp;
        this.raca = raca;
        this.posicao = posicao;
        this.pontosAtaque = pontosAtaque;
        this.alcance = alcance;
    }
    
    @Override
    public String toString() {
    	String ret = "[" + this.raca.getTipo() + "] ";
    	ret += this.getClass().getSimpleName();
    	ret += " (HP " + this.hp + ")";
    	ret += " em " + posicao.toString();
    	return ret;
    }

    public void recebeDano(int pontos) {
    	this.hp -= pontos;
    	if(this.hp < 0)
    		this.hp = 0;
    	this.verificaMorte();
    }
    
    public void restaurarVida() {
    	this.hp = this.hpMaximo;
    }
    
    public abstract void verificaMorte();

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

    public Custo getCusto() {
        return custo;
    }

    public Raca getRaca() {
        return raca;
    }
    
    public int getPontosAtaque() {
    	return pontosAtaque;
    }
    
    public double getAlcance() {
    	return alcance;
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
