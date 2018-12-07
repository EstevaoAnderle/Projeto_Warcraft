package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.racas.Raca;

/**
 * Classe onde são tratados todos métodos da construção "Torre".
 *
 * @author Estevao Anderle, Rafael de Paula
 */
public class Torre extends Construcao implements Ataque {

    public Torre(Raca raca, Posicao posicao) {
        super("ImagemTorre.jpg", new Custo(0, 70, 0, 0), true, 200, raca, posicao, 20, 7);
    }

    @Override
    public void atacar(Objeto alvo) {
        this.atacar(this, alvo);
    }
}
