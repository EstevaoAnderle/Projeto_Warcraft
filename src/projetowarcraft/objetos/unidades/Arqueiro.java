package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

public class Arqueiro extends Unidade implements Ataque {

    public Arqueiro(Raca raca, Posicao posicao) {
        super("ImagemArqueiro.jpg", new Custo(40, 0, 20, 0), true, 45, 5, 7, raca, posicao, 2.0, 0);
    }

}
