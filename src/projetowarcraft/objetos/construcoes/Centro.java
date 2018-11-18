package projetowarcraft.objetos.construcoes;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Ataque;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.unidades.Campones;
import projetowarcraft.objetos.unidades.Unidade;
import projetowarcraft.racas.Raca;

public class Centro extends Construcao implements Ataque {

    public Centro(Posicao posicao, Raca raca) {
        super("ImagemCentro.jpg", new Custo(0, 200, 0, 0), true, 600, 10, 8, raca, posicao);
    }

    void cria() {
        if (estado) {
            Campones campones = new Campones(raca, posicao);
            if (raca.getCusto().compararCustos(campones.getCusto())) {
                if (raca.podeCriar()) {
                    raca.adicionarUnidade(new Campones(raca, new Posicao(x, y)));
                    System.out.println("Camponês criado.");
                } else {
                    System.out.println("A quantidade máxima da população foi atingida.");
                }
                raca.getCusto().diminuirSuprimentosTotais(campones.getCusto());
            } else {
                System.out.println("Recursos não são suficientes!");
            }
        } else {
            System.out.println("Essa construção já está destruída.");
        }
    }

}
