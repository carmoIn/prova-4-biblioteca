package Views;

import Models.Genero;
import Utils.ViewUtils;

import java.util.Scanner;

public class MenuView {
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-Menu Principal-");
            System.out.println("1 - CADASTRAR BIBLIOTECA");
            System.out.println("2 - CADASTRAR GENERO");
            System.out.println("3 - EDITAR GENERO");
            System.out.println("4 - CADASTRAR LIVRO");
            System.out.println("5 - ENCONTRAR LIVRO PELO ID");
            System.out.println("6 - LISTAS LIVROS DA BIBILIOTECA");
            System.out.println("7 - LISTAR LIVROS POR GENERO");
            System.out.println("0 - SAIR");

            int choice = ViewUtils.selecionarOpcao(scanner);
            switch (choice) {
                case 0 -> System.exit(0);
                case 1 -> cadastrarBiblioteca();
                case 2 -> cadastrarGenero();
                case 3 -> editarGenero();
                case 4 -> cadastrarLivro();
                case 5 -> encontrarLivro();
                case 6 -> listarLivrosBiblioteca();
                case 7 -> listarLivrosGenero();
                default -> System.out.println("Escolha invalida! Tente novamente.");
            }
        }
    }

    public void cadastrarBiblioteca() {
        BibliotecaView view = new BibliotecaView();
        view.cadastrar();
    }

    public void cadastrarGenero() {
        GeneroView view = new GeneroView();
        view.cadastrar();
    }

    public void editarGenero() {
        GeneroView view = new GeneroView();
        view.editar();
    }

    public void cadastrarLivro() {
        LivroView view = new LivroView();
        view.cadastrar();
    }

    public void encontrarLivro() {
        LivroView view = new LivroView();
        view.encontrarLivro();
    }

    public void listarLivrosBiblioteca() {
        LivroView view = new LivroView();
        view.listarLivrosBiblioteca();
    }

    public void listarLivrosGenero() {
        LivroView view = new LivroView();
        view.listarLivrosGenero();
    }
}
