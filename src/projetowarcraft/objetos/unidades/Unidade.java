package projetowarcraft.objetos.unidades;

import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.Objeto;
import projetowarcraft.racas.Raca;

public class Unidade extends Objeto {

    private double velocidade;
    private int armadura;

    public Unidade(String imagem, Custo custo, boolean estado, int hp,
            int pontosAtaque, double alcance, Raca raca, Posicao posicao,
            double velocidade, int armadura) {
        super(imagem, custo, estado, hp, pontosAtaque, alcance, raca, posicao);
        this.velocidade = velocidade;
        this.armadura = armadura;
    }

    public void mover(String direcao) {

        if (estado) {
            switch (direcao.toLowerCase()) {
                case "norte":
                    posicao.moverParaNorte(velocidade);
                case "sul":
                    posicao.moverParaSul(velocidade);
                case "leste":
                    posicao.moverParaLeste(velocidade);
                case "oeste":
                    posicao.moverParaOeste(velocidade);
                default:
                    System.out.println("Verifica a opção informada.");
            }
        } else {
            System.out.println("Você está tentando mover algo que está morto.");
        }

    }

}
