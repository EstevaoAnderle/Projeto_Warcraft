package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.objetos.unidades.Campones;
import projetowarcraft.racas.Raca;

/**
 * Classe onde são tratados todos métodos da construção "Centro de cidade".
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Centro extends Construcao implements Ataque {

    public Centro(Raca raca, Posicao posicao) {
        super("ImagemCentro.jpg", new Custo(0, 200, 0, 0), true, 600, raca, posicao, 10, 8);
    }

    /**
     * Cria camponeses, verificando primeiramente se a construção está em pé e
     * após, verificando se há recursos.
     */
    public void criaCampones() {
        Campones unidade = new Campones(raca, posicao);
        this.cria(unidade);
    }

    @Override
    public void atacar(Objeto alvo) {
        this.atacar(this, alvo);
    }

}
