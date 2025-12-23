package br.com.portfolio.desafiomeva.view;

import br.com.portfolio.desafiomeva.model.Celular;
import br.com.portfolio.desafiomeva.model.Perfume;
import br.com.portfolio.desafiomeva.model.Produto;
import br.com.portfolio.desafiomeva.service.Estoque;

import java.util.Scanner;

public class MenuEstoque {

    private final Scanner input;
    private final Estoque estoque;

    public MenuEstoque() {
        this.input = new Scanner(System.in);
        this.estoque = new Estoque();
    }

    public void exibir() {
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("""
                    ---------------------------------
                    |      SISTEMA DE ESTOQUE       |
                    ---------------------------------
                    | 1. Adicionar produto          |
                    | 2. Listar produtos            |
                    | 3. Atualizar estoque          |
                    | 4. Buscar produto             |
                    | 5. Remover produto            |
                    | 6. Sair                       |
                    ---------------------------------
                    """);

            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> estoque.listarProdutos();
                case 3 -> atualizarEstoque();
                case 4 -> buscarProduto();
                case 5 -> removerProduto();
                case 6 -> System.out.println("""
                        ---------------------------------
                        | >>> DESLIGANDO SISTEMA... <<< |
                        ---------------------------------
                        """);
                default -> System.out.println(">>> OPÇÃO INVÁLIDA, TENTE NOVAMENTE! <<<");
            }

            System.out.println("""
                    
                    -------------------------------------------------------------
                    |   Sucesso na operação, pressione ENTER para continuar...  |
                    -------------------------------------------------------------
                    """);
            input.nextLine(); // Limpar o buffer do teclado
        }
    }

    // MÉTODOS DO MENU
    private void adicionarProduto() {

        System.out.println("Tipo de produto:");
        System.out.println("1 - Celular");
        System.out.println("2 - Perfume");
        System.out.print("Escolha: ");
        int tipo = input.nextInt();
        input.nextLine();

        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Código: ");
        String codigo = input.nextLine();

        System.out.print("Preço: ");
        double preco = input.nextDouble();

        System.out.print("Quantidade em estoque: ");
        int quantidade = input.nextInt();
        input.nextLine();

        if (tipo == 1) {
            System.out.print("Modelo: ");
            String modelo = input.nextLine();

            System.out.print("Fabricante: ");
            String fabricante = input.nextLine();

            System.out.print("Armazenamento (GB): ");
            int armazenamento = input.nextInt();

            Produto celular = new Celular(nome, codigo, preco, quantidade, modelo, fabricante, armazenamento);

            estoque.adicionarProduto(celular);

        } else if (tipo == 2) {
            System.out.print("Marca: ");
            String marca = input.nextLine();

            System.out.print("Família olfativa: ");
            String familia = input.nextLine();

            System.out.print("Tamanho (ml): ");
            int tamanho = input.nextInt();

            Produto perfume = new Perfume(nome, codigo, preco, quantidade, marca, familia, tamanho);

            estoque.adicionarProduto(perfume);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        System.out.println("Produto adicionado com sucesso.");
    }

    private void atualizarEstoque() {

        System.out.println("O que deseja cadastrar?");
        System.out.println("1 - Entrada de estoque");
        System.out.println("2 - Saída de estoque");
        System.out.print("Escolha: ");
        int tipo = input.nextInt();
        input.nextLine();

        System.out.print("Código do produto: ");
        String codigo = input.nextLine();

        if (tipo == 1) {
            System.out.print("Quantidade de entrada: ");
        } else {
            System.out.print("Quantidade de saída: ");
        }
        int quantidade = input.nextInt();
        input.nextLine();

        boolean atualizado;
        boolean adicionar;

        adicionar = tipo == 1;
        atualizado = estoque.atualizarQuantidade(codigo, quantidade, adicionar);

        if (atualizado) {
            System.out.println("Estoque atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void buscarProduto() {

        System.out.print("Código do produto: ");
        String codigo = input.nextLine();

        Produto produto = estoque.buscarPorCodigo(codigo);

        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void removerProduto() {

        System.out.print("Código do produto: ");
        String codigo = input.nextLine();

        boolean removido = estoque.removerPorCodigo(codigo);

        if (removido) {
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
