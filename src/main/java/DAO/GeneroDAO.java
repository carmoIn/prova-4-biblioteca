package DAO;

import Factory.ConnectionFactory;
import Models.Genero;

import java.sql.*;

public class GeneroDAO {
    Connection connection = new ConnectionFactory().getConnection();

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS generos (" +
                "genero_id BIGSERIAL PRIMARY KEY, " +
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

    public Genero cadastrar(Genero genero) {
        String sql = "INSERT INTO generos (nome) VALUES (?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, genero.getNome());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                genero.setId(resultSet.getLong("genero_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genero;
    }

    public Genero editar(Genero genero) {
        String sql = "UPDATE generos SET nome = ? WHERE genero_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, genero.getNome());
            statement.setLong(2, genero.getId());
            statement.execute();

            return genero;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Genero obterGeneroPeloId(Long generoId) {
        Genero genero = null;

        String sql = "SELECT * FROM generos WHERE genero_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, generoId);

            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                genero = new Genero();
                genero.setId(resultSet.getLong("genero_id"));
                genero.setNome(resultSet.getString("nome"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genero;
    }
}
