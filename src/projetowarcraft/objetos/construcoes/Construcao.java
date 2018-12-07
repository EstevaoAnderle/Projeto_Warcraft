package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.objetos.unidades.Unidade;
import projetowarcraft.racas.Raca;

/**
 * Classe onde são tratados todos métodos das construções.
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public abstract class Construcao extends Objeto {

    public Construcao(String imagem, Custo custo, boolean estado, int hp, Raca raca, Posicao posicao) {
        super(imagem, custo, estado, hp, raca, posicao);
    }

    public Construcao(String imagem, Custo custo, boolean estado, int hp, Raca raca, Posicao posicao,
            int pontosAtaque, double alcance) {
        super(imagem, custo, estado, hp, raca, posicao, pontosAtaque, alcance);
    }

    /**
     * Método que verifica se o objeto pode criar unidade e realiza a criação
     * (se possível).
     *
     * @param unidade - unidade que será criada
     */
    protected void cria(Unidade unidade) {

        if (!raca.podeCriar(unidade)) {
            return;
        }
        if (!estado) {
            System.out.println("Essa construcao já está destruída.");
            return;
        }

        raca.adicionarUnidade(unidade);
        System.out.println("Unidade criada.");

    }

    @Override
    public void verificaMorte() {
        if (this.hp <= 0) {
            raca.removerConstrucao(this);
        }
    }

}
