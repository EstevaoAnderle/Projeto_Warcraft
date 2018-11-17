package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

public class Torre extends Construcao implements Ataque {

    public Torre(Raca raca, Posicao posicao) {
        super("ImagemTorre.jpg", new Custo(0, 70, 0, 0), true, 200, 20, 7, raca, posicao);
    }

}
