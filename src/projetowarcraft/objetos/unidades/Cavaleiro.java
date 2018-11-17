package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

public class Cavaleiro extends Unidade implements Ataque {

    public Cavaleiro(Raca raca, Posicao posicao) {
        super("ImagemCavaleiro.jpg", new Custo(70, 0, 80, 0), true, 180, 12, 0, raca, posicao, 4.0, 3);
    }

}
