package Controllers;

import DAO.BibliotecaDAO;
import Models.Biblioteca;
import Models.Livro;

public class BibliotecaController {
    private final BibliotecaDAO dao = new BibliotecaDAO();

    public Biblioteca cadastrar(Biblioteca biblioteca) {
        if (biblioteca != null) {
            return dao.cadastrar(biblioteca);
        }
        return null;
    }

    public Biblioteca obterBibliotecaPeloId(Long bibliotecaId) {
        return dao.obterBibliotecaPeloId(bibliotecaId);
    }
}
