package bancoDeDados;

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
        PreparedStatement stmt = connection.prepareStatement("insert into pessoamentor values (?, ?, ?)");
        stmt.setLong(  1, pessoaMentor.getId());
        stmt.setString(2, pessoaMentor.getNome());
        stmt.setString(3, pessoaMentor.getEnumSexo().toString());
        int i = stmt.executeUpdate();
        connection.close();
    }
}



