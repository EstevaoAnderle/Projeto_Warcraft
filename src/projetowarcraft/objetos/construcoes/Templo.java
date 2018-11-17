package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

public class Templo extends Construcao {

    public Templo(Raca raca, Posicao posicao) {
        super("ImagemTemplo.jpg", new Custo(0, 250, 0, 0), true, 350, 0, 0, raca, posicao);
    }

    public void cria(String tipo) {

    }

}
