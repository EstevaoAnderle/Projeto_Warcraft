package projetowarcraft.objetos.unidades;

import java.util.ArrayList;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.racas.Raca;

public class Grifo extends Unidade {

    public Grifo(Raca raca, Posicao posicao) {
        super("ImagemGrifo.jpg", new Custo(200, 0, 40, 0), true, 300, 20, 7, raca, posicao, 4.0, 7);
    }

    @Override
    public void atacar(Objeto alvo) {
    	ArrayList<Unidade> unidades = alvo.getRaca().getUnidades();
    	Unidade alvoProximo;
    	for(int i = 0; i < unidades.size(); i++) {
    		alvoProximo = unidades.get(i);
    		double distancia = alvo.getPosicao().distance(alvoProximo.getPosicao());
    		if(!alvoProximo.equals(alvo) && distancia <= 3) {
    			super.atacar(alvoProximo);
    		}
    	}
    	//TODO: verificar se deve danificar as construções próximas a 3m também
    	super.atacar(alvo);
    }
}
