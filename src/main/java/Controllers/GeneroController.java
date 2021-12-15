package Controllers;

import DAO.GeneroDAO;
import Models.Genero;

public class GeneroController {
    private final GeneroDAO dao = new GeneroDAO();

    public Genero cadastrar(Genero genero) {
        if (genero != null) {
            return dao.cadastrar(genero);
        }
        return null;
    }

    public Genero editar(Genero genero) {
        if (genero != null) {
            return dao.editar(genero);
        }
        return null;
    }

    public Genero obterGeneroPeloId(Long generoId) {
        return dao.obterGeneroPeloId(generoId);
    }
}
