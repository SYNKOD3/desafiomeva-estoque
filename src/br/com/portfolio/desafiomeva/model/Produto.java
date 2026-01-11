package br.com.portfolio.desafiomeva.model;

public abstract class Produto { //modificador "abstract" indica a necessidade de implementação!
    private final String nome; // modificador "final" impede que os valores fixos sejam alterados!
    private final String codigo;
    private final double preco;
    private int quantidadeEstoque;

    public Produto(String nome, String codigo, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Metodo para controle de acesso do estoque (entrada):
    public void entradaEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade de entrada deve ser positiva!");
        }

        this.quantidadeEstoque += quantidade;
    }

    // Metodo para controle de acesso do estoque (saída):
    public void saidaEstoque(int quantidade) {

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade de saída deve ser positiva"); }

        if (quantidade > quantidadeEstoque) {
            throw new IllegalStateException("Estoque insuficiente");
        }

        this.quantidadeEstoque -= quantidade;
    }

    @Override
    public String toString() {
        return "PRODUTO: " + nome + " [Código = " + codigo + " / Preço = R$ " + preco +
                " / Estoque = " + quantidadeEstoque + " unidades]";
    }

    // GETTERS & SETTERS
    public String getCodigo() {
        return codigo;
    }
}
