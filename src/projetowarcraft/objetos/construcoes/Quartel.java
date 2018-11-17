package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.unidades.Unidade;
import projetowarcraft.racas.Raca;

public class Quartel extends Construcao {

    public Quartel(Raca raca, Posicao posicao) {
        super("ImagemQuartel.jpg", new Custo(0, 125, 0, 0), true, 350, 0, 0, raca, posicao);
    }

    void cria(Unidade unidade) {

    }

}
