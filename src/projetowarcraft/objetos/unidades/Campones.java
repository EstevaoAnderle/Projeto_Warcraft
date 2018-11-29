package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

public class Campones extends Unidade {

    public Campones(Raca raca, Posicao posicao) {
        super("ImagemCampones.jpg", new Custo(50, 0, 0, 0), true, 50, 3, 0, raca, posicao, 2.0, 0);
    }

    public void constroi(Posicao posicao, String tipo) {

    }

    public void colhe() {

    }

    public void corte() {

    }

    public void minera() {

    }

}
