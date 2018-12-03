package projetowarcraft;

import projetowarcraft.racas.*;
import projetowarcraft.mapa.*;
import projetowarcraft.objetos.*;
import projetowarcraft.objetos.construcoes.*;
import projetowarcraft.objetos.unidades.*;

/**
 * Classe principal do projeto. Inicializar o jogo artaves desta.
 * @author Estevao Anderle, Rafael de Paula
 */
public class ProjetoWarcraft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Raca humanos = new Raca('H', Mapa.getPosicao(0, 0), 500, 500, 500, 15);
        Centro centroHumanos = (Centro) humanos.getConstrucao(0);
        centroHumanos.criaCampones();
        
        Campones campones1 = (Campones) humanos.getUnidade(0);
        campones1.constroi(Mapa.getPosicao(1,0), "torre");
        Torre torre = (Torre) humanos.getConstrucoes().get(humanos.getConstrucoes().size() - 1);
        campones1.constroi(Mapa.getPosicao(0, 1), "quartel");
        Quartel quartel = (Quartel) humanos.getConstrucoes().get(humanos.getConstrucoes().size() - 1);
        campones1.mover("leste");
        
        quartel.criaGrifo();
        Grifo grifo = (Grifo) humanos.getUnidades().get(humanos.getUnidades().size() - 1);
        
        /* ############################# */
        
        Raca orcs = new Raca('O', Mapa.getPosicao(3, 0), 50, 50, 50, 15);
        Campones campones2 = (Campones) orcs.getUnidade(0);
        
        campones1.atacar(campones2);
        torre.atacar(campones2);
        grifo.atacar(campones2);
        
        orcs.relatorio();
    }
    
}