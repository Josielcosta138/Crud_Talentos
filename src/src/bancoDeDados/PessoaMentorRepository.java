package bancoDeDados;

import model.Contato;
import model.EnumEstado;
import model.PessoaMentor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaMentorRepository {

    //ConexaoComBanco
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/crudtalentos";
        Connection connection = DriverManager.getConnection(url, "root", "1234");

        return connection;

    }

    public void insere(PessoaMentor pessoaMentor) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();


        PreparedStatement stmt1 = connection.prepareStatement("INSERT INTO pessoamentor VALUES (?, ?, ?, ?, ?, ?, ?)");
        stmt1.setLong(1, pessoaMentor.getId());
        stmt1.setString(2, pessoaMentor.getNome());
        stmt1.setString(3, pessoaMentor.getEnumSexo().toString());
        stmt1.setInt(4, pessoaMentor.getIdade());
        stmt1.setString(5, pessoaMentor.getHistorioDeMentorias());
        stmt1.setString(6, pessoaMentor.getCidade());
        stmt1.setString(7, pessoaMentor.getEnumtipoAreaAtuacao().getDescricao());

        stmt1.executeUpdate();

        PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO contato  VALUES (?, ?, ?, ?)");
        stmt2.setLong(1, Contato.getId());
        stmt2.setString(2, Contato.getEnumContato().toString());
        stmt2.setString(3, Contato.getDescricaoContato());
        stmt2.setLong(4, Contato.getIdd());


        stmt2.executeUpdate();

        connection.close();
    }
}




