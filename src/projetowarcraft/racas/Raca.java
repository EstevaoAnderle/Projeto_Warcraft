package projetowarcraft.racas;

import java.util.ArrayList;
import projetowarcraft.mapa.Posicao;
import projetowarcraft.objetos.Custo;
import projetowarcraft.objetos.construcoes.Casa;
import projetowarcraft.objetos.construcoes.Centro;
import projetowarcraft.objetos.construcoes.Construcao;
import projetowarcraft.objetos.unidades.Campones;
import projetowarcraft.objetos.unidades.Unidade;

public class Raca {

    private int comida;
    private int madeira;
    private int mana;
    private int ouro;
    private ArrayList<Unidade> unidades = new ArrayList<>();
    private ArrayList<Construcao> construcoes = new ArrayList<>();
    private boolean extinta = false;
    private char tipo;//H - Humano; O - Orc
    private int populacao;
    private int capacidadePopulacional;

    public Raca(char tipo, Posicao posicao, int comida, int madeira, int ouro, int mana) {
        this.tipo = tipo;
        construcoes.add(new Centro(this, posicao));
        unidades.add(new Campones(this, posicao));
        unidades.add(new Campones(this, posicao));
        unidades.add(new Campones(this, posicao));
        unidades.add(new Campones(this, posicao));
        unidades.add(new Campones(this, posicao));
        this.adicionarSuprimentos(comida, madeira, ouro, mana);
        this.calculaCapacidadePopulacional();
    }

    public ArrayList<Unidade> getUnidades() {
        return unidades;
    }

    public ArrayList<Construcao> getConstrucoes() {
        return construcoes;
    }

    public void adicionarUnidade(Unidade unidade) {
        unidades.add(unidade);
        this.populacao += 1;
        this.diminuirSuprimentos(unidade.getCusto());
    }
    
    public void reviverUnidade(Unidade unidade) {
    	unidades.add(unidade);
        this.populacao += 1;
    }
    
    public void removerUnidade(Unidade unidade) {
		unidades.remove(unidade);
		this.populacao -= 1;
		this.verificaExtinta();
    }

    public void adicionarConstrucao(Construcao construcao) {
        construcoes.add(construcao);
        this.diminuirSuprimentos(construcao.getCusto());
        this.calculaCapacidadePopulacional();
    }
    
    public void removerConstrucao(Construcao construcao) {
    	construcoes.remove(construcao);
    	this.calculaCapacidadePopulacional();
    	this.verificaExtinta();
    }
    
    public void verificaExtinta() {
    	if(construcoes.size() == 0 && populacao == 0) {
    		this.extinguirRaca();
    	}
    }
    
    private void extinguirRaca() {
    	this.extinta = true;
    	String raca;
    	if(this.tipo == 'H')
    		raca = "humana";
    	else
    		raca = "orc";
    	System.out.println("A raça " + raca + " foi extinta!");
    }

    private void calculaCapacidadePopulacional() {
    	int capacidade = 0;
        for (Construcao construcao : construcoes) {
            if (construcao.getEstado()) {
                if (construcao instanceof Casa) {
                	capacidade = capacidade + 2;
                } else if (construcao instanceof Centro) {
                	capacidade = capacidade + 10;
                }
            }
        }
        this.capacidadePopulacional = capacidade;
    }

    public boolean podeCriar(Unidade unidade) {
    	if(this.getExtinta()) {
    		System.out.println("Esta raca esta extinta e nao pode criar unidades.");
    		return false;
    	}
        if(populacao >= capacidadePopulacional) {
        	System.out.println("A quantidade maxima da populacao foi atingida.");
        	return false;
        }
        if (!this.calculaSuprimentos(unidade.getCusto())) {
			System.out.println("Recursos nao sao suficientes!");
			return false;
		}
        return true;
    }
    
    public boolean podeConstruir(Construcao construcao) {
    	if(this.getExtinta()) {
    		System.out.println("Esta raca esta extinta e nao pode construir.");
    		return false;
    	}
    	if (!this.calculaSuprimentos(construcao.getCusto())) {
			System.out.println("Recursos nao sao suficientes!");
			return false;
		}
    	return true;
    }
    
    /**
     * Adiciona suprimentos.
     *
     * @param comida
     * @param madeira
     * @param ouro
     * @param mana
     */
    public void adicionarSuprimentos(int comida, int madeira, int ouro, int mana) {
        this.comida += comida;
        this.madeira += madeira;
        this.ouro += ouro;
        this.mana += mana;
    }

    /**
     * Diminui os suprimentos da raça com base no custo
     * do objeto criado.
     *
     * @param Custo
     */
    public void diminuirSuprimentos(Custo custo) {
        this.comida -= custo.getComida();
        this.madeira -= custo.getMadeira();
        this.ouro -= custo.getOuro();
        this.mana -= custo.getMana();
    }

    /**
     * Diminui suprimentos, podendo informar quais.
     *
     * @param comida
     * @param madeira
     * @param ouro
     * @param mana
     */
    public void diminuirSuprimentosEspecificos(int comida, int madeira, int ouro, int mana) {
    	this.comida -= comida;
        this.madeira -= madeira;
        this.ouro -= ouro;
        this.mana -= mana;
    }
    
    public boolean calculaSuprimentos(Custo custo) {
        if (this.comida >= custo.getComida() && this.madeira >= custo.getMadeira()
                && this.ouro >= custo.getOuro() && this.mana >= custo.getMana()) {
            return true;
        }
        return false;
    }
    

    public Unidade getUnidade(int posicao) {
        return unidades.get(posicao);
    }

    public Construcao getConstrucao(int posicao) {
        return construcoes.get(posicao);
    }
    
    /**
     * @return the comida
     */
    public int getComida() {
        return comida;
    }

    /**
     * @return the madeira
     */
    public int getMadeira() {
        return madeira;
    }

    /**
     * @return the mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * @return the ouro
     */
    public int getOuro() {
        return ouro;
    }
    
    public char getTipo() {
    	return tipo;
    }

    public boolean getExtinta() {
    	return this.extinta;
    }
    
    public void relatorio() {
    	System.out.println("###################");
    	for(Unidade unidade : unidades) {
    		System.out.println(unidade);
    	}
    	for(Construcao construcao : construcoes) {
    		System.out.println(construcao);
    	}
    	System.out.println("###################");
    }
    
    public void status() {
    	System.out.println("##########################");
    	System.out.println("STATUS DE RAÇA (" + this.tipo + ")");
    	System.out.println("População: " + populacao + "/" + capacidadePopulacional);
    	System.out.println("Construções: " + construcoes.size());
        System.out.println("Comida: " + getComida());
        System.out.println("Madeira: " + getMadeira());
        System.out.println("Ouro: " + getOuro());
        System.out.println("Mana: " + getMana());
        System.out.println("##########################");
    }
}
