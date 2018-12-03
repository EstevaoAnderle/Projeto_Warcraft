package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.objetos.unidades.Campones;
import projetowarcraft.racas.Raca;

public class Centro extends Construcao implements Ataque {

    public Centro(Raca raca, Posicao posicao) {
        super("ImagemCentro.jpg", new Custo(0, 200, 0, 0), true, 600, raca, posicao, 10, 8);
    }

    public void criaCampones() {
    	Campones unidade = new Campones(raca, posicao); 
        this.cria(unidade);
    }
    
    @Override
    public void atacar(Objeto alvo) {
    	this.atacar(this, alvo);
    }

}
