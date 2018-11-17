package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.racas.Raca;

public class Sacerdote extends Unidade {

    public Sacerdote(Raca raca, Posicao posicao) {
        super("ImagemSacerdote.jpg", new Custo(0, 0, 125, 0), true, 25, 0, 10, raca, posicao, 1.0, 0);
    }

    public void cura(Objeto alvo) {

    }

    public void reza() {

    }

}
