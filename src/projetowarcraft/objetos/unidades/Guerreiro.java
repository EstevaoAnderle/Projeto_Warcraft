package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

public class Guerreiro extends Unidade {

    public Guerreiro(Raca raca, Posicao posicao) {
        super("ImagemGuerreiro.jpg", new Custo(35, 0, 15, 0), true, 160, 13, 0, raca, posicao, 1.8, 2);
    }

}
