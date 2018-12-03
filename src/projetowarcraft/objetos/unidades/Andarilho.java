package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.racas.Raca;

public class Andarilho extends Unidade {

    public Andarilho(Raca raca, Posicao posicao) {
        super("ImagemAndarilho.jpg", new Custo(170, 0, 40, 0), true, 100, 2, 10, raca, posicao, 1.0, 2);
    }

    public void revive(Unidade objeto) {
    	if(!estado) {
    		System.out.println("Este andarilho ja esta morto.");
    		return;
    	}
    	if(raca.getMana() < 5) {
    		System.out.println("Nao ha mana suficiente!");
    		return;
    	}
    	double distancia = this.getPosicao().distance(objeto.getPosicao());
    	if(distancia > 10) {
    		System.out.println("O alvo esta muito distante para ser curado!");
    		return;
    	}
    	if(!objeto.getEstado()) {
	    	objeto.restaurarVida();
	    	objeto.setEstado(true);
	    	objeto.getRaca().reviverUnidade(objeto);
    	}
    	raca.diminuirSuprimentosEspecificos(0, 0, 0, 5);
    }

}
