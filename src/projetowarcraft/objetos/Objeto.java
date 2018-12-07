package projetowarcraft.objetos;

import projetowarcraft.mapa.Posicao;
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

    /**
     * Método que diminui os pontos do HP do objeto.
     *
     * @param pontos - pontos do objeto
     */
    public void recebeDano(int pontos) {
        this.hp -= pontos;
        if (this.hp < 0) {
            this.hp = 0;
        }
        this.verificaMorte();
    }

    /**
     * Restaura a vida do objeto.
     */
    public void restaurarVida() {
        this.hp = this.hpMaximo;
    }

    /**
     * Método que foi criado com o intuito de ser sobreescrito, a fim de
     * verificar se o objeto está morto ou não.
     *
     */
    public abstract void verificaMorte();

    //Getters
    /**
     * Retorna a posição do objeto.
     *
     * @return posicao
     */
    public Posicao getPosicao() {
        return posicao;
    }

    /**
     * Retorna o estado do objeto.
     *
     * @return estado
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * Retorna o HP do objeto.
     *
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * Retorna o custo do objeto.
     *
     * @return custo
     */
    public Custo getCusto() {
        return custo;
    }

    /**
     * Retorna a raça do objeto.
     *
     * @return raca
     */
    public Raca getRaca() {
        return raca;
    }

    /**
     * Retorna os pontos de ataque do objeto.
     *
     * @return pontosAtaque
     */
    public int getPontosAtaque() {
        return pontosAtaque;
    }

    /**
     * Retorna o alcance do objeto.
     *
     * @return alcance
     */
    public double getAlcance() {
        return alcance;
    }

    //Setters
    /**
     * Define o HP do objeto.
     *
     * @param hp - HP do objeto
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Define o estado do objeto.
     *
     * @param estado - estado (vivo ou morto)
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Define a raça do objeto.
     *
     * @param raca - raça do objeto
     */
    public void setRaca(Raca raca) {
        this.raca = raca;
    }

}
