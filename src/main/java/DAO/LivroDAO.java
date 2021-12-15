package DAO;

import Factory.ConnectionFactory;
import Models.Genero;
import Models.Livro;

import java.sql.*;
import java.util.ArrayList;

public class LivroDAO {
    Connection connection = new ConnectionFactory().getConnection();

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                "livro_id BIGSERIAL PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL, " +
                "biblioteca_id BIGINT, " +
                "genero_id BIGINT, " +
                "foreign key(genero_id) " +
                "references generos(genero_id), " +
                "foreign key(biblioteca_id)" +
                "references bibliotecas(biblioteca_id)" +
                ");";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Livro cadastrar(Livro livro) {
        String sql = "INSERT INTO livros (nome, biblioteca_id, genero_id) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, livro.getNome());
            statement.setLong(2, livro.getBiblioteca().getId());
            statement.setLong(3, livro.getGenero().getId());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                livro.setId(resultSet.getLong("livro_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return livro;
    }

    public Livro obterLivroPeloId(Long livroId) {
        Livro livro = null;

        String sql = "SELECT * FROM livros WHERE livro_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, livroId);

            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                livro = new Livro();
                livro.setId(resultSet.getLong("livro_id"));
                livro.setNome(resultSet.getString("nome"));

                GeneroDAO generoDAO = new GeneroDAO();
                Genero genero = generoDAO.obterGeneroPeloId(resultSet.getLong("genero_id"));

                livro.setGenero(genero);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return livro;
    }

    public ArrayList<Livro> listarLivrosBiblioteca(Long bibliotecaId) {
        ArrayList<Livro> livros = new ArrayList<>();

        String sql = "SELECT * FROM livros WHERE biblioteca_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, bibliotecaId);

            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getLong("livro_id"));
                livro.setNome(resultSet.getString("nome"));

                GeneroDAO generoDAO = new GeneroDAO();
                Genero genero = generoDAO.obterGeneroPeloId(resultSet.getLong("genero_id"));

                livro.setGenero(genero);

                livros.add(livro);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return livros;
    }

    public ArrayList<Livro> listarLivrosGenero(Long generoId) {
        ArrayList<Livro> livros = new ArrayList<>();

        String sql = "SELECT * FROM livros WHERE genero_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, generoId);

            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getLong("livro_id"));
                livro.setNome(resultSet.getString("nome"));

                GeneroDAO generoDAO = new GeneroDAO();
                Genero genero = generoDAO.obterGeneroPeloId(resultSet.getLong("genero_id"));

                livro.setGenero(genero);

                livros.add(livro);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return livros;
    }
}
