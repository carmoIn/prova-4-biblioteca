package DAO;

import Factory.ConnectionFactory;
import Models.Biblioteca;
import Models.Genero;

import java.sql.*;

public class BibliotecaDAO {

    Connection connection = new ConnectionFactory().getConnection();

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS bibliotecas (" +
                "biblioteca_id BIGSERIAL PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL" +
                ");";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Biblioteca cadastrar(Biblioteca biblioteca) {
        Biblioteca resultado = null;

        String sql = "INSERT INTO bibliotecas (nome) VALUES (?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, biblioteca.getNome());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                resultado = new Biblioteca();
                resultado.setId(resultSet.getLong("biblioteca_id"));
                resultado.setNome(resultSet.getString("nome"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultado;
    }

    public Biblioteca obterBibliotecaPeloId(Long bibliotecaId) {
        Biblioteca biblioteca = null;

        String sql = "SELECT * FROM bibliotecas WHERE biblioteca_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, bibliotecaId);

            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                biblioteca = new Biblioteca();
                biblioteca.setId(resultSet.getLong("biblioteca_id"));
                biblioteca.setNome(resultSet.getString("nome"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return biblioteca;
    }
}
