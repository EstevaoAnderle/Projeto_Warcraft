package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

public class Casa extends Construcao {

    public Casa(Raca raca, Posicao posicao) {
        super("ImagemCasa.jpg", new Custo(0, 30, 0, 0), true, 75, raca, posicao);
    }

}
