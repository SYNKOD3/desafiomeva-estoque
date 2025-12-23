package br.com.portfolio.desafiomeva.service;

import br.com.portfolio.desafiomeva.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private final List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Função para adicionar produtos:
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Função para listar produtos:
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
            return;
        }

        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
    }

    // Buscar um produto específico (por código)
    public Produto buscarPorCodigo(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    // Função para remover produtos:
    public boolean removerPorCodigo(String codigo) {

        Produto produto = buscarPorCodigo(codigo);

        if (produto != null) {
            produtos.remove(produto);
            return true;
        }

        return false;
    }

    // Função para atualizar a quantidade de um produto específico (por código):
    public boolean atualizarQuantidade(String codigo, int novaQuantidade, boolean adicionar) {

        Produto produto = buscarPorCodigo(codigo);

        if (produto != null && adicionar) {
            produto.entradaEstoque(novaQuantidade);
            return true;
        }
        if (produto != null) {
            produto.saidaEstoque(novaQuantidade);
            return true;
        }

        return false;
    }
}