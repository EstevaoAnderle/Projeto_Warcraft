package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.unidades.Unidade;
import projetowarcraft.racas.Raca;

public class Centro extends Construcao implements Ataque {

    public Centro(Posicao posicao, Raca raca) {
        super("ImagemCentro.jpg", new Custo(0, 200, 0, 0), true, 600, 10, 8, raca, posicao);
    }

    void cria(Unidade unidade) {

    }

}
