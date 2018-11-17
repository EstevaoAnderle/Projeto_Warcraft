package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.racas.Raca;

public abstract class Construcao extends Objeto {

    public Construcao(String imagem, Custo custo, boolean estado, int hp, int pontosAtaque, double alcance, Raca raca, Posicao posicao) {
        super(imagem, custo, estado, hp, pontosAtaque, alcance, raca, posicao);
    }

}
