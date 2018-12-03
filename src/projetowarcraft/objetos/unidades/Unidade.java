package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.racas.Raca;

public abstract class Unidade extends Objeto implements Ataque {

    private double velocidade;
    private int armadura;

    public Unidade(String imagem, Custo custo, boolean estado, int hp,
            int pontosAtaque, double alcance, Raca raca, Posicao posicao,
            double velocidade, int armadura) {
        super(imagem, custo, estado, hp, raca, posicao, pontosAtaque, alcance);
        this.velocidade = velocidade;
        this.armadura = armadura;
    }

    /**
     * Move a unidade conforme direcao informada,
     * levando em consideração velocidade da mesma.
     *
     */
    public void mover(String direcao) {

        if (estado) {
            switch (direcao.toLowerCase()) {
                case "norte":
                    posicao = posicao.moverParaNorte(velocidade);
                    break;
                case "sul":
                    posicao = posicao.moverParaSul(velocidade);
                    break;
                case "leste":
                    posicao = posicao.moverParaLeste(velocidade);
                    break;
                case "oeste":
                    posicao = posicao.moverParaOeste(velocidade);
                    break;
                default:
                    System.out.println("Verifica a opcao informada.");
                    break;
            }
        } else {
            System.out.println("Voce esta tentando mover algo que esta morto.");
        }

    }
    
    @Override
    public void verificaMorte() {
    	if(this.hp <= 0) {
    		raca.removerUnidade(this);
    	}
    }
    
    @Override
    public void atacar(Objeto alvo) {
    	this.atacar(this, alvo);
    }
    
    @Override
    public void recebeDano(int pontos) {
    	pontos -= this.armadura;
    	super.recebeDano(pontos);
    }
    
    public int getArmadura() {
    	return this.armadura;
    }


}
