package Controllers;

import DAO.LivroDAO;
import Models.Biblioteca;
import Models.Genero;
import Models.Livro;

import java.util.ArrayList;

public class LivroController {
    private final LivroDAO dao = new LivroDAO();

    public Livro cadastrar(Livro livro) {
        if (livro != null) {
            return dao.cadastrar(livro);
        }
        return null;
    }

    public Livro cadastrar(String nome, Long bibliotecaId, Long generoId) {
        if (generoId != null &&
                nome != null &&
            bibliotecaId != null) {
            GeneroController generoController = new GeneroController();
            BibliotecaController bibliotecaController = new BibliotecaController();

            Biblioteca biblioteca = bibliotecaController.obterBibliotecaPeloId(bibliotecaId);
            Genero genero = generoController.obterGeneroPeloId(generoId);
            if (genero != null && biblioteca != null) {
                Livro livro = new Livro();
                livro.setNome(nome);
                livro.setBiblioteca(biblioteca);
                livro.setGenero(genero);
                return dao.cadastrar(livro);
            }
        }
        return null;
    }

    public Livro obterLivroPeloId(Long livroId) {
        return dao.obterLivroPeloId(livroId);
    }

    public ArrayList<Livro> listarLivrosBiblioteca(Long bibliteocaId) {
        return dao.listarLivrosBiblioteca(bibliteocaId);
    }

    public ArrayList<Livro> listarLivrosGenero(Long generoId) {
        return dao.listarLivrosGenero(generoId);
    }
}
