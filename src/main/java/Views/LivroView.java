package Views;

import Controllers.LivroController;
import Models.Genero;
import Models.Livro;

import java.util.ArrayList;
import java.util.Scanner;

public class LivroView {
    LivroController controller = new LivroController();

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        Livro livro = new Livro();
        System.out.println("Cadatrar Livro");

        System.out.println("Infome o nome do livro: ");
        String nome = scanner.nextLine();

        System.out.println("Infome o id da biblioteca: ");
        Long bibliotecaId = scanner.nextLong();

        System.out.println("Infome o id do genero: ");
        Long generoId = scanner.nextLong();

        Livro novoLivro = controller.cadastrar(nome, bibliotecaId, generoId);
        if (novoLivro != null) {
            System.out.println("Livro " + novoLivro + " cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao realizar cadastro");
        }
    }

    public void encontrarLivro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Encontrar Livro");

        System.out.println("Infome o id do livro: ");
        Long livroId = scanner.nextLong();

        Livro livro = controller.obterLivroPeloId(livroId);
        if (livro != null) {
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado");
        }
    }

    public void listarLivrosBiblioteca() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Listar Livros biblioteca");

        System.out.println("Infome o id da biblioteca: ");
        Long bibliotecaId = scanner.nextLong();

        ArrayList<Livro> livros = controller.listarLivrosBiblioteca(bibliotecaId);
        if (!livros.isEmpty()) {
            System.out.println(livros);
        } else {
            System.out.println("Nenhum livro encontrado!");
        }
    }

    public void listarLivrosGenero() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Listar Livros genero");

        System.out.println("Infome o id do genero: ");
        Long generoId = scanner.nextLong();

        ArrayList<Livro> livros = controller.listarLivrosGenero(generoId);
        if (!livros.isEmpty()) {
            System.out.println(livros);
        } else {
            System.out.println("Nenhum livro encontrado!");
        }
    }
}
