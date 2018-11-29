package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.racas.Raca;

public class Andarilho extends Unidade {

    public Andarilho(Raca raca, Posicao posicao) {
        super("ImagemAndarilho.jpg", new Custo(170, 0, 40, 0), true, 100, 2, 10, raca, posicao, 1.0, 2);
    }

    public void revive(Objeto objeto) {

    }

}
