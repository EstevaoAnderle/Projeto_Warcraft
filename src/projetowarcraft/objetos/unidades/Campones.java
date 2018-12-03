package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.construcoes.*;
import projetowarcraft.racas.Raca;

public class Campones extends Unidade {

    public Campones(Raca raca, Posicao posicao) {
        super("ImagemCampones.jpg", new Custo(50, 0, 0, 0), true, 50, 3, 0, raca, posicao, 2.0, 0);
    }

    public void constroi(Posicao posicao, String tipo) {
    	Construcao construcao;
    	if(tipo == "casa") {
    		construcao = new Casa(raca, posicao);
    	}else if(tipo == "centro") {
    		construcao = new Centro(raca, posicao);
    	}else if(tipo == "templo") {
			construcao = new Templo(raca, posicao);
    	}else if(tipo == "quartel") {
			construcao = new Quartel(raca, posicao);
    	}else if(tipo == "torre") {
			construcao = new Torre(raca, posicao);
    	}else {
    		System.out.println("Construcao invalida!");
    		return;
    	}
    	
		if(!raca.podeConstruir(construcao))
    		return;
    	if (!estado) {
    		System.out.println("Este campones ja esta morto.");
    		return;
    	}
    	
    	raca.adicionarConstrucao(construcao);
        System.out.println("Construcao do tipo " + tipo + " criada.");
    }

    public void colhe() {
		if(estado)
			raca.adicionarSuprimentos(1, 0, 0, 0);
		else
			System.out.println("Este campones ja esta morto.");
    }

    public void corte() {
    	if(estado)
			raca.adicionarSuprimentos(0, 1, 0, 0);
		else
			System.out.println("Este campones ja esta morto.");
    }

    public void minera() {
    	if(estado)
			raca.adicionarSuprimentos(0, 0, 1, 0);
		else
			System.out.println("Este campones ja esta morto.");
    }

}
