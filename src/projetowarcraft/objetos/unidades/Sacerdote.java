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
    	if(!estado) {
    		System.out.println("Este sacerdote ja esta morto.");
    		return;
    	}
    	if(raca.getMana() < 5) {
    		System.out.println("Nao ha mana suficiente!");
    		return;
    	}
    	double distancia = this.getPosicao().distance(alvo.getPosicao());
    	if(distancia > 10) {
    		System.out.println("O alvo esta muito distante para ser curado!");
    		return;
    	}
    	alvo.restaurarVida();
    	raca.diminuirSuprimentosEspecificos(0, 0, 0, 5);
    }

    public void reza() {
    	if(estado)
    		raca.adicionarSuprimentos(0, 0, 0, 5);
    	else
    		System.out.println("Este sacerdote ja esta morto.");
    }

}
