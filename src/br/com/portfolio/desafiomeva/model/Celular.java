package br.com.portfolio.desafiomeva.model;

public class Celular extends Produto {
    private final String modelo;
    private final String fabricante;
    private final int armazenamento;

    public Celular(String nome, String codigo, double preco, int quantidadeEstoque, String modelo, String fabricante, int armazenamento) {
        super(nome, codigo, preco, quantidadeEstoque);
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.armazenamento = armazenamento;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTIPO: Celular [Modelo = " + modelo + " / Fabricante = " +
                fabricante + " / Armazenamento = " + armazenamento + " Gb]\n" +
                "----------------------------------------------------------------------------------------------";
    }
}
