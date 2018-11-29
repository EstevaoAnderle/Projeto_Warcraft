package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

public class Grifo extends Unidade {

    public Grifo(Raca raca, Posicao posicao) {
        super("ImagemGrifo.jpg", new Custo(200, 0, 40, 0), true, 300, 20, 7, raca, posicao, 4.0, 7);
    }

    //@Override
    //atacar;
}
