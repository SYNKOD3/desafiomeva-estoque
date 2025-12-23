package br.com.portfolio.desafiomeva.model;

public class Perfume extends Produto {
    private final String marca;
    private final String familiaOlfativa;
    private final int tamanho;

    public Perfume(String nome, String codigo, double preco, int quantidadeEstoque, String marca, String familiaOlfativa, int tamanho) {
        super(nome, codigo, preco, quantidadeEstoque);
        this.marca = marca;
        this.familiaOlfativa = familiaOlfativa;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTIPO: Perfume [Marca = " + marca + " / Família Olfativa = " +
                familiaOlfativa + " / Tamanho = " + tamanho + " ml]\n" +
                "----------------------------------------------------------------------------------------------";
    }
}
