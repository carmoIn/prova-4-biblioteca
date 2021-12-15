import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import DAO.LivroDAO;
import Views.MenuView;

import java.awt.*;

public class Main {

    public static void initDatabase() {
        new BibliotecaDAO().criarTabela();
        new GeneroDAO().criarTabela();
        new LivroDAO().criarTabela();
    }

    public static void startApplication() {
        initDatabase();
        new MenuView().exibirMenu();
    }

    public static void main(String[] args) {
        startApplication();
    }
}
